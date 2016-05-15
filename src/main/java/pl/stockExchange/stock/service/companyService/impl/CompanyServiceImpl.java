package pl.stockExchange.stock.service.companyService.impl;



import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stockExchange.stock.dao.CompanyDao;
import pl.stockExchange.stock.mapper.CompanyMapper;
import pl.stockExchange.stock.mapper.ShareMapper;
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.service.companyService.ICompanyService;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
    private CompanyDao companyDao;

	@Override
	public List<CompanyTo> findAll() {
		return CompanyMapper.map2To(companyDao.findAll());
	}

	@Override
	@Transactional(readOnly = false)
	public List<CompanyTo> saveAll(List<CompanyTo> companies) {
		List<CompanyEntity> entities = CompanyMapper.map2Entity(companies);
		for(CompanyEntity entity : entities)
		{
			entity = companyDao.save(entity);
		}
		return CompanyMapper.map2To(entities);
	}

	@Override
	public CompanyTo findById(Long id) {
		return CompanyMapper.map(companyDao.findOne(id));
	}

	@Override
	@Transactional(readOnly = false)
	public CompanyTo save(CompanyTo companyTo) {
		CompanyEntity companyEntity = CompanyMapper.map(companyTo);
		companyEntity = companyDao.save(companyEntity);
		return CompanyMapper.map(companyEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(CompanyTo companyTo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CompanyTo findCompanyByName(String name) {
		return CompanyMapper.map(companyDao.findCompanyByName(name));
	}

}
