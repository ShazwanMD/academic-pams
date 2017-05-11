import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {IdentityComponent} from "./identity.component";
import {studentListReducer, StudentListState} from "./student-list.reducer";
import {actorListReducer, ActorListState} from "./actor-list.reducer";
import {staffListReducer, StaffListState} from "./staff-list.reducer";

export interface IdentityModuleState {
  actors: ActorListState;
  students: StudentListState;
  staffs: StaffListState;
}
;

export const INITIAL_IDENTITY_STATE: IdentityModuleState = <IdentityModuleState>{};
export const identityModuleReducers = {
  actors: actorListReducer,
  students: studentListReducer,
  staffs: staffListReducer,
};


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,
  ],
  declarations: [
    IdentityComponent,
  ],
  exports: [],
})
export class IdentityModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: IdentityModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService
      ],
    };
  }
}
