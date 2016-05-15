package pl.stockExchange.stock.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.stockExchange.abstractDao.Dao;
import pl.stockExchange.stock.model.entity.CompanyEntity;


public interface CompanyDao extends Dao<CompanyEntity, Long> {
	
	CompanyEntity findCompanyByName(String name);

}
