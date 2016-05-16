package pl.stockExchange.strategy;

import java.util.Date;
import java.util.List;

import pl.stockExchange.stock.model.to.ShareTo;

public interface Strategy {
	
	 List<Long> saleShareDecison(List<ShareTo> shares);

	 List<Long> buyShareDecision(List<ShareTo> shares);

}
