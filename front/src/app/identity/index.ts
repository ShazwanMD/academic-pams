import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {IdentityComponent} from "./identity.component";

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,
  ],
  declarations: [
    IdentityComponent,
  ],
  exports: [],
})
export class IdentityModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: IdentityModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService
      ],
    };
  }
}
