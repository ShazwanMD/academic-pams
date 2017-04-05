import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Cohort} from "./cohort.interface";
import {CohortActions} from "./cohort.action";
import {PlannerState} from "../index";

@Component({
  selector: 'pams-cohort-center',
  templateUrl: './cohort-center.page.html',
})

export class CohortCenterPage implements OnInit {

  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: CohortActions;
  private store: Store<PlannerState>;
  private cohorts$: Observable<Cohort[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: CohortActions,
              store: Store<PlannerState>,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.cohorts$ = this.store.select('cohorts');
  }

  goBack(route: string): void {
    this._router.navigate(['/cohorts']);
  }

  viewCohort(cohort: Cohort) {
    console.log("cohort: " + cohort.id);
    this._router.navigate(['/cohorts-detail', cohort.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this._actions.findCohorts());
  }
}

