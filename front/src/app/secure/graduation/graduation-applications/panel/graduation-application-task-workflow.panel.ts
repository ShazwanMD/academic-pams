import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input, AfterViewInit
} from '@angular/core';
import {Observable} from "rxjs";
import {GraduationApplicationTask} from "../../../shared/model/graduation/graduation-application-task.interface";
import {GraduationApplicationDraftTaskPanel} from "./graduation-application-draft-task.panel";
import {FlowState} from "../../../core/flow-state.enum";
import {GraduationApplicationRegisterTaskPanel} from "./graduation-application-register-task.panel";
import {GraduationApplicationVerifyTaskPanel} from "./graduation-application-verify-task.panel";
import {GraduationApplicationCheckTaskPanel} from "./graduation-application-check-task.panel";


@Component({
  selector: 'pams-graduation-application-task-workflow',
  templateUrl: './graduation-application-task-workflow.panel.html',
})
export class GraduationApplicationTaskWorkflowPanel implements OnInit {

  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;

  @Input() graduationApplicationTaskObservable: Observable<GraduationApplicationTask>;
  private componentRef: ComponentRef<any>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.graduationApplicationTaskObservable.subscribe(task => {
      if (task.flowState) {

        console.log("task flowState: " + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(GraduationApplicationDraftTaskPanel);
            break;
          case FlowState.REGISTERED:
            componentFactory = this.cfr.resolveComponentFactory(GraduationApplicationRegisterTaskPanel);
            break;
          case FlowState.VERIFIED:
            componentFactory = this.cfr.resolveComponentFactory(GraduationApplicationVerifyTaskPanel);
            break;
          case FlowState.CHECKED:
            componentFactory = this.cfr.resolveComponentFactory(GraduationApplicationCheckTaskPanel);
            break;
        }
        this.componentRef = this.taskPanel.createComponent(componentFactory);
        this.componentRef.instance.graduationApplicationTask = task;
      }
    });
  }

  ngOnDestroy() {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
