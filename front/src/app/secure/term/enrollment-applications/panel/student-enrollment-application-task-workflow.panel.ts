import {
  Component,
  ComponentFactoryResolver,
  ComponentRef,
  Input,
  OnInit,
  ViewChild,
  ViewContainerRef
} from '@angular/core';
import {Observable} from 'rxjs';
import {EnrollmentApplicationDraftTaskPanel} from './enrollment-application-draft-task.panel';
import {EnrollmentApplicationTask} from '../../../../shared/model/term/enrollment-application-task.interface';
import {FlowState} from '../../../../core/flow-state.enum';
import { StudentEnrollmentApplicationDraftTaskPanel } from "./student-enrollment-application-draft-task.panel";

@Component({
  selector: 'pams-student-enrollment-application-task-workflow',
  templateUrl: './student-enrollment-application-task-workflow.panel.html',
})
export class StudentEnrollmentApplicationTaskWorkflowPanel implements OnInit {

  private componentRef: ComponentRef<any>;
  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;
  @Input() enrollmentApplicationTaskObservable: Observable<EnrollmentApplicationTask>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.enrollmentApplicationTaskObservable.subscribe((task) => {
      if (task.flowState) {

        console.log('task flowState: ' + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(StudentEnrollmentApplicationDraftTaskPanel);
            break;
          /*case FlowState.REGISTERED:
              componentFactory = this.cfr.resolveComponentFactory(EnrollmentApplicationRegisterTaskPanel);
              break;*/
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
