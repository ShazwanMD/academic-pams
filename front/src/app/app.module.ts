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

import {CommonModuleState, INITIAL_COMMON_STATE, commonModuleReducers} from "./common/index";
import {GraduationModule} from "./graduation/index";
import {ProfileModule, profileModuleReducers, ProfileModuleState, INITIAL_PROFILE_STATE} from "./profile/index";
import {TermModule, termModuleReducers, TermModuleState, INITIAL_TERM_STATE} from "./term/index";
import {PlannerModule, plannerModuleReducers, PlannerModuleState, INITIAL_PLANNER_STATE} from "./planner/index";

// interceptor
const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

// state
interface ApplicationState {
  commonModuleState: CommonModuleState;
  profileModuleState: ProfileModuleState;
  plannerModuleState: PlannerModuleState;
  termModuleState: TermModuleState;
  // graduationModuleState: GraduationModuleState;
}
;

// initial state
export const INITIAL_APP_STATE: ApplicationState =
  <ApplicationState> {
    commonModuleState: INITIAL_COMMON_STATE,
    profileModuleState: INITIAL_PROFILE_STATE,
    plannerModuleState: INITIAL_PLANNER_STATE,
    termModuleState: INITIAL_TERM_STATE,
    // graduationModuleState: INITIAL_GRADUATION_STATE,
    
  };

// combine reducer
export const applicationReducers = {
  commonModuleState: combineReducers({...commonModuleReducers}),
  profileModuleState: combineReducers({...profileModuleReducers}),
  plannerModuleState: combineReducers({...plannerModuleReducers}),
  termModuleState: combineReducers({...termModuleReducers,}),
  // graduationModuleState: combineReducers({...graduationModuleReducers}),
  
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
  ], // directives, components, and pipes owned by this NgModule
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
    ProfileModule.forRoot(),
    PlannerModule.forRoot(),
    TermModule.forRoot(),
    GraduationModule.forRoot(),
    

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
