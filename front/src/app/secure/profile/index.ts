import { BankCodeListState } from './../setup/bank-codes/bank-code-list.reducer';
import { BankCode } from './../../shared/model/common/bank-code.interface';
import { MinAmountDialog } from './dialog/minAmount.dialog';
import { StudentStatusDialog } from './dialog/student-status.dialog';
import { StudentStatusSelectComponent } from './component/student-status-select.component';
import { CohortSubModule } from '../planner/cohorts/index';
import { AddressEditorDialog } from './dialog/address-editor.dialog';
import { AdvisoryEditorDialog } from './dialog/advisory-editor.dialog';
import { GuardianEditorDialog } from './dialog/guardian-editor.dialog';
import { GuarantorEditorDialog } from './dialog/guarantor-editor.dialog';
import { Enrollment } from '../../shared/model/term/enrollment.interface';
import { Address } from '../../shared/model/profile/address.interface';
import { ModuleWithProviders, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { appRoutes, appRoutingProviders } from '../../app.routes';
import { CovalentCoreModule } from '@covalent/core';
import { CommonService, IdentityService } from '../../../services';
import { ProfileService } from '../../../services/profile.service';
import { ProfileActions } from './profile.action';
import { Student } from '../../shared/model/identity/student.interface';
import { ProfileCenterPage } from './profile-center.page';
import { ProfileStatusComponent } from './component/profile-status.component';
import { ProfileListComponent } from './component/profile-list.component';
import { ProfileComponent } from './component/profile.component';

import { ProfileDetailPage } from './profile-detail.page';
import { EffectsModule } from '@ngrx/effects';
import { ProfileEffects } from './profile.effect';
import { Guarantor } from '../../shared/model/profile/guarantor.interface';
import { Guardian } from '../../shared/model/profile/guardian.interface';
import { Contact } from '../../shared/model/profile/contact.interface';
import { addressListReducer, AddressListState } from './address-list.reducer';
import { contactListReducer, ContactListState } from './contact-list.reducer';
import { guardianListReducer, GuardianListState } from './guardian-list.reducer';
import { guarantorListReducer, GuarantorListState } from './guarantor-list.reducer';
//import {enrollmentListReducer, EnrollmentListState} from './enrollment-list.reducer';
import { admissionListReducer, AdmissionListState } from './admission-list.reducer';
import { academicSessionListReducer, AcademicSessionListState } from './academic-session-list.reducer';
import { admissionApplicationListReducer, AdmissionApplicationListState } from './admissionApplication-list.reducer';
import { graduationApplicationListReducer, GraduationApplicationListState } from './graduationApplication-list.reducer';
import { graduationListReducer, GraduationListState } from './graduation-list.reducer';
import { studentReducer, StudentState } from './student.reducer';
import { studentListReducer, StudentListState } from './student-list.reducer';
import { ContactEditorDialog } from './dialog/contact-editor.dialog';
import { DetailEditorDialog } from './dialog/detail-editor.dialog';
import { ContactTypeSelectComponent } from './component/contact-type-select.component';
import { GuarantorTypeSelectComponent } from './component/guarantor-type-select.component';
import { GuardianTypeSelectComponent } from './component/guardian-type-select.component';
import { AddressTypeSelectComponent } from './component/address-type-select.component';
import { ProfileActionComponent } from './component/profile-action.component';
import { StudyModeSwitcherDialog } from './dialog/study-mode-switcher.dialog';
import { CommonModule } from '../../common/index';
import { AcademicSessionSubModule } from '../planner/academic-sessions/index';
import { CohortTransfererDialog } from './dialog/cohort-transferer.dialog';
import { ProfileCohortComponent } from './component/profile-cohort.component';
import { ProfileEnrollmentListComponent } from './component/profile-enrollment-list.component';
import { ProfileAdmissionListComponent } from './component/profile-admission-list.component';
import { Admission } from "../../shared/model/term/admission.interface";
import { AcademicSession } from "../../shared/model/planner/academic-session.interface";
import { AdmissionApplication } from "../../shared/model/term/admission-application.interface";
import { GraduationApplication } from "../../shared/model/graduation/graduation-application.interface";
import { Graduation } from "../../shared/model/graduation/graduation.interface";
import { AdvisoryCenterPage } from "./advisory-center.page";
import { AdvisoryListComponent } from './component/advisory-list.component';
import { AdvisoryDetailPage } from './advisory-detail.page';
import { AdvisoryComponent } from './component/advisory.component';
import { IdentityModule } from "../identity/index";
import { bankCodeListReducer } from '../setup/bank-codes/bank-code-list.reducer';

export interface ProfileModuleState {
  students: StudentListState;
  student: StudentState;
  addresses: AddressListState;
  guarantors: GuarantorListState;
  guardians: GuardianListState;
  contacts: ContactListState;
  //enrollments: EnrollmentListState;
  admissions: AdmissionListState;
  academicSessions: AcademicSessionListState;
  admissionApplications: AdmissionApplicationListState;
  graduationApplications: GraduationApplicationListState;
  graduations: GraduationListState;
  bankCodes: BankCodeListState;
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
    //enrollments: <Enrollment[]>[],
    admissions: <Admission[]>[],
    academicSessions: <AcademicSession[]>[],
    admissionApplications: <AdmissionApplication[]>[],
    graduationApplications: <GraduationApplication[]>[],
    graduations: <Graduation[]>[],
    bankCodes:<BankCode[]>[],
  };

export const profileModuleReducers = {
  students: studentListReducer,
  student: studentReducer,
  addresses: addressListReducer,
  guarantors: guarantorListReducer,
  guardians: guardianListReducer,
  contacts: contactListReducer,
  //enrollments: enrollmentListReducer,
  admissions: admissionListReducer,
  academicSessions: academicSessionListReducer,
  admissionApplications: admissionApplicationListReducer,
  graduationApplications: graduationApplicationListReducer,
  graduations: graduationListReducer,
  bankCodes: bankCodeListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    IdentityModule.forRoot(),
    EffectsModule.run(ProfileEffects),
    CohortSubModule.forRoot(),
  ],
  declarations: [
    // page
    ProfileCenterPage,
    AdvisoryCenterPage,
    ProfileDetailPage,
    AdvisoryDetailPage,

    // component
    ProfileComponent,
    AdvisoryComponent,
    ProfileCohortComponent,
    ProfileActionComponent,
    ProfileListComponent,
    AdvisoryListComponent,
    ProfileStatusComponent,
    ProfileEnrollmentListComponent,
    ProfileAdmissionListComponent,
    ContactTypeSelectComponent,
    GuarantorTypeSelectComponent,
    GuardianTypeSelectComponent,
    AddressTypeSelectComponent,
    StudentStatusSelectComponent,

    //dialog
    DetailEditorDialog,
    ContactEditorDialog,
    GuarantorEditorDialog,
    GuardianEditorDialog,
    AddressEditorDialog,
    AdvisoryEditorDialog,
    StudyModeSwitcherDialog,
    CohortTransfererDialog,
    StudentStatusDialog,
    MinAmountDialog,
  ],
  exports: [
    ContactTypeSelectComponent,
    ContactTypeSelectComponent,
    GuarantorTypeSelectComponent,
    GuardianTypeSelectComponent,
    AddressTypeSelectComponent,
    StudentStatusSelectComponent,
  ],
  entryComponents: [
    DetailEditorDialog,
    ContactEditorDialog,
    GuarantorEditorDialog,
    GuardianEditorDialog,
    AddressEditorDialog,
    AdvisoryEditorDialog,
    StudyModeSwitcherDialog,
    CohortTransfererDialog,
    StudentStatusDialog,
    MinAmountDialog,
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
        ProfileActions,
      ],
    };
  }
}

