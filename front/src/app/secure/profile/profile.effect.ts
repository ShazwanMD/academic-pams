import {Student} from '../../shared/model/identity/student.interface';
import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {ProfileService} from '../../../services/profile.service';
import {ProfileActions} from './profile.action';
import {from} from 'rxjs/observable/from';
import {TermModuleState} from '../term/index';
import {Store} from '@ngrx/store';
import {Router} from '@angular/router';
import { TermService } from "../../../services/term.service";

@Injectable()
export class ProfileEffects {

  private STUDENT: string[] = "profileModuleState.student".split(".");

  constructor(private actions$: Actions,
              private profileActions: ProfileActions,
              private profileService: ProfileService,
              private termService: TermService,
              private router: Router,
              private store$: Store<TermModuleState>) {
  }

  /*==================================================================================================*/
  /*BARRING - EFFECT*/
  /*==================================================================================================*/
  @Effect() barStudent$ = this.actions$
    .ofType(ProfileActions.BAR_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.barStudent(student))
    .map(message => this.profileActions.barStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() transferCohort$ = this.actions$
    .ofType(ProfileActions.TRANSFER_COHORT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.transferCohort(payload.student, payload.transferCohort))
    .map(matricNo => this.profileActions.transferCohortSuccess(matricNo))
    .do(action => this.router.navigate(['/secure/profile/profile-detail/', action.payload])).ignoreElements();

  @Effect() switchStudyMode$ = this.actions$
    .ofType(ProfileActions.SWITCH_STUDY_MODE)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.switchStudyMode(payload.student, payload.switchStudyMode))
    .map(matricNo => this.profileActions.switchStudyModeSuccess(matricNo))
    .do(action => this.router.navigate(['/secure/profile/profile-detail/', action.payload])).ignoreElements();

  /*==================================================================================================*/
  /*ACTIVATE / DEACTIVATE - STUDENT EFFECT*/
  /*==================================================================================================*/
  @Effect() activateStudent$ = this.actions$
    .ofType(ProfileActions.ACTIVATE_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.activateStudent(student))
    .map(message => this.profileActions.activateStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deactivateStudent$ = this.actions$
    .ofType(ProfileActions.DEACTIVATE_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.deactivateStudent(student))
    .map(message => this.profileActions.deactivateStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*FINDING THINGS - EFFECT*/
  /*==================================================================================================*/
  @Effect() findProfiles$ = this.actions$
    .ofType(ProfileActions.FIND_STUDENTS)
    .switchMap(() => this.profileService.findStudents())
    .map(profiles => this.profileActions.findStudentsSuccess(profiles));

  @Effect() findStudentByIdentityNo$ = this.actions$
    .ofType(ProfileActions.FIND_STUDENT_BY_IDENTITY_NO)
    .map(action => action.payload)
    .switchMap(identityNo => this.profileService.findStudentByIdentityNo(identityNo))
    .map(student => this.profileActions.findStudentByIdentityNoSuccess(student))
    .mergeMap(action => from([action,
      this.profileActions.findAddresses(action.payload),
      this.profileActions.findAdmissionApplications(action.payload),
      this.profileActions.findContacts(action.payload),
      this.profileActions.findGuarantors(action.payload),
      this.profileActions.findGuardians(action.payload),
      this.profileActions.findEnrollments(action.payload),
      this.profileActions.findAdmissions(action.payload),
    ]));
  
  /*//find admission applications by students
  @Effect() findAdmissionApplications$ = this.actions$
  .ofType(ProfileActions.FIND_ADMISSION_APPLICATIONS)
  .map(action => action.payload)
  .switchMap(student => this.profileService.findAdmissionApplications(student))
  .map(admissionApplications => this.profileActions.findAdmissionApplicationsSuccess(admissionApplications));
*/
  @Effect() findAddresses$ = this.actions$
    .ofType(ProfileActions.FIND_ADDRESSES)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findAddresses(student))
    .map(addreesses => this.profileActions.findAddressesSuccess(addreesses));

  @Effect() findContacts$ = this.actions$
    .ofType(ProfileActions.FIND_CONTACTS)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findContacts(student))
    .map(addreesses => this.profileActions.findContactsSuccess(addreesses));

