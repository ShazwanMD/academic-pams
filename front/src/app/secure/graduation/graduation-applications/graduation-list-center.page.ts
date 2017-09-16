import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GraduationModuleState } from '../index';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { GraduationApplicationActions } from './graduation-application.action';
import { GraduationApplication } from "../../../shared/model/graduation/graduation-application.interface";
import { ProfileActions } from "../../profile/profile.action";

@Component( {
    selector: 'pams-graduation-list-center',
    templateUrl: './graduation-list-center.page.html',
} )

export class GraduationListCenterPage implements OnInit {

    private GRADUATION_APPLICATIONS: string[] = 'graduationModuleState.graduationApplications'.split( '.' );
    private graduationApplications$: Observable<GraduationApplication[]>;
   
    constructor( private router: Router,
        private route: ActivatedRoute,
        private vcf: ViewContainerRef,
        private actions: GraduationApplicationActions,
        private store: Store<GraduationModuleState>,
        private dialog: MdDialog ) {
 
        this.graduationApplications$ = this.store.select( ...this.GRADUATION_APPLICATIONS );
    }

    ngOnInit(): void {
        console.log( 'find graduation applications students' );
        this.store.dispatch( this.actions.findGraduationApplications() );


    }
}
