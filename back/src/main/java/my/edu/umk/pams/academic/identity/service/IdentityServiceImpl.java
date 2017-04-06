package my.edu.umk.pams.academic.identity.service;

import my.edu.umk.pams.academic.identity.dao.*;
import my.edu.umk.pams.academic.identity.event.ApplicantUpdatedEvent;
import my.edu.umk.pams.academic.identity.event.StaffCreatedEvent;
import my.edu.umk.pams.academic.identity.event.StaffUpdatedEvent;
import my.edu.umk.pams.academic.identity.event.StudentCreatedEvent;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.util.Util;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Transactional
@Service("inIdentityService")
public class IdentityServiceImpl implements IdentityService {

    private static final String GROUP_ROOT = "GRP_ADMN";

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

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

    //====================================================================================================
    // PRINCIPAL
    //====================================================================================================

    @Override
    public AdPrincipal findPrincipalById(Long id) {
        return null;
    }

    @Override
    public AdPrincipal findPrincipalByName(String name) {
        return null;
    }

    @Override
    public List<AdPrincipal> findPrincipals(String filter, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public Set<String> findSids(AdPrincipal principal) {
        return null;
    }

    @Override
    public Integer countPrincipal(String filter) {
        return principalDao.count(filter);
    }

    @Override
    public void addPrincipalRole(AdPrincipal principal, AdPrincipalRole principalRole) {
        principalDao.addRole(principal, principalRole, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deletePrincipalRole(AdPrincipal principal, AdPrincipalRole principalRole) {
        principalDao.deleteRole(principal, principalRole, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // USER
    //====================================================================================================

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
        userDao.save(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateUser(AdUser user) {
        userDao.update(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeUser(AdUser user) {
        userDao.remove(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void changePassword(AdUser user, String newPassword) {
        user.setPassword(newPassword);
        userDao.update(user, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // GROUP
    //====================================================================================================

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
            groupDao.save(group, Util.getCurrentUser());
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
        groupDao.save(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(group);

        for (AdRoleType type : types) {
            AdPrincipalRole role = new AdPrincipalRoleImpl();
            role.setRole(type);
            principalDao.addRole(group, role, Util.getCurrentUser());
            sessionFactory.getCurrentSession().flush();
        }
        sessionFactory.getCurrentSession().refresh(group);
        return group;
    }

    @Override
    public void saveGroup(AdGroup group) {
        groupDao.save(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateGroup(AdGroup group) {
        groupDao.update(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeGroup(AdGroup group) {
        groupDao.remove(group, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGroupMember(AdGroup group, AdPrincipal principal) throws RecursiveGroupException {
        groupDao.addMember(group, principal, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGroupMember(AdGroup group, AdPrincipal principal) {
        groupDao.deleteMember(group, principal);
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // ACTOR
    //====================================================================================================

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


    //====================================================================================================
    // STAFF
    //====================================================================================================

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
    public List<AdStaff> findStaffs(Integer offset, Integer limit) {
        return staffDao.find(offset, limit);
    }

    @Override
    public List<AdStaff> findStaffs(String filter, Integer offset, Integer limit) {
        return staffDao.find(filter, offset, limit);
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
        staffDao.save(staff, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStaff(AdStaff staff) {
        staffDao.update(staff, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteStaff(AdStaff staff) {
        staffDao.delete(staff, Util.getCurrentUser());
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


    //====================================================================================================
    // student
    //====================================================================================================

    @Override
    public AdStudent findStudentById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public AdStudent findStudentByStudentNo(String StudentNo) {
        return studentDao.findByStudentNo(StudentNo);
    }

    @Override
    public List<AdStudent> findStudents(Integer offset, Integer limit) {
        return studentDao.find(offset, limit);
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
        studentDao.save(student, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStudent(AdStudent student) {
        studentDao.update(student, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteStudent(AdStudent student) {
        studentDao.delete(student, Util.getCurrentUser());
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
}
