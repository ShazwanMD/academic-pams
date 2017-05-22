import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {AppointmentStatus} from "../appointment-status.enum";


@Component({
  selector: 'pams-appointment-status-select',
  templateUrl: './appointment-status-select.component.html',
})
export class AppointmentStatusSelectComponent implements OnInit {

  private appointmentStatuss: AppointmentStatus[] = <AppointmentStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in AppointmentStatus) {
      if(typeof AppointmentStatus[n] === 'string')
        this.appointmentStatuss.push(AppointmentStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AppointmentStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

