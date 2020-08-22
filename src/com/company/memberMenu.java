package com.company;

import java.util.Scanner;

public class memberMenu {
    // MEMBER MENU's
    public static void menu(Scanner in, Member user, MemberCollection members, MovieCollection library) {
        int i = 1;
        while (i != 0) {
            memberPrompt();
            i = tryParse(in.nextLine());
            switch (i) {
                case 1:
                    System.out.println("=========Movies in Library=========");
                    System.out.println(String.format("Size of movie library is: %d", library.getMovieLibrarySize()));
                    System.out.println("Movies:");
                    library.listDVDs();
                    break;
                case 2:
                    System.out.println("=========Borrow a DVD=========");
                    String title = enterMovieTitle(in);
                    if (library.findMovie(title) && !user.hasMovie(title)) {
                        user.borrowMovie(library.getMovie(title));
                        library.removeDVD(title, 1);
                    } else {
                        System.out.println("Could not find movie or user already has borrowed movie");
                    }
                    break;
                case 3:
                    System.out.println("=========Return a DVD=========");
                    String return_title = enterMovieTitle(in);
                    Movie movie = user.returnMovie(return_title);
                    if (movie != null) {
                        library.addDVD(movie, 1);
                    } else {
                        System.out.println("Movie entered does not exist");
                    }
                    break;
                case 4:
                    System.out.println("=========Borrowed Movies=========");
                    if (!user.recordsEmpty()) {
                        user.listBorrowedMovies();
                    } else {
                        System.out.println("No movies DVD's have been borrowed");
                    }

                    break;
                case 5:
                    System.out.println("=========Top 10 Most Borrowed Movies=========");
                    members.getTopBorrowedMovies();
                    break;
            }
        }
    }

    public static String enterMovieTitle(Scanner in) {
        System.out.println("Please enter a movie title:");
        return in.nextLine();
    }


    // Prompts

    public static void memberPrompt() {
        System.out.println("=========Member Menu=========");
        System.out.println("1. Display all movies");
        System.out.println("2. Borrow a movie DVD");
        System.out.println("3. Return a movie DVD");
        System.out.println("4. List current borrowed movie DVDs");
        System.out.println("5. Display top 10 most popular movies");
        System.out.println("0. Exit");
        System.out.println("===========================");
        System.out.println("Please make a selection (1-5) or 0 to return to main menu");
    }


    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
