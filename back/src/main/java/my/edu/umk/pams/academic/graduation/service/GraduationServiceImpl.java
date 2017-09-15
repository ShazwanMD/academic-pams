package my.edu.umk.pams.academic.graduation.service;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.graduation.dao.AdGraduationApplicationDao;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.workflow.service.WorkflowConstants;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static my.edu.umk.pams.academic.AcademicConstants.GRADUATION_APPLICATION_ID;

/**
 * @author PAMS
 */
@Transactional
@Service("graduationService")
public class GraduationServiceImpl implements GraduationService {

    private static final Logger LOG = LoggerFactory.getLogger(GraduationServiceImpl.class);

    @Autowired
    private AdGraduationApplicationDao graduationApplicationDao;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private SessionFactory sessionFactory;

    // ====================================================================================================
    // GRADUATION APPLICATION
    // ====================================================================================================

    // workflow
    @Override
    public AdGraduationApplication findGraduationApplicationByTaskId(String taskId) {
        Task task = workflowService.findTask(taskId);
        Map<String, Object> map = workflowService.getVariables(task.getExecutionId());
        return graduationApplicationDao.findById((Long) map.get(GRADUATION_APPLICATION_ID));
    }

    @Override
    public Task findGraduationApplicationTaskByTaskId(String taskId) {
        return workflowService.findTask(taskId);
    }

    @Override
    public List<Task> findAssignedGraduationApplicationTasks(Integer offset, Integer limit) {
        return workflowService.findAssignedTasks(AdGraduationApplication.class.getName(), offset, limit);
    }

    @Override
    public List<Task> findPooledGraduationApplicationTasks(Integer offset, Integer limit) {
        return workflowService.findPooledTasks(AdGraduationApplication.class.getName(), offset, limit);
    }

    @Override
    public String startGraduationApplicationTask(AdGraduationApplication application) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("academicSession", plannerService.findCurrentAcademicSession());
        String referenceNo = systemService.generateFormattedReferenceNo(AcademicConstants.GRADUATION_APPLICATION_REFERENCE_NO, map);
        application.setReferenceNo(referenceNo);
        LOG.debug("Processing application with refNo {}", referenceNo);

        graduationApplicationDao.saveOrUpdate(application, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(application);

        workflowService.processWorkflow(application, prepareVariables(application));
        return referenceNo;
    }

    @Override
    public void updateGraduationApplication(AdGraduationApplication application) {
        graduationApplicationDao.update(application, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void cancelGraduationApplication(AdGraduationApplication application) {
        application.getFlowdata().setState(AdFlowState.CANCELLED);
        application.getFlowdata().setCancelledDate(new Timestamp(System.currentTimeMillis()));
        application.getFlowdata().setCancelerId(securityService.getCurrentUser().getId());
        graduationApplicationDao.update(application, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public AdGraduationApplication findGraduationApplicationById(Long id) {
        return graduationApplicationDao.findById(id);
    }

    @Override
    public AdGraduationApplication findGraduationApplicationByReferenceNo(String referenceNo) {
        return graduationApplicationDao.findByReferenceNo(referenceNo);
    }

    @Override
    public List<AdGraduationApplication> findGraduationApplications(String filter, Integer offset, Integer limit) {
        return graduationApplicationDao.find(offset, limit);
    }

    @Override
    public List<AdGraduationApplication> findGraduationApplications(AdAcademicSession academicSession, Integer offset,
                                                                    Integer limit) {
        return graduationApplicationDao.find(academicSession, offset, limit);
    }
    
    @Override
    public List<AdGraduationApplication> findGraduationApplications(AdStudent student) {
        return graduationApplicationDao.find(student);
    }

    @Override
    public Integer countGraduationApplication(String filter) {
        return graduationApplicationDao.count();
    }

    @Override
    public Integer countGraduationApplication(AdAcademicSession academicSession) {
        return graduationApplicationDao.count(academicSession);
    }

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private Map<String, Object> prepareVariables(AdGraduationApplication application) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(GRADUATION_APPLICATION_ID, application.getId());
        map.put(WorkflowConstants.USER_CREATOR, securityService.getCurrentUser().getName());
        map.put(WorkflowConstants.REFERENCE_NO, application.getReferenceNo());
        map.put(WorkflowConstants.REMOVE_DECISION, false);
        map.put(WorkflowConstants.CANCEL_DECISION, false);
        return map;
    }

	@Override
	public List<AdGraduationApplication> findGraduationApplicationsByFlowStates(AdFlowState... flowStates) {
		return graduationApplicationDao.findByFlowStates(flowStates);
	}

}
