package pl.stockExchange.stock.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import pl.stockExchange.abstractDao.AbstractDao;
import pl.stockExchange.stock.dao.CompanyDao;
import pl.stockExchange.stock.dao.ShareDao;
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;

@Component
public class ShareDaoImpl extends AbstractDao<ShareEntity, Long> implements  ShareDao{

	@Override
	public List<ShareEntity> findSharesByDate(Date shareDate) {
		
		TypedQuery<ShareEntity> query = entityManager.createQuery(
				"select share from ShareEntity share where share.sharedate like :shareDate",
				ShareEntity.class);
		query.setParameter("shareDate", shareDate);
		return query.getResultList();
	}

	@Override
	public List<ShareEntity> findSharesByCompanyName(String companyName) {
		TypedQuery<ShareEntity> query = entityManager.createQuery(
				"select share from ShareEntity share join fetch share.companyid company "
				+ "where company.name  = :companyName",
				ShareEntity.class);
		query.setParameter("companyName", companyName);
		return query.getResultList();
	}
	
	@Override
	public List<ShareEntity> findSharesByCompanyId(Long id) {
		TypedQuery<ShareEntity> query = entityManager.createQuery(
				"select share from ShareEntity share where share.companyid.id = :id",
				ShareEntity.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public ShareEntity getLatestShareByCompanyName(String companyName) {
		TypedQuery<ShareEntity> query = entityManager.createQuery(
				"select share from ShareEntity share join fetch share.companyid company "
				+ "where company.name  = :companyName order by share.sharedate DESC",
				ShareEntity.class);
		query.setParameter("companyName", companyName);
		List<ShareEntity> shares = query.getResultList();
		query.setMaxResults(1);
		return query.getSingleResult();
	}

}
