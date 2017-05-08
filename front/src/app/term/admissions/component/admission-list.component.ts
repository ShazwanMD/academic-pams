import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Admission} from "../admission.interface";

@Component({
  selector: 'pams-admission-list',
  templateUrl: './admission-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionListComponent {

  @Input() admissions: Admission[];
  @Output() view = new EventEmitter<Admission>();

  private columns: any[] = [
    {name: 'student', label: 'Student'},
    {name: 'gpa', label: 'GPA'},
    {name: 'cgpa', label: 'CGPA'},
    {name: 'action', label: ''}
  ];
}
