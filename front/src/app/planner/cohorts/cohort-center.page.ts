import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Cohort} from "./cohort.interface";
import {CohortActions} from "./cohort.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-cohort-center',
  templateUrl: './cohort-center.page.html',
})
export class CohortCenterPage implements OnInit {

  private COHORTS = "plannerModuleState.cohorts".split(".");

  private cohorts$: Observable<Cohort[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private commonService: CommonService) {
    this.cohorts$ = this.store.select(...this.COHORTS);
  }

  goBack(route: string): void {
    this._router.navigate(['/cohorts']);
  }

  viewCohort(cohort: Cohort) {
    console.log("cohort: " + cohort.id);
    this.router.navigate(['/cohorts-detail', cohort.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this._actions.findCohorts());
  }
}

