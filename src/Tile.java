import java.awt.*;
import javax.swing.*;

public class Tile extends JPanel {
    public Color greenC = new Color(0, 205,0);
    public int xVar;
    public int yVar;
    public int zVar;
    public int zOrder;
    public int xLoc;
    public int yLoc;
    public boolean highlight = false;

    private	static	final	Dimension	SIZE;
    private	static	final	Polygon	    FACE;
    private	static	final	Polygon		SIDE;
    private static  final   Polygon     BSIDE;
    private	static	final	Polygon		BOTTOM;
    private	static	final	Polygon		BBOTTOM;

    private	static	final	GradientPaint	BSIDE_PAINT;
    private	static	final	GradientPaint	SIDE_PAINT;
    private	static	final	GradientPaint	BOTTOM_PAINT;
    private	static	final	GradientPaint	BBOTTOM_PAINT;
    private	static	final	GradientPaint	FACE_PAINT;



    public Tile()
    {
        setPreferredSize(SIZE);
        setSize(SIZE);
        setOpaque(false);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setStroke(new BasicStroke(2));
        g2.drawPolygon(SIDE);
        g2.drawPolygon(BSIDE);
        g2.drawPolygon(BOTTOM);
        g2.drawPolygon(BBOTTOM);
        g2.drawPolygon(FACE);

        g2.setPaint(BSIDE_PAINT);
        g2.fill(BSIDE);
        g2.setPaint(BBOTTOM_PAINT);
        g2.fill(BBOTTOM);
        g2.setPaint(FACE_PAINT);
        g2.fill(FACE);
        g2.setPaint(SIDE_PAINT);
        g2.fill(SIDE);
        g2.setPaint(BOTTOM_PAINT);
        g2.fill(BOTTOM);
        g2.setStroke(new BasicStroke(1));

//        if(highlight == true)
//        {
//            g2.setStroke(new BasicStroke(6));
//            g2.setColor(Color.RED);
//            g2.drawRect(21,1,70,70);
//            g2.setStroke(new BasicStroke(1));
//        }
    }


    public boolean matches(Tile other)
    {
        if(other == null)
        {
            return false;
        }

        if(this == other)
        {
            return false;
        }

        if(getClass() == other.getClass())
        {
            return true;
        }

        return false;
    }

    static
    {
        SIZE = new Dimension(92, 90);

        int[] xs = { 10, 20, 20, 10 };
        int[] ys = { 11, 1, 71, 81 };
        SIDE = new Polygon(xs, ys, 4);

        int[] xbs = { 1, 11, 11, 1 };
        int[] ybs = { 20, 10, 80, 90 };
        BSIDE = new Polygon(xbs, ybs, 4);

        int[] xb = { 21, 90, 80, 11 };
        int[] yb = { 72, 72, 82, 82 };
        BOTTOM = new Polygon(xb, yb, 4);

        int[] xbb = { 11, 81, 71, 1 };
        int[] ybb = { 81, 81, 91, 91 };
        BBOTTOM = new Polygon(xbb, ybb, 4);

        int[] xf = { 21, 91, 91, 21 };
        int[] yf = { 1, 1, 71, 71 };
        FACE = new Polygon(xf, yf,4);

        Color c1 = new Color(0,238, 0);
        Color c2 = new Color(0,28, 0);
        Color c3 = new Color(255,255,240);
        Color c4 = new Color(205,205,193);
        BSIDE_PAINT = new GradientPaint(0, 90, c1, 90, 0, c2);
        BBOTTOM_PAINT = new GradientPaint(0, 90, c1, 90, 0, c2);
        FACE_PAINT = new GradientPaint(0, 90, c3, 90, 0, c4);
        SIDE_PAINT = new GradientPaint(0, 90, c3, 90, 0, c4);
        BOTTOM_PAINT = new GradientPaint(0, 90, c3, 90, 0, c4);
    }

    public int getXVar()
    {
        return xVar;
    }

    public int getYVar(){return yVar;}

    public void setZOrder()
    {
        zOrder = getParent().getComponentZOrder(this);
    }

    public void resetZOrder()
    {
        getParent().setComponentZOrder(this, zOrder);
    }

    public int getZOrder()
    {
        return zOrder;
    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");

        frame.add(new Tile());

        frame.pack();
        frame.setVisible(true);
    }
}