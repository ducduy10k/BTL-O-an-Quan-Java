package BTLJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GraphicsFrame extends JPanel implements Runnable{
	public GraphicsFrame() {
		Thread thread=new Thread(this);
		thread.start() ;
	};
	public void paint(Graphics a) {
		a.setColor(Color.red);
		a.fillRect(0, 0, 1300, 800);
		ImageIcon img = new ImageIcon("src/BTL/background.jpg");
		
//a.drawImage(img, 500, 500, this);
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}











