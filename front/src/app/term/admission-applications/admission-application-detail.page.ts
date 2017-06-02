import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { MdDialog } from '@angular/material';
import { AdmissionApplicationActions } from "./admission-application.action";
import { AdmissionApplication } from "./admission-application.interface";
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit, ViewContainerRef } from '@angular/core';
import { TermModuleState } from "../index";


@Component({
  selector: 'pams-admission-application-detail',
  templateUrl: './admission-application-detail.page.html',
})

export class AdmissionApplicationDetailPage implements OnInit {

  @Input() admissionApplication: AdmissionApplication;

  private ADMISSION_APPLICATION: string[] = "termModuleState.admissionApplication".split(".");

  private admissionApplication$: Observable<AdmissionApplication>;
 
  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: AdmissionApplicationActions,
    private store: Store<TermModuleState>,
    private vcf: ViewContainerRef,
    private dialog: MdDialog,
    private dialogDelete: MdDialog) {

      this.admissionApplication$ = this.store.select(...this.ADMISSION_APPLICATION);
   }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findAdmissionApplicationByReferenceNo(referenceNo));
    });
  }


}