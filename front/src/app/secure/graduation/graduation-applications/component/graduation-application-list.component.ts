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
import {GraduationApplication} from '../../../../shared/model/graduation/graduation-application.interface';
import {  IPageChangeEvent,  ITdDataTableSortChangeEvent,  TdDataTableService,  TdDataTableSortingOrder} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-graduation-application-list',
  templateUrl: './graduation-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
//export class GraduationApplicationListComponent implements AfterViewInit, OnChanges {
    export class GraduationApplicationListComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'referenceNo', label: 'Reference No'},
    {name: 'student.name', label: 'Name'},
    {name: 'student.identityNo', label: 'IdentityNo'},
    {name: 'cgpa', label: 'CGPA'},
    {name: 'creditHour', label: 'Credit Hour'},
    {name: 'description', label: 'Description'},
    {name: 'academicSession.code', label: 'Academic Session'},
    {name: 'action', label: ''},
  ];

  /*filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;
*/
  @Input() graduationApplications: GraduationApplication[];
  @Output() view: EventEmitter<GraduationApplication> = new EventEmitter<GraduationApplication>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  /*ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log("changes", changes, changes['graduationApplications']);
    if (changes['graduationApplications']) {
      this.filteredData = changes['graduationApplications'].currentValue;
      this.filteredTotal = changes['graduationApplications'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.graduationApplications;
    this.filteredTotal = this.graduationApplications.length;
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
    let newData: any[] = this.graduationApplications;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
*/
 
}
