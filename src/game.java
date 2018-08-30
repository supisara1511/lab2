import java.sql.SQLOutput;
import java.util.*;
import static java.lang.System.*;

public class game {
    private static OX ox;
    private static int row,col;
    private static Scanner kb = new Scanner(in);


    public static void input()
    {
        boolean canPut = true;
        do {

            out.print(ox.getCurrentPlayer() + " (col): ");
            col = kb.nextInt();
            out.print(ox.getCurrentPlayer() + " (row): ");
            row = kb.nextInt();
            canPut = ox.put(col, row);
            if (!canPut) {
                System.out.println("Please input number beteen 0-2 or Can not repeat");
            }
        }while (!canPut);


    }


    public static void printScore()
    {
        System.out.println("X win " + ox.getScoreX());
        System.out.println("O win " + ox.getScoreO());
        System.out.println("Draw " + ox.getScoreD());
    }

    public static void printTable()
    {
        System.out.println(ox.getTableToString());
    }


    public static void main(String[] args){
        ox = new OX();

        while (true){
            printTable();
            input();
            if(ox.checkWin(col,row)){
                printTable();
                printScore();
                System.out.println("*New Game*");
                ox.resetTable();
                continue;
            }

            if(ox.isDraw()){
                printTable();
                printScore();
                System.out.println("*New Game*");
                ox.resetTable();
                continue;
            }

            ox.swcitchPlayer();

        }







    }

}

