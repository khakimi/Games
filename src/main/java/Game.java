import java.util.ArrayList;
import java.util.Arrays;

public class Game extends RuleTable {
    String[] moves;
    int botMove;

    public Game(String[] moves) throws IllegalArgumentException {
        super(moves);
        if (moves.length > 2 && moves.length % 2 == 1)
            this.moves = Arrays.copyOf(moves, moves.length);
        else
            throw new IllegalArgumentException(
                    "Number of moves must be more than 2 and uneven!");
    }



    public String playGame(int userMove) throws IllegalArgumentException {
        if (userMove >= 0 && userMove < this.moves.length) {
            botMove = 2;
            if (botMove == userMove) return "Draw";
            if (whoWin(botMove,userMove, moves.length)==botMove)
                return "You lose!";
            else
                return "You win!";

        } else
            throw new IllegalArgumentException(
                    "Incorrect move value!!");

    }
}
