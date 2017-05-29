import '@ngrx/core/add/operator/select';
import {EffectsModule} from '@ngrx/effects';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from "../../../services";

import {ProgramLevelCenterPage} from "./program-level-center.page";
import {ProgramLevelListComponent} from "./component/program-level-list.component";
import {ProgramLevelComponent} from "./component/program-level.component";
import {ProgramLevelDetailPage} from "./program-level-detail.page";
import {ProgramLevelActions} from "./program-level.action";
import {ProgramLevelEffects} from "./program-level.effect";
import {ProgramLevelSelectComponent} from './component/program-level-select.component';
import {ProgramLevelCreatorDialog} from "./dialog/program-level-creator.dialog";
import {ProgramLevelEditorDialog} from "./dialog/program-level-editor.dialog";
import {ProgramLevelActionComponent} from "./component/program-level-action.component";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(ProgramLevelEffects),
  ],
  declarations: [
    //page
    ProgramLevelCenterPage,
    ProgramLevelDetailPage,

    //component
    ProgramLevelListComponent,
    ProgramLevelComponent,
    ProgramLevelSelectComponent,
    ProgramLevelActionComponent,


    //dialog
    ProgramLevelCreatorDialog,
    ProgramLevelEditorDialog,
  ],

  exports: [
    ProgramLevelSelectComponent,
    ProgramLevelActionComponent,
  ],

  entryComponents: [
    ProgramLevelCreatorDialog,
    ProgramLevelEditorDialog,
    ProgramLevelSelectComponent,
    ProgramLevelActionComponent,
  ],

})

export class ProgramLevelSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ProgramLevelSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        ProgramLevelActions,
      ],
    };
  }
}
