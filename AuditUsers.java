package development;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AuditUsers extends AddUserDialog{
	//AuditUsers audit=new AuditUsers();
	JFrame frame=new JFrame("Audit Users");
	JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER));
	ArrayList<String> list=new ArrayList<String>();
	
	JTable table=new JTable(new DefaultTableModel(new Object[] {"First Name", "Last Name", "ID", "Position"},20));
	DefaultTableModel model=new DefaultTableModel();
	JScrollPane scrollPane=new JScrollPane();
	
	public String toString() {
		return fName;
	}
	
	
	public void displayUsers() {
		frame.setSize(300,300);
		
		frame.setContentPane(panel);
		
		table.setModel(model);
		
		
		//model.addRow(new Object[] {fName, lName, iD, positionChosen});
		//VERY IMPORTANT(!!!) DONT FORGET TO CHANGE FROM ARRAY LIST CONTENT TO A toString() METHOD(!!!)
		System.out.println(fName);
		
		panel.add(table);
		panel.add(scrollPane);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	/*public static void main(String[] args) {
		AuditUsers run=new AuditUsers();
		run.displayUsers();
	}*/
}
