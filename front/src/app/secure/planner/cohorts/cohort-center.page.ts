import {CohortActions} from './cohort.action';
import {CohortEditorDialog} from './dialog/cohort-editor.dialog';
import {ActivatedRoute, Router} from '@angular/router';

import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Cohort} from '../../../shared/model/planner/cohort.interface';
import {PlannerModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-cohort-center',
  templateUrl: './cohort-center.page.html',
  // changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CohortCenterPage implements OnInit {

  private COHORTS: string[] = "plannerModuleState.cohorts".split(".");
  private cohorts$: Observable<Cohort[]>;
  private creatorDialogRef: MdDialogRef<CohortEditorDialog>;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.cohorts$ = this.store.select(...this.COHORTS);
  }

  viewCohort(cohort: Cohort) {
    console.log("cohort: " + cohort.id);
    this.router.navigate(['/secure/term/cohorts-detail', cohort.id]);
  }
  
  ngOnInit(): void {
    console.log('findCohorts');
    this.store.dispatch(this.actions.findCohorts());
  }

  createDialog(): void {
    this.showDialog(null);
  }

  private showDialog(code: Cohort): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.position = {top: '1px'};
    this.creatorDialogRef = this.dialog.open(CohortEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.cohort = code;
    ;
   
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");

    });
  }

  //private columns: any[] = [
  // {name: 'code', label: 'Code'},
  //{name: 'title', label: 'Title'},
  //{name: 'description', label: 'Description'},
  //{name: 'action', label: ''}
//  ];

//  goBack(route: string): void {
//     this.router.navigate(['/cohort']);
//    }

  filter(): void {
  }

}
