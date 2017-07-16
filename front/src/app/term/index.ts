import {AdmissionApplicationTask} from './admission-applications/admission-application-task.interface';
import {SectionAppointmentListState, sectionAppointmentListReducer} from './sections/section-appointment-list.reducer';

import {AdmissionApplication} from './admissions/admission-application.interface';
import {AssessmentSubModule} from './assessments/index';
import {AssessmentActions} from './assessments/assessment.action';
import {Assessment} from './assessments/assessment.interface';
import {Appointment} from './appointments/appointment.interface';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {TermService} from '../../services/term.service';
import {TermPage} from './term.page';
import {OfferingSubModule} from './offerings/index';
import {OfferingActions} from './offerings/offering.action';
import {EnrollmentSubModule} from './enrollments/index';
import {offeringReducer, OfferingState} from './offerings/offering.reducer';
import {enrollmentReducer, EnrollmentState} from './enrollments/enrollment.reducer';
import {offeringListReducer, OfferingListState} from './offerings/offering-list.reducer';
import {Offering} from './offerings/offering.interface';
import {EnrollmentApplication} from './enrollment-applications/enrollment-application.interface';
import {Enrollment} from './enrollments/enrollment.interface';
import {AdmissionActions} from './admissions/admission.action';
import {AdmissionSubModule} from './admissions/index';
import {Admission} from './admissions/admission.interface';
import {admissionListReducer, AdmissionListState} from './admissions/admission-list.reducer';
import {admissionReducer, AdmissionState} from './admissions/admission.reducer';
import {appointmentReducer, AppointmentState} from './appointments/appointment.reducer';
import {AppointmentSubModule} from './appointments/index';
import {AppointmentActions} from './appointments/appointment.action';
import {EnrollmentActions} from './enrollments/enrollment.action';
import {EnrollmentApplicationTask} from './enrollment-applications/enrollment-application-task.interface';
import {EnrollmentApplicationSubModule} from './enrollment-applications/index';
import {
  enrollmentApplicationTaskReducer,
  EnrollmentApplicationTaskState,
} from './enrollment-applications/enrollment-application-task.reducer';
import {
  assignedEnrollmentApplicationTaskListReducer,
  EnrollmentApplicationTaskListState, pooledEnrollmentApplicationTaskListReducer,
} from './enrollment-applications/enrollment-application-task-list.reducer';
import {sectionReducer, SectionState} from './sections/section.reducer';
import {
  admissionApplicationReducer,
  AdmissionApplicationState,
} from './admission-applications/admission-application.reducer';
import {
    enrollmentApplicationReducer,
    EnrollmentApplicationState,
  } from './enrollment-applications/enrollment-application.reducer';
import {Section} from './sections/section.interface';
import {SectionActions} from './sections/section.action';
import {SectionSubModule} from './sections/index';
import {AdmissionApplicationSubModule} from './admission-applications/index';
import {assessmentReducer, AssessmentState} from './assessments/assessment.reducer';
import {gradebookMatrixListReducer, GradebookMatrixListState} from './offerings/gradebook-matrix-list.reducer';
import {GradebookMatrix} from './offerings/gradebook-matrix.interface';
import {appointmentListReducer, AppointmentListState} from './sections/appointment-list.reducer';
import {enrollmentListReducer, EnrollmentListState} from './sections/enrollment-list.reducer';
import {sectionListReducer, SectionListState} from './sections/section-list.reducer';
import {EnrollmentApplicationItem} from './enrollment-applications/enrollment-application-item.interface';
import {
  enrollmentApplicationItemListReducer,
  EnrollmentApplicationItemListState,
} from './enrollment-applications/enrollment-application-item-list.reducer';

import {offeringSectionListReducer, OfferingSectionListState} from './offerings/offering-section-list.reducer';
import {
  AdmissionApplicationTaskListState,
  pooledAdmissionApplicationTaskListReducer,
  assignedAdmissionApplicationTaskListReducer,
} from './admission-applications/admission-application-task-list.reducer';
import {OfferingAssessmentListState, offeringAssessmentListReducer} from './offerings/offering-assessment-list.reducer';
import {
  admissionEnrollmentListReducer,
  AdmissionEnrollmentListState,
} from './admissions/admission-enrollment-list.reducer';
import {
  admissionEnrollmentApplicationListReducer,
  AdmissionEnrollmentApplicationListState,
} from './admissions/admission-enrollment-application-list.reducer';
import {
  admissionApplicationTaskReducer,
  AdmissionApplicationTaskState,
} from './admission-applications/admission-application-task.reducer';
import {
  admissionApplicationListReducer,
  AdmissionApplicationListState, archivedAdmissionApplicationListReducer,
} from './admission-applications/admission-application-list.reducer';
import {
    enrollmentApplicationListReducer,
    EnrollmentApplicationListState, archivedEnrollmentApplicationListReducer,
  } from './enrollment-applications/enrollment-application-list.reducer';

