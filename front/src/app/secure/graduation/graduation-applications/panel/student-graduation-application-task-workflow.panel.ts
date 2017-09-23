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
import {GraduationApplicationDraftTaskPanel} from './graduation-application-draft-task.panel';
import {GraduationApplicationRegisterTaskPanel} from './graduation-application-register-task.panel';
import {GraduationApplicationVerifyTaskPanel} from './graduation-application-verify-task.panel';
import {GraduationApplicationCheckTaskPanel} from './graduation-application-check-task.panel';
import {GraduationApplicationTask} from '../../../../shared/model/graduation/graduation-application-task.interface';
import {FlowState} from '../../../../core/flow-state.enum';
import { StudentGraduationApplicationDraftTaskPanel } from "./student-graduation-application-draft-task.panel";

@Component({
  selector: 'pams-student-graduation-application-task-workflow',
  templateUrl: './student-graduation-application-task-workflow.panel.html',
})
export class StudentGraduationApplicationTaskWorkflowPanel implements OnInit {

  @ViewChild('taskPanel', {read: ViewContainerRef})
  private taskPanel: ViewContainerRef;

  @Input() graduationApplicationTaskObservable: Observable<GraduationApplicationTask>;
  private componentRef: ComponentRef<any>;

  constructor(private viewContainerRef: ViewContainerRef,
              private cfr: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    let componentFactory;
    this.graduationApplicationTaskObservable.subscribe((task) => {
      if (task.flowState) {

        console.log('task flowState: ' + task.flowState);
        if (this.componentRef) this.componentRef.destroy();
        switch (FlowState[task.flowState.toString()]) {
          case FlowState.DRAFTED:
            componentFactory = this.cfr.resolveComponentFactory(StudentGraduationApplicationDraftTaskPanel);
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
