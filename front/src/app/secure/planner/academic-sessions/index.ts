import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService, NotificationService} from '../../../../services';

import {AcademicSessionCenterPage} from './academic-session-center.page';
import {AcademicSessionListComponent} from './component/academic-session-list.component';
import {AcademicSessionComponent} from './component/academic-session.component';
import {AcademicSessionGraduationListComponent} from './component/academic-session-graduation-list.component';
import {AcademicSessionDetailPage} from './academic-session-detail.page';
import {AcademicSessionGraduationDetailPage} from './academic-session-graduation-detail.page';
import {AcademicSessionActions} from './academic-session.action';
import {AcademicSessionSelectComponent} from './component/academic-session-select.component';
import {AcademicSessionCreatorDialog} from './dialog/academic-session-creator.dialog';
import {AcademicSessionStatusComponent} from './component/academic-session-status.component';

import {AcademicSessionEditorDialog} from './dialog/academic-session-editor.dialog';
import {AcademicSemesterSelectComponent} from './component/academic-semester-select.component';
import {AcademicSessionActionComponent} from './component/academic-session-action.component';
import {AcademicYearSubModule} from '../academic-years/index';
import { AcademicSessionGraduationActionComponent } from "./component/academic-session-graduation-action.component";

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
    AcademicSessionGraduationDetailPage,

    //component
    AcademicSessionListComponent,
    AcademicSessionComponent,
    AcademicSessionGraduationListComponent,
    AcademicSessionSelectComponent,
    AcademicSessionStatusComponent,
    AcademicSemesterSelectComponent,
    AcademicSessionActionComponent,
    AcademicSessionGraduationActionComponent,

    //dialog
    AcademicSessionCreatorDialog,
    AcademicSessionEditorDialog,
  ],

  exports: [
    AcademicSessionSelectComponent,
    AcademicSessionStatusComponent,
    AcademicSemesterSelectComponent,
    AcademicSessionActionComponent,
    AcademicSessionGraduationActionComponent,

  ],

  entryComponents: [
    AcademicSessionCreatorDialog,
    AcademicSessionEditorDialog,
    AcademicSessionSelectComponent,
    AcademicSessionActionComponent,
    AcademicSessionGraduationActionComponent,

  ],

})

export class AcademicSessionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AcademicSessionSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        NotificationService,
        AcademicSessionActions,
      ],
    };
  }
}
