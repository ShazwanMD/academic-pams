package my.edu.umk.pams.academic.identity.service;

import my.edu.umk.pams.academic.identity.dao.*;
import my.edu.umk.pams.academic.identity.event.ApplicantUpdatedEvent;
import my.edu.umk.pams.academic.identity.event.StaffCreatedEvent;
import my.edu.umk.pams.academic.identity.event.StaffUpdatedEvent;
import my.edu.umk.pams.academic.identity.event.StudentCreatedEvent;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemServiceImpl;
import my.edu.umk.pams.academic.util.Util;
import my.edu.umk.pams.connector.payload.StaffPayload;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Transactional
@Service("inIdentityService")
public class IdentityServiceImpl implements IdentityService {

	private static final String GROUP_ROOT = "GRP_ADMN";
	private static final Logger LOG = LoggerFactory.getLogger(SystemServiceImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private AdPrincipalDao principalDao;

	@Autowired
	private AdUserDao userDao;

	@Autowired
	private AdGroupDao groupDao;

	@Autowired
	private AdActorDao actorDao;

	@Autowired
	private AdStaffDao staffDao;

	@Autowired
	private AdStudentDao studentDao;

	@Autowired
	private AdSponsorDao sponsorDao;

	@Autowired
	private AdSponsorshipDao sponsorshipDao;

	// ====================================================================================================
	// PRINCIPAL
	// ====================================================================================================

	@Override
	public AdPrincipal findPrincipalById(Long id) {
		return principalDao.findById(id);
	}

	@Override
	public AdPrincipal findPrincipalByName(String name) {
		return principalDao.findByName(name);
	}

	@Override
	public List<AdPrincipal> findPrincipals(String filter, Integer offset, Integer limit) {
		return principalDao.find(filter, offset, limit);
	}

	@Override
	public Set<String> findSids(AdPrincipal principal) {
		Set<AdGroup> groups = null;
		Set<String> principals = new HashSet<String>();
		try {
			groups = groupDao.findEffectiveAsNative(principal);
		} catch (Exception e) {
			LOG.error("Error occured loading principals", e);
		} finally {
			if (null != groups) {
				for (AdGroup group : groups) {
					principals.add(group.getName());
				}
			}
			principals.add(principal.getName());
		}
		return principals;
	}

	@Override
	public Integer countPrincipal(String filter) {
		return principalDao.count(filter);
	}

	@Override
	public void addPrincipalRole(AdPrincipal principal, AdPrincipalRole principalRole) {
		principalDao.addRole(principal, principalRole, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deletePrincipalRole(AdPrincipal principal, AdPrincipalRole principalRole) {
		principalDao.deleteRole(principal, principalRole, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// USER
	// ====================================================================================================

	@Override
	public AdUser findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public AdUser findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public AdUser findUserById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public AdUser findUserByActor(AdActor actor) {
		return userDao.findByActor(actor);
	}

	@Override
	public List<AdUser> findUsers(Integer offset, Integer limit) {
		return userDao.find(offset, limit);
	}

	@Override
	public List<AdUser> findUsers(String filter, Integer offset, Integer limit) {
		return userDao.find(filter, offset, limit);
	}

	@Override
	public Integer countUser() {
		return userDao.count();
	}

	@Override
	public Integer countUser(String filter) {
		return userDao.count(filter);
	}

	@Override
	public boolean hasUser(AdActor actor) {
		return userDao.hasUser(actor);
	}

	@Override
	public boolean isUserExists(String username) {
		return userDao.isExists(username);
	}

	@Override
	public void saveUser(AdUser user) {
		userDao.save(user, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateUser(AdUser user) {
		userDao.update(user, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeUser(AdUser user) {
		userDao.remove(user, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void changePassword(AdUser user, String newPassword) {
		user.setPassword(newPassword);
		userDao.update(user, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// GROUP
	// ====================================================================================================

	@Override
	public AdGroup getRootGroup() {
		return groupDao.findByName(GROUP_ROOT);
	}

	@Override
	public AdGroup findGroupByName(String name) {
		return groupDao.findByName(name);
	}

	@Override
	public AdGroup findOrCreateGroupByName(String name) {
		AdGroup group = null;
		if (groupDao.isExists(name))
			group = groupDao.findByName(name);
		else {
			group = new AdGroupImpl();
			group.setName(name);
			group.setEnabled(true);
			group.setLocked(false);
			groupDao.save(group, securityService.getCurrentUser());
		}
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(group);
		return group;
	}

	@Override
	public AdGroup findGroupById(Long id) {
		return groupDao.findById(id);
	}

	@Override
	public List<AdGroup> findGroups(Integer offset, Integer limit) {
		return groupDao.find(offset, limit);
	}

	@Override
	public List<AdGroup> findImmediateGroups(AdPrincipal principal) {
		return groupDao.findImmediate(principal);
	}

	@Override
	public List<AdGroup> findImmediateGroups(AdPrincipal principal, Integer offset, Integer limit) {
		return groupDao.findImmediate(principal, offset, limit);
	}

	@Override
	public Set<AdGroup> findEffectiveGroups(AdPrincipal principal) {
		return groupDao.findEffectiveAsNative(principal);
	}

	@Override
	public Set<String> findEffectiveGroupsAsString(AdPrincipal principal) {
		Set<String> groups = new HashSet<>();
		Set<AdGroup> groupSet = groupDao.findEffectiveAsNative(principal);
		for (AdGroup adGroup : groupSet) {
			groups.add(adGroup.getName());
		}
		return groups;
	}

	@Override
	public List<AdGroup> findAvailableUserGroups(AdUser user) {
		return groupDao.findAvailableGroups(user);
	}

	@Override
	public AdGroup findGroupByUser(AdUser user) {
		return groupDao.findGroupByUser(user);
	}

	@Override
	public List<AdPrincipal> findAvailableGroupMembers(AdGroup group) {
		return groupDao.findAvailableMembers(group);
	}

	@Override
	public List<AdPrincipal> findGroupMembers(AdGroup group) {
		return groupDao.findMembers(group);
	}

	@Override
	public List<AdPrincipal> findGroupMembers(AdGroup group, Integer offset, Integer limit) {
		return groupDao.findMembers(group, offset, limit);
	}

	@Override
	public Integer countGroup() {
		return groupDao.count();
	}

	@Override
	public Integer countGroupMember(AdGroup group) {
		return groupDao.countMember(group);
	}

	@Override
	public boolean isGroupExists(String name) {
		return groupDao.isExists(name);
	}

	@Override
	public boolean hasMembership(AdGroup group, AdPrincipal principal) {
		return groupDao.hasMembership(group, principal);
	}

	@Override
	public AdGroup createGroupWithRole(String name, AdRoleType... types) {
		AdGroup group = new AdGroupImpl();
		group.setName(name);
		group.setEnabled(true);
		group.setLocked(false);
		groupDao.save(group, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().refresh(group);

		for (AdRoleType type : types) {
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setRole(type);
			principalDao.addRole(group, role, securityService.getCurrentUser());
			sessionFactory.getCurrentSession().flush();
		}
		sessionFactory.getCurrentSession().refresh(group);
		return group;
	}

	@Override
	public void saveGroup(AdGroup group) {
		groupDao.save(group, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateGroup(AdGroup group) {
		groupDao.update(group, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeGroup(AdGroup group) {
		groupDao.remove(group, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addGroupMember(AdGroup group, AdPrincipal principal) throws RecursiveGroupException {
		groupDao.addMember(group, principal, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteGroupMember(AdGroup group, AdPrincipal principal) {
		groupDao.deleteMember(group, principal);
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// ACTOR
	// ====================================================================================================

	@Override
	public AdActor findActorById(Long id) {
		return actorDao.findById(id);
	}

	@Override
	public AdActor findActorByIdentityNo(String identityNo) {
		return actorDao.findByIdentityNo(identityNo);
	}

	@Override
	public List<AdActor> findActors(Integer offset, Integer limit) {
		return actorDao.find(offset, limit);
	}

	@Override
	public List<AdActor> findActors(AdActorType type, Integer offset, Integer limit) {
		return actorDao.find(type, offset, limit);
	}

	@Override
	public List<AdActor> findActors(String filter, Integer offset, Integer limit) {
		return actorDao.find(filter, offset, limit);
	}

	@Override
	public List<AdActor> findActors(String filter, AdActorType type, Integer offset, Integer limit) {
		return actorDao.find(filter, type, offset, limit);
	}

	@Override
	public Integer countActor() {
		return actorDao.count();
	}

	@Override
	public Integer countActor(AdActorType type) {
		return actorDao.count(type);
	}

	@Override
	public Integer countActor(String filter) {
		return actorDao.count(filter);
	}

	@Override
	public Integer countActor(String filter, AdActorType type) {
		return actorDao.count(filter, type);
	}

	// ====================================================================================================
	// STAFF
	// ====================================================================================================

	@Override
	public AdStaff findStaffById(Long id) {
		return staffDao.findById(id);
	}

	@Override
	public AdStaff findStaffByStaffNo(String StaffNo) {
		return staffDao.findByStaffNo(StaffNo);
	}

	@Override
	public AdStaff findStaffByNricNo(String nricNo) {
		return staffDao.findByStaffNo(nricNo);
	}

	@Override
	public AdStaff findStaffByIdentityNo(String identityNo) {
		return staffDao.findByIdentityNo(identityNo);
	}

	@Override
	public List<AdStaff> findStaffs(Integer offset, Integer limit) {
		return staffDao.find(offset, limit);
	}

	@Override
	public List<AdStaff> findStaffs(AdStaffType type, Integer offset, Integer limit) {
		return staffDao.find(type, offset, limit);
	}

	@Override
	public Integer countStaff() {
		return staffDao.count();
	}

	@Override
	public Integer countStaff(String filter) {
		return staffDao.count(filter);
	}

	@Override
	public boolean isStaffEmailExists(String email) {
		return staffDao.isEmailExists(email);
	}

	@Override
	public boolean isStaffNoExists(String staffNo) {
		return staffDao.isExists(staffNo);
	}

	@Override
	public void saveStaff(AdStaff staff) {
		staffDao.save(staff, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void saveStaffIMSNonAcademicActive(AdStaff staff) {
		staffDao.save(staff, securityService.getCurrentUser());
		LOG.info("Save Staff IMS Service");

		LOG.debug("Staff Email In Service:{}", staff.getEmail());
		// User
		AdUser user = new AdUserImpl();
		user.setActor(staff);
		user.setEmail(staff.getEmail());
		user.setUsername(staff.getEmail());
		user.setPassword(staff.getStaffNo());
		user.setRealName(staff.getName());
		// Username Principal
		user.setName(staff.getEmail());
		user.setEnabled(true);
		user.setLocked(true);
		user.setPrincipalType(AdPrincipalType.USER);
		saveUser(user);

		// Principal
		AdPrincipal principal = findPrincipalByName(staff.getEmail());
		if (staff.getFaculty().getCode().equals("A10") && staff.getStaffCategory().equals("A")) {
			LOG.info("If Faculty A10 MGSEB && Category A");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_MGSEB);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_PGW_ADM_A10");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getFaculty().getCode().equals("A10")) {
			LOG.info("If Faculty A10 MGSEB Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_MGSEB);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_KRN_ADM_A10");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getFaculty().getCode().equals("A09") && staff.getStaffCategory().equals("A")) {
			LOG.info("If Faculty A09 CPS && Category A");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_CPS);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_PGW_ADM_A09");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getFaculty().getCode().equals("A09")) {
			LOG.info("If Faculty A09 CPS Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_CPS);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_KRN_ADM_A09");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getStaffCategory().equals("A")) {
			LOG.info("If All Faculty and Category A Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_FACULTY);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_PGW_FCTY_" + staff.getFaculty().getCode());
				// GroupMember

				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else {
			LOG.info("If All Faculty Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_FACULTY);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_KRN_FCTY_" + staff.getFaculty().getCode());
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		}
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void saveStaffIMSNonAcademicInActive(AdStaff staff) {
		staffDao.save(staff, securityService.getCurrentUser());
		LOG.info("Save Staff IMS Service");

		LOG.debug("Staff Email In Service:{}", staff.getEmail());
		// User
		AdUser user = new AdUserImpl();
		user.setActor(staff);
		user.setEmail(staff.getEmail());
		user.setUsername(staff.getEmail());
		user.setPassword(staff.getStaffNo());
		user.setRealName(staff.getName());
		// Username Principal
		user.setName(staff.getEmail());
		user.setEnabled(false);
		user.setLocked(true);
		user.setPrincipalType(AdPrincipalType.USER);
		saveUser(user);

		// Principal
		AdPrincipal principal = findPrincipalByName(staff.getEmail());
		if (staff.getFaculty().getCode().equals("A10") && staff.getStaffCategory().equals("A")) {
			LOG.info("If Faculty A10 MGSEB && Category A");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_MGSEB);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_PGW_ADM_A10");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getFaculty().getCode().equals("A10")) {
			LOG.info("If Faculty A10 MGSEB Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_MGSEB);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_KRN_ADM_A10");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getFaculty().getCode().equals("A09") && staff.getStaffCategory().equals("A")) {
			LOG.info("If Faculty A09 CPS && Category A");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_CPS);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_PGW_ADM_A09");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getFaculty().getCode().equals("A09")) {
			LOG.info("If Faculty A09 CPS Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_CPS);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_KRN_ADM_A09");
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else if (staff.getStaffCategory().equals("A")) {
			LOG.info("If All Faculty and Category A Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_FACULTY);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_PGW_FCTY_" + staff.getFaculty().getCode());
				// GroupMember

				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		} else {
			LOG.info("If All Faculty Only");

			// Principal Role
			AdPrincipalRole role = new AdPrincipalRoleImpl();
			role.setPrincipal(principal);
			role.setRole(AdRoleType.ROLE_FACULTY);
			addPrincipalRole(principal, role);

			try {
				// Group
				AdGroup group = findGroupByName("GRP_KRN_FCTY_" + staff.getFaculty().getCode());
				// GroupMember
				AdGroupMember member = new AdGroupMemberImpl();
				member.setGroup(group);
				member.setPrincipal(principal);
				addGroupMember(group, principal);
			} catch (RecursiveGroupException e) {

				e.printStackTrace();
			}
		}
		sessionFactory.getCurrentSession().flush();
	}

	@Override
    public void saveStaffIMSAcademicActive(AdStaff staff) {
		staffDao.save(staff, securityService.getCurrentUser());
		LOG.info("Save Staff IMS Service");
		
		LOG.debug("Staff Email In Service:{}",staff.getEmail());
		LOG.debug("Lecturer Faculty:{}",staff.getFaculty().getCode());
		// User
		AdUser user = new AdUserImpl();
		user.setActor(staff);
		user.setEmail(staff.getEmail());
		user.setUsername(staff.getEmail());
		user.setPassword(staff.getStaffNo());
		user.setRealName(staff.getName());
		//Username Principal
		user.setName(staff.getEmail());
		user.setEnabled(true);
		user.setLocked(true);
		user.setPrincipalType(AdPrincipalType.USER);
		saveUser(user);
				
		// Principal
		AdPrincipal principal = findPrincipalByName(staff.getEmail());
		
		// Principal Role
		AdPrincipalRole role = new AdPrincipalRoleImpl();
		role.setPrincipal(principal);
		role.setRole(AdRoleType.ROLE_LECTURER);
		addPrincipalRole(principal, role);

		try{
		// Group
		AdGroup group = findGroupByName("GRP_LEC");
		// GroupMember
		AdGroupMember member = new AdGroupMemberImpl();
		member.setGroup(group);
		member.setPrincipal(principal);
		addGroupMember(group, principal);
		} catch (RecursiveGroupException e) {
			
			e.printStackTrace();
		}
	
	
	sessionFactory.getCurrentSession().flush();
	}
	
	@Override
    public void saveStaffIMSAcademicInActive(AdStaff staff) {
		staffDao.save(staff, securityService.getCurrentUser());
		LOG.info("Save Staff IMS Service");
		
		LOG.debug("Staff Email In Service:{}",staff.getEmail());
		LOG.debug("Lecturer Faculty:{}",staff.getFaculty().getCode());
		// User
		AdUser user = new AdUserImpl();
		user.setActor(staff);
		user.setEmail(staff.getEmail());
		user.setUsername(staff.getEmail());
		user.setPassword(staff.getStaffNo());
		user.setRealName(staff.getName());
		//Username Principal
		user.setName(staff.getEmail());
		user.setEnabled(false);
		user.setLocked(true);
		user.setPrincipalType(AdPrincipalType.USER);
		saveUser(user);
				
		// Principal
		AdPrincipal principal = findPrincipalByName(staff.getEmail());
		
		// Principal Role
		AdPrincipalRole role = new AdPrincipalRoleImpl();
		role.setPrincipal(principal);
		role.setRole(AdRoleType.ROLE_LECTURER);
		addPrincipalRole(principal, role);

		try{
		// Group
		AdGroup group = findGroupByName("GRP_LEC");
		// GroupMember
		AdGroupMember member = new AdGroupMemberImpl();
		member.setGroup(group);
		member.setPrincipal(principal);
		addGroupMember(group, principal);
		} catch (RecursiveGroupException e) {
			
			e.printStackTrace();
		}
	
	
	sessionFactory.getCurrentSession().flush();
	}


	@Override
    public void updateStaff(AdStaff staff) {
        staffDao.update(staff, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

	@Override
    public void updateStaffIMSNonAcademicActive(AdStaff staff, StaffPayload payload){
        staffDao.update(staff, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

	@Override
    public void deleteStaff(AdStaff staff) {
        staffDao.delete(staff, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

	@Override
    public void broadcastCreated(AdStaff staff) {
        StaffCreatedEvent event = new StaffCreatedEvent(staff);
        applicationContext.publishEvent(event);
    }

	@Override
    public void broadcastUpdated(AdStaff staff) {
        StaffUpdatedEvent event = new StaffUpdatedEvent(staff);
        applicationContext.publishEvent(event);
    }

	// ====================================================================================================
	// student
	// ====================================================================================================

	@Override
    public AdStudent findStudentById(Long id) {
        return studentDao.findById(id);
    }

	@Override
    public AdStudent findStudentByMatricNo(String matricNo) {
        return studentDao.findByStudentNo(matricNo);
    }

	@Override
    public List<AdStudent> findStudents(Integer offset, Integer limit) {
        return studentDao.find(offset, limit);
    }

	// findGraduatedStudents
	@Override
    public List<AdStudent> findGraduatedStudents(Integer offset, Integer limit) {
        return studentDao.findGraduatedStudents(offset, limit);
    }

	@Override
    public List<AdStudent> findStudents(String filter, Integer offset, Integer limit) {
        return studentDao.find(offset, limit);
    }

	@Override
    public Integer countStudent() {
        return studentDao.count();
    }

	@Override
	public Integer countStudent(String filter) {
		return studentDao.count(filter);
	}

	@Override
	public void saveStudent(AdStudent student) {
		studentDao.save(student, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateStudent(AdStudent student) {
		studentDao.update(student, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteStudent(AdStudent student) {
		studentDao.delete(student, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void broadcastCreated(AdStudent student) {
		StudentCreatedEvent event = new StudentCreatedEvent(student);
		applicationContext.publishEvent(event);
	}

	@Override
	public void broadcastUpdated(AdStudent student) {
		ApplicantUpdatedEvent event = new ApplicantUpdatedEvent(student);
		applicationContext.publishEvent(event);
	}

	@Override
	public AdSponsor findSponsorById(Long id) {
		return sponsorDao.findById(id);
	}

	@Override
	public AdSponsor findSponsorBySponsorNo(String sponsorNo) {
		return sponsorDao.findBySponsorNo(sponsorNo);
	}

	@Override
	public List<AdSponsor> findSponsors(Integer offset, Integer limit) {
		return sponsorDao.find(offset, limit);
	}

	@Override
	public List<AdSponsor> findSponsors(String filter, Integer offset, Integer limit) {
		return sponsorDao.find(filter, offset, limit);
	}

	@Override
	public Integer countSponsorship(AdSponsor sponsor) {
		return sponsorDao.countSponsorship(sponsor);
	}

	@Override
	public void saveSponsor(AdSponsor sponsor) {
		sponsorDao.save(sponsor, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void addSponsorship(AdSponsor sponsor, AdSponsorship sponsorship) {
		sponsorDao.addSponsorship(sponsor, sponsorship, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void removeSponsorship(AdSponsor sponsor, AdSponsorship sponsorship) {
		sponsorDao.removeSponsorship(sponsor, sponsorship, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public AdSponsorship findSponsorshipById(Long id) {
		return sponsorDao.findSponsorshipById(id);
	}

	@Override
	public List<AdSponsorship> findSponsorships(AdSponsor sponsor) {
		return sponsorshipDao.find();
	}

	@Override
	public List<AdSponsorship> findSponsorships(AdStudent student) {
		return sponsorshipDao.find();
	}

	@Override
	public List<AdSponsorship> findSponsorships(Integer offset, Integer limit) {
		return sponsorshipDao.find(offset, limit);
	}

	@Override
	public void saveSponsorship(AdSponsorship sponsorship) {
		sponsorshipDao.save(sponsorship, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public boolean hasSponsorship(AdStudent student) {
		return studentDao.hasSponsorship(student);
	}

	@Override
	public boolean hasSponsorship(AdSponsor sponsor) {
		return sponsorDao.hasSponsorship(sponsor);
	}

	@Override
	public void updateSponsorship(AdSponsorship sponsorship) {
		sponsorshipDao.save(sponsorship, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}
}
