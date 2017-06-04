import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {MdSnackBar} from "@angular/material";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";

@Component({
  selector: 'pams-pooled-enrollment-application-task-list',
  templateUrl: './pooled-enrollment-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PooledEnrollmentApplicationTaskListComponent {

  @Input() enrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() claim = new EventEmitter<EnrollmentApplicationTask>();

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'student.identityNo', label: 'Student'},
    {name: 'cgpa', label: 'CGPA'},
    {name: 'creditHour', label: 'Credit Hour'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];

  constructor(private snackBar: MdSnackBar) {
  }

  claimTask(task: EnrollmentApplicationTask): void {
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Claiming enrollmentApplication", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.claim.emit(task);
    });
  }
}
