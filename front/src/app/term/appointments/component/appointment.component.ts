import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Appointment} from "../appointment.interface";
import { MdDialog } from "@angular/material";
import { ActivatedRoute, Router } from "@angular/router";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../../index";

@Component({
    selector: 'pams-appointment',
    templateUrl: './appointment.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppointmentComponent {

    @Input() imgPath:string = "./../assets/ico/"; //.\..\assets\ico\01001A.jpg  //--  "app/header/"
    imgFileName:string = "01001A.jpg";
     
    @Input() appointment: Appointment;
    @Output() view = new EventEmitter<Appointment>();
    
    constructor(private router: Router,
        private route: ActivatedRoute,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
    }


}
