import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

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
import {OfferingEditorDialog} from "./dialog/offering-editor.dialog";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
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
    
    //dialog
    OfferingEditorDialog,
    
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
      ],
    };
  }
}


