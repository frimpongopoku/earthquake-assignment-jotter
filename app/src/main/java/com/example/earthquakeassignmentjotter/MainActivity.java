package com.example.earthquakeassignmentjotter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String XML = "<item>\n" +
                "<title>World Earthquake alert : M 7.5 :SOUTHERN TURKEY, Mon, 06 Feb 2023 10:24:48</title>\n" +
                "<description>Origin date/time: Mon, 06 Feb 2023 10:24:48 ; Location: SOUTHERN TURKEY ; Lat/long: 38.024,37.203 ; Depth: 10 km ; Magnitude: 7.5</description>\n" +
                "<link>http://earthquakes.bgs.ac.uk/earthquakes/recent_events/20230206102900.html</link>\n" +
                "<pubDate>Mon, 06 Feb 2023 10:24:48</pubDate>\n" +
                "<category>EQMH</category>\n" +
                "<geo:lat>38.024</geo:lat>\n" +
                "<geo:long>37.203</geo:long>\n" +
                "</item>";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput( new StringReader(XML));
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    if(parser.getName().equals("title")){
                        Log.d("PRINTING", parser.nextText());
                    }else if(parser.getName().equals("description")){
                        Log.d("PRINTING", parser.nextText());
                    }else if(parser.getName().equals("link")){
                        Log.d("PRINTING", parser.nextText());
                    }else if(parser.getName().equals("pubDate")){
                        Log.d("PRINTING", parser.nextText());
                    }else if(parser.getName().equals("category")){
                        Log.d("PRINTING", parser.nextText());
                    }else if(parser.getName().equals("geo:lat")){
                        Log.d("PRINTING", parser.nextText());
                    }else if(parser.getName().equals("geo:long")){
                        Log.d("PRINTING", parser.nextText());
                    }

                }
                eventType = parser.next();

            }
        } catch (XmlPullParserException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}