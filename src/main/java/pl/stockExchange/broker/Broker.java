package pl.stockExchange.broker;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.stockExchange.bank.helper.SavedShare;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;
import pl.stockExchange.stock.service.stockExchangeService.IStockExchangeService;

@Component
public class Broker implements IBrokerOffice {

	private static final BigDecimal sellPromise = new BigDecimal("0.005");
	private static final BigDecimal buyPromise = new BigDecimal("0.005");

	@Autowired
	private IStockExchangeService stockExchangeService;

	@Override
	public List<ShareTo> findSharesByCompanyName(String companyName) {
		return stockExchangeService.findSharesByCompanyName(companyName);
	}

	@Override
	public List<ShareTo> findSharesByCompanyId(Long id) {
		return stockExchangeService.findSharesByCompanyId(id);
	}

	@Override
	public List<ShareTo> findSharesByDate(Date date) {
		return stockExchangeService.findSharesByDate(date);
	}

	@Override
	public BigDecimal buy(String companyName, int amount) {
		BigDecimal latestShareCost = stockExchangeService.getLatestShareByCompanyName(companyName).getPrice();
		return addBuyingPromise(latestShareCost).multiply(new BigDecimal(amount));


	}

	@Override
	public SavedShare sell(String companyName, int amount) {
		BigDecimal latestShareCost = stockExchangeService.getLatestShareByCompanyName(companyName).getPrice();
		return new SavedShare(amount, addSellingPromise(latestShareCost).multiply(new BigDecimal(amount)), companyName);
	}

	@Override
	public List<ShareTo> findSharesByCompanyNameAndAddBrokerPromise(String companyName) {
		List<ShareTo> shares = stockExchangeService.findSharesByCompanyName(companyName);
		for (ShareTo share : shares) {
			BigDecimal sharePrice = share.getPrice();
			BigDecimal updatedPrice = sharePrice.add(sharePrice.multiply(sellPromise));
			share.setPrice(updatedPrice);
		}
		return shares;
	}
	
	private BigDecimal addBuyingPromise(BigDecimal value) {
		BigDecimal brokerPromise = value.multiply(buyPromise);
    	if(brokerPromise.doubleValue() < 5.0)
    	{
    	 brokerPromise = new BigDecimal("5");
    	 return value.subtract(brokerPromise);
    	}
        return BigDecimal.ONE.subtract(buyPromise).multiply(value);
    }

    private BigDecimal addSellingPromise(BigDecimal value) {
    	BigDecimal brokerPromise = value.multiply(sellPromise);
    	if(brokerPromise.doubleValue() < 5.0)
    	{
    	 brokerPromise = new BigDecimal("5");
    	 return brokerPromise.add(value);
    	}
    	
        return BigDecimal.ONE.add(sellPromise).multiply(value);
    }

	@Override
	public CompanyTo findCompanyById(Long id) {
		return stockExchangeService.findCompanyById(id);
	}

}
