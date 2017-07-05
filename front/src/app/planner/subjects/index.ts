
import {SubjectCenterPage } from './subject-center.page';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {SubjectListComponent} from "./component/subject-list.component";
// import {SubjectActions} from "./subject.action";
import {EffectsModule} from "@ngrx/effects";
// import {SubjectEffects} from "./subject.effect";
import {SubjectComponent} from "./component/subject.component";
import {SubjectDetailPage} from "./subject-detail.page";
import {SubjectEditorDialog} from "./dialog/subject-editor.dialog";
import {SubjectCreatorDialog} from "./dialog/subject-creator.dialog";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    // EffectsModule.run(SubjectEffects),
  ],
  
  declarations: [

    // page
    SubjectCenterPage,
    SubjectDetailPage,

    // component
    SubjectListComponent,
    SubjectComponent,
  

    // dialog
    SubjectEditorDialog,
    SubjectCreatorDialog,
    
  ],
  exports: [
 
    SubjectListComponent,
    SubjectComponent,

  ],
  
   entryComponents: [
    SubjectCreatorDialog,
    SubjectEditorDialog,
  ],
})

export class SubjectSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SubjectSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        // SubjectActions,
      ],
    };
  }
}


