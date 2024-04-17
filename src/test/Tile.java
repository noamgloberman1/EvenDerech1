package test;


import java.util.Objects;
import java.util.Random;

public class Tile
{

    public final char letter;
    public final int score;

    private Tile(char letter, int score)
    {
        this.letter = letter;
        this.score = score;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return letter == tile.letter && score == tile.score;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(letter, score);

    }

    public static class Bag
    {

        int totalTiles = 26;
        int maxTiles = 98;
        private int[] tiles = new int[totalTiles];
        private int[] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        private static Bag bag = null;
        private int currentTilesTotal;

        private Bag()
        {

            this.tiles[0] = 9;
            this.tiles[1] = 2;
            this.tiles[2] = 2;
            this.tiles[3] = 4;
            this.tiles[4] = 12;
            this.tiles[5] = 2;
            this.tiles[6] = 3;
            this.tiles[7] = 2;
            this.tiles[8] = 9;
            this.tiles[9] = 1;
            this.tiles[10] = 1;
            this.tiles[11] = 4;
            this.tiles[12] = 2;
            this.tiles[13] = 6;
            this.tiles[14] = 8;
            this.tiles[15] = 2;
            this.tiles[16] = 1;
            this.tiles[17] = 6;
            this.tiles[18] = 4;
            this.tiles[19] = 6;
            this.tiles[20] = 4;
            this.tiles[21] = 2;
            this.tiles[22] = 2;
            this.tiles[23] = 1;
            this.tiles[24] = 2;
            this.tiles[25] = 1;

            // update the total tiles count
            this.currentTilesTotal = 98;

        }

        public static Bag getBag()
        {

            if (bag == null)
            {

                bag = new Bag();

            }

            return bag;

        }

        public Tile getRand()
        {

            // check if the entire bag is empty
            for (int j = 0; j < totalTiles; j++)
            {

                if (tiles[j] != 0)
                {

                    break;

                }

                if (j == totalTiles - 1 && tiles[j] == 0)
                {

                    return null;

                }

            }

            Random rand = new Random();
            int tileIndex = rand.nextInt(totalTiles);

            // run until found good index
            while (this.tiles[tileIndex] == 0)
            {

                tileIndex = rand.nextInt(totalTiles);

            }

            // remove one from the tiles index and update current tiles total
            this.tiles[tileIndex] --;
            this.currentTilesTotal --;
            return new Tile((char)('A' + tileIndex), scores[tileIndex]);
        }

        public Tile getTile(char tile)
        {

            // check validity of input
            if (Character.isUpperCase(tile) == false)
            {

                return null;

            }

            // get the index of the tile in the array of tiles
            int index = tile - 'A';

            // check if there are no tiles
            if (this.tiles[index] == 0)
            {

                return null;

            }
            else
            {

                // remove this tile from the array and return a tile like this
                this.tiles[index] --;
                this.currentTilesTotal --;
                return new Tile(tile, scores[index]);

            }

        }

        public void put(Tile tile)
        {

            if (this.currentTilesTotal < maxTiles)
            {

                // unpack the tile and find the index in the tiles array
                char letter = tile.letter;
                int score = tile.score;
                int index = letter - 'A';

                // increment the tiles array and the current total tiles
                this.tiles[index] ++;
                this.currentTilesTotal ++;

            }

        }

        public int size()
        {

            return this.currentTilesTotal;

        }

        public int[] getQuantities()
        {

            // create a copy of the array and return it
            int[] copy = new int[this.tiles.length];
            System.arraycopy(this.tiles, 0, copy, 0, this.tiles.length);
            return copy;

        }

    }
	
}
