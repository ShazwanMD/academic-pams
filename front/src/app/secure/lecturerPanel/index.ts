import { LecturerProfileComponent } from './component/lecturer-profile.component';
import { ProfileModule } from './../profile/index';
import { CohortSubModule } from './../planner/cohorts/index';
import { EffectsModule } from '@ngrx/effects';
import { AcademicSessionSubModule } from './../planner/academic-sessions/index';
import { CommonModule } from './../../common/index';
import { CovalentCoreModule } from '@covalent/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { LecturerActions } from './lecturer.action';
import { LecturerPanelService } from './../../../services/lecturerPanel.service';
import { CommonService } from './../../../services/common.service';
import { IdentityService } from './../../../services/identity.service';
import { appRoutingProviders, appRoutes } from './../../app.routes';
import { LecturerProfileCenterPage } from './lecturer-profile-center.page';
import { LecturerEffects } from './lecturer.effect';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { Staff } from './../../shared/model/identity/staff.interface';
import { LecturerState, lecturerReducer } from "./lecturer.reducer";
import { LecturerListState, lecturerListReducer } from "./lecturer-list.reducer";
import { Appointment } from "../../shared/model/term/appointment.interface";
import { AdmissionApplication } from "../../shared/model/term/admission-application.interface";
import { Admission } from "../../shared/model/term/admission.interface";
import { appointmentListReducer, AppointmentListState } from "./appointment-list.reducer";
import { admissionApplicationListReducer, AdmissionApplicationListState } from "./admissionApplication-list.reducer";
import { admissionListReducer, AdmissionListState } from "./admission-list.reducer";

export interface LecturerModuleState {

    lecturer: LecturerState;
    lecturers: LecturerListState;
    appointments: AppointmentListState;
    admissionApplications: AdmissionApplicationListState;
admissions: AdmissionListState;
};

export const INITIAL_LECTURER_PROFILE_STATE: LecturerModuleState =
    <LecturerModuleState>{

        lecturers: <Staff[]>[],
        lecturer: <Staff>{},
        appointments: <Appointment[]>[],
        admissionApplications: <AdmissionApplication[]>[],
        admissions: <Admission[]>[],
    };

export const lecturerModuleReducers = {

    lecturer: lecturerReducer,
    lecturers: lecturerListReducer,
    appointments: appointmentListReducer,
    admissionApplications: admissionApplicationListReducer,
    admissions: admissionListReducer,
};

@NgModule( {
    imports: [
        appRoutes,
        BrowserModule,
        ReactiveFormsModule,
        CovalentCoreModule.forRoot(),
        CommonModule.forRoot(),
        AcademicSessionSubModule.forRoot(),
        EffectsModule.run( LecturerEffects ),
        CohortSubModule.forRoot(),
        ProfileModule.forRoot(),
    ],
    declarations: [
        //Page
        LecturerProfileCenterPage,

        //Component
        LecturerProfileComponent,

        //Dialog

    ],

    exports: [

    ],
    entryComponents: [

    ]
} )

export class LecturerModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: LecturerModule,
            providers: [
                appRoutingProviders,
                IdentityService,
                CommonService,
                LecturerPanelService,
                LecturerActions,
            ]
        }
    }

}

