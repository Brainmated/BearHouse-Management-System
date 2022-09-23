package development;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

abstract class BearAppDialog extends JDialog implements ActionListener{
	protected JFrame bframe=new JFrame();
	protected J
	public BearAppDialog(JFrame frame, String title, BearFrame bear) {
		super(frame, title);
		theFrame=bear;
		setLocationRelativeTo(null);
		setTitle(title);
		
	}

}
