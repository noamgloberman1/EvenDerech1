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

    private boolean emptyBoard()
    {

        for (int x = 0; x < this.tiles.length; x ++)
        {

            for (int y = 0; y < this.tiles[x].length; y ++)
            {

                if (this.tiles[x][y] != null)
                {

                    return false;

                }

            }

        }

        return true;

    }

    public boolean boardLegal(Word word)
    {

        // unpack the word
        Tile[] wordTiles = word.getTiles();
        int row = word.getRow();
        int col = word.getCol();
        int wordLength = wordTiles.length;
        boolean vertical = word.getVertical();

        // check that the first position is in the board
        if (row >= 15 || col >= 15 || row < 0 || col < 0)
        {

            return false;

        }

        // perform the check for vertical
        if (vertical == true)
        {

            // check that the end of the word is inside the board
            if (row + wordLength > 15)
            {

                return false;

            }

            // check if its the first word
            if (this.emptyBoard() == true)
            {

                // check if the word isnt on the star
                if (col != 7 || row + wordLength - 1 < 7 || row > 7)
                {

                    return false;

                }

            }

            int wordIndexCounter = 0;
            for (int i = row; i < row + wordLength; i++)
            {


                if (this.tiles[i][col] == null || wordTiles[wordIndexCounter].letter == this.tiles[i][col].letter)
                {

                    // legal char
                    wordIndexCounter ++;
                    continue;

                }
                else
                {

                    return false;

                }

            }

        }
        else
        {

            // check if the word fits the board
            if (col + wordLength > 15)
            {

                return false;

            }

            // check if its the first word
            if (this.emptyBoard() == true)
            {

                // check if the word isnt on the star
                if (row != 7 || col + wordLength - 1 < 7 || col > 7)
                {

                    return false;

                }

            }

            int wordIndexCounter = 0;
            for (int i = col; i < col + wordLength; i++)
            {

                if (this.tiles[row][i] == null || wordTiles[wordIndexCounter].letter == this.tiles[row][i].letter)
                {

                    // legal char
                    wordIndexCounter ++;
                    continue;

                }
                else
                {

                    return false;

                }

            }

        }

        return true;

    }

    public boolean dictionaryLegal(Word word)
    {

        return true;

    }

    public Word[] getWords(Word word)
    {



    }

}
