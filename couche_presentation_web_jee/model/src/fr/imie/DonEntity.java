package fr.imie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "don" database table.
 * 
 */
@Entity
@Table(name="don")
@NamedQuery(name="DonEntity.findAll", query="SELECT d FROM DonEntity d")
public class DonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="valeur")
	private Integer value;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumns({
        @JoinColumn(name="personne_id", referencedColumnName="id")
		})
	private UserEntity user;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumns({
        @JoinColumn(name="projet_id", referencedColumnName="id")
		})
	private CrowdFundingEntity crowdFunding;

	public DonEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public CrowdFundingEntity getCrowdFunding() {
		return crowdFunding;
	}

	public void setCrowdFunding(CrowdFundingEntity crowdFunding) {
		this.crowdFunding = crowdFunding;
	}

	

}