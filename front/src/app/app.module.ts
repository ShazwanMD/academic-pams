import { PTJDashboardPanel } from './secure/ptj-dashboard.panel';
import { FacultyDashboardPanel } from './secure/faculty-dashboard.panel';
import { LecturerModuleState, INITIAL_LECTURER_PROFILE_STATE, lecturerModuleReducers, LecturerModule } from './secure/lecturerPanel/index';
import { LecturerDashboardPanel } from './secure/lecturer-dashboard.panel';
import { RegistrationModule, registrationModuleReducers, INITIAL_REGISTRATION_STATE, RegistrationModuleState } from './registration/index';
import { StudentDashboardPanel } from './secure/student-dashboard.panel';
import { StudentProfileModuleState, INITIAL_STUDENT_PROFILE_STATE, studentProfileModuleReducers, StudentProfileModule } from './secure/studentProfile/index';
import { NgModule, Type } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { RequestInterceptor } from '../config/interceptors/request.interceptor';

import { CovalentCoreModule } from '@covalent/core';
import { CovalentHttpModule } from '@covalent/http';
import { CovalentHighlightModule } from '@covalent/highlight';
import { CovalentMarkdownModule } from '@covalent/markdown';
import { CovalentChartsModule } from '@covalent/charts';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ActionReducer, combineReducers, StoreModule } from '@ngrx/store';

import { AppComponent } from './app.component';
import { appRoutes, appRoutingProviders } from './app.routes';

import {
  GraduationModule,
  graduationModuleReducers,
  GraduationModuleState,
  INITIAL_GRADUATION_STATE
} from './secure/graduation/index';
import { commonModuleReducers, CommonModuleState, INITIAL_COMMON_STATE } from './common/index';
import { INITIAL_PROFILE_STATE, ProfileModule, profileModuleReducers, ProfileModuleState } from './secure/profile/index';
import { INITIAL_TERM_STATE, TermModule, termModuleReducers, TermModuleState } from './secure/term/index';
import { INITIAL_PLANNER_STATE, PlannerModule, plannerModuleReducers, PlannerModuleState } from './secure/planner/index';
import { INITIAL_SETUP_STATE, SetupModule, setupModuleReducers, SetupModuleState } from './secure/setup/index';
import {
  IdentityModule,
  identityModuleReducers,
  IdentityModuleState,
  INITIAL_IDENTITY_STATE
} from './secure/identity/index';
import { SectionEffects } from './secure/term/sections/section.effect';
import { AppointmentEffects } from './secure/term/appointments/appointment.effect';
import { StaffEffects } from './secure/identity/staffs/staff.effect';
import { EffectsModule } from '@ngrx/effects';
import { AcademicSessionEffects } from './secure/planner/academic-sessions/academic-session.effect';
import { AcademicYearEffects } from './secure/planner/academic-years/academic-year.effect';
import { CohortEffects } from './secure/planner/cohorts/cohort.effect';
import { PipeModule } from './app.pipe.module';
import { environment } from '../environments/environment';
import {
  applicationContextReducer,
  ApplicationContextState,
  INITIAL_APPLICATION_CONTEXT_STATE
} from './application-context.reducer';
import { ApplicationContextActions } from './application-context.action';
import { AdministratorDashboardPanel } from './secure/administrator-dashboard.panel';
import { AuthorizationGuard } from './secure/identity/guard/authorization.guard';
import { AuthenticationGuard } from './secure/identity/guard/authentication.guard';
import { SystemService } from '../services/system.service';
import { AuthorizationService } from '../services/authorization.service';
import { AlertService } from '../services/alert.service';
import { AuthenticationService } from '../services/authentication.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HomePage } from './home/home.page';
import { SecurePage } from './secure/secure.page';
import { LoginPage } from './login/login.page';
import { ForgetPasswordPage } from './login/forget-password.page';
import { DashboardPage } from './secure/dashboard.page';
import { AuthorizedShowDirective } from './secure/identity/directive/authorized-show.directive';
import { AuthenticatedShowDirective } from './secure/identity/directive/authenticated-show.directive';
import { NotAuthenticatedShowDirective } from './secure/identity/directive/not-authenticated-show.directive';
import { AssessmentEffects } from "./secure/term/assessments/assessment.effect";
import { OfferingEffects } from "./secure/term/offerings/offering.effect";
import { CurriculumEffects } from "./secure/planner/curriculums/curriculum.effect";
import { ReportModule } from "./shared/report/index";
// interceptor
const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

