import {compose} from "@ngrx/core/compose";
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
import {StoreModule, combineReducers} from "@ngrx/store";

import {AppComponent} from './app.component';
import {MainComponent} from './main/main.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {appRoutes, appRoutingProviders} from './app.routes';


import {PlannerModule, plannerReducer} from "./planner/index";
import {HomeComponent} from "./home/home.component";
import {TermModule, termReducer} from "./term/index";
import {CustomUrlSerializer} from "./common/custom-url-serializer";
import {UrlSerializer} from "@angular/router";
const httpInterceptorProviders: Type<any>[] = [
  RequestInterceptor,
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    DashboardComponent,
    HomeComponent,
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
    PlannerModule.forRoot(),
    TermModule.forRoot(),

    // note:temporary solution
    StoreModule.provideStore(plannerReducer),
    StoreDevtoolsModule.instrumentOnlyWithExtension(),


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
