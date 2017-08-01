import {BundleSubjectPart} from '../../../../shared/model/planner/bundle-subject-part.interface';
import {CurriculumBundleSubjectPartDialog} from '../dialog/curriculum-bundle-subject-part.dialog';
import {BundleSubject} from '../../../../shared/model/planner/bundle-subject.interface';

import {PlannerModuleState} from '../../index';
import {Subject} from '../../../../shared/model/planner/subject.interface';
import {ChangeDetectionStrategy, Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {CurriculumActions} from '../curriculum.action';

@Component({
  selector: 'pams-curriculum-bundle-subject-part',
  templateUrl: './curriculum-bundle-subject-part.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class BundleSubjectPartComponent implements OnInit {

  private curriculum: any;
  private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;
  private selectedRows: BundleSubjectPart[];
  private bundleSubjectPartColumns: any[] = [
    {name: 'course', label: 'course'},
    {name: 'action', label: ''},
  ];

  @Input() bundleSubjectPart: BundleSubjectPart[];
  @Input() subject: Subject;

  constructor(private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.bundleSubjectPart.filter((value) => value.selected);
  }

  delete(): void {
    console.log('length: ' + this.selectedRows.length);
    for (let i: number = 0; i < this.selectedRows.length; i++) {
      //   this.store.dispatch(this.actions.deleteSubject(this.subject, this.selectedRows[i]));
    }
    this.selectedRows = [];
  }

  edit(bundleSubjectPart: BundleSubjectPart): void {
    this.showDialog(bundleSubjectPart);
  }

  selectRow(bundleSubjectPart: BundleSubjectPart): void {
  }

  selectAllRows(bundleSubjectPart: BundleSubjectPart[]): void {
  }

  showDialog(bundleSubjectPart: BundleSubjectPart): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.bundleSubjectPartDialogRef = this.dialog.open(CurriculumBundleSubjectPartDialog, config);
    this.bundleSubjectPartDialogRef.componentInstance.curriculum = this.curriculum;
    this.bundleSubjectPartDialogRef.afterClosed().subscribe((res) => {
    });
  }
}
