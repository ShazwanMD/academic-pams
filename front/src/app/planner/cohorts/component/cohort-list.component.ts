import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Cohort} from "../cohort.interface";
import { TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';
import { MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-cohort-list',
  templateUrl: './cohort-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CohortListComponent {

  @Input() cohorts: Cohort[];
  @Output() view = new EventEmitter<Cohort>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
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
          private snackBar: MdSnackBar) {}
  
  
   ngAfterViewInit(): void {
    this.filteredData = this.cohorts;
    this.filteredTotal = this.cohorts.length;
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
    let newData: any[] = this.cohorts;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewCohort(cohort: Cohort): void {
   console.log("Emitting cohorts");
   let snackBarRef = this.snackBar.open("Viewing cohorts info", "OK");
   snackBarRef.afterDismissed().subscribe(() => {
   this.view.emit(cohort);
    });
  }
}

