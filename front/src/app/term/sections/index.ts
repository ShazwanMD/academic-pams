import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {SectionActions} from "./section.action";
import {EffectsModule} from "@ngrx/effects";
import {SectionEffects} from "./section.effect";
import {SectionDetailPage} from "./section-detail.page";
import {SectionComponent} from "./component/section.component";
import {SectionListComponent} from "./component/section-list.component";
import {SectionSelectComponent} from "./component/section-select.component";
import {SectionEditorDialog} from "./dialog/section-editor.dialog";



@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    //SectionModule.forRoot(),
    CovalentCoreModule.forRoot(),
    EffectsModule.run(SectionEffects),
  ],
  declarations: [
    // page
    SectionDetailPage,

    // component
    SectionListComponent,
    SectionComponent,
    SectionSelectComponent,
    

    //dialog
    SectionEditorDialog,
    

  ],
  exports: [
    SectionSelectComponent,
    SectionListComponent,
    SectionEditorDialog,
  ],
  entryComponents: [
   SectionEditorDialog,
   SectionSelectComponent,
  ],
})

export class SectionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SectionSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        SectionActions,
      ],
    };
  }
}







