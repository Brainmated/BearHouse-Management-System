package development;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
	
public class ImportStorage extends BearFrame{
		
		public ImportStorage() {
			String[] columnNames= {"Pallet ID", "Box ID", "Document Name", "Type"};
			DefaultTableModel model=new DefaultTableModel(columnNames, 0);
			JTable table=new JTable(model);
			
			JButton btn=createButton(table);
			JFrame frame=new JFrame("Test");
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new JScrollPane(table));
			frame.add(btn, BorderLayout.SOUTH);
			frame.pack();
			frame.setLocationByPlatform(true);
			frame.setVisible(true);
			
		}
		
		private JButton createButton(final JTable table) {
	        JButton button = new JButton("Import");
	        button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JFileChooser chooser = new JFileChooser();
	                int result = chooser.showOpenDialog(table);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File file = chooser.getSelectedFile();
	                    DefaultTableModel model = createModel(file);
	                    table.setModel(model);
	                }
	            }
	        });
	        return button;
	    }

	    private DefaultTableModel createModel(File file) {
	        DefaultTableModel model = null;

	        try {
	            BufferedReader txtReader = new BufferedReader(
	                    new FileReader(file));
	            String header = txtReader.readLine();
	            model = new DefaultTableModel(header.split(","), 0);
	            String line;
	            while ((line = txtReader.readLine()) != null) {
	                model.addRow(line.split(","));
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }

	        return model;
	    }

}
