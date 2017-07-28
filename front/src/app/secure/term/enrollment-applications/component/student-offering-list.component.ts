import {AfterViewInit, ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-student-offering-list',
  templateUrl: './student-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentOfferingListComponent implements AfterViewInit {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'course.code', label: 'Code'},
    {name: 'course.titleEn', label: 'TitleEn'},
    {name: 'program.code', label: 'Program'},
    {name: 'capacity.number', label: 'Capacity'},
    {name: 'course.credit', label: 'Credit'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'course.code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() offerings: Offering[];
  @Output() view = new EventEmitter<Offering>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngAfterViewInit(): void {
    this.filteredData = this.offerings;
    this.filteredTotal = this.offerings.length;
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
    let newData: any[] = this.offerings;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewOffering(offering: Offering): void {
    console.log('Emitting offering');
    let snackBarRef = this.snackBar.open('Viewing offering info', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(offering);
    });
  }
}
