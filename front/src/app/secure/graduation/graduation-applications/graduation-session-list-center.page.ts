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
import { AcademicSession } from "../../../shared/model/planner/academic-session.interface";
import { AcademicSessionActions } from "../../planner/academic-sessions/academic-session.action";

@Component( {
    selector: 'pams-graduation-session-list-center',
    templateUrl: './graduation-session-list-center.page.html',
} )

export class GraduationSessionListCenterPage implements OnInit {

    private GRADUATIONS: string[] = 'graduationModuleState.graduations'.split( '.' );
    private ACADEMIC_SESSIONS: string[] = 'plannerModuleState.academicSessions'.split( '.' );
    private graduations$: Observable<Graduation[]>;
    private academicSessions$: Observable<AcademicSession[]>;
    private creatorDialogRef: MdDialogRef<GraduationApplicationCreatorDialog>;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private vcf: ViewContainerRef,
        private actions: GraduationApplicationActions,
        private actions2: AcademicSessionActions,
        private store: Store<GraduationModuleState>,
        private dialog: MdDialog ) {

        this.graduations$ = this.store.select( ...this.GRADUATIONS );
        this.academicSessions$ = this.store.select( ...this.ACADEMIC_SESSIONS );
    }

    ngOnInit(): void {
        console.log( 'find graduations by sessions' );
        //this.store.dispatch( this.actions.findGraduations() );
        this.store.dispatch( this.actions2.findAcademicSessions() );

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
