import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output } from '@angular/core';
import { MdSnackBar } from '@angular/material';
import { GraduationApplicationTask } from '../../../../shared/model/graduation/graduation-application-task.interface';

@Component( {
    selector: 'pams-assigned-graduation-application-task-list',
    templateUrl: './assigned-graduation-application-task-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class AssignedGraduationApplicationTaskListComponent {

    @Input() graduationApplicationTasks: GraduationApplicationTask[];
    @Output() view = new EventEmitter<GraduationApplicationTask>();

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

    constructor( private snackBar: MdSnackBar ) {
    }

    viewTask( task: GraduationApplicationTask ): void {
        console.log( 'Emitting task' );
        let snackBarRef = this.snackBar.open( 'Viewing Graduate Applicant', '' , { duration: 3000 }  );
        snackBarRef.afterDismissed().subscribe(() => {
            this.view.emit( task );
        } );
    }
}
