package com.company;

public class MovieCollection {
    private BSTree movies = new BSTree();

    // Add x movies to the BSTree
    public void addDVD(Movie movie, int amount) {
        for (int i = 0; i < amount; i++) {
            this.movies.insert(movie);
        }
    }

    // Remove x movies to the BSTree
    public void removeDVD(String title, int amount) {
        for (int i = 0; i < amount; i++) {
            this.movies.delete(title);
        }
    }

    // Print all of the movies in alphabetical order which are stored within the library
    public void listDVDs() {
        this.movies.InOrderTraverse();
    }

    // Get the number of DVD's available within the library
    public int getMovieLibrarySize() {
        return this.movies.getSize();
    }

    // Check if a DVD exists within the library
    public boolean findMovie(String title) {
        return movies.find(title);
    }

    // Retrieve a DVD from the library
    public Movie getMovie(String title) {
        return movies.get(title);
    }
}
