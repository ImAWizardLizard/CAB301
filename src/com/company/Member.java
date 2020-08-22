package com.company;

public class Member {

    private String address;
    private String phoneNumber;
    private String surname;
    private String givenName;
    private int password;
    private Movie[] record = new Movie[20];

    public Member(String givenName, String surname, String password, String phoneNumber, String address) {
        this.surname = surname;
        this.givenName = givenName;
        this.phoneNumber = phoneNumber;
        this.address = address;

        // TODO: Need to take into account incorrectly entered passwords
        // TODO: Need to raise an exception if this is wrong
        if (password.length() == 4) {
            this.password = Integer.parseInt(password.trim());
        }
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    // Get all of the movies that the member is currently borrowing
    public String[] getMovieTitles() {
        String[] movies = new String[this.record.length];
        for (int i = 0; i < this.record.length; i++) {
            if (this.record[i] != null) {
                // Append the movie title to the movies array
                movies[i] = this.record[i].getTitle();
            }
        }
        // Return the list of movies the user is borrowing
        return movies;
    }

    // Insert a movie into the members record given the movie object
    public void borrowMovie(Movie movie) {
        for (int i = 0; i < record.length; i++) {
            if (record[i] == null) {
                record[i] = movie;
                break;
            }
        }
    }

    // Remove a movie from a users record given the movie title
    public Movie returnMovie(String title) {
        Movie temp = null;
        for (int i = 0; i < record.length; i++) {
            if (record[i] != null) {
                if (title.compareTo(record[i].getTitle()) == 0) {
                    temp = record[i];
                    record[i] = null;
                    break;
                }
            }
        }
        return temp;
    }

    // List all fo the borrowed movies the user has in their record
    public void listBorrowedMovies() {
        for (int i = 0; i < record.length; i++) {
            if (record[i] != null) {
                System.out.println(record[i].getTitle());
            }
        }
    }

    // Check if the user has borrowed a movie given the movie title
    public boolean hasMovie(String title) {
        for (int i = 0; i < record.length; i++) {
            if (record[i] != null) {
                if (title.compareTo(record[i].getTitle()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recordsEmpty() {
        for (int i = 0; i < record.length; i++) {
            if (record[i] != null)
                return false;
        }
        return true;
    }


}
