import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output } from '@angular/core';
import { MdSnackBar } from '@angular/material';
import { GraduationApplicationTask } from '../../../../shared/model/graduation/graduation-application-task.interface';

@Component( {
    selector: 'pams-pooled-graduation-application-task-list',
    templateUrl: './pooled-graduation-application-task-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class PooledGraduationApplicationTaskListComponent {

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'referenceNo', label: 'ReferenceNo' },
        { name: 'student.identityNo', label: 'Student' },
        { name: 'description', label: 'Description' },
        { name: 'cgpa', label: 'CGPA' },
        { name: 'creditHour', label: 'Credit Hour' },
        { name: 'flowState', label: 'Status' },
        { name: 'action', label: '' },
    ];

    @Input() graduationApplicationTasks: GraduationApplicationTask[];
    @Output() claim = new EventEmitter<GraduationApplicationTask>();

    constructor( private snackBar: MdSnackBar ) {
    }

    claimTask( task: GraduationApplicationTask ): void {
        console.log( 'Emitting task' );
        let snackBarRef = this.snackBar.open( 'Claiming Graduate Applicant', 'OK' , { duration: 2000 }  );
        snackBarRef.afterDismissed().subscribe(() => {
            this.claim.emit( task );
        } );
    }
}
