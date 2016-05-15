package pl.stockExchange.stock.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANYENTITY")
public class CompanyEntity  {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "companyName", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyid", cascade = CascadeType.ALL)
	private List<ShareEntity> share;

	protected CompanyEntity() {
	}

	public CompanyEntity(Long id, String name, List<ShareEntity> share) {
		super();
		this.id = id;
		this.name = name;
		this.share = share;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ShareEntity> getShare() {
		return share;
	}

	public void setShare(List<ShareEntity> share) {
		this.share = share;
	}

}
