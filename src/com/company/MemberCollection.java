package com.company;

public class MemberCollection {
    private Member[] members = new Member[10];

    public int getAmountOfMembers() {
        int i = 0;
        while (this.members[i] != null) i++;
        return i;
    }

    // Login a member if it exists within the system
    public Member login(String username, int password) {
        for (int i = 0; i < members.length - 1; i++) {
            if (members[i] != null) {
                // Check if username is correct
                boolean userNameCorrect = username.compareTo(members[i].getSurname().concat(members[i].getGivenName())) == 0;
                // Check if password is correct
                boolean passwordCorrect = password == members[i].getPassword();
                if (userNameCorrect && passwordCorrect) {
                    // Return the user
                    return members[i];
                }
            }
        }
        // Return null (no user found)
        return null;
    }

    // Register a new member into the system
    public boolean registerMember(Member member) {
        for (int i = 0; i < members.length - 1; i++) {
            if (members[i] == null) {
                members[i] = member;
                return true; // TODO: Should not have to return anything
            }
        }
        // Members array is full!
        return false; // TODO: Should raise exception instead
    }

    // Return the members phone number given their first name and surname
    public String findContact(String givenName, String surname) {
        for (int i = 0; i < members.length - 1; i++) {
            if (members[i] != null) {
                String firstname = members[i].getGivenName();
                String lastname = members[i].getSurname();
                if (firstname.equals(givenName) && lastname.equals(surname)) {
                    return members[i].getPhoneNumber(); // Found contact information
                }
            }
        }
        return "Contact not found"; // TODO: Should raise exception instead
    }

    public void getTopBorrowedMovies() {

        // Get the number of members in the library system
        int amountOfMembersInSystem = getAmountOfMembers();

        // Generate an array to contain the distinct movie titles
        String[] distinct_movie_titles = new String[amountOfMembersInSystem * 10];

        // Generate an array to contain the distinct movie frequencies
        int[] distinct_movie_frequency = new int[amountOfMembersInSystem * 10];

        // Loop through each member
        for (int i = 0; i < amountOfMembersInSystem; i++) {
            String[] movie_titles = this.members[i].getMovieTitles();
            // Loop through all of the movie titles
            for (int j = 0; j < movie_titles.length; j++) {
                if (movie_titles[j] != null) {
                    for (int k = 0; k < distinct_movie_titles.length; k++) {
                        if (distinct_movie_titles[k] != null) {
                            if (movie_titles[j].equals(distinct_movie_titles[k])) {
                                distinct_movie_frequency[k]++;
                                break;
                            }
                        } else {
                            distinct_movie_titles[k] = movie_titles[j];
                            distinct_movie_frequency[k]++;
                            break;
                        }

                    }
                }
            }
        }


        // Print the Frequency of movies titles
        for (int i = 0; i < distinct_movie_titles.length; i++) {
            if (distinct_movie_titles[i] != null)
                System.out.println(String.format("%s has been borrowed %d times", distinct_movie_titles[i], distinct_movie_frequency[i]));
        }
    }
}
