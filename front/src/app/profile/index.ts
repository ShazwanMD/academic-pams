import { Address } from './address.interface';
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
import {addressListReducer, AddressListState} from "./address-list.reducer";
import {Guarantor} from "./guarantor.interface";
import {Guardian} from "./guardian.interface";
import {Contact} from "./contact.interface";
import {contactListReducer, ContactListState} from "./contact-list.reducer";
import {guardianListReducer, GuardianListState} from "./guardian-list.reducer";
import {guarantorListReducer, GuarantorListState} from "./guarantor-list.reducer";

export interface ProfileModuleState {
  students: ProfileListState;
  student: ProfileState;
  studentIdentityNo: ProfileDetailState;
  addresses: AddressListState;
  guarantors: GuarantorListState;
  guardians: GuardianListState;
  contacts: ContactListState;
}
;

export const INITIAL_PROFILE_STATE: ProfileModuleState =
  <ProfileModuleState>{
    students: <Student[]>[],
    student: <Student>{},
    studentIdentityNo: <Student[]>[],
    addresses: <Address[]>[],
    guarantors: <Guarantor[]>[],
    guardians: <Guardian[]>[],
    contacts: <Contact[]>[],
  };

export const profileModuleReducers = {
  students: profileListReducer,
  student: profileReducer,
  studentIdentityNo: profileDetailReducer,
  addresses: addressListReducer,
  guarantors: guarantorListReducer,
  guardians: guardianListReducer,
  contacts: contactListReducer,
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

