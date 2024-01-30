package com.example.demo.movie;

import jakarta.persistence.*;


@Entity
@Table(name="movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="Movie id")
    private long id;
    @Column(name = "Movie Name")
    private String name;
    @Column(name="Movie Lan")
    private String lan;
    @Column(name = "Available")
    private String Availability;
    @Column(name = "Time")
    private int time;
    @Column(name="Rating")
    private double rating;

    public Movie(long id, String name, String lan, String availability, int time, double rating)
    {
        this.id = id;
        this.name = name;
        this.lan = lan;
        Availability = availability;
        this.time = time;
        this.rating = rating;
    }

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lan='" + lan + '\'' +
                ", Availability='" + Availability + '\'' +
                ", time=" + time +
                ", rating=" + rating +
                '}';
    }
}
