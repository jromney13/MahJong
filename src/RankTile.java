public class RankTile extends Tile {

    protected int rank;

    RankTile(int rank)
    {
        this.rank = rank;
    }

    public boolean matches(Tile other)
    {
        if(super.matches(other))
        {
            RankTile r = (RankTile) other;
            return this.rank == r.rank;
        }
        return false;
    }
}
