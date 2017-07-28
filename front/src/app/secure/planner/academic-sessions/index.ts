import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../../services';

import {AcademicSessionCenterPage} from './academic-session-center.page';
import {AcademicSessionListComponent} from './component/academic-session-list.component';
import {AcademicSessionComponent} from './component/academic-session.component';
import {AcademicSessionDetailPage} from './academic-session-detail.page';
import {AcademicSessionActions} from './academic-session.action';
import {AcademicSessionSelectComponent} from './component/academic-session-select.component';
import {AcademicSessionCreatorDialog} from './dialog/academic-session-creator.dialog';
import {AcademicSessionStatusComponent} from './component/academic-session-status.component';

import {AcademicSessionEditorDialog} from './dialog/academic-session-editor.dialog';
import {AcademicSemesterSelectComponent} from './component/academic-semester-select.component';
import {AcademicSessionActionComponent} from './component/academic-session-action.component';
import {AcademicYearSubModule} from '../academic-years/index';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    AcademicYearSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    // EffectsModule.run(AcademicSessionEffects), // lazy load bug, moved to app root. Fix in Angular 4
  ],
  declarations: [
    //page
    AcademicSessionCenterPage,
    AcademicSessionDetailPage,

    //component
    AcademicSessionListComponent,
    AcademicSessionComponent,
    AcademicSessionSelectComponent,
    AcademicSessionStatusComponent,
    AcademicSemesterSelectComponent,
    AcademicSessionActionComponent,

    //dialog
    AcademicSessionCreatorDialog,
    AcademicSessionEditorDialog,
  ],

  exports: [
    AcademicSessionSelectComponent,
    AcademicSessionStatusComponent,
    AcademicSemesterSelectComponent,
    AcademicSessionActionComponent,

  ],

  entryComponents: [
    AcademicSessionCreatorDialog,
    AcademicSessionEditorDialog,
    AcademicSessionSelectComponent,
    AcademicSessionActionComponent,

  ],

})

export class AcademicSessionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AcademicSessionSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        AcademicSessionActions,
      ],
    };
  }
}
