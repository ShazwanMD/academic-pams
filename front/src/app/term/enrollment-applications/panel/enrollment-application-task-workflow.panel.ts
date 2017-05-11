import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input, AfterViewInit
} from '@angular/core';
import {Observable} from "rxjs";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {EnrollmentApplicationDraftTaskPanel} from "./enrollment-application-draft-task.panel";


@Component({
  selector: 'pams-enrollment-application-task-workflow',
  templateUrl: './enrollment-application-task-workflow.panel.html',
})
export class EnrollmentApplicationTaskWorkflowPanel implements OnInit {

  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;
  private componentRef: ComponentRef<any>;
  @Input() enrollmentApplicationTaskObservable: Observable<EnrollmentApplicationTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.enrollmentApplicationTaskObservable.subscribe(task => {
      if (task.flowState) {

        console.log("task flowState: " + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(EnrollmentApplicationDraftTaskPanel);
            break;
        }
        this.componentRef = this.taskPanel.createComponent(componentFactory);
        this.componentRef.instance.enrollmentApplicationTask = task;
      }
    });
  }

  ngOnDestroy() {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
