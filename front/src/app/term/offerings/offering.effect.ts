import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { OfferingActions } from "./offering.action";
import { TermService } from "../../../services/term.service";
import { from } from "rxjs/observable/from";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../index";
import { Offering } from './offering.interface';

@Injectable()
export class OfferingEffects {

    private OFFERING: string[] = "termModuleState.program".split( "." );

    constructor( private actions$: Actions,
        private offeringActions: OfferingActions,
        private termService: TermService,
        private store$: Store<TermModuleState> ) {
    }

    @Effect() findOfferings$ = this.actions$
        .ofType( OfferingActions.FIND_OFFERINGS )
        .switchMap(() => this.termService.findOfferings() )
        .map( offerings => this.offeringActions.findOfferingsSuccess( offerings ) );

    @Effect() findOfferingByCanonicalCode$ = this.actions$
        .ofType( OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE )
        .map( action => action.payload )
        .switchMap( canonicalCode => this.termService.findOfferingByCanonicalCode( canonicalCode ) )
        .map( offering => this.offeringActions.findOfferingByCanonicalCodeSuccess( offering ) )
        .mergeMap( action => from( [action,
            this.offeringActions.findSectionsByOffering( action.payload ),
            this.offeringActions.findAssessmentsByOffering( action.payload ),
            this.offeringActions.findEnrollmentsByOffering( action.payload ),
            this.offeringActions.findAppointmentsByOffering( action.payload )
        ] ) );

    @Effect() findSectionsByOffering$ = this.actions$
        .ofType( OfferingActions.FIND_SECTIONS_BY_OFFERING )
        .map( action => action.payload )
        .switchMap( offering => this.termService.findSectionsByOffering( offering ) )
        .map( sections => this.offeringActions.findSectionsByOfferingSuccess( sections ) );

    @Effect() findAssessmentsByOffering$ = this.actions$
        .ofType( OfferingActions.FIND_ASSESSMENTS_BY_OFFERING )
        .map( action => action.payload )
        .switchMap( offering => this.termService.findAssessmentsByOffering( offering ) )
        .map( sections => this.offeringActions.findAssessmentsByOfferingSuccess( sections ) );

    @Effect() findEnrollmentsByOffering$ = this.actions$
        .ofType( OfferingActions.FIND_ENROLLMENTS_BY_OFFERING )
        .map( action => action.payload )
        .switchMap( offering => this.termService.findEnrollmentsByOffering( offering ) )
        .map( sections => this.offeringActions.findEnrollmentsByOfferingSuccess( sections ) );

    @Effect() findAppointmentsByOffering$ = this.actions$
        .ofType( OfferingActions.FIND_APPOINTMENTS_BY_OFFERING )
        .map( action => action.payload )
        .switchMap( offering => this.termService.findAppointmentsByOffering( offering ) )
        .map( sections => this.offeringActions.findAppointmentsByOfferingSuccess( sections ) );

    @Effect() saveOffering$ = this.actions$
        .ofType( OfferingActions.SAVE_OFFERING )
        .map( action => action.payload )
        .switchMap( offering => this.termService.saveOffering( offering ) )
        .map( offering => this.offeringActions.saveOfferingSuccess( offering ) );

    //update offering
   /* @Effect() updateOfferings$ = this.actions$
        .ofType( OfferingActions.UPDATE_OFFERING )
        .map( action => action.payload )
        .switchMap( payload => this.termService.updateOffering( payload ) )
        .map( message => this.offeringActions.updateOfferingSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.OFFERING ) )
        .map( state => state[1] )
        .map(( offering: Offering ) => this.offeringActions.findOfferingByCanonicalCode( offering.canonicalCode ) );
    */
 
    //update offering
    
    @Effect() updateOffering$ = this.actions$
    .ofType(OfferingActions.UPDATE_OFFERING)
    .map(action => action.payload)
    .switchMap(payload => this.termService.updateOffering(payload))
    .map(message => this.offeringActions.updateOfferingSuccess(message))
    .withLatestFrom( this.store$.select( ...this.OFFERING ) )
    .map(state => state[1])
    //.mergeMap(action => from([action, this.offeringActions.findOfferings()]));
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));
    

}
