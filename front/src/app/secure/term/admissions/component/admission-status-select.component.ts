import {AdmissionStatus} from '../../../../shared/model/term/admission-status.enum';
import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'pams-admission-status-select',
  templateUrl: './admission-status-select.component.html',
  styleUrls: ['./admission-status-select.scss'],
})

export class AdmissionStatusSelectComponent implements OnInit {
  private statuses: AdmissionStatus[] = <AdmissionStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;


  constructor() {
    for (var n in AdmissionStatus) {
      if (typeof AdmissionStatus[n] === 'string')
        this.statuses.push(AdmissionStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AdmissionStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
