import { Component, ChangeDetectionStrategy, Output, Input, EventEmitter, AfterViewInit } from '@angular/core';
import { AdmissionApplication } from "./../admission-application.interface";
import { IPageChangeEvent, ITdDataTableSortChangeEvent, TdDataTableSortingOrder, TdDataTableService } from "@covalent/core";
//import { MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-admission-application-list',
  templateUrl: './admission-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AdmissionApplicationListComponent   {

  @Input() admissionApplications: AdmissionApplication[];
  @Output() view = new EventEmitter<AdmissionApplication>();

  private columns: any[] = [
    // { name: 'auditNo', label: 'Audit No' },
    { name: 'referenceNo', label: 'Reference No' },
    { name: 'description', label: 'Description' },
    // { name: 'sourceNo', label: 'Source No' },
    // { name: 'cancelComment', label: 'Cancel Comment' },
    // { name: 'removeComment', label: 'Remove Comment' },
    { name: 'advisor.identityNo', label: 'Advisor' },
    { name: 'program.code', label: 'Program' },
    { name: 'session.code', label: 'Academic Session' },
    { name: 'student.identityNo', label: 'Student' },
    { name: 'studyCenter.code', label: 'Study Center' },
    { name: 'action', label: '' }

  ];
  
  /*filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  constructor(private _dataTableService: TdDataTableService,
          private snackBar: MdSnackBar) {}
  
  ngAfterViewInit(): void {
    this.filteredData = this.admissionApplications;
    this.filteredTotal = this.admissionApplications.length;
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
    let newData: any[] = this.admissionApplications;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }*/
  
  /*viewAdmissionApplication(admissionApplication: AdmissionApplication): void {
      console.log("Emitting admissionApplication");
      let snackBarRef = this.snackBar.open("Viewing admissionApplication info", "OK");
      snackBarRef.afterDismissed().subscribe(() => {
        this.view.emit(admissionApplication);
      });
    } */
}
