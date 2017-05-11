import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {TermService} from "../../../../services/term.service";
import {Appointment} from "../appointment.interface";
import {AppointmentActions} from "../appointment.action";
import {MdDialog} from '@angular/material';


@Component({
  selector: 'pams-appointment-editor',
  templateUrl: './appointment-editor.dialog.html',
})

export class AppointmentEditorDialog implements OnInit {

  private appointment: Appointment;
  private editForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: AppointmentActions,
              public dialog: MdDialog,
              private viewContainerRef: ViewContainerRef) {
  }
  
  openDialog(): void {
      this.dialog.open(AppointmentEditorDialog, {
        height: '50%', // can be px or %
        width: '60%', // can be px or %
      });
    }

  ngOnInit(): void {
   /* this.editForm = this.formBuilder.group(<Offering>{
      id: null,
      code: '',
     });

    this.editForm.patchValue(this.offering);*/
  }

  save(appointment: Appointment, isValid: boolean) {
    // do something
  }
}
