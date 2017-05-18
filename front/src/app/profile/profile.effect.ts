import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { ProfileService } from "../../services/profile.service";
import { ProfileActions } from "./profile.action";
import { from } from "rxjs/observable/from";


@Injectable()
export class ProfileEffects {
  constructor(private actions$: Actions,
    private profileActions: ProfileActions,
    private profileService: ProfileService) {
  }

  @Effect() findProfiles$ = this.actions$
    .ofType(ProfileActions.FIND_PROFILES)
    .switchMap(() => this.profileService.findStudents())
    .map(profiles => this.profileActions.findProfilesSuccess(profiles));

  @Effect() findProfile$ = this.actions$
    .ofType(ProfileActions.FIND_PROFILE)
    .map(action => action.payload)
    .switchMap(identityNo => this.profileService.findStudentByMatricNo(identityNo))
    .map(student => this.profileActions.getProfileSuccess(student))
    .mergeMap(action => from([action,
      this.profileActions.findAddresses(action.payload),
      this.profileActions.findContacts(action.payload),
      this.profileActions.findGuarantors(action.payload),
      this.profileActions.findGuardians(action.payload),
      this.profileActions.findEnrollments(action.payload),
    ]));


  @Effect() updateProfile$ = this.actions$
    .ofType(ProfileActions.UPDATE_PROFILE)
    .map(action => action.payload)
    .switchMap(student => this.profileService.updateStudent(student))
    .map(profile => this.profileActions.updateProfileSuccess(profile));

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

  @Effect() updateStudents$ = this.actions$
    .ofType(ProfileActions.UPDATE_STUDENT)
    .map(action => action.payload)
    .switchMap(payload => this.profileService.updateStudent(payload))
    .map(message => this.profileActions.updateStudentSuccess(message))
    .mergeMap(identityNo => from([identityNo, this.profileActions.findStudentByMatricNo(identityNo)]));

}
