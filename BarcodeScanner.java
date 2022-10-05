package development;

import java.awt.event.KeyEvent;

public class BarcodeScanner {
	
	  @Override
	    public void keyTyped(KeyEvent e) {
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	        logger().info("keytyped" + e.getKeyChar() + " code "+e.getKeyCode());
	        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	            logger().info("all keys " + keyspressed);
	            return;
	        }
	        // will not last more than a second...
	        if (keyspressed == null || System.currentTimeMillis() - currentTimeMillis > 1000) {
	            keyspressed = e.getKeyChar()+"";
	            currentTimeMillis = System.currentTimeMillis();
	        } else {
	            keyspressed = keyspressed + e.getKeyChar();
	            currentTimeMillis = System.currentTimeMillis();
	        }
	    }

	    private String keyspressed = null;
	    private long currentTimeMillis = System.currentTimeMillis();

}
