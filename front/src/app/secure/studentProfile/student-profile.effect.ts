import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {ProfileService} from '../../../services/profile.service';
import {from} from 'rxjs/observable/from';
import {TermModuleState} from '../term/index';
import {Store} from '@ngrx/store';
import {Router} from '@angular/router';
import { StudentProfileActions } from "./student-profile.action";
import { Student } from "../../shared/model/identity/student.interface";

@Injectable()
export class StudentProfileEffects {

  private STUDENT: string[] = "studentProfileModuleState.student".split(".");

  constructor(private actions$: Actions,
              private studentProfileActions: StudentProfileActions,
              private profileService: ProfileService,
              private router: Router,
              private store$: Store<TermModuleState>) {
  }

  /*==================================================================================================*/
  /*BARRING - EFFECT*/
  /*==================================================================================================*/
  @Effect() barStudent$ = this.actions$
    .ofType(StudentProfileActions.BAR_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.barStudent(student))
    .map(message => this.studentProfileActions.barStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() transferCohort$ = this.actions$
    .ofType(StudentProfileActions.TRANSFER_COHORT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.transferCohort(payload.student, payload.transferCohort))
    .map(matricNo => this.studentProfileActions.transferCohortSuccess(matricNo))
    .do(action => this.router.navigate(['/secure/profile/profile-detail/', action.payload])).ignoreElements();

  @Effect() switchStudyMode$ = this.actions$
    .ofType(StudentProfileActions.SWITCH_STUDY_MODE)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.switchStudyMode(payload.student, payload.switchStudyMode))
    .map(matricNo => this.studentProfileActions.switchStudyModeSuccess(matricNo))
    .do(action => this.router.navigate(['/secure/profile/profile-detail/', action.payload])).ignoreElements();

  /*==================================================================================================*/
  /*ACTIVATE / DEACTIVATE - STUDENT EFFECT*/
  /*==================================================================================================*/
  @Effect() activateStudent$ = this.actions$
    .ofType(StudentProfileActions.ACTIVATE_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.activateStudent(student))
    .map(message => this.studentProfileActions.activateStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deactivateStudent$ = this.actions$
    .ofType(StudentProfileActions.DEACTIVATE_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.deactivateStudent(student))
    .map(message => this.studentProfileActions.deactivateStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*FINDING THINGS - EFFECT*/
  /*==================================================================================================*/
  @Effect() findProfiles$ = this.actions$
    .ofType(StudentProfileActions.FIND_STUDENTS)
    .switchMap(() => this.profileService.findStudents())
    .map(profiles => this.studentProfileActions.findStudentsSuccess(profiles));

  @Effect() findStudentByIdentityNo$ = this.actions$
    .ofType(StudentProfileActions.FIND_STUDENT_BY_IDENTITY_NO)
    .map(action => action.payload)
    .switchMap(identityNo => this.profileService.findStudentByIdentityNo(identityNo))
    .map(student => this.studentProfileActions.findStudentByIdentityNoSuccess(student))
    .mergeMap(action => from([action,
      this.studentProfileActions.findAddresses(action.payload),
      this.studentProfileActions.findContacts(action.payload),
      this.studentProfileActions.findGuarantors(action.payload),
      this.studentProfileActions.findGuardians(action.payload),
      this.studentProfileActions.findEnrollments(action.payload),
    ]));

  @Effect() findAddresses$ = this.actions$
    .ofType(StudentProfileActions.FIND_ADDRESSES)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findAddresses(student))
    .map(addreesses => this.studentProfileActions.findAddressesSuccess(addreesses));

  @Effect() findContacts$ = this.actions$
    .ofType(StudentProfileActions.FIND_CONTACTS)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findContacts(student))
    .map(addreesses => this.studentProfileActions.findContactsSuccess(addreesses));

  @Effect() findGuardians$ = this.actions$
    .ofType(StudentProfileActions.FIND_GUARDIANS)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findGuardians(student))
    .map(addreesses => this.studentProfileActions.findGuardiansSuccess(addreesses));

  @Effect() findGuarantors$ = this.actions$
    .ofType(StudentProfileActions.FIND_GUARANTORS)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findGuarantors(student))
    .map(addreesses => this.studentProfileActions.findGuarantorsSuccess(addreesses));

  @Effect() findEnrollments$ = this.actions$
    .ofType(StudentProfileActions.FIND_ENROLLMENTS_BY_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.findEnrollments(student))
    .map(enrollments => this.studentProfileActions.findEnrollmentsSuccess(enrollments));

  /*==================================================================================================*/
  /*ADD / UPD STUDENT INFORMATION - EFFECT*/
  /*==================================================================================================*/
  @Effect() updateProfile$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT)
    .map(action => action.payload)
    .switchMap(student => this.profileService.updateStudent(student))
    .map(profile => this.studentProfileActions.updateStudentSuccess(profile))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateStudents$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudent(payload))
    .map(message => this.studentProfileActions.updateStudentSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*ADDRESS - EFFECT*/
  /*==================================================================================================*/
  @Effect() addAddress$ = this.actions$
    .ofType(StudentProfileActions.ADD_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addAddress(payload.student, payload.address))
    .map(message => this.studentProfileActions.addAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateAddress$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateAddress(payload.student, payload.address))
    .map(message => this.studentProfileActions.updateAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteAddress$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteAddress(payload.student, payload.address))
    .map(message => this.studentProfileActions.deleteAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*CONTACT - EFFECT*/
  /*==================================================================================================*/
  @Effect() addContact$ = this.actions$
    .ofType(StudentProfileActions.ADD_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addContact(payload.student, payload.contact))
    .map(message => this.studentProfileActions.addContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateContact$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateContact(payload.student, payload.contact))
    .map(message => this.studentProfileActions.updateContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteContact$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteContact(payload.student, payload.contact))
    .map(message => this.studentProfileActions.deleteContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*GUARANTOR - EFFECT*/
  /*==================================================================================================*/
  @Effect() addGuarantor$ = this.actions$
    .ofType(StudentProfileActions.ADD_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addGuarantor(payload.student, payload.guarantor))
    .map(message => this.studentProfileActions.addGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() updateGuarantor$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateGuarantor(payload.student, payload.guarantor))
    .map(message => this.studentProfileActions.updateGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteGuarantor$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteGuarantor(payload.student, payload.guarantor))
    .map(message => this.studentProfileActions.deleteGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  /*==================================================================================================*/
  /*GUARDIAN - EFFECT*/
  /*==================================================================================================*/
  @Effect() updateGuardian$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateGuardian(payload.student, payload.guardian))
    .map(message => this.studentProfileActions.updateGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() addGuardian$ = this.actions$
    .ofType(StudentProfileActions.ADD_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addGuardian(payload.student, payload.guardian))
    .map(message => this.studentProfileActions.addGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));

  @Effect() deleteGuardian$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteGuardian(payload.student, payload.guardian))
    .map(message => this.studentProfileActions.deleteGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map((student: Student) => this.studentProfileActions.findStudentByIdentityNo(student.identityNo));
}
