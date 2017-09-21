package my.edu.umk.pams.academic.identity.dao;

import static my.edu.umk.pams.academic.core.AdMetaState.ACTIVE;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdSponsor;
import my.edu.umk.pams.academic.identity.model.AdSponsorship;
import my.edu.umk.pams.academic.identity.model.AdSponsorshipImpl;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;


@Repository("AdSponsorshipDao")
public class AdSponsorshipDaoImpl extends GenericDaoSupport<Long, AdSponsorship> implements AdSponsorshipDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdSponsorshipDaoImpl.class);

    public AdSponsorshipDaoImpl() {
        super(AdSponsorshipImpl.class);
    }

	@Override
	public AdSponsorship findSponsorshipById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (AdSponsorship) session.get(AdSponsorshipImpl.class, id);
	}

	@Override
	public List<AdSponsorship> findSponsorships(AdSponsorship sponsorship) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdSponsorship a where " +
                "a.sponsor = :sponsor "+
                "and a.metadata.state = :state");
        query.setEntity("sponsorship", sponsorship);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdSponsorship>) query.list();
	}

	@Override
	public List<AdSponsorship> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from AdSponsorship i where " +
                "(upper(i.code) like upper(:filter) " +
                "or upper(i.description) like upper(:filter)) " +
                "and i.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdSponsorship>) query.list();
	}

	@Override
	public void addSponsorship(AdStudent student, AdSponsorship sponsorship, AdUser user) {
        Validate.notNull(student, "Student should not be null");
        Validate.notNull(sponsorship, "Sponsorship should not be null");

        Session session = sessionFactory.getCurrentSession();
        sponsorship.setStudent(student);

        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(ACTIVE);
        sponsorship.setMetadata(metadata);

        session.save(sponsorship);
		
	}

	@Override
	public AdSponsorship findByReferenceNo(String referenceNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSponsorship(AdStudent student, AdSponsorship sponsorship, AdUser user) {
        Validate.notNull(student, "Account should not be null");
        Validate.notNull(sponsorship, "Charge should not be null");

        Session session = sessionFactory.getCurrentSession();
        sponsorship.setStudent(student);

        AdMetadata metadata = sponsorship.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        sponsorship.setMetadata(metadata);
        session.update(sponsorship);
		
	}

	@Override
	public void removeSponsorship(AdStudent student, AdSponsorship sponsorship, AdUser user) {
        Validate.notNull(student, "Account should not be null");
        Validate.notNull(sponsorship, "Sponsorship should not be null");

        Session session = sessionFactory.getCurrentSession();
        AdMetadata metadata = sponsorship.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(AdMetaState.INACTIVE);
        sponsorship.setMetadata(metadata);
        session.update(sponsorship);
		
	}

}
