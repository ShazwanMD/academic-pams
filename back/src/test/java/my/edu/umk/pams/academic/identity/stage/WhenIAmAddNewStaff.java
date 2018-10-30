package my.edu.umk.pams.academic.identity.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

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
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIAmAddNewStaff extends Stage<WhenIAmAddNewStaff> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmAddNewStaff.class);
	
	@Autowired
	private IdentityService identityService;
	
	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdStaff staff;
	
	@Autowired
	private PlannerService plannerService;

	
	
	public WhenIAmAddNewStaff I_am_add_new_staff(){
		
//		AdStaff a = new AdStaffImpl();
//		a.setName("SAM");
//		a.setActorType(AdActorType.STAFF);
//		a.setEmail("zack@umk.edu.my");
//		a.setFaculty(plannerService.findFacultyByCode("A10"));
//		a.setFax("097477134");
//		a.setIdentityNo("S110976");
//		a.setMobile("0179282817");
//		a.setPhone("097477134");
//		a.setStaffCategory("CCI");
//		a.setStaffNo("S110976");
//		a.setStaffType(AdStaffType.ACADEMIC);
//		a.setTitle("Prof");
//		
//		identityService.saveStaff(a);
//		LOG.debug("StaffNo{}",a.getStaffNo());
//		LOG.debug("ActorId:{}",a.getIdentityNo());
//		
//		AdUser user = new AdUserImpl();
//		user.setActor(a);
//		user.setEmail(a.getEmail());
//		user.setEnabled(true);
//		user.setLocked(true);
//		user.setName(a.getEmail());
//		user.setPassword(a.getStaffNo());
//		user.setRealName(a.getName());
//		user.setUsername(a.getEmail());
//		user.setPrincipalType(AdPrincipalType.USER);
//		
//		LOG.debug("Username{}",user.getUsername());
//		LOG.debug("Pass:{}",user.getPassword());
//		
//		identityService.saveUser(user);
//		
//		AdPrincipal principal = identityService.findPrincipalByName(a.getEmail());
//		
//		AdPrincipalRole role = new AdPrincipalRoleImpl();
//		role.setPrincipal(principal);
//		role.setRole(AdRoleType.ROLE_LECTURER);
//		identityService.addPrincipalRole(principal, role);
//
//		try{
//			AdGroup group = identityService.findGroupByName("GRP_LEC");
//			
//			AdGroupMember member = new AdGroupMemberImpl();
//			member.setGroup(group);
//			member.setPrincipal(principal);
//			identityService.addGroupMember(group, principal);
//			
//			
//		}catch (RecursiveGroupException e){
//			e.printStackTrace();
//		}
//		
//		AdGroup g = identityService.findGroupByUser(user);
//		LOG.debug("Group:{}",g.getName());
		
//		AdFaculty faculty = plannerService.findFacultyByCode("A10");
//		
//		List<AdStaff> staffs = identityService.findAcademicStaffByFaculty(AdStaffType.ACADEMIC, faculty, 0, Integer.MAX_VALUE);
//		for (AdStaff adStaff : staffs) {
//			LOG.debug("ID:{}",adStaff.getStaffNo());
//		}
		
		String identityNo = "1234";
		
		AdActor actor = identityService.findActorByIdentityNo(identityNo);
		LOG.debug("Actor:{}",actor.getIdentityNo());
		
		AdStaff staff = identityService.findStaffByIdentityNo(identityNo);
		LOG.debug("Staff ID:{}",identityNo);
		
		AdUser user = identityService.findUserByEmail(staff.getEmail());
		LOG.debug("User:{}",user.getEmail());
		LOG.debug("User:{}",user.isEnabled());

//		user.setEnabled(false);
//		identityService.updateUser(user);



		
		
		return self();
	}

}
