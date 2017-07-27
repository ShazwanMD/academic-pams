import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ProgramLevelActions} from './program-level.action';
import {PlannerService} from '../../../services/planner.service';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../index';
import {ProgramLevel} from '../../shared/model/planner/program-level.interface';

@Injectable()
export class ProgramLevelEffects {

  private PROGRAM_LEVEL: string[] = 'plannerModuleState.programLevel'.split('.');

  constructor(private actions$: Actions,
              private programLevelActions: ProgramLevelActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findProgramLevels$ = this.actions$
    .ofType(ProgramLevelActions.FIND_PROGRAM_LEVELS)
    .switchMap(() => this.plannerService.findProgramLevels())
    .map((programLevels) => this.programLevelActions.findProgramLevelsSuccess(programLevels));

  @Effect() findProgramLevelByCode$ = this.actions$
    .ofType(ProgramLevelActions.FIND_PROGRAM_LEVEL_BY_CODE)
    .map((action) => action.payload)
    .switchMap((code) => this.plannerService.findProgramLevelByCode(code))
    .map((programLevel) => this.programLevelActions.findProgramLevelByCodeSuccess(programLevel));

  @Effect() activateProgramLevel$ = this.actions$
    .ofType(ProgramLevelActions.ACTIVATE_PROGRAM_LEVEL)
    .map((action) => action.payload)
    .switchMap((programLevel) => this.plannerService.activateProgramLevel(programLevel))
    .map((message) => this.programLevelActions.activateProgramLevelSuccess(message))
    .withLatestFrom(this.store$.select(...this.PROGRAM_LEVEL))
    .map((state) => state[1])
    .map((programLevel: ProgramLevel) => this.programLevelActions.findProgramLevelByCode(programLevel.code));

  @Effect() deactivateProgramLevel$ = this.actions$
    .ofType(ProgramLevelActions.DEACTIVATE_PROGRAM_LEVEL)
    .map((action) => action.payload)
    .switchMap((programLevel) => this.plannerService.deactivateProgramLevel(programLevel))
    .map((message) => this.programLevelActions.deactivateProgramLevelSuccess(message))
    .withLatestFrom(this.store$.select(...this.PROGRAM_LEVEL))
    .map((state) => state[1])
    .map((programLevel: ProgramLevel) => this.programLevelActions.findProgramLevelByCode(programLevel.code));

}
