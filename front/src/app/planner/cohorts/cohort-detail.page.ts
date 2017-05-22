import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {CohortUpdateDialog} from './dialog/cohort-update.dialog';
import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Cohort} from "./cohort.interface";
import {CohortActions} from "./cohort.action";
import {PlannerModuleState} from "../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ViewContainerRef} from '@angular/core';


@Component({
  selector: 'pams-cohort-detail',
  templateUrl: './cohort-detail.page.html',
})

export class CohortDetailPage implements OnInit {

  private COHORT: string[] = "plannerModuleState.cohort".split(".");
  private cohort$: Observable<Cohort>;
    private creatorDialogRef: MdDialogRef<CohortUpdateDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.cohort$ = this.store.select(...this.COHORT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCohortByCode(code));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/cohorts']);
  }

  filter(): void {
  }

    showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(CohortUpdateDialog, config);
   
    };
}


