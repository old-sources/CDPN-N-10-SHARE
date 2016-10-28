package fr.imie;

import javax.ejb.Local;

@Local
public interface IGiveService {

	void give(UserEntity userEntity, CrowdFundingEntity crowdFundingEntity, Integer value);

}
