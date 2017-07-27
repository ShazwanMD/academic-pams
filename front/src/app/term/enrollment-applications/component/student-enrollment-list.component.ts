import {
  Component,
  Input,
  EventEmitter,
  Output,
  ChangeDetectionStrategy,
  ViewContainerRef,
  SimpleChange,
  OnChanges,
} from '@angular/core';
import {MdSnackBar} from '@angular/material';
import {EnrollmentApplicationTask} from '../../../shared/model/term/enrollment-application-task.interface';
import {
  TdDataTableSortingOrder,
  TdDataTableService,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent,
} from '@covalent/core';

@Component({
  selector: 'pams-student-enrollment-list',
  templateUrl: './student-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentEnrollmentListComponent implements OnChanges {

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'application.admission.student.identityNo', label: 'Student ID'},
    {name: 'application.admission.student.name', label: 'Name'},
    {name: 'application.admission.cgpa', label: 'CGPA'},
    {name: 'application.admission.cohort.code', label: 'Cohort'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  @Input() studentEnrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() view = new EventEmitter<EnrollmentApplicationTask>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log('changes', changes, changes['studentEnrollmentApplicationTasks']);
    if (changes['studentEnrollmentApplicationTasks']) {
      this.filteredData = changes['studentEnrollmentApplicationTasks'].currentValue;
      this.filteredTotal = changes['studentEnrollmentApplicationTasks'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.studentEnrollmentApplicationTasks;
    this.filteredTotal = this.studentEnrollmentApplicationTasks.length;
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
    let newData: any[] = this.studentEnrollmentApplicationTasks;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewTask(task: EnrollmentApplicationTask): void {
    console.log('Emitting task');
    let snackBarRef = this.snackBar.open('Viewing student enrollment application', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
