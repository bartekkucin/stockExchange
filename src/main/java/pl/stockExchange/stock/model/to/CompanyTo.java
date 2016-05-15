package pl.stockExchange.stock.model.to;

import java.util.List;

import pl.stockExchange.stock.model.entity.ShareEntity;

public class CompanyTo implements Comparable<CompanyTo> {

	private Long id;
	private String companyName;
	private List<ShareTo> share;

	public CompanyTo(Long id, String companyName, List<ShareTo> share ) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.share = share;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

	public List<ShareTo> getShare() {
		return share;
	}

	public void setShare(List<ShareTo> share) {
		this.share = share;
	}

	@Override
	public int compareTo(CompanyTo o) {
		return this.companyName.compareTo(o.companyName);

	}

}
