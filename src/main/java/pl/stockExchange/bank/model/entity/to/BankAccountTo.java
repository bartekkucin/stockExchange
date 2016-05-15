package pl.stockExchange.bank.model.entity.to;

import java.math.BigDecimal;

import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;

public class BankAccountTo {

	private Long id;
	private String clientNumber;
	private BankAccountCurrencyTypeEnum currencyEnum;
	private BigDecimal amount;

	public BankAccountTo(Long id, String clientNumber, BankAccountCurrencyTypeEnum currencyEnum, BigDecimal amount) {
		super();
		this.id = id;
		this.clientNumber = clientNumber;
		this.currencyEnum = currencyEnum;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public BankAccountCurrencyTypeEnum getCurrencyEnum() {
		return currencyEnum;
	}

	public void setCurrencyEnum(BankAccountCurrencyTypeEnum currencyEnum) {
		this.currencyEnum = currencyEnum;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
