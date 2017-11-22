import {AfterViewInit, ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {Appointment} from '../../../../shared/model/term/appointment.interface';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-appointment-list',
  templateUrl: './appointment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppointmentListComponent implements AfterViewInit {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'staff.name', label: 'Staf Name'},
    {name: 'section.code', label: 'Section'},
    {name: 'section.session.code', label: 'Academic Session'},
    {name: 'section.offering.course.title', label: 'Course Offering'},
    {name: 'section.offering.program.code', label: 'Program'},
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

  @Input() appointments: Appointment[];
  @Output() view: EventEmitter<Appointment> = new EventEmitter<Appointment>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
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

  viewAppointment(appointment: Appointment): void {
    console.log('Emitting appointment');
    let snackBarRef = this.snackBar.open('Viewing appointment', 'OK', {duration:2000});
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(appointment);
    });
  }
}

