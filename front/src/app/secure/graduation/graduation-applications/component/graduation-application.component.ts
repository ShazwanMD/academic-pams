import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { GraduationApplication } from '../../../../shared/model/graduation/graduation-application.interface';

@Component( {
    selector: 'pams-graduation-application',
    templateUrl: './graduation-application.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class GraduationApplicationComponent {

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'action', label: '' },
    ];

    @Input() graduationApplication: GraduationApplication;
}

