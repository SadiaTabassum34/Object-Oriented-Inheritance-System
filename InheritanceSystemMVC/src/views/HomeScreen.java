package views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JCheckBox;




import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.DistributeShares;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class HomeScreen extends Screen {

	private JFrame frame;
	private JTextField textFieldDaughters;
	private JTextField textFieldSons;
	private JTextField textFieldSisters;
	private JTextField textFieldGrandSons;
	private JTextField textFieldGrandDaughters;
	private JTextField textFieldBrothers;
	private JTextField textFieldNephews;
	private JTextField textFieldSonsOfNephews;
	private JTextField textFieldUncles;
	private JTextField textFieldSonsOfUncles;
	private JTextField textFieldTotalShares;
	private JTextField textFieldBequestShares;

	/**
	 * Launch the application.
	 */
	public void takeListOfHeirs() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Inheritence System");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(0, 0, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(36, 292, 242, 300);
		Image img=new ImageIcon(this.getClass().getResource("/inheritance.jfif")).getImage();
		Image img1=img.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
		lblimage.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(lblimage);
		
		JComboBox<String> comboBoxNumberOfWives = new JComboBox<String>();
		comboBoxNumberOfWives.setEditable(false);
		comboBoxNumberOfWives.setForeground(Color.RED);
		comboBoxNumberOfWives.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxNumberOfWives.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4"}));
		comboBoxNumberOfWives.setBounds(459, 334, 163, 21);
		comboBoxNumberOfWives.setEnabled(false);
		frame.getContentPane().add(comboBoxNumberOfWives);
		
		JCheckBox chckbxWives = new JCheckBox("Wives");
		JCheckBox chckbxHusband = new JCheckBox("Husband");
		chckbxHusband.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					chckbxWives.setEnabled(false);
					comboBoxNumberOfWives.setEnabled(false);
					
				}
				else {
					chckbxWives.setEnabled(true);
					//comboBoxNumberOfWives.setEnabled(true);
				}
			}
		});
		chckbxHusband.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxHusband.setBounds(311, 292, 121, 21);
		frame.getContentPane().add(chckbxHusband);
		
		chckbxWives.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					chckbxHusband.setEnabled(false);
					comboBoxNumberOfWives.setEnabled(true);
				}
				else {
					chckbxHusband.setEnabled(true);
					comboBoxNumberOfWives.setEnabled(false);
				}
			}
		});
		chckbxWives.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxWives.setBounds(312, 332, 99, 21);
		frame.getContentPane().add(chckbxWives);
		
		textFieldDaughters = new JTextField();
		textFieldDaughters.setEnabled(false);
		textFieldDaughters.setText("1");
		textFieldDaughters.setBounds(459, 376, 163, 19);
		frame.getContentPane().add(textFieldDaughters);
		textFieldDaughters.setColumns(10);
		
		JCheckBox chckbxDaughters = new JCheckBox("Daughters");
		chckbxDaughters.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldDaughters.setEnabled(true);
				}
				else {
					textFieldDaughters.setEnabled(false);
				}
			}
		});
		chckbxDaughters.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxDaughters.setBounds(311, 371, 141, 21);
		frame.getContentPane().add(chckbxDaughters);
		
		textFieldSons = new JTextField();
		textFieldSons.setEnabled(false);
		textFieldSons.setText("1");
		textFieldSons.setColumns(10);
		textFieldSons.setBounds(459, 420, 163, 19);
		frame.getContentPane().add(textFieldSons);
		
		JCheckBox chckbxSons = new JCheckBox("Sons");
		chckbxSons.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldSons.setEnabled(true);
				}
				else {
					textFieldSons.setEnabled(false);
				}
			}
		});
		chckbxSons.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxSons.setBounds(311, 418, 121, 21);
		frame.getContentPane().add(chckbxSons);
		
		JCheckBox chckbxFather = new JCheckBox("Father");
		chckbxFather.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxFather.setBounds(311, 464, 121, 21);
		frame.getContentPane().add(chckbxFather);
		
		JCheckBox chckbxGrandFather = new JCheckBox("Father's Father");
		chckbxGrandFather.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxGrandFather.setBounds(311, 501, 204, 21);
		frame.getContentPane().add(chckbxGrandFather);
		
		JLabel lblNewLabel = new JLabel("Inheritance System");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(650, 29, 400, 49);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblTopImage = new JLabel("");
		lblTopImage.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTopImage.setBounds(10, 10, 1466, 106);
		Image imgTop=new ImageIcon(this.getClass().getResource("/top.jpg")).getImage();
		Image img1Top=imgTop.getScaledInstance(lblTopImage.getWidth(), lblTopImage.getHeight(), Image.SCALE_SMOOTH);
		lblTopImage.setIcon(new ImageIcon(img1Top));
		frame.getContentPane().add(lblTopImage);
		
		JCheckBox chckbxPaternalGrandMother = new JCheckBox("Father's Mother");
		chckbxPaternalGrandMother.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxPaternalGrandMother.setBounds(311, 540, 204, 21);
		frame.getContentPane().add(chckbxPaternalGrandMother);
		
		JCheckBox chckbxMother = new JCheckBox("Mother");
		chckbxMother.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxMother.setBounds(311, 577, 204, 21);
		frame.getContentPane().add(chckbxMother);
		
		JCheckBox chckbxMaternalGrandMother = new JCheckBox("Mother's Mother");
		chckbxMaternalGrandMother.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxMaternalGrandMother.setBounds(311, 612, 204, 21);
		frame.getContentPane().add(chckbxMaternalGrandMother);
		
		textFieldSisters = new JTextField();
		textFieldSisters.setEnabled(false);
		textFieldSisters.setText("1");
		textFieldSisters.setColumns(10);
		textFieldSisters.setBounds(1195, 453, 163, 19);
		frame.getContentPane().add(textFieldSisters);
		
		JCheckBox chckbxSisters = new JCheckBox("Sisters");
		chckbxSisters.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldSisters.setEnabled(true);
				}
				else {
					textFieldSisters.setEnabled(false);
				}
			}
		});
		chckbxSisters.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxSisters.setBounds(906, 450, 121, 21);
		frame.getContentPane().add(chckbxSisters);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.ORANGE);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(288, 288, 13, 319);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.RED);
		separator_1.setBounds(20, 605, 268, 13);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.RED);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(894, 292, 2, 363);
		frame.getContentPane().add(separator_2);
		
		textFieldGrandSons = new JTextField();
		textFieldGrandSons.setEnabled(false);
		textFieldGrandSons.setText("1");
		textFieldGrandSons.setColumns(10);
		textFieldGrandSons.setBounds(1195, 330, 163, 19);
		frame.getContentPane().add(textFieldGrandSons);
		
		JCheckBox chckbxGrandSons = new JCheckBox("Sons' Sons");
		chckbxGrandSons.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldGrandSons.setEnabled(true);
				}
				else {
					textFieldGrandSons.setEnabled(false);
				}
			}
		});
		chckbxGrandSons.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxGrandSons.setBounds(906, 327, 149, 21);
		frame.getContentPane().add(chckbxGrandSons);
		
		textFieldGrandDaughters = new JTextField();
		textFieldGrandDaughters.setEnabled(false);
		textFieldGrandDaughters.setText("1");
		textFieldGrandDaughters.setColumns(10);
		textFieldGrandDaughters.setBounds(1195, 370, 163, 19);
		frame.getContentPane().add(textFieldGrandDaughters);
		
		JCheckBox chckbxGrandDaughters = new JCheckBox("Sons' Daughters");
		chckbxGrandDaughters.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldGrandDaughters.setEnabled(true);
				}
				else {
					textFieldGrandDaughters.setEnabled(false);
				}
			}
		});
		chckbxGrandDaughters.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxGrandDaughters.setBounds(906, 367, 204, 21);
		frame.getContentPane().add(chckbxGrandDaughters);
		
		textFieldBrothers = new JTextField();
		textFieldBrothers.setEnabled(false);
		textFieldBrothers.setText("1");
		textFieldBrothers.setColumns(10);
		textFieldBrothers.setBounds(1195, 415, 163, 19);
		frame.getContentPane().add(textFieldBrothers);
		
		JCheckBox chckbxBrothers = new JCheckBox("Brothers");
		chckbxBrothers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldBrothers.setEnabled(true);
				}
				else {
					textFieldBrothers.setEnabled(false);
				}
			}
		});
		chckbxBrothers.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxBrothers.setBounds(906, 412, 149, 21);
		frame.getContentPane().add(chckbxBrothers);
		
		textFieldNephews = new JTextField();
		textFieldNephews.setEnabled(false);
		textFieldNephews.setText("1");
		textFieldNephews.setColumns(10);
		textFieldNephews.setBounds(1195, 499, 163, 19);
		frame.getContentPane().add(textFieldNephews);
		
		JCheckBox chckbxNephews = new JCheckBox("Brothers' Sons");
		chckbxNephews.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldNephews.setEnabled(true);
				}
				else {
					textFieldNephews.setEnabled(false);
				}
			}
		});
		chckbxNephews.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxNephews.setBounds(906, 496, 176, 21);
		frame.getContentPane().add(chckbxNephews);
		
		textFieldSonsOfNephews = new JTextField();
		textFieldSonsOfNephews.setEnabled(false);
		textFieldSonsOfNephews.setText("1");
		textFieldSonsOfNephews.setColumns(10);
		textFieldSonsOfNephews.setBounds(1195, 539, 163, 19);
		frame.getContentPane().add(textFieldSonsOfNephews);
		
		JCheckBox chckbxSonsOfNephews = new JCheckBox("Sons of Brothers' Sons");
		chckbxSonsOfNephews.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldSonsOfNephews.setEnabled(true);
				}
				else {
					textFieldSonsOfNephews.setEnabled(false);
				}
			}
		});
		chckbxSonsOfNephews.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxSonsOfNephews.setBounds(906, 536, 253, 21);
		frame.getContentPane().add(chckbxSonsOfNephews);
		
		textFieldSonsOfUncles = new JTextField();
		textFieldSonsOfUncles.setEnabled(false);
		textFieldSonsOfUncles.setText("1");
		textFieldSonsOfUncles.setColumns(10);
		textFieldSonsOfUncles.setBounds(1195, 612, 163, 19);
		frame.getContentPane().add(textFieldSonsOfUncles);
		
		JCheckBox chckbxSonsOfUncles = new JCheckBox("Sons of Father's Brothers");
		chckbxSonsOfUncles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldSonsOfUncles.setEnabled(true);
				}
				else {
					textFieldSonsOfUncles.setEnabled(false);
				}
			}
		});
		chckbxSonsOfUncles.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxSonsOfUncles.setBounds(906, 612, 283, 21);
		frame.getContentPane().add(chckbxSonsOfUncles);
		
		textFieldUncles = new JTextField();
		textFieldUncles.setEnabled(false);
		textFieldUncles.setText("1");
		textFieldUncles.setColumns(10);
		textFieldUncles.setBounds(1195, 572, 163, 19);
		frame.getContentPane().add(textFieldUncles);
		
		JCheckBox chckbxUncles = new JCheckBox("Father's Brothers");
		chckbxUncles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					textFieldUncles.setEnabled(true);
				}
				else {
					textFieldUncles.setEnabled(false);
				}
			}
		});
		chckbxUncles.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxUncles.setBounds(906, 572, 216, 21);
		frame.getContentPane().add(chckbxUncles);
		
		JLabel lblTotal = new JLabel("Total Shares of Deceased      :");
		lblTotal.setBackground(new Color(139, 0, 139));
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotal.setBounds(482, 126, 304, 30);
		frame.getContentPane().add(lblTotal);
		
		textFieldTotalShares = new JTextField();
		textFieldTotalShares.setText("100");
		textFieldTotalShares.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldTotalShares.setBounds(796, 126, 99, 29);
		frame.getContentPane().add(textFieldTotalShares);
		textFieldTotalShares.setColumns(10);
		
		JLabel lblTk = new JLabel("TK.");
		lblTk.setForeground(Color.RED);
		lblTk.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTk.setBackground(new Color(139, 0, 139));
		lblTk.setBounds(908, 126, 52, 30);
		frame.getContentPane().add(lblTk);
		
		JLabel lblBequestSharesOf = new JLabel("Bequest Shares of Deceased :");
		lblBequestSharesOf.setForeground(Color.RED);
		lblBequestSharesOf.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBequestSharesOf.setBackground(new Color(139, 0, 139));
		lblBequestSharesOf.setBounds(482, 166, 304, 30);
		frame.getContentPane().add(lblBequestSharesOf);
		
		textFieldBequestShares = new JTextField();
		textFieldBequestShares.setText("0");
		textFieldBequestShares.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldBequestShares.setColumns(10);
		textFieldBequestShares.setBounds(796, 166, 99, 29);
		frame.getContentPane().add(textFieldBequestShares);
		
		JLabel lblTk_1 = new JLabel("TK.");
		lblTk_1.setForeground(Color.RED);
		lblTk_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTk_1.setBackground(new Color(139, 0, 139));
		lblTk_1.setBounds(908, 166, 52, 30);
		frame.getContentPane().add(lblTk_1);
		
		JLabel lblSelectLiveHeirs = new JLabel("Select Live Heirs of Deceased");
		lblSelectLiveHeirs.setForeground(new Color(210, 105, 30));
		lblSelectLiveHeirs.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSelectLiveHeirs.setBackground(new Color(139, 0, 139));
		lblSelectLiveHeirs.setBounds(540, 236, 481, 30);
		frame.getContentPane().add(lblSelectLiveHeirs);
		
		JButton btnDistribute = new JButton("Distribute");
		btnDistribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double effectiveShares=Double.parseDouble(textFieldTotalShares.getText())-Double.parseDouble(textFieldBequestShares.getText());
				ArrayList<String> list=new ArrayList<String>();
				ArrayList<Integer> number=new ArrayList<Integer>();
				//System.out.println(effectiveShares);
				if(chckbxHusband.isSelected()) {
					list.add("husband");
					number.add(1);
				}
				if(chckbxWives.isSelected()) {
					list.add("wives");
					number.add(Integer.parseInt(comboBoxNumberOfWives.getSelectedItem().toString()));
				}
				if(chckbxSons.isSelected()) {
					list.add("sons");
					number.add(Integer.parseInt(textFieldSons.getText()));
				}
				if(chckbxDaughters.isSelected()) {
					list.add("daughters");
					number.add(Integer.parseInt(textFieldDaughters.getText()));
				}
				if(chckbxFather.isSelected()) {
					list.add("father");
					number.add(1);
				}
				if(chckbxGrandFather.isSelected()) {
					list.add("father's father");
					number.add(1);
				}
				if(chckbxPaternalGrandMother.isSelected()) {
					list.add("father's mother");
					number.add(1);
				}
				if(chckbxMother.isSelected()) {
					list.add("mother");
					number.add(1);
				}
				if(chckbxMaternalGrandMother.isSelected()) {
					list.add("mother's mother");
					number.add(1);
				}
				if(chckbxGrandSons.isSelected()) {
					list.add("son's sons");
					number.add(Integer.parseInt(textFieldGrandSons.getText()));
				}
				if(chckbxGrandDaughters.isSelected()) {
					list.add("son's daughters");
					number.add(Integer.parseInt(textFieldGrandDaughters.getText()));
				}
				if(chckbxBrothers.isSelected()) {
					list.add("brothers");
					number.add(Integer.parseInt(textFieldBrothers.getText()));
				}
				if(chckbxSisters.isSelected()) {
					list.add("sisters");
					number.add(Integer.parseInt(textFieldSisters.getText()));
				}
				if(chckbxNephews.isSelected()) {
					list.add("brother's sons");
					number.add(Integer.parseInt(textFieldNephews.getText()));
				}
				if(chckbxSonsOfNephews.isSelected()) {
					list.add("sons of brother's sons");
					number.add(Integer.parseInt(textFieldSonsOfNephews.getText()));
				}
				if(chckbxUncles.isSelected()) {
					list.add("fathers's brothers");
					number.add(Integer.parseInt(textFieldUncles.getText()));
				}
				if(chckbxSonsOfUncles.isSelected()) {
					list.add("sons of fathers's brothers");
					number.add(Integer.parseInt(textFieldSonsOfUncles.getText()));
				}
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i)+ ": "+ number.get(i));
				}
				DistributeShares ds=new DistributeShares();
				ds.allotShares(list,number,effectiveShares);
			}
		});
		btnDistribute.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDistribute.setBounds(326, 686, 141, 30);
		frame.getContentPane().add(btnDistribute);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTotalShares.setText("100");
				textFieldBequestShares.setText("0");
				chckbxHusband.setSelected(false);
				chckbxWives.setSelected(false);
				chckbxSons.setSelected(false);
				chckbxDaughters.setSelected(false);
				chckbxFather.setSelected(false);
				chckbxGrandFather.setSelected(false);
				chckbxPaternalGrandMother.setSelected(false);
				chckbxMother.setSelected(false);
				chckbxMaternalGrandMother.setSelected(false);
				chckbxGrandSons.setSelected(false);
				chckbxGrandDaughters.setSelected(false);
				chckbxBrothers.setSelected(false);
				chckbxSisters.setSelected(false);
				chckbxNephews.setSelected(false);
				chckbxSonsOfNephews.setSelected(false);
				chckbxUncles.setSelected(false);
				chckbxSonsOfUncles.setSelected(false);
				//System.out.print("\033[H\033[2J");
			    //System.out.flush();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(724, 686, 216, 30);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(1137, 686, 141, 30);
		frame.getContentPane().add(btnExit);
	}
}
