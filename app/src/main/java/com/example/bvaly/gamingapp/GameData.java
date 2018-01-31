package com.example.bvaly.gamingapp;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by bvaly on 1/17/2018.
 */

public class GameData {
private int id;
private String name;
private String url;
private String summary;
private int collection;
private int franchise;
private JSONArray franchises;
private int hypes;
private double popularity;
private JSONArray games;
private JSONArray tags;
private JSONArray developers;
private JSONArray publishers;
private int category;
private JSONArray gameModes;
private JSONArray keywords;
private JSONArray themes;
private long firstReleaseDate;
private int pulseCount;
private JSONArray platforms;
private JSONArray releaseDates;
private JSONArray screenshots;
private JSONArray videos;
private JSONObject coverURL;
private JSONObject esrbRating;
private JSONArray websites;
private JSONArray multiplayerModes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getFranchise() {
        return franchise;
    }

    public void setFranchise(int franchise) {
        this.franchise = franchise;
    }

    public JSONArray getFranchises() {
        return franchises;
    }

    public void setFranchises(JSONArray franchises) {
        this.franchises = franchises;
    }

    public int getHypes() {
        return hypes;
    }

    public void setHypes(int hypes) {
        this.hypes = hypes;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public JSONArray getGames() {
        return games;
    }

    public void setGames(JSONArray games) {
        this.games = games;
    }

    public JSONArray getTags() {
        return tags;
    }

    public void setTags(JSONArray tags) {
        this.tags = tags;
    }

    public JSONArray getDevelopers() {
        return developers;
    }

    public void setDevelopers(JSONArray developers) {
        this.developers = developers;
    }

    public JSONArray getPublishers() {
        return publishers;
    }

    public void setPublishers(JSONArray publishers) {
        this.publishers = publishers;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public JSONArray getGameModes() {
        return gameModes;
    }

    public void setGameModes(JSONArray gameModes) {
        this.gameModes = gameModes;
    }

    public JSONArray getKeywords() {
        return keywords;
    }

    public void setKeywords(JSONArray keywords) {
        this.keywords = keywords;
    }

    public JSONArray getThemes() {
        return themes;
    }

    public void setThemes(JSONArray themes) {
        this.themes = themes;
    }

    public long getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(long firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public int getPulseCount() {
        return pulseCount;
    }

    public void setPulseCount(int pulseCount) {
        this.pulseCount = pulseCount;
    }

    public JSONArray getPlatforms() {
        return platforms;
    }

    public void setPlatforms(JSONArray platforms) {
        this.platforms = platforms;
    }

    public JSONArray getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(JSONArray releaseDates) {
        this.releaseDates = releaseDates;
    }

    public JSONArray getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(JSONArray screenshots) {
        this.screenshots = screenshots;
    }

    public JSONArray getVideos() {
        return videos;
    }

    public void setVideos(JSONArray videos) {
        this.videos = videos;
    }

    public JSONObject getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(JSONObject coverURL) {
        this.coverURL = coverURL;
    }

    public JSONObject getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(JSONObject esrbRating) {
        this.esrbRating = esrbRating;
    }

    public JSONArray getWebsites() {
        return websites;
    }

    public void setWebsites(JSONArray websites) {
        this.websites = websites;
    }

    public JSONArray getMultiplayerModes() {
        return multiplayerModes;
    }

    public void setMultiplayerModes(JSONArray multiplayerModes) {
        this.multiplayerModes = multiplayerModes;
    }
}
