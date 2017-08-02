import {CurriculumBundleSubjectPartDialog} from './dialog/curriculum-bundle-subject-part.dialog';
import {CurriculumBundleSubjectDialog} from './dialog/curriculum-bundle-subject.dialog';
import {BundleSubjectComponent} from './component/curriculum-bundle-subject.component';
import {CourseActions} from '../courses/course.action';
import {CourseSubModule} from '../courses/index';
import {SingleSubjectComponent} from './component/curriculum-single-subject.component';
import {CurriculumSingleSubjectDialog} from './dialog/curriculum-single-subject.dialog';
import {CurriculumActionComponent} from './component/curriculum-action.component';
import {CurriculumSelectComponent} from './component/curriculum-select.component';
import {CurriculumSubjectListComponent} from './component/curriculum-subject-list.component';
import {CurriculumBundleSubjectListComponent} from './component/curriculum-bundle-subject-list.component';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {CommonService, IdentityService, PlannerService} from '../../../../services';
import {ProgramSubModule} from '../programs/index';
import {CurriculumCenterPage} from './curriculum-center.page';
import {CurriculumListComponent} from './component/curriculum-list.component';
import {CurriculumActions} from './curriculum.action';
import {EffectsModule} from '@ngrx/effects';
import {CurriculumEffects} from './curriculum.effect';
import {CurriculumEditorDialog} from './dialog/curriculum-editor.dialog';
import {CurriculumDetailPage} from './curriculum-detail.page';
import {CurriculumComponent} from './component/curriculum.component';
import {IdentityModule} from '../../identity/index';
import {AcademicSessionSubModule} from '../academic-sessions/index';
import {CurriculumUpdateDialog} from './dialog/curriculum-update.dialog';
import {SubjectTypeSelectComponent} from './component/subject-type-select.component';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    ProgramSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    CourseSubModule.forRoot(),
    IdentityModule.forRoot(),
    EffectsModule.run(CurriculumEffects),
  ],
  declarations: [
    // page
    CurriculumCenterPage,
    CurriculumDetailPage,

    // component
    CurriculumListComponent,
    CurriculumComponent,
    CurriculumSelectComponent,
    CurriculumActionComponent,
    CurriculumSubjectListComponent,
    SingleSubjectComponent,
    BundleSubjectComponent,
    SubjectTypeSelectComponent,
    CurriculumBundleSubjectListComponent,

    // dialog
    CurriculumEditorDialog,
    CurriculumUpdateDialog,
    CurriculumSingleSubjectDialog,
    CurriculumBundleSubjectDialog,
    CurriculumBundleSubjectPartDialog,
    
  ],
  exports: [
    CurriculumSelectComponent,
    CurriculumActionComponent,
    SingleSubjectComponent,
    BundleSubjectComponent,
    CurriculumSubjectListComponent,
  ],
  entryComponents: [
    CurriculumEditorDialog,
    CurriculumUpdateDialog,
    CurriculumSelectComponent,
    CurriculumActionComponent,
    CurriculumSubjectListComponent,
    CurriculumSingleSubjectDialog,
    CurriculumBundleSubjectDialog,
    CurriculumBundleSubjectPartDialog,
    SubjectTypeSelectComponent,
    CurriculumBundleSubjectListComponent,
    SingleSubjectComponent,
  ],
})

export class CurriculumSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CurriculumSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        CurriculumActions,
        CourseActions,
      ],
    };
  }
}

