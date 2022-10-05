package development;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.sql.*;



public class BearFrame {

	
	public JFrame frame;
	private JLabel label;
	
    private BearFrame warehouse;
    private String soundName = "fart.wav"; 
    private JMenu file;
    private JMenu users;
    private JMenu documents;
    private JMenu customers;
    private JMenu about;
    private JMenuBar menuBar;
    private JMenu warehouseOperations;
    private JMenuItem interfaceOpt;
    private JMenuItem sql;
    private JMenuItem addUsers;

    private JMenuItem auditUsers;
    private JMenuItem createOrder;

    private JMenuItem storage;
    private JMenuItem search;
    private JMenuItem importDoc;
    private JMenuItem export;
    private JMenuItem addCustomer;

    private JMenuItem auditCustomer;
    private JMenuItem help;
    private JMenuItem documentation;
    
    protected static BearApp theBear;
    private Connection con=null;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */

	public void mainFrame() throws ClassNotFoundException {
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//con = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port/orcl", "username", "password");
		
		
		
		frame=new JFrame();
		frame.setTitle("BearHouse Management System");
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JLabel(new ImageIcon("C:/Users/Alex/eclipse-workspace/GitHubPortfolio/src/development/beargineer.png")));
		frame.setResizable(false);
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		/**
		 *
		 * @file-----------------------------------------------------------------------------------------------------------------
		 */
		
		file = new JMenu("Settings");
		menuBar.add(file);
		
		interfaceOpt = new JMenuItem("User Interface");
		file.add(interfaceOpt);
		//interfaceOpt.addActionListener(this);
		interfaceOpt.setToolTipText("Edit your personal UI preferences");
		sql = new JMenuItem("SQL Operations");
		file.add(sql);
		//sql.addActionListener(this);
		sql.setToolTipText("Import Database/Edit");
		
		/**
		 *
		 * @users-----------------------------------------------------------------------------------------------------------------
		 */
		
		users = new JMenu("Users");
		menuBar.add(users);
		
		addUsers = new JMenuItem("Add/Edit User");
		users.add(addUsers);
		addUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==addUsers) {
					java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			                new addEditUsers().setVisible(true);
			            }
			        });
				}
			}
		});

		//editUsers.addActionListener(this);
		auditUsers = new JMenuItem("Audit User");
		users.add(auditUsers);
		//auditUsers.addActionListener(this);
		auditUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==auditUsers) {
					AuditUsers auditDialog=new AuditUsers();
					auditDialog.displayUsers();
				}
			}
		});
		/**
		 *
		 * @warehouse-----------------------------------------------------------------------------------------------------------------
		 */
		
		warehouseOperations = new JMenu("Warehouse");
		menuBar.add(warehouseOperations);
		
		createOrder = new JMenuItem("Create Work Order");
		warehouseOperations.add(createOrder);
		createOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==createOrder) {
					CreateOrder createOrder=new CreateOrder();
					createOrder.setInterface();
				}
			}
		});

		storage = new JMenuItem("Import Inventory");
		warehouseOperations.add(storage);
		//storage.addActionListener(this);
		storage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==storage) {
					SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			                new ImportStorage();
			            }
			        });
				}
			}
		});
		search = new JMenuItem("Search Location/Pallet/Box");
		warehouseOperations.add(search);
		//search.addActionListener(this);
		/**
		 *
		 * @documents-----------------------------------------------------------------------------------------------------------------
		 */
		
		documents = new JMenu("Documents");
		menuBar.add(documents);
		
		importDoc = new JMenuItem("Import");
		documents.add(importDoc);
		//importDoc.addActionListener(this);
		export = new JMenuItem("Search/Export");
		documents.add(export);
		//export.addActionListener(this);
		/**
		 *
		 * @customers-----------------------------------------------------------------------------------------------------------------
		 */
		
		customers = new JMenu("Customers");
		menuBar.add(customers);
		
		
		addCustomer = new JMenuItem("Add/Edit Customer");
		customers.add(addCustomer);

		//searchCustomer.addActionListener(this);
		auditCustomer = new JMenuItem("Audit Customer");
		customers.add(auditCustomer);
		//auditCustomer.addActionListener(this);
		/**
		 *
		 * @about-----------------------------------------------------------------------------------------------------------------
		 */
		File manual=new File("C:\\Users\\Alex\\eclipse-workspace\\GitHubPortfolio\\src\\development\\BHMS Manual.pdf");
		
		about = new JMenu("About");
		menuBar.add(about);
		
		help = new JMenuItem("Help");
		about.add(help);
		//help.addActionListener(this);
		documentation = new JMenuItem("Documentation");
		about.add(documentation);
		//documentation.addActionListener(this);
		documentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==documentation) {
					try {
						Desktop.getDesktop().open(manual);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		frame.setVisible(true);

	}


}
	

