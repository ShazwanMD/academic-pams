import {
  AfterViewInit,
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  Output,
  ViewContainerRef
} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {TermModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {EnrollmentApplicationItemUpdateDialog} from '../dialog/enrollment-application-item-update.dialog';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';

@Component({
  selector: 'pams-student-enrollment-application-item',
  templateUrl: './student-enrollment-application-item.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class StudentEnrollmentApplicationItemComponent implements AfterViewInit {

  private editorDialogRef: MdDialogRef<EnrollmentApplicationItemUpdateDialog>;
  private selectedRows: EnrollmentApplicationItem[];
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'section.ordinal', label: 'Section'},
    {name: 'section.code', label: 'Code'},
    {name: 'section.offering.titleEn', label: 'Title'},
    {name: 'section.offering.course.credit', label: 'Credit'},
    {name: 'action', label: 'Add/Drop Status'},
    {name: 'action2', label: ''},

  ];

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollmentApplicationItem: EnrollmentApplicationItem;
  @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
  @Output() view = new EventEmitter<EnrollmentApplicationItem>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  ngAfterViewInit(): void {
    this.filteredData = this.enrollmentApplicationItems;
    this.filteredTotal = this.enrollmentApplicationItems.length;
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
    let newData: any[] = this.enrollmentApplicationItems;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewEnrollmentApplicationItem(enrollmentApplicationItem: EnrollmentApplicationItem): void {
    console.log('Emitting enrollmentApplicationItem');
    let snackBarRef = this.snackBar.open('Viewing enrollmentApplicationItem info', 'OK' , {duration:2000});
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(enrollmentApplicationItem);
    });
  }

  ngOnInit(): void {
    this.selectedRows = this.enrollmentApplicationItems.filter((value) => value.selected);
  }

  selectRow(item: EnrollmentApplicationItem): void {
  }

  selectAllRows(items: EnrollmentApplicationItem[]): void {
  }

  delete(item: EnrollmentApplicationItem): void {
    this.store.dispatch(this.actions.deleteEnrollmentApplicationItem(this.enrollmentApplication, item));
  }

  createDialog(): void {
    console.log('show Dialog EnrollmentApplicationItem');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(EnrollmentApplicationItemUpdateDialog, config);
    this.editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;

    // close
    this.editorDialogRef.afterClosed().subscribe((res) => {
      // do something
    });
  }

  //edit dialog
  editDialog(enrollmentApplicationItem: EnrollmentApplicationItem, isValid: boolean): void {
    console.log('EnrollmentApplicationItem:{}', enrollmentApplicationItem);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    this.editorDialogRef = this.dialog.open(EnrollmentApplicationItemUpdateDialog, config);
    if (isValid) {
      this.editorDialogRef.componentInstance.enrollmentApplicationItem = enrollmentApplicationItem;
      this.editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;

    }
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog enrollmentApplicationItem');
      // load something here
    });
  }
}

