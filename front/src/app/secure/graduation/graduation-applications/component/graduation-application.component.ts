import {Component, Input} from '@angular/core';
import {GraduationApplication} from '../../../../shared/model/graduation/graduation-application.interface';

@Component({
  selector: 'pams-graduation-application',
  templateUrl: './graduation-application.component.html',

})
export class GraduationApplicationComponent {

  @Input() graduationApplication: GraduationApplication;
}
