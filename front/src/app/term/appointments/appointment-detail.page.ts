import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Appointment} from "./appointment.interface";
import {AppointmentActions} from "./appointment.action";
import {TermModuleState} from "../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import { AppointmentEditorDialog } from "./dialog/appointment-editor.dialog";

@Component({
  selector: 'pams-appointment-detail',
  templateUrl: './appointment-detail.page.html',
})

export class AppointmentDetailPage implements OnInit {

  private APPOINTMENT: string[] = "termModuleState.appointment".split(".");
  private appointment$: Observable<Appointment>;
  private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AppointmentActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.appointment$ = this.store.select(...this.APPOINTMENT);
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '45%';
    config.position = {top: '3px'};
    this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: string }) => {
      let id: string = params.id;
      this.store.dispatch(this.actions.findAppointmentById(id));
      //this.appointment$ = this.termService.findAppointmentByCanonicalCode(canonicalCode);


    });
  }

  goBack(route: string): void {
    this.router.navigate(['/appointments']);
  }
}

