import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, AfterViewInit, OnChanges, SimpleChange} from '@angular/core';
import {Offering} from '../offering.interface';
import {
  TdDataTableSortingOrder,
  TdDataTableService,
  ITdDataTableSortChangeEvent,
  IPageChangeEvent
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-offering-list',
  templateUrl: './offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingListComponent implements AfterViewInit,OnChanges {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'course.status', label: 'Status'},
    {name: 'titleEn', label: 'TitleEn'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'program.code', label: 'Program'},
    {name: 'course.faculty.name', label: 'Faculty'},
    {name: 'program.level.code', label: 'Level'},
   
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() offerings: Offering[];
  @Output() view: EventEmitter<Offering> = new EventEmitter<Offering>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }
  
  ngOnChanges(changes: {[ propName: string]: SimpleChange}) {
      console.log("changes",changes,changes['offerings']);
        if (changes['offerings']){
        this.filteredData = changes['offerings'].currentValue; 
        this.filteredTotal = changes['offerings'].currentValue.length;
        this.filter();
      }
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
