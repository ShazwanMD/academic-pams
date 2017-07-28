import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {TermService} from '../../../../services';
import {CommonService} from '../../../../services';
import {IdentityService} from '../../../../services';
import {GradebookActions} from './gradebook.action';
import {EffectsModule} from '@ngrx/effects';
import {GradebookEffects} from './gradebook.effect';
import {GradebookDetailPage} from './gradebook-detail.page';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(GradebookEffects),
  ],
  declarations: [
    // page
    GradebookDetailPage,
  ],
  exports: [],
  entryComponents: [],
})

export class GradebookSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: GradebookSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        GradebookActions,
      ],
    };
  }
}

