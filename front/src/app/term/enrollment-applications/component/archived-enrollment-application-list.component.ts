import { MdSnackBar } from '@angular/material';
import { EnrollmentApplicationTask } from './../enrollment-application-task.interface';
import { Component, Input, Output, ChangeDetectionStrategy, EventEmitter, AfterViewInit } from '@angular/core';
import { TdDataTableService, IPageChangeEvent, ITdDataTableSortChangeEvent, TdDataTableSortingOrder } from "@covalent/core";
import { EnrollmentApplication } from "./../enrollment-application.interface";


@Component({
  selector: 'pams-archived-enrollment-application-list',
  templateUrl: './archived-enrollment-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ArchivedEnrollmentApplicationListComponent implements AfterViewInit {

  @Input() enrollmentApplications: EnrollmentApplication[];
  @Output() view = new EventEmitter<EnrollmentApplication>();

  private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'referenceNo', label: 'Reference No' },
    { name: 'admission.student.name', label: 'Name' },
    { name: 'admission.student.identityNo', label: 'Matric No.' },
    { name: 'admission.ordinal', label: 'Semester' },
    { name: 'admission.student.cohort.program.code', label: 'Program' },
    { name: 'admission.studyCenter.description', label: 'Study Center' },
    { name: 'flowState', label: 'Status' },
   
    { name: 'action', label: '' },
  ];

  constructor(private snackBar: MdSnackBar,
          private _dataTableService: TdDataTableService) {
  }
  
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 20;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;
  
  ngAfterViewInit(): void {
      this.filteredData = this.enrollmentApplications;
      this.filteredTotal = this.enrollmentApplications.length;
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
      let newData: any[] = this.enrollmentApplications;
      newData = this._dataTableService.filterData(newData, this.searchTerm, true);
      this.filteredTotal = newData.length;
      newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
      newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
      this.filteredData = newData;
    }
    
    

  viewEnrollmentApplication(enrollmentApplication: EnrollmentApplication): void {
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Viewing enrollment application", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(enrollmentApplication);
    });
  }
}