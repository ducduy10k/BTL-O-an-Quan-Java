package BTLJava;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MenuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtWellComeTo;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setTitle("\u00D4 \u0102n Quan");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\unnamed.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		unit();}
		public void unit() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		txtWellComeTo = new JTextField();
		txtWellComeTo.setBackground(new Color(255, 255, 0));
		txtWellComeTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtWellComeTo.setEditable(false);
		txtWellComeTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtWellComeTo.setText("Welcome to the OAnQuan game");
		getContentPane().add(txtWellComeTo, BorderLayout.NORTH);
		txtWellComeTo.setColumns(10);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		JButton btnNewButton_3 = new JButton("Play");
		btnNewButton_3.setToolTipText("Ch\u01A1i");
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(new Color(0, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AppGame a = new AppGame();
				a.setVisible(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("History");
		btnNewButton_4.setBackground(new Color(0, 255, 255));
		
		JButton btnNewButton_5 = new JButton("Exit");
		btnNewButton_5.setBackground(new Color(0, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnNewButton = new JButton("Option");
		btnNewButton.setBackground(new Color(240, 230, 140));
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(163)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
					.addGap(66)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(33))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_4)
					.addGap(18)
					.addComponent(btnNewButton_5)
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addGap(26))
		);
		panel.setLayout(gl_panel);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		setVisible(true);
	}

	public static void main(String[] args) {
   new MenuFrame();

	}


}
