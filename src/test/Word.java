package test;


import java.util.Arrays;

public class Word {

    private Tile[] tiles;
    private int row, col;
    private boolean vertical;

    public Word(Tile[] tiles, int row, int col, boolean vertical)
    {

        this.tiles = tiles;
        this.row = row;
        this.col = col;
        this.vertical = vertical;

    }

    public Tile[] getTiles()
    {

        return this.tiles;

    }

    public int getRow()
    {

        return this.row;

    }

    public int getCol()
    {

        return this.col;

    }

    public boolean getVertical()
    {

        return this.vertical;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (row != word.row) return false;
        if (col != word.col) return false;
        if (vertical != word.vertical) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(tiles, word.tiles);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(tiles);
        result = 31 * result + row;
        result = 31 * result + col;
        result = 31 * result + (vertical ? 1 : 0);
        return result;
    }

}
