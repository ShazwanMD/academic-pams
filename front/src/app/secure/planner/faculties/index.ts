import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {EffectsModule} from '@ngrx/effects';

import {CommonService, IdentityService, PlannerService} from '../../../../services';

import {FacultyCenterPage} from './faculty-center.page';
import {FacultyDetailPage} from './faculty-detail.page';
import {FacultyListComponent} from './component/faculty-list.component';
import {FacultyActions} from './faculty.action';
import {FacultyEffects} from './faculty.effect';
import {FacultyComponent} from './component/faculty.component';
import {FacultySelectComponent} from './component/faculty-select.component';
import {FacultyActionComponent} from './component/faculty-action.component';
import {FacultyStatusComponent} from './component/faculty-status.component';
import {FacultyCreatorDialog} from './dialog/faculty-creator.dialog';
import {FacultyStatusSelectComponent} from './component/faculty-status-select.component';
import {FacultyProgramListComponent} from './component/faculty-program-list.component';
import {FacultyEditorDialog} from './dialog/faculty-editor.dialog';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    // ProgramSubModule.forRoot(),
    EffectsModule.run(FacultyEffects),
  ],
  declarations: [
    // page
    FacultyCenterPage,
    FacultyDetailPage,

    // component
    FacultyListComponent,
    FacultyComponent,
    FacultySelectComponent,
    FacultyActionComponent,
    FacultyStatusComponent,
    FacultyProgramListComponent,
    FacultyStatusSelectComponent,

    //dialog
    FacultyCreatorDialog,
    FacultyEditorDialog,

  ],

  exports: [
    FacultySelectComponent,
    FacultyActionComponent,
    FacultyStatusComponent,
    FacultyListComponent,
    FacultyComponent,

  ],

  entryComponents: [
    FacultyCreatorDialog,
    FacultyEditorDialog,
  ],
})

export class FacultySubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: FacultySubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        FacultyActions,
      ],
    };
  }
}

