package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("acCourseDao")
public class AdCourseDaoImpl extends GenericDaoSupport<Long, AdCourse> implements AdCourseDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdCourseDaoImpl.class);

    public AdCourseDaoImpl() {
        super(AdCourseImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdCourse findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCourse) query.uniqueResult();
    }

    @Override
    public AdCourse findByCodeAndFaculty(String code, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "s.code = :code " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("faculty", faculty);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCourse) query.uniqueResult();
    }

    @Override
    public List<AdCourse> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }

    @Override
    public List<AdCourse> find(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("faculty", faculty);
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }

    @Override
    public List<AdCourse> find(String filter, AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "and s.faculty = :faculty " +
                "order by s.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("faculty", faculty);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }

    @Override
    public List<AdCourse> findAvailable(AdAcademicSession academicSession, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct s.offering " +
                "from AcSection s where " +
                "s.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }


    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
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
    public Integer count(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s.course) from AcOffering s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdCourse s where " +
                "s.code = :code " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isPrerequisite(AdCourse course, AdCourse prerequisite) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdCoursePrerequisite s where " +
                "s.prerequisite = :prerequisite " +
                "and s.metadata.state = :state ");
        query.setEntity("prerequisite", prerequisite);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addPrerequisites(AdCourse course, AdUser user, AdCourse... prereqCourses) {

        Validate.notNull(user, "User cannot be null");
        Validate.notNull(course, "Course cannot be null");
        Validate.notNull(prereqCourses, "prereqCourses cannot be null");
        Validate.notEmpty(prereqCourses, "prereqCourses cannot be empty");
        Session session = sessionFactory.getCurrentSession();

        Arrays.asList(prereqCourses).forEach(prereqCourse -> {
            if (isPrerequisite(course, prereqCourse)) {
                LOG.debug("Course " + prereqCourse.getCode() + " is already a prerequisite for course " + course.getCode());
            } else {
                AdCoursePrerequisiteImpl prerequisite = new AdCoursePrerequisiteImpl();
                prerequisite.setCourse(course);
                prerequisite.setPrerequisite(prereqCourse);

                // prepare metadata
                AdMetadata metadata = new AdMetadata();
                metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
                metadata.setCreatorId(user.getId());
                metadata.setState(AdMetaState.ACTIVE);
                prerequisite.setMetadata(metadata);
                session.save(prerequisite);
            }
        });
    }

		@Override
		public void updatePrerequisites(AdCourse course, AdUser user, AdCourse... prereqCourses) {
		    Validate.notNull(user, "User cannot be null");
	        Validate.notNull(course, "Course cannot be null");
	        Validate.notNull(prereqCourses, "prereqCourses cannot be null");
	        Validate.notEmpty(prereqCourses, "prereqCourses cannot be empty");
	        Session session = sessionFactory.getCurrentSession();


	        Arrays.asList(prereqCourses).forEach(prereqCourse -> {
	            if (isPrerequisite(course, prereqCourse)) {
	                LOG.debug("Course " + prereqCourse.getCode() + " is already a prerequisite for course " + course.getCode());
	            } else {
	                AdCoursePrerequisiteImpl prerequisite = new AdCoursePrerequisiteImpl();
	                prerequisite.setCourse(course);
	                prerequisite.setPrerequisite(prereqCourse);

			                
			        // prepare metadata
		            AdMetadata metadata = new AdMetadata();
		            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		            metadata.setCreatorId(user.getId());
		            metadata.setState(AdMetaState.ACTIVE);
		            prerequisite.setMetadata(metadata);
		            session.update(prerequisite);
	            }
	        
	        });
	        
		}

    @Override
    public AdCoursePrerequisite findByCourseAndPrerequisite(AdCourse course, AdCourse prerequisite) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCoursePrerequisite s where " +
                "s.course = :course " +
                "and s.prerequisite = :prerequisite " +
                "and s.metadata.state = :state");
        query.setEntity("course", course);
        query.setEntity("prerequisite", prerequisite);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCoursePrerequisite) query.uniqueResult();
    }


    public void removePrerequisites(AdCourse course, AdUser user, AdCourse... prerequisites) {
            Validate.notNull(user, "User cannot be null");
            Validate.notNull(course, "Course cannot be null");
            Validate.notNull(prerequisites, "prerequisites cannot be null");
            Validate.notEmpty(prerequisites, "prerequisites cannot be empty");
            Session session = sessionFactory.getCurrentSession();

            Arrays.asList(prerequisites).forEach(prerequisite -> {
                if (!isPrerequisite(course, prerequisite)) {
                    LOG.debug("Course " + prerequisite.getCode() + " is NOT a prerequisite for course " + course.getCode());
                } else {

                    AdCoursePrerequisite prereq = findByCourseAndPrerequisite(course, prerequisite);

                    // prepare metadata
                    AdMetadata metadata = new AdMetadata();
                    metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
                    metadata.setDeleterId(user.getId());
                    metadata.setState(AdMetaState.INACTIVE);
                    prerequisite.setMetadata(metadata);
                    session.update(prereq);
                }
            });

        }
}
