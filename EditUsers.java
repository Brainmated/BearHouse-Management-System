package development;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EditUsers extends AddUserDialog implements ActionListener{
	
	EditUsers editDialog=new EditUsers();
	JFrame frame=new JFrame();
	JButton edit=new JButton("Edit");
	JButton delete=new JButton("Delete");
	JButton cancel=new JButton("Cancel");
	JScrollPane sp=new JScrollPane();
	String[] columns= {"First Name", "Last Name", "ID", "Position"};
	DefaultTableModel model=new DefaultTableModel(columns, 0);
	JTable table=new JTable();
	static ArrayList<String> Users=new ArrayList<String>();
	static ArrayList<String> firstnames=new ArrayList<String>();
	static ArrayList<String> lastnames=new ArrayList<String>();
	static ArrayList<String> allIds=new ArrayList<String>();
	static ArrayList<String> allThePositions=new ArrayList<String>();

	public void showUsers() {
		Users.addAll(firstnames);
		Users.addAll(lastnames);
		Users.addAll(allIds);
		Users.addAll(allThePositions);
		this.firstnames=editDialog.fnames;
		this.lastnames=editDialog.lnames;
		this.allIds=editDialog.ids;
		this.allThePositions=editDialog.allPositions;
		
		for(int i=0; i<firstnames.size(); i++) {
			Object[] data= {firstnames.get(i), lastnames.get(i), allIds.get(i), allThePositions.get(i)};
			model.addRow(data);
		}
		// TODO Auto-generated constructor stub
		edit.addActionListener(this);
		delete.addActionListener(this);
		cancel.addActionListener(this);
		
		JOptionPane.showMessageDialog(null,Users);
		
		frame.add(table);
		frame.add(sp);
		frame.setTitle("Users");
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==edit) {
			
		}
		else if(e.getSource()==delete) {
			
		}
		else if(e.getSource()==cancel) {
			
		}
		
		
	}
}
