import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

//import {StaffListComponent} from "./component/staff-list.component";
import {StaffActions} from "./staff.action";
import {EffectsModule} from "@ngrx/effects";

import {StaffDetailPage} from "./staff-detail.page";

import {StaffComponent} from "./component/staff.component";

//import {StaffEditorDialog} from "./dialog/staff-editor.dialog";
import {IdentityModule} from "../../identity/index";
//import { StaffActionComponent } from "./component/staff-action.component";
import { StaffCenterPage } from "./staff-center.page";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
   
    IdentityModule.forRoot(),
  
  ],
  declarations: [
    // page
    StaffDetailPage,
    StaffCenterPage,
   
    // component
    //StaffListComponent,
    StaffComponent,
   
   // StaffActionComponent,

    //dialog
    //StaffEditorDialog,

  ],
  exports: [
   // StaffEditorDialog,
   StaffComponent,
   StaffCenterPage,
  ],
  entryComponents: [
    //StaffEditorDialog,
  ],
})

export class StaffSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: StaffSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        StaffActions,
      ],
    };
  }
}
