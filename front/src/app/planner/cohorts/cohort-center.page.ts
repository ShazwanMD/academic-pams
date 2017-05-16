import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Cohort} from "./cohort.interface";
import {PlannerModuleState} from "../index";
import {CohortActions} from "./cohort.action";
import {CohortEditorDialog} from "./dialog/cohort-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";


@Component({
    selector: 'pams-cohort-center',
    templateUrl: './cohort-center.page.html',
})
export class CohortCenterPage implements OnInit {

    private cohorts$: Observable<Cohort[]>;
    private COHORTS = "plannerModuleState.cohorts".split(".");
    private creatorDialogRef: MdDialogRef<CohortEditorDialog>;


    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: CohortActions,
        private store: Store<PlannerModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
        this.cohorts$ = this.store.select(...this.COHORTS);
    }

    goBack(route: string): void {
        this.router.navigate(['/planner/cohorts']);
    }

    viewCohort(cohort: Cohort) {
        console.log("cohort: " + cohort.id);
        this.router.navigate(['/cohorts-detail', cohort.id]);
    }
    showDialog(): void {
        console.log("showDialog");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '65%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open(CohortEditorDialog, config);
        this.creatorDialogRef.afterClosed().subscribe(res => {
            console.log("close dialog");
            // load something here
        })
    };

    ngOnInit(): void {
        console.log("find cohorts");
        this.store.dispatch(this.actions.findCohorts());
    }
}

