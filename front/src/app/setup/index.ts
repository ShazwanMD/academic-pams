import { EffectsModule } from '@ngrx/effects';
import { GenderCodeListPage } from './gender-codes/gender-code-list.page';
import { GenderCode } from './../common/gender-codes/gender-code.interface';
import { SetupActions } from './setup.action';
import { SetupEffects } from './setup.effect';
import { CommonModule } from './../common/index';
import {NgModule, ModuleWithProviders} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';


import {CovalentCoreModule} from '@covalent/core';
import {IdentityService} from '../../services';
import { SetupPage } from "./setup.page";
import {genderCodeListReducer, GenderCodeListState} from "./gender-codes/gender-code-list.reducer";

export interface SetupModuleState {
genderCodes: GenderCodeListState;

};
export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    genderCodes: <GenderCode[]>[],

  };
export const setupModuleReducers = { 

  genderCodes: genderCodeListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    EffectsModule.run(SetupEffects),
  
    
 
  ],
  declarations: [
    // page
    SetupPage,
    GenderCodeListPage

    //Dialog
    
  ],
  exports: [],

})
export class SetupModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SetupModule,
       providers: [
        appRoutingProviders,
          IdentityService,
          SetupActions
        
              ],
    };
  }
}