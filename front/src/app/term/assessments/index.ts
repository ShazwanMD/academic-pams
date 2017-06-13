import {AssessmentCategorySelectComponent} from './component/assessment-category-select.component';
import {AssessmentTypeSelectComponent} from './component/assessment-type-select.component';
import {AssessmentCreatorDialog} from './dialog/assessment-creator.dialog';
import {AssessmentListComponent} from './component/assessment-list.component';
import {AssessmentComponent} from './component/assessment.component';
import {EffectsModule} from '@ngrx/effects';
import {AssessmentEffects} from './assessment.effect';
import {AssessmentActions} from './assessment.action';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {AssessmentDetailPage} from "./assessment-detail.page";
import {TermService} from "../../../services/term.service";
import {PlannerService} from "../../../services/planner.service";
import {PipeModule} from "../../app.pipe.module";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AssessmentEffects),
    PipeModule,
  ],
  declarations: [
    //page
    AssessmentDetailPage,

    //component
    AssessmentListComponent,
    AssessmentTypeSelectComponent,
    AssessmentComponent,

    //dialog
    AssessmentCreatorDialog,
    AssessmentCategorySelectComponent,
  ],
  exports: [
    AssessmentCreatorDialog,
    AssessmentTypeSelectComponent,
    AssessmentCategorySelectComponent,
    AssessmentDetailPage,

  ],

  entryComponents: [
    AssessmentCreatorDialog,

  ],
})
export class AssessmentSubModule {
  static forRoot(): ModuleWithProviders {
    return {
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
