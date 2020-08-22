package com.company;

import java.util.Scanner;


public class Main {

    public static MemberCollection memberCollection = new MemberCollection();
    public static MovieCollection library = new MovieCollection();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            welcomePrompt();
            i = tryParse(in.nextLine());
            switch (i) {
                case 1:
                    // staff login
                    System.out.println("=========Staff Login=========");
                    if (staffLogin(in)) {
                        staffMenu.menu(in, memberCollection, library);
                    }
                    break;
                case 2:
                    // Member login
                    System.out.println("=========Memeber Login=========");
                    Member user = memberLogin(in);
                    if (user != null) {
                        memberMenu.menu(in, user, memberCollection, library);
                    }
                    break;
            }
        }
    }

    // Make sure the staff login inputs are correct
    public static boolean staffLogin(Scanner in) {
        System.out.println("Please enter staff username:");
        String username = in.nextLine();

        System.out.println("Please enter staff password:");
        String password = in.nextLine();

        return username.compareTo("staff") == 0 && password.compareTo("today123") == 0;
    }

    // Make sure the given user exists and return a reference to the user
    public static Member memberLogin(Scanner in) {
        System.out.println("Please enter member username:");
        String username = in.nextLine();

        System.out.println("Please enter member password:");
        int password = tryParse(in.nextLine());

        return memberCollection.login(username, password);
    }

    // Prompts
    public static void welcomePrompt() {
        System.out.println("Welcome to the community library");
        System.out.println("=========Main Menu=========");
        System.out.println("1. Staff Login");
        System.out.println("2. Member Login");
        System.out.println("0. Exit");
        System.out.println("===========================");
        System.out.println("Please make a selection (1-2) or 0 to exit the program");
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


}
