import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";
import {TermPage} from "./term.page";
import {OfferingSubModule} from "./offerings/index";
import {offeringReducer, OfferingState} from "./offerings/offering.reducer";
import {offeringListReducer, OfferingListState} from "./offerings/offering-list.reducer";
import {Offering} from "./offerings/offering.interface";
import {AdmissionSubModule} from "./admissions/index";
import {Admission} from "./admissions/admission.interface";
import {admissionListReducer, AdmissionListState} from "./admissions/admission-list.reducer";
import {admissionReducer, AdmissionState} from "./admissions/admission.reducer";


export interface TermModuleState {
  offerings: OfferingListState;
  offering: OfferingState;
  admissions: AdmissionListState;
  admission: AdmissionState;
}
;

export const INITIAL_TERM_STATE: TermModuleState =
  <TermModuleState>{
    offerings: <Offering[]>[],
    offering: <Offering>{},
    admissions: <Admission[]>[],
    admission: <Admission>{},
  };

export const termModuleReducers = {
  offerings: offeringListReducer,
  offering: offeringReducer,
  admissions: admissionListReducer,
  admission: admissionReducer,
};


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    OfferingSubModule.forRoot(),
    AdmissionSubModule.forRoot(),
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

