import {FormBuilder} from '@angular/forms';
import {AppointmentActions} from '../../appointments/appointment.action';
import {
  AfterViewInit,
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  Output,
  ViewContainerRef,
OnChanges,
SimpleChange
} from '@angular/core';
import {Appointment} from '../../../../shared/model/term/appointment.interface';
import {Section} from '../../../../shared/model/term/section.interface';
import {Store} from '@ngrx/store';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {TermModuleState} from '../../index';
import {AppointmentEditorDialog} from '../../appointments/dialog/appointment-editor.dialog';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';

@Component({
  selector: 'pams-section-appointment-list',
  templateUrl: './section-appointment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class SectionAppointmentListComponent implements AfterViewInit, OnChanges {

  @Input() section: Section;
  @Input() appointments: Appointment[];
  @Input() appointment: Appointment;
  @Output() view = new EventEmitter<Appointment>();

  private selectedRows: Appointment[];
  private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'staff.name', label: 'Staff'},
    {name: 'staff.identityNo', label: 'IdentityNo'},
    {name: 'appointmentStatus', label: 'Appointment Status'},
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

  constructor(private _dataTableService: TdDataTableService,
              private router: Router,
              private route: ActivatedRoute,
              private actions: AppointmentActions,
              private store: Store<TermModuleState>,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private snackBar: MdSnackBar,
              private dialog: MdDialog) {
  }
  
  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
      console.log("changes", changes, changes['appointments']);
      if (changes['appointments']) {
        this.filteredData = changes['appointments'].currentValue;
        this.filteredTotal = changes['appointments'].currentValue.length;
        this.filter();
      }
    }

  ngOnInit(): void {
    this.selectedRows = this.appointments.filter((value) => value.selected);
  }

  ngAfterViewInit(): void {
    this.filteredData = this.appointments;
    this.filteredTotal = this.appointments.length;
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
    let newData: any[] = this.appointments;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  selectRow(appointment: Appointment): void {
  }

  selectAllRows(appointments: Appointment[]): void {
  }

  addDialog(): void {
    console.log('showAddDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
    this.creatorDialogRef.componentInstance.section = this.section;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close add dialog');
      // load something here
    });
  }

  editDialog(appointment: Appointment, isValid: boolean): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
    if (isValid) {
      this.creatorDialogRef.componentInstance.appointment = appointment;
      this.creatorDialogRef.componentInstance.section = this.section;

    }
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      
    });
  }

  removeAppointment(appointment: Appointment): void {
      
      if (confirm("Are you sure to delete this appointment?") == true) {
          this.store.dispatch(this.actions.removeAppointment(this.section, appointment));
            let snackBarRef = this.snackBar.open( 'Appointment: ' + appointment.staff.name + ' has been deleted', '', { duration: 3000 } );
            snackBarRef.afterDismissed().subscribe(() => {
            } );
        } else {
            let snackBarRef = this.snackBar.open( 'Appointment: ' + appointment.staff.name + ' cancel deleted', '', { duration: 3000 } );
            snackBarRef.afterDismissed().subscribe(() => {
            } );
        }
      
      
   /* console.log('removeAppointment:{}', appointment);
    this.store.dispatch(this.actions.removeAppointment(this.section, appointment));

    console.log('deleteAppoiment:{}', appointment);*/

  }
}
