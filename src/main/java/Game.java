import java.security.SecureRandom;
import java.util.Scanner;

public class Game extends RuleTable {
    Scanner scanner;
    Hmac hmac;
    long key;
    int botMove;

    private void generateHmac() {
        key = new SecureRandom().nextLong();
        botMove = Math.abs(Long.valueOf(key % moves.length).intValue());
        hmac = new Hmac(key, moves[botMove]);
    }

    public Game(String[] moves) throws IllegalArgumentException {

        super(moves);
        scanner = new Scanner(System.in);
    }


    public boolean startGame() {
        generateHmac();
        System.out.println("HMAC: " + hmac.getHmac());
        return playGame();
    }

    public boolean playGame() {
        printActions();
        System.out.println("Enter your move: ");
        while (true) {
            String choice = scanner.useDelimiter(" ").nextLine();
            if (choice.equals("?")) printRuleTable();
            else if (new Scanner(choice).hasNextInt()) {
                int userMove = Integer.parseInt(choice);
                if (userMove == 0) return false;
                else if (userMove >= 1 && userMove <= moves.length + 1) {
                    userMove--;
                    System.out.println("Your move: " + moves[userMove]);
                    System.out.println("Computer move: " + moves[botMove]);
                    System.out.println(winner(userMove));
                    System.out.println("HMAC key: " + hmac.getKey() + "\n\n");
                    break;
                } else
                    System.out.println("Incorrect input!");
            } else
                System.out.println("Incorrect input!");
        }
        return true;

    }

    public String winner(int userMove) throws IllegalArgumentException {
        if (userMove >= 0 && userMove < this.moves.length) {
            if (botMove == userMove) return "Draw";
            else if (whoWin(botMove, userMove, moves.length) == botMove)
                return "Computer win!";
            else
                return "You win!";

        } else
            throw new IllegalArgumentException(
                    "Incorrect move value!!");

    }
}
