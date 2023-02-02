import java.util.Scanner;
import java.util.InputMismatchException;

public class RPC
{
    int keepGoing = 1;
    int cpuChoice = 0; 
    String stringChoice;
    String playerChoice;                          // 1=rock,2=paper,3=scissors
    Scanner scanner = new Scanner(System.in);
    boolean shouldContinue  = true;

    public RPC()
    {

    }

    public void runEventLoop() {
        while (shouldContinue) {
            System.out.println("Will you throw out rock, paper, or scissors? (case sensitive)");
            System.out.println("if you want to quit, type Stop");
            try {
                playerChoice = scanner.next();
                if(keepGoing == 0) { 
                    shouldContinue = false; 
                }
                else if(playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors")){
                    cpuChoice = (int)(Math.random() * 3) + 1;
                    if (cpuChoice == 1) {
                        stringChoice = "rock";
                    } else if (cpuChoice == 2) {
                        stringChoice = "paper";
                    } else if (cpuChoice == 3) {
                        stringChoice = "scissors";
                    }
                    System.out.println("You played " + playerChoice + " and the computer played " + stringChoice); 
                    winner(stringChoice, playerChoice);
                }
                else if(playerChoice.equals("Stop")) {
                    shouldContinue = false;
                }
                else {
                    System.out.println(playerChoice + " is not a valid option; please choose either rock, paper, or scissors.");
                }
            } catch (InputMismatchException error) {
                System.out.println("Error");
                scanner.next();
            }
        }
    } 

    public void winner(String stringChoice, String playerChoice) {
        if (playerChoice.equals("rock") && stringChoice.equals("scissors")) {
            System.out.println("You win!");
        } else if (playerChoice.equals("scissors") && stringChoice.equals("paper")) {
            System.out.println("You win!");
        } else if (playerChoice.equals("paper") && stringChoice.equals("rock")) {
            System.out.println("You win!");
        } else if (stringChoice.equals("rock") && playerChoice.equals("scissors")) {
            System.out.println("The computer wins...");
        } else if (stringChoice.equals("scissors") && playerChoice.equals("paper")) {
            System.out.println("The computer wins...");
        } else if (stringChoice.equals("paper") && playerChoice.equals("rock")) {
            System.out.println("The computer wins...");
        } else {
            System.out.println("You tied.");
        }
    }

    /**
     * The main method instantiates and runs the program
     */
    public static void main (String[] args) {
        RPC rpc = new RPC();
        rpc.runEventLoop();
    }
}

