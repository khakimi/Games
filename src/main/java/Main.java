import java.util.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(args);
        Scanner scanner = new Scanner(System.in);
        String choice;
        while(game.startGame()){}
    }
}