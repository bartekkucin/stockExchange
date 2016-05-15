package pl.stockExchange.stock.service.shareService.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stockExchange.stock.dao.CompanyDao;
import pl.stockExchange.stock.dao.ShareDao;
import pl.stockExchange.stock.mapper.CompanyMapper;
import pl.stockExchange.stock.mapper.ShareMapper;
import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.ShareTo;
import pl.stockExchange.stock.service.shareService.IShareService;

@Service
@Transactional(readOnly = true)
public class ShareServiceImpl implements IShareService {

	@Autowired
	private ShareDao shareDao;

	@Override
	public List<ShareTo> findSharesByCompanyName(String companyName) {
		return ShareMapper.map2To(shareDao.findSharesByCompanyName(companyName));
	}

	@Override
	public List<ShareTo> findSharesByCompanyId(Long id) {
		return ShareMapper.map2To(shareDao.findSharesByCompanyId(id));

	}

	@Override
	public List<ShareTo> findSharesByDate(Date date) {
		return ShareMapper.map2To(shareDao.findSharesByDate(date));

	}

	@Override
	public List<ShareTo> findAll() {
		return ShareMapper.map2To(shareDao.findAll());
	}

	@Override
	public ShareTo findById(Long id) {
		return ShareMapper.map(shareDao.findOne(id));
	}

	@Override
	@Transactional(readOnly = false)
	public ShareTo save(ShareTo shareTo) {
		ShareEntity shareEntity = ShareMapper.map(shareTo);
		shareEntity = shareDao.save(shareEntity);
		return ShareMapper.map(shareEntity);

	}

	@Override
	@Transactional
	public void update(ShareTo shareTo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShareTo getLatestShareByCompanyName(String companyName) {
		return ShareMapper.map(shareDao.getLatestShareByCompanyName(companyName));
	}

}
