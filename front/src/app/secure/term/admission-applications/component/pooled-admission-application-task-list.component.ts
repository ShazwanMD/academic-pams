import {MdSnackBar} from '@angular/material';
import {AdmissionApplicationTask} from '../../../../shared/model/term/admission-application-task.interface';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnChanges, Output, SimpleChange} from '@angular/core';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
@Component({
  selector: 'pams-pooled-admission-application-task-list',
  templateUrl: './pooled-admission-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PooledAdmissionApplicationTaskListComponent implements OnChanges {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'referenceNo', label: 'Reference No'},
    {name: 'application.student.identityNo', label: 'Matric.No'},
    {name: 'application.student.name', label: 'Name'},
    {name: 'application.advisor.identityNo', label: 'Advisor'},
    {name: 'application.student.cohort.program.code', label: 'Program'},
    {name: 'application.studyCenter.description', label: 'Study Center'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 20;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() admissionApplicationTasks: AdmissionApplicationTask[];
  @Output() claim = new EventEmitter<AdmissionApplicationTask>();

  constructor(private snackBar: MdSnackBar,
              private _dataTableService: TdDataTableService) {
  }


  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log('changes', changes, changes['admissionApplicationTasks']);
    if (changes['admissionApplicationTasks']) {
      this.filteredData = changes['admissionApplicationTasks'].currentValue;
      this.filteredTotal = changes['admissionApplicationTasks'].currentValue.length;
      this.filter();
    }
  }

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

  claimTask(task: AdmissionApplicationTask): void {
    console.log('Emitting task');
    let snackBarRef = this.snackBar.open('Claiming registration application', '' , {duration:3000});
    snackBarRef.afterDismissed().subscribe(() => {
      this.claim.emit(task);
    });
  }
}
