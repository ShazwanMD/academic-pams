import {CourseClassificationComponent} from './component/course-classification.component';
import {CourseClassificationSelectComponent} from './component/course-classification-select.component';

import { CourseCenterPage } from './course-center.page';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {PlannerService} from '../../../../services';
import {CommonService} from '../../../../services';
import {IdentityService} from '../../../../services';
import {CourseListComponent} from './component/course-list.component';
import {CourseActions} from './course.action';
import {EffectsModule} from '@ngrx/effects';
import {CourseEffects} from './course.effect';
import {CourseComponent} from './component/course.component';
import {CourseDetailPage} from './course-detail.page';
import {CourseEditorDialog} from './dialog/course-editor.dialog';
import {CourseCreatorDialog} from './dialog/course-creator.dialog';
import {CourseSelectComponent} from './component/course-select.component';
import {FacultySubModule} from '../faculties/index';
import {CourseActionComponent} from './component/course-action.component';
import {CourseStatusComponent} from './component/course-status.component';
import {CourseStatusSelectComponent} from './component/course-status-select.component';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    FacultySubModule.forRoot(),
    EffectsModule.run(CourseEffects),
  ],

  declarations: [

    // page
    CourseCenterPage,
    CourseDetailPage,

    // component
    CourseListComponent,
    CourseComponent,
    CourseSelectComponent,
    CourseActionComponent,
    CourseStatusComponent,
    CourseStatusSelectComponent,
    CourseClassificationSelectComponent,
    CourseClassificationComponent,

    // dialog
    CourseEditorDialog,
    CourseCreatorDialog,

  ],
  exports: [
    CourseSelectComponent,
    CourseListComponent,
    CourseComponent,
    CourseStatusComponent,
    CourseStatusSelectComponent,
    CourseClassificationSelectComponent,
    CourseClassificationComponent,

  ],

   entryComponents: [
    CourseCreatorDialog,
    CourseEditorDialog,
  ],
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

