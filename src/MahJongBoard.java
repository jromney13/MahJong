import javax.swing.*;
import	javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.net.*;
import java.util.Stack;

public class MahJongBoard extends JPanel implements MouseListener
{
    private MahJong game;
    private MahJongModel model;
    private Fireworks reward;

    public Tile[][][] tiles = new Tile[5][8][15];
    public int[][][] tilesEmpty = new int[5][8][15];
    public Stack<Tile> removeStack = new Stack<>();
    public int score = 0;
    public boolean soundOn = true;

    private Border selected = BorderFactory.createLineBorder(Color.RED, 4);
    private Tile first = null;
    private Tile second = null;

    public PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
    public JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public JScrollPane jPane = new JScrollPane();


    public MahJongBoard(MahJong game, long gameNum)
    {
        setLayout(null);
        setPreferredSize(new Dimension(1200,720));
        this.game = game;
        model = new MahJongModel(this);
        TileDeck t = new TileDeck();
        t.shuffle(gameNum);

        tilesEmpty[0][0][0] = 1;
        tilesEmpty[0][0][13] = 1;
        tilesEmpty[0][0][14] = 1;

        tilesEmpty[0][1][0] = 1;
        tilesEmpty[0][1][1] = 1;
        tilesEmpty[0][1][2] = 1;

        tilesEmpty[0][1][11] = 1;
        tilesEmpty[0][1][12] = 1;
        tilesEmpty[0][1][13] = 1;
        tilesEmpty[0][1][14] = 1;

        tilesEmpty[0][2][0] = 1;
        tilesEmpty[0][2][1] = 1;

        tilesEmpty[0][2][12] = 1;
        tilesEmpty[0][2][13] = 1;
        tilesEmpty[0][2][14] = 1;

        tilesEmpty[0][4][0] = 1;
        tilesEmpty[0][4][13] = 1;
        tilesEmpty[0][4][14] = 1;

        tilesEmpty[0][5][0] = 1;
        tilesEmpty[0][5][1] = 1;

        tilesEmpty[0][5][12] = 1;
        tilesEmpty[0][5][13] = 1;
        tilesEmpty[0][5][14] = 1;

        tilesEmpty[0][6][0] = 1;
        tilesEmpty[0][6][1] = 1;
        tilesEmpty[0][6][2] = 1;

        tilesEmpty[0][6][11] = 1;
        tilesEmpty[0][6][12] = 1;
        tilesEmpty[0][6][13] = 1;
        tilesEmpty[0][6][14] = 1;

        tilesEmpty[0][7][0] = 1;
        tilesEmpty[0][7][13] = 1;
        tilesEmpty[0][7][14] = 1;

        for(int i=0; i<5; i++)
        {
            for(int j=0; j<8; j++)
            {
                for(int k=0; k<15; k++)
                {
                    if(i == 0 && tilesEmpty[i][j][k] != 1)
                    {
                        tiles[i][j][k] = t.deal();
                        tiles[i][j][k].xVar = k;
                        tiles[i][j][k].yVar = j;
                        tiles[i][j][k].zVar = i;
                    }
                    else if(i == 1 && (j<6) && (k<6) )
                    {
                        tiles[i][j+1][k+4] = t.deal();
                        tiles[i][j+1][k+4].xVar = k+4;
                        tiles[i][j+1][k+4].yVar = j+1;
                        tiles[i][j+1][k+4].zVar = i;
                    }
                    else if(i == 2 && (j<4) && (k<4) )
                    {
                        tiles[i][j+2][k+5] = t.deal();
                        tiles[i][j+2][k+5].xVar = k+5;
                        tiles[i][j+2][k+5].yVar = j+2;
                        tiles[i][j+2][k+5].zVar = i;
                    }
                    else if(i == 3 && (j<2) && (k<2) )
                    {
                        tiles[i][j+3][k+6] = t.deal();
                        tiles[i][j+3][k+6].xVar = k+6;
                        tiles[i][j+3][k+6].yVar = j+3;
                        tiles[i][j+3][k+6].zVar = i;
                    }
                    else if(i == 4 && (j<1) && (k<1) ) {
                        tiles[i][j + 3][k + 6] = t.deal();
                        tiles[i][j + 3][k + 6].xVar = k+6;
                        tiles[i][j + 3][k + 6].yVar = j+3;
                        tiles[i][j + 3][k + 6].zVar = i;
                    }
                }
            }
        }


        Tile tile2 = getTile(0, 3, 0);
        tile2.setLocation(70, (3 * 70) + 35);
        add(tile2);

        for(int i=4; i>=0; i--)
        {
            for(int j=7; j>=0; j--)
            {
                for(int k=0; k<15; k++)
                {
                    if(tiles[i][j][k] != null)
                    {
                        Tile tile1 = getTile(i, j, k);
                        tile1.addMouseListener(this);

                        if(i == 0 && j == 3 && (k == 13 || k ==14 ))
                        {
                            tile1.setLocation((k * 71 + 71) + (i * 20), (j * 70) + (i * -20) + 35);
                            tile1.xLoc = (k * 71 + 71) + (i * 20);
                            tile1.yLoc = (j * 70) + (i * -20) + 35;
                        }
                        else if(i == 0 && j == 3 && k == 0)
                        {
                            tile1.xLoc = (k * 71 + 71) + (i * 20);
                            tile1.yLoc = (j * 70) + (i * -20) + 35;
                            continue;
                        }
                        else if(i == 4)
                        {
                            tile1.setLocation((k * 71 + 105) + (i * 20), (j * 70) + (i * -20) + 35);
                            tile1.xLoc = (k * 71 + 105) + (i * 20);
                            tile1.yLoc = (j * 70) + (i * -20) + 35;
                        }
                        else
                        {
                            tile1.setLocation((k * 71 + 71) + (i * 20), (j * 70) + (i * -20));
                            tile1.xLoc = (k * 71 + 71) + (i * 20);
                            tile1.yLoc = (j * 70) + (i * -20);
                        }
                        add(tile1);
                    }
                }
            }
        }
        jPane.setSize(new Dimension(1200, 120));
        jPane.setLocation(0,600);
        jPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jPane.setViewportView(jp);
        add(jPane);
    }

