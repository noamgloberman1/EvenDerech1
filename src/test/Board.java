package test;


public class Board {

    private Tile[][] tiles = new Tile[15][15];
    private static Board board = null;

    private Board()
    {

    }

    public static Board getBoard()
    {

        // check if no board has been created
        if (board == null)
        {

            board = new Board();

        }

        return board;

    }

    public Tile[][] getTiles()
    {

        // create a copy of the array and return it
        int rows = this.tiles.length;
        int cols = this.tiles[0].length;
        Tile[][] copy = new Tile[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(this.tiles[i], 0, copy[i], 0, cols);
        }

        return copy;

    }

    public boolean boardLegal(Word word)
    {

        
        return true;

    }

}
