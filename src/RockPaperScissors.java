import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {

    public static void playGame() {
        // Array holding int values representing rock-1,paper-2,scissors-3 - for computer choice
        int[] choice = {1, 2, 3};

        // variables holding scores - user and pc points
        int userPoints = 0;
        int pcPoints = 0;

        // Scanner for obtaining inputs
        Scanner scan = new Scanner(System.in);

        // Welcome message
        System.out.println("     Hey, Lets play     \n *** Rock-Paper-Scissors ***");
        System.out.println("How many rounds you want to play? (1 - 10 allowed):");

        // User inputs how many rounds want to play
        int userRounds = scan.nextInt();

        // while rounds in range  -> get user choice input and random pc choice from array-choice
        while (userRounds <= 10 && userRounds > 0) {
            System.out.println("What do you choose?Type 0 for Rock, 1 for Paper or 2 for Scissors.");
            int userInput = scan.nextInt();
            int pcChoiceIndex = new Random().nextInt(choice.length);
            int computerChoice = choice[pcChoiceIndex];

    /*
    Paper 2 wraps Rock 1 to win
    Scissors 3 cut Paper 2 to win
    Rock 1 breaks Scissors 3 to win
    3 > 2 > 1
    */
            // Loop through rounds quantity
            for (int i = 1; i < userRounds; i++) {

                // Comparing user and pc choice - adding points to winner and decreasing rounds count
                if (userInput >= 3 || userInput < 0) {
                    System.out.println("You typed an invalid number, you lose a point!");
                    pcPoints++;
                    break;
                } else if (userInput == 1 && computerChoice == 3) {
                    System.out.println("Your Rock breaks Scissors. You win!");
                    userPoints++;
                    break;
                } else if (computerChoice == 1 && userInput == 2) {
                    System.out.println("Rock breaks your Scissors. You lose!");
                    pcPoints++;
                    break;
                } else if (computerChoice > userInput) {
                    System.out.println("You lose!");
                    pcPoints++;
                    break;
                } else if (userInput > computerChoice) {
                    System.out.println("You win!");
                    userPoints++;
                    break;
                } else if (userInput == computerChoice) {
                    System.out.println("It's a draw");
                    break;
                } else {
                    System.out.println("You can play 1 to 10 rounds. Try again: ");
                }

            } // End of for loop - rounds loop

            userRounds--;                        // decreasing rounds count
            System.out.println("Rounds left: " + userRounds);
        } //End of while - rounds range check

        // Comparing scores to find out who is the winner
        if (userPoints > pcPoints) {
            System.out.println("You win with " + userPoints + " points.");
        } else if (userPoints < pcPoints) {
            System.out.println("Computer wins with " + pcPoints + " points.");
        } else {
            System.out.println(" It's a draw." + userPoints + " --- " + pcPoints);
        } // End of if - points comparison to determine winner

    }

    public static void main(String[] args) {

        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);

        do {
            playGame();
            System.out.println("Would you like to play again? Yes/No");
            playAgain = scan.nextLine().trim().equalsIgnoreCase("yes");
        } while (playAgain);

    } // End of main

} // End of class

