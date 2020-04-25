package post.inhabitant;

public class BankAccount {
	
	/** the amount of the bank account */
	private float amount;
	
	/**
	 * 
	 * @param amount the amount of the bank account
	 */
	public BankAccount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * 
	 * @return the amount of the bank account
	 */
	public float getAmount() {
		return this.amount;
	}
	
	/**
	 * 
	 * @param sum the sum to be credited to the bank account
	 */
	public void credit(float sum) {
		this.amount += sum;
	}
	
	/**
	 * 
	 * @param sum the sum to be debited to the bank account
	 */
	public void debit(float sum) {
		this.amount -= sum;
	}

}
