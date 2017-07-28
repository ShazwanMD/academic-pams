import {NgModule, Type} from '@angular/core';
import {BrowserModule, Title}  from '@angular/platform-browser';
import {RequestInterceptor} from '../config/interceptors/request.interceptor';

import {CovalentCoreModule} from '@covalent/core';
import {CovalentHttpModule, IHttpInterceptor} from '@covalent/http';
import {CovalentHighlightModule} from '@covalent/highlight';
import {CovalentMarkdownModule} from '@covalent/markdown';
import {CovalentChartsModule} from '@covalent/charts';
import {NgxChartsModule} from '@swimlane/ngx-charts';
import {StoreModule, ActionReducer, combineReducers} from '@ngrx/store';

import {AppComponent} from './app.component';
import {appRoutes, appRoutingProviders} from './app.routes';

import {
  GraduationModule, graduationModuleReducers, GraduationModuleState,
  INITIAL_GRADUATION_STATE,
} from './secure/graduation/index';
import {CommonModuleState, INITIAL_COMMON_STATE, commonModuleReducers} from './common/index';
import {ProfileModule, profileModuleReducers, ProfileModuleState, INITIAL_PROFILE_STATE} from './secure/profile/index';
import {TermModule, termModuleReducers, TermModuleState, INITIAL_TERM_STATE} from './secure/term/index';
import {PlannerModule, plannerModuleReducers, PlannerModuleState, INITIAL_PLANNER_STATE} from './secure/planner/index';
import {SetupModule, setupModuleReducers, SetupModuleState, INITIAL_SETUP_STATE} from './secure/setup/index';
import {IdentityModule, identityModuleReducers, IdentityModuleState, INITIAL_IDENTITY_STATE} from './secure/identity/index';
import {SectionEffects} from './secure/term/sections/section.effect';
import {AppointmentEffects} from './secure/term/appointments/appointment.effect';
import {StaffEffects} from './secure/identity/staffs/staff.effect';
import {EffectsModule} from '@ngrx/effects';
import {AcademicSessionEffects} from './secure/planner/academic-sessions/academic-session.effect';
import {PipeModule} from './app.pipe.module';
import {environment} from '../environments/environment';
import {
  applicationContextReducer, ApplicationContextState,
  INITIAL_APPLICATION_CONTEXT_STATE,
} from './application-context.reducer';
import {ApplicationContextActions} from './application-context.action';
import {AdministratorDashboardPanel} from './secure/administrator-dashboard.panel';
import {AuthorizationGuard} from './secure/identity/guard/authorization.guard';
import {AuthenticationGuard} from './secure/identity/guard/authentication.guard';
import {SystemService} from '../services/system.service';
import {AuthorizationService} from '../services/authorization.service';
import {AlertService} from '../services/alert.service';
import {AuthenticationService} from '../services/authentication.service';
import {ReactiveFormsModule} from '@angular/forms';
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
}
;

// initial state
export const INITIAL_APP_STATE: ApplicationState =
  <ApplicationState> {
    applicationContextState: INITIAL_APPLICATION_CONTEXT_STATE,
    commonModuleState: INITIAL_COMMON_STATE,
    identityModuleState: INITIAL_IDENTITY_STATE,
    profileModuleState: INITIAL_PROFILE_STATE,
    plannerModuleState: INITIAL_PLANNER_STATE,
    termModuleState: INITIAL_TERM_STATE,
    graduationModuleState: INITIAL_GRADUATION_STATE,
    setupModuleState: INITIAL_SETUP_STATE,

  };

// combine reducer
export const applicationReducers = {
  applicationContextState: applicationContextReducer,
  commonModuleState: combineReducers({...commonModuleReducers}),
  identityModuleState: combineReducers({...identityModuleReducers}),
  profileModuleState: combineReducers({...profileModuleReducers}),
  plannerModuleState: combineReducers({...plannerModuleReducers}),
  termModuleState: combineReducers({...termModuleReducers, }),
  graduationModuleState: combineReducers({...graduationModuleReducers, }),
  setupModuleState: combineReducers({...setupModuleReducers}),
};
export const productionReducer: ActionReducer<ApplicationState> = combineReducers(applicationReducers);
export function applicationReducer(applicationState: any = INITIAL_APP_STATE, action: any) {
  return productionReducer(applicationState, action);
}

@NgModule({
  declarations: [
    AppComponent,
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
    EffectsModule.run(SectionEffects), // lazy load bug, moved from section root. Fix in Angular 4
    EffectsModule.run(AppointmentEffects),
    EffectsModule.run(StaffEffects),
    EffectsModule.run(AcademicSessionEffects),

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
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
