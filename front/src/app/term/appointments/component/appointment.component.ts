import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Appointment} from "../appointment.interface";
import { MdDialog } from "@angular/material";
import { ActivatedRoute, Router } from "@angular/router";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../../index";

@Component({
  selector: 'pams-appointment',
  templateUrl: './appointment.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppointmentComponent {

  @Input() appointment: Appointment;
  @Output() view = new EventEmitter<Appointment>();
  // @Output() addComment = new EventEmitter<ProgramComment>();
  // @Output() addAttachment = new EventEmitter<ProgramAttachment>();
   
  constructor(private router: Router,
          private route: ActivatedRoute,
          private store: Store<TermModuleState>,
          private vcf: ViewContainerRef,
          private dialog: MdDialog) {
}
  
}
