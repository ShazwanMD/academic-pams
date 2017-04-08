import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";

import {TermPage} from "./term.page";
import {combineReducers, StoreModule} from "@ngrx/store";
import {compose} from "@ngrx/core/compose";

export interface TermState {
  // todo
}
;

export const termReducer = compose(combineReducers)({
  // todo
});


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,

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

