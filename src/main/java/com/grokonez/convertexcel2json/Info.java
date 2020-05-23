package com.grokonez.convertexcel2json;

public class Info {
    private String summary;
    private String wordings;
    private String lesson;
    private String startDay;
    private String endDay;

    public Info() {
    }

    public Info(String summary, String wordings, String lesson, String startDay, String endDay) {
        this.summary = summary;
        this.wordings = wordings;
        this.lesson = lesson;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWordings() {
        return wordings;
    }

    public void setWordings(String wordings) {
        this.wordings = wordings;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
}
