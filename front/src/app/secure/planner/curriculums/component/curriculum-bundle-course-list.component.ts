import {MdSnackBar} from '@angular/material/snack-bar';
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
  selector: 'pams-curriculum-bundle-course-list',
  templateUrl: './curriculum-bundle-course-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumBndleCourseListComponent implements OnInit, OnChanges {

  private selectedRows: Subject[];
  private singleSubjectDialogRef: MdDialogRef<CurriculumSingleSubjectDialog>;
  private bundleSubjectDialogRef: MdDialogRef<CurriculumBundleSubjectDialog>;
  private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'course.code', label: 'course'},
    {name: 'action', label: ''},
  ];

  @Input() bundle: BundleSubject;
  @Input() subject: BundleSubjectPart[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog,) {
  }

  ngOnInit(): void {
    //this.selectedRows = this.subjects.filter((value) => value.selected);
  }

  ngOnChanges(changes: { [propName: string]: SimpleChange }) {
 
  }

  filter(): void {
    // no op
  }


  showBundleSubjectPartDialog(bundleSubject: BundleSubject): void {
    console.log("open bundle : "+this.bundle.subjectType);
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '30%';
    config.height = '30%';
    config.position = { top: '65px' };
    this.bundleSubjectPartDialogRef = this.dialog.open(CurriculumBundleSubjectPartDialog, config);
    this.bundleSubjectPartDialogRef.componentInstance.bundleSubject = this.bundle;
    this.bundleSubjectPartDialogRef.afterClosed().subscribe((res) => {
      // no op
    });

  }

   deleteSubject( subject:Subject): void {
        if ( subject.id) {
            console.log( "Don't delete this Subject" ); //try to print at console
            let snackBarRef = this.snackBar.open( 'Subject cannot be deleted', 'OK' );
        } else {
            console.log( 'deleteSubject' ); // move on
           // this.store.dispatch( this.actions.deleteSubject( this.curriculum, subject ) );
        }
    }

  selectRow(subject: Subject): void {
  }

  selectAllRows(subject: Subject[]): void {
  }
  goBack(route: string): void {
    this.router.navigate(['/subjects']);
  }
}


