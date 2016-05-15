package pl.stockExchange.bank.helper;

import java.math.BigDecimal;

public class SavedShare {

	private int amount;
	private BigDecimal costSum;
	private String companyName;
	
	

	public SavedShare() {
		super();
	}

	public SavedShare(int amount, BigDecimal costSum, String companyName) {
		super();
		this.amount = amount;
		this.costSum = costSum;
		this.companyName = companyName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BigDecimal getCostSum() {
		return costSum;
	}

	public void setCostSum(BigDecimal costSum) {
		this.costSum = costSum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
