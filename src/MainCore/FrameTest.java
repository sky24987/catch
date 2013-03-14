package MainCore;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import java.util.*;
public class FrameTest extends JFrame implements ActionListener { 
	public KeyAdapter kd = new KeyAdapter(){
		public void keyPressed(KeyEvent e) 
		{ 
			System.out.println("使用了键盘!----------"); 
		}
		public void keyReleased(KeyEvent e) { 
			System.out.println("释放了键盘!----------"); 
		} 
	};

	
	public FrameTest() { 
			Container cp = getContentPane(); 
			cp.setLayout(new FlowLayout()); 
			JButton jb = new JButton("Click"); 
			jb.addActionListener(this); cp.add(jb); 
			JTextField tf = new JTextField(10);
			cp.add(tf); 
			this.setFocusable(true);
			tf.addKeyListener(kd); 
			this.addKeyListener(kd); 
			this.setSize(300,180); 
			this.setTitle("FrameTest"); 
			setDefaultCloseOperation(EXIT_ON_CLOSE); 
			show(); 
			KeyEvent ke = new KeyEvent(this,1100,new Date().getTime(),0,KeyEvent.VK_WINDOWS,(char)KeyEvent.VK_WINDOWS); 
			this.kd.keyPressed(ke); ke = new KeyEvent(this,1100,new Date().getTime(),0,KeyEvent.VK_D,'D'); 
			this.kd.keyPressed(ke); } 
				public void actionPerformed(ActionEvent event) { 
				//JOptionPane.showMessageDialog(null,"按下了按钮!----------"); 
				KeyEvent ke = new KeyEvent(this,1100,new Date().getTime(),KeyEvent.VK_WINDOWS,KeyEvent.VK_D,'D'); 
				this.kd.keyPressed(ke);
				KeyEvent kup = new KeyEvent(this,1100,new Date().getTime(),KeyEvent.VK_WINDOWS,KeyEvent.VK_D,'D'); 
				this.kd.keyReleased(kup); 
		}
	public static void main(String[] args) { 
				FrameTest ft = new FrameTest();
				} 
} 
