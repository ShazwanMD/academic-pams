import { PlannerModuleState } from './../../index';
import { Observable } from 'rxjs';
import { ProgramActions } from './../program.action';
import { Store } from '@ngrx/store';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Program} from "../program.interface";

@Component({
  selector: 'pams-program-list',
  templateUrl: './program-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramListComponent {


 private PROGRAMS:string[] = "plannerModuleState.bankCodes".split(".");
 private programs$: Observable<Program>;
  @Input() programs: Program[];
  @Output() view = new EventEmitter<Program>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleMs', label: 'TitleMs'},
    {name: 'action', label: ''}
  ];

 constructor(private store: Store<PlannerModuleState>,
              private actions: ProgramActions) {
   this.programs$ = this.store.select(...this.PROGRAMS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findPrograms());

  }

  filter(): void {
  }
}