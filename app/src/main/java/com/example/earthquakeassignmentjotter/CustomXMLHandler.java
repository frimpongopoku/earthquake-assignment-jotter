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
    private String TAG = "PRINTING";
    public CustomXMLHandler(String xmlString){
        this.xmlString = xmlString;
        this.process();
    }

    public void process () {
        if( this.xmlString == null) {
            Log.d(TAG,"XML String is Empty....");
            return;
        }
//        Log.d(TAG,xmlString);


        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput( new StringReader(this.xmlString));


            int eventType = parser.getEventType();
            // Traverse through the XML document
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && parser.getName().equalsIgnoreCase("item")) {
                    String title = "";
                    String description = "";
                    String pubDate = "";
                    String link = "";

                    while (eventType != XmlPullParser.END_TAG || !parser.getName().equalsIgnoreCase("item")) {
                        if (eventType == XmlPullParser.START_TAG) {
                            switch (parser.getName().toLowerCase()) {
                                case "title":
                                    title = parser.nextText();
                                    break;
                                case "description":
                                    description = parser.nextText();
                                    break;
                                case "pubdate":
                                    pubDate = parser.nextText();
                                    break;
                                case "link":
                                    link = parser.nextText();
                                    break;
                                default:
                                    break;
                            }
                        }
                        eventType = parser.next();
                    }

                    System.out.println("Title: " + title);
                    System.out.println("Description: " + description);
                    System.out.println("PubDate: " + pubDate);
                    System.out.println("Link: " + link);
                    System.out.println("----------------------------");
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
//            throw new RuntimeException(e);
            Log.d("PRINTING ERROR HERE", e.toString());
        }
    }

}
