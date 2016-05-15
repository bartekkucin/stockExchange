package pl.stockExchange.stock.model.to;

import java.math.BigDecimal;
import java.util.Date;

public class ShareTo {

	private Long id;
	private Long companyid;
	private BigDecimal price;
	private Date date;

	public ShareTo(Long id, Long companyid, BigDecimal price, Date date) {
		super();
		this.id = id;
		this.companyid = companyid;
		this.price = price;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
