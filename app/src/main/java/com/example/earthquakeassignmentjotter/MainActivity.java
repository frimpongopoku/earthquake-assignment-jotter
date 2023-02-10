package com.example.earthquakeassignmentjotter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.TextLinks;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity{

    CustomXMLHandler xmlHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InternetExplorer task = (InternetExplorer) new InternetExplorer().execute();
        task.onComplete = new AfterEffect() {
            @Override
            public void sendResponse(String response) {
                xmlHandler = new CustomXMLHandler(response);
//                Log.d("PRINTING AGAIN","YOU KNOW, THIS IS WHERE THE THING ACTUALLY HAPPENS");
//                Log.d("PRINTING AGAIN",response);
            }
        };




//        URL url = null;
//        try {
//            url = new URL("http://quakes.bgs.ac.uk/feeds/WorldSeismology.xml");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        HttpURLConnection urlConnection = null;
//        try {
//          urlConnection = (HttpURLConnection) url.openConnection();
//          InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = factory.newPullParser();
//            parser.setInput( in,"UTF-8");
//
////            readStream(in);
//
//        } catch (IOException | XmlPullParserException e) {
//            throw new RuntimeException(e);
//
//        } finally {
//            urlConnection.disconnect();
//        }


//        String XML = "<item>\n" +
//                "<title>World Earthquake alert : M 7.5 :SOUTHERN TURKEY, Mon, 06 Feb 2023 10:24:48</title>\n" +
//                "<description>Origin date/time: Mon, 06 Feb 2023 10:24:48 ; Location: SOUTHERN TURKEY ; Lat/long: 38.024,37.203 ; Depth: 10 km ; Magnitude: 7.5</description>\n" +
//                "<link>http://earthquakes.bgs.ac.uk/earthquakes/recent_events/20230206102900.html</link>\n" +
//                "<pubDate>Mon, 06 Feb 2023 10:24:48</pubDate>\n" +
//                "<category>EQMH</category>\n" +
//                "<geo:lat>38.024</geo:lat>\n" +
//                "<geo:long>37.203</geo:long>\n" +
//                "</item>";
//
//        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = factory.newPullParser();
//            parser.setInput( new StringReader(XML));
//            int eventType = parser.getEventType();
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
//        } catch (XmlPullParserException | IOException e) {
//            throw new RuntimeException(e);
//        }


    }
}