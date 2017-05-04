import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";

import {TermPage} from "./term.page";


export interface TermModuleState {
  // todo
}
;

export const INITIAL_TERM_STATE: TermModuleState =
  <TermModuleState>{
    // todo
  };

export const termModuleReducers = {
// todo
};


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),

    // our modules
    // ngrx
  ],
  declarations: [
    // page
    TermPage,
    
  ],
  exports: [],
})
export class TermModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: TermModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        TermService,
      ],
    };
  }
}

