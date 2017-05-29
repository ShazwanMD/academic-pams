import {AddressEditorDialog} from './dialog/address-editor.dialog';
import {GuardianEditorDialog} from './dialog/guardian-editor.dialog';
import {GuarantorEditorDialog} from './dialog/guarantor-editor.dialog';
import {Enrollment} from './../term/enrollments/enrollment.interface';
import {Address} from './address.interface';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {ProfileService} from "../../services/profile.service";
import {ProfileActions} from "./profile.action";
import {Student} from "../identity/student.interface";
import {ProfileCenterPage} from "./profile-center.page";
import {ProfileStatusComponent} from "./component/profile-status.component";
import {ProfileListComponent} from "./component/profile-list.component";
import {ProfileComponent} from "./component/profile.component";
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
import {studentReducer, StudentState} from "./student.reducer";
import {studentListReducer, StudentListState} from "./student-list.reducer";
import {ContactEditorDialog} from "./dialog/contact-editor.dialog";
import {DetailEditorDialog} from "./dialog/detail-editor.dialog";
import {ContactTypeSelectComponent} from "./component/contact-type-select.component";
import {GuarantorTypeSelectComponent} from "./component/guarantor-type-select.component";
import {GuardianTypeSelectComponent} from "./component/guardian-type-select.component";
import {AddressTypeSelectComponent} from './component/address-type-select.component';
import {ProfileActionComponent} from "./component/profile-action.component";
import {StudyModeSwitcherDialog} from "./dialog/study-mode-switcher.dialog";
import {CommonModule} from "../common/index";
import {AcademicSessionSubModule} from "../planner/academic-sessions/index";
import {CohortTransfererDialog} from "./dialog/cohort-transferer.dialog";
import {ProfileCohortComponent} from "./component/profile-cohort.component";
import {ProfileEnrollmentListComponent} from "./component/profile-enrollment-list.component";

export interface ProfileModuleState {
  students: StudentListState;
  student: StudentState;
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
  students: studentListReducer,
  student: studentReducer,
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
    CommonModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    EffectsModule.run(ProfileEffects),
  ],
  declarations: [
    // page
    ProfileCenterPage,
    ProfileDetailPage,

    // component
    ProfileComponent,
    ProfileCohortComponent,
    ProfileActionComponent,
    ProfileListComponent,
    ProfileStatusComponent,
    ProfileEnrollmentListComponent,
    ContactTypeSelectComponent,
    GuarantorTypeSelectComponent,
    GuardianTypeSelectComponent,
    AddressTypeSelectComponent,

    //dialog
    DetailEditorDialog,
    ContactEditorDialog,
    GuarantorEditorDialog,
    GuardianEditorDialog,
    AddressEditorDialog,
    StudyModeSwitcherDialog,
    CohortTransfererDialog,
  ],
  exports: [
    ContactTypeSelectComponent,
    ContactTypeSelectComponent,
    GuarantorTypeSelectComponent,
    GuardianTypeSelectComponent,
    AddressTypeSelectComponent,
  ],
  entryComponents: [
    DetailEditorDialog,
    ContactEditorDialog,
    GuarantorEditorDialog,
    GuardianEditorDialog,
    AddressEditorDialog,
    StudyModeSwitcherDialog,
    CohortTransfererDialog,
  ],
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

