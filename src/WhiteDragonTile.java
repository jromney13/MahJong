import java.awt.*;

public class WhiteDragonTile extends Tile
{
    public WhiteDragonTile()
    {
        setToolTipText("White Dragon");
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(26,6,60, 8);
        g.setColor(Color.BLUE);
        g.fillRect(26, 6, 10,8);
        g.fillRect(46, 6, 10,8);
        g.fillRect(66, 6, 10,8);

        g.setColor(Color.WHITE);
        g.fillRect(26,56,60, 8);
        g.setColor(Color.BLUE);
        g.fillRect(26, 56, 10,8);
        g.fillRect(46, 56, 10,8);
        g.fillRect(66, 56, 10,8);

        g.setColor(Color.WHITE);
        g.fillRect(26,14, 8, 42);
        g.setColor(Color.BLUE);
        g.fillRect(26, 21, 8,9);
        g.fillRect(26, 39, 8,9);

        g.fillRect(78,14, 8, 42);
        g.setColor(Color.WHITE);
        g.fillRect(78, 21, 8,9);
        g.fillRect(78, 39, 8,9);

        g.setColor(Color.BLACK);
        g.drawRect(26, 6, 60 , 58);
        g.drawRect(34, 14, 44, 42);
    }


    public String toString()
    {
        return "White Dragon";
    }
}
