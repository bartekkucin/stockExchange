package pl.stockExchange.stock.service.shareService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.ShareTo;

public interface IShareService {

	List<ShareTo> findSharesByCompanyName(String companyName);

	List<ShareTo> findSharesByCompanyId(Long id);
	
	ShareTo getLatestShareByCompanyName(String companyName);

	List<ShareTo> findSharesByDate(Date date);

	List<ShareTo> findAll();

	ShareTo findById(Long id);

	ShareTo save(ShareTo shareTo);

	void update(ShareTo shareTo);

	void delete(Long id);

}
