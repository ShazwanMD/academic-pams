import {AfterViewInit, ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';
import {Subject} from '../subject.interface';

@Component({
  selector: 'pams-subject-list',
  templateUrl: './subject-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SubjectListComponent implements AfterViewInit {


  @Input() subjects: Subject[];
  @Output() view = new EventEmitter<Subject>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'subjectType', label: 'SubjectType'},
    {name: 'curriculum', label: 'Curriculum'},
    {name: 'action', label: ''}
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;


  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
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

  viewSubject(Subject: Subject): void {
    console.log('Emitting subjects');
    let snackBarRef = this.snackBar.open('Viewing subjects info', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(Subject);
    });
  }
}

