import java.awt.*;
import javax.swing.*;
import java.util.HashMap;

public class CharacterTile extends Tile {

    protected char symbol;
    static protected HashMap<Character, Character> charMap = new HashMap<>();

    static
    {
        charMap.put('1','\u4E00');
        charMap.put('2','\u4E8C');
        charMap.put('3','\u4E09');
        charMap.put('4','\u56DB');
        charMap.put('5','\u4E94');
        charMap.put('6','\u516D');
        charMap.put('7','\u4E03');
        charMap.put('8','\u516B');
        charMap.put('9','\u4E5D');
        charMap.put('N','\u5317');
        charMap.put('E','\u6771');
        charMap.put('W','\u897F');
        charMap.put('S','\u5357');
        charMap.put('C','\u4E2D');
        charMap.put('F','\u767C');
    }

    CharacterTile(char symbol)
    {
        this.symbol = symbol;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setToolTipText(toString());
        g.setColor(Color.RED);
        g.drawString(Character.toString(symbol),75,15);
        g.setColor(Color.BLACK);

        if( symbol == 'N' || symbol == 'E' || symbol == 'W' ||
                symbol == 'S' || symbol == 'C' || symbol == 'F')
        {
            Font f = g.getFont().deriveFont(45F);
            g.setFont(f);

            if(symbol == 'F')
            {
                g.setColor(greenC);
            }
            if(symbol == 'C')
            {
                g.setColor(Color.RED);
            }

            g.drawString(Character.toString(charMap.get(symbol)),32, 55);
        }

        else
        {
            Font f = g.getFont().deriveFont(20F);
            g.setFont(f);
            g.drawString(Character.toString(charMap.get(symbol)), 45, 30);
            g.setColor(Color.RED);
            g.drawString(Character.toString('\u842C'), 45, 60);
        }
    }


    public boolean matches(Tile other)
    {
        if(super.matches(other))
        {
            CharacterTile c = (CharacterTile) other;
            return this.symbol == c.symbol;
        }
        return false;
    }

    public String toString()
    {
        if(symbol == 'N')
        {
            return "North Wind";
        }
        else if(symbol == 'E')
        {
            return "East Wind";
        }
        else if(symbol == 'W')
        {
            return "West Wind";
        }
        else if(symbol == 'S')
        {
            return "South Wind";
        }
        else if(symbol == 'C')
        {
            return "Red Dragon";
        }
        else if(symbol == 'F')
        {
            return "Green Dragon";
        }
        return "Character " + symbol;
    }

    public String toChinese()
    {
        return Character.toString(charMap.get(symbol));
    }

    public static void main(String[] args)
    {
        JFrame		frame = new JFrame();
        JPanel		tiles = new JPanel();
        JScrollPane	scroller = new JScrollPane(tiles);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Tiles");
        frame.add(scroller);

        // Try something like this if your tiles don't fit on the screen.
        // Replace "tile width" and "tile height" with your values.
        //scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

        tiles.add(new CharacterTile('1'));
        tiles.add(new CharacterTile('2'));
        tiles.add(new CharacterTile('3'));
        tiles.add(new CharacterTile('4'));
        tiles.add(new CharacterTile('5'));
        tiles.add(new CharacterTile('6'));
        tiles.add(new CharacterTile('7'));
        tiles.add(new CharacterTile('8'));
        tiles.add(new CharacterTile('9'));
        tiles.add(new CharacterTile('N'));
        tiles.add(new CharacterTile('E'));
        tiles.add(new CharacterTile('W'));
        tiles.add(new CharacterTile('S'));
        tiles.add(new CharacterTile('C'));
        tiles.add(new CharacterTile('F'));

        frame.pack();
        frame.setVisible(true);
    }
}
