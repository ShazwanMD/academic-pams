import { Program } from './../program.interface';
import {Observable} from "rxjs";
import { ProgramLevel } from './../program-level.interface';
import { Store } from '@ngrx/store';

import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import { ProgramActions } from "../program.action";
import { PlannerModuleState } from "../../index";


@Component({
  selector: 'pams-program-level-select',
  templateUrl: './program-level-select.component.html',
})
export class ProgramLevelSelectComponent implements OnInit {

 private PROGRAMLEVELS: string[] = "plannerModuleState.programs".split(".");

   programLevels$: Observable<ProgramLevel>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: ProgramActions) {

        this.programLevels$ = this.store.select(...this.PROGRAMLEVELS);

  }

 ngOnInit() {
    // this.store.dispatch(this.actions.findProgramLevelByCode(code));
  }

  selectChangeEvent(event: ProgramLevel) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
