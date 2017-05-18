import { AssessmentListComponent } from './component/assessment-list.component';
import { EffectsModule } from '@ngrx/effects';
import { AssessmentCenterPage } from './assessment-center.page';
import { AssessmentEffects } from './assessment.effect';
import { AssessmentActions } from './assessment.action';
import { PlannerService } from './../../../services/planner.service';
import { TermService } from './../../../services/term.service';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';



@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AssessmentEffects),
  ],
    declarations: [
      //page
      AssessmentCenterPage,

      //Component
      AssessmentListComponent,
    ],
      exports: [  
       ],
})
export class AssessmentSubModule{
    static forRoot(): ModuleWithProviders{
        return{
      ngModule: AssessmentSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        PlannerService,
        AssessmentActions,
      ],
        };
    }
}
