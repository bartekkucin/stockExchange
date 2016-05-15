package pl.stockExchange.stock.service.stockExchangeService.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;
import pl.stockExchange.stock.service.companyService.ICompanyService;
import pl.stockExchange.stock.service.shareService.IShareService;
import pl.stockExchange.stock.service.stockExchangeService.IStockExchangeService;

@Service
@Transactional(readOnly = true)
public class StockExchangeImpl implements IStockExchangeService {
	
	@Autowired
	private IShareService shareService;
	
	@Autowired
	private ICompanyService companyService;
	
	@Override
	public List<ShareTo> findSharesByCompanyName(String companyName) {
		return shareService.findSharesByCompanyName(companyName);
	}

	@Override
	public List<ShareTo> findSharesByCompanyId(Long id) {
		return shareService.findSharesByCompanyId(id);
	}

	@Override
	public List<ShareTo> findSharesByDate(Date date) {
		return shareService.findSharesByDate(date);
	}

	@Override
	public ShareTo findByShareId(Long id) {
		return shareService.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public ShareTo saveShare(ShareTo shareTo) {
		return shareService.save(shareTo);
	}

	@Override
	public List<ShareTo> findAllShares() {
		return shareService.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public List<CompanyTo> saveAllData(List<CompanyTo> shares) {
		return companyService.saveAll(shares);
	}

	@Override
	public CompanyTo findCompanyByName(String name) {
		return companyService.findCompanyByName(name);
	}

	@Override
	public List<CompanyTo> findAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyTo findCompanyById(Long id) {
		return companyService.findById(id);
	}

	@Override
	public ShareTo getLatestShareByCompanyName(String companyName) {
		return shareService.getLatestShareByCompanyName(companyName);
	}

	

}
