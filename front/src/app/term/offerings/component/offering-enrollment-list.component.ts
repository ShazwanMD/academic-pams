import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import { Section } from '../../sections/section.interface';
import {Enrollment} from "../../enrollments/enrollment.interface";

@Component({
  selector: 'pams-offering-enrollment-list',
  templateUrl: './offering-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingEnrollmentListComponent {

  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Section>();

      private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'action', label: '' }
  ];


}

