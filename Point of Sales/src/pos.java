import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.print.PrinterException;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class pos {

	private JFrame frmPointOfSales;
	private JTable tableProductsSelected;
	private JTextField JTextTotal;
	private JTextField JtextCash;
	private JTextField JTextChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pos window = new pos();
					window.frmPointOfSales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pos() {
		initialize();
		getTotal();	
	}
	
//	==================================================FUNCTIONS========================================================
	
	public void getTotal() {
		double rowsCount = tableProductsSelected.getRowCount();
		double sum = 0;
		for (int i = 0; i < rowsCount; i++) {

//			Get the value of row and calculate the value for total.
			sum = sum + Double.parseDouble(tableProductsSelected.getValueAt(i, 4).toString());	
		}
//		Set the total to JTextField with a variable name of JTextTotal
		JTextTotal.setText(String.format("Php %.2f", sum));
	}
//	==================================================FUNCTIONS========================================================

	
	/**
	 * Initialize the contents of the frame.
	 */
	int clickCount = 0;
	
	private void initialize() {
		frmPointOfSales = new JFrame();
//		frmPointOfSales.setBounds(100, 100, 450, 300);
		frmPointOfSales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frmPointOfSales.setLocationRelativeTo(null);
		frmPointOfSales.setTitle("Point of Sales ");
		frmPointOfSales.setResizable(true);
		frmPointOfSales.setSize(1380, 740);
		frmPointOfSales.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmPointOfSales.getContentPane().setLayout(null);
		
//		Title
		JLabel labelTitle = new JLabel("ONLINE SARI-SARI STORE");
		labelTitle.setForeground(new Color(255, 255, 255));
		labelTitle.setBounds(10, 11, 1344, 30);
		labelTitle.setFont(new Font("Uni Sans Heavy CAPS", Font.PLAIN, 24));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frmPointOfSales.getContentPane().add(labelTitle);
		
		JPanel containerTitle = new JPanel();
		containerTitle.setBackground(new Color(0x32517D));
		containerTitle.setBounds(10, 4, 1344, 37);
		frmPointOfSales.getContentPane().add(containerTitle);
		
		JPanel containerProductSelected = new JPanel();
		containerProductSelected.setBackground(new Color(192, 192, 192));
		containerProductSelected.setBounds(10, 52, 532, 532);
		frmPointOfSales.getContentPane().add(containerProductSelected);
		containerProductSelected.setLayout(null);
		
		JLabel JLabelProductsSelected = new JLabel("PRODUCTS SELECTED:");
		JLabelProductsSelected.setBounds(10, 11, 501, 14);
		JLabelProductsSelected.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 15));
		JLabelProductsSelected.setHorizontalAlignment(SwingConstants.CENTER);
		containerProductSelected.add(JLabelProductsSelected);
		
		tableProductsSelected = new JTable();
		tableProductsSelected.setBounds(1, 1, 510, 460);
		tableProductsSelected.setColumnSelectionAllowed(false);
		tableProductsSelected.setRowSelectionAllowed(false);
		tableProductsSelected.setCellSelectionEnabled(false);
		tableProductsSelected.setFillsViewportHeight(true);
		tableProductsSelected.setEnabled(true);
		tableProductsSelected.setTableHeader(null);
		tableProductsSelected.setFont(new Font("Euclid Circular A Medium", Font.PLAIN, 15));
		tableProductsSelected.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"JTableProductNo", "JTableProductName", "JTableQuantity", "JTablePrice", "JTableTotal"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		containerProductSelected.add(tableProductsSelected);

		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 512, 24);
		panel.setBackground(new Color(0x32517D));
		containerProductSelected.add(panel);
		panel.setLayout(null);
		
		JLabel label2 = new JLabel("Product Name");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Euclid Circular B SemiBold", Font.PLAIN, 14));
		label2.setBounds(99, 0, 99, 20);
		panel.add(label2);
		
		JLabel label3 = new JLabel("Quantity");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Euclid Circular B SemiBold", Font.PLAIN, 14));
		label3.setBounds(199, 0, 99, 20);
		panel.add(label3);
		
		JLabel label4 = new JLabel("Price");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Euclid Circular B SemiBold", Font.PLAIN, 14));
		label4.setBounds(298, 0, 99, 20);
		panel.add(label4);
		
		JLabel label5 = new JLabel("Total");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("Euclid Circular B SemiBold", Font.PLAIN, 14));
		label5.setBounds(395, 0, 99, 20);
		panel.add(label5);
		
		JLabel label1 = new JLabel("Product No.");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Euclid Circular B SemiBold", Font.PLAIN, 14));
		label1.setBounds(0, 0, 99, 20);
		panel.add(label1);
		
		JScrollPane scrollPane = new JScrollPane(tableProductsSelected);
		scrollPane.setBounds(10, 57, 512, 462);
		containerProductSelected.add(scrollPane);
		
		
		JPanel containerProductAvailable = new JPanel();
		containerProductAvailable.setBackground(new Color(192, 192, 192));
		containerProductAvailable.setBounds(552, 52, 802, 532);
		frmPointOfSales.getContentPane().add(containerProductAvailable);
		containerProductAvailable.setLayout(null);
		
		JLabel JLabelAvailableProducts = new JLabel("PRODUCTS AVAILABLE:");
		JLabelAvailableProducts.setBounds(10, 11, 793, 15);
		JLabelAvailableProducts.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelAvailableProducts.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		containerProductAvailable.add(JLabelAvailableProducts);
		
		JButton btn1 = new JButton("");
		btn1.setBounds(10, 37, 89, 89);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 clickCount++;
				double priceItem1 = 8.00;
				int productNum = 1021543;
				double findValue = 0;
				int i = 0;
				double rowsCount = tableProductsSelected.getRowCount();
				for (i = 0; i < rowsCount; i++) {
//					Get the value of row and calculate the value for total.
					findValue = Double.parseDouble(tableProductsSelected.getValueAt(i, 0).toString());	
				}	
				if (findValue == productNum) {
//					Quantity multiply by price
					double total = clickCount * priceItem1;
					SetData(clickCount ,0 ,2);
					SetTotalProductItems(total, 0, 4);
					System.out.println("total: " + total);
					getTotal();
				} else if (findValue != productNum) {
					DefaultTableModel model = (DefaultTableModel) tableProductsSelected.getModel();
					model.addRow(new Object[] {productNum, "Rejoice", 1, priceItem1, priceItem1 });
					getTotal();					
				}
			}
			private void SetTotalProductItems(Object obj, int row_index, int col_index) {
				tableProductsSelected.getModel().setValueAt(obj,row_index,col_index);
				System.out.println("Total is displayed");
				// TODO Auto-generated method stub
			}
			private void SetData(Object obj, int row_index, int col_index) {
				// TODO Auto-generated method stub
				tableProductsSelected.getModel().setValueAt(obj,row_index,col_index);
				System.out.println("Value is added");
			}
		});
		
		btn1.setIcon(new ImageIcon(pos.class.getResource("/images/1.jpg")));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setForeground(new Color(255, 255, 255));
		containerProductAvailable.add(btn1);
		
		JButton btn1_1 = new JButton("");
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceItem1 = 20.00;
				DefaultTableModel model = (DefaultTableModel) tableProductsSelected.getModel();
				model.addRow(new Object[] {"001", "Coke", "", priceItem1, ""});
				getTotal();
			}
		});
		btn1_1.setBounds(109, 37, 89, 89);
		btn1_1.setForeground(Color.WHITE);
		btn1_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_1);
		
		JButton btn1_2 = new JButton("");
		btn1_2.setBounds(208, 37, 89, 89);
		btn1_2.setForeground(Color.WHITE);
		btn1_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_2);
		
		JButton btn1_3 = new JButton("");
		btn1_3.setBounds(307, 37, 89, 89);
		btn1_3.setForeground(Color.WHITE);
		btn1_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_3);
		
		JButton btn1_4 = new JButton("");
		btn1_4.setBounds(406, 37, 89, 89);
		btn1_4.setForeground(Color.WHITE);
		btn1_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_4);
		
		JButton btn1_5 = new JButton("");
		btn1_5.setBounds(505, 37, 89, 89);
		btn1_5.setForeground(Color.WHITE);
		btn1_5.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_5);
		
		JButton btn1_6 = new JButton("");
		btn1_6.setBounds(604, 37, 89, 89);
		btn1_6.setForeground(Color.WHITE);
		btn1_6.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_6);
		
		JButton btn1_7 = new JButton("");
		btn1_7.setBounds(703, 37, 89, 89);
		btn1_7.setForeground(Color.WHITE);
		btn1_7.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_7);
		
		JButton btn1_8 = new JButton("");
		btn1_8.setBounds(10, 137, 89, 89);
		btn1_8.setForeground(Color.WHITE);
		btn1_8.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_8);
		
		JButton btn1_1_1 = new JButton("");
		btn1_1_1.setBounds(109, 137, 89, 89);
		btn1_1_1.setForeground(Color.WHITE);
		btn1_1_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_1_1);
		
		JButton btn1_2_1 = new JButton("");
		btn1_2_1.setBounds(208, 137, 89, 89);
		btn1_2_1.setForeground(Color.WHITE);
		btn1_2_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_2_1);
		
		JButton btn1_3_1 = new JButton("");
		btn1_3_1.setBounds(307, 137, 89, 89);
		btn1_3_1.setForeground(Color.WHITE);
		btn1_3_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_3_1);
		
		JButton btn1_4_1 = new JButton("");
		btn1_4_1.setBounds(406, 137, 89, 89);
		btn1_4_1.setForeground(Color.WHITE);
		btn1_4_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_4_1);
		
		JButton btn1_5_1 = new JButton("");
		btn1_5_1.setBounds(505, 137, 89, 89);
		btn1_5_1.setForeground(Color.WHITE);
		btn1_5_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_5_1);
		
		JButton btn1_6_1 = new JButton("");
		btn1_6_1.setBounds(604, 137, 89, 89);
		btn1_6_1.setForeground(Color.WHITE);
		btn1_6_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_6_1);
		
		JButton btn1_7_1 = new JButton("");
		btn1_7_1.setBounds(703, 137, 89, 89);
		btn1_7_1.setForeground(Color.WHITE);
		btn1_7_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_7_1);
		
		JButton btn1_9 = new JButton("");
		btn1_9.setBounds(10, 237, 89, 89);
		btn1_9.setForeground(Color.WHITE);
		btn1_9.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_9);
		
		JButton btn1_1_2 = new JButton("");
		btn1_1_2.setBounds(109, 237, 89, 89);
		btn1_1_2.setForeground(Color.WHITE);
		btn1_1_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_1_2);
		
		JButton btn1_2_2 = new JButton("");
		btn1_2_2.setBounds(208, 237, 89, 89);
		btn1_2_2.setForeground(Color.WHITE);
		btn1_2_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_2_2);
		
		JButton btn1_3_2 = new JButton("");
		btn1_3_2.setBounds(307, 237, 89, 89);
		btn1_3_2.setForeground(Color.WHITE);
		btn1_3_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_3_2);
		
		JButton btn1_4_2 = new JButton("");
		btn1_4_2.setBounds(406, 237, 89, 89);
		btn1_4_2.setForeground(Color.WHITE);
		btn1_4_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_4_2);
		
		JButton btn1_5_2 = new JButton("");
		btn1_5_2.setBounds(505, 237, 89, 89);
		btn1_5_2.setForeground(Color.WHITE);
		btn1_5_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_5_2);
		
		JButton btn1_6_2 = new JButton("");
		btn1_6_2.setBounds(604, 237, 89, 89);
		btn1_6_2.setForeground(Color.WHITE);
		btn1_6_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_6_2);
		
		JButton btn1_7_2 = new JButton("");
		btn1_7_2.setBounds(703, 237, 89, 89);
		btn1_7_2.setForeground(Color.WHITE);
		btn1_7_2.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_7_2);
		
		JButton btn1_10 = new JButton("");
		btn1_10.setBounds(10, 337, 89, 89);
		btn1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1_10.setForeground(Color.WHITE);
		btn1_10.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_10);
		
		JButton btn1_1_3 = new JButton("");
		btn1_1_3.setBounds(109, 337, 89, 89);
		btn1_1_3.setForeground(Color.WHITE);
		btn1_1_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_1_3);
		
		JButton btn1_2_3 = new JButton("");
		btn1_2_3.setBounds(208, 337, 89, 89);
		btn1_2_3.setForeground(Color.WHITE);
		btn1_2_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_2_3);
		
		JButton btn1_3_3 = new JButton("");
		btn1_3_3.setBounds(307, 337, 89, 89);
		btn1_3_3.setForeground(Color.WHITE);
		btn1_3_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_3_3);
		
		JButton btn1_4_3 = new JButton("");
		btn1_4_3.setBounds(406, 337, 89, 89);
		btn1_4_3.setForeground(Color.WHITE);
		btn1_4_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_4_3);
		
		JButton btn1_5_3 = new JButton("");
		btn1_5_3.setBounds(505, 337, 89, 89);
		btn1_5_3.setForeground(Color.WHITE);
		btn1_5_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_5_3);
		
		JButton btn1_6_3 = new JButton("");
		btn1_6_3.setBounds(604, 337, 89, 89);
		btn1_6_3.setForeground(Color.WHITE);
		btn1_6_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_6_3);
		
		JButton btn1_7_3 = new JButton("");
		btn1_7_3.setBounds(703, 337, 89, 89);
		btn1_7_3.setForeground(Color.WHITE);
		btn1_7_3.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_7_3);
		
		JButton btn1_1_4 = new JButton("");
		btn1_1_4.setBounds(109, 435, 89, 89);
		btn1_1_4.setForeground(Color.WHITE);
		btn1_1_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_1_4);
		
		JButton btn1_2_4 = new JButton("");
		btn1_2_4.setBounds(208, 435, 89, 89);
		btn1_2_4.setForeground(Color.WHITE);
		btn1_2_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_2_4);
		
		JButton btn1_3_4 = new JButton("");
		btn1_3_4.setBounds(307, 435, 89, 89);
		btn1_3_4.setForeground(Color.WHITE);
		btn1_3_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_3_4);
		
		JButton btn1_4_4 = new JButton("");
		btn1_4_4.setBounds(406, 435, 89, 89);
		btn1_4_4.setForeground(Color.WHITE);
		btn1_4_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_4_4);
		
		JButton btn1_5_4 = new JButton("");
		btn1_5_4.setBounds(505, 435, 89, 89);
		btn1_5_4.setForeground(Color.WHITE);
		btn1_5_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_5_4);
		
		JButton btn1_6_4 = new JButton("");
		btn1_6_4.setBounds(604, 435, 89, 89);
		btn1_6_4.setForeground(Color.WHITE);
		btn1_6_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_6_4);
		
		JButton btn1_7_4 = new JButton("");
		btn1_7_4.setBounds(703, 435, 89, 89);
		btn1_7_4.setForeground(Color.WHITE);
		btn1_7_4.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_7_4);
		
		JButton btn1_11_1 = new JButton("");
		btn1_11_1.setBounds(10, 437, 89, 89);
		btn1_11_1.setForeground(Color.WHITE);
		btn1_11_1.setBackground(Color.WHITE);
		containerProductAvailable.add(btn1_11_1);
		
		JPanel containerPaymentProcess = new JPanel();
		containerPaymentProcess.setBorder(null);
		containerPaymentProcess.setBackground(Color.LIGHT_GRAY);
		containerPaymentProcess.setBounds(93, 595, 1033, 95);
		frmPointOfSales.getContentPane().add(containerPaymentProcess);
		containerPaymentProcess.setLayout(null);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setFocusPainted(false); 
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double cash = Double.parseDouble(JtextCash.getText());
				double sum = 0;
				double rowsCount = tableProductsSelected.getRowCount();
				for (int i = 0; i < rowsCount; i++) {

//					Get the value of row and calculate the value for total.
					sum = sum + Double.parseDouble(tableProductsSelected.getValueAt(i, 4).toString());	
				}
				double change = (cash - sum);
		
				JOptionPane.showMessageDialog(frmPointOfSales, "TOTAL: Php " + sum + "\nCASH: Php " + cash +
						"\nCHANGE: Php " + change, "Summary" , JOptionPane.PLAIN_MESSAGE);
				
				JtextCash.setText("Input Cash Here");
				JtextCash.setForeground(new Color(0xC0C0C0));
				JTextChange.setText("Php 0.00");
				JTextTotal.setText("Php 0.00");
				if (clickCount != 0) {
					clickCount = 0;
				}
	
			}
		});
		btnPay.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		btnPay.setBounds(750, 11, 130, 33);
		containerPaymentProcess.add(btnPay);
		btnPay.setForeground(new Color(0, 0, 0));
		btnPay.setBackground(Color.WHITE);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFocusPainted(false); 
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean print = tableProductsSelected.print();
					if (!print) {
						JOptionPane.showMessageDialog(frmPointOfSales, "Unable to Print!", "Message" , JOptionPane.ERROR_MESSAGE);
						
					}
					
				}catch (PrinterException ex) {
					JOptionPane.showConfirmDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(750, 55, 130, 33);
		containerPaymentProcess.add(btnPrint);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFocusPainted(false); 
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) tableProductsSelected.getModel();
				
				int removeItem = tableProductsSelected.getSelectedRow();
				
				if (removeItem >= 0) {
					model.removeRow(removeItem);
				}
				
				getTotal();
				
				if (clickCount != 0) {
					clickCount = 0;
				}
				
			}
			
		});
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(892, 55, 130, 33);
		containerPaymentProcess.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFocusPainted(false); 
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JtextCash.setText("Input Cash Here");
				JtextCash.setForeground(new Color(0xC0C0C0));
				JTextChange.setText("Php 0.00");
				JTextTotal.setText("Php 0.00");
				DefaultTableModel recordTable = (DefaultTableModel) tableProductsSelected.getModel();
				recordTable.setRowCount(0);
				
				if (clickCount != 0) {
					clickCount = 0;
				}
				
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(892, 11, 130, 33);
		containerPaymentProcess.add(btnReset);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFocusPainted(false); 
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double cash = Double.parseDouble(JtextCash.getText());
				double sum = 0;
				double rowsCount = tableProductsSelected.getRowCount();
				for (int i = 0; i < rowsCount; i++) {

//					Get the value of row and calculate the value for total.
					sum = sum + Double.parseDouble(tableProductsSelected.getValueAt(i, 4).toString());	
				}
				double change = (cash - sum);
				JTextChange.setText(String.format("Php %.2f", change));
				
			}
		});
		btnChange.setForeground(Color.BLACK);
		btnChange.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		btnChange.setBackground(Color.WHITE);
		btnChange.setBounds(349, 55, 130, 33);
		containerPaymentProcess.add(btnChange);
		
		JTextTotal = new JTextField();
		JTextTotal.setEditable(false);
		JTextTotal.setText("Php 0.00");
		JTextTotal.setFont(new Font("Euclid Circular B SemiBold", Font.PLAIN, 20));
		JTextTotal.setBounds(146, 11, 193, 33);
		containerPaymentProcess.add(JTextTotal);
		JTextTotal.setColumns(10);
		
		
		JtextCash = new JTextField();
		JtextCash.setDisabledTextColor(new Color(0xC0C0C0));
		JtextCash.setText("Input Cash Here");
		JtextCash.setForeground(new Color(0xC0C0C0));
		JtextCash.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {

				if (JtextCash.getText().equalsIgnoreCase("Input Cash Here")) {
					JtextCash.setText("");
					JtextCash.setForeground(new Color(0x00000));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {

				if (JtextCash.getText().equalsIgnoreCase("")) {
					JtextCash.setText("Input Cash Here");
					JtextCash.setForeground(new Color(0xC0C0C0));
				}
			}
			
		});
		JtextCash.setForeground(Color.GRAY);
		JtextCash.setFont(new Font("Euclid Circular B Medium", Font.PLAIN, 20));
		JtextCash.setColumns(10);
		JtextCash.setBounds(489, 11, 193, 33);
		containerPaymentProcess.add(JtextCash);
		
		
		
		
		JTextChange = new JTextField();
		JTextChange.setEditable(false);
		JTextChange.setText("Php 0.00");
		JTextChange.setFont(new Font("Euclid Circular A SemiBold", Font.PLAIN, 20));
		JTextChange.setColumns(10);
		JTextChange.setBounds(489, 55, 193, 33);
		containerPaymentProcess.add(JTextChange);
		
		JComboBox comboBoxPaymentMethod = new JComboBox();
		comboBoxPaymentMethod.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Gcash", "PayPal", "Visa Card"}));
		comboBoxPaymentMethod.setFont(new Font("Euclid Circular A Medium", Font.PLAIN, 20));
		comboBoxPaymentMethod.setBounds(192, 55, 147, 33);
		containerPaymentProcess.add(comboBoxPaymentMethod);
		
		
		JLabel JLabelPaymentMethod = new JLabel("Payment Method:");
		JLabelPaymentMethod.setFont(new Font("Euclid Circular A SemiBold", Font.PLAIN, 20));
		JLabelPaymentMethod.setForeground(new Color(0, 0, 0));
		JLabelPaymentMethod.setBounds(10, 55, 180, 33);
		containerPaymentProcess.add(JLabelPaymentMethod);
		
		JLabel JLabelTotal = new JLabel("Total:");
		JLabelTotal.setForeground(Color.BLACK);
		JLabelTotal.setFont(new Font("Euclid Circular A SemiBold", Font.PLAIN, 20));
		JLabelTotal.setBounds(10, 11, 126, 33);
		containerPaymentProcess.add(JLabelTotal);
		
		JLabel JLabelCash = new JLabel("Cash:");
		JLabelCash.setForeground(Color.BLACK);
		JLabelCash.setFont(new Font("Euclid Circular A SemiBold", Font.PLAIN, 20));
		JLabelCash.setBounds(349, 11, 84, 33);
		containerPaymentProcess.add(JLabelCash);
		
		JButton btnClear = new JButton("");
		btnClear.setToolTipText("Do you want to clear?");
		btnClear.setBorderPainted(false); 
		btnClear.setContentAreaFilled(true); 
		btnClear.setFocusPainted(true); 
		btnClear.setOpaque(true);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JtextCash.setText("Input Cash Here");
				JtextCash.setForeground(new Color(0xC0C0C0));
			}
		});
		btnClear.setIcon(new ImageIcon(pos.class.getResource("/images/clearIcon.png")));
		btnClear.setForeground(Color.LIGHT_GRAY);
		btnClear.setFont(new Font("Ubuntu", Font.BOLD, 15));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(449, 11, 30, 30);
		containerPaymentProcess.add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFocusPainted(false);
//		btnExit.addActionListener(e -> System.exit(0));
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			
			}
		});
		btnExit.setBounds(1224, 657, 130, 33);
		frmPointOfSales.getContentPane().add(btnExit);
		btnExit.setForeground(new Color(178, 34, 34));
		btnExit.setFont(new Font("Euclid Circular A SemiBold", Font.BOLD, 20));
		btnExit.setBackground(new Color(255, 255, 255));
		
	}
}
