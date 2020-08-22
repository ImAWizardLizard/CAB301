package com.company;

public class Movie {
    // TODO: Use enum for classification in order to determine value to store in BSTree
    enum Genre {
        Drama,
        Adventure,
        Family,
        Action,
        Scifi,
        Comedy,
        Animated,
        Thriller,
        Other
    }

    enum Classification {
        G,
        PG,
        M,
        MA
    }

    private String title;
    private String starring;
    private String director;
    private int duration;
    private Genre genre;
    private Classification classification;
    private String release_date;

    public Movie(String title, String starring, String director, int duration, Genre genre, Classification classification, String release_date) {
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    // Compare movies
    public int compare(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }
}
