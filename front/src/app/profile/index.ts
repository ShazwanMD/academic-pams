import { from } from 'rxjs/observable/from';
import { Enrollment } from './../term/enrollments/enrollment.interface';
import { ProfileEnrollmentListComponent } from './components/profile-enrollment-list.component';
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
import {Guarantor} from "./guarantor.interface";
import {Guardian} from "./guardian.interface";
import {Contact} from "./contact.interface";
import {addressListReducer, AddressListState} from "./address-list.reducer";
import {contactListReducer, ContactListState} from "./contact-list.reducer";
import {guardianListReducer, GuardianListState} from "./guardian-list.reducer";
import {guarantorListReducer, GuarantorListState} from "./guarantor-list.reducer";
import {enrollmentListReducer, EnrollmentListState} from "./enrollment-list.reducer";


export interface ProfileModuleState {
  students: ProfileListState;
  student: ProfileState;
  addresses: AddressListState;
  guarantors: GuarantorListState;
  guardians: GuardianListState;
  contacts: ContactListState;
  enrollments: EnrollmentListState;

}
;

export const INITIAL_PROFILE_STATE: ProfileModuleState =
  <ProfileModuleState>{
    students: <Student[]>[],
    student: <Student>{},
    addresses: <Address[]>[],
    guarantors: <Guarantor[]>[],
    guardians: <Guardian[]>[],
    contacts: <Contact[]>[],
    enrollments: <Enrollment[]>[],
  };

export const profileModuleReducers = {
  students: profileListReducer,
  student: profileReducer,
  addresses: addressListReducer,
  guarantors: guarantorListReducer,
  guardians: guardianListReducer,
  contacts: contactListReducer,
  enrollments: enrollmentListReducer,
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
    ProfileStatusComponent,
    ProfileEnrollmentListComponent,
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

