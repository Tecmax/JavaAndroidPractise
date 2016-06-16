package GUI;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JButton extends JFrame{
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton()
	{
		super("JButton");
		
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = this.getContentPane();
		con.add(panel);
		
		button.setMnemonic('p');
		panel.add(button);
		button.requestFocus();
		
		setVisible(true);		
	}
	private void setMnemonic(char c) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new JButton();
	}
}
