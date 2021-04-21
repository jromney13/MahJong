import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class PictureTile extends Tile{

    private String name;
    ImageIcon image;

    PictureTile(String name)
    {
        this.name = name;
        URL url = PictureTile.class.getResource("images/" + name + ".png");
        image = new ImageIcon(url);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setToolTipText(toString());

        if(name.equals("Sparrow") || name.equals("Chrysanthemum"))
        {
            g.drawImage(image.getImage(), 25,10, this);
        }
        else if (name.equals("Spring"))
        {
            g.drawImage(image.getImage(), 25,13, this);
        }
        else if (name.equals("Bamboo"))
        {
            g.drawImage(image.getImage(), 30,5, this);
        }
        else
        {
            g.drawImage(image.getImage(), 25,5, this);
        }
    }

    public String toString()
    {
        return name;
    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Picture Tiles");

        frame.add(new Bamboo1Tile());

        frame.add(new FlowerTile("Chrysanthemum"));
        frame.add(new FlowerTile("Orchid"));
        frame.add(new FlowerTile("Plum"));
        frame.add(new FlowerTile("Bamboo"));

        frame.add(new SeasonTile("Spring"));
        frame.add(new SeasonTile("Summer"));
        frame.add(new SeasonTile("Fall"));
        frame.add(new SeasonTile("Winter"));

        frame.pack();
        frame.setVisible(true);
    }
}
