import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { Admission } from '../../../shared/model/term/admission.interface';

@Component( {
    selector: 'pams-profile-admission-list',
    templateUrl: 'profile-admission-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class ProfileAdmissionListComponent {

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'academicSession.code', label: 'Academic Session' },
        { name: 'cgpa', label: 'CGPA' },
        { name: 'gpa', label: 'GPA' },
        { name: 'creditEarned', label: 'Credit Earned' },
        { name: 'creditTaken', label: 'Credit Taken' },
        { name: 'standing', label: 'Standing' },
        { name: 'status', label: 'Status' },

    ];

    @Input() admissions: Admission[];
}
