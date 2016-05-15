package pl.stockExchange.bank.bankAccount.service;

import java.math.BigDecimal;
import java.util.List;

import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.bank.model.entity.to.BankAccountTo;

public interface IBankService {

	List<BankAccountTo> findBankAccountByClientSerialId(String serialId);

	BankAccountTo findBankAccountBySerialidAndCurrencyType(String serialId, BankAccountCurrencyTypeEnum currency);
	
	BigDecimal getMoneyFromBankAccountByClientIdAndCurrency(String serialId, BankAccountCurrencyTypeEnum currencyEnum);

	BankAccountTo findById(Long id);
	
	BankAccountTo currencyConversion(BankAccountTo bankAccountTo);
	
	BigDecimal getMoneyFromAccount(BankAccountTo bankAccountTo);

	BankAccountTo save(BankAccountTo bankAccountTo);

	void update(BankAccountTo bankAccountTo);

	void delete(Long id);

}
