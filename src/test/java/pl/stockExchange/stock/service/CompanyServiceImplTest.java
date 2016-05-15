package pl.stockExchange.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.stockExchange.stock.dao.CompanyDao;
import pl.stockExchange.stock.helper.ShareCSVReader;
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;
import pl.stockExchange.stock.service.companyService.ICompanyService;
import pl.stockExchange.stock.service.shareService.IShareService;
import pl.stockExchange.stock.service.stockExchangeService.IStockExchangeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class CompanyServiceImplTest {
	
	@Autowired
	private ICompanyService compService;
	
	@Autowired
	private IStockExchangeService stockExchangeService;

	
	@Test
    public void testShouldSaveShare() throws ParseException {
        // given
        final long companyId = 1;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2013-02-02");
        List<ShareTo> shares = new ArrayList<>();
        shares.add(new ShareTo(null, null, new BigDecimal("123"), date));
        // when
        CompanyTo company = new CompanyTo(null, "dupa", shares);
        company = compService.save(company);
        // then
        assertNotNull(company);
        //assertEquals("dupa", share.getCompany().getCompanyName());
    }
	
	@Test
    public void testShouldUseShareServiceAndFindShare() throws ParseException {
		
		ShareTo share = stockExchangeService.findByShareId(1L);
		assertNotNull(share);
		
	}
	
	@Test
    public void testShouldSaveData() throws ParseException, IOException {
		
		ShareCSVReader shareCSVReader = new ShareCSVReader();
		final String filePath = "../stockExchange/src/main/resources/dane.csv";
		List<CompanyTo> comp = shareCSVReader.getDataForCompanyTo(filePath);

		List<CompanyTo> comp3 = stockExchangeService.saveAllData(comp);
		assertNotNull(comp3);
		
	}
	}

