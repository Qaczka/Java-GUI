package PSO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
    ArrayList<Point> points = new ArrayList<Point>();
    ArrayList<Point> points_temp;
    boolean woda=false;
	private int i=0, X, Y, numb_of_gen=0, nb_of_agents=100, panel_x=450, panel_y=25, Max=500, Min=0;
    private long m =2147483647, a = 16808, c = 0;
    private double x = 1,U = 0, C=0.6;
    private double F=Math.sqrt((1-C/2)/nb_of_agents);
    
	public MyPanel() {
		setPreferredSize(new Dimension(1000, 600));//wymiary panelu do rysowania
		this.setLayout(null);//null zeby ustawiac pozycje manualnie
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//tworzenie wymiaru import dimension i toolkit

		int window_width=1000;
		int window_height=600;
	    JButton startButton = new JButton("START");        
		
	    this.add(startButton);      
	    startButton.setBounds((screenSize.width)/2-window_width+100, (screenSize.height)/2-100, 100, 30);
	    
	    	while(numb_of_gen!=nb_of_agents)//czyli 40 liczb
	    	{
			GenRandPoint();
	    	}
	        System.out.println("F to: " + F);

	}
	
	public int GenRandNumb()
	{
		 x=(a*x+c)%m;
         U=(x/m)*500;
         return (int) U;
	}
	   
	
	public void GenRandPoint()
	{
        i++;
        
		 x=(a*x+c)%m;
         U=(x/m)*500;//to generuje liczbe z przedzialu 0-500
                  
         if(i%2==0)
         {
         X=(int) U;
         }
         else
         {
         Y=(int) U;
         this.points.add(new Point (X,Y));
         System.out.println("Dodaje " + X + " " + Y + " jest to " + ((i/2)+1) + " liczba.");
         numb_of_gen+=1;
         }
       }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(panel_x, panel_y, 500, 500);
		g2d.setColor(Color.RED);
		// prostokat
		//g2d.drawRect(10, 10, 380, 380);
		// kolo
		//g2d.drawOval(10, 10, 4, 4);
/*
		for(int i=0;i<120;i=i+4)
		{
		g2d.fillOval(panel_x+i, panel_y, 4, 4);
		}
		*/
		for(Point point: points)
		{
			g2d.fillOval(panel_x+point.x, panel_y+point.y, 4, 4);
			//System.out.println("Dziala " + point.x + " " + point.y);
		}
		/*
		if(woda==false)
		{
			g2d.fillOval(panel_x+380, panel_y+8, 10, 10);
			woda=true;
			System.out.println("Dziala");
		}
		else
		{
			//g2d.fillOval(panel_x+380, panel_y+8, 10, 10);
			woda=false;
		}
		*/
		points_temp=points;
		

        repaint();
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
