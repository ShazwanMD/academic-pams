import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {GraduationApplication} from "../graduation-application.interface";

@Component({
  selector: 'pams-graduation-application',
  templateUrl: './graduation-application.component.html',

})
export class GraduationApplicationComponent {

  @Input() graduationApplication: GraduationApplication;
}
