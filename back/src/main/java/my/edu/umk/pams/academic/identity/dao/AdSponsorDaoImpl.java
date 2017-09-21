package my.edu.umk.pams.academic.identity.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

import static my.edu.umk.pams.academic.core.AdMetaState.ACTIVE;

/**
 * @author PAMS
 */
@SuppressWarnings({"unchecked"})
@Repository("sponsorDao")
public class AdSponsorDaoImpl extends GenericDaoSupport<Long, AdSponsor> implements AdSponsorDao {
	
    private static final Logger LOG = LoggerFactory.getLogger(AdSponsorDaoImpl.class);

    public AdSponsorDaoImpl() {
        super(AdSponsorImpl.class);
    }

	@Override
	public AdSponsor findBySponsorNo(String sponsorNo) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdSponsor a where " +
                "a.identityNo = :identityNo");
        query.setString("identityNo", sponsorNo);
        return (AdSponsor) query.uniqueResult();
	}

	@Override
	public AdSponsorship findSponsorshipById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (AdSponsorship) session.get(AdSponsorshipImpl.class, id);
	}

	@Override
	public List<AdSponsor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSponsor s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", ACTIVE.ordinal());
        return query.list();
	}

	@Override
	public List<AdSponsorship> findSponsorships(AdSponsor sponsor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdSponsorship a where " +
                "a.sponsor = :sponsor "+
                "and a.metadata.state = :state");
        query.setEntity("sponsor", sponsor);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdSponsorship>) query.list();
	}

	@Override
	public Integer countSponsorship(AdSponsor sponsor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSponsorship s where " +
                "s.sponsor = :sponsor " +
                "and s.metadata.state = :state ");
        query.setEntity("sponsor", sponsor);
        query.setInteger("state", ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public boolean hasSponsorship(AdSponsor sponsor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSponsorship s where " +
                "s.sponsor = :sponsor " +
                "and s.metadata.state = :state ");
        query.setEntity("sponsor", sponsor);
        query.setInteger("state", ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue() >= 1;
	}

	@Override
	public void addSponsorship(AdSponsor sponsor, AdSponsorship sponsorship, AdUser user) {
        Validate.notNull(sponsor, "Sponsor should not be null");
        Validate.notNull(sponsorship, "Sponsorship should not be null");

        Session session = sessionFactory.getCurrentSession();
        sponsorship.setSponsor(sponsor);

        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(ACTIVE);
        sponsorship.setMetadata(metadata);

        session.save(sponsorship);
		
	}

	@Override
	public void removeSponsorship(AdSponsor sponsor, AdSponsorship sponsorship, AdUser user) {
        Validate.notNull(sponsor, "Sponsor should not be null");
        Validate.notNull(sponsorship, "Sponsorship should not be null");

        Session session = sessionFactory.getCurrentSession();
        AdMetadata metadata = sponsorship.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(AdMetaState.INACTIVE);
        sponsorship.setMetadata(metadata);
        session.update(sponsor);
		
	}
    
  
}
