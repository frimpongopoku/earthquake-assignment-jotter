package com.example.earthquakeassignmentjotter;

import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetExplorer extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] objects) {
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL("http://quakes.bgs.ac.uk/feeds/WorldSeismology.xml");
            urlConnection = (HttpURLConnection) url.openConnection();

            int code = urlConnection.getResponseCode();
            if (code !=  200) {
                throw new IOException("Invalid response from server: " + code);
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;

            final StringBuilder sb = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                sb.append(line).append("\n");
            }
            Log.d("PRINTING", sb.toString());

//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = factory.newPullParser();
//            parser.setInput( urlConnection.getInputStream(),"UTF-8");
//            int eventType = parser.getEventType();
//            Log.d("PRINTING", String.valueOf(eventType));
//            while(eventType != XmlPullParser.END_DOCUMENT){
//                if(eventType == XmlPullParser.START_TAG){
//                    if(parser.getName().equals("title")){
//                        Log.d("PRINTING", parser.nextText());
//                    }else if(parser.getName().equals("description")){
//                        Log.d("PRINTING", parser.nextText());
//                    }else if(parser.getName().equals("link")){
//                        Log.d("PRINTING", parser.nextText());
//                    }else if(parser.getName().equals("pubDate")){
//                        Log.d("PRINTING", parser.nextText());
//                    }else if(parser.getName().equals("category")){
//                        Log.d("PRINTING", parser.nextText());
//                    }else if(parser.getName().equals("geo:lat")){
//                        Log.d("PRINTING", parser.nextText());
//                    }else if(parser.getName().equals("geo:long")){
//                        Log.d("PRINTING", parser.nextText());
//                    }
//
//                }
//                eventType = parser.next();
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }

}
