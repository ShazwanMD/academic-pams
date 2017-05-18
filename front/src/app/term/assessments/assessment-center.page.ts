import { TermModuleState } from './../index';
import { AssessmentActions } from './assessment.action';
import { Assessment } from './assessment.interface';
import { TermService } from './../../../services/term.service';
import { Component, OnInit, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CommonService } from '../../../services';
import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";

@Component({
    selector: 'pams-assessment-center',
    templateUrl: './assessment-center.page.html',
})

export class AssessmentCenterPage implements OnInit {
    private ASSESSMENTS = "termModuleState.assessments".split(".");
    private assessments$: Observable<Assessment[]>;

        constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: AssessmentActions,
        private store: Store<TermModuleState>) {
        this.assessments$ = this.store.select(...this.ASSESSMENTS);
    }


  ngOnInit():void {
    this.store.dispatch(this.actions.findAssessments());
   }
   

}
