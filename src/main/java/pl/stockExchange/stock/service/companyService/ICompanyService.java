package pl.stockExchange.stock.service.companyService;

import java.util.Collection;
import java.util.List;

import pl.stockExchange.stock.model.to.CompanyTo;

public interface ICompanyService {
	
	CompanyTo findCompanyByName(String name);
	
	List<CompanyTo> findAll();

	List<CompanyTo> saveAll(List<CompanyTo> shares);

	CompanyTo findById(Long id);

	CompanyTo save(CompanyTo companyTo);

	void update(CompanyTo companyTo);

	void delete(Long id);

}
