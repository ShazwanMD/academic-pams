import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Admission } from "../admission.interface";

@Component({
  selector: 'pams-admission-list',
  templateUrl: './admission-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionListComponent {

  @Input() admissions: Admission[];
  @Output() view = new EventEmitter<Admission>();

  private columns: any[] = [
    { name: 'student.name', label: 'Name' },
    { name: 'student.identityNo', label: 'Matric No' },
    { name: 'academicSession.code', label: 'Session' },
    { name: 'cohort.code', label: 'Cohort' },
    { name: 'action', label: '' }
  ];
}
