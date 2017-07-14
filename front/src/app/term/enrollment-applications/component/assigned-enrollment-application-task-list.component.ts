import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, AfterViewInit} from '@angular/core';
import {MdSnackBar} from "@angular/material";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";
import { TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';

@Component({
  selector: 'pams-assigned-enrollment-application-task-list',
  templateUrl: './assigned-enrollment-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedEnrollmentApplicationTaskListComponent implements AfterViewInit {

  @Input() enrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() view = new EventEmitter<EnrollmentApplicationTask>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'application.admission.student.name', label: 'Name'},
    {name: 'application.admission.student.identityNo', label: 'Matric No'},
    {name: 'application.admission.cohort.code', label: 'Cohort'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];
  
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 15;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
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
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Viewing enrollment applications", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
