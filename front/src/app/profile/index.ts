import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {ProfileListState, profileListReducer} from "./profile-list.reducer";
import {profileReducer, ProfileState} from "./profile.reducer";
import {ProfileService} from "../../services/profile.service";
import {ProfileActions} from "./profile.action";
import {Student} from "../identity/student.interface";
import {ProfileCenterPage} from "./profile-center.page";
import {ProfileStatusComponent} from "./components/profile-status.component";
import {ProfileListComponent} from "./components/profile-list.component";
import {ProfileComponent} from "./components/profile.component";
import {ProfileDetailPage} from "./profile-detail.page";
import {EffectsModule} from "@ngrx/effects";
import {ProfileEffects} from "./profile.effect";
import {ProfileDetailState, profileDetailReducer} from "./profile-detail.reducer";

export interface ProfileModuleState {
  students: ProfileListState;
  student: ProfileState;
  studentIdentityNo: ProfileDetailState;
}
;

export const INITIAL_PROFILE_STATE: ProfileModuleState =
  <ProfileModuleState>{
    students: <Student[]>[],
    student: <Student>{},
    studentIdentityNo: <Student[]>[],
  };

export const profileModuleReducers = {
  students: profileListReducer,
  student: profileReducer,
  studentIdentityNo: profileDetailReducer,
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

