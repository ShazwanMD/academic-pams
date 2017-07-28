import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Cohort} from '../../../shared/model/planner/cohort.interface';
import {CohortActions} from './cohort.action';
import {PlannerModuleState} from '../index';
import {MdDialog, MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-cohort-detail',
  templateUrl: './cohort-detail.page.html',
})

export class CohortDetailPage implements OnInit {
  @Input() cohorts: Cohort[];
  private COHORT: string[] = "plannerModuleState.cohort".split(".");
  private cohort$: Observable<Cohort>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

    this.cohort$ = this.store.select(...this.COHORT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCohortByCode(code));
    });
  }

  // goBack(route: string): void {
  // this.router.navigate(['/cohorts']);
}

// filter(): void {




