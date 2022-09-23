package development;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class AddUserDialog extends JDialog implements ActionListener{
	
	String fName, lName, ID, positionChosen;
	String[] positions= {"Manager", "Administrator", "Moderator", "Index User", "Warehouse User"};
	static ArrayList<String> User=new ArrayList<String>();
	static ArrayList<String> fnames=new ArrayList<String>();
	static ArrayList<String> lnames=new ArrayList<String>();
	static ArrayList<String> ids=new ArrayList<String>();
	static ArrayList<String> allPositions=new ArrayList<String>();
	
	JTextField fname=new JTextField(10);
	JTextField lname=new JTextField(10);
	static JTextField id=new JTextField(10);
	JComboBox<String> position=new JComboBox<String>(positions);
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();

	JLabel flabel=new JLabel("First Name: ");
	JLabel llabel=new JLabel("Last Name: ");
	JLabel idlabel=new JLabel("ID: ");
	JLabel positionlabel=new JLabel("Position: ");
	JButton save=new JButton("Save");
	JButton cancel=new JButton("Cancel");
	
	
	public void registerUser() {
		
		
		frame.setSize(300,300);
		frame.setTitle("Add User");
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		
		panel.setLayout(new GridLayout(5,2,10,10));

		flabel.setHorizontalAlignment(JLabel.CENTER);
		llabel.setHorizontalAlignment(JLabel.CENTER);
		idlabel.setHorizontalAlignment(JLabel.CENTER);
		positionlabel.setHorizontalAlignment(JLabel.CENTER);
		save.setHorizontalAlignment(JButton.CENTER);
		cancel.setHorizontalAlignment(JButton.CENTER);
		
		
		panel.add(flabel);
		panel.add(fname);
		
		panel.add(llabel);
		panel.add(lname);
		
		panel.add(idlabel);
		panel.add(id);
		
		panel.add(positionlabel);		
		panel.add(position);
		
		panel.add(save);
		save.addActionListener(this);
		panel.add(cancel);
		cancel.addActionListener(this);
		
		
		frame.setResizable(false);
		
		frame.setVisible(true);
		frame.pack();
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==save) {
			fName=fname.getText();
			lName=lname.getText();
			ID=id.getText();
			positionChosen=position.getSelectedItem().toString();
			
			fnames.add(fName);
			lnames.add(lName);
			ids.add(ID);
			allPositions.add(positionChosen);
			
			JOptionPane.showMessageDialog(frame, "User: "+ID+" created.");
			User.addAll(fnames);
			User.addAll(lnames);
			User.addAll(ids);
			User.addAll(allPositions);
			
		}
		else if(e.getSource()==cancel){
			fname.setText("");
			lname.setText("");
			id.setText("");
			position.removeItem(positionChosen);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
		else {
			JOptionPane.showMessageDialog(frame,
				    "Error!",
				    "Inane warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}

}
