import {SubjectCreatorDialog} from '../../subjects/dialog/subject-creator.dialog';
import {CurriculumEditorDialog} from '../dialog/curriculum-editor.dialog';
import {CurriculumActions} from '../curriculum.action';

import { SubjectEditorDialog} from '../../subjects/dialog/subject-editor.dialog';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import { MdSnackBar } from '@angular/material';
import {Curriculum} from '../curriculum.interface';
import {Subject} from '../../subjects/subject.interface';

@Component({
  selector: 'pams-curriculum-subject-list',
  templateUrl: './curriculum-subject-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumSubjectListComponent implements OnInit {

  private selectedRows: Subject[];
  private creatorDialogRef: MdDialogRef<SubjectCreatorDialog>;

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'ordinal', label: 'Ordinal'},
    {name:'subjectType', label: 'SubjectType'},
    {name: 'curriculum.code', label: 'Code'},
    {name: 'action', label: ''},
  ];

  @Input() curriculum: Curriculum;
  @Input() subject: Subject;
  @Input() subjects: Subject[];
  @Output() view = new EventEmitter<Subject>();


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {
    this.selectedRows = this.subjects.filter((value) => value.selected);
  }

  filter(): void {
  }

  selectRow(subject: Subject): void {
  }

  selectAllRows(subject: Subject[]): void {
  }

  editDialog(subject: Subject, isValid: boolean): void {
    console.log('Subject:{}', subject);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SubjectCreatorDialog, config);
    if (isValid) {
      this.creatorDialogRef .componentInstance.subject = subject;
      this.creatorDialogRef .componentInstance.curriculum = this.curriculum;

    }
    this.creatorDialogRef .afterClosed().subscribe((res) => {
      console.log('close dialog section');
      // load something here
    });
  }

    addSubjectDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SubjectCreatorDialog, config);
    this.creatorDialogRef.componentInstance.curriculum = this.curriculum;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  goBack(route: string): void {
      this.router.navigate(['/subjects']);
    }
}
