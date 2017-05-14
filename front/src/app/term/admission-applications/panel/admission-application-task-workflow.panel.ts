import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input, AfterViewInit
} from '@angular/core';
import {Observable} from "rxjs";
import {AdmissionApplicationTask} from "../admission-application-task.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {AdmissionApplicationDraftTaskPanel} from "./admission-application-draft-task.panel";


@Component({
  selector: 'pams-admission-application-task-workflow',
  templateUrl: './admission-application-task-workflow.panel.html',
})
export class AdmissionApplicationTaskWorkflowPanel implements OnInit {

  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;
  private componentRef: ComponentRef<any>;
  @Input() admissionApplicationTaskObservable: Observable<AdmissionApplicationTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.admissionApplicationTaskObservable.subscribe(task => {
      if (task.flowState) {

        console.log("task flowState: " + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(AdmissionApplicationDraftTaskPanel);
            break;
        }
        this.componentRef = this.taskPanel.createComponent(componentFactory);
        this.componentRef.instance.admissionApplicationTask = task;
      }
    });
  }

  ngOnDestroy() {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
