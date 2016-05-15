package pl.stockExchange.stock.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.CompanyTo;

public class CompanyMapper {

	public static CompanyTo map(CompanyEntity companyEntity) {
		if (companyEntity != null) {
			return new CompanyTo(companyEntity.getId(), companyEntity.getName(), ShareMapper.map2To(companyEntity.getShare()));
		}
		return null;
	}

	public static CompanyEntity map(CompanyTo companyTo) {
		if (companyTo != null) {
			CompanyEntity companyEntity = new CompanyEntity(companyTo.getId(),
					companyTo.getCompanyName(), null);
			List<ShareEntity> shareEntity = ShareMapper.map2Entity(companyTo
					.getShare());
			shareEntity.forEach(sp -> sp.setCompany(companyEntity));
			companyEntity.setShare(shareEntity);
			return companyEntity;
		}
		return null;
	}

	public static List<CompanyTo> map2To(List<CompanyEntity> companyEntities) {
		return companyEntities.stream().map(CompanyMapper::map).collect(Collectors.toList());
	}

	public static List<CompanyEntity> map2Entity(List<CompanyTo> companyEntities) {
		return companyEntities.stream().map(CompanyMapper::map).collect(Collectors.toList());
	}

}
