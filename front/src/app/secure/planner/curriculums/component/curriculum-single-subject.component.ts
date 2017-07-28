import {CurriculumSingleSubjectDialog} from '../dialog/curriculum-single-subject.dialog';

import {PlannerModuleState} from '../../index';
import {Subject} from '../../../../shared/model/planner/subject.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {SingleSubject} from '../../../../shared/model/planner/single-subject.interface';
import {CurriculumActions} from '../curriculum.action';

@Component({
  selector: 'pams-curriculum-single-subject',
  templateUrl: './curriculum-single-subject.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SingleSubjectComponent implements OnInit {
  private curriculum: any;
  private singleSubjectDialogRef: MdDialogRef<CurriculumSingleSubjectDialog>;
  private selectedRows: SingleSubject[];
  private singleSubjectColumns: any[] = [
    {name: 'course', label: 'course'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'action', label: ''},
  ];
  @Input() singleSubject: SingleSubject[];
  @Input() subject: Subject;

  constructor(private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.singleSubject.filter((value) => value.selected);
  }

  delete(): void {
    console.log('length: ' + this.selectedRows.length);
    for (let i: number = 0; i < this.selectedRows.length; i++) {
      //   this.store.dispatch(this.actions.deleteSubject(this.subject, this.selectedRows[i]));
    }
    this.selectedRows = [];
  }

  edit(singleSubject: SingleSubject): void {
    this.showDialog(singleSubject);
  }

  selectRow(singleSubject: SingleSubject): void {
  }

  selectAllRows(singleSubject: SingleSubject[]): void {
  }

  showDialog(singleSubject: SingleSubject): void {
    console.log('showDialog');
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.singleSubjectDialogRef = this.dialog.open(CurriculumSingleSubjectDialog, config);
    this.singleSubjectDialogRef.componentInstance.curriculum = this.curriculum;
    this.singleSubjectDialogRef.afterClosed().subscribe((res) => {
    });
  }
}
