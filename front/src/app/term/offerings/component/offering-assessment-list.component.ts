import {FormBuilder} from '@angular/forms';
import {TermModuleState} from './../../index';
import {Store} from '@ngrx/store';
import {AssessmentCreatorDialog} from './../../assessments/dialog/assessment-creator.dialog';
import {AssessmentActions} from './../../assessments/assessment.action';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Assessment} from '../../assessments/assessment.interface';
import {Offering} from "../offering.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'pams-offering-assessment-list',
  templateUrl: './offering-assessment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingAssessmentListComponent {

  @Input() offering: Offering;
  @Input() assessments: Assessment[];
  @Output() view = new EventEmitter<Assessment>();

  private creatorDialogRef: MdDialogRef<AssessmentCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AssessmentActions,
              private store: Store<TermModuleState>,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,) {
  }

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'canonicalCode', label: 'Canonical Code'},
    {name: 'assessmentType', label: 'Assessment Type'},
    {name: 'assessmentCategory', label: 'Assessment Category'},
    {name: 'action', label: ''}
  ];

  addAssessmentDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AssessmentCreatorDialog, config);
    this.creatorDialogRef.componentInstance.offering = this.offering;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  updateAssessment(assessment: Assessment, isValid: boolean): void {
    console.log("Assessment:{}", assessment)
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AssessmentCreatorDialog, config);
    if (isValid) {
      this.creatorDialogRef.componentInstance.assessment = assessment;
      this.creatorDialogRef.componentInstance.offering = this.offering;

    }
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  deleteAssessment(assessment: Assessment): void {
    this.store.dispatch(this.actions.deleteAssessment(this.offering, assessment))
    console.log("deleteAssessment:{}", assessment)
  }
}

