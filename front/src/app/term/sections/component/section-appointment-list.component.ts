import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Appointment} from "../../appointments/appointment.interface";
import {Section} from "../section.interface";
import {Store} from "@ngrx/store";
import {ActivatedRoute, Router} from "@angular/router";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {AppointmentCreateTaskCreatorDialog} from "../../appointments/dialog/appointment-create-task-creator.dialog";

@Component({
  selector: 'pams-section-appointment-list',
  templateUrl: './section-appointment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class SectionAppointmentListComponent {

  @Input() section: Section;
  @Input() appointments: Appointment[];
  @Output() view = new EventEmitter<Appointment>();


  private creatorDialogRef: MdDialogRef<AppointmentCreateTaskCreatorDialog>;

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'staff.name', label: 'Staff'},
    {name: 'staff.identityNo', label: 'IdentityNo'},
    {name: 'appointmentStatus', label: 'Appointment Status'},
    {name: 'action', label: ''}
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AppointmentCreateTaskCreatorDialog, config);
    this.creatorDialogRef.componentInstance.section = this.section;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
}


