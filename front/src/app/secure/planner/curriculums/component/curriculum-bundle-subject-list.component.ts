import {Store} from '@ngrx/store';
import {
  ChangeDetectionStrategy,
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChange,
  ViewContainerRef
} from '@angular/core';
import {Curriculum} from '../../../../shared/model/planner/curriculum.interface';
import {BundleSubjectPart} from '../../../../shared/model/planner/bundle-subject-part.interface';
import {BundleSubject} from '../../../../shared/model/planner/bundle-subject.interface';
import {SingleSubject} from '../../../../shared/model/planner/single-subject.interface';
import {CurriculumBundleSubjectPartDialog} from '../dialog/curriculum-bundle-subject-part.dialog';
import {CurriculumBundleSubjectDialog} from '../dialog/curriculum-bundle-subject.dialog';
import {CurriculumSingleSubjectDialog} from '../dialog/curriculum-single-subject.dialog';
import {CurriculumActions} from '../curriculum.action';
import {ActivatedRoute, Router} from '@angular/router';
import {PlannerModuleState} from '../../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Subject} from '../../../../shared/model/planner/subject.interface';

@Component({
  selector: 'pams-curriculum-bundle-subject-list',
  templateUrl: './curriculum-bundle-subject-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumSubjectListComponent implements OnInit, OnChanges {

  private selectedRows: Subject[];
  private singleSubjectDialogRef: MdDialogRef<CurriculumSingleSubjectDialog>;
  private bundleSubjectDialogRef: MdDialogRef<CurriculumBundleSubjectDialog>;
  private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'ordinal', label: 'Semester'},
    {name: 'subjectType', label: 'Type'},
    {name: 'course.code', label: 'Course'},
    {name: 'course.credit', label: 'Credit'},
    // {name: 'parts', label: 'Parts'},
    {name: 'action', label: ''},
  ];

  @Input() curriculum: Curriculum;
  @Input() subjects: Subject[];
  @Input() singleSubject: SingleSubject[];
  @Input() bundleSubject: BundleSubject[];
  @Input() bundleSubjectPart: BundleSubjectPart[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog,) {
  }

  ngOnInit(): void {
    this.selectedRows = this.subjects.filter((value) => value.selected);
  }

  ngOnChanges(changes: { [propName: string]: SimpleChange }) {
    if (changes['subjects'] && this.subjects) {
      console.log('subject length:' + this.subjects.length);
      this.subjects.forEach((s: Subject) => {
        console.log('subject: ' + s.type);
        console.log('subject: ' + s.ordinal);

        if (s.type === 'single') {
          console.log('single subject: ' + s.ordinal);
        } else if (s.type === 'bundle') {
          console.log('bundle subject: ' + s.ordinal);
        } else {
          console.log('subject');
        }
      });
    }
  }

  filter(): void {
    // no op
  }

  showSingleSubjectDialog(singleSubject: SingleSubject): void {
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.singleSubjectDialogRef = this.dialog.open(CurriculumSingleSubjectDialog, config);
    this.singleSubjectDialogRef.componentInstance.curriculum = this.curriculum;
    this.singleSubjectDialogRef.afterClosed().subscribe((res) => {
      // no op
    });

  }

  showBundleSubjectDialog(bundleSubject: BundleSubject): void {
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.bundleSubjectDialogRef = this.dialog.open(CurriculumBundleSubjectDialog, config);
    this.bundleSubjectDialogRef.componentInstance.curriculum = this.curriculum;
    this.bundleSubjectDialogRef.afterClosed().subscribe((res) => {
      // no op
    });

  }

  showBundleSubjectPartDialog(bundleSubjectPart: BundleSubjectPart) {
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.bundleSubjectPartDialogRef = this.dialog.open(CurriculumBundleSubjectPartDialog, config);
    this.bundleSubjectPartDialogRef.componentInstance.curriculum = this.curriculum;
    this.bundleSubjectPartDialogRef.afterClosed().subscribe((res) => {
      // no op
    });
  }

  selectRow(subject: Subject): void {
  }

  selectAllRows(subject: Subject[]): void {
  }

  goBack(route: string): void {
    this.router.navigate(['/subjects']);
  }
}
