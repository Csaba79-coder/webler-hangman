import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanApp {


    // Arrays of words for countries and cities
    private static final String[] COUNTRIES = {"Hungary", "France", "USA"};
    private static final String[] CITIES = {"New York", "Budapest", "Paris"};

    // Random object to choose a word
    private static final Random random = new Random();

    // Maximum number of incorrect guesses allowed
    private static final int MAX_INCORRECT_GUESSES = 6;

    // Method to start the game

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message and get user's name
        System.out.print("Welcome to Hangman! Please enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + capitalizeInput(playerName) + "! Let's play Hangman.");

        // Ask the player to choose a category (country or city)
        int categoryChoice;
        do {
            System.out.print("Choose a category (1 for countries, 2 for cities): ");
            if (scanner.hasNextInt()) {
                categoryChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (categoryChoice != 1 && categoryChoice != 2) {
                    System.out.println("Invalid choice. Please enter 1 for countries or 2 for cities.");
                }
            } else {
                System.out.println("Invalid input. Please enter 1 for countries or 2 for cities.");
                scanner.nextLine(); // Consume the invalid input
                categoryChoice = 0; // Set an invalid choice to continue the loop
            }
        } while (categoryChoice != 1 && categoryChoice != 2);

        // Select a word from the chosen category
        String wordToGuess = chooseWordToGuess(categoryChoice);

        // Create an array to store guessed letters
        char[] guessedLetters = new char[wordToGuess.length()];

        // Initialize guessedLetters with underscores and spaces
        Arrays.fill(guessedLetters, ' ');
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == ' ') {
                guessedLetters[i] = ' ';
            }
        }

        // Create an array to store incorrect guesses
        char[] incorrectGuesses = new char[MAX_INCORRECT_GUESSES];
        int incorrectGuessCount = 0;

        // Main game loop
        boolean gameOver = false;
        while (!gameOver) {
            displayWord(guessedLetters);

            // Ask the player for a letter guess
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            // Check if the guess is a valid English letter
            if (!Character.isLetter(guess) || guess < 'a' || guess > 'z') {
                System.out.println("Invalid input. Please enter a valid letter.");
                continue;
            }

            // Check if the guess is correct
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (Character.toLowerCase(wordToGuess.charAt(i)) == guess) {
                    guessedLetters[i] = wordToGuess.charAt(i);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                incorrectGuesses[incorrectGuessCount] = guess;
                incorrectGuessCount++;
                drawGallows(incorrectGuessCount);
            }

            // Check if the player has won
            if (Arrays.equals(guessedLetters, wordToGuess.toCharArray())) {
                displayWord(guessedLetters);
                System.out.println("Congratulations, you win! The word was: " + wordToGuess);
                gameOver = true;
            }

            // Check if the player has lost
            if (incorrectGuessCount == MAX_INCORRECT_GUESSES) {
                System.out.println("Sorry, you lose! The word was: " + wordToGuess);
                gameOver = true;
            }
        }

        scanner.close();
    }

    // Method to select a random word from an array
    private static String getRandomWord(String[] words) {
        return words[random.nextInt(words.length)];
    }

    private static String capitalizeInput(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Return the input as-is for null or empty strings
        }

        String[] words = input.split(" ");
        String result = "";

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0)); // Capitalize the first character
                String capitalizedWord = firstChar + word.substring(1).toLowerCase();
                result += capitalizedWord + " ";
            }
        }

        return result.trim(); // Trim to remove trailing spaces
    }

    private static String chooseWordToGuess(int choice) {
        if (choice == 1) {
            return getRandomWord(COUNTRIES);
        } else if (choice == 2) {
            return getRandomWord(CITIES);
        } else {
            System.out.println("Invalid category choice. Please choose 1 for countries or 2 for cities.");
            System.exit(0);
        }
        return null;
    }

    // Method to display the current state of the word
    // what is wrong here? :) incoming param! space 2 words!
    // find the gap here!
    private static void displayWord(char[] guessedLetters) {
        System.out.println(Arrays.toString(guessedLetters)); // if it is 2 words make a mistake!
        System.out.print("Word: ");

        for (char letter : guessedLetters) {
            if (letter == ' ') {
                System.out.print("_ "); // Print underscores for spaces between words
            } else if (letter == '_') {
                System.out.print("_ "); // Print underscores for hidden letters
            } else {
                System.out.print(letter + " "); // Print guessed letters with spaces
            }
        }
        System.out.println();
    }


    // Method to draw the gallows tree based on the number of incorrect guesses
    private static void drawGallows(int incorrectGuessCount) {
        System.out.println("Incorrect guesses: ");

        // You can customize the gallows drawing here based on the incorrectGuessCount
        switch (incorrectGuessCount) {
            case 1:
                System.out.println("  _______");
                System.out.println(" |       |");
                System.out.println(" |       O");
                break;
            case 2:
                System.out.println("  _______");
                System.out.println(" |       |");
                System.out.println(" |       O");
                System.out.println(" |       |");
                System.out.println(" |");
                break;
            case 3:
                System.out.println("  _______");
                System.out.println(" |       |");
                System.out.println(" |       O");
                System.out.println(" |      /|");
                System.out.println(" |");
                break;
            case 4:
                System.out.println("  _______");
                System.out.println(" |       |");
                System.out.println(" |       O");
                System.out.println(" |      /|\\");
                System.out.println(" |");
                break;
            case 5:
                System.out.println("  _______");
                System.out.println(" |       |");
                System.out.println(" |       O");
                System.out.println(" |      /|\\");
                System.out.println(" |      /");
                break;
            case 6:
                System.out.println("  _______");
                System.out.println(" |       |");
                System.out.println(" |       O");
                System.out.println(" |      /|\\");
                System.out.println(" |      / \\");
                break;
        }
    }
}

