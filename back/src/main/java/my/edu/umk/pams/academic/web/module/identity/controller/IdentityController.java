package my.edu.umk.pams.academic.web.module.identity.controller;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdGroupMember;
import my.edu.umk.pams.academic.identity.model.AdGroupMemberImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRole;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRoleImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipalType;
import my.edu.umk.pams.academic.identity.model.AdRoleType;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffImpl;
import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.identity.vo.Actor;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;
import my.edu.umk.pams.academic.web.module.identity.vo.StaffAcademic;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.term.controller.TermTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.Appointment;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAMS
 */
@RestController
@Transactional
@RequestMapping("/api/identity")
public class IdentityController {

    private static final Logger LOG = LoggerFactory.getLogger(IdentityController.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private IdentityTransformer identityTransformer;
    
    @Autowired
    private TermTransformer termTransformer;

    @Autowired
    AuthenticationManager authenticationManager;

    // ==================================================================================================== //
    // ACTOR
    // ==================================================================================================== //

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public ResponseEntity<List<Actor>> findActors() {
        return new ResponseEntity<List<Actor>>(identityTransformer
                .toActorVos(identityService.findActors(0, 100)), HttpStatus.OK);
    }

    // ==================================================================================================== //
    // STAFF
    // ==================================================================================================== //

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> findStaffs() {
        return new ResponseEntity<List<Staff>>(identityTransformer
                .toStaffVos(identityService.findStaffs(AdStaffType.ACADEMIC, 0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/staffs/{identityNo}", method = RequestMethod.GET)
    public ResponseEntity<Staff> findStaffByIdentityNo(@PathVariable String identityNo) {
        return new ResponseEntity<Staff>(identityTransformer
                .toStaffVo(identityService.findStaffByStaffNo(identityNo)), HttpStatus.OK);
    }
    
    //find appointments by staff
    @RequestMapping(value = "/staffs/{identityNo}/appointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointmentsByStaff(@PathVariable String identityNo) {
        AdStaff staff = identityService.findStaffByIdentityNo(identityNo);
        List<AdAppointment> appointments = termService.findAppointments(staff);
        List<Appointment> appointmentVos = termTransformer.toAppointmentVos(appointments);
        return new ResponseEntity<List<Appointment>>(appointmentVos, HttpStatus.OK);

    }
    
    // ==================================================================================================== //
    // add new staff
    // ==================================================================================================== //
    @RequestMapping(value = "/academicStaffs", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> findAcademicStaffs() {
    	
    	AdFaculty faculty = plannerService.findFacultyByCode("A10");
    	
        return new ResponseEntity<List<Staff>>(identityTransformer
                .toStaffVos(identityService.findAcademicStaffByFaculty(AdStaffType.ACADEMIC,faculty, 0, Integer.MAX_VALUE)), HttpStatus.OK);
    }
    
//    @RequestMapping(value = "/academicStaffs", method = RequestMethod.GET)
//    public ResponseEntity<List<StaffAcademic>> findAcademicStaffs() {
//    	
//    	AdFaculty faculty = plannerService.findFacultyByCode("A10");
//    	List<AdStaff> staff = identityService.findAcademicStaffByFaculty(AdStaffType.ACADEMIC, faculty, 0, Integer.MAX_VALUE);
//    	List<AdUser> users = identityService.findUsers(0, Integer.MAX_VALUE);
//
//    	List<StaffAcademic> staffs = new ArrayList<StaffAcademic>();
//    
//    	for (AdStaff adStaff : staff) {
//    		StaffAcademic sa = new StaffAcademic();
//			sa.setEmail(adStaff.getEmail());
//			sa.setName(adStaff.getName());
//			sa.setUsername(adStaff.getEmail());
//			
//			AdStaff staffBaharu = identityService.findStaffByIdentityNo(adStaff.getIdentityNo());
//			sa.setStaff(identityTransformer.toStaffVo(staffBaharu));
//	    	for (AdUser adUser : users) {
//	    		LOG.debug("User:{}",adUser.isEnabled());
//			sa.setEnabled(adUser.isEnabled());
//			staffs.add(sa);
//			}
//			LOG.debug("Staff:{}",adStaff.getEmail());
//	    	staffs.add(sa);
//    	}
//
//    	
//        return new ResponseEntity<List<StaffAcademic>>(staffs,HttpStatus.OK);
//    }
    
    @RequestMapping(value = "/academicStaffs",method = RequestMethod.POST)
    public ResponseEntity<String> saveAcademicStaff(@RequestBody Staff vo){
    	
		AdStaff a = new AdStaffImpl();
		a.setName(vo.getName());
		a.setActorType(AdActorType.STAFF);
		a.setEmail(vo.getEmail());
		a.setFaculty(plannerService.findFacultyByCode("A10"));
		a.setFax(vo.getFax());
		a.setIdentityNo(vo.getIdentityNo());
		a.setMobile(vo.getMobile());
		a.setPhone(vo.getPhone());
		a.setStaffCategory(vo.getCategory());
		a.setStaffNo(vo.getIdentityNo());
		a.setStaffType(AdStaffType.ACADEMIC);
		a.setTitle(vo.getTitle());
		
		identityService.saveStaff(a);
		LOG.debug("StaffNo{}",a.getStaffNo());
		LOG.debug("Name:{}",a.getName());
		
		AdUser user = new AdUserImpl();
		user.setActor(a);
		user.setEmail(a.getEmail());
		user.setEnabled(true);
		user.setLocked(true);
		user.setName(a.getEmail());
		user.setPassword(a.getStaffNo());
		user.setRealName(a.getName());
		user.setUsername(a.getEmail());
		user.setPrincipalType(AdPrincipalType.USER);
		
		LOG.debug("Username{}",user.getUsername());
		LOG.debug("Pass:{}",user.getPassword());
		
		identityService.saveUser(user);
		
		AdPrincipal principal = identityService.findPrincipalByName(a.getEmail());
		
		AdPrincipalRole role = new AdPrincipalRoleImpl();
		role.setPrincipal(principal);
		role.setRole(AdRoleType.ROLE_LECTURER);
		identityService.addPrincipalRole(principal, role);

		try{
			AdGroup group = identityService.findGroupByName("GRP_LEC");
			
			AdGroupMember member = new AdGroupMemberImpl();
			member.setGroup(group);
			member.setPrincipal(principal);
			identityService.addGroupMember(group, principal);
			
			
		}catch (RecursiveGroupException e){
			e.printStackTrace();
		}
		
		AdGroup g = identityService.findGroupByUser(user);
		LOG.debug("Group:{}",g.getName());
	
    	return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/academicStaffs/{identityNo}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateAcademicStaff(@PathVariable String identityNo, @RequestBody Staff vo){
    	
		AdStaff a = identityService.findStaffByIdentityNo(identityNo);
		a.setName(vo.getName());
		a.setActorType(AdActorType.STAFF);
		a.setEmail(vo.getEmail());
		a.setFaculty(plannerService.findFacultyByCode("A10"));
		a.setFax(vo.getFax());
		a.setIdentityNo(vo.getIdentityNo());
		a.setMobile(vo.getMobile());
		a.setPhone(vo.getPhone());
		a.setStaffCategory(vo.getCategory());
		a.setStaffNo(vo.getIdentityNo());
		a.setStaffType(AdStaffType.ACADEMIC);
		a.setTitle(vo.getTitle());
		
		identityService.updateStaff(a);
		LOG.debug("StaffNo{}",a.getStaffNo());
		LOG.debug("Name:{}",a.getName());
		
		AdUser user = identityService.findUserByEmail(a.getEmail());
		user.setActor(a);
		user.setEmail(a.getEmail());
		user.setEnabled(true);
		user.setLocked(true);
		user.setName(a.getEmail());
		user.setPassword(a.getStaffNo());
		user.setRealName(a.getName());
		user.setUsername(a.getEmail());
		user.setPrincipalType(AdPrincipalType.USER);
		
		LOG.debug("Username{}",user.getUsername());
		LOG.debug("Pass:{}",user.getPassword());
		
		identityService.updateUser(user);
		
		AdPrincipal principal = identityService.findPrincipalByName(a.getEmail());
				
		AdGroup g = identityService.findGroupByUser(user);
		LOG.debug("Group:{}",g.getName());
	
    	return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/academicStaffs/{identityNo}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deactiveStaffAcademic(@PathVariable String identityNo) {
    	
    		AdActor actor = identityService.findActorByIdentityNo(identityNo);

    		AdStaff staff = identityService.findStaffByIdentityNo(identityNo);
    		LOG.debug("Staff ID:{}",identityNo);
    		
    		AdUser user = identityService.findUserByEmail(staff.getEmail());
    		LOG.debug("User:{}",user.getEmail());
    		
    		if(user.isEnabled()){
    			user.setEnabled(false);
    		}else{
    			user.setEnabled(true);
    		}
    		
    		identityService.updateUser(user);

    

    		return new ResponseEntity<String>("Success", HttpStatus.OK);
            }

    
    // ==================================================================================================== //
    // STUDENT
    // ==================================================================================================== //

//    @RequestMapping(value = "/students", method = RequestMethod.GET)
//    public ResponseEntity<List<Student>> findStudents() {
//        return new ResponseEntity<List<Student>>(identityTransformer
//                .toStudentVos(identityService.findStudents(0, 100)), HttpStatus.OK);
//    }
    
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findStudents() {
        return new ResponseEntity<List<Student>>(identityTransformer
                .toStudentVos(identityService.findStudents()), HttpStatus.OK);
    }


    @RequestMapping(value = "/students/{identityNo}", method = RequestMethod.GET)
    public ResponseEntity<Student> findStudentByIdentityNo(@PathVariable String identityNo) {
        return new ResponseEntity<Student>(identityTransformer
                .toStudentVo(identityService.findStudentByMatricNo(identityNo)), HttpStatus.OK);
    }
    

}
