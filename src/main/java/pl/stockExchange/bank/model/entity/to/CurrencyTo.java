package pl.stockExchange.bank.model.entity.to;

import java.math.BigDecimal;
import java.util.Date;

import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;

public class CurrencyTo {

	private Long id;
	private String currency;
	private Date lastCurrencyUpdate;
	private BigDecimal currencyValue;

	public CurrencyTo(Long id, String currency, Date lastCurrencyUpdate, BigDecimal currencyValue) {
		super();
		this.id = id;
		this.currency = currency;
		this.lastCurrencyUpdate = lastCurrencyUpdate;
		this.currencyValue = currencyValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getLastCurrencyUpdate() {
		return lastCurrencyUpdate;
	}

	public void setLastCurrencyUpdate(Date lastCurrencyUpdate) {
		this.lastCurrencyUpdate = lastCurrencyUpdate;
	}

	public BigDecimal getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}

}
