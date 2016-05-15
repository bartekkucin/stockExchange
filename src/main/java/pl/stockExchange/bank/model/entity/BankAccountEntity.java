package pl.stockExchange.bank.model.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.stock.model.entity.ShareEntity;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccountEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "client_number", nullable = false)
	private String clientNumber;

	@Column(name = "currency_type", nullable = false)
	private BankAccountCurrencyTypeEnum currency;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
	
	protected BankAccountEntity() {
	}

	public BankAccountEntity(Long id, String clientNumber, BankAccountCurrencyTypeEnum currency,
			BigDecimal amount) {
		super();
		this.id = id;
		this.clientNumber = clientNumber;
		this.currency = currency;
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
		return currency;
	}

	public void setCurrencyEnum(BankAccountCurrencyTypeEnum currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	

}
