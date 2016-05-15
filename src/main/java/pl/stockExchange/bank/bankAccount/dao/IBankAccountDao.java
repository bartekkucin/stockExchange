package pl.stockExchange.bank.bankAccount.dao;

import java.math.BigDecimal;
import java.util.List;

import pl.stockExchange.abstractDao.Dao;
import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.bank.model.entity.BankAccountEntity;
import pl.stockExchange.stock.model.entity.CompanyEntity;

public interface IBankAccountDao extends Dao<BankAccountEntity, Long>{
	
	List<BankAccountEntity> findBankAccountByClientSerialId(String serialId);
	BigDecimal getMoneyFromBankAccountByClientIdAndCurrency(String serialId, BankAccountCurrencyTypeEnum currencyEnum);
	BankAccountEntity findBankAccountBySerialidAndCurrencyType(String serialId, BankAccountCurrencyTypeEnum currency);

}
