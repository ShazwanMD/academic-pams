import { MdSnackBar } from '@angular/material';
import { AdmissionApplicationTask } from '../admission-application-task.interface';
import { Component, ChangeDetectionStrategy, EventEmitter, Output, Input } from '@angular/core';
import { TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';

@Component({
  selector: 'pams-assigned-admission-application-task-list',
  templateUrl: './assigned-admission-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedAdmissionApplicationTaskListComponent {

    @Input() admissionApplicationTasks: AdmissionApplicationTask[];
    @Output() view = new EventEmitter<AdmissionApplicationTask>();
    
  private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'referenceNo', label: 'Reference No' },
    { name: 'application.student.identityNo', label: 'Matric No.' },
    { name: 'application.student.name', label: 'Name' },
    { name: 'application.ordinal', label: 'Semester' },
    { name: 'application.advisor.identityNo', label: 'Advisor' },
    { name: 'application.student.cohort.program.code', label: 'Program' },
    { name: 'application.studyCenter.description', label: 'Study Center' },
    { name: 'flowState', label: 'Status' },
    { name: 'action', label: '' },
  ];

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }
  
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 20;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;
  
  ngAfterViewInit(): void {
      this.filteredData = this.admissionApplicationTasks;
      this.filteredTotal = this.admissionApplicationTasks.length;
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
      let newData: any[] = this.admissionApplicationTasks;
      newData = this._dataTableService.filterData(newData, this.searchTerm, true);
      this.filteredTotal = newData.length;
      newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
      newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
      this.filteredData = newData;
    }

  viewTask(task: AdmissionApplicationTask): void {
    console.log('viewing task');
    let snackBarRef = this.snackBar.open('Viewing semester registration', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
