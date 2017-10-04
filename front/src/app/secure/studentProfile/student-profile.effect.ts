import { ProfileActions } from './../profile/profile.action';
import { Injectable } from '@angular/core';
import { Actions, Effect } from '@ngrx/effects';
import { ProfileService } from '../../../services/profile.service';
import { from } from 'rxjs/observable/from';
import { TermModuleState } from '../term/index';
import { Store } from '@ngrx/store';
import { Router } from '@angular/router';
import { StudentProfileActions } from "./student-profile.action";
import { Student } from "../../shared/model/identity/student.interface";

@Injectable()
export class StudentProfileEffects {

  private STUDENT: string[] = "studentProfileModuleState.student".split(".");

  constructor(private actions$: Actions,
    private studentProfileActions: StudentProfileActions,
    private profileActions: ProfileActions,
    private profileService: ProfileService,
    private router: Router,
    private store$: Store<TermModuleState>) {
  }

  /*==================================================================================================*/
  /*FINDING THINGS - EFFECT*/
  /*==================================================================================================*/
  @Effect() findStudentByUser$ = this.actions$
    .ofType(StudentProfileActions.FIND_STUDENT_BY_USER)
    .map(action => action.payload)
    .switchMap(() => this.profileService.findStudentByUser())
    .map(payload => this.studentProfileActions.findStudentByUserSuccess(payload))
    .mergeMap(action => from([action,
      this.profileActions.findAddresses(action.payload),
      this.profileActions.findContacts(action.payload),
      this.profileActions.findGuarantors(action.payload),
      this.profileActions.findGuardians(action.payload),
      this.profileActions.findEnrollments(action.payload),
      this.profileActions.findAdmissions(action.payload),
      this.profileActions.findGraduationApplications(action.payload),
      this.profileActions.findGraduations(action.payload),
      this.profileActions.findAdmissionApplications(action.payload),
    ]));

  @Effect() findStudentsByIdentityNo$ = this.actions$
    .ofType(StudentProfileActions.FIND_STUDENTS_BY_IDENTITY_NO)
    .map(action => action.payload)
    .switchMap(identityNo => this.profileService.findStudentByIdentityNo(identityNo))
    .map(student => this.studentProfileActions.findStudentsByIdentityNo(student));


  @Effect() findAddressessByStudent$ = this.actions$
    .ofType(StudentProfileActions.FIND_ADDRESSES_BY_STUDENT)
    .map(action => action.payload)
    .switchMap(() => this.profileService.findAddressessByStudent())
    .map(addreesses => this.studentProfileActions.findAddressessByStudentSuccess(addreesses));

  @Effect() findAcademicSessionsByStudent$ = this.actions$
    .ofType(StudentProfileActions.FIND_ACADEMIC_SESSIONS_BY_STUDENT)
    .map(action => action.payload)
    .switchMap(() => this.profileService.findAcademicSessionsByStudent())
    .map(message => this.studentProfileActions.findAcademicSessionsByStudentSuccess(message));

  @Effect() findAcademicSessionByCode$ = this.actions$
    .ofType(StudentProfileActions.FIND_ACADEMIC_SESSION_BY_CODE)
    .map((action) => action.payload)
    .switchMap((code) => this.profileService.findAcademicSessionByCode(code))
    .map((academicSession) => this.studentProfileActions.findAcademicSessionByCodeSuccess(academicSession));

  @Effect() findAdmissionsByStudent$ = this.actions$
    .ofType(StudentProfileActions.FIND_ADMISSIONS_BY_STUDENT)
    .map(action => action.payload)
    .switchMap(() => this.profileService.findAdmissionsByStudent())
    .map(message => this.studentProfileActions.findAdmissionsByStudentSuccess(message));

  @Effect() findAdmissionsById$ = this.actions$
    .ofType(StudentProfileActions.FIND_ADMISSIONS_BY_ID)
    .map(action => action.payload)
    .switchMap((id) => this.profileService.findAdmissionsById(id))
    .map(message => this.studentProfileActions.findAdmissionsByIdSuccess(message));

