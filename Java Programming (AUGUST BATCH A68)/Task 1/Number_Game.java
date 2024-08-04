/*
     Task 1: Number Game
     (Date - 4/8/24)

     1. Generate a random number within a specified range, such as 1 to 100.
     2. Prompt the user to enter their guess for the generated number.
     3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
     4. Repeat steps 2 and 3 until the user guesses the correct number.

     You can incorporate additional details as follows:

     5. Limit the number of attempts the user has to guess the number.
     6. Add the option for multiple rounds, allowing the user to play again.
     7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Number_Game {
     private byte random_Number, lives = 100;
     private int points, score = 0;

     public static void main(String[] args) {
          Number_Game nb = new Number_Game();
          nb.play_Game();
     }

     private Number_Game() {
          give_Instructions_Rules();
          set_Points();
     }

     private void give_Instructions_Rules() {
          System.out.println("\nYou are playing Number Game.");
          System.out.println("\nRules:-\n1. Guess a number from 1 to 100.\n2. You start with 100 lives.\n3. Correct guesses earn points.\n4. Incorrect guesses decrement lives by 1.\n5. Score 100 points to win the game.");
          System.out.println("\nGood Luck!");
     }

     private void set_Points() {
          Scanner sc = new Scanner(System.in);
          int points = 0;
          do {
               System.out.println("\nHow many points do you want to increase for every correct guess?\nEnter points in the range from 1 to 100.");
               try {
                    points = sc.nextInt();
                    if (points < 1 || points > 100) {
                         System.out.println("Points must be between 1 and 100. Please try again.");
                    }
               } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value between 1 and 100.");
                    sc.next();
               }
          } while (points < 1 || points > 100);
          this.points = points;
     }

     private void generate_Random() {
          this.random_Number = (byte) (Math.random() * 100 + 1);
     }

     private void play_Game() {
          Scanner sc = new Scanner(System.in);
          while (lives > 0) {
               generate_Random();
               int guess;
               do {
                    System.out.println("\nGuess a number (1-100) or enter '-31' to quit:");
                    try {
                         guess = sc.nextInt();
                         if (guess == -31)
                              play_Again();
                         if (guess < 1 || guess > 100) {
                              System.out.println("Number out of range. Enter a number between 1 and 100.");
                         }
                    } catch (InputMismatchException e) {
                         System.out.println("Invalid input. Enter a number between 1 and 100.");
                         sc.next();
                         guess = 0;
                    }
               } while (guess < 1 || guess > 100);

               byte difference = (byte) Math.abs(random_Number - guess);
               if (difference == 0) {
                    System.out.println("Congratulations! You scored " + points + " points.");
                    score += (byte) points;
                    if (score >= 100) {
                         System.out.println("\nCongratulations! You scored 100 or more points. You won!");
                         play_Again();
                    }
               } else {
                    int distanceRange = (difference / 10) * 10;
                    if (distanceRange == 0)
                         System.out.println("You are approximately less than 10 numbers away from the actual number.");
                    else
                         System.out.println(
                                   "You are approximately " + distanceRange + " numbers away from the actual number.");
                    System.out.println("Generated random number: " + random_Number);
                    lives--;
               }
               display_Status();
          }
          System.out.println("\nYou've run out of lives.");
          play_Again();
     }

     private void display_Status() {
          System.out.println("Your total score: " + score);
          System.out.println("Your remaining lives: " + lives);
     }

     private void reset_Game() {
          this.score = 0;
          this.lives = 100;
     }

     private void play_Again() {
          Scanner sc = new Scanner(System.in);
          System.out.println("Game Over! Want to play again? (Yes/No)");
          String response;
          do {
               response = sc.next().trim();
               if (response.equalsIgnoreCase("Yes")) {
                    reset_Game();
                    give_Instructions_Rules();
                    set_Points();
                    play_Game();
               } else if (response.equalsIgnoreCase("No")) {
                    System.out.println("Goodbye! Have a nice day!");
                    sc.close();
                    System.exit(0);
               } else {
                    System.out.println("Invalid input. Please type 'Yes' or 'No'.");
               }
          } while (!response.equalsIgnoreCase("Yes") && !response.equalsIgnoreCase("No"));
     }
}
