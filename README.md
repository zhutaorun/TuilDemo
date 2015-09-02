# TuilDemo 实现了智能回复功能，以及文字交流为主
question mark

1.<uses-permission android:name="ANDROID.PERMISSION.INTERNET"/>  is error,can't get internet permisson

<uses-permission android:name="android.permission.INTERNET"/>
2.android:gravity="center_vertical|left"; Text aligin left and vertical

3.http://www.tuling123.com/openapi/

4. old method of Http get
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
