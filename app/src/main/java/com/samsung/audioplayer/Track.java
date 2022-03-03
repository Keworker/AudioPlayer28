package com.samsung.audioplayer;

public class Track {
    private long id;
    private String title;
    private String author;
    private String path;
    private long duration;

    public Track(long id, String title, String author, String path) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.path = path;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Track " + "id = " + id + ", title = " + title + ", author = " + author
                + ", path = " + path;
    }
}
