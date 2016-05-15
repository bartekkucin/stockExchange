package pl.stockExchange.bank.currency.dao;


import java.util.List;

import pl.stockExchange.abstractDao.Dao;
import pl.stockExchange.bank.model.entity.CurrencyEntity;

public interface ICurrencyDao extends Dao<CurrencyEntity, Long> {
	
	List<CurrencyEntity> updateCurrencies(List<CurrencyEntity> currencies);
	
	CurrencyEntity findCurrencyByName(String currencyName);

}
