package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdSponsorship;
import my.edu.umk.pams.academic.identity.model.AdStudent;

import java.util.List;

import my.edu.umk.pams.academic.identity.model.AdUser;

public interface AdSponsorshipDao extends GenericDao<Long, AdSponsorship> {
	
	// ====================================================================================================
    // FINDER
    // ====================================================================================================
	
	AdSponsorship findSponsorshipById(Long id);
	
	List<AdSponsorship> findSponsorships(AdSponsorship sponsorship);

    List<AdSponsorship> find(String filter, Integer offset, Integer limit);
    
	void addSponsorship(AdStudent student, AdSponsorship sponsorship, AdUser user);

	AdSponsorship findByReferenceNo(String referenceNo);

	void updateSponsorship(AdStudent student, AdSponsorship sponsorship, AdUser user);

	void removeSponsorship(AdStudent student, AdSponsorship sponsorship, AdUser user);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    //Integer count(String filter);


}
