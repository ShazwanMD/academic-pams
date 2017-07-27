import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {MdDialogRef, MdDialog, MdDialogConfig, MdSnackBar} from "@angular/material";
import {GraduationApplicationTask} from "../../../shared/model/graduation/graduation-application-task.interface";

@Component({
  selector: 'pams-pooled-graduation-application-task-list',
  templateUrl: './pooled-graduation-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PooledGraduationApplicationTaskListComponent {

  @Input() graduationApplicationTasks: GraduationApplicationTask[];
  @Output() claim = new EventEmitter<GraduationApplicationTask>();

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

  claimTask(task: GraduationApplicationTask): void {
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Claiming Graduate Applicant", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.claim.emit(task);
    });
  }
}
