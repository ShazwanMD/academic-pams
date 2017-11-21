import {AfterViewInit} from '@angular/core';
import {CurriculumBundleElectiveDialog} from '../dialog/curriculum-bundle-elective.dialog';
import {MdSnackBar} from '@angular/material/snack-bar';
import { Store } from '@ngrx/store';
import {
  ChangeDetectionStrategy,
  Component,
  Input,
  OnChanges,
  EventEmitter,
  Output,
  OnInit,
  SimpleChange,
  ViewContainerRef
} from '@angular/core';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
} from '@covalent/core';
import { Curriculum } from '../../../../shared/model/planner/curriculum.interface';
import { BundleSubjectPart } from '../../../../shared/model/planner/bundle-subject-part.interface';
import { BundleSubject } from '../../../../shared/model/planner/bundle-subject.interface';
import { SingleSubject } from '../../../../shared/model/planner/single-subject.interface';
import { CurriculumBundleSubjectPartDialog } from '../dialog/curriculum-bundle-subject-part.dialog';
import { CurriculumBundleSubjectDialog } from '../dialog/curriculum-bundle-subject.dialog';
import { CurriculumSingleSubjectDialog } from '../dialog/curriculum-single-subject.dialog';
import { CurriculumActions } from '../curriculum.action';
import { ActivatedRoute, Router } from '@angular/router';
import { PlannerModuleState } from '../../index';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { Subject } from '../../../../shared/model/planner/subject.interface';

@Component({
  selector: 'pams-curriculum-bundle-subject-list',
  templateUrl: './curriculum-bundle-subject-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumBundleSubjectListComponent implements OnInit, OnChanges, AfterViewInit{

  private selectedRows: Subject[];
  private bundleSubjectDialogRef: MdDialogRef<CurriculumBundleSubjectDialog>;
  private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;
   private bundleElectiveDialogRef: MdDialogRef<CurriculumBundleElectiveDialog>;
 private numPart: Number;//Variable for subject part array
 private refreshCurriculum: boolean = false;

  private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'ordinal', label: 'Semester' },
    { name: 'subjectType', label: 'Type' },
    { name: 'subjectElectiveStatus', label: 'Status' },
    // { name: 'course.code', label: 'Course' },
    // { name: 'course.credit', label: 'Credit' },
    // {name: 'parts', label: 'Parts'},
    { name: 'action', label: '' },
  ];

  filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'id';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;


  @Input() curriculum: Curriculum;
  @Input() subjects: Subject[];
  @Output() view: EventEmitter<Subject> = new EventEmitter<Subject>();

 constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog,
              private _dataTableService: TdDataTableService) {
  }

  
  ngOnInit(): void {
    this.selectedRows = this.subjects.filter((value) => value.selected);
  }

  ngOnChanges(changes: { [propName: string]: SimpleChange }) {
    this.selectedRows = [];
    if(this.refreshCurriculum == true) {
    this.store.dispatch(this.actions.findSubjectsByCurriculum(this.curriculum));
    this.store.dispatch(this.actions.findSubjectsByCurriculumAndSubjectElectiveType(this.curriculum));
    this.selectedRows = [];
    this.refreshCurriculum = false;
  //  console.log("Inside RefCur", this.actions.findSubjectsByCurriculumAndSubjectElectiveType(this.curriculum).payload.subjects.length)
    this.subjects = [];
    this.filter();
    }
      
    if (changes['subjects'] && this.subjects) {
      console.log('subject length:' + this.subjects.length);
      this.subjects.forEach((s: Subject) => {
        console.log('subject: ' + s.type);
        console.log('subject: ' + s.ordinal);
        console.log('subject: ' + s.subjectElectiveStatus);

      this.filteredData = changes['subjects'].currentValue;
      this.filteredTotal = changes['subjects'].currentValue.length;
      this.filter();

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

  ngAfterViewInit(): void {
        this.filteredData = this.subjects;
        this.filteredTotal = this.subjects.length;
        this.filter();
    }

    sort(sortEvent: ITdDataTableSortChangeEvent): void {
        this.sortBy = sortEvent.name;
        this.sortOrder = sortEvent.order;
        this.filter();
    }

    search(searchTerm: string): void {
        this.searchTerm = searchTerm;
        this.filter();
    }

    page(pagingEvent: IPageChangeEvent): void {
        this.fromRow = pagingEvent.fromRow;
        this.currentPage = pagingEvent.page;
        this.pageSize = pagingEvent.pageSize;
        this.filter();
    }

    filter(): void {
        let newData: any[] = this.subjects;
        newData = this._dataTableService.filterData(newData, this.searchTerm, true);
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
        newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
        this.filteredData = newData;
    }

  showBundleSubjectDialog(bundleSubject: BundleSubject): void {
      console.log("curriculum : "+this.curriculum.academicSession);
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = { top: '65px' };
    this.bundleSubjectDialogRef = this.dialog.open(CurriculumBundleSubjectDialog, config);
    this.bundleSubjectDialogRef.componentInstance.curriculum = this.curriculum;
    this.bundleSubjectDialogRef.afterClosed().subscribe((res) => {
      // no op
    });

  }

  showBundleElectiveDialog(bundleSubject: BundleSubject): void {
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = { top: '65px' };
    this.bundleElectiveDialogRef = this.dialog.open(CurriculumBundleElectiveDialog, config);
    this.bundleElectiveDialogRef.componentInstance.bundleSubject = bundleSubject;
    this.bundleElectiveDialogRef.afterClosed().subscribe((res) => {
      // no op
    });

  }
  
  selectRow(subject: Subject): void {
  }

  selectAllRows(subject: Subject[]): void {
  }

  viewSubject(subject: Subject): void {
    console.log('Emitting subject');
    let snackBarRef = this.snackBar.open('Viewing subject info', '' , { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
    this.view.emit(subject);
    });
  }

  deleteSubject(): void {

  for (let i: number = 0; i < this.selectedRows.length; i++) {
  
    this.numPart = this.actions.findBundleSubjectPart(this.selectedRows[i]).payload.bundleSubject.parts.length;
   

  if(this.numPart > 0) {
    //Proceed here if we CANNOT delete
    alert("Please Delete the Subject Part First");
    let snackBarRef = this.snackBar.open( 'Subject Elective cannot be deleted','',{ duration: 3000 });
    console.log("Number numPart " + this.numPart)
    snackBarRef.afterDismissed().subscribe(() => {
  
    } );

  } else {
   //Proceed here if we CAN delete
    this.store.dispatch(this.actions.deleteSubject(this.curriculum, this.selectedRows[i]));
    this.refreshCurriculum= true;
    let snackBarRef = this.snackBar.open('  Subject Elective has been deleted','',
    { duration: 3000 });
    snackBarRef.afterDismissed().subscribe(() => {

    } );
  }
  }
  }

  goBack(route: string): void {
    this.router.navigate(['/subjects']);
  }
}



