import { StudentProfileEnrollmentsComponent } from './component/student-profile-enrollments.component';
import { StudentDetailEditorDialog } from './dialog/student-detail-editor.dialog';
import { StudentAddressEditorDialog } from './dialog/student-address-editor.dialog';
import { StudentGuarantorEditorDialog } from './dialog/student-guarantor-editor.dialog';
import { StudentGuardianEditorDialog } from './dialog/student-guardian-editor.dialog';
import { StudentContactEditorDialog } from './dialog/student-contact-editor.dialog';
import { StudentProfilePage } from './component/student-profile.component';
import { StudentProfileListPage } from './component/student-profile-list.component';
import { ProfileModule } from './../profile/index';
import { Enrollment } from './../../shared/model/term/enrollment.interface';
import { Contact } from './../../shared/model/profile/contact.interface';
import { Guardian } from './../../shared/model/profile/guardian.interface';
import { Guarantor } from './../../shared/model/profile/guarantor.interface';
import { Address } from './../../shared/model/profile/address.interface';
import { Student } from './../../shared/model/identity/student.interface';
import { StudentProfileActions } from './student-profile.action';
import { StudentProfileEffects } from './student-profile.effect';
import { ProfileService } from './../../../services/profile.service';
import { CommonService } from './../../../services/common.service';
import { IdentityService } from './../../../services/identity.service';
import { CohortSubModule } from './../planner/cohorts/index';
import { EffectsModule } from '@ngrx/effects';
import { AcademicSessionSubModule } from './../planner/academic-sessions/index';
import { CommonModule } from './../../common/index';
import { CovalentCoreModule } from '@covalent/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { appRoutes, appRoutingProviders } from './../../app.routes';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { AddressListState, addressListReducer } from "../profile/address-list.reducer";
import { GuarantorListState, guarantorListReducer } from "../profile/guarantor-list.reducer";
import { GuardianListState, guardianListReducer } from "../profile/guardian-list.reducer";
import { ContactListState, contactListReducer } from "../profile/contact-list.reducer";
import { EnrollmentListState, enrollmentListReducer } from "../profile/enrollment-list.reducer";
import { StudentProfileCenterPage } from "./student-profile-center.page";
import { StudentListState, studentListReducer } from "./student-list.reducer";
import { StudentState, studentReducer } from "./student.reducer";
import { StudentMenu } from "./component/student-menu.component";
import { Admission } from "../../shared/model/term/admission.interface";
import { admissionListReducer, AdmissionListState } from "../term/admissions/admission-list.reducer";


export interface StudentProfileModuleState {
    students: StudentListState;
    student: StudentState;
    addresses: AddressListState;
    guarantors: GuarantorListState;
    guardians: GuardianListState;
    contacts: ContactListState;
    enrollments: EnrollmentListState;
    admissions: AdmissionListState;


};

export const INITIAL_STUDENT_PROFILE_STATE: StudentProfileModuleState =
    <StudentProfileModuleState>{
        students: <Student[]>[],
        student: <Student>{},
        addresses: <Address[]>[],
        guarantors: <Guarantor[]>[],
        guardians: <Guardian[]>[],
        contacts: <Contact[]>[],
        enrollments: <Enrollment[]>[],
        admissions: <Admission[]>[],

    };


export const studentProfileModuleReducers = {
    students: studentListReducer,
    student: studentReducer,
    addresses: addressListReducer,
    guarantors: guarantorListReducer,
    guardians: guardianListReducer,
    contacts: contactListReducer,
    enrollments: enrollmentListReducer,
    admissions: admissionListReducer,

};

@NgModule({
    imports: [
        appRoutes,
        BrowserModule,
        ReactiveFormsModule,
        CovalentCoreModule.forRoot(),
        CommonModule.forRoot(),
        AcademicSessionSubModule.forRoot(),
        EffectsModule.run(StudentProfileEffects),
        CohortSubModule.forRoot(),
        ProfileModule.forRoot(),

    ],
    declarations: [
        //Page
        StudentProfileCenterPage,

        //Component
        StudentProfilePage,
        StudentProfileListPage,
        StudentMenu,
        StudentProfileEnrollmentsComponent,

        //Dialog
        StudentContactEditorDialog,
        StudentGuardianEditorDialog,
        StudentGuarantorEditorDialog,
        StudentAddressEditorDialog,
        StudentDetailEditorDialog,

    ],

    exports: [
        StudentContactEditorDialog,
        StudentGuardianEditorDialog,
        StudentGuarantorEditorDialog,
        StudentAddressEditorDialog,
        StudentDetailEditorDialog,

    ],

    entryComponents: [

        StudentContactEditorDialog,
        StudentGuardianEditorDialog,
        StudentGuarantorEditorDialog,
        StudentAddressEditorDialog,
        StudentDetailEditorDialog,

    ],

})

export class StudentProfileModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: StudentProfileModule,
            providers: [
                appRoutingProviders,
                IdentityService,
                CommonService,
                ProfileService,
                StudentProfileActions,
            ],
        };
    }

}