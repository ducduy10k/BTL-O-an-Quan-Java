package BTLJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AppGame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OAnQuan a = new OAnQuan();
	private JPanel contentPane;
	private JTextField textField_A;
	private JTextField textField_B;

	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	// private JTextField textField_12;
	// private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_0;
	private JTextField txtNote;
	// private String chon;
	private JRadioButton rdoA;
	private JRadioButton rdoB;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					AppGame frame = new AppGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppGame( ) {
		setTitle("Ô ăn quan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 624);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);

		rdoA = new JRadioButton("Người chơi A");
		rdoA.setToolTipText("");
		rdoA.setBackground(new Color(255, 255, 255));
		rdoA.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoA.setForeground(Color.BLACK);
		rdoA.setSelected(true);
		buttonGroup.add(rdoA);
		panel.add(rdoA);

		textField_A = new JTextField();
		textField_A.setHorizontalAlignment(SwingConstants.CENTER);
		textField_A.setBackground(new Color(127, 255, 0));
		textField_A.setToolTipText("Điểm của người chơi A");
		textField_A.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_A.setEditable(false);
		textField_A.setEnabled(false);
		panel.add(textField_A);
		textField_A.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		rdoB = new JRadioButton("Người chơi B");
		rdoB.setBackground(new Color(255, 255, 255));
		rdoB.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoB.setForeground(Color.BLACK);
		buttonGroup.add(rdoB);
		panel_1.add(rdoB);

		textField_B = new JTextField();
		textField_B.setHorizontalAlignment(SwingConstants.CENTER);
		textField_B.setBackground(Color.CYAN);
		textField_B.setToolTipText("Điểm của người chơi B");
		textField_B.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_B.setEditable(false);
		textField_B.setEnabled(false);
		panel_1.add(textField_B);
		textField_B.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		contentPane.add(panel_2, BorderLayout.WEST);

		JButton Left = new JButton("Left");
		Left.setToolTipText("Trái");

		JButton Right = new JButton("Right");
		Right.setToolTipText("Phải");

		textField_14 = new JTextField();
		textField_14.setToolTipText("Ô di chuyển");
		textField_14.setColumns(10);

		lblNewLabel_1 = new JLabel("Ch\u1ECDn \u00F4");

		txtNote = new JTextField();
		txtNote.setEditable(false);
		txtNote.setHorizontalAlignment(SwingConstants.CENTER);
		txtNote.setToolTipText("Chú Ý");
		txtNote.setForeground(Color.DARK_GRAY);
		txtNote.setColumns(10);

		txtNote.setFont(new Font("Dialog", Font.PLAIN, 14));

		JButton Exitbt = new JButton("Exit");
		Exitbt.setToolTipText("Thoát Game");
		Exitbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int click = JOptionPane.showConfirmDialog(null, "Do you want exit", "Exit", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JButton btnRestart = new JButton("Restart");
		btnRestart.setToolTipText("Khởi động lại");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.create();
				rdoA.setSelected(true);
				String s0;
				String s1;
				String s2;
				String s3;
				String s4;
				String s5;
				String s6;
				String s7;
				String s8;
				String s9;
				String s10;
				String s11;
				String s12;
				String s13;
				s0 = String.valueOf(a.getGameA(0).getValue());
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				s6 = String.valueOf(a.getGameA(6).getValue());
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				s12 = String.valueOf(a.getKq1());
				s13 = String.valueOf(a.getKq2());
				textField_0.setText(s0);
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);
				textField_6.setText(s6);
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
				textField_14.setText(null);
				textField_A.setText(s12);
				textField_B.setText(s13);
			}
		});

		btnMainMenu = new JButton("Main menu");
		btnMainMenu.setToolTipText("Quay lại Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MenuFrame();

			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRestart)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(Left)
									.addGap(28)
									.addComponent(Right))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnMainMenu)
								.addComponent(Exitbt))
							.addGap(38))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addGap(12)
							.addComponent(txtNote)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(Left)
						.addComponent(Right))
					.addGap(29)
					.addComponent(txtNote, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRestart)
					.addGap(11)
					.addComponent(btnMainMenu)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Exitbt)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		textField_0 = new JTextField();
		textField_0.setBackground(new Color(255, 228, 181));
		textField_0.setEditable(false);
		textField_0.setForeground(new Color(220, 20, 60));
		textField_0.setHorizontalAlignment(SwingConstants.CENTER);
		textField_0.setText("10");
		textField_0.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_4.add(textField_0, BorderLayout.WEST);
		textField_0.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 218, 185));
		textField_6.setEditable(false);
		textField_6.setForeground(new Color(199, 21, 133));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText("10");
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_4.add(textField_6, BorderLayout.EAST);
		textField_6.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.ORANGE);
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("5");
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2 = new JTextField();
		textField_2.setBackground(Color.ORANGE);
		textField_2.setEditable(false);
		textField_2.setText("5");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3 = new JTextField();
		textField_3.setBackground(Color.ORANGE);
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("5");
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_4 = new JTextField();
		textField_4.setBackground(Color.ORANGE);
		textField_4.setEditable(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText("5");
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5 = new JTextField();
		textField_5.setBackground(Color.ORANGE);
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText("5");
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_11 = new JTextField();
		textField_11.setBackground(Color.ORANGE);
		textField_11.setEditable(false);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setText("5");
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		// textField_13 = new JTextField();
		// textField_12 = new JTextField();
		textField_10 = new JTextField();
		textField_10.setBackground(Color.ORANGE);
		textField_10.setEditable(false);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setText("5");
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_9 = new JTextField();
		textField_9.setBackground(Color.ORANGE);
		textField_9.setEditable(false);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setText("5");
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_8 = new JTextField();
		textField_8.setBackground(Color.ORANGE);
		textField_8.setEditable(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setText("5");
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_7 = new JTextField();
		textField_7.setBackground(Color.ORANGE);
		textField_7.setEditable(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText("5");
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(2, 5));
		panel_5.add(textField_1);
		panel_5.add(textField_2);
		panel_5.add(textField_3);
		panel_5.add(textField_4);
		panel_5.add(textField_5);
		panel_5.add(textField_11);
		panel_5.add(textField_10);
		panel_5.add(textField_9);
		panel_5.add(textField_8);
		panel_5.add(textField_7);
		this.a.create();
		this.a.setFlag(0);
		Left.addActionListener(this);
		Right.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = e.getActionCommand();
		// Object source = e.getSource();
		String s0;
		String s1;
		String s2;
		String s3;
		String s4;
		String s5;
		String s6;
		String s7;
		String s8;
		String s9;
		String s10;
		String s11;
		String s12;
		String s13;
		String c = textField_14.getText();
		// String c = ChonO.getModel().getElementAt(1);
		int v02 = Integer.parseInt(c);
		if (v02 > 5 || v02 < 1) {
			txtNote.setText("Số liệu nhập không hợp lệ");
			textField_14.setText(null);
		} else {
			if (a.getFlag() == 0 && a.getGameA(Integer.parseInt(c)).getValue() == 0) {
				txtNote.setText("Ô không có quân");
				textField_14.setText(null);
			} else {
				if (a.getFlag() == 1 && a.getGameA(12 - Integer.parseInt(c)).getValue() == 0) {
					txtNote.setText("Ô không có quân");
					textField_14.setText(null);
				} else
					txtNote.setText("");
			}
		}
		String b = textField_14.getText();
		int v01 = Integer.parseInt(b);
		int v03 = 6 - v01;
		int t = a.getFlag();
		if ("right".equalsIgnoreCase(name)) {
			if (t == 0) {
				a.PlayA(v01, "r");
				// String s=String.valueOf(a.getGameA(1).getValue());
				// textField_4.setText(s);
				s0 = String.valueOf(a.getGameA(0).getValue());
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				s6 = String.valueOf(a.getGameA(6).getValue());
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				s12 = String.valueOf(a.getKq1());
				s13 = String.valueOf(a.getKq2());
				textField_0.setText(s0);
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);
				textField_6.setText(s6);
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
				textField_14.setText(null);
				textField_A.setText(s12);
				textField_B.setText(s13);
				a.setFlag(1);
				Double a1 = Double.parseDouble(textField_A.getText());
				Double a2 = Double.parseDouble(textField_B.getText());
				rdoB.setSelected(true);
				if (a.getGameA(0).getValue() == 0 && a.getGameA(6).getValue() == 0) {
					if (a1 > a2) {
						int click = JOptionPane.showConfirmDialog(null, "Play A win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					} else {
						int click = JOptionPane.showConfirmDialog(null, "Play B win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					}
				}
				a.CheckGameB();
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
			}
		}
		if ("right".equalsIgnoreCase(name)) {
			if (t == 1) {
				a.PlayB(v03, "r");
				// String s=String.valueOf(a.getGameA(1).getValue());
				// textField_4.setText(s);
				s0 = String.valueOf(a.getGameA(0).getValue());
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				s6 = String.valueOf(a.getGameA(6).getValue());
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				s12 = String.valueOf(a.getKq1());
				s13 = String.valueOf(a.getKq2());
				textField_0.setText(s0);
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);
				textField_6.setText(s6);
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
				textField_14.setText(null);
				textField_A.setText(s12);
				textField_B.setText(s13);
				a.setFlag(0);
				Double a1 = Double.parseDouble(textField_A.getText());
				Double a2 = Double.parseDouble(textField_B.getText());
				rdoA.setSelected(true);
				if (a.getGameA(0).getValue() == 0 && a.getGameA(6).getValue() == 0) {
					if (a1 > a2) {
						int click = JOptionPane.showConfirmDialog(null, "Play A win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					} else {
						int click = JOptionPane.showConfirmDialog(null, "Play B win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							
							setVisible(false);
							new MenuFrame();
						}
					}
				}	
				a.CheckGameA();
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);		
			}
		}
		if ("left".equalsIgnoreCase(name)) {
			if (t == 0) {
				a.PlayA(v01, "l");
				// String s=String.valueOf(a.getGameA(1).getValue());
				// textField_4.setText(s);
				s0 = String.valueOf(a.getGameA(0).getValue());
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				s6 = String.valueOf(a.getGameA(6).getValue());
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				s12 = String.valueOf(a.getKq1());
				s13 = String.valueOf(a.getKq2());
				textField_0.setText(s0);
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);
				textField_6.setText(s6);
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
				textField_14.setText(null);
				textField_A.setText(s12);
				textField_B.setText(s13);
				a.setFlag(1);
				Double a1 = Double.parseDouble(textField_A.getText());
				Double a2 = Double.parseDouble(textField_B.getText());
				rdoB.setSelected(true);
				if (a.getGameA(0).getValue() == 0 && a.getGameA(6).getValue() == 0) {
					if (a1 > a2) {
						int click = JOptionPane.showConfirmDialog(null, "Play A win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					} else {
						int click = JOptionPane.showConfirmDialog(null, "Play B win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					}
				}
				a.CheckGameB();
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
			}
		}
		if ("left".equalsIgnoreCase(name)) {
			if (t == 1) {
				a.PlayB(v03, "l");
				// String s=String.valueOf(a.getGameA(0));
				// textField_4.setText(s);
				s0 = String.valueOf(a.getGameA(0).getValue());
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				s6 = String.valueOf(a.getGameA(6).getValue());
				s7 = String.valueOf(a.getGameA(7).getValue());
				s8 = String.valueOf(a.getGameA(8).getValue());
				s9 = String.valueOf(a.getGameA(9).getValue());
				s10 = String.valueOf(a.getGameA(10).getValue());
				s11 = String.valueOf(a.getGameA(11).getValue());
				s12 = String.valueOf(a.getKq1());
				s13 = String.valueOf(a.getKq2());
				textField_0.setText(s0);
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);
				textField_6.setText(s6);
				textField_7.setText(s7);
				textField_8.setText(s8);
				textField_9.setText(s9);
				textField_10.setText(s10);
				textField_11.setText(s11);
				textField_14.setText(null);
				textField_A.setText(s12);
				textField_B.setText(s13);
				Double a1 = Double.parseDouble(textField_A.getText());
				Double a2 = Double.parseDouble(textField_B.getText());
				a.setFlag(0);
				rdoA.setSelected(true);
				if (a.getGameA(0).getValue() == 0 && a.getGameA(6).getValue() == 0) {
					if (a1 > a2) {
						int click = JOptionPane.showConfirmDialog(null, "Play A win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					} else {
						int click = JOptionPane.showConfirmDialog(null, "Play B win , Play again?", "End Game",
								JOptionPane.YES_OPTION);
						if (click == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						if(click==JOptionPane.YES_OPTION) {
							setVisible(false);
							new MenuFrame();
						}
					}
				}
				a.CheckGameA();
				s1 = String.valueOf(a.getGameA(1).getValue());
				s2 = String.valueOf(a.getGameA(2).getValue());
				s3 = String.valueOf(a.getGameA(3).getValue());
				s4 = String.valueOf(a.getGameA(4).getValue());
				s5 = String.valueOf(a.getGameA(5).getValue());
				textField_1.setText(s1);
				textField_2.setText(s2);
				textField_3.setText(s3);
				textField_4.setText(s4);
				textField_5.setText(s5);		
			}
		}
	}
}// end
