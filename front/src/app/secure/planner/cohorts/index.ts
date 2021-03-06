import {CurriculumSubModule} from '../curriculums/index';
import {CohortActionComponent} from './component/cohort-action.component';
import {AcademicClassificationSelectComponent} from './component/academic-classification-select.component';
import {CohortSelectComponent} from './component/cohort-select.component';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {CommonService, IdentityService, PlannerService} from '../../../../services';
import {ProgramSubModule} from '../programs/index';
import {CohortCenterPage} from './cohort-center.page';
import {CohortListComponent} from './component/cohort-list.component';
import {CohortActions} from './cohort.action';
import {CohortEditorDialog} from './dialog/cohort-editor.dialog';
import {CohortDetailPage} from './cohort-detail.page';
import {CohortComponent} from './component/cohort.component';
import {IdentityModule} from '../../identity/index';
import {AcademicSessionSubModule} from '../academic-sessions/index';
import {CohortUpdateDialog} from './dialog/cohort-update.dialog';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    ProgramSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    CurriculumSubModule.forRoot(),
    

    IdentityModule.forRoot(),

  ],
  declarations: [
    // page
    CohortCenterPage,
    CohortDetailPage,

    // component
    CohortListComponent,
    CohortComponent,
    CohortSelectComponent,
    AcademicClassificationSelectComponent,
    CohortActionComponent,

    // dialog
    CohortEditorDialog,
    CohortUpdateDialog,

  ],
  exports: [CohortSelectComponent,
    AcademicClassificationSelectComponent,
    CohortActionComponent,],
  entryComponents: [
    CohortEditorDialog,
    CohortUpdateDialog,
    CohortSelectComponent,
    AcademicClassificationSelectComponent,
    CohortActionComponent,
  ],

})

export class CohortSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CohortSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        CohortActions,
      ],
    };
  }
}

