package fr.imie;

import java.sql.SQLException;
import java.util.List;

public interface IContributionDAO {

	List<DonEntity> getContributionsByCrowdFunding(CrowdFundingEntity crowdFundingEntity) throws SQLException;

}
