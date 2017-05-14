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
    { name: 'student.name', label: 'StudentName' },
    { name: 'student.identityNo', label: 'StudentIC' },
    { name: 'academicSession.description', label: 'AcademicSession' },
    { name: 'cohort.code', label: 'Cohort' },
    { name: 'gpa', label: 'GPA' },
    { name: 'cgpa', label: 'CGPA' },
    { name: 'action', label: '' }
  ];
}
