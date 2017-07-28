import {MdSnackBar} from '@angular/material';
import {Component, Input, Output, ChangeDetectionStrategy, EventEmitter, AfterViewInit} from '@angular/core';
import {
  TdDataTableService,
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableSortingOrder,
} from '@covalent/core';
import {AdmissionApplication} from '../../../../shared/model/term/admission-application.interface';

@Component({
  selector: 'pams-archived-admission-application-list',
  templateUrl: './archived-admission-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ArchivedAdmissionApplicationListComponent implements AfterViewInit {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'referenceNo', label: 'Reference No'},
    {name: 'student.identityNo', label: 'Matric.No'},
    {name: 'student.name', label: 'Name'},
    {name: 'advisor.identityNo', label: 'Advisor'},
    {name: 'student.cohort.program.code', label: 'Program'},
    {name: 'studyCenter.description', label: 'Study Center'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 20;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() admissionApplications: AdmissionApplication[];
  @Output() view = new EventEmitter<AdmissionApplication>();

  constructor(private snackBar: MdSnackBar,
              private _dataTableService: TdDataTableService) {
  }

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
  }

  viewAdmissionApplication(admissionApplication: AdmissionApplication): void {
    console.log('Emitting task');
    let snackBarRef = this.snackBar.open('Viewing admission application', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(admissionApplication);
    });
  }
}
