package figure.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import figure.model.Rettangolo;

public class MainWindow extends JFrame {
	
	//public static int somma(int a, int b) {return a+b;}
	
	Rettangolo rett;
	Color color = Color.PINK;
	boolean isRunning;
	JPanel panel;
	
	public MainWindow() {
		//System.out.println(this.somma(10,5));
		rett = new Rettangolo(10, 10, 200, 100);
		setSize(500,500);
		setTitle("Figure Geometriche");
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				//g.setColor(Color.PINK);
				g.setColor(color);
				//g.setColor(new Color(200,255,200));
				g.fillRect(rett.getX(), rett.getY(), rett.getBase(), rett.getAltezza());
			}
		};
		add(panel);
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
					rett.setX(rett.getX()+5);
				} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
					rett.setX(rett.getX()-5);
				}
				panel.repaint();
				panel.invalidate();
				repaint();
				invalidate();
			}
		});
		Thread t = new Thread() {
			@Override
			public void run() {
				boolean dirDx = true;
				isRunning=true;
				while (true) {
					//for (int i=0; i<1000000; i++);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (rett.getX()>=getWidth()-5) {
						//rett.setX(0);
						dirDx=false;
					}
					if (rett.getX()<0) {
						//rett.setX(0);
						dirDx=true;
					}
					if (isRunning) {	
						rett.setX(rett.getX()+ (dirDx ? 5 : -5));
					}
					panel.repaint();
					panel.invalidate();
					repaint();
					invalidate();
				}
			}
		};
		t.start();
		
		setLayout(null);
		JButton button = new JButton("Cliccami!");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainWindow.this, "Hello, World!");
				if (color == Color.PINK) {
					color = Color.BLUE;
				} else {
					color = Color.PINK;
				}
				panel.repaint();
				panel.invalidate();
				repaint();
				invalidate();
			}
		});
		button.setSize(100,50);
		button.setLocation(10, 400);
		panel.setSize(400,400);
		add(button);
		
		JButton button2 = new JButton("STOP");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isRunning) {
					isRunning=false;
					button2.setText("PLAY");
				} else {
					isRunning=true;
					button2.setText("STOP");
				}
			}
		});
		button2.setSize(100,50);
		button2.setLocation(120, 400);
		add(button2);
		
		MyKeyListener keyListener = new MyKeyListener(this);
		button.addKeyListener(keyListener);
		button2.addKeyListener(keyListener);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}





class MyKeyListener implements KeyListener {
	
	private MainWindow mainWindow;
	
	public MyKeyListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			mainWindow.rett.setX(mainWindow.rett.getX()+5);
		} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			mainWindow.rett.setX(mainWindow.rett.getX()-5);
		}
		mainWindow.panel.repaint();
		mainWindow.panel.invalidate();
		mainWindow.repaint();
		mainWindow.invalidate();
	}
	
}







