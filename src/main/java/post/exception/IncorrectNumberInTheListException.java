package post.exception;

public class IncorrectNumberInTheListException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/** the message printed when there is this exception */
	private String message;
	
	/**
	 * 
	 * the message printed when there is this exception
	 */
	public IncorrectNumberInTheListException() {
		this.message = "The list must be filled up with 4 inhabitants";
	}
	
	/**
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}
	
}
