import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy,  AfterViewInit} from '@angular/core';
import { TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';
import {Staff} from "../staff.interface";
import {MdSnackBar} from "@angular/material";

@Component({
  selector: 'pams-staff-list',
  templateUrl: './staff-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StaffListComponent implements AfterViewInit {

  @Input() staffs: Staff[];
  @Output() view: EventEmitter<Staff> = new EventEmitter<Staff>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'staff.name', label: 'Staf Name'},
    {name: 'section.code', label: 'Section'},
    {name: 'section.session.code', label: 'Academic Session'},
    {name: 'section.offering.course.title', label: 'Course Offering'},
    {name: 'section.offering.program.code', label: 'Program'},
    {name: 'action', label: ''}
  ];
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  
  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {}
  
  ngAfterViewInit(): void {
    this.filteredData = this.staffs;
    this.filteredTotal = this.staffs.length;
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
    let newData: any[] = this.staffs;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  
  viewStaff(staff: Staff): void {
    console.log("Emitting staff");
    let snackBarRef = this.snackBar.open("Viewing staff", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(staff);
    });
  } 
}

