# Hangman

## Description

This is a simple Hangman game written in Java. It is using only static methods ... JAVA - basics, not OOP yet.

At first place, pls enter your name (first letter will be capitalized!)
Choose category that returns a random word from the list (array is used) of words in that category.
You have 6 guesses to guess the word. If you guess the word, you win, if you lose all your lives, you lose.
If you guess the same letter as before, 1 of your guess is gone!

## How to run

1. Clone this repo
2. Open terminal in project directory
3. Run `javac Hangman.java` command
4. Run `java Hangman` command
5. Have fun!

## Future plan:
1. add FileReader function and txt file with words
2. add categories (extra)
3. add a function can ask you at the end restart or exit as an extra
4. add ASCII art (extra)
5. add GUI (extra)
6. add OOP (extra)

## Extra for future development:
1. If you want to add new words to the game, just edit `words.txt` file (also you need to implement file reader function! Now it is using array of strings. File can be named by category as well! Or do not forget in txt to add category number)
2. If you want to change the number of lives, edit `Hangman.java` file and change the value of `lives` variable
3. If you want to change the ASCII art, edit `Hangman.java` file and change the value of `hangman` variable
4. Can be added as an extra (choose level -> high, medium, easy -> number of lives will be changed or dwaring of hangman will be changed)