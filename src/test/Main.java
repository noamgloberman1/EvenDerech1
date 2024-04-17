package test;
import test.Tile.Bag;
import test.Board;

public class Main {

    public static void main(String[] args)
    {

        Bag rand = Tile.Bag.getBag();
        Board test = Board.getBoard();
        Tile[][] array = test.getTiles();

        int rows = array.length;
        int cols = array[0].length; // Assuming all rows have the same number of columns

        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j]);
                if (j != cols - 1) {
                    System.out.print(", "); // Add comma and space between elements (except last)
                }
            }
            System.out.println("]"); // Add closing bracket and newline for each row
        }


//        for (int i = 0; i < 60; i ++)
//        {
//            rand.getRand();
//        }
//
//        System.out.println(rand.getTile('C'));

    }

}
