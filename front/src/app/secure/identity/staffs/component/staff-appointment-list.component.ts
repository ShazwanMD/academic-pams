import {FormBuilder} from '@angular/forms';

import {
  AfterViewInit,
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewContainerRef
} from '@angular/core';
import {Appointment} from '../../../../shared/model/term/appointment.interface';
import {Store} from '@ngrx/store';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog} from '@angular/material';
import {IdentityModuleState} from '../../index';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {AppointmentActions} from '../../../term/appointments/appointment.action';
import {Staff} from '../../../../shared/model/identity/staff.interface';

@Component({
  selector: 'pams-staff-appointment-list',
  templateUrl: './staff-appointment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class StaffAppointmentListComponent implements OnInit, AfterViewInit {

  private selectedRows: Appointment[];
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'section.offering.code', label: 'Section Code'},
    {name: 'section.offering.titleEn', label: 'Section Title'},
    {name: 'section.offering.capacity', label: 'Capacity'},
    {name: 'section.offering.program.code', label: 'Program'},
    {name: 'section.offering.course.faculty.name', label: 'Faculty'},
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

  @Input() staff: Staff;
  @Input() appointments: Appointment[];
  @Output() view = new EventEmitter<Appointment>();

  constructor(private _dataTableService: TdDataTableService,
              private router: Router,
              private route: ActivatedRoute,
              private actions: AppointmentActions,
              private store: Store<IdentityModuleState>,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
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

  removeAppointment(appointment: Appointment): void {
    console.log('removeAppointment:{}', appointment);
    this.store.dispatch(this.actions.removeAppointment(this.staff, appointment));

    console.log('deleteAppoiment:{}', appointment);

  }
}
