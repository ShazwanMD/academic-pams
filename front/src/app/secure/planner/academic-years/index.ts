import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {AcademicYearActions} from './academic-year.action';
import {CommonService, IdentityService, PlannerService} from '../../../../services';
import {AcademicYearSelectComponent} from './component/academic-year-select.component';
import {AcademicYearCenterPage} from './academic-year-center.page';
import {AcademicYearDetailPage} from './academic-year-detail.page';
import { AcademicSessionCreatorDialog } from "../academic-sessions/dialog/academic-session-creator.dialog";
import { AcademicYearCreatorDialog } from "./dialog/academic-year-creator.dialog";
import {AcademicYearListComponent} from './component/academic-year-list.component';
import { AcademicYearComponent } from "./component/academic-year.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
   //effects for academicYear
  ],
  declarations: [
    // page
    AcademicYearCenterPage,
    AcademicYearDetailPage,

    // component
    AcademicYearSelectComponent,
    AcademicYearListComponent,
    AcademicYearComponent,

    // dialog
    AcademicYearCreatorDialog,
  ],
  exports: [
    AcademicYearSelectComponent,

  ],

  entryComponents: [
    AcademicYearSelectComponent,
    AcademicYearCreatorDialog,
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

