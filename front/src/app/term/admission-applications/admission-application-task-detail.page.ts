import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {AdmissionApplicationTask} from '../../shared/model/term/admission-application-task.interface';
import {TermModuleState} from '../index';
import {AdmissionApplicationActions} from './admission-application.action';

@Component({
  selector: 'pams-admission-application-task-detail',
  templateUrl: './admission-application-task-detail.page.html',
})
export class AdmissionApplicationTaskDetailPage implements OnInit {

  private ADMISSION_APPLICATION_TASK: string[] = 'termModuleState.admissionApplicationTask'.split('.');
  private admissionApplicationTask$: Observable<AdmissionApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions) {
    this.admissionApplicationTask$ = this.store.select(...this.ADMISSION_APPLICATION_TASK);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findAdmissionApplicationTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/term/admission-applications']);
  }
}

