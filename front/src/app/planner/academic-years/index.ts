import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

//import {AcademicYearActions} from "./academicYear.action";
import {EffectsModule} from "@ngrx/effects";
import { AcademicYearSelectComponent } from "./component/academic-year-select.component";
//import {AcademicYearEffects} from "./academicYear.effect";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
   // EffectsModule.run(AcademicYearEffects),
  ],
  declarations: [
    // page
    

    // component
   AcademicYearSelectComponent,
   

    // dialog
    
    
  ],
  exports: [
    AcademicYearSelectComponent,

  ],
  
   entryComponents: [
AcademicYearSelectComponent,
  ],
})

export class AcademicYearSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AcademicYearSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        //AcademicYearActions,
      ],
    };
  }
}


