package my.edu.umk.pams.academic.web.module.integration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.dsl.http.Http;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.dao.RecursiveGroupException;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorImpl;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdGroupMember;
import my.edu.umk.pams.academic.identity.model.AdGroupMemberImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.identity.model.AdPrincipalImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRole;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRoleImpl;
import my.edu.umk.pams.academic.identity.model.AdPrincipalType;
import my.edu.umk.pams.academic.identity.model.AdRoleType;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffImpl;
import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.security.integration.NonSerializableSecurityContext;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.connector.payload.AccountPayload;
import my.edu.umk.pams.connector.payload.CandidatePayload;
import my.edu.umk.pams.connector.payload.FacultyCodePayload;
import my.edu.umk.pams.connector.payload.StaffPayload;

/**
 */
@Transactional
@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

	private static final Logger LOG = LoggerFactory.getLogger(IntegrationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CommonService commonService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@Autowired
	private ProfileService profileService;

	// ====================================================================================================
	// Faculty/Department Code
	// ====================================================================================================

	@RequestMapping(value = "/facultyCodes", method = RequestMethod.POST)
	public ResponseEntity<String> saveFacultyCode(@RequestBody List<FacultyCodePayload> facultyCodePayload) {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Faculty");
		for (FacultyCodePayload payload : facultyCodePayload) {
			LOG.debug("Faculty Code:{}", payload.getCode());

			if (plannerService.isFacultyExists(payload.getCode())) {

				LOG.info("DepartmentCode Already Exists");
				AdFaculty faculty = plannerService.findFacultyByCode(payload.getCode());
				faculty.setCode(payload.getCode());
				faculty.setPrefix(payload.getPrefix()); // prefix
				faculty.setDescription(payload.getDescription());
				plannerService.updateFaculty(faculty);

			} else {
				LOG.info("DepartmentCode Not Exists");
				AdFaculty faculty = new AdFacultyImpl();
				faculty.setCode(payload.getCode());
				faculty.setPrefix(payload.getPrefix()); // prefix
				faculty.setDescription(payload.getDescription());
				faculty.setName(payload.getCode());

				if (payload.getCode().equals("A10")) {
					faculty.setCenter(commonService.findGraduateCenterByCode("MGSEB"));
				} else if (payload.getCode().substring(0, 1).equals("A")) {
					faculty.setCenter(commonService.findGraduateCenterByCode("CPS"));
				} else {
					faculty.setCenter(null);
				}
				plannerService.saveFaculty(faculty);
			}
		}
		LOG.info("Finish Receive Faculty");
		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// COHORT
	// ====================================================================================================
	@RequestMapping(value = "/cohort", method = RequestMethod.POST)
	public ResponseEntity<String> saveCohort() {
		SecurityContext ctx = loginAsSystem();

		AdCohort cohort = new AdCohortImpl();
		cohort.setCode("TODO");
		cohort.setDescription("TODO");
		cohort.setProgram(plannerService.findProgramByCode("TODO"));
		cohort.setCurriculum(plannerService.findCurriculumByCode("TODO"));
		cohort.setSession(plannerService.findCurrentAcademicSession());
		plannerService.saveCohort(cohort);

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}

	// ====================================================================================================
	// STAFF BUKAN AKADEMIC ACTIVE
	// ====================================================================================================
	@RequestMapping(value = "/staff/nonAcademicActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaff(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());

				// Find Staff By Identity No
				AdStaff staff = identityService.findStaffByIdentityNo(payload.getStaffId());
				if (staff.getFaculty().getCenter() != null) {
					// Find Department Code Existence
					if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {

						LOG.info("Faculty Already Exists");

						// Find Department Code
						AdFaculty departmentCode = plannerService.findFacultyByCode(staff.getFaculty().getCode());

						// Find User
						AdUser user = null;

						if (staff.getEmail() == null) {
							user = identityService.findUserByUsername(staff.getIdentityNo());
						} else {
							user = identityService.findUserByUsername(staff.getEmail());
						}

						// Find Group
						AdGroup group = identityService.findGroupByUser(user);

						if (departmentCode.equals(payload.getStaffDepartmentCode())
								&& identityService.isGroupExists(group.getName())) {

							AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

							AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
							staffUpdate.setIdentityNo(payload.getStaffId());
							staffUpdate.setName(payload.getStaffName());
							staffUpdate.setActorType(AdActorType.STAFF);
							staffUpdate.setStaffType(AdStaffType.NON_ACADEMIC);
							staffUpdate.setPhone(payload.getStaffPhoneNo());
							staffUpdate.setFaculty(faculty);
							staffUpdate.setStaffCategory(payload.getStaffCategory());
							staffUpdate.setEmail(payload.getStaffEmail());
							identityService.updateStaff(staffUpdate);

						} else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))) {

							AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

							AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
							staffUpdate.setIdentityNo(payload.getStaffId());
							staffUpdate.setName(payload.getStaffName());
							staffUpdate.setActorType(AdActorType.STAFF);
							staffUpdate.setStaffType(AdStaffType.NON_ACADEMIC);
							staffUpdate.setPhone(payload.getStaffPhoneNo());
							staffUpdate.setFaculty(faculty);
							staffUpdate.setStaffCategory(payload.getStaffCategory());
							staffUpdate.setEmail(payload.getStaffEmail());

							AdUser updateUser = identityService.findUserByUsername(payload.getStaffEmail());
							updateUser.setActor(staffUpdate);
							if (staff.getEmail() == null) {
								updateUser.setEmail(payload.getStaffId());
							} else {
								updateUser.setEmail(payload.getStaffEmail());
							}
							updateUser.setUsername(payload.getStaffEmail());
							updateUser.setPassword(payload.getStaffId());
							updateUser.setRealName(payload.getStaffName());
							if (staff.getEmail() == null) {
								updateUser.setName(payload.getStaffId());
							} else {
								updateUser.setName(payload.getStaffEmail());
							}
							updateUser.setEnabled(true);
							updateUser.setLocked(true);
							updateUser.setPrincipalType(AdPrincipalType.USER);
							identityService.saveUser(updateUser);

							AdPrincipal principal = null;
							if (staff.getEmail() == null) {
								principal = identityService.findPrincipalByName(payload.getStaffId());
							} else {
								principal = identityService.findPrincipalByName(payload.getStaffEmail());
							}
							LOG.debug("Principal Atas:{}", principal);

							// Check Group Existence
							if (identityService.isGroupExists(group.getName())) {

								// setting roles of MGSEB
								if (payload.getStaffDepartmentCode().equals("A10")) {

									if (payload.getStaffCategory().equals("A")) {

										// Principal Role
										AdPrincipalRole roleA10 = new AdPrincipalRoleImpl();
										roleA10.setPrincipal(principal);
										roleA10.setRole(AdRoleType.ROLE_MGSEB);
										identityService.addPrincipalRole(principal, roleA10);

										try {
											// Group
											AdGroup groupPegawaiA10 = identityService
													.findGroupByName("GRP_PGW_ADM_A10");
											// GroupMember
											if (!identityService.isGroupExists(groupPegawaiA10.getName())) {

												identityService.addGroupMember(groupPegawaiA10, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									} else {

										// Principal Role
										AdPrincipalRole roleKRNA10 = new AdPrincipalRoleImpl();
										roleKRNA10.setPrincipal(principal);
										roleKRNA10.setRole(AdRoleType.ROLE_MGSEB);
										identityService.addPrincipalRole(principal, roleKRNA10);

										try {
											// Group
											AdGroup groupKRNA10 = identityService.findGroupByName("GRP_KRN_ADM_A10");
											// GroupMember
											if (!identityService.isGroupExists(groupKRNA10.getName())) {

												identityService.addGroupMember(groupKRNA10, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									}
								}
								// Setting roles of CPS
								else if (payload.getStaffDepartmentCode().equals("A09")) {

									if (payload.getStaffCategory().equals("A")) {

										// Principal Role
										AdPrincipalRole roleA09 = new AdPrincipalRoleImpl();
										roleA09.setPrincipal(principal);
										roleA09.setRole(AdRoleType.ROLE_CPS);
										identityService.addPrincipalRole(principal, roleA09);

										try {
											// Group
											AdGroup groupPegawaiA09 = identityService
													.findGroupByName("GRP_PGW_ADM_A09");
											// GroupMember
											if (!identityService.isGroupExists(groupPegawaiA09.getName())) {

												identityService.addGroupMember(groupPegawaiA09, principal);
											}
										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									} else {

										// Principal Role
										AdPrincipalRole roleKRNA09 = new AdPrincipalRoleImpl();
										roleKRNA09.setPrincipal(principal);
										roleKRNA09.setRole(AdRoleType.ROLE_CPS);
										identityService.addPrincipalRole(principal, roleKRNA09);

										try {
											// Group
											AdGroup groupKRNA09 = identityService.findGroupByName("GRP_KRN_ADM_A09");
											// GroupMember
											if (!identityService.isGroupExists(groupKRNA09.getName())) {

												identityService.addGroupMember(groupKRNA09, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									}
								}
								// Setting roles of Others Faculty
								else {
									if (payload.getStaffCategory().equals("A")) {
										LOG.info("If All Faculty and Category A Only");

										// Principal Role
										AdPrincipalRole roleAllFac = new AdPrincipalRoleImpl();
										roleAllFac.setPrincipal(principal);
										roleAllFac.setRole(AdRoleType.ROLE_FACULTY);
										identityService.addPrincipalRole(principal, roleAllFac);
										LOG.debug("roleAllFac:{}", roleAllFac);
										try {
											// Group

											AdGroup groupAllFac = identityService.findGroupByName(
													"GRP_PGW_FCTY_" + payload.getStaffDepartmentCode());
											LOG.debug("Group:{}", groupAllFac);
											// GroupMember
											if (!identityService.isGroupExists(groupAllFac.getName())) {

												identityService.addGroupMember(groupAllFac, principal);
											}
										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}
									} else {
										LOG.info("If All Faculty Only");

										// Principal Role
										AdPrincipalRole roleAllFaculty = new AdPrincipalRoleImpl();
										roleAllFaculty.setPrincipal(principal);
										roleAllFaculty.setRole(AdRoleType.ROLE_FACULTY);
										identityService.addPrincipalRole(principal, roleAllFaculty);

										try {
											// Group
											AdGroup groupAllFaculty = identityService.findGroupByName(
													"GRP_KRN_FCTY_" + payload.getStaffDepartmentCode());
											LOG.debug("Group:{}", groupAllFaculty);
											// GroupMember
											if (!identityService.isGroupExists(groupAllFaculty.getName())) {

												identityService.addGroupMember(groupAllFaculty, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}
									}
								}
							}

							identityService.updateStaff(staffUpdate);
						}

					}
				} else {
					LOG.info("Faculty Not Exists");

					// update staff
					AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
					staffUpdate.setIdentityNo(payload.getStaffId());
					staffUpdate.setName(payload.getStaffName());
					staffUpdate.setActorType(AdActorType.STAFF);
					staffUpdate.setStaffType(AdStaffType.NON_ACADEMIC);
					staffUpdate.setPhone(payload.getStaffPhoneNo());
					staffUpdate.setStaffCategory(payload.getStaffCategory());
					staffUpdate.setEmail(payload.getStaffEmail());
					identityService.updateStaff(staffUpdate);
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
				LOG.debug("Staff Category:{}", payload.getStaffCategory());

				String facultyCode = payload.getStaffDepartmentCode();
				AdFaculty faculty = plannerService.findFacultyByCode(facultyCode);

				AdStaff staff = new AdStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(AdStaffType.NON_ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(AdActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFaculty(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());

				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {

					if (faculty.getCenter() != null) {

						LOG.info("if faculty exists");
						identityService.saveStaffIMSNonAcademicActive(staff);

					} else {
						LOG.info("if Graduate Center not exists");
						identityService.saveStaff(staff);
					}

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STAFF BUKAN AKADEMIC INACTIVE
	// ====================================================================================================
	@RequestMapping(value = "/staff/nonAcademicInActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaffInActive(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());

				// Find Staff By Identity No
				AdStaff staff = identityService.findStaffByIdentityNo(payload.getStaffId());

				// Find Department Code Existence
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {

					LOG.info("Faculty Already Exists");

					// Find Department Code
					AdFaculty departmentCode = plannerService.findFacultyByCode(staff.getFaculty().getCode());

					// Find User
					AdUser user = null;

					if (staff.getEmail() == null) {
						user = identityService.findUserByUsername(staff.getIdentityNo());
					} else {
						user = identityService.findUserByUsername(staff.getEmail());
					}

					// Find Group
					AdGroup group = identityService.findGroupByUser(user);

					if (departmentCode.equals(payload.getStaffDepartmentCode())
							&& identityService.isGroupExists(group.getName())) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staffUpdate.setStaffType(AdStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());
						identityService.updateStaff(staffUpdate);

					} else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staffUpdate.setStaffType(AdStaffType.NON_ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setStaffCategory(payload.getStaffCategory());
						staffUpdate.setEmail(payload.getStaffEmail());

						AdUser updateUser = identityService.findUserByUsername(payload.getStaffEmail());
						updateUser.setActor(staffUpdate);
						if (staff.getEmail() == null) {
							updateUser.setEmail(payload.getStaffId());
						} else {
							updateUser.setEmail(payload.getStaffEmail());
						}
						updateUser.setUsername(payload.getStaffEmail());
						updateUser.setPassword(payload.getStaffId());
						updateUser.setRealName(payload.getStaffName());
						if (staff.getEmail() == null) {
							updateUser.setName(payload.getStaffId());
						} else {
							updateUser.setName(payload.getStaffEmail());
						}
						updateUser.setEnabled(false);
						updateUser.setLocked(true);
						updateUser.setPrincipalType(AdPrincipalType.USER);
						identityService.saveUser(updateUser);

						AdPrincipal principal = null;
						if (staff.getEmail() == null) {
							principal = identityService.findPrincipalByName(payload.getStaffId());
						} else {
							principal = identityService.findPrincipalByName(payload.getStaffEmail());
						}

						LOG.debug("Principal Atas:{}", principal);

						// Check Group Existence
						if (group != null) {
							if (identityService.isGroupExists(group.getName())) {

								// setting roles of MGSEB
								if (payload.getStaffDepartmentCode().equals("A10")) {

									if (payload.getStaffCategory().equals("A")) {

										// Principal Role
										AdPrincipalRole roleA10 = new AdPrincipalRoleImpl();
										roleA10.setPrincipal(principal);
										roleA10.setRole(AdRoleType.ROLE_MGSEB);
										identityService.addPrincipalRole(principal, roleA10);

										try {
											// Group
											AdGroup groupPegawaiA10 = identityService
													.findGroupByName("GRP_PGW_ADM_A10");
											// GroupMember
											if (!identityService.isGroupExists(groupPegawaiA10.getName())) {

												identityService.addGroupMember(groupPegawaiA10, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									} else {

										// Principal Role
										AdPrincipalRole roleKRNA10 = new AdPrincipalRoleImpl();
										roleKRNA10.setPrincipal(principal);
										roleKRNA10.setRole(AdRoleType.ROLE_MGSEB);
										identityService.addPrincipalRole(principal, roleKRNA10);

										try {
											// Group
											AdGroup groupKRNA10 = identityService.findGroupByName("GRP_KRN_ADM_A10");
											// GroupMember
											if (!identityService.isGroupExists(groupKRNA10.getName())) {

												identityService.addGroupMember(groupKRNA10, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									}
								}
								// Setting roles of CPS
								else if (payload.getStaffDepartmentCode().equals("A09")) {

									if (payload.getStaffCategory().equals("A")) {

										// Principal Role
										AdPrincipalRole roleA09 = new AdPrincipalRoleImpl();
										roleA09.setPrincipal(principal);
										roleA09.setRole(AdRoleType.ROLE_CPS);
										identityService.addPrincipalRole(principal, roleA09);

										try {
											// Group
											AdGroup groupPegawaiA09 = identityService
													.findGroupByName("GRP_PGW_ADM_A09");
											// GroupMember
											if (!identityService.isGroupExists(groupPegawaiA09.getName())) {

												identityService.addGroupMember(groupPegawaiA09, principal);
											}
										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									} else {

										// Principal Role
										AdPrincipalRole roleKRNA09 = new AdPrincipalRoleImpl();
										roleKRNA09.setPrincipal(principal);
										roleKRNA09.setRole(AdRoleType.ROLE_CPS);
										identityService.addPrincipalRole(principal, roleKRNA09);

										try {
											// Group
											AdGroup groupKRNA09 = identityService.findGroupByName("GRP_KRN_ADM_A09");
											// GroupMember
											if (!identityService.isGroupExists(groupKRNA09.getName())) {

												identityService.addGroupMember(groupKRNA09, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}

									}
								}
								// Setting roles of Others Faculty
								else {
									if (payload.getStaffCategory().equals("A")) {
										LOG.info("If All Faculty and Category A Only");

										// Principal Role
										AdPrincipalRole roleAllFac = new AdPrincipalRoleImpl();
										roleAllFac.setPrincipal(principal);
										roleAllFac.setRole(AdRoleType.ROLE_FACULTY);
										identityService.addPrincipalRole(principal, roleAllFac);
										LOG.debug("roleAllFac:{}", roleAllFac);
										try {
											// Group

											AdGroup groupAllFac = identityService.findGroupByName(
													"GRP_PGW_FCTY_" + payload.getStaffDepartmentCode());
											LOG.debug("Group:{}", groupAllFac);
											// GroupMember
											if (!identityService.isGroupExists(groupAllFac.getName())) {

												identityService.addGroupMember(groupAllFac, principal);
											}
										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}
									} else {
										LOG.info("If All Faculty Only");

										// Principal Role
										AdPrincipalRole roleAllFaculty = new AdPrincipalRoleImpl();
										roleAllFaculty.setPrincipal(principal);
										roleAllFaculty.setRole(AdRoleType.ROLE_FACULTY);
										identityService.addPrincipalRole(principal, roleAllFaculty);

										try {
											// Group
											AdGroup groupAllFaculty = identityService.findGroupByName(
													"GRP_KRN_FCTY_" + payload.getStaffDepartmentCode());
											LOG.debug("Group:{}", groupAllFaculty);
											// GroupMember
											if (!identityService.isGroupExists(groupAllFaculty.getName())) {

												identityService.addGroupMember(groupAllFaculty, principal);
											}

										} catch (RecursiveGroupException e) {

											e.printStackTrace();
										}
									}
								}
							}
						} else {

							identityService.updateStaff(staffUpdate);

						}

						identityService.updateStaff(staffUpdate);
					}

				} else {
					LOG.info("Faculty Not Exists");

					// update staff
					AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
					staffUpdate.setIdentityNo(payload.getStaffId());
					staffUpdate.setName(payload.getStaffName());
					staffUpdate.setActorType(AdActorType.STAFF);
					staffUpdate.setStaffType(AdStaffType.NON_ACADEMIC);
					staffUpdate.setPhone(payload.getStaffPhoneNo());
					staffUpdate.setStaffCategory(payload.getStaffCategory());
					staffUpdate.setEmail(payload.getStaffEmail());
					identityService.updateStaff(staffUpdate);
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());
				LOG.debug("Staff Category:{}", payload.getStaffCategory());

				String facultyCode = payload.getStaffDepartmentCode();
				AdFaculty faculty = plannerService.findFacultyByCode(facultyCode);

				AdStaff staff = new AdStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(AdStaffType.NON_ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(AdActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFaculty(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {
					LOG.info("if faculty exists");
					identityService.saveStaffIMSNonAcademicInActive(staff);

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STAFF AKADEMIC ACTIVE
	// ====================================================================================================
	@RequestMapping(value = "/staff/academicActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaffAcademicActive(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Academic Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());

				// Find Staff By Identity No
				AdStaff staff = identityService.findStaffByIdentityNo(payload.getStaffId());

				// Find Department Code Existence
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {

					// Find Department Code
					AdFaculty departmentCode = plannerService.findFacultyByCode(staff.getFaculty().getCode());

					// Find User
					AdUser user = null;

					if (staff.getEmail() == null) {
						user = identityService.findUserByUsername(staff.getIdentityNo());
					} else {
						user = identityService.findUserByUsername(staff.getEmail());
					}
					// Find Group
					AdGroup group = identityService.findGroupByUser(user);

					if (departmentCode.equals(payload.getStaffDepartmentCode())
							&& identityService.isGroupExists(group.getName())) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staffUpdate.setStaffType(AdStaffType.ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setEmail(payload.getStaffEmail());
						identityService.updateStaff(staffUpdate);

					} else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate2 = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate2.setIdentityNo(payload.getStaffId());
						staffUpdate2.setName(payload.getStaffName());
						staffUpdate2.setActorType(AdActorType.STAFF);
						staffUpdate2.setStaffType(AdStaffType.ACADEMIC);
						staffUpdate2.setPhone(payload.getStaffPhoneNo());
						staffUpdate2.setFaculty(faculty);
						staffUpdate2.setEmail(payload.getStaffEmail());

						AdUser updateUser = null;

						if (staff.getEmail() == null) {
							LOG.info("no email");
							updateUser = identityService.findUserByUsername(payload.getStaffId());
						} else {
							LOG.info("has email");
							updateUser = identityService.findUserByUsername(payload.getStaffEmail());
						}
						updateUser.setActor(staffUpdate2);

						if (staffUpdate2.getEmail() == null) {
							updateUser.setEmail(payload.getStaffId());
						} else {
							updateUser.setEmail(payload.getStaffEmail());
						}

						updateUser.setUsername(payload.getStaffEmail());
						updateUser.setPassword(payload.getStaffId());
						updateUser.setRealName(payload.getStaffName());
						if (staff.getEmail() == null) {
							updateUser.setName(payload.getStaffId());
						} else {
							updateUser.setName(payload.getStaffEmail());
						}
						updateUser.setEnabled(true);
						updateUser.setLocked(true);
						updateUser.setPrincipalType(AdPrincipalType.USER);
						identityService.saveUser(updateUser);

						AdPrincipal principal = null;
						if (staff.getEmail() == null) {
							principal = identityService.findPrincipalByName(payload.getStaffId());
						} else {
							principal = identityService.findPrincipalByName(payload.getStaffEmail());
						}

						if (identityService.isGroupExists(group.getName())) {

							LOG.info("If Group Academic Exists");

							// Principal Role
							AdPrincipalRole role = new AdPrincipalRoleImpl();
							role.setPrincipal(principal);
							role.setRole(AdRoleType.ROLE_LECTURER);
							identityService.addPrincipalRole(principal, role);

							try {
								// Group
								AdGroup groupLec = identityService.findGroupByName("GRP_LEC");
								LOG.debug("Group:{}", groupLec);
								// GroupMember
								if (!identityService.isGroupExists(groupLec.getName())) {

									identityService.addGroupMember(groupLec, principal);
								}

							} catch (RecursiveGroupException e) {

								e.printStackTrace();
							}
						}
						identityService.updateStaff(staffUpdate2);
					}
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());

				String facultyCode = payload.getStaffDepartmentCode();
				AdFaculty faculty = plannerService.findFacultyByCode(facultyCode);

				AdStaff staff = new AdStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(AdStaffType.ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(AdActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFaculty(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {
					LOG.info("if faculty exists");
					identityService.saveStaffIMSAcademicActive(staff);

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STAFF AKADEMIC INACTIVE
	// ====================================================================================================
	@RequestMapping(value = "/staff/academicInActive", method = RequestMethod.POST)
	public ResponseEntity<String> saveStaffAcademicInActive(@RequestBody List<StaffPayload> staffPayload)
			throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receive Academic Staff From IMS");
		for (StaffPayload payload : staffPayload) {

			boolean staffReceive = identityService.isStaffNoExists(payload.getStaffId());

			if (staffReceive) {

				LOG.info("Staff already exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());

				// Find Staff By Identity No
				AdStaff staff = identityService.findStaffByIdentityNo(payload.getStaffId());

				// Find Department Code Existence
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {

					// Find Department Code
					AdFaculty departmentCode = plannerService.findFacultyByCode(staff.getFaculty().getCode());

					// Find User
					AdUser user = null;

					if (staff.getEmail() == null) {
						user = identityService.findUserByUsername(staff.getIdentityNo());
					} else {
						user = identityService.findUserByUsername(staff.getEmail());
					}

					// Find Group
					AdGroup group = identityService.findGroupByUser(user);

					if (departmentCode.equals(payload.getStaffDepartmentCode())
							&& identityService.isGroupExists(group.getName())) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staffUpdate.setStaffType(AdStaffType.ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setEmail(payload.getStaffEmail());

						identityService.updateStaff(staffUpdate);

					} else if ((!departmentCode.equals(payload.getStaffDepartmentCode()))) {

						AdFaculty faculty = plannerService.findFacultyByCode(payload.getStaffDepartmentCode());

						AdStaff staffUpdate = identityService.findStaffByIdentityNo(payload.getStaffId());
						staffUpdate.setIdentityNo(payload.getStaffId());
						staffUpdate.setName(payload.getStaffName());
						staffUpdate.setActorType(AdActorType.STAFF);
						staffUpdate.setStaffType(AdStaffType.ACADEMIC);
						staffUpdate.setPhone(payload.getStaffPhoneNo());
						staffUpdate.setFaculty(faculty);
						staffUpdate.setEmail(payload.getStaffEmail());

						AdUser updateUser = null;

						if (staff.getEmail() == null) {
							updateUser = identityService.findUserByUsername(payload.getStaffId());
						} else {
							updateUser = identityService.findUserByUsername(payload.getStaffEmail());
						}
						updateUser.setActor(staffUpdate);
						if (staffUpdate.getEmail() == null) {
							updateUser.setEmail(payload.getStaffId());
						} else {
							updateUser.setEmail(payload.getStaffEmail());
						}
						updateUser.setUsername(payload.getStaffEmail());
						updateUser.setPassword(payload.getStaffId());
						updateUser.setRealName(payload.getStaffName());
						if (staff.getEmail() == null) {
							updateUser.setName(payload.getStaffId());
						} else {
							updateUser.setName(payload.getStaffEmail());
						}
						updateUser.setEnabled(false);
						updateUser.setLocked(true);
						updateUser.setPrincipalType(AdPrincipalType.USER);
						identityService.saveUser(updateUser);

						AdPrincipal principal = null;
						if (staff.getEmail() == null) {
							principal = identityService.findPrincipalByName(payload.getStaffId());
						} else {
							principal = identityService.findPrincipalByName(payload.getStaffEmail());
						}

						if (identityService.isGroupExists(group.getName())) {

							LOG.info("If Group Academic Exists");

							// Principal Role
							AdPrincipalRole role = new AdPrincipalRoleImpl();
							role.setPrincipal(principal);
							role.setRole(AdRoleType.ROLE_LECTURER);
							identityService.addPrincipalRole(principal, role);

							try {
								// Group
								AdGroup groupLec = identityService.findGroupByName("GRP_LEC");
								LOG.debug("Group:{}", groupLec);
								// GroupMember
								if (!identityService.isGroupExists(groupLec.getName())) {

									identityService.addGroupMember(groupLec, principal);
								}

							} catch (RecursiveGroupException e) {

								e.printStackTrace();
							}
						}
						identityService.updateStaff(staffUpdate);
					}
				}

			} else {

				LOG.info("Staff not exists");
				LOG.debug("Staff Staff_No:{}", payload.getStaffId());
				LOG.debug("Staff Name:{}", payload.getStaffName());
				LOG.debug("Staff Department_Code:{}", payload.getStaffDepartmentCode());

				String facultyCode = payload.getStaffDepartmentCode();
				AdFaculty faculty = plannerService.findFacultyByCode(facultyCode);

				AdStaff staff = new AdStaffImpl();
				staff.setIdentityNo(payload.getStaffId());
				staff.setStaffType(AdStaffType.ACADEMIC);
				staff.setName(payload.getStaffName());
				staff.setActorType(AdActorType.STAFF);
				staff.setPhone(payload.getStaffPhoneNo());
				staff.setFaculty(faculty);
				staff.setStaffCategory(payload.getStaffCategory());
				staff.setEmail(payload.getStaffEmail());
				if (plannerService.isFacultyExists(payload.getStaffDepartmentCode())) {
					LOG.info("if faculty exists");
					identityService.saveStaffIMSAcademicInActive(staff);

				} else {
					LOG.info("if faculty not exists");
					identityService.saveStaff(staff);

				}
			}
		}
		LOG.info("Finish Receive Staff From IMS");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// ====================================================================================================
	// STUDENT ACCOUNT
	// ====================================================================================================
	@RequestMapping(value = "/studentAccounts", method = RequestMethod.PUT)
	public ResponseEntity<String> saveStudentAccount(@RequestBody AccountPayload payload) {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start Receiving Student Account");
		// Find Student By Matric No
		AdStudent student = identityService.findStudentByMatricNo(payload.getMatricNo());
		LOG.debug("Student Name:{}", student.getName());

		student.setBalance(payload.getBalance());
		student.setOutstanding(payload.isOutstanding());

		// Condition Boolean Outstanding == true
		if (payload.isOutstanding() == true) {

			LOG.info("Student Has Outstanding Payments");

			student.setMemo("Outstanding Payments");
			student.setStudentStatus(AdStudentStatus.BARRED);

		}

		// Condition Boolean Outstanding == false
		else {

			LOG.info("Student Has No Outstanding");

			student.setMemo("N/A");
			student.setStudentStatus(AdStudentStatus.ACTIVE);

		}
		identityService.updateStudent(student);

		LOG.info("Finish Receiving Student Account");
		logoutAsSystem(ctx);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}

	// ====================================================================================================
	// CANDIDATE
	// ====================================================================================================
	@RequestMapping(value = "/candidates", method = RequestMethod.POST)
	public ResponseEntity<String> saveCandidate(@RequestBody CandidatePayload payload) throws RecursiveGroupException {
		SecurityContext ctx = loginAsSystem();

		LOG.info("Start integration candidate controller");

		if (plannerService.isCohortExists(payload.getCohortCode())) {
			LOG.info("cohort already exists");
		} else {

			LOG.info("if cohort not exists");

			// Cohort
			AdCohort cohort = new AdCohortImpl();
			cohort.setCode(payload.getCohortCode());
			cohort.setDescription(payload.getCohortCode());
			cohort.setProgram(plannerService.findProgramByCode(payload.getProgramCode().getCode()));
			cohort.setSession(plannerService.findCurrentAcademicSession());
			plannerService.saveCohort(cohort);

		}

		// student info
		AdStudent student = new AdStudentImpl();
		student.setMatricNo(payload.getMatricNo());
		student.setName(payload.getName());
		student.setEmail(payload.getEmail());
		student.setFax(payload.getFax());
		student.setPhone(payload.getPhone());
		student.setMobile(payload.getMobile());
		student.setNoID(payload.getUserPayload().getNric());
		student.setGenderCode(commonService.findGenderCodeByCode(payload.getGender()));
		student.setMaritalCode(commonService.findMaritalCodeByCode(payload.getMartialStatus()));
		student.setRaceCode(commonService.findRaceCodeByCode(payload.getRace()));
		student.setReligionCode(commonService.findReligionCodeByCode(payload.getReligion()));
		student.setNationalityCode(commonService.findNationalityCodeByCode(payload.getNationalityCode().getCode()));

		// status, mode and cohort
		student.setStudentStatus(AdStudentStatus.ACTIVE);
		student.setStudyMode(commonService.findStudyModeByCode(payload.getStudyMode().getCode()));
		student.setCohort(plannerService.findCohortByCode(payload.getCohortCode()));
		student.setBalance(BigDecimal.ZERO);
		student.setOutstanding(false);

		identityService.saveStudent(student);

		// Mailing Address
		AdAddress currentAddress = new AdAddressImpl();
		currentAddress.setAddress1(payload.getSecondaryAddress().getAddress1());
		currentAddress.setAddress2(payload.getSecondaryAddress().getAddress2());
		currentAddress.setAddress3(payload.getSecondaryAddress().getAddress3());
		currentAddress.setPostCode(payload.getSecondaryAddress().getPostcode());
		currentAddress.setStateCode(commonService.findStateCodeByCode(payload.getSecondaryAddress().getStateCode()));
		currentAddress
				.setCountryCode(commonService.findCountryCodeByCode(payload.getSecondaryAddress().getCountryCode()));
		currentAddress.setStudent(student);
		currentAddress.setType(AdAddressType.CURRENT);
		profileService.addAddress(student, currentAddress);

		// Billing Address
		AdAddress permenantAddress = new AdAddressImpl();
		permenantAddress.setAddress1(payload.getPrimaryAddress().getAddress1());
		permenantAddress.setAddress2(payload.getPrimaryAddress().getAddress2());
		permenantAddress.setAddress3(payload.getPrimaryAddress().getAddress3());
		permenantAddress.setPostCode(payload.getPrimaryAddress().getPostcode());
		permenantAddress.setStateCode(commonService.findStateCodeByCode(payload.getPrimaryAddress().getStateCode()));
		permenantAddress
				.setCountryCode(commonService.findCountryCodeByCode(payload.getPrimaryAddress().getCountryCode()));
		permenantAddress.setStudent(student);
		permenantAddress.setType(AdAddressType.PERMANENT);
		profileService.addAddress(student, permenantAddress);

		// User
		AdUser user = new AdUserImpl();
		user.setActor(student);
		user.setEmail(payload.getEmail());
		user.setUsername(payload.getEmail());
		user.setPassword(payload.getUserPayload().getPassword());
		user.setRealName(payload.getName());
		identityService.saveUser(user);

		// Principal
		AdPrincipal principal = identityService.findPrincipalByName(payload.getEmail());
		principal.setName(payload.getEmail());
		principal.setPrincipalType(AdPrincipalType.USER);
		principal.setEnabled(true);
		principal.setLocked(true);

		// Principal Role
		AdPrincipalRole role = new AdPrincipalRoleImpl();
		role.setPrincipal(principal);
		role.setRole(AdRoleType.ROLE_USER);
		identityService.addPrincipalRole(principal, role);

		// Group
		AdGroup group = identityService.findGroupByName("GRP_STDN");
		// GroupMember
		AdGroupMember member = new AdGroupMemberImpl();
		member.setGroup(group);
		member.setPrincipal(principal);
		identityService.addGroupMember(group, principal);

		LOG.info("Start Admission");
		AdAcademicSession session = plannerService.findCurrentAcademicSession();
		AdAdmission admission = new AdAdmissionImpl();
		admission.setSession(session);
		admission.setStudent(student);
		admission.setOrdinal(1);

		// Advisor
		if (payload.getFacultyCode().getCode().equals("A10")) {
			admission.setAdvisor(null);
		} else {
			AdStaff advisor = identityService.findStaffByIdentityNo(payload.getSupervisorCode());
			LOG.debug("advisor name:{}", advisor.getName());
			admission.setAdvisor(advisor);
		}
		LOG.info("Finish Supervisor");

		admission.setCgpa(BigDecimal.ZERO);
		admission.setCohort(plannerService.findCohortByCode(payload.getCohortCode()));
		admission.setGpa(BigDecimal.ZERO);
		admission.setStanding(AdAcademicStanding.TBD);
		admission.setStatus(AdAdmissionStatus.REGULAR);

		// StudyCenter
		if (payload.getFacultyCode().getCode().equals("A10")) {
			LOG.debug("Faculty:{}", payload.getFacultyCode());

			String studyCenterCode = payload.getStudyCenter().getCode();
			admission.setStudyCenter(commonService.findStudyCenterByCode(studyCenterCode));
		} else {
			LOG.debug("Faculty:{}", payload.getFacultyCode());
			LOG.info("StudyCenter NULL");
			admission.setStudyCenter(null);
		}
		LOG.info("Finish StudyCenter");

		termService.saveAdmission(admission);
		LOG.info("Finish Admission");

		LOG.info("Finish integration candidate controller");

		logoutAsSystem(ctx);
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}

	private SecurityContext loginAsSystem() {
		SecurityContext savedCtx = SecurityContextHolder.getContext();
		AdAutoLoginToken authenticationToken = new AdAutoLoginToken("system");
		Authentication authed = authenticationManager.authenticate(authenticationToken);
		SecurityContext system = new NonSerializableSecurityContext();
		system.setAuthentication(authed);
		SecurityContextHolder.setContext(system);
		return savedCtx;
	}

	private void logoutAsSystem(SecurityContext context) {
		SecurityContextHolder.setContext(context);
	}
}
