import {FormBuilder} from '@angular/forms';
import {TermModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {AssessmentActions} from '../../assessments/assessment.action';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Assessment} from '../../../../shared/model/term/assessment.interface';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {AssessmentEditorDialog} from '../../assessments/dialog/assessment-creator.dialog';

@Component({
  selector: 'pams-offering-assessment-list',
  templateUrl: './offering-assessment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingAssessmentListComponent implements OnInit {

  private selectedRows: Assessment[];
  private editorDialogRef: MdDialogRef<AssessmentEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'weight', label: 'Weight %'},
    {name: 'assessmentType', label: 'Assessment Type'},
    {name: 'assessmentCategory', label: 'Assessment Category'},
    {name: 'action', label: ''},
  ];

  @Input() offering: Offering;
  @Input() assessments: Assessment[];
  @Output() view = new EventEmitter<Assessment>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AssessmentActions,
              private store: Store<TermModuleState>,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,) {
  }

  ngOnInit(): void {
    this.selectedRows = this.assessments.filter((value) => value.selected);
  }

  filter(): void {
  }

  selectRow(assessment: Assessment): void {
  }

  selectAllRows(assessments: Assessment[]): void {
  }

  createDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AssessmentEditorDialog, config);
    this.editorDialogRef.componentInstance.offering = this.offering;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  updateAssessment(assessment: Assessment, isValid: boolean): void {
    console.log('Assessment:{}', assessment);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AssessmentEditorDialog, config);
    if (isValid) {
      this.editorDialogRef.componentInstance.assessment = assessment;
      this.editorDialogRef.componentInstance.offering = this.offering;

    }
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  deleteAssessment(assessment: Assessment): void {
    this.store.dispatch(this.actions.deleteAssessment(this.offering, assessment));
    console.log('deleteAssessment:{}', assessment);
  }
}

