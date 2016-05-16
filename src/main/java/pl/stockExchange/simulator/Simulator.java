package pl.stockExchange.simulator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.stockExchange.client.Client;
import pl.stockExchange.client.shareWallet.ShareWalletManager;
import pl.stockExchange.strategy.impl.RandomStrategy;

@Component
public class Simulator {
	
	@Autowired
	Client client;
	
	ShareWalletManager shareWalletManager = new ShareWalletManager();
	
	public void startSimulation(Date startDate, int numberOfDays) throws ParseException
	{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        startDate = formatter.parse(dateString);
        
		client.setClientSerialNumber("123");
		client.setShareWallet(shareWalletManager.createShareWallet("123"));
		client.setStrategy(new RandomStrategy());
		for(int i = 0; i< numberOfDays; i++){
			client.initDecisions(startDate);
			long timeadj = 24*60*60*1000;
			startDate = new Date(startDate.getTime() + timeadj);
			
		}
		
		//client.summary();
		
	}
	

}
