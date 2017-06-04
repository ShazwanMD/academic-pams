import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {MdSnackBar} from "@angular/material";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";

@Component({
  selector: 'pams-assigned-enrollment-application-task-list',
  templateUrl: './assigned-enrollment-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedEnrollmentApplicationTaskListComponent {

  @Input() enrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() view = new EventEmitter<EnrollmentApplicationTask>();

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'application.admission.student.identityNo', label: 'Student'},
    {name: 'description', label: 'Description'},
    {name: 'application.admission.cgpa', label: 'CGPA'},
    {name: 'application.admission.cohort.code', label: 'Cohort'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];

  constructor(private snackBar: MdSnackBar) {
  }

  viewTask(task: EnrollmentApplicationTask): void {
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Viewing enrollmentApplication", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
