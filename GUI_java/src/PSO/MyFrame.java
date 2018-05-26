package PSO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Math;

//w razie problemow
//https://javastart.pl/baza-wiedzy/darmowy-kurs-java/grafika_awt_swing/zarzadzanie_rozkladem

public class MyFrame extends JFrame {
    JPanel Panel = new JPanel();

	public MyFrame() {
		super("PSO");
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);//to chyba renderuje
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//tworzenie wymiaru import dimension i toolkit
		int window_width=1000;
		int window_height=600;
		//setLocationRelativeTo(null);//ustawia okno na srodku
		setSize(1000,600);
		setLocation((screenSize.width-window_width)/2,(screenSize.height-window_height)/2);
				
		//add(new JButton("Start"));
		//add(new JButton("Przycisk 2"));
		//add(new JButton("Przycisk 3"));
		
		/*
		Container container = getContentPane();//tu tworzymy kontener i dodajemy do niego buttony w celu modykacji
		...
		container.add(new JButton("Przycisk 1"));
		container.add(new JButton("Przycisk 2"));
		container.add(new JButton("Przycisk 3"));
		*/
		//albo

		//Teraz przyda sie layout manager do modyfikacji buttonow
	}
	


	

}