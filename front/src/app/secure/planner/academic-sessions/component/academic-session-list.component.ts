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
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-academic-session-list',
  templateUrl: './academic-session-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AcademicSessionListComponent implements AfterViewInit, OnChanges {

  private columns: any [] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'current', label: 'Status'},
    {name: 'action', label: ''},

  ];
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() academicSessions: AcademicSession[];
  @Output() view = new EventEmitter<AcademicSession>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  viewAcademicSession(academicSession: AcademicSession): void {
    console.log('Emitting academicSessions');
    let snackBarRef = this.snackBar.open('Viewing academicSession info', 'OK' , { duration: 2000 } );
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(academicSession);
    });

  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log('changes', changes, changes['academicSessions']);
    if (changes['academicSessions']) {
      this.filteredData = changes['academicSessions'].currentValue;
      this.filteredTotal = changes['academicSessions'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.academicSessions;
    this.filteredTotal = this.academicSessions.length;
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
    let newData: any[] = this.academicSessions;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

}
