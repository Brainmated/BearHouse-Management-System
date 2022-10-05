package development;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class CreateOrder {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel workOrder=new JLabel("Work Order No");
	JLabel date=new JLabel("Date/Time");
	JLabel user=new JLabel("User ID");
	JLabel department=new JLabel("Department");
	JLabel status=new JLabel("Status");
	JLabel notes=new JLabel("Notes");
	JTextField workOrderjtf=new JTextField(10);
	JTextField datejtf=new JTextField(10);
	JTextField userjtf=new JTextField(10);
	JTextField departmentjtf=new JTextField(10);
	JTextField statusjtf=new JTextField(10);
	JTextField notesjtf=new JTextField(10);
	
	JButton register=new JButton("Register");
	JButton reset=new JButton("Reset");
	
	String[] orderStatus= {"Completed", "Not Prepared", "In Transit", "Stored", "Delivered", "Removed"};
	JComboBox<String> orderState=new JComboBox<String>(orderStatus);
	String serialNo="";
	String dateTime="";
	String userId="";
	String departmentNo="";
	String currentStatus="";
	String extra="";
	
	public void setInterface() {
		
		frame.setSize(300, 300);
		frame.setTitle("Create Work Order");
		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);
		workOrder.setHorizontalAlignment(JLabel.CENTER);
		date.setHorizontalAlignment(JLabel.CENTER);
		user.setHorizontalAlignment(JLabel.CENTER);
		department.setHorizontalAlignment(JLabel.CENTER);
		status.setHorizontalAlignment(JLabel.CENTER);
		notes.setHorizontalAlignment(JLabel.CENTER);
		panel.add(workOrder);
		panel.add(workOrderjtf);
		panel.add(date);
		panel.add(datejtf);
		panel.add(user);
		panel.add(userjtf);
		panel.add(department);
		panel.add(departmentjtf);
		panel.add(status);
		panel.add(statusjtf);
		panel.add(notes);
		panel.add(notesjtf);
		
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==register) {
					serialNo=workOrderjtf.getText();
					dateTime=datejtf.getText();
					userId=userjtf.getText();
					departmentNo=departmentjtf.getText();
					currentStatus=statusjtf.getText();
					extra=notesjtf.getText();
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==reset) {
					workOrderjtf.setText("");
					datejtf.setText("");
					userjtf.setText("");
					departmentjtf.setText("");
					statusjtf.setText("");
					notesjtf.setText("");
					
				}
			}
		});
		panel.add(register);
		panel.add(reset);
		
		frame.setVisible(true);
	}

}
