package fr.imie;

import java.util.List;

import javax.ejb.Local;

import fr.imie.CrowdFundingEntity;

@Local
public interface ICrowdFundingService {
	public List<CrowdFundingEntity> getAllCrowdFunfingDTO();
	
}
