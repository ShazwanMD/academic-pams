import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { Faculty } from '../faculty.interface';
import { selector } from 'rxjs/operator/multicast';

@Component({
  selector: 'pams-faculty-status',
  templateUrl: 'faculty-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})

export class FacultyStatusComponent {

    @Input() faculty: Faculty;
}