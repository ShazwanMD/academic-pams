import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {OfferingApplicationActions} from "./offering-application.action";
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {OfferingCenterPage} from "./offering-center.page";
import {OfferingListComponent} from "./component/offering-list.component";
import {OfferingActions} from "./offering.action";
import {EffectsModule} from "@ngrx/effects";
import {OfferingEffects} from "./offering.effect";
import {OfferingDetailPage} from "./offering-detail.page";
import {OfferingComponent} from "./component/offering.component";
import {OfferingSectionComponent} from "./component/offering-section.component";
import {OfferingEditorDialog} from "./dialog/offering-editor.dialog";
import {OfferingCreateTaskCreatorDialog} from "./dialog/offering-create-task-creator.dialog";
import {CourseSubModule} from "../../planner/courses/index";
import {ProgramSubModule} from "../../planner/programs/index";
import {OfferingUpdateTaskCreatorDialog} from "./dialog/offering-update-task-creator.dialog";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CourseSubModule.forRoot(),
    ProgramSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    EffectsModule.run(OfferingEffects),
  ],
  declarations: [
    // page
    OfferingCenterPage,
    OfferingDetailPage,

    // component
    OfferingListComponent,
    OfferingComponent,
    OfferingSectionComponent,
    
    
    //dialog
    OfferingEditorDialog,
    OfferingCreateTaskCreatorDialog,
    OfferingUpdateTaskCreatorDialog,
        
  ],
  exports: [],
})

export class OfferingSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: OfferingSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        OfferingActions,
        OfferingApplicationActions,
      ],
    };
  }
}


