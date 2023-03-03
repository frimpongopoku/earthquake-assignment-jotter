package com.example.earthquakeassignmentjotter;

import java.util.ArrayList;

public class EarthquakeChannel {
    private String description;
    private String link;
    private String title;
    private String language;
    private String buildDate;
    private ArrayList<EarthquakeItem> items = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public void addItem(EarthquakeItem item){
        this.items.add(item);
    }
    public ArrayList<EarthquakeItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<EarthquakeItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String items ="";

        for(int i = 0; i < items.length(); i++){
            EarthquakeItem itm = this.items.get(i);
            if(i != 0) items +="\n-------------------------------\n";
            items +=itm.toString();
        }

        return items;
    }
}
