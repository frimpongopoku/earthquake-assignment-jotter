package com.example.earthquakeassignmentjotter;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class CustomXMLHandler {
    private String xmlString;
    private EarthquakeChannel channel = new EarthquakeChannel();

    public CustomXMLHandler(String xmlString){
        this.xmlString = xmlString;
        this.process();
    }

    public void process () {
        XmlPullParserFactory factory = null;
        try {
            int tracker = 0 ;
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput( new StringReader(this.xmlString));
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    String name = parser.getName();
                    String value = parser.nextText();
                    EarthquakeItem earth = new EarthquakeItem();
                    switch (name){
                        case "item":
                            earth = new EarthquakeItem();
                        case "title":
                            if(tracker == 0) channel.setTitle(value);
                            else earth.setTitle(value);
                        case "link":
                            if(tracker == 0) channel.setLink(value);
                        case "description":
                            if(tracker == 0) channel.setDescription(value);
                            else earth.setDescription(value);
                        case "language":
                            if(tracker == 0) channel.setLanguage(value);
                        case "lastBuildDate":
                            if(tracker == 0) channel.setBuildDate(value);
                        case "pubDate":
                            earth.setPubDate(value);
                        case "category":
                            earth.setCategory(value);
                        case "geo:lat":
                            earth.setLatitude(Double.valueOf(value));
                        case "geo:long":
                            earth.setLongitude(Double.valueOf(value));
                    }

                    if(eventType == XmlPullParser.END_TAG){
                        if (name.equals("lastBuildDate")) tracker+=1;
                        else if (name.equals("item")) channel.addItem(earth);
                    }


                    Log.d("PRINTING", String.valueOf(eventType));
                    Log.d("PRINTING", name);





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

                }
                eventType = parser.next();

            }
        } catch (XmlPullParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
