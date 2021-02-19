package views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.TotalDistributedShares;
import models.prescribed.PrescribedHeir;
import models.residual.ResidualHeir;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class OutputScreen extends Screen {

	private JFrame frame;
	private JTable tablePrescribed;
	private JTable tableResidual;
	private JTable tableTotal;
	ArrayList<PrescribedHeir> listofps;
	ArrayList<ResidualHeir> listofrs;
	TotalDistributedShares tds;

	/**
	 * Launch the application.
	 */
	public  void view(TotalDistributedShares tds) {
		this.listofps=tds.getListofheirsofps();
		this.listofrs=tds.getListofheirsofrs();
		this.tds=tds;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public OutputScreen() {
		initialize();
		
	}*/

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame("Distributed Shares");
		frame.setBounds(0, 0, 800, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Inheritance System");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(260, 42, 400, 49);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblTopImage = new JLabel("");
		lblTopImage.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTopImage.setBounds(10, 10, 766, 106);
		Image imgTop=new ImageIcon(this.getClass().getResource("/top.jpg")).getImage();
		Image img1Top=imgTop.getScaledInstance(lblTopImage.getWidth(), lblTopImage.getHeight(), Image.SCALE_SMOOTH);
		lblTopImage.setIcon(new ImageIcon(img1Top));
		frame.getContentPane().add(lblTopImage);
		
		JPanel panelPrescribed = new JPanel();
		panelPrescribed.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panelPrescribed.setBounds(39, 212, 187, 141);
		frame.getContentPane().add(panelPrescribed);
		panelPrescribed.setLayout(null);
		
		JScrollPane scrollPanePrescribed = new JScrollPane();
		scrollPanePrescribed.setBounds(10, 10, 167, 121);
		panelPrescribed.add(scrollPanePrescribed);
		
		tablePrescribed = new JTable();
		tablePrescribed.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Relatives", "Earned Shares"
			}
		));		
		tablePrescribed.getColumnModel().getColumn(1).setPreferredWidth(85);
		scrollPanePrescribed.setViewportView(tablePrescribed);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(338, 401, 122, 27);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panelResidual = new JPanel();
		panelResidual.setLayout(null);
		panelResidual.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panelResidual.setBounds(296, 212, 197, 141);
		frame.getContentPane().add(panelResidual);
		
		JScrollPane scrollPaneResidual = new JScrollPane();
		scrollPaneResidual.setBounds(10, 10, 177, 121);
		panelResidual.add(scrollPaneResidual);
		
		tableResidual = new JTable();
		tableResidual.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Relatives", "Earned Shares"
			}
		));
		scrollPaneResidual.setViewportView(tableResidual);
		
		JPanel panelTotal = new JPanel();
		panelTotal.setLayout(null);
		panelTotal.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panelTotal.setBounds(552, 212, 197, 141);
		frame.getContentPane().add(panelTotal);
		
		JScrollPane scrollPaneTotal = new JScrollPane();
		scrollPaneTotal.setBounds(10, 10, 177, 121);
		panelTotal.add(scrollPaneTotal);
		
		tableTotal = new JTable();
		tableTotal.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Relatives", "Total Shares"
			}
		));
		scrollPaneTotal.setViewportView(tableTotal);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(252, 177, 1, 176);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.RED);
		separator_1.setBounds(521, 177, 1, 176);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Prescribed Shares");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(54, 177, 145, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Residual Shares");
		lblNewLabel_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.PINK);
		lblNewLabel_1_1.setBounds(324, 177, 129, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total Shares");
		lblNewLabel_1_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBackground(Color.PINK);
		lblNewLabel_1_1_1.setBounds(579, 177, 129, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Total Distributed Shares per Person");
		lblNewLabel_1_1_2.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1_2.setBackground(Color.PINK);
		lblNewLabel_1_1_2.setBounds(129, 130, 549, 37);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		DefaultTableModel model= (DefaultTableModel) tablePrescribed.getModel();
		for(PrescribedHeir i: listofps) {
			model.addRow(new Object[] {i.getName(),i.getPortions()});
		}
		
		model= (DefaultTableModel) tableResidual.getModel();
		for(ResidualHeir i: listofrs) {
			model.addRow(new Object[] {i.getName(),i.getPortions()});
		}
		
		model= (DefaultTableModel) tableTotal.getModel();
		ArrayList<String> listoftds=tds.getEffectiveHeirs();
		ArrayList<Double> shareoftds=tds.getEffectiveShares();
		for(String name: listoftds) {
			model.addRow(new Object[] {name, shareoftds.get(listoftds.indexOf(name))});
		}
	}

}
