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

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,
  ],
  declarations: [

    // page
    CourseCenterPage,
    // CourseDetailPage,

    // component
    CourseListComponent,
  ],
  exports: [],
})

export class CourseModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CourseModule,
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


