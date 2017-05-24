import { ProgramStatusComponent } from './program-status.component';
import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {ProgramActions} from "../program.action";
import {Program} from "../program.interface";
import {PlannerModuleState} from "../../index";
// import { ProgramStatus } from "../program-status.enum";


@Component({
  selector: 'pams-program-select',
  templateUrl: './program-select.component.html',
})
export class ProgramSelectComponent implements OnInit {
  
  // private programStatus:ProgramStatus[]=<ProgramStatus[]>[];
  private PROGRAMS: string[] = "plannerModuleState.programs".split(".");

  private programs$: Observable<Program[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: ProgramActions) {
    this.programs$ = this.store.select(...this.PROGRAMS);
    //  for (var n in ProgramStatus) {
    //   if(typeof ProgramStatus[n] === 'string')
    //     this.programStatus.push(ProgramStatus[n.toString()]);
    // }
     }
  ngOnInit() {
    this.store.dispatch(this.actions.findPrograms());
  }

  selectChangeEvent(event: Program) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

