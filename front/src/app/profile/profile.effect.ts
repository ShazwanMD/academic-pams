import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ProfileService} from "../../services/profile.service";
import {ProfileActions} from "./profile.action";


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
    .map(profile => this.profileActions.getProfileSuccess(profile));

  @Effect() updateProfile$ = this.actions$
    .ofType(ProfileActions.UPDATE_PROFILE)
    .map(action => action.payload)
    .switchMap(student => this.profileService.updateStudent(student))
    .map(profile => this.profileActions.updateProfileSuccess(profile));

}