// state
export interface ApplicationState {
  applicationContextState: ApplicationContextState;
  commonModuleState: CommonModuleState;
  identityModuleState: IdentityModuleState;
  profileModuleState: ProfileModuleState;
  plannerModuleState: PlannerModuleState;
  termModuleState: TermModuleState;
  graduationModuleState: GraduationModuleState;
  setupModuleState: SetupModuleState;
  studentProfileModuleState: StudentProfileModuleState;
  registrationModuleState: RegistrationModuleState;
  lecturerModuleState: LecturerModuleState;
}

// initial state
export const INITIAL_APP_STATE: ApplicationState =
  <ApplicationState>{
    applicationContextState: INITIAL_APPLICATION_CONTEXT_STATE,
    commonModuleState: INITIAL_COMMON_STATE,
    identityModuleState: INITIAL_IDENTITY_STATE,
    profileModuleState: INITIAL_PROFILE_STATE,
    plannerModuleState: INITIAL_PLANNER_STATE,
    termModuleState: INITIAL_TERM_STATE,
    graduationModuleState: INITIAL_GRADUATION_STATE,
    setupModuleState: INITIAL_SETUP_STATE,
    studentProfileModuleState: INITIAL_STUDENT_PROFILE_STATE,
    registrationModuleState: INITIAL_REGISTRATION_STATE,
    lecturerModuleState: INITIAL_LECTURER_PROFILE_STATE,

  };

// combine reducer
export const applicationReducers = {
  applicationContextState: applicationContextReducer,
  commonModuleState: combineReducers({ ...commonModuleReducers }),
  identityModuleState: combineReducers({ ...identityModuleReducers }),
  profileModuleState: combineReducers({ ...profileModuleReducers }),
  plannerModuleState: combineReducers({ ...plannerModuleReducers }),
  termModuleState: combineReducers({ ...termModuleReducers, }),
  graduationModuleState: combineReducers({ ...graduationModuleReducers, }),
  setupModuleState: combineReducers({ ...setupModuleReducers }),
  studentProfileModuleState: combineReducers({ ...studentProfileModuleReducers }),
  registrationModuleState: combineReducers({ ...registrationModuleReducers }),
  LecturerModuleState: combineReducers({...lecturerModuleReducers}),
};
export const productionReducer: ActionReducer<ApplicationState> = combineReducers(applicationReducers);
export function applicationReducer(applicationState: any = INITIAL_APP_STATE, action: any) {
  return productionReducer(applicationState, action);
}

@NgModule({
  declarations: [
    AppComponent,
    HomePage,
    SecurePage,
    LoginPage,
    ForgetPasswordPage,
    DashboardPage,
    ForgetPasswordPage,
    AdministratorDashboardPanel,
    AuthorizedShowDirective,
    AuthenticatedShowDirective,
    NotAuthenticatedShowDirective,
    //Student DashBoard Panel
    StudentDashboardPanel,
    LecturerDashboardPanel,
    FacultyDashboardPanel,
    PTJDashboardPanel,
  ],
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CovalentChartsModule.forRoot(),
    CovalentHttpModule.forRoot({
      interceptors: [{
        interceptor: RequestInterceptor, paths: ['**'],
      }],
    }),
    CovalentHighlightModule.forRoot(),
    CovalentMarkdownModule.forRoot(),
    NgxChartsModule,
    StoreModule.provideStore(applicationReducer),
    environment.imports,

    PipeModule,
    IdentityModule.forRoot(),
    ProfileModule.forRoot(),
    PlannerModule.forRoot(),
    TermModule.forRoot(),
    GraduationModule.forRoot(),
    SetupModule.forRoot(),
    ReportModule.forRoot(),
    EffectsModule.run(SectionEffects), // lazy load bug, moved from section root. Fix in Angular 4
    EffectsModule.run(AppointmentEffects),
    EffectsModule.run(StaffEffects),
    EffectsModule.run(AcademicSessionEffects),
    
    EffectsModule.run(AcademicYearEffects),
    EffectsModule.run(CohortEffects),
    EffectsModule.run(AssessmentEffects),
    EffectsModule.run(OfferingEffects),
    StudentProfileModule.forRoot(),
    RegistrationModule.forRoot(),
    LecturerModule.forRoot(),

  ], // modules needed to run this module
  providers: [
    appRoutingProviders,
    httpInterceptorProviders,
    AuthenticationService,
    AlertService,
    AuthorizationService,
    SystemService,
    AuthenticationGuard,
    AuthorizationGuard,
    Title,
    ApplicationContextActions,
  ],
  entryComponents: [
    AdministratorDashboardPanel,
    StudentDashboardPanel,
    LecturerDashboardPanel,
    FacultyDashboardPanel,
    PTJDashboardPanel,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
