package pl.stockExchange.bank.model.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.stockExchange.bank.model.entity.CurrencyEntity;
import pl.stockExchange.bank.model.entity.to.CurrencyTo;

public class CurrencyMapper {

	public static CurrencyTo map(CurrencyEntity currencyEntity) {
		if (currencyEntity != null) {
			return new CurrencyTo(currencyEntity.getId(), currencyEntity.getCurrency(), currencyEntity.getLastUpdate(),
					currencyEntity.getCurrencyValue());
		}
		return null;
	}

	public static CurrencyEntity map(CurrencyTo currencyTo) {
		if (currencyTo != null) {
			return new CurrencyEntity(currencyTo.getId(), currencyTo.getCurrencyValue(),
					currencyTo.getLastCurrencyUpdate(), currencyTo.getCurrency());
		}
		return null;
	}

	public static List<CurrencyTo> map2To(List<CurrencyEntity> bankAccountEntities) {
		return bankAccountEntities.stream().map(CurrencyMapper::map).collect(Collectors.toList());
	}

	public static List<CurrencyEntity> map2Entity(List<CurrencyTo> bankAccountEntities) {
		return bankAccountEntities.stream().map(CurrencyMapper::map).collect(Collectors.toList());
	}
}