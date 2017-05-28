import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {GraduationApplicationTask} from "./graduation-application-task.interface";
import {Observable} from "rxjs";
import {GraduationModuleState} from "../index";
import {Store} from "@ngrx/store";
import {GraduationApplicationActions} from "./graduation-application.action";


@Component({
  selector: 'pams-graduation-application-task-iew',
  templateUrl: './graduation-application-task-view.page.html',
})
export class GraduationApplicationTaskViewPage implements OnInit {

  private GRADUATION_APPLICATION_TASK = "graduationModuleState.graduationApplicationTask".split(".");
  private graduationApplicationTask$: Observable<GraduationApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<GraduationModuleState>,
              private actions: GraduationApplicationActions) {
    this.graduationApplicationTask$ = this.store.select(...this.GRADUATION_APPLICATION_TASK)
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {taskId: string}) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findGraduationApplicationTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/graduation/graduationApplications']);
  }
}


