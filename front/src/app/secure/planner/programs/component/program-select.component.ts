import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {ProgramActions} from '../program.action';
import {Program} from '../../../../shared/model/planner/program.interface';
import {PlannerModuleState} from '../../index';

@Component({
  selector: 'pams-program-select',
  templateUrl: './program-select.component.html',
  styleUrls: ['./program-select.component.scss'],
})
export class ProgramSelectComponent implements OnInit {

  private PROGRAMS: string[] = 'plannerModuleState.programs'.split('.');

  private programs$: Observable<Program[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: ProgramActions) {
    this.programs$ = this.store.select(...this.PROGRAMS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findPrograms());
  }

  selectChangeEvent(event: Program) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

