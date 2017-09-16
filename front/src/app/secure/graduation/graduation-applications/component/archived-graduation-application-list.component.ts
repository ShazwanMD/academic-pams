import {MdSnackBar} from '@angular/material';
import {AfterViewInit, ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {GraduationApplication} from '../../../../shared/model/term/graduation-application.interface';

@Component({
  selector: 'pams-archived-graduation-application-list',
  templateUrl: './archived-graduation-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ArchivedGraduationApplicationListComponent implements AfterViewInit {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 20;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() graduationApplications: GraduationApplication[];
  @Output() view = new EventEmitter<GraduationApplication>();

  constructor(private snackBar: MdSnackBar,
              private _dataTableService: TdDataTableService) {
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

  viewGraduationApplication(graduationApplication: GraduationApplication): void {
    console.log('Emitting task');
    let snackBarRef = this.snackBar.open('Viewing graduation application', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(graduationApplication);
    });
  }
}
