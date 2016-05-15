package pl.stockExchange.bank.currency.service;

import java.util.List;

import pl.stockExchange.bank.model.entity.to.CurrencyTo;


public interface ICurrencyService {
	
	List<CurrencyTo> findAll();

	List<CurrencyTo> updateAllCurrencies(List<CurrencyTo> currencies);
	
	CurrencyTo findCurrencyByName(String currencyName);

	CurrencyTo findById(Long id);

	CurrencyTo save(CurrencyTo companyTo);

	void update(CurrencyTo companyTo);

	void delete(Long id);

}
