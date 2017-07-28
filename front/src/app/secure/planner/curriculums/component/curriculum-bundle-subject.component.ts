import {CurriculumBundleSubjectDialog} from '../dialog/curriculum-bundle-subject.dialog';
import {BundleSubject} from '../../../../shared/model/planner/bundle-subject.interface';

import {PlannerModuleState} from '../../index';
import {Subject} from '../../../../shared/model/planner/subject.interface';
import {ChangeDetectionStrategy, Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {CurriculumActions} from '../curriculum.action';

@Component({
  selector: 'pams-curriculum-bundle-subject',
  templateUrl: './curriculum-bundle-subject.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class BundleSubjectComponent implements OnInit {

  private curriculum: any;
  private bundleSubjectDialogRef: MdDialogRef<CurriculumBundleSubjectDialog>;
  private selectedRows: BundleSubject[];
  private bundleSubjectColumns: any[] = [
    {name: 'course', label: 'course'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'action', label: ''},
  ];

  @Input() bundleSubject: BundleSubject[];
  @Input() subject: Subject;

  constructor(private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.bundleSubject.filter((value) => value.selected);
  }

  delete(): void {
    console.log('length: ' + this.selectedRows.length);
    for (let i: number = 0; i < this.selectedRows.length; i++) {
      //   this.store.dispatch(this.actions.deleteSubject(this.subject, this.selectedRows[i]));
    }
    this.selectedRows = [];
  }

  edit(bundleSubject: BundleSubject): void {
    this.showDialog(bundleSubject);
  }

  selectRow(bundleSubject: BundleSubject): void {
  }

  selectAllRows(bundleSubject: BundleSubject[]): void {
  }

  showDialog(bundleSubject: BundleSubject): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.bundleSubjectDialogRef = this.dialog.open(CurriculumBundleSubjectDialog, config);
    this.bundleSubjectDialogRef.componentInstance.curriculum = this.curriculum;
    this.bundleSubjectDialogRef.afterClosed().subscribe((res) => {
    });
  }
}
