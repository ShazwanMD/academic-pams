import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {CourseCenterPage} from "./course-center.page";
import {CourseListComponent} from "./component/course-list.component";
import {CourseActions} from "./course.action";
import {EffectsModule} from "@ngrx/effects";
import {CourseEffects} from "./course.effect";
import {CourseDetailPage} from "./course-detail.page";
import {CourseComponent} from "./component/course.component";
// import { CourseSelectComponent } from './component/course-select.component';


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CourseEffects),
  ],
  declarations: [
    // page
    CourseCenterPage,
    CourseDetailPage,

    // component
    CourseListComponent,
    CourseComponent,

    //dialog
    
  ],
  exports: [
    //component
    // CourseSelectComponent,
  ],
  
  entryComponents: [
    //dialog 
  ]

})

export class CourseSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CourseSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        CourseActions,
      ],
    };
  }
}


