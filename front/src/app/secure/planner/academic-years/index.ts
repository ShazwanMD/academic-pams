import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {AcademicYearActions} from './academic-year.action';
import {CommonService, IdentityService, PlannerService} from '../../../../services';
import {AcademicYearEffects} from './academic-year.effect';
import {EffectsModule} from '@ngrx/effects';
import {AcademicYearSelectComponent} from './component/academic-year-select.component';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AcademicYearEffects),
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
        AcademicYearActions,
      ],
    };
  }
}

