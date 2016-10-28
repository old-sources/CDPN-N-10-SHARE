package fr.imie;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
@Default
@Stateless
@Regular
public class GiveServiceORM implements IGiveService {

	private @PersistenceContext EntityManager entityManager;

	@Override
	public void give(UserEntity userEntity, CrowdFundingEntity crowdFundingEntity, Integer value) {
		DonEntity donEntity= new DonEntity();
		donEntity.setCrowdFunding(crowdFundingEntity);
		donEntity.setUser(userEntity);
		donEntity.setValue(value);
		entityManager.persist(donEntity);
		
	}



}
