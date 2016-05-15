package pl.stockExchange.stock.service.stockExchangeService;

import java.util.Date;
import java.util.List;

import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;

public interface IStockExchangeService {

	ShareTo findByShareId(Long id);

	ShareTo saveShare(ShareTo shareTo);

	List<ShareTo> findAllShares();

	List<CompanyTo> saveAllData(List<CompanyTo> shares);

	CompanyTo findCompanyByName(String name);

	List<CompanyTo> findAllCompanies();

	CompanyTo findCompanyById(Long id);
	
	ShareTo getLatestShareByCompanyName(String companyName);
	
	List<ShareTo> findSharesByCompanyName(String companyName);

	List<ShareTo> findSharesByCompanyId(Long id);

	List<ShareTo> findSharesByDate(Date date);
}
