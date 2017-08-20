import { LecturerActions } from './../lecturer.action';
import { LecturerModuleState } from './../index';
import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef, OnInit } from '@angular/core';
import { MdDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Staff } from "../../../shared/model/identity/staff.interface";
import { Observable } from 'rxjs';
import { Appointment } from "../../../shared/model/term/appointment.interface";

@Component( {
    selector: 'pams-lecturer-profile',
    templateUrl: 'lecturer-profile.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class LecturerProfileComponent implements OnInit {

    private selectedRows: Appointment[];
  
    @Input() lecturer: Staff;
    @Input() appointments: Appointment[];
    
    @Output() view2 = new EventEmitter<Staff>();

    constructor( 
       
        private router: Router,
        private route: ActivatedRoute,
        private actions: LecturerActions,
        private store: Store<LecturerModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {
    }
    
  //view data appointments to review sections 
    private columns: any[] = [
        { name: 'id', label: 'Id' },
        //{ name: 'status', label: 'Status' },
        { name: 'section.ordinal', label: 'Section No.' },
        { name: 'section.offering.titleEn', label: 'Title' },
        { name: 'section.offering.program.code', label: 'Program' },
        { name: 'section.offering.program.faculty.description', label: 'Faculty' },
        { name: 'action', label: '' },
    ];
    
    ngOnInit(): void {
        
      }

      selectRow(appointment: Appointment): void {
      }

      selectAllRows(appointments: Appointment[]): void {
      }

    myProfile() {
        this.router.navigate( ['/secure'] );

    }

    insertGradebook() {
        this.router.navigate( ['/secure/term/offerings/lecturer-offering-center'] );

    }

}
