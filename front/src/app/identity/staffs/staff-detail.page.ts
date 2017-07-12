import { Component, OnInit, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { IdentityService } from '../../../services';
import { TermService } from '../../../services';
import { CommonService } from '../../../services';
import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { Staff } from "./staff.interface";
import {StaffActions } from "./staff.action";
import { IdentityModuleState } from "../index";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";

@Component( {
    selector: 'pams-staff-detail',
    templateUrl: './staff-detail.page.html',
} )

export class StaffDetailPage implements OnInit {

    private STAFF: string[] = "identityModuleState.staff".split( "." );
    private staff$: Observable<Staff>;
  
    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: StaffActions,
        private termService: TermService,
        private store: Store<IdentityModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {

        this.staff$ = this.store.select( ...this.STAFF );    
    }

    ngOnInit(): void {
        this.route.params.subscribe(( params: { id: string } ) => {
            let id: string = params.id;
            this.store.dispatch( this.actions.findStaffById( id ) );
        } );
    }

    goBack( route: string ): void {
        this.router.navigate( ['/staffs'] );
    }
}

