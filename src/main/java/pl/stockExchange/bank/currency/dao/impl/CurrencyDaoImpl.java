package pl.stockExchange.bank.currency.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.stockExchange.abstractDao.AbstractDao;
import pl.stockExchange.bank.currency.dao.ICurrencyDao;
import pl.stockExchange.bank.model.entity.CurrencyEntity;

@Component
public class CurrencyDaoImpl extends AbstractDao<CurrencyEntity, Long> implements ICurrencyDao {

	@Override
	public List<CurrencyEntity> updateCurrencies(List<CurrencyEntity> currencies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyEntity findCurrencyByName(String currencyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
