package pl.stockExchange.stock.dao;

import static org.junit.Assert.*;

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
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class CompanyDaoImplTest {
	
	@Autowired
	private CompanyDao companyDao;
	
	
	
	@Test
    public void testShouldFindById() {
        // given
        final long companyId = 1;
        // when
        CompanyEntity companyEntity = companyDao.findOne(companyId);
        // then
        //assertNotNull(companyEntity);
        //assertEquals("dupa", companyEntity.getName());
    }
	
	@Test
    public void testShouldSaveCompanyWithShares() throws ParseException {
        // given
        final long companyId = 1;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2013-02-02");
        List<ShareEntity> shares = new ArrayList<>();
        shares.add(new ShareEntity(null, new BigDecimal("123"), date, null));
        CompanyEntity compay = new CompanyEntity(null, "dupa", shares);
        // when
        compay = companyDao.save(compay);
        // then

        //assertEquals(1, shareDao.findAll());
        //assertEquals(Long.valueOf(1L), Long.valueOf(compay.getId()));
    }
	

}
