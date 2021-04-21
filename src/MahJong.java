import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EmptyStackException;

public class MahJong extends JFrame
{
    public MahJongBoard board;
    private long gameNumber;

    public MahJong()
    {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {System.exit(0);}
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int)screenSize.getWidth()/2)-600, 0);
        setResizable(false);

        makeMenu();

        gameNumber = System.currentTimeMillis() % 1000000;
        this.setTitle("MahJong - Game Number: " + gameNumber);

        board = new MahJongBoard(this, gameNumber);
        add(board, BorderLayout.WEST);
        pack();
        setVisible(true);
    }

    public MahJong(Long gameNum)
    {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {System.exit(0);}
        });

        makeMenu();

        gameNumber = gameNum;
        this.setTitle("MahJong - Game Number: " + gameNumber);

        board = new MahJongBoard(this, gameNumber);
        add(board);
        pack();
        setVisible(true);

        add(new JScrollPane(), BorderLayout.EAST);
    }

    private void makeMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic('G');
        menuBar.add(gameMenu);

        JMenuItem play = new JMenuItem("Play", 'P');
        play.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
        gameMenu.add(play);
        play.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        {
            if(newGame())
            {
                setVisible(false);
                dispose();
                new MahJong();
            }
        }
        });

        JMenuItem restart = new JMenuItem("Restart", 'R');
        restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        gameMenu.add(restart);
        restart.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        {
            if(restartGame())
            {
                setVisible(false);
                dispose();
                new MahJong(gameNumber);
            }
        }
        });

        JMenuItem numbered = new JMenuItem("Numbered", 'N');
        numbered.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        gameMenu.add(numbered);
        numbered.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        {
            long gameInput = Long.parseLong(JOptionPane.showInputDialog("Enter a game number to play"));
            setVisible(false);
            dispose();
            new MahJong(gameInput);
        }
        });


        gameMenu.addSeparator();

        JMenuItem exit = new JMenuItem("Exit", 'E');
        exit.setToolTipText("Exit the program");
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        gameMenu.add(exit);
        exit.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        { if(exit())
            {
                System.exit(0);
            }
        }
        });

        ButtonGroup	soundGroup = new ButtonGroup();

        JMenu soundMenu = new JMenu("Sound");
        soundMenu.setMnemonic('S');
        menuBar.add(soundMenu);

        JRadioButtonMenuItem soundOn = new JRadioButtonMenuItem("On", true);
        soundGroup.add(soundOn);
        soundMenu.add(soundOn);
        soundOn.setToolTipText("Turn Sound On");
        soundOn.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        soundOn.setMnemonic('O');
        soundOn.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        { board.soundOn = true;}
        });

        JRadioButtonMenuItem soundOff = new JRadioButtonMenuItem("Off", false);
        soundGroup.add(soundOff);
        soundMenu.add(soundOff);
        soundOff.setToolTipText("Turn Sound Off");
        soundOff.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
        soundOff.setMnemonic('F');
        soundOff.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        { board.soundOn = false; }
        });

        JMenu moveMenu = new JMenu("Move");
        moveMenu.setMnemonic('M');
        menuBar.add(moveMenu);

        JMenuItem undo = new JMenuItem("Undo", 'U');
        undo.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
        moveMenu.add(undo);
        undo.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e) {
            try
            {
                Tile t1 = board.removeStack.pop();
                Tile t2 = board.removeStack.pop();
                t1.setLocation(t1.xLoc, t1.yLoc);
                board.add(t1, t1.getZOrder());
                board.add(t2, t2.getZOrder());
                if(board.score != 0)
                {
                    board.score -= 2;
                }
                revalidate();
                repaint();
            }
            catch (EmptyStackException es)
            {
            }
        }
        });


        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuBar.add(helpMenu);

        JMenuItem operation = new JMenuItem("Operation", 'O');
        operation.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        helpMenu.add(operation);
        operation.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        {   Help h2 = new Help("help/operations.html", "Game Operations");
            h2.display();
        }
        });

        JMenuItem rules = new JMenuItem("Game Rules", 'G');
        rules.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
        helpMenu.add(rules);
        rules.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
        {   Help h1 = new Help("help/rules.html", "Game Rules");
            h1.display();
        }
        });
    }

    public boolean newGame()
    {
        if(JOptionPane.showConfirmDialog(this, "Start a new game?", "New Game",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            return true;
        }
        return false;
    }

    public boolean restartGame()
    {
        if(JOptionPane.showConfirmDialog(this, "Restart game?", "Restart Game",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            return true;
        }
        return false;
    }

    public boolean exit()
    {
        if(JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the game?",
                "Exit Game", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MahJong m1 = new MahJong();
    }
}
