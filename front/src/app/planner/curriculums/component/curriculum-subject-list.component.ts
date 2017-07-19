import {SubjectCreatorDialog} from '../../subjects/dialog/subject-creator.dialog';
import {CurriculumActions} from '../curriculum.action';
import {
  Component, Input, ChangeDetectionStrategy, OnInit, Output, EventEmitter, ViewContainerRef,
} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdSnackBar} from '@angular/material';
import {Curriculum} from '../curriculum.interface';
import {Subject} from '../subject.interface';

@Component({
  selector: 'pams-curriculum-subject-list',
  templateUrl: './curriculum-subject-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumSubjectListComponent implements OnInit {

  private creatorDialogRef: MdDialogRef<SubjectCreatorDialog>;
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'type', label: 'Type'},
    {name: 'course.code', label: 'Course'},
    {name: 'parts', label: 'Parts'},
    {name: 'action', label: ''},
  ];

  @Input() curriculum: Curriculum;
  @Input() subjects: Subject[];
  @Output() view: EventEmitter<Subject> = new EventEmitter<Subject>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {
  }

  filter(): void {
    // no op
  }

  selectRow(subject: Subject): void {
  }

  selectAllRows(subject: Subject[]): void {
  }

  editDialog(subject: Subject, isValid: boolean): void {
    console.log('Subject:{}', subject);
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SubjectCreatorDialog, config);
    if (isValid) {
      this.creatorDialogRef.componentInstance.subject = subject;
      this.creatorDialogRef.componentInstance.curriculum = this.curriculum;

    }
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog section');
      // load something here
    });
  }

  addSubjectDialog(): void {
    console.log('showDialog');
    let config: MdDialogConfig = new MdDialogConfig();
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
