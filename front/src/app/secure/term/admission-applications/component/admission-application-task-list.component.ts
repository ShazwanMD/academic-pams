import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {AdmissionApplicationTask} from '../../../../shared/model/term/admission-application-task.interface';

@Component({
  selector: 'pams-admission-application-task-list',
  templateUrl: './admission-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionApplicationTaskListComponent {

  @Input() admissionApplicationTasks: AdmissionApplicationTask[];
  @Output() view = new EventEmitter<AdmissionApplicationTask>();

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'description', label: 'Description'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];
}
