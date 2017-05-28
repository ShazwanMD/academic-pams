import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Section} from '../../sections/section.interface';
import {Enrollment} from "../../enrollments/enrollment.interface";
import {Offering} from "../offering.interface";

@Component({
  selector: 'pams-offering-enrollment-list',
  templateUrl: './offering-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingEnrollmentListComponent {

  @Input() offering: Offering;
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

