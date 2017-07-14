import {
  Component, OnInit, ViewChild, ViewContainerRef,
  ComponentFactoryResolver, ComponentRef, Input, AfterViewInit,
} from '@angular/core';
import {Observable} from 'rxjs';
import {AdmissionApplicationTask} from '../admission-application-task.interface';
import {FlowState} from '../../../core/flow-state.enum';
import {StudentAdmissionApplicationDraftTaskPanel} from './student-admission-application-draft-task.panel';
import {AdmissionApplicationRegisterTaskPanel} from './admission-application-register-task.panel';

@Component({
  selector: 'pams-student-admission-application-task-workflow',
  templateUrl: './student-admission-application-task-workflow.panel.html',
})
export class StudentAdmissionApplicationTaskWorkflowPanel implements OnInit {

  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;
  private componentRef: ComponentRef<any>;
  @Input() admissionApplicationTaskObservable: Observable<AdmissionApplicationTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.admissionApplicationTaskObservable.subscribe((task) => {
      if (task.flowState) {

        console.log('task flowState: ' + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(StudentAdmissionApplicationDraftTaskPanel);
            break;
          case FlowState.REGISTERED:
            componentFactory = this.cfr.resolveComponentFactory(AdmissionApplicationRegisterTaskPanel);
            break;
        }
        this.componentRef = this.taskPanel.createComponent(componentFactory);
        this.componentRef.instance.admissionApplicationTask = task;
      }
    });
  }

  ngOnDestroy(): void {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
