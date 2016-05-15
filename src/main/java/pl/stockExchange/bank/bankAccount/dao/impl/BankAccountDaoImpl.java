package pl.stockExchange.bank.bankAccount.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import pl.stockExchange.abstractDao.AbstractDao;
import pl.stockExchange.bank.bankAccount.dao.IBankAccountDao;
import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.bank.model.entity.BankAccountEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;


@Component
public class BankAccountDaoImpl extends AbstractDao<BankAccountEntity, Long> implements IBankAccountDao{

	@Override
	public List<BankAccountEntity> findBankAccountByClientSerialId(String serialId) {
		TypedQuery<BankAccountEntity> query = entityManager.createQuery(
				"select bank from BankAccountEntity bank where bank.client_number like :serialId",
				BankAccountEntity.class);
		query.setParameter("serialId", serialId);
		return query.getResultList();
	}

	@Override
	public BankAccountEntity findBankAccountBySerialidAndCurrencyType(String serialId, BankAccountCurrencyTypeEnum currency) {
		TypedQuery<BankAccountEntity> query = entityManager.createQuery(
				"select bank from BankAccountEntity bank where bank.clientNumber like :serialId and bank.currency like :currency",
				BankAccountEntity.class);
		query.setParameter("serialId", serialId);
		query.setParameter("currency", currency);
		return query.getSingleResult();
	}

	@Override
	public BigDecimal getMoneyFromBankAccountByClientIdAndCurrency(String serialId,
			BankAccountCurrencyTypeEnum currencyEnum) {
		TypedQuery<BankAccountEntity> query = entityManager.createQuery(
				"select bank from BankAccountEntity bank where bank.clientNumber like :serialId and bank.currency like :currency",
				BankAccountEntity.class);
		query.setParameter("serialId", serialId);
		query.setParameter("currency", currencyEnum);
		return query.getSingleResult().getAmount();
	}

	

}
