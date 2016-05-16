package pl.stockExchange.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import pl.stockExchange.stock.model.to.ShareTo;
import pl.stockExchange.strategy.Strategy;

public class RandomStrategy implements Strategy{

	@Override
	public List<Long> saleShareDecison(List<ShareTo> shares) {
		List<Long> companyIds = new ArrayList<>();
		for(ShareTo share : shares)
		{
			int value = (int)(Math.random()* 2);
			if(value == 1)
			{
				companyIds.add(share.getCompanyid());
				
			}
		}
		return companyIds;
	}

	@Override
	public List<Long> buyShareDecision(List<ShareTo> shares) {
		List<Long> companyIds = new ArrayList<>();
		for(ShareTo share : shares)
		{
			int value = (int)(Math.random()* 2);
			if(value == 1)
			{
				companyIds.add(share.getCompanyid());
				
			}
		}
		return companyIds;
	}
	
	

}
