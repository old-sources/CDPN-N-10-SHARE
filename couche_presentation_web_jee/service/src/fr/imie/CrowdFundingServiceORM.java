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
public class CrowdFundingServiceORM implements ICrowdFundingService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CrowdFundingEntity> getAllCrowdFunfingDTO() {

		List<CrowdFundingEntity> retour = entityManager.createNamedQuery("CrowdFundingEntity.findAll").getResultList();
		for (CrowdFundingEntity crowdFundingEntity : retour) {
			this.completeEntity(crowdFundingEntity);
		}
		return retour;

	}

	private void completeEntity(CrowdFundingEntity crowdFundingEntity) {
		Integer aim = crowdFundingEntity.getGoal();
		for (DonEntity donEntity : crowdFundingEntity.getDons()) {
			aim-= donEntity.getValue();
		}
		crowdFundingEntity.setAim(aim);
		crowdFundingEntity.getDons();
		
	}


}
