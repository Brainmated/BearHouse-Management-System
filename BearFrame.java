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

	private JFrame frame;

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
    private JMenuItem editUsers;
    private JMenuItem auditUsers;
    private JMenuItem createOrder;
    private JMenuItem editOrder;
    private JMenuItem storage;
    private JMenuItem search;
    private JMenuItem importDoc;
    private JMenuItem export;
    private JMenuItem addCustomer;
    private JMenuItem searchCustomer;
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

	public BearFrame() throws ClassNotFoundException {
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//con = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port/orcl", "username", "password");
		
		
		
		setFrame(new JFrame());
		getFrame().setTitle("BearHouse Management System");
		
		getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().add(new JLabel(new ImageIcon("C:/Users/Alex/eclipse-workspace/GitHubPortfolio/src/development/beargineer.png")));
		getFrame().setResizable(false);
		menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);
		
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
		
		addUsers = new JMenuItem("Add User");
		users.add(addUsers);
		addUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==addUsers) {
					AddUserDialog addDialog=new AddUserDialog();
					//addDialog.setModalityType(ModalityType.APPLICATION_MODAL);
					//addDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					addDialog.registerUser();
				}
			}
		});
		//addUsers.addActionListener(this);
		editUsers = new JMenuItem("Edit User");
		users.add(editUsers);
		editUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==editUsers) {
					EditUsers editDialog=new EditUsers();
					editDialog.showUsers();
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
		//createOrder.addActionListener(this);
		editOrder = new JMenuItem("Edit Work Order");
		warehouseOperations.add(editOrder);
		//editOrder.addActionListener(this);
		storage = new JMenuItem("Storage Control");
		warehouseOperations.add(storage);
		//storage.addActionListener(this);
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
		
		
		addCustomer = new JMenuItem("Add Customer");
		customers.add(addCustomer);
		//addCustomer.addActionListener(this);
		searchCustomer = new JMenuItem("Search/Edit Customer");
		customers.add(searchCustomer);
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
		
		getFrame().setVisible(true); //the main frame
		
		
	}

	/*@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		
		if(ae.getSource() == interfaceOpt) {
			JOptionPane.showMessageDialog(null, "Test");
			System.out.println("Test");
		}
		else if(ae.getSource()==sql){
			System.out.println("Test1");
			
		}
		else if(ae.getSource()==addUsers) {
			try {
				AddUserDialog addDialog=new AddUserDialog();
				//addDialog.setModalityType(ModalityType.APPLICATION_MODAL);
				//addDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				addDialog.registerUser();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			System.out.println("Test2");
		}
		else if(ae.getSource()==editUsers) {
			
			try {
				EditUsers editDialog=new EditUsers();
				editDialog.showUsers();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("Test3");
		}
		else if(ae.getSource()==auditUsers) {
			AuditUsers audit=new AuditUsers();
			System.out.println("Test4");
		}
		else if(ae.getSource()==createOrder) {
			System.out.println("Test5");
		}
		else if(ae.getSource()==editOrder) {
			
		}
		else if(ae.getSource()==storage) {
			
		}
		else if(ae.getSource()==search) {
			
		}
		else if(ae.getSource()==importDoc) {
			
		}
		else if(ae.getSource()==export) {
			
		}
		else if(ae.getSource()==addCustomer) {
			
		}
		else if(ae.getSource()==searchCustomer) {
			
		}
		else if(ae.getSource()==auditCustomer) {
			
		}
		else if(ae.getSource()==help) {
			
		}
		else if(ae.getSource()==documentation) {
			
		}
		else {
			System.out.println("Error");
		}
		
	}*/
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	

	
}
	

