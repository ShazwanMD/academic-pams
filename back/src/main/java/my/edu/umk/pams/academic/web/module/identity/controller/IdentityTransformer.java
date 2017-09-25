package my.edu.umk.pams.academic.web.module.identity.controller;

import my.edu.umk.pams.academic.common.service.CommonService;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.common.controller.CommonTransformer;
import my.edu.umk.pams.academic.web.module.identity.vo.Actor;
import my.edu.umk.pams.academic.web.module.identity.vo.ActorType;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.identity.vo.StudentStatus;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.term.controller.TermTransformer;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PAMS
 */
@Component("identityTransformer")
public class IdentityTransformer {

	@Autowired
	private TermService termService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private IdentityTransformer identityTransformer;

	@Autowired
	private CommonTransformer commonTransformer;

	@Autowired
	private PlannerTransformer plannerTransformer;

	@Autowired
	private TermTransformer termTransformer;

	public Staff toStaffVo(AdStaff staff) {
		Staff vo = new Staff();
		vo.setId(staff.getId());
		vo.setIdentityNo(staff.getIdentityNo());
		vo.setName(staff.getName());
		vo.setEmail(staff.getEmail());
		vo.setMobile(staff.getMobile());
		vo.setPhone(staff.getPhone());
		vo.setFax(staff.getFax());
		vo.setTitle(staff.getTitle());
		vo.setActorType(ActorType.get(staff.getActorType().ordinal()));
		vo.setProgram(plannerTransformer.toProgramVo(staff.getProgram()));
		vo.setFaculty(plannerTransformer.toFacultyVo(staff.getFaculty()));

		return vo;
	}

	public Student toStudentVo(AdStudent student) {
		Student vo = new Student();
		vo.setId(student.getId());
		vo.setIdentityNo(student.getIdentityNo());
		vo.setName(student.getName());
		vo.setEmail(student.getEmail());
		vo.setMobile(student.getMobile());
		vo.setPhone(student.getPhone());
		vo.setFax(student.getFax());
		vo.setStudentStatus(StudentStatus.get(student.getStudentStatus().ordinal()));
		//vo.setBalance(student.getBalance());
		//vo.setOutstanding(student.getOutstanding());
		vo.setMemo(student.getMemo());
		vo.setCohort(plannerTransformer.toCohortVo(student.getCohort()));

		return vo;
	}

	public List<Staff> toStaffVos(List<AdStaff> staffs) {
		List<Staff> vos = staffs.stream().map((staff) -> toStaffVo(staff)).collect(toList());
		return vos;
	}

	public List<Student> toStudentVos(List<AdStudent> students) {
		List<Student> vos = students.stream().map((student) -> toStudentVo(student)).collect(toList());
		return vos;
	}

	public List<Actor> toActorVos(List<AdActor> actors) {
		List<Actor> vos = actors.stream().map((actor) -> toActorVo(actor)).collect(toList());
		return vos;
	}

	public Actor toActorVo(AdActor actor) {
		if (actor instanceof AdStaff)
			return toStaffVo((AdStaff) actor);
		else
			return null;
	}
}
