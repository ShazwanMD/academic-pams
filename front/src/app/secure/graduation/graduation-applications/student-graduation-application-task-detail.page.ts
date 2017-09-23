import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {GraduationApplicationTask} from '../../../shared/model/graduation/graduation-application-task.interface';
import {Observable} from 'rxjs';
import {GraduationModuleState} from '../index';
import {Store} from '@ngrx/store';
import {GraduationApplicationActions} from './graduation-application.action';

@Component({
  selector: 'pams-student-graduation-application-task-detail',
  templateUrl: './student-graduation-application-task-detail.page.html',
})
export class StudentGraduationApplicationTaskDetailPage implements OnInit {

  private GRADUATION_APPLICATION_TASK = 'graduationModuleState.graduationApplicationTask'.split('.');
  private graduationApplicationTask$: Observable<GraduationApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<GraduationModuleState>,
              private actions: GraduationApplicationActions) {
    this.graduationApplicationTask$ = this.store.select(...this.GRADUATION_APPLICATION_TASK);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findGraduationApplicationTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/secure/graduation/graduation-Applications']);
  }
}