  @Effect() findEnrollmentsByAdmissionsID$ = this.actions$
    .ofType(StudentProfileActions.FIND_ENROLLMENTS_BY_ADMISSIONS_ID)
    .map(action => action.payload)
    .switchMap((id) => this.profileService.findEnrollmentsByAdmissionsID(id))
    .map(message => this.studentProfileActions.findEnrollmentsByAdmissionsIDSuccess(message));
  /*==================================================================================================*/
  /*CONTACT - EFFECT*/
  /*==================================================================================================*/
  @Effect() addStudentContact$ = this.actions$
    .ofType(StudentProfileActions.ADD_STUDENT_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addStudentContact(payload.student, payload.contact))
    .map(message => this.studentProfileActions.addStudentContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() deleteStudentContact$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_STUDENT_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteStudentContact(payload.student, payload.contact))
    .map(message => this.studentProfileActions.deleteStudentContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() updateStudentContact$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT_CONTACT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudentContact(payload.student, payload.contact))
    .map(message => this.studentProfileActions.updateStudentContactSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  /*==================================================================================================*/
  /*GUARDIAN - EFFECT*/
  /*==================================================================================================*/
  @Effect() updateStudentGuardian$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudentGuardian(payload.student, payload.guardian))
    .map(message => this.studentProfileActions.updateStudentGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() addStudentGuardian$ = this.actions$
    .ofType(StudentProfileActions.ADD_STUDENT_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addStudentGuardian(payload.student, payload.guardian))
    .map(message => this.studentProfileActions.addStudentGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() deleteStudentGuardian$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_STUDENT_GUARDIAN)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteStudentGuardian(payload.student, payload.guardian))
    .map(message => this.studentProfileActions.deleteStudentGuardianSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  /*==================================================================================================*/
  /*GUARANTOR - EFFECT*/
  /*==================================================================================================*/
  @Effect() addStudentGuarantor$ = this.actions$
    .ofType(StudentProfileActions.ADD_STUDENT_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addStudentGuarantor(payload.student, payload.guarantor))
    .map(message => this.studentProfileActions.addStudentGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() updateStudentGuarantor$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudentGuarantor(payload.student, payload.guarantor))
    .map(message => this.studentProfileActions.updateStudentGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() deleteStudentGuarantor$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_STUDENT_GUARANTOR)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteStudentGuarantor(payload.student, payload.guarantor))
    .map(message => this.studentProfileActions.deleteStudentGuarantorSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  /*==================================================================================================*/
  /*ADDRESS - EFFECT*/
  /*==================================================================================================*/
  @Effect() addStudentAddress$ = this.actions$
    .ofType(StudentProfileActions.ADD_STUDENT_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.addStudentAddress(payload.student, payload.address))
    .map(message => this.studentProfileActions.addStudentAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() updateStudentAddress$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudentAddress(payload.student, payload.address))
    .map(message => this.studentProfileActions.updateStudentAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  @Effect() deleteStudentAddress$ = this.actions$
    .ofType(StudentProfileActions.REMOVE_STUDENT_ADDRESS)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.deleteStudentAddress(payload.student, payload.address))
    .map(message => this.studentProfileActions.deleteStudentAddressSuccess(message))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

  /*==================================================================================================*/
  /*STUDENT INFORMATION - EFFECT
  /*==================================================================================================*/
  @Effect() updateStudentDetail$ = this.actions$
    .ofType(StudentProfileActions.UPDATE_STUDENT_DETAIL)
    .map(action => action.payload)
    .switchMap(student => this.profileService.updateStudentDetail(student))
    .map(profile => this.studentProfileActions.updateStudentDetailSuccess(profile))
    .withLatestFrom(this.store$.select(...this.STUDENT))
    .map(state => state[1])
    .map(() => this.studentProfileActions.findStudentByUser());

}
