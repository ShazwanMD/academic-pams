import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {from} from "rxjs/observable/from";
import {IdentityService} from "../../../services/identity.service";
import {ActorActions} from "./actor.action";
import {StudentActions} from "../student.action";
import {StaffActions} from "./staff.action";


@Injectable()
export class ActorEffects {
  constructor(private actions$: Actions,
              private actorActions: ActorActions,
              private studentActions: StudentActions,
              private staffActions: StaffActions,
              private identityService: IdentityService) {
  }

  @Effect() findActors$ = this.actions$
    .ofType(ActorActions.FIND_ACTORS)
    .switchMap(() => this.identityService.findActors())
    .map(actors => this.actorActions.findActorsSuccess(actors));

  @Effect() findActor$ = this.actions$
    .ofType(ActorActions.FIND_ACTOR)
    .map(action => action.payload)
    .switchMap(code => this.identityService.findActorByIdentityNo(code))
    .map(actor => this.actorActions.findActorSuccess(actor));

  @Effect() saveActor$ = this.actions$
    .ofType(ActorActions.SAVE_ACTOR)
    .map(action => action.payload);
  // todo

  @Effect() updateActor$ = this.actions$
    .ofType(ActorActions.UPDATE_ACTOR)
    .map(action => action.payload);
  // todo

  @Effect() findStudents$ = this.actions$
    .ofType(StudentActions.FIND_STUDENTS)
    .switchMap(() => this.identityService.findStudents())
    .map(students => this.studentActions.findStudentsSuccess(students));

  @Effect() findStudent$ = this.actions$
    .ofType(StudentActions.FIND_STUDENT)
    .map(action => action.payload)
    .switchMap(code => this.identityService.findStudentByIdentityNo(code))
    .map(student => this.studentActions.findStudentSuccess(student));

  @Effect() findStaffs$ = this.actions$
    .ofType(StaffActions.FIND_STAFFS)
    .switchMap(() => this.identityService.findStaffs())
    .map(staffs => this.staffActions.findStaffsSuccess(staffs));

  @Effect() findStaff$ = this.actions$
    .ofType(StaffActions.FIND_STAFF)
    .map(action => action.payload)
    .switchMap(code => this.identityService.findStaffByIdentityNo(code))
    .map(staff => this.staffActions.findStaffSuccess(staff));
}
