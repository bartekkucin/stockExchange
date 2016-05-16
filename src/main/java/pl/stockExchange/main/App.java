package pl.stockExchange.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import pl.stockExchange.bank.bankAccount.service.IBankService;
import pl.stockExchange.bank.bankAccount.service.impl.BankServiceImpl;
import pl.stockExchange.bank.enums.BankAccountCurrencyTypeEnum;
import pl.stockExchange.bank.model.entity.to.BankAccountTo;
import pl.stockExchange.client.Client;
import pl.stockExchange.client.shareWallet.ShareWalletManager;
import pl.stockExchange.simulator.Simulator;
import pl.stockExchange.stock.helper.ShareCSVReader;
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;
import pl.stockExchange.stock.service.stockExchangeService.IStockExchangeService;
import pl.stockExchange.stock.service.stockExchangeService.impl.StockExchangeImpl;

/**
 * Hello world!
 *
 */
@Component
public class App {

	@Autowired
	IStockExchangeService stockExchangeService;

	@Autowired
	IBankService bankService;

	@Autowired
	Simulator simulator;

	static ShareWalletManager shareWalletManager = new ShareWalletManager();

	static ShareCSVReader shareCSVReader = new ShareCSVReader();
	private static final String filePath = "../stockExchange/src/main/resources/dane.csv";

	public static void main(String[] args) throws IOException, ParseException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring.xml", "spring/database-context.xml");
		App main = ctx.getBean(App.class);
		List<BankAccountTo> banks = new ArrayList<>();
		List<CompanyTo> comp = shareCSVReader.getDataForCompanyTo(filePath);
		main.stockExchangeService.saveAllData(comp);
		banks.add(main.bankService
				.save(new BankAccountTo(null, "123", BankAccountCurrencyTypeEnum.PLN, new BigDecimal("10000"))));
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse("2013-01-02");

		main.simulator.startSimulation(date, 10);


	}
}
