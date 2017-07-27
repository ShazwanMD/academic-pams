import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {EnrollmentActions} from '../../enrollments/enrollment.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Admission} from '../../../shared/model/term/admission.interface';
import {AdmissionEnrollmentDialog} from '../dialog/admission-enrollment.dialog';
import {
  TdDataTableSortingOrder,
  TdDataTableService,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-student-admission-enrollment-list',
  templateUrl: './student-admission-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentAdmissionEnrollmentListComponent implements OnInit {

  private columns: any[] = [
    {name: 'section.id', label: 'Section'},
    {name: 'section.offering.academicSession.code', label: 'Session'},
    {name: 'section.code', label: 'Code'},
    {name: 'section.offering.titleEn', label: 'Title'},
    {name: 'section.offering.program.code', label: 'Program'},
    {name: 'enrollmentStanding', label: 'Standing'},
    {name: 'enrollmentStatus', label: 'Status'},
    {name: 'totalScore', label: 'Total Score'},
    {name: 'action', label: ''},
  ];
  private selectedRows: Enrollment[];
  private creatorDialogRef: MdDialogRef<AdmissionEnrollmentDialog>;

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'section.id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;


  @Input() enrollment: Enrollment;
  @Input() admission: Admission;
  @Input() enrollments: Enrollment[];
  @Output() view: EventEmitter<Enrollment> = new EventEmitter<Enrollment>();

  constructor(private _dataTableService: TdDataTableService,
              private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.enrollments.filter((value) => value.selected);
  }

  selectRow(enrollment: Enrollment): void {
  }

  selectAllRows(enrollments: Enrollment[]): void {
  }

  showDialog(): void {
    console.log('showDialog details');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '90%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AdmissionEnrollmentDialog, config);

    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  ngAfterViewInit(): void {
    this.filteredData = this.enrollments;
    this.filteredTotal = this.enrollments.length;
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
    let newData: any[] = this.enrollments;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewTask(enrollment: Enrollment): void {
    console.log('Emitting enrollment');
    let snackBarRef = this.snackBar.open('Viewing enrollment info', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(enrollment);
    });
  }

}
