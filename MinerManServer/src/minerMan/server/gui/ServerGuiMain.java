package minerMan.server.gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ServerGuiMain extends JFrame {
	List<String> conn = new ArrayList<String>();
	String conns="";
	private JLabel lab1;
	public ServerGuiMain(int width, int height){
		lab1 = new JLabel("1");
		this.setSize(width, height);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		lab1.setBounds(0, 0, 100, 100);
		//this.add(lab1);
		
		
	}
	
	public void onUpdate(String i){
		this.conns=i;
		this.repaint();
		System.out.println("onupdate");
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawString(this.conns, 100, 100);
		System.out.println("painted");
	}

}
