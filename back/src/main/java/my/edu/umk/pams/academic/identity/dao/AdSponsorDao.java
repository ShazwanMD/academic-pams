package my.edu.umk.pams.academic.identity.dao;

import java.util.List;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdSponsor;
import my.edu.umk.pams.academic.identity.model.AdSponsorship;
import my.edu.umk.pams.academic.identity.model.AdUser;

public interface AdSponsorDao extends GenericDao<Long, AdSponsor> {
	

    AdSponsor findBySponsorNo(String sponsorNo);


    AdSponsorship findSponsorshipById(Long id);

    List<AdSponsor> find(String filter, Integer offset, Integer limit);


    List<AdSponsorship> findSponsorships(AdSponsor sponsor);


    Integer countSponsorship(AdSponsor sponsor);

    boolean hasSponsorship(AdSponsor sponsor);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addSponsorship(AdSponsor sponsor, AdSponsorship sponsorship, AdUser user);

    void removeSponsorship(AdSponsor sponsor, AdSponsorship sponsorship, AdUser user);


}
