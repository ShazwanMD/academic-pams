package my.edu.umk.pams.academic.offering.service;

import my.edu.umk.pams.academic.identity.dao.AdStaffDao;
import my.edu.umk.pams.academic.identity.dao.AdStudentDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.offering.dao.*;
import my.edu.umk.pams.academic.offering.model.*;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.studyplan.dao.*;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static my.edu.umk.pams.academic.AcademicConstants.ENROLLMENT_APPLICATION_ID;

/**
 * @author PAMS
 */
@Service("offeringServie")
public class OfferingServiceImpl implements OfferingService {

	private static final Logger LOG = LoggerFactory.getLogger(OfferingServiceImpl.class);

	@Autowired
	private AdAcademicSessionDao academicSessionDao;

    @Autowired
    private AdAcademicYearDao academicYearDao;

    @Autowired
    private AdIntakeCodeDao intakeCodeDao;

    @Autowired
    private AdFacultyDao facultyDao;

    @Autowired
    private AdProgramDao programDao;

    @Autowired
    private AdCurriculumDao curriculumDao;

    @Autowired
    private AdCourseDao courseDao;

    @Autowired
    private AdOfferingDao offeringDao;

    @Autowired
    private AdCohortDao cohortDao;

    @Autowired
    private AdSectionDao sectionDao;

    @Autowired
    private AdEnrollmentApplicationDao enrollmentApplicationDao;

    @Autowired
    private AdEnrollmentDao enrollmentDao;

    @Autowired
    private AdAssessmentDao assessmentDao;

    @Autowired
    private AdGradebookDao gradebookDao;

    @Autowired
    private AdStudentDao studentDao;

    @Autowired
    private AdStaffDao staffDao;

    @Autowired
	private SecurityService securityService;

    @Autowired
	private WorkflowService workflowService;

	@Autowired
	private SessionFactory sessionFactory;

	// ====================================================================================================
	// OFFERING
	// ====================================================================================================

	@Override
	public AdOffering findOfferingById(Long id) {
		return offeringDao.findById(id);
	}

	@Override
	public AdOffering findOfferingByCanonicalCode(String canonicalCode) {
		return offeringDao.findByCanonicalCode(canonicalCode);
	}

	@Override
	public AdOffering findOfferingByProgramAndCourse(AdProgram program, AdCourse course) {
		return offeringDao.findByProgramAndCourse(program, course);
	}

	@Override
	public AdAcademicSession findLastOfferedOffering(AdAcademicSession current, AdCourse course) {
		return null;
	}

