package pl.stockExchange.bank.currency.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stockExchange.bank.currency.dao.ICurrencyDao;
import pl.stockExchange.bank.currency.service.ICurrencyService;
import pl.stockExchange.bank.model.entity.to.CurrencyTo;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.service.companyService.ICompanyService;

@Service
@Transactional(readOnly = true)
public class CurrencyServiceImpl implements ICurrencyService {
	
	@Autowired
	private ICurrencyDao currencyDao;

	@Override
	public List<CurrencyTo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CurrencyTo> updateAllCurrencies(List<CurrencyTo> currencies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyTo findCurrencyByName(String currencyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyTo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyTo save(CurrencyTo companyTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CurrencyTo companyTo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


}
