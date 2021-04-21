import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class CircleTile extends RankTile {

    CircleTile(int rank)
    {
        super(rank);
    }

    public void Circle(Graphics g, int x, int y,Color c)
    {
        g.setColor(c);
        g.fillOval(x, y, 12, 12);
        g.setColor(Color.BLACK);
        g.drawLine(x+6,y+1,x+6,y+11);
        g.drawLine(x+1,y+6,x+11,y+6);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setToolTipText(toString());

        if(rank == 1)
        {
            g.setColor(greenC);
            g.fillOval(30, 10, 50, 50);
            Circle(g, 49, 29, Color.RED);
            g.setColor(Color.BLACK);
            g.drawOval(30,10,50,50);

            g.setColor(Color.WHITE);
            for (double i = 0; i < 6.2831853072; i += 0.3490658504)
            {
                g.fillOval((int)Math.round(Math.cos(i) * 20) + 53,
                        (int)Math.round(Math.sin(i) * 20) + 33, 4, 4);
            }
        }

        else if(rank == 2)
        {
            Circle(g, 49, 15, greenC);
            Circle(g, 49, 45, Color.RED);
        }
        else if(rank == 3)
        {
            Circle(g, 25, 5, Color.BLUE);
            Circle(g, 73, 53, greenC);
            Circle(g, 49, 29, Color.RED);
        }
        else if (rank == 4)
        {
            Circle(g, 30, 10, Color.BLUE);
            Circle(g, 30, 48, greenC);
            Circle(g, 68, 10, greenC);
            Circle(g, 68, 48, Color.BLUE);
        }
        else if (rank == 5)
        {
            Circle(g, 30, 10, Color.BLUE);
            Circle(g, 30, 48, greenC);
            Circle(g, 68, 10, greenC);
            Circle(g, 68, 48, Color.BLUE);
            Circle(g, 49, 29, Color.RED);
        }
        else if (rank == 6)
        {
            Circle(g, 35, 10, greenC);
            Circle(g, 35, 48, Color.RED);
            Circle(g, 63, 10, greenC);
            Circle(g, 63, 48, Color.RED);
            Circle(g, 35, 29, Color.RED);
            Circle(g, 63, 29, Color.RED);
        }
        else if (rank == 7)
        {
            Circle(g, 29, 8, greenC);
            Circle(g, 35, 52, Color.RED);
            Circle(g, 69, 20, greenC);
            Circle(g, 63, 52, Color.RED);
            Circle(g, 35, 36, Color.RED);
            Circle(g, 63, 36, Color.RED);
            Circle(g, 49, 14, greenC);
        }
        else if (rank == 8)
        {
            Circle(g, 63, 4, Color.BLUE);
            Circle(g, 35, 4, Color.BLUE);
            Circle(g, 63, 20, Color.BLUE);
            Circle(g, 35, 20, Color.BLUE);
            Circle(g, 35, 52, Color.BLUE);
            Circle(g, 63, 52, Color.BLUE);
            Circle(g, 35, 36, Color.BLUE);
            Circle(g, 63, 36, Color.BLUE);
        }
        else if (rank == 9)
        {
            Circle(g, 49, 4, greenC);
            Circle(g, 24, 4, greenC);
            Circle(g, 74, 4, greenC);
            Circle(g, 49, 29, Color.RED);
            Circle(g, 24, 29, Color.RED);
            Circle(g, 74, 29, Color.RED);
            Circle(g, 49, 54, Color.BLUE);
            Circle(g, 24, 54, Color.BLUE);
            Circle(g, 74, 54, Color.BLUE);
        }

    }

    public String toString()
    {
        return "Circle " + rank;
    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));
        frame.add(new CircleTile(7));
        frame.add(new CircleTile(8));
        frame.add(new CircleTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
