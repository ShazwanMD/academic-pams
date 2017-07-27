import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {ProgramLevel} from '../../../shared/model/planner/program-level.interface';
import {PlannerModuleState} from '../../index';
import {ProgramLevelActions} from '../program-level.action';

@Component({
  selector: 'pams-program-level-select',
  templateUrl: './program-level-select.component.html',
})
export class ProgramLevelSelectComponent implements OnInit {

  private PROGRAM_LEVELS: string[] = 'plannerModuleState.programLevels'.split('.');
  private programLevels$: Observable<ProgramLevel[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: ProgramLevelActions) {
    this.programLevels$ = this.store.select(...this.PROGRAM_LEVELS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findProgramLevels());
  }

  selectChangeEvent(event: ProgramLevel) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
