import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {EnrollmentApplicationTask} from "./enrollment-application-task.interface";
import {TermModuleState} from "../index";
import {EnrollmentApplicationActions} from "./enrollment-application.action";


@Component({
  selector: 'pams-enrollment-application-task-iew',
  templateUrl: './enrollment-application-task-view.page.html',
})
export class EnrollmentApplicationTaskViewPage implements OnInit {

  private ENROLLMENT_APPLICATION_TASK = "termModuleState.enrollmentApplicationTask".split(".");
  private enrollmentApplicationTask$: Observable<EnrollmentApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions) {
    this.enrollmentApplicationTask$ = this.store.select(...this.ENROLLMENT_APPLICATION_TASK)
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {taskId: string}) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findEnrollmentApplicationTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/term/enrollment-applications']);
  }
}


