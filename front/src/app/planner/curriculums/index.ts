import {SubjectSubModule} from '../subjects/index';
import {SubjectActions} from '../subjects/subject.action';
import {CurriculumActionComponent} from './component/curriculum-action.component';
import {CurriculumSelectComponent} from './component/curriculum-select.component';
import { CurriculumSubjectListComponent,} from './component/curriculum-subject-list.component';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';

import {IdentityService} from '../../../services';
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

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    ProgramSubModule.forRoot(),
    SubjectSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CurriculumEffects),
    AcademicSessionSubModule.forRoot(),
    IdentityModule.forRoot(),

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

    // dialog
    CurriculumEditorDialog,
    CurriculumUpdateDialog,

  ],
  exports: [CurriculumSelectComponent,
    CurriculumActionComponent,],
  entryComponents: [
    CurriculumEditorDialog,
    CurriculumUpdateDialog,
    CurriculumSelectComponent,
    CurriculumActionComponent,
    CurriculumSubjectListComponent,
    

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
        SubjectActions,
        
      ],
    };
  }
}

