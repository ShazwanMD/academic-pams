import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {environment} from '../../environments/environment';
import {combineReducers, StoreModule} from "@ngrx/store";
import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {compose} from "@ngrx/core/compose";
import {ProfileListState, profileListReducer} from "./profile-list.reducer";
import {profileReducer, ProfileState} from "./profile.reducer";
import {ProfileCenterPage} from "./profile-center.page";
import {ProfileDetailPage} from "./profile-detail.page";
import {ProfileService} from "../../services/profile.service";
import {ProfileComponent} from "./components/profile.component";
import {ProfileListComponent} from "./components/profile-list.component";
import {ProfileStatusComponent} from "./components/profile-status.component";
import {ProfileActions} from "./profile.action";
import {ProfileEffects} from "./profile.effect";
import {EffectsModule} from "@ngrx/effects";
import {Student} from "../identity/student.interface";

export interface ProfileModuleState {
  students: ProfileListState;
  student: ProfileState;
}
;

export const INITIAL_PROFILE_STATE: ProfileModuleState =
  <ProfileModuleState>{
    students: <Student[]>[],
    student: <Student>{},
  };

export const profileModuleReducers = {
  students: profileListReducer,
  student: profileReducer,
};


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(ProfileEffects),
  ],
  declarations: [
    // page
    ProfileCenterPage,
    ProfileDetailPage,

    // component
    ProfileComponent,
    ProfileListComponent,
    ProfileStatusComponent
  ],
  exports: [],
})
export class ProfileModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ProfileModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        ProfileService,
        ProfileActions
      ],
    };
  }
}

