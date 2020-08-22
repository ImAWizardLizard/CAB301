package com.company;

import java.util.Scanner;

public class staffMenu {

    // STAFF MENU's
    public static void menu(Scanner in, MemberCollection memberCollection, MovieCollection library) {
        int i = 1;
        while (i != 0) {
            staffPrompt();
            i = tryParse(in.nextLine());
            switch (i) {
                case 1:
                    System.out.println("=========Add a DVD to the library=========");

                    // Get movie information
                    String title = enterMovieTitle(in);
                    String starring = enterMovieStarring(in);
                    String director = enterMovieDirector(in);
                    int duration = enterMovieDuration(in);
                    Movie.Genre genre = pickMovieGenre(in);
                    Movie.Classification classification = pickMovieClassification(in);
                    String release_date = enterMovieReleaseDate(in);
                    int amount = enterAmountOfDVDs(in);

                    // Put data into a movie object instance
                    Movie movie = new Movie(title, starring, director, duration, genre, classification, release_date);

                    // Add movie to the library
                    library.addDVD(movie, amount);

                    System.out.println();
                    break;
                case 2:
                    System.out.println("=========Remove A DVD=========");

                    String movie_title = enterMovieTitle(in);
                    int remove_amount = enterAmountOfDVDs(in);

                    library.removeDVD(movie_title, remove_amount);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("=========Register a new Member=========");
                    String firstName = enterFirstName(in);
                    String surname = enterSurname(in);
                    String password = enterPassword(in);
                    String phoneNumber = enterPhoneNumber(in);
                    String address = enterAddress(in);

                    memberCollection.registerMember(new Member(firstName, surname, password, phoneNumber, address));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("=========Find a registered member=========");
                    String name = enterFirstName(in);
                    String last_name = enterSurname(in);
                    String result = memberCollection.findContact(name, last_name);
                    System.out.println(String.format("Phone Number: %s", result));
                    System.out.println();
                    break;
            }
        }
    }

    //  New DVD inputs
    public static String enterMovieTitle(Scanner in) {
        System.out.println("Please enter a movie title:");
        return in.nextLine();
    }

    public static String enterMovieStarring(Scanner in) {
        System.out.println("Please enter a starring actor: ");
        return in.nextLine();
    }

    public static String enterMovieDirector(Scanner in) {
        System.out.println("Please enter a director:");
        return in.nextLine();
    }

    public static String enterMovieReleaseDate(Scanner in) {
        System.out.println("Please enter a release date:");
        return in.nextLine();
    }

    // Only accept integer input
    public static int enterMovieDuration(Scanner in) {
        int i = 0;
        while (true) {
            System.out.println("Please enter a movie duration:");
            i = tryParse(in.nextLine());
            if (i != -1) {
                return i;
            }
        }
    }

    // Only accept integer input
    public static int enterAmountOfDVDs(Scanner in) {
        int i = 0;
        while (true) {
            System.out.println("Please enter a number of DVD's:");
            i = tryParse(in.nextLine());
            if (i != -1) {
                return i;
            }
        }
    }

    // Only accept integer input
    public static Movie.Genre pickMovieGenre(Scanner in) {
        int i = 0;
        while (true) {
            pickMovieGenrePrompt();
            i = tryParse(in.nextLine());
            if (i != -1 && i >= 1 && i - 1 <= Movie.Genre.values().length - 1) {
                return Movie.Genre.values()[i - 1];
            }
        }
    }

    // Only accept integer input
    public static Movie.Classification pickMovieClassification(Scanner in) {
        int i = 0;
        while (true) {
            pickMovieClassificationPrompt();
            i = tryParse(in.nextLine());
            if (i != -1 && i >= 1 && i - 1 <= Movie.Classification.values().length - 1) {
                return Movie.Classification.values()[i - 1];
            }
        }
    }

    // New Member Inputs
    public static String enterFirstName(Scanner in) {
        System.out.println("Please enter the first name");
        return in.nextLine();
    }

    public static String enterSurname(Scanner in) {
        System.out.println("Please enter the surname");
        return in.nextLine();
    }

    public static String enterPassword(Scanner in) {
        System.out.println("Please enter the password");
        return in.nextLine();
    }

    public static String enterPhoneNumber(Scanner in) {
        System.out.println("Please enter the phone number");
        return in.nextLine();
    }

    public static String enterAddress(Scanner in) {
        System.out.println("Please enter the address");
        return in.nextLine();
    }


    // Prompts

    public static void staffPrompt() {
        System.out.println("=========Staff Menu=========");
        System.out.println("1. Add a new Movie DVD");
        System.out.println("2. Remove a movie DVD");
        System.out.println("3. Register a new Member");
        System.out.println("4. Find a registered Member");
        System.out.println("0. Exit");
        System.out.println("============================");
        System.out.println("Please make a selection (1-4) or 0 to return to main menu");
    }


    public static void pickMovieGenrePrompt() {
        System.out.println("=========Pick Genre Menu=========");
        System.out.println("1. Drama");
        System.out.println("2. Adventure");
        System.out.println("3. Family");
        System.out.println("4. Action");
        System.out.println("5. Sci-fi");
        System.out.println("6. Comedy");
        System.out.println("7. Animated");
        System.out.println("8. Thriller");
        System.out.println("9. Other");
        System.out.println("===========================");
        System.out.println("Please make a selection (1-9)");
    }

    public static void pickMovieClassificationPrompt() {
        System.out.println("=========Pick Rating Menu=========");
        System.out.println("1. G");
        System.out.println("2. PG");
        System.out.println("3. M");
        System.out.println("4. MA");
        System.out.println("===========================");
        System.out.println("Please make a selection (1-4) ");
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
