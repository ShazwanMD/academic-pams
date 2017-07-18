import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
//import {GradebookListComponent} from "./component/gradebook-list.component";
import {GradebookActions} from "./gradebook.action";
import {EffectsModule} from "@ngrx/effects";
import {GradebookEffects} from "./gradebook.effect";
import {GradebookDetailPage} from "./gradebook-detail.page";
//import {GradebookComponent} from "./component/gradebook.component";
//import {GradebookActionComponent} from "./component/gradebook-action.component";
//import {GradebookEditorDialog} from "./dialog/gradebook-editor.dialog";
//import {GradebookStatusSelectComponent} from "./component/gradebook-status-select.component";


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

    // component
   // GradebookListComponent,
   // GradebookComponent,
   // GradebookActionComponent,
   // GradebookStatusSelectComponent,

  //dialog
  //  GradebookEditorDialog,
  ],
  exports: [
 // GradebookEditorDialog,
      ],
   entryComponents: [
  //  GradebookEditorDialog,
  ],
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


