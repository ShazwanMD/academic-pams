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

@Component( {
    selector: 'pams-graduation-application-detail',
    templateUrl: './graduation-application-detail.page.html',
} )

export class GraduationApplicationDetailPage implements OnInit {

    private GRADUATION_APPLICATION: string[] = 'graduationModuleState.graduationApplication'.split( '.' );
    private graduationApplication$: Observable<GraduationApplication>;
   // private editorDialogRef: MdDialogRef<OfferingUpdateDialog>;

    //@Input() graduationApplication: GraduationApplication;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: GraduationApplicationActions,
        private store: Store<GraduationModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {

        this.graduationApplication$ = this.store.select( ...this.GRADUATION_APPLICATION );
        
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

