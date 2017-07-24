import {FormBuilder} from '@angular/forms';
import { AppointmentActions } from './../../appointments/appointment.action';
import { SectionActions } from './../section.action';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Appointment} from "../../appointments/appointment.interface";
import {Section} from "../section.interface";
import {Store} from "@ngrx/store";
import {ActivatedRoute, Router} from "@angular/router";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {AppointmentEditorDialog} from "../../appointments/dialog/appointment-editor.dialog";

@Component({
    selector: 'pams-student-section-appointment-list',
    templateUrl: './student-section-appointment-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentSectionAppointmentListComponent implements OnInit {

    @Input() section: Section;
    @Input() appointments: Appointment[];
    @Output() view = new EventEmitter<Appointment>();

    private selectedRows: Appointment[];
    private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;
    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'staff.name', label: 'Staff' },
        { name: 'staff.email', label: 'Email' },
        { name: 'staff.program.code', label: 'Program' },
        { name: 'staff.faculty.name', label: 'Faculty' },
        { name: 'action', label: '' }
    ];

    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: AppointmentActions,
        private store: Store<TermModuleState>,
         private formBuilder: FormBuilder,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
    }
    ngOnInit(): void {
        this.selectedRows = this.appointments.filter(value => value.selected);
  }

    filter(): void {
    }

    selectRow(appointment: Appointment): void {
    }

    selectAllRows(appointments: Appointment[]): void {
    }

    addDialog(): void {
        console.log("showAddDialog");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '40%';
        config.height = '40%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
        this.creatorDialogRef.componentInstance.section = this.section;
        this.creatorDialogRef.afterClosed().subscribe(res => {
            console.log("close add dialog");
            // load something here
        });
    }

    editDialog(appointment: Appointment, isValid: boolean): void {
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
            this.creatorDialogRef.componentInstance.section = this.section;

        }
        this.creatorDialogRef.afterClosed().subscribe(res => {
            console.log("close dialog");
            // load something here
        });
    }

    removeAppointment(appointment: Appointment): void {
        console.log("removeAppointment:{}", appointment)
        this.store.dispatch(this.actions.removeAppointment(this.section, appointment))

         console.log("deleteAppoiment:{}", appointment)

    }
}