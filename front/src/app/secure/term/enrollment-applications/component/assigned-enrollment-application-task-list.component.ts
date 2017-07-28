import {
  AfterViewInit,
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  Output,
  SimpleChange
} from '@angular/core';
import {MdSnackBar} from '@angular/material';
import {EnrollmentApplicationTask} from '../../../../shared/model/term/enrollment-application-task.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';

@Component({
  selector: 'pams-assigned-enrollment-application-task-list',
  templateUrl: './assigned-enrollment-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedEnrollmentApplicationTaskListComponent implements AfterViewInit, OnChanges {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'application.admission.student.name', label: 'Name'},
    {name: 'application.admission.student.identityNo', label: 'Matric No'},
    {name: 'application.admission.cohort.code', label: 'Cohort'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 15;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() enrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() view = new EventEmitter<EnrollmentApplicationTask>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log('changes', changes, changes['enrollmentApplicationTasks']);
    if (changes['enrollmentApplicationTasks']) {
      this.filteredData = changes['enrollmentApplicationTasks'].currentValue;
      this.filteredTotal = changes['enrollmentApplicationTasks'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.enrollmentApplicationTasks;
    this.filteredTotal = this.enrollmentApplicationTasks.length;
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
    let newData: any[] = this.enrollmentApplicationTasks;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewTask(task: EnrollmentApplicationTask): void {
    console.log('Emitting task');
    let snackBarRef = this.snackBar.open('Viewing enrollment applications', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
