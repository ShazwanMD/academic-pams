import { MdSnackBar } from '@angular/material';
import { AdmissionApplicationTask } from '../admission-application-task.interface';
import { Component, ChangeDetectionStrategy, EventEmitter, Output, Input } from '@angular/core';

@Component({
  selector: 'pams-assigned-admission-application-task-list',
  templateUrl: './assigned-admission-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedAdmissionApplicationTaskListComponent {

  private columns: any[] = [
    { name: 'referenceNo', label: 'Reference No' },
    { name: 'actor.name', label: 'Advisor' },
    { name: 'application.student.cohort.program.code', label: 'Program' },
    { name: 'application.academicSession.code', label: 'Academic Session' },
    { name: 'application.student.name', label: 'Student' },
    { name: 'studyCenter.code', label: 'Study Center' },
    { name: 'flowState', label: 'Status' },
    { name: 'action', label: '' },
  ];

  @Input() admissionApplicationTasks: AdmissionApplicationTask[];
  @Output() view = new EventEmitter<AdmissionApplicationTask>();

  constructor(private snackBar: MdSnackBar) {
  }

  viewTask(task: AdmissionApplicationTask): void {
    console.log('viewing task');
    let snackBarRef = this.snackBar.open('Viewing semester registration', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
