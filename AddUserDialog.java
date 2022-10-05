package development;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class AddUserDialog{
	/**
	 * @wbp.parser.entryPoint
	 */
	
	String fName, lName, id, positionChosen;
	String[] positions= {"Manager", "Administrator", "Moderator", "Index User", "Warehouse User"};
	
	JTextField fname=new JTextField(10);
	JTextField lname=new JTextField(10);
	static JTextField iD=new JTextField(10);
	
	
	DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(positions);
	JComboBox<String> position=new JComboBox<String>(comboModel);
	JFrame frame=new JFrame();
	JPanel addingPanel=new JPanel();
	JPanel editingPanel=new JPanel();
	
	
	
	private JTable table=new JTable();
	Object[] columns= {"First Name", "Last Name", "ID", "Position"};
	DefaultTableModel model=new DefaultTableModel();

	JLabel flabel=new JLabel("First Name: ");
	JLabel llabel=new JLabel("Last Name: ");
	JLabel idlabel=new JLabel("ID: ");
	JLabel positionlabel=new JLabel("Position: ");
	JButton save=new JButton("Save");
	JButton cancel=new JButton("Cancel");
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void registerUser() {
		
		
		frame.setSize(300,300);
		frame.setTitle("Add User");
		frame.getContentPane().add(addingPanel);
		frame.add(addingPanel, BorderLayout.WEST);
		frame.add(editingPanel, BorderLayout.EAST);
		frame.setLocationRelativeTo(null);
		
		addingPanel.setLayout(new GridLayout(5,2,10,10));

		flabel.setHorizontalAlignment(JLabel.CENTER);
		llabel.setHorizontalAlignment(JLabel.CENTER);
		idlabel.setHorizontalAlignment(JLabel.CENTER);
		positionlabel.setHorizontalAlignment(JLabel.CENTER);
		save.setHorizontalAlignment(JButton.CENTER);
		cancel.setHorizontalAlignment(JButton.CENTER);
		
		
		addingPanel.add(flabel);
		addingPanel.add(fname);
		
		addingPanel.add(llabel);
		addingPanel.add(lname);
		
		addingPanel.add(idlabel);
		addingPanel.add(iD);
		
		addingPanel.add(positionlabel);		
		addingPanel.add(position);
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==save) {
					fName=fname.getText();
					lName=lname.getText();
					id=iD.getText();
					positionChosen=position.getSelectedItem().toString();
					
					JOptionPane.showMessageDialog(frame, "User: "+id+" created.");
					fname.setText("");
					lname.setText("");
					iD.setText("");
					fname.setText("");
				}
			}
		});
		addingPanel.add(save);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==cancel) {
					fname.setText("");
					lname.setText("");
					iD.setText("");
					position.removeItem(positionChosen);
					//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
		addingPanel.add(cancel);
		
		table.setFillsViewportHeight(true);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		
		Object[] row=new Object[4];
		
		
		frame.setResizable(false);
		
		frame.setVisible(true);
		frame.pack();
	}
	
	

}
