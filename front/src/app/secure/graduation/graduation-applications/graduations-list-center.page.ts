import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GraduationModuleState } from '../index';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { GraduationApplicationActions } from './graduation-application.action';
import { GraduationApplication } from "../../../shared/model/graduation/graduation-application.interface";
import { ProfileActions } from "../../profile/profile.action";
import { GraduationApplicationCreatorDialog } from "./dialog/graduation-application-creator.dialog";
import { Graduation } from "../../../shared/model/graduation/graduation.interface";

@Component( {
    selector: 'pams-graduations-list-center',
    templateUrl: './graduations-list-center.page.html',
} )

export class GraduationsListCenterPage implements OnInit {

    private GRADUATIONS: string[] = 'graduationModuleState.graduations'.split( '.' );
    private graduations$: Observable<Graduation[]>;
    private creatorDialogRef: MdDialogRef<GraduationApplicationCreatorDialog>;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private vcf: ViewContainerRef,
        private actions: GraduationApplicationActions,
        private store: Store<GraduationModuleState>,
        private dialog: MdDialog ) {

        this.graduations$ = this.store.select( ...this.GRADUATIONS );
    }

    ngOnInit(): void {
        console.log( 'find graduations students' );
        this.store.dispatch( this.actions.findGraduations() );

    }

    showDialog(): void {
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( GraduationApplicationCreatorDialog, config );
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }
}
