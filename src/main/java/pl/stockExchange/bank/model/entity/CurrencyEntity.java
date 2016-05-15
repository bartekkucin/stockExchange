package pl.stockExchange.bank.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CURRENCY")
public class CurrencyEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "currency_value", nullable = false)
	private BigDecimal currencyValue;
	
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;

	@Column(name = "currency", nullable = false)
	private String currency;
	
	protected CurrencyEntity() {
	}

	public CurrencyEntity(Long id, BigDecimal currencyValue, Date lastUpdate, String currency) {
		super();
		this.id = id;
		this.currencyValue = currencyValue;
		this.currency = currency;
		this.lastUpdate = lastUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	
	


}
