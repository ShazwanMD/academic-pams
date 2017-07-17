import { ActorSelectComponent } from './component/actor-select.component';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { appRoutes, appRoutingProviders } from '../app.routes';
import { CovalentCoreModule } from '@covalent/core';
import { CommonService } from '../../services';
import { IdentityService } from '../../services';
import { IdentityComponent } from "./identity.component";
import { StaffSubModule } from "./staffs/index";

import { studentListReducer, StudentListState } from "./student-list.reducer";
import { actorListReducer, ActorListState } from "./actor-list.reducer";
import { staffListReducer, StaffListState } from "./staff-list.reducer";
import { staffReducer, StaffState } from "./staffs/staff.reducer";
import { StudentSelectComponent } from "./component/student-select.component";
import { StaffSelectComponent } from "./component/staff-select.component";
import { StudentActions } from "./student.action";
import { StaffActions } from "./staff.action";
import { ActorActions } from "./actor.action";
import { ActorEffects } from "./actor.effect";
import { EffectsModule } from "@ngrx/effects";
import {StaffAppointmentListState, staffAppointmentListReducer} from './staffs/staff-appointment-list.reducer';
import {Appointment} from '../term/appointments/appointment.interface';
import { Staff } from "./staffs/staff.interface";

export interface IdentityModuleState {
    actors: ActorListState;
    students: StudentListState;
    staffs: StaffListState;
    staff: StaffState;
    staffAppointments: StaffAppointmentListState;
}
;

export const INITIAL_IDENTITY_STATE: IdentityModuleState = <IdentityModuleState>{
    actors: [],
    students: [],
    
    staffs: <Staff[]>[],
    staff: <Staff>{},
    staffAppointments: <Appointment[]>[],
};

export const identityModuleReducers = {
    actors: actorListReducer,
    students: studentListReducer,
    staffs: staffListReducer,
    staff: staffReducer,
    staffAppointments: staffAppointmentListReducer,
};


@NgModule( {
    imports: [
        appRoutes,
        BrowserModule,
        ReactiveFormsModule,
        CovalentCoreModule.forRoot(),
        StaffSubModule.forRoot(),
        EffectsModule.run( ActorEffects ),
    ],
    declarations: [
        IdentityComponent,
        StudentSelectComponent,
        StaffSelectComponent,
        ActorSelectComponent,

    ],
    exports: [
        IdentityComponent,
        StudentSelectComponent,
        StaffSelectComponent,
        ActorSelectComponent,

    ],
} )
export class IdentityModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: IdentityModule,
            providers: [
                appRoutingProviders,
                IdentityService,
                CommonService,
                ActorActions,
                StudentActions,
                StaffActions,
            ],
        };
    }
}
