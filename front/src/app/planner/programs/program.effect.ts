import { Program } from './program.interface';
import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ProgramActions} from "./program.action";
import {PlannerService} from "../../../services/planner.service";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {PlannerModuleState} from "../index";


@Injectable()
export class ProgramEffects {
  constructor(private actions$: Actions,
              private programActions: ProgramActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findPrograms$ = this.actions$
    .ofType(ProgramActions.FIND_PROGRAMS)
    .switchMap(() => this.plannerService.findPrograms())
    .map(programs => this.programActions.findProgramsSuccess(programs));

  @Effect() findProgram$ = this.actions$
    .ofType(ProgramActions.FIND_PROGRAM)
    .map(action => action.payload)
    .switchMap(code => this.plannerService.findProgram(code))
    .map(program => this.programActions.getProgramSuccess(program));

  @Effect() saveProgram$ = this.actions$
    .ofType(ProgramActions.SAVE_PROGRAM)
    .map(action => action.payload)
    .switchMap(program => this.plannerService.saveProgram(program))
    .map(program => this.programActions.saveProgramSuccess(program));
   // .map(() => this.programActions.findPrograms())

  @Effect() updateProgram$ = this.actions$
    .ofType(ProgramActions.UPDATE_PROGRAM)
    .map(action => action.payload)
    .switchMap(program => this.plannerService.updateProgram(program))
    .map(program => this.programActions.updateProgramSuccess(program));


 @Effect() activateProgram$ = this.actions$
    .ofType(ProgramActions.ACTIVATE_PROGRAM)
    .map(action => action.payload)
    .switchMap(program => this.plannerService.activateProgram(program))
    .map(message => this.programActions.activateProgramSuccess(message))
    // .withLatestFrom(this.store$.select(...this.PROGRAM))
    // .map(state => state[1])
    // .map((program: Program) => this.programActions.findProgram(program.code));


  @Effect() deactivateProgram$ = this.actions$
    .ofType(ProgramActions.DEACTIVATE_PROGRAM)
    .map(action => action.payload)
    .switchMap(program => this.plannerService.deactivateProgram(program))
    // .map(message => this.programActions.deactivateProgramSuccess(message))
    // .withLatestFrom(this.store$.select(...this.PROGRAM))
    // .map(state => state[1])
    // .map((program: Program) => this.programActions.findProgram(program.code));

}

  // @Effect() createProgram = this.actions$
  //   .ofType(ProgramActions.CREATE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.plannerService.saveProgram(program))
  //   .map(program => this.programActions.addProgramSuccess(program));
  //
  // @Effect() deleteProgram$ = this.actions$
  //   .ofType(ProgramActions.DELETE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.plannerService.deleteProgram(program))
  //   .map(program => this.programActions.deleteProgramSuccess(program));
