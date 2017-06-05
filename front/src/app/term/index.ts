import {AdmissionApplication} from './admissions/admission-application.interface';
import {AssessmentSubModule} from './assessments/index';
import {AssessmentActions} from './assessments/assessment.action';
import {Assessment} from "./assessments/assessment.interface";
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
import {OfferingActions} from "./offerings/offering.action";
import {EnrollmentSubModule} from "./enrollments/index";
import {offeringReducer, OfferingState} from "./offerings/offering.reducer";
import {enrollmentReducer, EnrollmentState} from "./enrollments/enrollment.reducer";
import {offeringListReducer, OfferingListState} from "./offerings/offering-list.reducer";
import {Offering} from "./offerings/offering.interface";
import {Enrollment} from "./enrollments/enrollment.interface";
import {AdmissionActions} from "./admissions/admission.action";
import {AdmissionSubModule} from "./admissions/index";
import {Admission} from "./admissions/admission.interface";
import {admissionListReducer, AdmissionListState} from "./admissions/admission-list.reducer";
import {admissionReducer, AdmissionState} from "./admissions/admission.reducer";
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
import {sectionReducer, SectionState} from "./sections/section.reducer";
import {
  admissionApplicationListReducer,
  AdmissionApplicationListState
} from "./admission-applications/admission-applications-list.reducer";
import {
  admissionApplicationReducer,
  AdmissionApplicationState
} from "./admission-applications/admission-application.reducer";
import {Section} from "./sections/section.interface";
import {SectionActions} from "./sections/section.action";
import {SectionSubModule} from "./sections/index";
import {AdmissionApplicationSubModule} from "./admission-applications/index";
import {assessmentReducer, AssessmentState} from "./assessments/assessment.reducer";
import {gradebookMatrixListReducer, GradebookMatrixListState} from "./offerings/gradebook-matrix-list.reducer";
import {GradebookMatrix} from "./offerings/gradebook-matrix.interface";
import {appointmentListReducer, AppointmentListState} from "./sections/appointment-list.reducer";
import {enrollmentListReducer, EnrollmentListState} from "./sections/enrollment-list.reducer";
import {sectionListReducer, SectionListState} from "./sections/section-list.reducer";
import {EnrollmentApplicationItem} from "./enrollment-applications/enrollment-application-item.interface";
import {
  enrollmentApplicationItemListReducer,
  EnrollmentApplicationItemListState
} from "./enrollment-applications/enrollment-application-item-list.reducer";
import {offeringAssessmentListReducer, OfferingAssessmentListState} from "./offerings/offering-assessment-list.reducer";
import {offeringSectionListReducer, OfferingSectionListState} from "./offerings/offering-section-list.reducer";
export interface TermModuleState {
  admissions: AdmissionListState;
  admission: AdmissionState;
  offerings: OfferingListState;
  offering: OfferingState;
  offeringAssessments: OfferingAssessmentListState;
  offeringSections: OfferingSectionListState;
  section: SectionState;
  sections: SectionListState;
  assessment: AssessmentState;
  enrollments: EnrollmentListState;
  enrollment: EnrollmentState;
  appointments: AppointmentListState;
  appointment: AppointmentState;
  admissionApplications: AdmissionApplicationListState,
  assignedEnrollmentApplicationTasks: EnrollmentApplicationTaskListState,
  pooledEnrollmentApplicationTasks: EnrollmentApplicationTaskListState,
  enrollmentApplicationTask: EnrollmentApplicationTaskState,
  enrollmentApplicationItems: EnrollmentApplicationItemListState,
  gradebookMatrices: GradebookMatrixListState,
}
;

export const INITIAL_TERM_STATE: TermModuleState =
  <TermModuleState>{
    admissions: <Admission[]>[],
    admission: <Admission>{},
    offerings: <Offering[]>[],
    offering: <Offering>{},
    offeringSections: <Section[]>[],
    offeringAssessments: <Assessment[]>[],
    sections: <Section[]>[],
    section: <Section>{},
    assessment: <Assessment[]>[],
    enrollments: <Enrollment[]>[],
    enrollment: <Enrollment>{},
    appointments: <Appointment[]>[],
    appointment: <Appointment>{},
    admissionApplications: <AdmissionApplication[]>[],
    admissionApplication: <AdmissionApplication>{},
    assignedEnrollmentApplicationTasks: <EnrollmentApplicationTask[]>[],
    pooledEnrollmentApplicationTasks: <EnrollmentApplicationTask[]>[],
    enrollmentApplicationTask: <EnrollmentApplicationTask>{},
    enrollmentApplicationItems: <EnrollmentApplicationItem[]>[],
    gradebookMatrices: <GradebookMatrix[]>[],
  };

export const termModuleReducers = {
  offerings: offeringListReducer,
  offering: offeringReducer,
  offeringAssessments: offeringAssessmentListReducer,
  offeringSections: offeringSectionListReducer,
  sections: sectionListReducer,
  section: sectionReducer,
  assessment: assessmentReducer,
  enrollments: enrollmentListReducer,
  enrollment: enrollmentReducer,
  admissions: admissionListReducer,
  admission: admissionReducer,
  appointments: appointmentListReducer,
  appointment: appointmentReducer,
  admissionApplications: admissionApplicationListReducer,
  admissionApplication: admissionApplicationReducer,
  assignedEnrollmentApplicationTasks: assignedEnrollmentApplicationTaskListReducer,
  pooledEnrollmentApplicationTasks: pooledEnrollmentApplicationTaskListReducer,
  enrollmentApplicationTask: enrollmentApplicationTaskReducer,
  enrollmentApplicationItems: enrollmentApplicationItemListReducer,
  gradebookMatrices: gradebookMatrixListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    OfferingSubModule.forRoot(),
    AdmissionApplicationSubModule.forRoot(),
    EnrollmentApplicationSubModule.forRoot(),
    EnrollmentSubModule.forRoot(),
    AdmissionSubModule.forRoot(),
    AppointmentSubModule.forRoot(),
    SectionSubModule.forRoot(),
    AssessmentSubModule.forRoot(),

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
        SectionActions,
        OfferingActions,
        AssessmentActions,

      ],
    };
  }
}

