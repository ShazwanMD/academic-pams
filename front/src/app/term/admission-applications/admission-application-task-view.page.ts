import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {AdmissionApplicationTask} from "./admission-application-task.interface";
import {TermModuleState} from "../index";
import {AdmissionApplicationActions} from "./admission-application.action";


@Component({
  selector: 'pams-admission-application-task-view',
  templateUrl: './admission-application-task-view.page.html',
})
export class AdmissionApplicationTaskViewPage implements OnInit {

  private ADMISSION_APPLICATION_TASK = "termModuleState.admissionApplicationTask".split(".");
  private admissionApplicationTask$: Observable<AdmissionApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions) {
    this.admissionApplicationTask$ = this.store.select(...this.ADMISSION_APPLICATION_TASK)
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {taskId: string}) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findAdmissionApplicationTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/term/admission-applications']);
  }
}


