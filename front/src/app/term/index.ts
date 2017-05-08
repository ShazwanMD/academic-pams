import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";
import {TermPage} from "./term.page";
import {AdmissionDetailPage} from "./admissions/admission-detail.page";
import {OfferingSubModule} from "./offerings/index";
import {offeringReducer, OfferingState} from "./offerings/offering.reducer";
import {offeringListReducer, OfferingListState} from "./offerings/offering-list.reducer";
import {Offering} from "./offerings/offering.interface";


export interface TermModuleState {
  offerings: OfferingListState;
  offering: OfferingState;
}
;

export const INITIAL_TERM_STATE: TermModuleState =
  <TermModuleState>{
    offerings: <Offering[]>[],
    offering: <Offering>{},
  };

export const termModuleReducers = {
  offerings: offeringListReducer,
  offering: offeringReducer,
};


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    OfferingSubModule.forRoot()

    // our modules
    // ngrx
  ],
  declarations: [
    // page
    TermPage,
    AdmissionDetailPage,

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

