import java.awt.*;

public class BambooTile extends RankTile {

    BambooTile(int rank)
    {
        super(rank);
    }

    public void Bamboo(Graphics g, Color c, int x, int y)
    {
        g.setColor(c);
        g.fillRect(x,y,4,15);
        g.setColor(Color.WHITE);
        g.drawLine(x+2, y, x+2, y+15);
        g.setColor(c);
        g.fillRoundRect(x-3,y, 10,2,2, 2);
        g.fillRoundRect(x-3,y+7, 10,2,2, 2);
        g.fillRoundRect(x-3,y+15, 10,2,2, 2);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setToolTipText(toString());

        if(rank == 2)
        {
            Bamboo(g, Color.BLUE, 55, 17);
            Bamboo(g, greenC, 55, 37);
        }

        else if(rank == 3)
        {
            Bamboo(g, Color.BLUE, 55, 17);

            Bamboo(g, greenC, 42, 37);
            Bamboo(g, greenC, 68, 37);
        }

        else if(rank == 4)
        {
            Bamboo(g, Color.BLUE, 42, 17);
            Bamboo(g, greenC, 68, 17);

            Bamboo(g, greenC, 42, 37);
            Bamboo(g, Color.BLUE, 68, 37);
        }

        else if(rank == 5)
        {
            Bamboo(g, greenC, 35, 17);
            Bamboo(g, Color.BLUE, 75, 17);

            Bamboo(g, Color.RED, 55, 27);

            Bamboo(g, Color.BLUE, 35, 37);
            Bamboo(g, greenC, 75, 37);
        }

        else if(rank == 6)
        {
            Bamboo(g, greenC, 35, 17);
            Bamboo(g, greenC, 55, 17);
            Bamboo(g, greenC, 75, 17);

            Bamboo(g, Color.BLUE, 35, 37);
            Bamboo(g, Color.BLUE, 55, 37);
            Bamboo(g, Color.BLUE, 75, 37);
        }

        else if(rank == 7)
        {
            Bamboo(g, greenC, 35, 48);
            Bamboo(g, greenC, 35, 28);

            Bamboo(g, Color.BLUE, 55, 48);
            Bamboo(g, Color.BLUE, 55, 28);
            Bamboo(g, Color.RED, 55, 8);

            Bamboo(g, greenC, 75, 48);
            Bamboo(g, greenC, 75, 28);
        }

        else if(rank == 8)
        {
            Bamboo(g, greenC, 35, 8);
            Bamboo(g, greenC, 55, 8);
            Bamboo(g, greenC, 75, 8);

            Bamboo(g, Color.RED, 45, 28);
            Bamboo(g, Color.RED, 65, 28);

            Bamboo(g, Color.BLUE, 35, 48);
            Bamboo(g, Color.BLUE, 55, 48);
            Bamboo(g, Color.BLUE, 75, 48);
        }

        else if(rank == 9)
        {
            Bamboo(g, Color.RED, 35, 48);
            Bamboo(g, Color.RED, 35, 28);
            Bamboo(g, Color.RED, 35, 8);

            Bamboo(g, Color.BLUE, 55, 48);
            Bamboo(g, Color.BLUE, 55, 28);
            Bamboo(g, Color.BLUE, 55, 8);

            Bamboo(g, greenC, 75, 48);
            Bamboo(g, greenC, 75, 28);
            Bamboo(g, greenC, 75, 8);
        }
    }

    public String toString()
    {
        return "Bamboo " + rank;
    }
}
