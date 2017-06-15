import { MdSnackBar } from '@angular/material';
import { AdmissionApplicationTask } from './../admission-application-task.interface';
import { Component, Input, Output, ChangeDetectionStrategy, EventEmitter } from '@angular/core';
@Component({
  selector: 'pams-pooled-admission-application-task-list',
  templateUrl: './pooled-admission-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PooledAdmissionApplicationTaskListComponent {

  @Input() admissionApplicationTasks: AdmissionApplicationTask[];
  @Output() claim = new EventEmitter<AdmissionApplicationTask>();

  private columns: any[] = [
    { name: 'referenceNo', label: 'Reference No' },
    { name: 'application.actor.name', label: 'Advisor ID' },
    { name: 'application.student.cohort.program.code', label: 'Program' },
    { name: 'application.academicSession.code', label: 'Academic Session' },
    { name: 'application.student.identityNo', label: 'Student ID' },
    { name: 'application.studyCenter.description', label: 'Study Center' },
    { name: 'flowState', label: 'Status' },
    { name: 'action', label: '' },
  ];

  constructor(private snackBar: MdSnackBar) {
  }

  claimTask(task: AdmissionApplicationTask): void {
    console.log("Emitting task");
    let snackBarRef = this.snackBar.open("Claiming registration application", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.claim.emit(task);
    });
  }
}