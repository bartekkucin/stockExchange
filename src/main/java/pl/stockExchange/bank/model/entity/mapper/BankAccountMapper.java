package pl.stockExchange.bank.model.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.stockExchange.bank.model.entity.BankAccountEntity;
import pl.stockExchange.bank.model.entity.to.BankAccountTo;


public class BankAccountMapper {

	public static BankAccountTo map(BankAccountEntity bankAccountEntity) {
		if (bankAccountEntity != null) {
			return new BankAccountTo(bankAccountEntity.getId(), bankAccountEntity.getClientNumber(),
					bankAccountEntity.getCurrencyEnum(), bankAccountEntity.getAmount());
		}
		return null;
	}

	public static BankAccountEntity map(BankAccountTo bankAccountTo) {
		if (bankAccountTo != null) {
			return new BankAccountEntity(bankAccountTo.getId(), bankAccountTo.getClientNumber(),
					bankAccountTo.getCurrencyEnum(), bankAccountTo.getAmount());
		}
		return null;
	}

	public static List<BankAccountTo> map2To(List<BankAccountEntity> bankAccountEntities) {
		return bankAccountEntities.stream().map(BankAccountMapper::map).collect(Collectors.toList());
	}

	public static List<BankAccountEntity> map2Entity(List<BankAccountTo> bankAccountEntities) {
		return bankAccountEntities.stream().map(BankAccountMapper::map).collect(Collectors.toList());
	}

}
