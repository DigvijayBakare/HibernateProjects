package com.tut;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
    private String course;
    private String duration;

    public void setCourse(String course) {
        this.course = course;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getCourse() {
        return course;
    }
    public String getDuration() {
        return duration;
    }
    public Certificate() {
        super();
    }
    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

}
