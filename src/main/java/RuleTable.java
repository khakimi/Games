import com.github.freva.asciitable.AsciiTable;

public class RuleTable {
    private String[] header;
    private String[][] data;

    public RuleTable(String[] moves) throws IllegalArgumentException {
        data = new String[moves.length][moves.length+1];
        header = new String[moves.length+1];
        header[0] = "";
        for (int i = 0; i < moves.length; i++) {
            header[i+1] = moves[i];
        }
        for (int i = 0; i < moves.length; i++) {
            data[i][0] = moves[i];
            for (int j = 0; j < moves.length; j++) {
                if( i == j) data[i][i+1] = "draw";
                else
                    data[i][j+1] = (whoWin(i, j, moves.length) == i)? "win": "lose";
            }
        }
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

    void printRuleTable(){
        System.out.println(AsciiTable.getTable(header, data));
    }
}
