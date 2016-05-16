package pl.stockExchange.bank.bankAccount.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stockExchange.bank.bankAccount.dao.IBankAccountDao;
import pl.stockExchange.bank.bankAccount.service.IBankService;
import pl.stockExchange.bank.currency.service.ICurrencyService;
import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.bank.model.entity.BankAccountEntity;
import pl.stockExchange.bank.model.entity.mapper.BankAccountMapper;
import pl.stockExchange.bank.model.entity.to.BankAccountTo;
import pl.stockExchange.bank.model.entity.to.CurrencyTo;
import pl.stockExchange.stock.mapper.ShareMapper;
import pl.stockExchange.stock.model.entity.ShareEntity;

@Service
@Transactional(readOnly = true)
public class BankServiceImpl implements IBankService{
	
	@Autowired
	private IBankAccountDao bankAccountDao;
	
	@Autowired
	private ICurrencyService currencyService;
	

	@Override
	public List<BankAccountTo> findBankAccountByClientSerialId(String serialId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountTo findBankAccountBySerialidAndCurrencyType(String serialId, BankAccountCurrencyTypeEnum currency) {
		return BankAccountMapper.map(bankAccountDao.findBankAccountBySerialidAndCurrencyType(serialId, currency));
	}


	@Override
	public BankAccountTo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public BankAccountTo save(BankAccountTo bankAccountTo) {
		BankAccountEntity  bankAccount = BankAccountMapper.map(bankAccountTo);
		bankAccount = bankAccountDao.save(bankAccount);
		return BankAccountMapper.map(bankAccount);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(BankAccountTo bankAccountTo) {
		BankAccountEntity  bankAccount = BankAccountMapper.map(bankAccountTo);
		bankAccount = bankAccountDao.update(bankAccount);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankAccountTo currencyConversion(BankAccountTo bankAccountTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getMoneyFromAccount(BankAccountTo bankAccountTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getMoneyFromBankAccountByClientIdAndCurrency(String serialId,
			BankAccountCurrencyTypeEnum currencyEnum) {
		return bankAccountDao.getMoneyFromBankAccountByClientIdAndCurrency(serialId, currencyEnum);
	}

	

}
