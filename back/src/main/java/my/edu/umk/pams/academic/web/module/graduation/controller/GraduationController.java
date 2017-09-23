package my.edu.umk.pams.academic.web.module.graduation.controller;

import my.edu.umk.pams.academic.core.AdFlowState;

import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplicationImpl;
import my.edu.umk.pams.academic.graduation.service.GraduationService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.web.module.graduation.vo.GraduationApplication;
import my.edu.umk.pams.academic.web.module.graduation.vo.GraduationApplicationTask;
import my.edu.umk.pams.academic.web.module.term.vo.Admission;
import my.edu.umk.pams.academic.web.module.term.vo.AdmissionApplication;
import my.edu.umk.pams.academic.web.module.term.vo.AdmissionApplicationTask;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PAMS
 */
@RestController
@RequestMapping("/api/graduation")
public class GraduationController {

	@Autowired
	private GraduationService graduationService;

	@Autowired
	private GraduationTransformer graduationTransformer;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private AuthenticationManager authenticationManager;

	// ====================================================================================================
	// GRADUATION APPLICATION
	// ====================================================================================================

	@RequestMapping(value = "/graduationApplications", method = RequestMethod.GET)
	public ResponseEntity<List<GraduationApplication>> findGraduationApplications() {
		List<AdGraduationApplication> graduationApplications = graduationService.findGraduationApplications("%", 0,
				100);
		return new ResponseEntity<List<GraduationApplication>>(
				graduationTransformer.toGraduationApplicationVos(graduationApplications), HttpStatus.OK);
	}

	@RequestMapping(value = "/graduationApplications/{referenceNo}", method = RequestMethod.GET)
	public ResponseEntity<GraduationApplication> findGraduationApplicationByReferenceNo(
			@PathVariable String referenceNo) {
		AdGraduationApplication graduationApplication = (AdGraduationApplication) graduationService
				.findGraduationApplicationByReferenceNo(referenceNo);
		return new ResponseEntity<GraduationApplication>(
				graduationTransformer.toGraduationApplicationVo(graduationApplication), HttpStatus.OK);
	}

	// update graduationApplication
	@RequestMapping(value = "/graduationApplications/{referenceNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateGraduationApplication(@PathVariable String referenceNo,
			@RequestBody GraduationApplication vo) {
		AdGraduationApplication graduationApplication = graduationService
				.findGraduationApplicationByReferenceNo(referenceNo);
		graduationApplication.setCgpa(vo.getCgpa());
		graduationApplication.setCreditHour(vo.getCreditHour());
		graduationApplication.setDescription(vo.getDescription());
		graduationApplication.setMemo(vo.getMemo());
		graduationService.updateGraduationApplication(graduationApplication);
		return new ResponseEntity<String>("Success Update graduationApplication", HttpStatus.OK);
	}

	@RequestMapping(value = "/graduationApplications/assignedTasks", method = RequestMethod.GET)
	public ResponseEntity<List<GraduationApplicationTask>> findAssignedGraduationApplications() {
		// dummyLogin();
		List<Task> tasks = graduationService.findAssignedGraduationApplicationTasks(0, 100);
		return new ResponseEntity<List<GraduationApplicationTask>>(
				graduationTransformer.toGraduationApplicationTaskVos(tasks), HttpStatus.OK);
	}

	@RequestMapping(value = "/graduationApplications/pooledTasks", method = RequestMethod.GET)
	public ResponseEntity<List<GraduationApplicationTask>> findPooledGraduationApplications() {
		// dummyLogin();
		List<Task> tasks = graduationService.findPooledGraduationApplicationTasks(0, 100);
		return new ResponseEntity<List<GraduationApplicationTask>>(
				graduationTransformer.toGraduationApplicationTaskVos(tasks), HttpStatus.OK);
	}

	@RequestMapping(value = "/graduationApplications/archived", method = RequestMethod.GET)
	public ResponseEntity<List<GraduationApplication>> findArchivedGraduationsApplications() {
		List<AdGraduationApplication> graduationApplications = graduationService.findGraduationApplicationsByFlowStates(
				AdFlowState.COMPLETED, AdFlowState.REMOVED, AdFlowState.CANCELLED);
		return new ResponseEntity<List<GraduationApplication>>(
				graduationTransformer.toGraduationApplicationVos(graduationApplications), HttpStatus.OK);
	}

	@RequestMapping(value = "/graduationApplications/startTask", method = RequestMethod.POST)
	public ResponseEntity<String> startGraduationApplicationTask(@RequestBody GraduationApplication vo)
			throws Exception {

		AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getAcademicSession().getId());
		AdStudent student = identityService.findStudentById(vo.getStudent().getId());

		if (countGraduation(academicSession, student) > 0) {
			// throw new IllegalArgumentException("Data admission already
			// exists! Please insert new data");

			System.out.println("Duplicate graduation application: " + student.getName());
			return new ResponseEntity<String>("Duplicate", HttpStatus.OK);

		} else {

			AdGraduationApplication graduationApplication = new AdGraduationApplicationImpl();
			graduationApplication.setDescription(vo.getDescription());
			graduationApplication.setMemo(vo.getMemo());

			// todo: calculate with latest admission
			// todo: calculate with all enrollments
			graduationApplication.setCgpa(vo.getCgpa());
			graduationApplication.setCreditHour(vo.getCreditHour());
			graduationApplication.setStudent(student);
			graduationApplication.setSession(academicSession);
			graduationService.startGraduationApplicationTask(graduationApplication);

			System.out.println("Success save data: " + student.getName());
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// countGraduationApplication
	private Integer countGraduationApplication(AdAcademicSession session, AdStudent student) {
		System.out.println(graduationService.countGraduationApplication(session, student));
		return graduationService.countGraduationApplication(session, student);
	}

	// countGraduation
	private Integer countGraduation(AdAcademicSession session, AdStudent student) {
		System.out.println(graduationService.countGraduation(session, student));
		return graduationService.countGraduation(session, student);
	}

	@RequestMapping(value = "/graduationApplications/viewTask/{taskId}", method = RequestMethod.GET)
	public ResponseEntity<GraduationApplicationTask> findGraduationApplicationTaskByTaskId(
			@PathVariable String taskId) {
		return new ResponseEntity<GraduationApplicationTask>(graduationTransformer.toGraduationApplicationTaskVo(
				graduationService.findGraduationApplicationTaskByTaskId(taskId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/graduationApplications/claimTask", method = RequestMethod.POST)
	public void claimGraduationApplicationTask(@RequestBody GraduationApplicationTask vo) {
		// dummyLogin();
		Task task = graduationService.findGraduationApplicationTaskByTaskId(vo.getTaskId());
		workflowService.claimTask(task);
	}

	@RequestMapping(value = "/graduationApplications/completeTask", method = RequestMethod.POST)
	public void completeGraduationApplicationTask(@RequestBody GraduationApplicationTask vo) {
		// dummyLogin();
		Task task = graduationService.findGraduationApplicationTaskByTaskId(vo.getTaskId());
		workflowService.completeTask(task);

		AdStudent student = profileService.findStudentByMatricNo(vo.getStudent().getIdentityNo());
		student.setStudentStatus(AdStudentStatus.GRADUATED);
		profileService.updateStudent(student);
	}
	
	
	// ====================================================================================================
	// PRIVATE METHODS
	// ====================================================================================================

	private void dummyLogin() {
		AdAutoLoginToken token = new AdAutoLoginToken("root");
		Authentication authed = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authed);
	}
}
