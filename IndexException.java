package development;

public class IndexException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndexException() {
		
		super("Internal System IndexViolation");
		
	}
	
	public IndexException(String s) {
		
		super(s);
	}

}
