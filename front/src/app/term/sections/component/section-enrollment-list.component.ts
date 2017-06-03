import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Section} from '../section.interface';
import {Enrollment} from "../../enrollments/enrollment.interface";

@Component({
  selector: 'pams-section-enrollment-list',
  templateUrl: './section-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionEnrollmentListComponent {

  @Input() section: Section;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Section>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'admission.student.name', label: 'Student'},
    {name: 'admission.student.email', label: 'Email'},
    {name: 'enrollmentStatus', label: 'Status'},
    {name: 'enrollmentStanding', label: 'Standing'},
    {name: 'action', label: ''}
  ];
}
