package pl.stockExchange.stock.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.stockExchange.abstractDao.Dao;
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;


public interface ShareDao extends Dao<ShareEntity, Long> {
	
	List<ShareEntity> findSharesByDate(Date date);
	List<ShareEntity> findSharesByCompanyName(String companyName);
	ShareEntity getLatestShareByCompanyName(String companyName);
	List<ShareEntity> findSharesByCompanyId(Long id);

}