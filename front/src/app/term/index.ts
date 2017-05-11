import {Appointment} from './appointments/appointment.interface';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";
import {TermPage} from "./term.page";
import {OfferingSubModule} from "./offerings/index";
import {EnrollmentSubModule} from "./enrollments/index";
import {offeringReducer, OfferingState} from "./offerings/offering.reducer";
import {enrollmentReducer, EnrollmentState} from "./enrollments/enrollment.reducer";
import {offeringListReducer, OfferingListState} from "./offerings/offering-list.reducer";
import {enrollmentListReducer, EnrollmentListState} from "./enrollments/enrollment-list.reducer";
import {Offering} from "./offerings/offering.interface";
import {Enrollment} from "./enrollments/enrollment.interface";
import {AdmissionActions} from "./admissions/admission.action";
import {AdmissionSubModule} from "./admissions/index";
import {Admission} from "./admissions/admission.interface";
import {admissionListReducer, AdmissionListState} from "./admissions/admission-list.reducer";
import {admissionReducer, AdmissionState} from "./admissions/admission.reducer";
import {appointmentListReducer, AppointmentListState} from "./appointments/appointment-list.reducer";
import {appointmentReducer, AppointmentState} from "./appointments/appointment.reducer";
import {AppointmentSubModule} from "./appointments/index";
import {AppointmentActions} from "./appointments/appointment.action";
import {EnrollmentActions} from "./enrollments/enrollment.action";
import {EnrollmentApplicationTask} from "./enrollment-applications/enrollment-application-task.interface";
import {EnrollmentApplicationSubModule} from "./enrollment-applications/index";
import {
  enrollmentApplicationTaskReducer,
  EnrollmentApplicationTaskState
} from "./enrollment-applications/enrollment-application-task.reducer";
import {
  assignedEnrollmentApplicationTaskListReducer,
  EnrollmentApplicationTaskListState, pooledEnrollmentApplicationTaskListReducer
} from "./enrollment-applications/enrollment-application-task-list.reducer";

export interface TermModuleState {
  offerings: OfferingListState;
  offering: OfferingState;
  enrollments: EnrollmentListState;
  enrollment: EnrollmentState;
  admissions: AdmissionListState;
  admission: AdmissionState;
  appointments: AppointmentListState;
  appointment: AppointmentState;
  // admissionApplicationTasks:AdmissionApplicationListState,
  // admissionApplicationTask:AdmissionApplicationState,
  assignedEnrollmentApplicationTasks: EnrollmentApplicationTaskListState,
  pooledEnrollmentApplicationTasks: EnrollmentApplicationTaskListState,
  enrollmentApplicationTask: EnrollmentApplicationTaskState,
}
;

export const INITIAL_TERM_STATE: TermModuleState =
  <TermModuleState>{
    offerings: <Offering[]>[],
    offering: <Offering>{},
    enrollments: <Enrollment[]>[],
    enrollment: <Enrollment>{},
    admissions: <Admission[]>[],
    admission: <Admission>{},
    appointments: <Appointment[]>[],
    appointment: <Appointment>{},
    assignedEnrollmentApplicationTasks: <EnrollmentApplicationTask[]>[],
    pooledEnrollmentApplicationTasks: <EnrollmentApplicationTask[]>[],
    enrollmentApplicationTask:<EnrollmentApplicationTask>{},
  };

export const termModuleReducers = {
  offerings: offeringListReducer,
  offering: offeringReducer,
  enrollments: enrollmentListReducer,
  enrollment: enrollmentReducer,
  admissions: admissionListReducer,
  admission: admissionReducer,
  appointments: appointmentListReducer,
  appointment: appointmentReducer,
  // assignedAdmissionApplicationTasks:admissionApplicationTaskListReducer,
  // pooledAdmissionApplicationTasks:admissionApplicationTaskListReducer,
  // admissionApplicationTask:admissionApplicationTaskReducer,
  assignedEnrollmentApplicationTasks: assignedEnrollmentApplicationTaskListReducer,
  pooledEnrollmentApplicationTasks: pooledEnrollmentApplicationTaskListReducer,
  enrollmentApplicationTask: enrollmentApplicationTaskReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    OfferingSubModule.forRoot(),
    // todo: AdmissionApplicationSubModule.forRoot(),
    EnrollmentApplicationSubModule.forRoot(),
    EnrollmentSubModule.forRoot(),
    AdmissionSubModule.forRoot(),
    AppointmentSubModule.forRoot(),
  ],
  declarations: [
    // page
    TermPage,
  ],
  exports: [],
  entryComponents: []
})
export class TermModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: TermModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        TermService,
        AdmissionActions,
        AppointmentActions,
        EnrollmentActions,

      ],
    };
  }
}

