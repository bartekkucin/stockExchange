package pl.stockExchange.stock.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "SHARE")
public class ShareEntity  {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Column(name = "sharedate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date sharedate;

	@ManyToOne
	@JoinColumn(name = "companyid")
	private CompanyEntity companyid;

	protected ShareEntity() {
	}

	public ShareEntity(Long id, BigDecimal price, Date sharedate, CompanyEntity companyid) {
		super();
		this.id = id;
		this.price = price;
		this.sharedate = sharedate;
		this.companyid = companyid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getShareDate() {
		return sharedate;
	}

	public void setShareDate(Date sharedate) {
		this.sharedate = sharedate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CompanyEntity getCompany() {
		return companyid;
	}

	public void setCompany(CompanyEntity companyid) {
		this.companyid = companyid;
	}

}
