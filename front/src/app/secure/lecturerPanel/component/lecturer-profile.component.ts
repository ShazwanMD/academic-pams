import { LecturerActions } from './../lecturer.action';
import { LecturerModuleState } from './../index';
import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef, OnInit } from '@angular/core';
import { MdDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Staff } from "../../../shared/model/identity/staff.interface";
import { Observable } from 'rxjs';
import { Appointment } from "../../../shared/model/term/appointment.interface";
import { AdmissionApplication } from "../../../shared/model/term/admission-application.interface";
import { Admission } from "../../../shared/model/term/admission.interface";

@Component( {
    selector: 'pams-lecturer-profile',
    templateUrl: 'lecturer-profile.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class LecturerProfileComponent implements OnInit {

    private selectedRows: Appointment[];
  
    @Input() lecturer: Staff;
    @Input() appointments: Appointment[];
    @Input() admissionApplications: AdmissionApplication[];
    @Input() admissions: Admission[];
    
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
        { name: 'section.ordinal', label: 'Section No.' },
         { name: 'section.code', label: 'Section Code.' },
         { name: 'section.offering.academicSession.code', label: 'Academic Session' },
        { name: 'section.offering.titleEn', label: 'Title' },
        { name: 'section.offering.program.code', label: 'Program' },
        { name: 'section.offering.program.faculty.name', label: 'Faculty' },
        { name: 'action', label: '' },
    ];
    
    //view data admissions to review supervision 
    private columnAdmission: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'academicSession.code', label: 'Academic Session' },
        { name: 'student.name', label: 'Student Name' },
        { name: 'student.identityNo', label: 'Student Identity No.' },
        { name: 'ordinal', label: 'Semester' },
        { name: 'cgpa', label: 'CGPA' },
        { name: 'gpa', label: 'GPA' },
        { name: 'studyCenter.description', label: 'Study Center' },
        
        
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
