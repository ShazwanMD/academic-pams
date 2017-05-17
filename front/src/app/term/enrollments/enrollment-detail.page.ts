import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Enrollment} from "./enrollment.interface";
import {EnrollmentActions} from "./enrollment.action";
import {TermModuleState} from "../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {EnrollmentApplicationTaskCreatorDialog} from "../enrollment-applications/dialog/enrollment-application-task-creator.dialog";

@Component({
  selector: 'pams-enrollment-detail',
  templateUrl: './enrollment-detail.page.html',
})

export class EnrollmentDetailPage implements OnInit {

  private ENROLLMENT = "termModuleState.enrollment".split(".");
  private enrollment$: Observable<Enrollment>;
  private creatorDialogRef: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.enrollment$ = this.store.select(...this.ENROLLMENT);
  }

     showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EnrollmentApplicationTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
    
  ngOnInit(): void {
    this.route.params.subscribe((params: { id: string }) => {
      let id: string = params.id;
      this.store.dispatch(this.actions.findEnrollmentById(id));
    });
  }


  goBack(route: string): void {
    this.router.navigate(['/enrollments']);
  }
}

