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
    { name: 'actor.name', label: 'Advisor' },
    { name: 'program.code', label: 'Program' },
    { name: 'academicSession.code', label: 'Academic Session' },
    { name: 'student.identityNo', label: 'Student' },
    { name: 'studyCenter.code', label: 'Study Center' },
    { name: 'flowState', label: 'Status' },
    { name: 'action', label: '' }

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