	@Override
	public List<AdOffering> findOfferings(Integer offset, Integer limit) {
		return offeringDao.find(offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, Integer offset, Integer limit) {
		return offeringDao.find(filter, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(AdProgram program) {
		return offeringDao.find(program);
	}

	@Override
	public List<AdOffering> findOfferings(AdProgram program, Integer offset, Integer limit) {
		return offeringDao.find(program, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		return offeringDao.find(filter, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, AdProgram program,
			Integer offset, Integer limit) {
		return offeringDao.find(filter, academicSession, program, offset, limit);
	}

	@Override
	public List<AdOffering> findRunningOfferings(AdAcademicSession session) {
		return null; // TODO;
	}

	@Override
	public Integer countOffering(String filter) {
		return offeringDao.count(filter);
	}

	@Override
	public Integer countOffering(AdProgram program) {
		return offeringDao.count(program);
	}

	@Override
	public Integer countOffering(AdCourse course) {
		return offeringDao.count(course);
	}

	@Override
	public Integer countOffering(boolean authorized, String filter) {
		return offeringDao.count(filter); // todo(uda): auth
	}

	@Override
	public Integer countOffering(boolean authorized, String filter, AdProgram program) {
		return offeringDao.count(filter, program); // todo(uda): auth
	}

	@Override
	public Integer countOfferingWithSection(boolean authorized, String filter) {
		return offeringDao.countWithSection(filter); // todo(uda): auth
	}

	@Override
	public Integer countOfferingWithSection(boolean authorized, String filter, AdAcademicSession academicSession) {
		return offeringDao.countWithSection(filter, academicSession); // todo(uda): auth
	}

	@Override
	public boolean isOfferingExists(AdProgram program, AdCourse course) {
		return offeringDao.isExists(program, course);
	}
	

	@Override
	public void saveOffering(AdOffering offering) {
		offeringDao.save(offering, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	// ====================================================================================================
	// SECTION
	// ====================================================================================================

	@Override
	public AdSection findSectionById(Long id) {
		return sectionDao.findById(id);
	}

	@Override
	public AdSection findSectionByCanonicalCode(String canonicalCode) {
		return sectionDao.findByCanonicalCode(canonicalCode);
	}

	@Override
	public List<AdSection> findSections(Integer offset, Integer limit) {
		return sectionDao.find(offset, limit);
	}

	// todo: decorate
	@Override
	public List<AdSection> findSections(String filter, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		return sectionDao.find(filter, academicSession, offset, limit);
	}

	@Override
	public List<AdSection> findSections(AdOffering offering) {
		return sectionDao.find(offering);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession) {
		return sectionDao.find(academicSession);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, Integer offset, Integer limit) {
		return sectionDao.find(academicSession, offset, limit);
	}

	// todo: decorate
	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.find(academicSession, offering);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering, Integer offset,
			Integer limit) {
		return sectionDao.find(academicSession, offering, offset, limit);
	}

	@Override
	public List<AdSection> findSections(String filter, AdAcademicSession academicSession, AdAdmission admission,
			Integer offset, Integer limit) {
		return sectionDao.find(filter, academicSession, admission, offset, limit);
	}

	@Override
	public Integer countSection() {
		return sectionDao.count();
	}

	@Override
	public Integer countSection(String filter, AdAcademicSession academicSession) {
		return sectionDao.count(filter, academicSession);
	}

	@Override
	public Integer countSection(AdOffering offering) {
		return sectionDao.count(offering);
	}

	@Override
	public Integer countSection(AdAcademicSession academicSession) {
		return sectionDao.count(academicSession);
	}

	@Override
	public Integer countSection(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.count(academicSession, offering);
	}

	@Override
	public Integer countSection(String filter, AdAcademicSession academicSession, AdAdmission admission) {
		return sectionDao.count(filter, academicSession, admission);
	}

	@Override
	public Integer countAvailableStaff(AdOffering offering) {
		return sectionDao.countAvailableStaff(offering);
	}

	@Override
	public Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.countAvailableStaff(academicSession, offering);
	}

	@Override
	public boolean hasSection(AdAcademicSession academicSession) {
		return sectionDao.hasSection(academicSession);
	}

	@Override
	public boolean hasSection(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.hasSection(academicSession, offering);
	}

	@Override
	public boolean isSectionExists(String canonicalCode) {
		return sectionDao.isExists(canonicalCode);
	}


    // ====================================================================================================
    // OFFERING
    // ====================================================================================================

    @Override
    public AdEnrollmentApplication findEnrollmentApplicationById(Long id) {
        return enrollmentApplicationDao.findById(id);
    }

    @Override
    public AdEnrollmentApplication findEnrollmentApplicationByReferenceNo(String referenceNo) {
        return enrollmentApplicationDao.findByReferenceNo(referenceNo);
    }

    @Override
    public AdEnrollmentApplication findEnrollmentApplicationByTaskId(String taskId) {
        Task task = workflowService.findTask(taskId);
        Map<String, Object> vars = workflowService.getVariables(task.getExecutionId());
        return findEnrollmentApplicationById((Long) vars.get(ENROLLMENT_APPLICATION_ID));
    }

    @Override
    public AdEnrollmentApplicationItem findEnrollmentApplicationItemById(Long id) {
        return enrollmentApplicationDao.findItemById(id);
    }

    @Override
    public List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session) {
        return enrollmentApplicationDao.find(session);
    }

    @Override
    public List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session, Integer offset, Integer limit) {
        return enrollmentApplicationDao.find(session, offset, limit);
    }

    @Override
    public List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, Integer offset, Integer limit) {
        return enrollmentApplicationDao.find(filter, session, offset, limit);
    }

    @Override
    public List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit) {
        return enrollmentApplicationDao.find(filter, session, student, offset, limit);
    }

    @Override
    public List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit) {
        return enrollmentApplicationDao.find(filter, session, advisor, offset, limit);
    }

    @Override
    public List<AdEnrollmentApplicationItem> findEnrollmentApplicationItems(AdEnrollmentApplication application) {
        return enrollmentApplicationDao.findItems(application);
    }

    @Override
    public Integer countEnrollmentApplication(AdAcademicSession session) {
        return enrollmentApplicationDao.count(session);
    }

