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



}
