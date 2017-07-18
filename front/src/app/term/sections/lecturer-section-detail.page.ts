import { Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { TermService } from '../../../services';
import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { Section } from "./section.interface";
import { SectionActions } from "./section.action";
import { TermModuleState } from "../index";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import { Appointment } from "../appointments/appointment.interface";
import { Enrollment } from "../enrollments/enrollment.interface";
import { Offering } from "../offerings/offering.interface";
import { Gradebook } from "../gradebooks/gradebook.interface";

@Component( {
    selector: 'pams-lecturer-section-detail',
    templateUrl: './lecturer-section-detail.page.html',
} )

export class LecturerSectionDetailPage implements OnInit {

    @Input() section: Section;
    @Input() offering: Offering;

    private OFFERING: string[] = "termModuleState.offering".split( "." );
    private SECTION: string[] = "termModuleState.section".split( "." );
    private ENROLLMENTS: string[] = "termModuleState.enrollments".split( "." );
    private GRADEBOOKS: string[] = "termModuleState.gradebooks".split( "." );

    private offering$: Observable<Offering>;
    private section$: Observable<Section>;
    private gradebooks$: Observable<Gradebook[]>;
    private enrollments$: Observable<Enrollment[]>;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: SectionActions,
        private termService: TermService,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {


        this.section$ = this.store.select( ...this.SECTION );
        this.offering$ = this.store.select( ...this.OFFERING );
        this.enrollments$ = this.store.select( ...this.ENROLLMENTS );
        this.gradebooks$ = this.store.select( ...this.GRADEBOOKS );
    }

    showDialog(): void {
    }

    showDialogDel(): void {
    }

    ngOnInit(): void {
        this.route.params.subscribe(( params: { canonicalCode: string } ) => {
            let canonicalCode: string = params.canonicalCode;
            this.store.dispatch( this.actions.findSectionByCanonicalCode( canonicalCode ) );
        } );
    }

    goBack( route: string ): void {
        this.router.navigate( ['/sections'] );
    }
}