    public Tile getTile(int layer, int row, int col)
    {
        return tiles[layer][row][col];
    }

    public void paintComponent(Graphics g)
    {
        URL url = MahJongBoard.class.getResource("images/dragon_bg.png");
        ImageIcon image = new ImageIcon(url);
        g.drawImage(image.getImage(), ((1200/ 2) - (image.getIconWidth()/2)),
                (600/ 2) - (image.getIconHeight()/2), this);
    }

    public void mousePressed(MouseEvent e) {
        Tile t = (Tile)e.getSource();

        if(model.isTileOpen(t.xVar, t.yVar, t.zVar))
        {
            if (first == null)
            {
                first = t;
                first.setBorder(selected);
            }

            else if (t == first)
            {
                first.setBorder(null);
                first = null;
            }

            if(first != null && t != first && second == null)
            {
                second = t;
                second.setBorder(selected);

            }

            else if (t == second)
            {
                second.setBorder(null);
                second = null;
            }

            if(first != null && second != null && first.matches(second))
            {
                second.setZOrder();
                remove(second);
                first.setZOrder();
                remove(first);
                first.setBorder(null);
                second.setBorder(null);
                model.board.tiles[first.zVar][first.yVar][first.xVar] = null;
                model.board.tiles[second.zVar][second.yVar][second.xVar] = null;
                removeStack.push(second);
                removeStack.push(first);
                jp.add(first,0);
                first = null;
                second = null;
                score += 2;
                startReward();
                if(soundOn == true)
                {
                    clip.play();
                }
            }
        }
        repaint();
    }

    private void startReward()
    {
        if (score < 144)
            return;

        reward = new Fireworks(this);
        reward.setSound(soundOn);
        reward.fire();
    }

    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}



}