    @Override
    public Integer countEnrollmentApplication(String filter, AdAcademicSession session) {
        return enrollmentApplicationDao.count(filter, session);
    }

    @Override
    public Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStudent student) {
        return enrollmentApplicationDao.count(filter, session, student);
    }

    @Override
    public Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStaff staff) {
        return enrollmentApplicationDao.count(filter, session, staff);
    }

    //====================================================================================================
    // ENROLLMENT
    //====================================================================================================

    @Override
    public AdEnrollment findEnrollmentById(Long id) {
        return enrollmentDao.findById(id);
    }

    @Override
    public AdEnrollment findEnrollmentBySectionAndStudent(AdSection section, AdStudent student) {
        return enrollmentDao.findBySectionAndStudent(section, student);
    }

    @Override
    public AdEnrollment findEnrollmentByMatricNoAndOffering(String matricNo, AdOffering offering) {
        return enrollmentDao.findByMatricNoAndOffering(matricNo, offering);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdAdmission admission) {
        return enrollmentDao.find(admission);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession) {
        return enrollmentDao.find(academicSession);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdProgram program) {
        return enrollmentDao.find(academicSession, program);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdProgram program) {
        return enrollmentDao.find(program);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdOffering offering) {
        return enrollmentDao.find(offering);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdSection section) {
        return enrollmentDao.find(section);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdStudent student) {
        return enrollmentDao.find(student);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdOffering offering, Integer offset, Integer limit) {
        return enrollmentDao.find(offering, offset, limit);
    }

    @Override
    public List<AdEnrollment> findEnrollments(String filter, AdOffering offering, Integer offset, Integer limit) {
        return enrollmentDao.find(filter, offering, offset, limit);
    }

    @Override
    public List<AdEnrollment> findEnrollments(String filter, AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        return enrollmentDao.find(filter, academicSession, offering, offset, limit);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdOffering offering) {
        return enrollmentDao.find(academicSession, offering);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdStudent student) {
        return enrollmentDao.find(academicSession, student);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        return enrollmentDao.find(academicSession, offering, offset, limit);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdStudent student, Integer offset, Integer limit) {
        return enrollmentDao.find(student, offset, limit);
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdSection section, Integer offset, Integer limit) {
        return enrollmentDao.find(section, offset, limit);
    }

    @Override
    public List<AdEnrollment> findEnrollments(String filter, AdSection section, Integer offset, Integer limit) {
        return enrollmentDao.find(filter, section, offset, limit);
    }

    @Override
    public Integer countEnrollment(AdOffering offering) {
        return enrollmentDao.count(offering);
    }

    @Override
    public Integer countEnrollment(AdAcademicSession academicSession, AdOffering offering) {
        return enrollmentDao.count(academicSession, offering);
    }

    @Override
    public Integer countEnrollment(String filter, AdOffering offering) {
        return enrollmentDao.count(filter, offering);
    }

    @Override
    public Integer countEnrollment(String filter, AdAcademicSession academicSession, AdOffering offering) {
        return enrollmentDao.count(filter, academicSession, offering);
    }

    @Override
    public Integer countEnrollment(AdSection section) {
        return enrollmentDao.count(section);
    }

    @Override
    public Integer countEnrollment(AdEnrollmentStatus status, AdSection section) {
        return enrollmentDao.count(status, section);
    }

    @Override
    public Integer countEnrollment(String filter, AdSection section) {
        return enrollmentDao.count(filter, section);
    }

    @Override
    public Integer countEnrollment(AdStudent student) {
        return enrollmentDao.count(student);
    }

    @Override
    public Integer countEnrollment(AdAdmission admission) {
        return enrollmentDao.count(admission);
    }

    @Override
    public boolean isAnyEnrollmentExists(AdAcademicSession academicSession, AdOffering offering, AdStudent student) {
        return enrollmentDao.isAnyExists(academicSession, offering, student);
    }

    @Override
    public boolean isEnrollmentExists(AdSection section, AdStudent student) {
        return enrollmentDao.isExists(section, student);
    }

    @Override
    public boolean hasEnrollment(AdSection section) {
        return enrollmentDao.hasEnrollment(section);
    }

    @Override
    public boolean hasExceededEnrollment(AdSection section) {
        Integer capacity = section.getCapacity();
        Integer confirmedEnrollment = countEnrollment(AdEnrollmentStatus.CONFIRMED, section);

        if (confirmedEnrollment >= capacity) return true;
        else return false;
    }
}
