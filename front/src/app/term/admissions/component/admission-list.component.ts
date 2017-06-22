import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, AfterViewInit } from '@angular/core';
import { Admission } from "../admission.interface";
import { TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';
import {MdSnackBar} from "@angular/material";

@Component({
  selector: 'pams-admission-list',
  templateUrl: './admission-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionListComponent implements AfterViewInit  {

  @Input() admissions: Admission[];
  @Output() view = new EventEmitter<Admission>();

  private columns: any[] = [
    { name: 'student.name', label: 'Name' },
    { name: 'student.identityNo', label: 'Matric No' },
    { name: 'academicSession.code', label: 'Session' },
    { name: 'cohort.code', label: 'Cohort' },
    { name: 'standing', label: 'Academic Standing' },
    { name: 'status', label: 'Admission Status' },
    { name: 'action', label: '' }
  ];
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'student.identityNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  
  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {}
  
  ngAfterViewInit(): void {
    this.filteredData = this.admissions;
    this.filteredTotal = this.admissions.length;
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
    let newData: any[] = this.admissions;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
  
  viewAdmission(admission: Admission): void {
    console.log("Emitting admission");
    let snackBarRef = this.snackBar.open("Viewing semester registration", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(admission);
    });
  } 
}