export interface TermModuleState {
  offerings: OfferingListState;
  offering: OfferingState;
  offeringAssessments: OfferingAssessmentListState;
  offeringSections: OfferingSectionListState;
  section: SectionState;
  sections: SectionListState;
  sectionAppointments: SectionAppointmentListState;
  assessment: AssessmentState;
  enrollments: EnrollmentListState;
  enrollment: EnrollmentState;
  appointments: AppointmentListState;
  appointment: AppointmentState;
  // admission
  admissions: AdmissionListState;
  admission: AdmissionState;
  admissionEnrollments: AdmissionEnrollmentListState;
  admissionEnrollmentApplications: AdmissionEnrollmentApplicationListState;
  assignedAdmissionApplicationTasks: AdmissionApplicationTaskListState;
  pooledAdmissionApplicationTasks: AdmissionApplicationTaskListState;
  archivedAdmissionApplications: AdmissionApplicationListState;
  admissionApplicationTask: AdmissionApplicationTaskState;
  // enrollment
  assignedEnrollmentApplicationTasks: EnrollmentApplicationTaskListState;
  pooledEnrollmentApplicationTasks: EnrollmentApplicationTaskListState;
  archivedEnrollmentApplications: EnrollmentApplicationListState;
  enrollmentApplicationTask: EnrollmentApplicationTaskState;
  enrollmentApplicationItems: EnrollmentApplicationItemListState;
  gradebookMatrices: GradebookMatrixListState;
}
;

export const INITIAL_TERM_STATE: TermModuleState = <TermModuleState>{
    offerings: <Offering[]>[],
    offering: <Offering>{},
    offeringSections: <Section[]>[],
    offeringAssessments: <Assessment[]>[],
    sections: <Section[]>[],
    section: <Section>{},
    sectionAppointments: <Appointment[]>[],
    assessment: <Assessment[]>[],
    enrollments: <Enrollment[]>[],
    enrollment: <Enrollment>{},
    appointments: <Appointment[]>[],
    appointment: <Appointment>{},
    // admission
    admissions: <Admission[]>[],
    admission: <Admission>{},
    admissionEnrollments: <Enrollment[]>[],
    admissionEnrollmentApplications: <EnrollmentApplication[]>[],
    admissionApplications: <AdmissionApplication[]>[],
    admissionApplication: <AdmissionApplication>{},
    assignedAdmissionApplicationTasks: <AdmissionApplicationTask[]>[],
    pooledAdmissionApplicationTasks: <AdmissionApplicationTask[]>[],
    archivedAdmissionApplications: <AdmissionApplication[]>[],
    admissionApplicationTask: <AdmissionApplicationTask>{},
    // enrollment
    assignedEnrollmentApplicationTasks: <EnrollmentApplicationTask[]>[],
    pooledEnrollmentApplicationTasks: <EnrollmentApplicationTask[]>[],
    archivedEnrollmentApplications: <EnrollmentApplication[]>[],
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
  sectionAppointments: sectionAppointmentListReducer,
  assessment: assessmentReducer,
  enrollments: enrollmentListReducer,
  enrollment: enrollmentReducer,
  appointments: appointmentListReducer,
  appointment: appointmentReducer,
  // admission
  admissions: admissionListReducer,
  admission: admissionReducer,
  admissionEnrollments: admissionEnrollmentListReducer,
  admissionEnrollmentApplications: admissionEnrollmentApplicationListReducer,
  admissionApplications: admissionApplicationListReducer,
  admissionApplication: admissionApplicationReducer,
  assignedAdmissionApplicationTasks: assignedAdmissionApplicationTaskListReducer,
  pooledAdmissionApplicationTasks: pooledAdmissionApplicationTaskListReducer,
  archivedAdmissionApplications: archivedAdmissionApplicationListReducer,
  admissionApplicationTask: admissionApplicationTaskReducer,
  // enrollment
  assignedEnrollmentApplicationTasks: assignedEnrollmentApplicationTaskListReducer,
  pooledEnrollmentApplicationTasks: pooledEnrollmentApplicationTaskListReducer,
  archivedEnrollmentApplications: archivedEnrollmentApplicationListReducer,
  enrollmentApplicationTask: enrollmentApplicationTaskReducer,
  enrollmentApplicationItems: enrollmentApplicationItemListReducer,
  enrollmentApplication: enrollmentApplicationReducer,
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
  entryComponents: [],
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
