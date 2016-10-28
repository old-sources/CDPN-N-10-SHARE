package fr.imie;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="projet")
@NamedQuery(name="CrowdFundingEntity.findAll", query="SELECT p FROM CrowdFundingEntity p")
public class CrowdFundingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String name;
	
	@Column(name="objectif")
	private Integer goal;
	
	private String description;
	
	@OneToMany(mappedBy="crowdFunding")
	private List<DonEntity> dons;
	
	@Transient
	private Integer aim;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
	public Integer getAim() {
		return aim;
	}
	public void setAim(Integer aim) {
		this.aim = aim;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<DonEntity> getDons() {
		return dons;
	}
	public void setDons(List<DonEntity> dons) {
		this.dons = dons;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
