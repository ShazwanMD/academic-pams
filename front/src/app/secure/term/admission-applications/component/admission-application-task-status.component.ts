import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {AdmissionApplicationTask} from '../../../../shared/model/term/admission-application-task.interface';

@Component({
  selector: 'pams-admission-application-task-status',
  templateUrl: './admission-application-task-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class AdmissionApplicationTaskStatusComponent {
  @Input() admissionApplicationTask: AdmissionApplicationTask;
}
