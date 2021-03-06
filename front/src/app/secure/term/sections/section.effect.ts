import { Injectable } from '@angular/core';
import { Actions, Effect } from '@ngrx/effects';
import { SectionActions } from './section.action';
import { TermService } from '../../../../services/term.service';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../index';
import { OfferingActions } from '../offerings/offering.action';
import { Offering } from '../../../shared/model/term/offering.interface';
import { from } from 'rxjs/observable/from';
import { NotificationService } from '../../../../services/notification.service';

@Injectable()
export class SectionEffects {

    private OFFERING: string[] = 'termModuleState.offering'.split( '.' );
    private SECTION: string[] = 'termModuleState.section'.split( '.' );

    constructor( private actions$: Actions,
        private sectionActions: SectionActions,
        private offeringActions: OfferingActions,
        private termService: TermService,
        private notificationService: NotificationService,
        private store$: Store<TermModuleState> ) {
    }

    @Effect() findSections$ = this.actions$
        .ofType( SectionActions.FIND_SECTIONS )
        .switchMap(() => this.termService.findSections() )
        .map(( sections ) => this.sectionActions.findSectionsSuccess( sections ) );

    @Effect() findSectionByCanonicalCode$ = this.actions$
        .ofType( SectionActions.FIND_SECTION_BY_CANONICAL_CODE )
        .map(( action ) => action.payload )
        .switchMap(( canonicalCode ) => this.termService.findSectionByCanonicalCode( canonicalCode ) )
        .map(( section ) => this.sectionActions.findSectionByCanonicalCodeSuccess( section ) )
        .mergeMap(( action ) => from( [action,
            this.sectionActions.findEnrollmentsBySection( action.payload ),
            this.sectionActions.findGradebooksBySection( action.payload ),
            this.sectionActions.findAppointmentsBySection( action.payload )] ) );

    @Effect() findSectionById$ = this.actions$
        .ofType( SectionActions.FIND_SECTION_BY_ID )
        .map(( action ) => action.payload )
        .switchMap(( id ) => this.termService.findSectionById( id ) )
        .map(( section ) => this.sectionActions.findSectionByIdSuccess( section ) )
        .mergeMap(( action ) => from( [action,
            this.sectionActions.findEnrollmentsBySection( action.payload ),
            this.sectionActions.findGradebooksBySection( action.payload ),
            this.sectionActions.findAppointmentsBySection( action.payload )] ) );


    @Effect() findEnrollmentsBySection$ = this.actions$
        .ofType( SectionActions.FIND_ENROLLMENTS_BY_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( section ) => this.termService.findEnrollmentsBySection( section ) )
        .map(( sections ) => this.sectionActions.findEnrollmentsBySectionSuccess( sections ) );

    @Effect() findGradebooksBySection$ = this.actions$
        .ofType( SectionActions.FIND_GRADEBOOKS_BY_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( section ) => this.termService.findGradebooksBySection( section ) )
        .map(( sections ) => this.sectionActions.findGradebooksBySectionSuccess( sections ) );

    @Effect() findGradebookMatrices = this.actions$
        .ofType( SectionActions.FIND_GRADEBOOK_MATRICESS_BY_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( section ) => this.termService.findGradebookMatricesBySection( section ) )
        .map(( sections ) => this.sectionActions.findGradebookMatricessBySectionSuccess( sections ) );


    @Effect() findAppointmentsBySection$ = this.actions$
        .ofType( SectionActions.FIND_APPOINTMENTS_BY_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( section ) => this.termService.findAppointmentsBySection( section ) )
        .map(( sections ) => this.sectionActions.findAppointmentsBySectionSuccess( sections ) );

    @Effect() addSection$ =
    this.actions$
        .ofType( SectionActions.ADD_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.addSection( payload.offering, payload.section ) )
        .map(( message ) => this.sectionActions.addSectionSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.OFFERING ) )
        .map(( state ) => state[1] )
        .map(( offering: Offering ) => this.offeringActions.findOfferingByCanonicalCode( offering.canonicalCode ) );

    @Effect() deleteSection$ = this.actions$
        .ofType( SectionActions.REMOVE_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.deleteSection( payload.offering, payload.section ) )
        .map(( message ) => this.sectionActions.deleteSectionSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.OFFERING ) )
        .map(( state ) => state[1] )
        .map(( offering: Offering ) => this.offeringActions.findOfferingByCanonicalCode( offering.canonicalCode ) );

    @Effect() updateSection$ = this.actions$
        .ofType( SectionActions.UPDATE_SECTION )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.updateSection( payload.offering, payload.section ) )
        .map(( message ) => this.sectionActions.updateSectionSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.OFFERING ) )
        .map(( state ) => state[1] )
        .map(( offering: Offering ) => this.offeringActions.findOfferingByCanonicalCode( offering.canonicalCode ) );

}
