package development;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AuditUsers /*extends AddUserDialog*/{
	//AuditUsers audit=new AuditUsers();
	JFrame frame=new JFrame("Edit Users");
	JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER));
	ArrayList<String> list=new ArrayList<String>();
	JTable table=new JTable();
	JScrollPane scrollPane=new JScrollPane();
	DefaultTableModel model=new DefaultTableModel();
	
	
	
	public void displayUsers() {
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		
		table.setModel(model);
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("ID");
		model.addColumn("Position");
		panel.add(table);
		//list.add(audit.fName);
		//list.add(audit.lName);
		//list.add(audit.ID);
		//list.add(positionChosen);
		//model.addRow(new Object[] {list});
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	/*public static void main(String[] args) {
		AuditUsers run=new AuditUsers();
		run.displayUsers();
	}*/
}
