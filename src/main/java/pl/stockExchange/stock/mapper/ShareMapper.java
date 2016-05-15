package pl.stockExchange.stock.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.stockExchange.stock.model.entity.CompanyEntity;
import pl.stockExchange.stock.model.entity.ShareEntity;
import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;

public class ShareMapper {
	
	public static ShareTo map(ShareEntity shareEntity) {
		if (shareEntity != null) {
			return new ShareTo(shareEntity.getId(), shareEntity.getCompany().getId(), shareEntity.getPrice(), shareEntity.getShareDate());
		}
		return null;
	}

	public static ShareEntity map(ShareTo shareTo) {
		if (shareTo != null) {
			return new ShareEntity(shareTo.getId(),  shareTo.getPrice(), shareTo.getDate(), null);
		}
		return null;
	}

	public static List<ShareTo> map2To(List<ShareEntity> shareEntities) {
		return shareEntities.stream().map(ShareMapper::map).collect(Collectors.toList());
	}

	public static List<ShareEntity> map2Entity(List<ShareTo> companyEntities) {
		return companyEntities.stream().map(ShareMapper::map).collect(Collectors.toList());
	}

}
