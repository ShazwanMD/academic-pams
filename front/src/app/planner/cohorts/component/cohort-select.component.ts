import { CohortActions } from './../cohort.action';
import { PlannerModuleState } from './../../index';
import { FormControl } from '@angular/forms';
import { Component, Input, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Rx';
import { Cohort } from './../cohort.interface';

@Component({
    selector: 'pams-cohort-select',
    templateUrl:'./cohort-select.component.html'
})
export class CohortSelectComponent implements OnInit {
    @Input() placeholder : string;
    @Input() innerFormControl: FormControl;
    private COHORTS: string[] = "plannerModuleState.cohorts".split(".");
    cohorts$: Observable<Cohort[]>;

  constructor(private store: Store<PlannerModuleState>,
              private actions: CohortActions) {
    this.cohorts$ = this.store.select(...this.COHORTS);
  }
   ngOnInit() {
    this.store.dispatch(this.actions.findCohorts());
  }

  selectChangeEvent(event: Cohort) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
