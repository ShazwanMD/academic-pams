import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Cohort} from "./cohort.interface";
import {CohortActions} from "./cohort.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-cohort-detail',
  templateUrl: './cohort-detail.page.html',
})

export class CohortDetailPage implements OnInit {

  private COHORT = "plannerModuleState.cohort".split(".");
  private cohort$: Observable<Cohort>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>) {

    this.cohort$ = this.store.select(...this.COHORT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {code: string}) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCohort(code));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/cohorts']);
  }
}

