import {AssessmentCategorySelectComponent} from './component/assessment-category-select.component';
import {AssessmentTypeSelectComponent} from './component/assessment-type-select.component';
import {AssessmentListComponent} from './component/assessment-list.component';
import {AssessmentComponent} from './component/assessment.component';
import {EffectsModule} from '@ngrx/effects';
import {AssessmentEffects} from './assessment.effect';
import {AssessmentActions} from './assessment.action';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {AssessmentDetailPage} from './assessment-detail.page';
import {TermService} from '../../../../services/term.service';
import {PlannerService} from '../../../../services/planner.service';
import {PipeModule} from '../../../app.pipe.module';
import {AssessmentEditorDialog} from './dialog/assessment-creator.dialog';
import { NotificationService } from "../../../../services/notification.service";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    //EffectsModule.run(AssessmentEffects), // lazy load bug, moved to app root. Fix in Angular 4
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
    AssessmentEditorDialog,
    AssessmentCategorySelectComponent,
  ],
  exports: [
    AssessmentEditorDialog,
    AssessmentTypeSelectComponent,
    AssessmentCategorySelectComponent,
    AssessmentDetailPage,

  ],

  entryComponents: [
    AssessmentEditorDialog,

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
        NotificationService,
      ],
    };
  }
}
