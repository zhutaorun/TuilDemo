package com.zhutaorun.tulingdemo;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by zhutaorun on 15/8/14.
 */
public class HttpData extends AsyncTask<String,Void,String> {

    private HttpClient mHttpClient;
    private HttpGet mHttpGet;
    private HttpResponse mHttpResponse;
    private HttpEntity mHttpEntity;
    private InputStream in;
    private HttpGetDataListener listener;

    private String url;
    public HttpData(String url,HttpGetDataListener listener){
        this.url = url;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        Log.e("zhutao","url="+url);
        try {
            mHttpClient = new DefaultHttpClient();
            mHttpGet =new HttpGet(url);
            mHttpResponse = mHttpClient.execute(mHttpGet);
            mHttpEntity = mHttpResponse.getEntity();
            in = mHttpEntity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            Log.e("zhutao","br ="+br );
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line =br.readLine())!= null){
                sb.append(line);
            }
            Log.e("zhutao","sb" +sb.toString());
            return sb.toString();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if(s !=null) {
            listener.getDataUrl(s);
            super.onPostExecute(s);
        }else{
            Log.e("zhutao"," s is null");
        }
    }
}
