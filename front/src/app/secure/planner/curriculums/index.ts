import {CurriculumBndleCourseListComponent} from './component/curriculum-bundle-course-list.component';
import {CurriculumBundleElectiveListComponent} from './component/curriculum-bundle-elective-list.component';
import {CurriculumBundleElectiveDialog} from './dialog/curriculum-bundle-elective.dialog';
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
import {CurriculumElectiveSubjectListComponent} from './component/curriculum-elective-subject-list.component';
import {CurriculumBundleSubjectListComponent} from './component/curriculum-bundle-subject-list.component';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {CommonService, IdentityService, PlannerService, ReportService} from '../../../../services';
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
import {SubjectElectiveStatusSelectComponent} from './component/subject-elective-status-select.component';
import { ReportActions } from "../../../shared/report/report.action";
import { ReportModule } from "../../../shared/report/index";
import { CurriculumElectiveSubjectDialog } from "./dialog/curriculum-elective-subject.dialog";

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
    CurriculumElectiveSubjectListComponent,
    SingleSubjectComponent,
    BundleSubjectComponent,
    CurriculumBundleElectiveListComponent,
    SubjectTypeSelectComponent,
    CurriculumBundleSubjectListComponent,
    CurriculumBndleCourseListComponent,
    SubjectElectiveStatusSelectComponent,

    // dialog
    CurriculumEditorDialog,
    CurriculumUpdateDialog,
    CurriculumSingleSubjectDialog,
    CurriculumElectiveSubjectDialog,
    CurriculumBundleSubjectDialog,
    CurriculumBundleSubjectPartDialog,
    CurriculumBundleElectiveDialog,
    
  ],
  exports: [
    CurriculumSelectComponent,
    CurriculumActionComponent,
    SingleSubjectComponent,
    BundleSubjectComponent,
    CurriculumSubjectListComponent,
    CurriculumElectiveSubjectListComponent,
    CurriculumBundleElectiveListComponent,
    CurriculumBndleCourseListComponent,
    SubjectElectiveStatusSelectComponent,
  ],
  entryComponents: [
    CurriculumEditorDialog,
    CurriculumUpdateDialog,
    CurriculumSelectComponent,
    CurriculumActionComponent,
    CurriculumSubjectListComponent,
    CurriculumElectiveSubjectListComponent,
    CurriculumSingleSubjectDialog,
    CurriculumElectiveSubjectDialog,
    CurriculumBundleSubjectDialog,
    CurriculumBundleSubjectPartDialog,
    CurriculumBundleElectiveDialog,
    SubjectTypeSelectComponent,
    SubjectElectiveStatusSelectComponent,
    CurriculumBundleSubjectListComponent,
    SingleSubjectComponent,
    CurriculumBundleElectiveListComponent,
    CurriculumBndleCourseListComponent,
    CurriculumBndleCourseListComponent,
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

