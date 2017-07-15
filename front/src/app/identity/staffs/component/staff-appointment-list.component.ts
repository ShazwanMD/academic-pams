import {FormBuilder} from '@angular/forms';

import { StaffActions } from './../staff.action';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {Appointment} from "../../../term/appointments/appointment.interface";
import {Staff} from "../staff.interface";
import {Store} from "@ngrx/store";
import {ActivatedRoute, Router} from "@angular/router";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {IdentityModuleState} from "../../index";
import {AppointmentEditorDialog} from "../../../term/appointments/dialog/appointment-editor.dialog";
import { TdDataTableSortingOrder, TdDataTableService, IPageChangeEvent, ITdDataTableSortChangeEvent } from "@covalent/core";
import { AppointmentActions } from "../../../term/appointments/appointment.action";

@Component({
    selector: 'pams-staff-appointment-list',
    templateUrl: './staff-appointment-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,

})
export class StaffAppointmentListComponent implements AfterViewInit {


    @Input() staff: Staff;
    @Input() appointments: Appointment[];
   
    @Output() view = new EventEmitter<Appointment>();


    private selectedRows: Appointment[];
   // private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'section.offering.code', label: 'Section Code' },
        { name: 'section.offering.titleEn', label: 'Section Title' },
        { name: 'section.offering.capacity', label: 'Capacity' },
        { name: 'section.offering.course.program.code', label: 'Program' },
        { name: 'section.offering.course.faculty.name', label: 'Faculty' },
        { name: 'appointmentStatus', label: 'Appointment Status' },
        { name: 'action', label: '' }
    ];
    
    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'id';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

    constructor(
        private _dataTableService: TdDataTableService,
        private router: Router,
        private route: ActivatedRoute,
        private actions: AppointmentActions,
        private store: Store<IdentityModuleState>,
         private formBuilder: FormBuilder,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
    }

    ngOnInit(): void {
        this.selectedRows = this.appointments.filter(value => value.selected);
  }

    ngAfterViewInit(): void {
        this.filteredData = this.appointments;
        this.filteredTotal = this.appointments.length;
        this.filter();
    }

    sort( sortEvent: ITdDataTableSortChangeEvent ): void {
        this.sortBy = sortEvent.name;
        this.sortOrder = sortEvent.order;
        this.filter();
    }

    search( searchTerm: string ): void {
        this.searchTerm = searchTerm;
        this.filter();
    }

    page( pagingEvent: IPageChangeEvent ): void {
        this.fromRow = pagingEvent.fromRow;
        this.currentPage = pagingEvent.page;
        this.pageSize = pagingEvent.pageSize;
        this.filter();
    }

    filter(): void {
        let newData: any[] = this.appointments;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    selectRow(appointment: Appointment): void {
    }

    selectAllRows(appointments: Appointment[]): void {
    }

    /*addDialog(): void {
        console.log("showAddDialog");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '40%';
        config.height = '40%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
        this.creatorDialogRef.componentInstance.staff = this.staff;
        this.creatorDialogRef.afterClosed().subscribe(res => {
            console.log("close add dialog");
            // load something here
        });
    }*/

    /*editDialog(appointment: Appointment, isValid: boolean): void {
        console.log("showDialog");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
        if (isValid) {
            this.creatorDialogRef.componentInstance.appointment = appointment;
            this.creatorDialogRef.componentInstance.staff = this.staff;

        }
        this.creatorDialogRef.afterClosed().subscribe(res => {
            console.log("close dialog");
            // load something here
        });
    }*/

    removeAppointment(appointment: Appointment): void {
        console.log("removeAppointment:{}", appointment)
        this.store.dispatch(this.actions.removeAppointment(this.staff, appointment))

         console.log("deleteAppoiment:{}", appointment)

    }
}


