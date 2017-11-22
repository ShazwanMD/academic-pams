import {
  AfterViewInit,
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  Output,
  ViewContainerRef
} from '@angular/core';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {EnrollmentApplicationActions} from '../../enrollment-applications/enrollment-application.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {AdmissionEnrollmentDialog} from '../dialog/admission-enrollment.dialog';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';

@Component({
  selector: 'pams-admission-enrollment-application-list',
  templateUrl: './admission-enrollment-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionEnrollmentApplicationListComponent implements AfterViewInit {

  private columns: any[] = [
    {name: 'id', label: 'Id'}, //referenceNo
    {name: 'referenceNo', label: 'Reference No.'},
    {name: 'description', label: 'Description'},
    {name: 'applicationType', label: 'Application Type'},
    {name: 'action', label: ''},
  ];
  private selectedRows: EnrollmentApplication[];
  private creatorDialogRef: MdDialogRef<AdmissionEnrollmentDialog>;

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() admission: Admission;
  @Input() enrollmentApplications: EnrollmentApplication[];
  @Output() view: EventEmitter<EnrollmentApplication> = new EventEmitter<EnrollmentApplication>();

  constructor(private _dataTableService: TdDataTableService,
              private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar,
              private dialog: MdDialog) {
  }

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

  viewTask(enrollmentApplication: EnrollmentApplication): void {
    console.log('Emitting enrollmentApplication');
    let snackBarRef = this.snackBar.open('Viewing enrollment application info', 'OK', {duration:2000});
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(enrollmentApplication);
    });
  }

  ngOnInit(): void {
    this.selectedRows = this.enrollmentApplications.filter((value) => value.selected);
  }

  selectRow(enrollmentApplication: EnrollmentApplication): void {
  }

  selectAllRows(enrollmentApplications: EnrollmentApplication[]): void {
  }

  showDialog(): void {
    console.log('showDialog details');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '90%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AdmissionEnrollmentDialog, config);

    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  delete(admission: Admission, application: EnrollmentApplication): void {
    this.store.dispatch(this.actions.removeEnrollmentApplication(this.admission, application));
  }

}
