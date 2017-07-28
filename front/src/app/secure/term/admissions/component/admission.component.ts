import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Admission } from '../../../../shared/model/term/admission.interface';

@Component({
  selector: 'pams-admission',
  templateUrl: './admission.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionComponent {

  @Input() admission: Admission;
  @Output() view = new EventEmitter<Admission>();
}
