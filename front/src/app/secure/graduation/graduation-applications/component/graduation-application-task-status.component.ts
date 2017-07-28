import { GraduationApplicationTask } from '../../../../shared/model/graduation/graduation-application-task.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
    selector: 'pams-graduation-application-task-status',
    templateUrl:'./graduation-application-task-status.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GraduationApplicationTaskStatusComponent{
    @Input() graduationApplicationTask: GraduationApplicationTask;
}
