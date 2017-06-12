import { MdSnackBar } from '@angular/material';
import { AdmissionApplicationTask } from './../admission-application-task.interface';
import { Component, ChangeDetectionStrategy, EventEmitter, Output, Input } from '@angular/core';

@Component({
  selector: 'pams-assigned-admission-application-task-list',
  templateUrl: './assigned-admission-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssignedAdmissionApplicationTaskListComponent {

  @Input() admissionApplicationTasks: AdmissionApplicationTask[]; 
  @Output() view = new EventEmitter<AdmissionApplicationTask>();

  private columns: any[] = [

    {name: 'action', label: ''}
  ];

  constructor(private snackBar: MdSnackBar) {
  }

  viewTask(task: AdmissionApplicationTask): void {
    console.log("Approving task");
    let snackBarRef = this.snackBar.open("Viewing semester registration", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(task);
    });
  }
}
