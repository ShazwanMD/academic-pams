package my.edu.umk.pams.academic.identity.service;

import my.edu.umk.pams.academic.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.connector.payload.StaffPayload;

import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface IdentityService {

	// ====================================================================================================
	// PRINCIPAL
	// ====================================================================================================

	AdPrincipal findPrincipalById(Long id);

	AdPrincipal findPrincipalByName(String name);

	List<AdPrincipal> findPrincipals(String filter, Integer offset, Integer limit);

	Set<String> findSids(AdPrincipal principal);

	Integer countPrincipal(String filter);
	
	AdPrincipalRole findRoleByPrincipal(AdPrincipal principal);

	void addPrincipalRole(AdPrincipal principal, AdPrincipalRole principalRole);

	void deletePrincipalRole(AdPrincipal principal, AdPrincipalRole principalRole);

	void deletePrincipal(AdPrincipal principal);
	// ====================================================================================================
	// USER
	// ====================================================================================================

	AdUser findUserByEmail(String email);

	AdUser findUserByUsername(String username);

	AdUser findUserById(Long id);

	AdUser findUserByActor(AdActor actor);

	List<AdUser> findUsers(Integer offset, Integer limit);

	List<AdUser> findUsers(String filter, Integer offset, Integer limit);

	Integer countUser();

	Integer countUser(String filter);

	boolean hasUser(AdActor actor);

	boolean isUserExists(String username);

	void saveUser(AdUser user);

	void updateUser(AdUser user);

	void removeUser(AdUser user);
	
	void deleteUser(AdUser user);

	void changePassword(AdUser user, String newPassword);

	// ====================================================================================================
	// GROUP
	// ====================================================================================================
	
	AdGroupMember findGroupMemberByPrincipal(AdPrincipal principal);

	AdGroup getRootGroup();

	AdGroup findGroupByName(String name);

	AdGroup findOrCreateGroupByName(String name);

	AdGroup findGroupById(Long id);

	List<AdGroup> findGroups(Integer offset, Integer limit);

	List<AdGroup> findImmediateGroups(AdPrincipal principal);

	List<AdGroup> findImmediateGroups(AdPrincipal principal, Integer offset, Integer limit);

	Set<AdGroup> findEffectiveGroups(AdPrincipal principal);

	Set<String> findEffectiveGroupsAsString(AdPrincipal principal);

	List<AdGroup> findAvailableUserGroups(AdUser user);

	AdGroup findGroupByUser(AdUser user);

	List<AdPrincipal> findAvailableGroupMembers(AdGroup group);

	List<AdPrincipal> findGroupMembers(AdGroup group);

	List<AdPrincipal> findGroupMembers(AdGroup group, Integer offset, Integer limit);

	Integer countGroup();

	Integer countGroupMember(AdGroup group);

	boolean isGroupExists(String name);

	boolean hasMembership(AdGroup group, AdPrincipal principal);

	AdGroup createGroupWithRole(String groupName, AdRoleType... types);

	void saveGroup(AdGroup group);

	void updateGroup(AdGroup group);

	void removeGroup(AdGroup group);

	void addGroupMember(AdGroup group, AdPrincipal principal) throws RecursiveGroupException;

	void deleteGroupMember(AdGroup group, AdPrincipal principal);

	// ====================================================================================================
	// ACTOR
	// ====================================================================================================

	AdActor findActorById(Long id);

	AdActor findActorByIdentityNo(String identityNo);

	List<AdActor> findActors(Integer offset, Integer limit);

	List<AdActor> findActors(AdActorType type, Integer offset, Integer limit);

	List<AdActor> findActors(String filter, Integer offset, Integer limit);

	List<AdActor> findActors(String filter, AdActorType type, Integer offset, Integer limit);

	Integer countActor();

	Integer countActor(AdActorType type);

	Integer countActor(String filter);

	Integer countActor(String filter, AdActorType type);
	
	void deleteActor(AdActor actor);

	// ====================================================================================================
	// STAFF
	// ====================================================================================================

	AdStaff findStaffById(Long id);

	AdStaff findStaffByStaffNo(String StaffNo);

	AdStaff findStaffByIdentityNo(String identityNo);

	AdStaff findStaffByNricNo(String nricNo);

	List<AdStaff> findStaffs(Integer offset, Integer limit);

	List<AdStaff> findStaffs(AdStaffType type, Integer offset, Integer limit);
	
	List<AdStaff> findAcademicStaffByFaculty(AdStaffType type,AdFaculty faculty, Integer offset, Integer limit);

	Integer countStaff();

	Integer countStaff(String filter);

	boolean isStaffEmailExists(String email);

	boolean isStaffNoExists(String StaffNo);

	void saveStaff(AdStaff Staff);

	void saveStaffIMSNonAcademicActive(AdStaff staff);

	// InActive Staff
	void saveStaffIMSNonAcademicInActive(AdStaff staff);

	// Academic Active Staff
	void saveStaffIMSAcademicActive(AdStaff staff);
	
	// Academic InActive Staff
	void saveStaffIMSAcademicInActive(AdStaff staff);

	void updateStaff(AdStaff Staff);

	void updateStaffIMSNonAcademicActive(AdStaff staff, StaffPayload payload);

	void deleteStaff(AdStaff Staff);

	void broadcastCreated(AdStaff Staff);

	void broadcastUpdated(AdStaff Staff);

	// ====================================================================================================
	// STUDENT
	// ====================================================================================================

	AdStudent findStudentById(Long id);

	AdStudent findStudentByMatricNo(String matricNo);

	List<AdStudent> findStudents(Integer offset, Integer limit);
	
	List<AdStudent> findStudents();

	// findGraduatedStudents
	List<AdStudent> findGraduatedStudents(Integer offset, Integer limit);

	List<AdStudent> findStudents(String filter, Integer offset, Integer limit);

	Integer countStudent();

	Integer countStudent(String filter);

	void saveStudent(AdStudent Student);

	void updateStudent(AdStudent Student);

	void deleteStudent(AdStudent Student);

	void broadcastCreated(AdStudent Student);

	void broadcastUpdated(AdStudent Student);

	// ====================================================================================================
	// SPONSOR
	// ====================================================================================================

	AdSponsor findSponsorById(Long id);

	AdSponsor findSponsorBySponsorNo(String sponsorNo);

	List<AdSponsor> findSponsors(Integer offset, Integer limit);

	List<AdSponsor> findSponsors(String filter, Integer offset, Integer limit);

	Integer countSponsorship(AdSponsor sponsor);

	void saveSponsor(AdSponsor sponsor);

	void addSponsorship(AdSponsor sponsor, AdSponsorship sponsorship);

	void removeSponsorship(AdSponsor sponsor, AdSponsorship sponsorship);

	// ====================================================================================================
	// SPONSORSHIP
	// ====================================================================================================

	AdSponsorship findSponsorshipById(Long id);

	List<AdSponsorship> findSponsorships(AdSponsor sponsor);

	List<AdSponsorship> findSponsorships(AdStudent student);

	List<AdSponsorship> findSponsorships(Integer offset, Integer limit);

	void saveSponsorship(AdSponsorship sponsorship);

	boolean hasSponsorship(AdStudent student);

	boolean hasSponsorship(AdSponsor sponsor);

	void updateSponsorship(AdSponsorship sponsorship);


}
