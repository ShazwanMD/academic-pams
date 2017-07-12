import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Staff} from "../staff.interface";
import { MdDialog } from "@angular/material";
import { ActivatedRoute, Router } from "@angular/router";
import { Store } from "@ngrx/store";
import { IdentityModuleState } from "../../index";

@Component({
    selector: 'pams-staff',
    templateUrl: './staff.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StaffComponent {

    @Input() imgPath:string = "./../assets/ico/lecturer/"; //.\..\assets\ico\01001A.jpg  //--  "app/header/"
    imgFileName:string = "01001A.jpg";
     
    @Input() staff: Staff;
    @Output() view = new EventEmitter<Staff>();
    
    constructor(private router: Router,
        private route: ActivatedRoute,
        private store: Store<IdentityModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
    }


}
