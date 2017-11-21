import {MdSnackBar} from '@angular/material/snack-bar';
import {Store} from '@ngrx/store';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
} from '@covalent/core';
import {
    ChangeDetectionStrategy,
    Component,
    Input,
    AfterViewInit,
    OnChanges,
    OnInit,
    SimpleChange,
    EventEmitter,
    Output,
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
    selector: 'pams-curriculum-elective-subject-list',
    templateUrl: './curriculum-elective-subject-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumElectiveSubjectListComponent implements AfterViewInit , OnChanges {

    private selectedRows: Subject[];
    private singleSubjectDialogRef: MdDialogRef<CurriculumSingleSubjectDialog>;
    private bundleSubjectDialogRef: MdDialogRef<CurriculumBundleSubjectDialog>;
    private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;
    
     //display subject core in curriculum
    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'ordinal', label: 'Semester' },
        { name: 'subjectType', label: 'Type' },
        { name: 'course.code', label: 'Course' },
        { name: 'course.titleEn', label: 'Title' },
        { name: 'course.credit', label: 'Credit' },
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

      
     ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    // console.log("changes", changes, changes['subjects']);

     console.log('subject length:' + this.subjects.length);
    if (changes['subjects'] && this.subjects) {
      this.filteredData = changes['subjects'].currentValue;
      this.filteredTotal = changes['subjects'].currentValue.length;
      this.filter();
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


    showSingleSubjectDialog(singleSubject: SingleSubject): void {
        console.log("this.curriculum : " + this.curriculum.academicSession);
        let config: MdDialogConfig = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '60%';
        config.position = { top: '65px' };
        this.singleSubjectDialogRef = this.dialog.open(CurriculumSingleSubjectDialog, config);
        this.singleSubjectDialogRef.componentInstance.curriculum = this.curriculum;
        this.singleSubjectDialogRef.afterClosed().subscribe((res) => {
            // no op
        });

    }

    deleteSubject(subject: Subject): void {
        // console.log('length: ' + this.selectedRows.length);
        // window.confirm("Are you sure to delete this Subject?");
        // for (let i: number = 0; i < this.selectedRows.length; i++) {
        //     this.store.dispatch(this.actions.deleteSubject(this.curriculum, this.selectedRows[i]));
        // }
 if (confirm("Are you sure to delete this subject?") == true) {
    
    for (let i: number = 0; i < this.selectedRows.length; i++) {
    this.store.dispatch(this.actions.deleteSubject(this.curriculum, this.selectedRows[i]));
     }
       let snackBarRef = this.snackBar.open('Subject has been deleted', '',
        { duration: 3000 });
    
        snackBarRef.afterDismissed().subscribe(() => {
        this.selectedRows = [];
     } );

  } else {
           
        let snackBarRef = this.snackBar.open( 'subject cancel deleted', '', 
        { duration: 3000 } );
        snackBarRef.afterDismissed().subscribe(() => {
    } );
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
