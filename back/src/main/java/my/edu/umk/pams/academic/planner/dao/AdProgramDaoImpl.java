package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.planner.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("acProgramDao")
public class AdProgramDaoImpl extends GenericDaoSupport<Long, AdProgram> implements AdProgramDao {

    public AdProgramDaoImpl() {
        super(AdProgramImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdProgram findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.code = :code and  " +
                "s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdProgram) query.uniqueResult();
    }

    @Override
    public AdProgram findByCodeAndFaculty(String code, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.code = :code " +
                "and s.faculty= :faculty " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("faculty", faculty);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdProgram) query.uniqueResult();
    }

    @Override
    public List<AdProgram> find(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.titleEn) like upper(:filter)) " +
                "and s.metadata.state = :state order by s.titleEn asc ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(String filter, AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(String filter, AdProgramType type, AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.programType = :programType " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("faculty", faculty);
        query.setInteger("programType", type.ordinal());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(AdProgramType type, AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.programType = :programType " +
                "and s.metadata.state = :state ");
        query.setInteger("programType", type.ordinal());
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("faculty", faculty);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }
    
    @Override
    public List<AdProgram> find(AdGraduateCenter graduateCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.faculty.center = :center " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("center", graduateCenter);
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    @Override
    public List<AdProgram> find(AdProgramType type, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.programType = :programType " +
                "and s.metadata.state = :state ");
        query.setInteger("programType", type.ordinal());
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdProgram>) query.list();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdProgramType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.programType = :programType " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("programType", type.ordinal());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdProgramType type, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.programType = :programType " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("programType", type.ordinal());
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("faculty", faculty);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgramType type, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.programType = :programType " +
                "and s.metadata.state = :state ");
        query.setInteger("programType", type.ordinal());
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdProgram s where " +
                "s.code = :code " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasGrades(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdGradeCode s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public void addOffering(AdProgram program, AdCourse course, AdOffering offering, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(course, "Course cannot be null");
        Session session = sessionFactory.getCurrentSession();
        offering.setProgram(program);
        offering.setCourse(course);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        offering.setMetadata(metadata);
        session.save(offering);
    }

    @Override
    public void updateOffering(AdProgram program, AdCourse course, AdOffering offering, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(course, "Course cannot be null");
        Session session = sessionFactory.getCurrentSession();
        offering.setProgram(program);
        offering.setCourse(course);

        // prepare metadata
        AdMetadata metadata = offering.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        offering.setMetadata(metadata);
        session.update(offering);
    }

    @Override
    public void removeOffering(AdProgram program, AdCourse course, AdOffering offering, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(course, "Course cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(offering);
    }

    @Override
    public void addGradeCode(AdProgram program, AdGradeCode gradeCode, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(gradeCode, "Grade Code cannot be null");
        Session session = sessionFactory.getCurrentSession();
//        gradeCode.setProgram(program);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        gradeCode.setMetadata(metadata);
        session.save(gradeCode);
    }

    @Override
    public void updateGradeCode(AdProgram program, AdGradeCode gradeCode, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(gradeCode, "Grade Code cannot be null");
        Session session = sessionFactory.getCurrentSession();
//        gradeCode.setProgram(program);

        // prepare metadata
        AdMetadata metadata = gradeCode.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        gradeCode.setMetadata(metadata);
        session.update(gradeCode);
    }

    @Override
    public void removeGradeCode(AdProgram program, AdGradeCode gradeCode, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(gradeCode, "Grade Code cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(gradeCode);
    }

	@Override
	public void save(AdProgram program, AdFaculty faculty, AdUser currentUser) {
		
        Validate.notNull(currentUser, "User cannot be null");
        Validate.notNull(program, "Program cannot be null");
        Validate.notNull(faculty, "Grade Code cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.save(faculty);
		
		
	}
}