  @Effect() findGuardians$ = this.actions$
    .ofType(ProfileActions.FIND_GUARDIANS)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findGuardians(student))
    .map(addreesses => this.profileActions.findGuardiansSuccess(addreesses));

  @Effect() findGuarantors$ = this.actions$
    .ofType(ProfileActions.FIND_GUARANTORS)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findGuarantors(student))
    .map(addreesses => this.profileActions.findGuarantorsSuccess(addreesses));

  @Effect() findEnrollments$ = this.actions$
    .ofType(ProfileActions.FIND_ENROLLMENTS_BY_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findEnrollments(student))
    .map(enrollments => this.profileActions.findEnrollmentsSuccess(enrollments));
  
  //find admissions
  @Effect() findAdmissions$ = this.actions$
  .ofType(ProfileActions.FIND_ADMISSIONS_BY_STUDENT)
  .map(action => action.payload)
  .switchMap(student => this.profileService.findAdmissions(student))
  .map(admissions => this.profileActions.findAdmissionsSuccess(admissions));

  
//find admissionApplications
  @Effect() findAdmissionApplications$ = this.actions$
  .ofType(ProfileActions.FIND_ADMISSION_APPLICATIONS_BY_STUDENT)
  .map(action => action.payload)
  .switchMap(student => this.profileService.findAdmissionApplications(student))
  .map(admissionApplications => this.profileActions.findAdmissionApplicationsSuccess(admissionApplications));

  
  /*==================================================================================================*/
  /*ADD / UPD STUDENT INFORMATION - EFFECT*/
  /*==================================================================================================*/
  @Effect() updateProfile$ = this.actions$
    .ofType(ProfileActions.UPDATE_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.updateStudent(student))
    .map(profile => this.profileActions.updateStudentSuccess(profile))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateStudents$ = this.actions$
    .ofType(ProfileActions.UPDATE_STUDENT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudent(payload))
    .map(message => this.profileActions.updateStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*ADMISSION APPLICATION/ADVISORY - EFFECT*/
  /*==================================================================================================*/
  
  @Effect() updateAdmissionApplication$ = this.actions$
  .ofType(ProfileActions.UPDATE_ADMISSION_APPLICATION)
  .map(action => action.payload)
  .switchMap(payload => this.profileService.updateAdmissionApplication(payload.student, payload.admissionApplication))
  .map(message => this.profileActions.updateAdmissionApplicationSuccess(message))
  .withLatestFrom(this.store$.select(...this.STUDENT))
  .map(state => state[1])
  .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  
  /*==================================================================================================*/
  /*ADDRESS - EFFECT*/
  /*==================================================================================================*/
  @Effect() addAddress$ = this.actions$
    .ofType(ProfileActions.ADD_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addAddress(payload.student, payload.address))
    .map(message => this.profileActions.addAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateAddress$ = this.actions$
    .ofType(ProfileActions.UPDATE_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateAddress(payload.student, payload.address))
    .map(message => this.profileActions.updateAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteAddress$ = this.actions$
    .ofType(ProfileActions.REMOVE_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteAddress(payload.student, payload.address))
    .map(message => this.profileActions.deleteAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*CONTACT - EFFECT*/
  /*==================================================================================================*/
  @Effect() addContact$ = this.actions$
    .ofType(ProfileActions.ADD_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addContact(payload.student, payload.contact))
    .map(message => this.profileActions.addContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateContact$ = this.actions$
    .ofType(ProfileActions.UPDATE_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateContact(payload.student, payload.contact))
    .map(message => this.profileActions.updateContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteContact$ = this.actions$
    .ofType(ProfileActions.REMOVE_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteContact(payload.student, payload.contact))
    .map(message => this.profileActions.deleteContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*GUARANTOR - EFFECT*/
  /*==================================================================================================*/
  @Effect() addGuarantor$ = this.actions$
    .ofType(ProfileActions.ADD_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addGuarantor(payload.student, payload.guarantor))
    .map(message => this.profileActions.addGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateGuarantor$ = this.actions$
    .ofType(ProfileActions.UPDATE_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateGuarantor(payload.student, payload.guarantor))
    .map(message => this.profileActions.updateGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteGuarantor$ = this.actions$
    .ofType(ProfileActions.REMOVE_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteGuarantor(payload.student, payload.guarantor))
    .map(message => this.profileActions.deleteGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*GUARDIAN - EFFECT*/
  /*==================================================================================================*/
  @Effect() updateGuardian$ = this.actions$
    .ofType(ProfileActions.UPDATE_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateGuardian(payload.student, payload.guardian))
    .map(message => this.profileActions.updateGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() addGuardian$ = this.actions$
    .ofType(ProfileActions.ADD_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addGuardian(payload.student, payload.guardian))
    .map(message => this.profileActions.addGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteGuardian$ = this.actions$
    .ofType(ProfileActions.REMOVE_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteGuardian(payload.student, payload.guardian))
    .map(message => this.profileActions.deleteGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.profileActions.findStudentByIdentityNo(student.identityNo));
}
