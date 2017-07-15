import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {EnrollmentApplicationTask} from "./enrollment-application-task.interface";
import {TermModuleState} from "../index";
import {EnrollmentApplicationActions} from "./enrollment-application.action";
import {EnrollmentApplication} from "./enrollment-application.interface";
import { Admission } from "../admissions/admission.interface";
import { EnrollmentApplicationItem } from "./enrollment-application-item.interface";
import { TermService } from "../../../services/term.service";

@Component({
  selector: 'pams-enrollment-application-detail',
  templateUrl: './enrollment-application-detail.page.html',
})
export class EnrollmentApplicationDetailPage implements OnInit {
    
    @Input() enrollmentApplication: EnrollmentApplication;
    @Input() admission: Admission;
    
    private ENROLLMENT_APPLICATION: string[] = "termModuleState.enrollmentApplication".split(".");
    private ADMISSION: string[] = "termModuleState.admission".split(".");
    private ENROLLMENT_APPLICATION_ITEMS: string[] = "termModuleState.enrollmentApplicationItems".split(".");

    private admission$: Observable<Admission>;
    private enrollmentApplication$: Observable<EnrollmentApplication>;
    private enrollmentApplicationItems$: Observable<EnrollmentApplicationItem[]>;
    
    
  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private termService: TermService,
              private actions: EnrollmentApplicationActions) {
    
      this.enrollmentApplication$ = this.store.select(...this.ENROLLMENT_APPLICATION);
      this.admission$ = this.store.select(...this.ADMISSION);
      this.enrollmentApplicationItems$ = this.store.select(...this.ENROLLMENT_APPLICATION_ITEMS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findEnrollmentApplicationByReferenceNo(referenceNo));
    });
  }

  goBack(): void {
    this.router.navigate(['/term/enrollment-applications']);
  }
}


