package pl.stockExchange.stock.dao;

import static org.junit.Assert.*;

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

import pl.stockExchange.stock.model.entity.ShareEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class ShareDaoImplTest {
	
	@Autowired
	private ShareDao shareDao;
	
	@Test
	public void testShouldFindSharesByCompanyName() {
		
		final String companyName = "test";
		List<ShareEntity> shares = new ArrayList<>();
		shares=shareDao.findSharesByCompanyName(companyName);
		assertEquals(2, shares.size());
	}
	
	@Test
	public void testShouldFindSharesByCompanyId() {
		
		final Long companyId = 1L;
		List<ShareEntity> shares = new ArrayList<>();
		shares=shareDao.findSharesByCompanyId(companyId);
		assertEquals(2, shares.size());
	}
	
	@Test
	public void testShouldFindLatestShareByCompanyName() throws ParseException {
		
		final String companyName = "test";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2013-02-03");
		ShareEntity share =shareDao.getLatestShareByCompanyName(companyName);
		assertEquals(date, share.getShareDate());
	}
	
	

}
