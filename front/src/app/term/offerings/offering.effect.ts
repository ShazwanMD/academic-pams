import { SectionActions } from '../sections/section.action';
import { PlannerService } from '../../../services/planner.service';
import { CourseActions } from '../../planner/courses/course.action';
import { ProgramActions } from '../../planner/programs/program.action';
import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { OfferingActions } from './offering.action';
import { TermService } from '../../../services/term.service';
import { from } from 'rxjs/observable/from';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../index';
import { Offering } from './offering.interface';

@Injectable()
export class OfferingEffects {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');

  constructor(private actions$: Actions,
    private offeringActions: OfferingActions,
    private programActions: ProgramActions,
    private courseActions: CourseActions,
    private sectionActions: SectionActions,
    private termService: TermService,
    private plannerService: PlannerService,
    private store$: Store<TermModuleState>) {
  }

  @Effect() findOfferings$ = this.actions$
    .ofType(OfferingActions.FIND_OFFERINGS)
    .switchMap(() => this.termService.findOfferings())
    .map((offerings) => this.offeringActions.findOfferingsSuccess(offerings));

  @Effect() findOfferingByCanonicalCode$ = this.actions$
    .ofType(OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE)
    .map((action) => action.payload)
    .switchMap((canonicalCode) => this.termService.findOfferingByCanonicalCode(canonicalCode))
    .map((offering) => this.offeringActions.findOfferingByCanonicalCodeSuccess(offering))
    .mergeMap((action) => from([action,
      this.offeringActions.findSectionsByOffering(action.payload),
      this.offeringActions.findAssessmentsByOffering(action.payload),
    ]));

  @Effect() findSectionsByOffering$ = this.actions$
    .ofType(OfferingActions.FIND_SECTIONS_BY_OFFERING)
    .map((action) => action.payload)
    .switchMap((offering) => this.termService.findSectionsByOffering(offering))
    .map((sections) => this.offeringActions.findSectionsByOfferingSuccess(sections));

  @Effect() findAssessmentsByOffering$ = this.actions$
    .ofType(OfferingActions.FIND_ASSESSMENTS_BY_OFFERING)
    .map((action) => action.payload)
    .switchMap((offering) => this.termService.findAssessmentsByOffering(offering))
    .map((sections) => this.offeringActions.findAssessmentsByOfferingSuccess(sections));

  @Effect() findGradebookMatrices = this.actions$
    .ofType(OfferingActions.FIND_GRADEBOOK_MATRICESS_BY_OFFERING)
    .map((action) => action.payload)
    .switchMap((offering) => this.termService.findGradebookMatricesByOffering(offering))
    .map((sections) => this.offeringActions.findGradebookMatricessByOfferingSuccess(sections));

  @Effect() saveOffering$ = this.actions$
    .ofType(OfferingActions.SAVE_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.saveOffering(payload.program, payload.course, payload.offering))
    .map((offering) => this.offeringActions.saveOfferingSuccess(offering))
    .mergeMap((action) => from([action, this.offeringActions.findOfferings()]))
    .catch((error) => {
      console.error('error ' + error.errorMessage);
      return Observable.empty();
    });

  @Effect() updateOfferings$ = this.actions$
    .ofType(OfferingActions.UPDATE_OFFERING)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.updateOffering(payload))
    .map((message) => this.offeringActions.updateOfferingSuccess(message))

    .withLatestFrom(this.store$.select(...this.OFFERING))
    .map((state) => state[1])
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));

  @Effect() uploadGradebook$ = this.actions$
    .ofType(OfferingActions.UPLOAD_GRADEBOOK)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.uploadGradebook(payload.offering, payload.file))
    .map((message) => this.offeringActions.uploadGradebookSuccess(message))
    .withLatestFrom(this.store$.select(...this.OFFERING))
    .map((state) => state[1])
    .map((offering: Offering) => this.offeringActions.findGradebookMatricessByOffering(offering));

  @Effect() downloadGradebook$ = this.actions$
    .ofType(OfferingActions.DOWNLOAD_GRADEBOOK)
    .map((action) => action.payload)
    .switchMap((offering) => this.termService.downloadGradebook(offering))
    .map((file) => {
      let url = URL.createObjectURL(file);
      let a = document.createElement('a');
      a.href = url;
      a.download = file.name;
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
      URL.revokeObjectURL(url);
    }).ignoreElements();

  @Effect() calculateGradebook$ = this.actions$
    .ofType(OfferingActions.CALCULATE_GRADEBOOK)
    .map((action) => action.payload)
    .switchMap((offering) => this.termService.calculateGradebook(offering))
    .map((message) => this.offeringActions.calculateGradebookSuccess(message));

  @Effect() calculateGPA$ = this.actions$
    .ofType(OfferingActions.CALCULATE_GPA)
    .map((action) => action.payload)
    .switchMap((offering) => this.termService.calculateGPA(offering))
    .map((message) => this.offeringActions.calculateGPASuccess(message));
}

