import { Component, Input, OnInit, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
//import { OfferingUpdateDialog } from './dialog/offering-update.dialog';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Offering } from '../../../shared/model/term/offering.interface';
import { GraduationModuleState } from '../index';
import { Section } from '../../../shared/model/term/section.interface';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { Assessment } from '../../../shared/model/term/assessment.interface';
import { GraduationApplication } from "../../../shared/model/graduation/graduation-application.interface";
import { GraduationApplicationActions } from "./graduation-application.action";
import { Graduation } from "../../../shared/model/graduation/graduation.interface";

@Component( {
    selector: 'pams-graduation-session-detail',
    templateUrl: './graduation-session-detail.page.html',
} )

export class GraduationSessionDetailPage implements OnInit {

    private GRADUATION: string[] = 'graduationModuleState.graduation'.split( '.' );
    private graduation$: Observable<Graduation>;
   

    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: GraduationApplicationActions,
        private store: Store<GraduationModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {

        this.graduation$ = this.store.select( ...this.GRADUATION );
        
    }

    ngOnInit(): void {
        this.route.params.subscribe(( params: { referenceNo: string } ) => {
            let referenceNo: string = params.referenceNo;
            this.store.dispatch( this.actions.findGraduationApplicationByReferenceNo( referenceNo ) );
        } );
    }

    /*showUpdateDialog(): void {
        console.log( 'edit graduationApplication' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '40%';
        config.position = { top: '0px' };
        this.editorDialogRef = this.dialog.open( OfferingUpdateDialog, config );
        this.editorDialogRef.componentInstance.graduationApplication = this.graduationApplication;

        // set
        this.editorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog update graduationApplication' );
        } );
    }*/

    filter(): void {

    }

    goBack( route: string ): void {
        this.router.navigate( ['/graduation-applications'] );
    }

    

}

