import {NgModule, Type} from '@angular/core';
import {BrowserModule, Title}  from '@angular/platform-browser';
import {RequestInterceptor} from '../config/interceptors/request.interceptor';

import {CovalentCoreModule} from '@covalent/core';
import {CovalentHttpModule, IHttpInterceptor} from '@covalent/http';
import {CovalentHighlightModule} from '@covalent/highlight';
import {CovalentMarkdownModule} from '@covalent/markdown';
import {CovalentChartsModule} from '@covalent/charts';
import {NgxChartsModule} from '@swimlane/ngx-charts';
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {StoreModule, ActionReducer, combineReducers} from "@ngrx/store";

import {AppComponent} from './app.component';
import {MainComponent} from './main/main.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {appRoutes, appRoutingProviders} from './app.routes';
import {HomeComponent} from "./home/home.component";
import {CustomUrlSerializer} from "./common/custom-url-serializer";
import {UrlSerializer} from "@angular/router";

import {
  GraduationModule, graduationModuleReducers, GraduationModuleState,
  INITIAL_GRADUATION_STATE
} from "./graduation/index";
import {CommonModuleState, INITIAL_COMMON_STATE, commonModuleReducers} from "./common/index";
import {ProfileModule, profileModuleReducers, ProfileModuleState, INITIAL_PROFILE_STATE} from "./profile/index";
import {TermModule, termModuleReducers, TermModuleState, INITIAL_TERM_STATE} from "./term/index";
import {PlannerModule, plannerModuleReducers, PlannerModuleState, INITIAL_PLANNER_STATE} from "./planner/index";
import {SetupModule, setupModuleReducers, SetupModuleState, INITIAL_SETUP_STATE} from "./setup/index";
import {IdentityModule, identityModuleReducers, IdentityModuleState, INITIAL_IDENTITY_STATE} from "./identity/index";
import {SectionEffects} from "./term/sections/section.effect";
import {AppointmentEffects} from "./term/appointments/appointment.effect";
import {EffectsModule} from "@ngrx/effects";
// interceptor
const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

// state
interface ApplicationState {
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
  commonModuleState: combineReducers({...commonModuleReducers}),
  identityModuleState: combineReducers({...identityModuleReducers}),
  profileModuleState: combineReducers({...profileModuleReducers}),
  plannerModuleState: combineReducers({...plannerModuleReducers}),
  termModuleState: combineReducers({...termModuleReducers,}),
  graduationModuleState: combineReducers({...graduationModuleReducers,}),
  setupModuleState: combineReducers({...setupModuleReducers}),
};
export const productionReducer: ActionReducer<ApplicationState> = combineReducers(applicationReducers);
export function applicationReducer(applicationState: any = INITIAL_APP_STATE, action: any) {
  return productionReducer(applicationState, action);
}

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HomeComponent,
    DashboardComponent,
    LoginComponent,
  ],
  imports: [
    appRoutes,
    BrowserModule,
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
    StoreDevtoolsModule.instrumentOnlyWithExtension(),
    IdentityModule.forRoot(),
    ProfileModule.forRoot(),
    PlannerModule.forRoot(),
    TermModule.forRoot(),
    GraduationModule.forRoot(),
    SetupModule.forRoot(),
    EffectsModule.run(SectionEffects), // lazy load bug, moved from section root. Fix in Angular 4
    EffectsModule.run(AppointmentEffects),

  ], // modules needed to run this module
  providers: [
    appRoutingProviders,
    httpInterceptorProviders,
    Title,
    {provide: UrlSerializer, useClass: CustomUrlSerializer}
  ], // additional providers needed for this module
  entryComponents: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
