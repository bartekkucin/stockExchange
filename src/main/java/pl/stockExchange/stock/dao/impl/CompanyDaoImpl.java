package pl.stockExchange.stock.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import pl.stockExchange.abstractDao.AbstractDao;
import pl.stockExchange.stock.dao.CompanyDao;
import pl.stockExchange.stock.model.entity.CompanyEntity;

@Component
public class CompanyDaoImpl extends AbstractDao<CompanyEntity, Long> implements  CompanyDao{

	@Override
	public CompanyEntity findCompanyByName(String name) {
		TypedQuery<CompanyEntity> query = entityManager.createQuery(
				"select company from CompanyEntity company where company.name like :name",
				CompanyEntity.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
