package bubblesort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Animator extends JComponent {
	static int n = 21;
	static int a[] = { 22,6,38,71,42,55,1,45,43,30,37,82,81,56,98,27,48,76,30,95,4};
	static int basey = 500;
	static int width = 20;
	int max=100;
	static int gab = 30;
	private static JPanel buttonsPanel;
	public static Animator comp;
	static int firstnum=0;
	static int secondnum=1;
	static int scale=500;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for (int i = 0; i < n; i++) {
			int k = a[i] * 10;
			int f=k*max/scale;
			g.setColor(Color.black);	
			g.drawString(a[i]+"", 10  * i*3 + gab, basey - f-10);
			g.drawRect(10 * 3 * i + gab, basey - f, width,f );
			if(i==firstnum||i==secondnum) {
				g.setColor(Color.yellow);
			}else {
				g.setColor(Color.blue);	
			}
			
			g.fillRect(10 * 3 * i + gab, basey - f, width, f);
		}

	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		comp = new Animator();
		comp.setPreferredSize(new Dimension(800, 800));
		testFrame.getContentPane().add(comp, BorderLayout.CENTER);
		testFrame.pack();
		testFrame.setVisible(true);
		comp.setFocusable(true);
		comp.revalidate();
		comp.setBackground(Color.BLUE);
		comp.repaint();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				for (int i = 0; i < n-1; i++) {
					for (int j = 0; j < n - i-1; j++) {
						firstnum=j;
						secondnum=j+1;
						if (a[j] > a[j + 1]) { // swap
							a[j] += a[j + 1];
							a[j + 1] = a[j] - a[j + 1];
							a[j] -= a[j + 1];
						}
						try {
							comp.revalidate();
							comp.repaint();	
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						
				}
				firstnum=-1;
				secondnum=-1;
				comp.revalidate();
				comp.repaint();	
				timer.cancel();
			}
		}, 100);
	}

}