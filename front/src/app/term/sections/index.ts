import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {SectionActions} from "./section.action";
import {EffectsModule} from "@ngrx/effects";
import {SectionEffects} from "./section.effect";
import {SectionDetailPage} from "./section-detail.page";
import {SectionComponent} from "./component/section.component";
import {SectionListComponent} from "./component/section-list.component";
import {SectionSelectComponent} from "./component/section-select.component";
import {SectionUpdateTaskCreatorDialog} from "./dialog/section-update-task-creator.dialog";
import {SectionDeleteTaskCreatorDialog} from "./dialog/section-delete-task-creator.dialog";
import { SectionCreateTaskCreatorDialog } from "./dialog/section-create-task-creator.dialog";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(SectionEffects),
  ],
  declarations: [
    // page
    SectionDetailPage,

    // component
    SectionListComponent,
    SectionComponent,
    SectionSelectComponent,

    //dialog
    SectionUpdateTaskCreatorDialog,
    SectionDeleteTaskCreatorDialog,
    SectionCreateTaskCreatorDialog,

  ],
  exports: [
    SectionSelectComponent,
    SectionListComponent,

  ],
})

export class SectionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SectionSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        SectionActions,
      ],
    };
  }
}







