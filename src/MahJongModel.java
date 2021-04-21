public class MahJongModel
{
    public MahJongBoard board;

    public MahJongModel(MahJongBoard board)
    {
        this.board = board;
    }

    boolean isTileOpen(int x, int y, int z) {
        if (x == 0 || x == 14 || z == 4)
            return true;

        if (z == 3 && board.tiles[4][3][6] != null) {
            return false;
        }

        if (board.tiles[z + 1][y][x] == null &&
                (board.tiles[z][y][x - 1] == null || board.tiles[z][y][x + 1] == null))
        {
            if (z == 0 && x == 1 && y == 4 && board.tiles[0][3][0] != null)
            {
                return false;
            }

            else if (z == 0 && x == 12 && y == 4 && board.tiles[0][3][13] != null)
            {
                return false;
            }

            return true;
        }
        return false;
    }

}
