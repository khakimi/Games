import com.github.freva.asciitable.AsciiTable;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class RuleTable {
    String[] moves;
    private String[] header;
    private String[][] data;


    private void buildTable() {
        if (ArrayUtils.isNotEmpty(moves)) {
            data = new String[moves.length][moves.length + 1];
            header = new String[moves.length + 1];
            header[0] = "";
            System.arraycopy(moves, 0, header, 1, moves.length);
            for (int i = 0; i < moves.length; i++) {
                data[i][0] = moves[i];
                for (int j = 0; j < moves.length; j++) {
                    if (i == j) data[i][i + 1] = "draw";
                    else
                        data[i][j + 1] = (whoWin(i, j, moves.length) == i) ? "win" : "lose";
                }
            }
        }
    }

    private void hasDuplicate(String[] moves) throws IllegalArgumentException {
        for (int i = 0; i < moves.length; i++) {
            for (int j = i + 1; j < moves.length; j++) {
                if (moves[i].equals(moves[j])) throw new
                        IllegalArgumentException(
                        "The sequence should not contain duplicates!");
            }

        }
    }

    private void moveNumberCheck(String[] moves) throws IllegalArgumentException {
        if (moves.length > 2 && moves.length % 2 == 1)
            this.moves = Arrays.copyOf(moves, moves.length);
        else
            throw new IllegalArgumentException(
                    "Number of moves must be more than 2 and uneven!");
    }

    public RuleTable(String[] moves) throws IllegalArgumentException {
        moveNumberCheck(moves);
        hasDuplicate(moves);
        buildTable();
    }

    public int whoWin(int player1, int player2, int movesNumber) {
        if (player1 == player2) return -1;
        if (player1 < player2) {
            player1 += player2;
            player2 = player1 - player2;
            player1 = player1 - player2;
        }
        return player1 - player2 > movesNumber / 2 ? player1 : player2;
    }

    public void printActions() {
        System.out.println("Available moves: ");
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + " - " + moves[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

    public void printRuleTable() {
        System.out.println(AsciiTable.getTable(header, data));
    }
}
