package pl.stockExchange.broker;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pl.stockExchange.bank.helper.SavedShare;
import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;

public interface IBrokerOffice {
	
	List<ShareTo> findSharesByCompanyName(String companyName);

	List<ShareTo> findSharesByCompanyId(Long id);

	List<ShareTo> findSharesByDate(Date date);
	
	CompanyTo findCompanyById(Long id);
	
	List<ShareTo> findSharesByCompanyNameAndAddBrokerPromise(String companyName);
	
	BigDecimal buy(String companyName, int amount);
	
	SavedShare sell(String companyName, int amount);
	

}
