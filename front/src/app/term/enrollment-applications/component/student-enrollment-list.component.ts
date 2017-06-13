import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {MdSnackBar} from "@angular/material";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";

@Component({
  selector: 'pams-student-enrollment-list',
  templateUrl: './student-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentEnrollmentListComponent {

  @Input() studentEnrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() view = new EventEmitter<EnrollmentApplicationTask>();

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'application.admission.student.identityNo', label: 'Student ID'},
    {name: 'application.admission.student.name', label: 'Name'},
    {name: 'application.admission.cgpa', label: 'CGPA'},
    {name: 'application.admission.cohort.code', label: 'Cohort'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];

  constructor(private snackBar: MdSnackBar) {
  }

  viewTask(task: EnrollmentApplicationTask): void {
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Viewing enrollment application", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
