import '@ngrx/core/add/operator/select';
import { EffectsModule } from '@ngrx/effects';
import { appRoutes, appRoutingProviders } from '../../app.routes';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { CovalentCoreModule } from '@covalent/core';

import { PlannerService } from "../../../services";

import { AcademicSessionCenterPage } from "./academic-session-center.page";
import { AcademicSessionListComponent } from "./component/academic-session-list.component";
import { AcademicSessionComponent } from "./component/academic-session.component";
import { AcademicSessionDetailPage } from "./academic-session-detail.page";
import { AcademicSessionActions } from "./academic-session.action";
import { AcademicSessionEffects } from "./academic-session.effect";
import { AcademicSessionSelectComponent } from "./component/academic-session-select.component";
import { AcademicSessionCreatorDialog } from "./dialog/academic-session-creator.dialog";
import { AcademicSessionStatusComponent } from "./component/academic-session-status.component";
import { AcademicYear } from "./academic-session-year.interface";
import { AcademicSessionEditorDialog } from "./dialog/academic-session-editor.dialog";
import { AcademicSessionSemesterComponent } from "./component/academic-session-semester.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AcademicSessionEffects),
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
    AcademicSessionSemesterComponent,

    //dialog
    AcademicSessionCreatorDialog,
    AcademicSessionEditorDialog,
  ],

  exports: [
    AcademicSessionSelectComponent,
    AcademicSessionStatusComponent,
    AcademicSessionSemesterComponent
  ],

  entryComponents: [
    AcademicSessionCreatorDialog,
    AcademicSessionEditorDialog,

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
