import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
//import {OfferingUpdateDialog} from "./dialog/offering-update.dialog";
import {IdentityService} from '../../../services';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {AdmissionApplication} from "./admission-application.interface";
import {AdmissionApplicationActions} from "./admission-application.action";
import {TermModuleState} from "../index";
import {Section} from "../sections/section.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {Enrollment} from "../enrollments/enrollment.interface";
import {Appointment} from "../appointments/appointment.interface";
import {Assessment} from "../assessments/assessment.interface";

@Component({
  selector: 'pams-student-admission-application-detail',
  templateUrl: './student-admission-application-detail.page.html',
})

export class StudentAdmissionApplicationDetailPage implements OnInit {

  @Input() admissionApplication: AdmissionApplication;

  private ADMISSION_APPLICATION: string[] = "termModuleState.admissionApplication".split(".");
  
  private admissionApplication$: Observable<AdmissionApplication>;
 
  //private editorDialogRef: MdDialogRef<OfferingUpdateDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.admissionApplication$ = this.store.select(...this.ADMISSION_APPLICATION);
   
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findAdmissionApplicationByReferenceNo(referenceNo));
    });
  }

 
    filter(): void {

  }

  goBack(route: string): void {
    this.router.navigate(['/admission-applications']);
  }
  
 
  
}

