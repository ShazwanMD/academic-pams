import {AdmissionApplication} from '../../../shared/model/term/admission-application.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-admission-application',
  templateUrl: './admission-application.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionApplicationComponent {

  private columns: any[] = [
    {name: 'auditNo', label: 'Audit No'},
    {name: 'description', label: 'Description'},
    {name: 'sourceNo', label: 'Source No'},
    {name: 'referenceNo', label: 'Reference No'},
    {name: 'cancelComment', label: 'Cancel Comment'},
    {name: 'removeComment', label: 'Remove Comment'},
    {name: 'advisor.identityNo', label: 'Advisor'},
    {name: 'program.code', label: 'Program'},
    {name: 'session.code', label: 'Academic Session'},
    {name: 'student.identityNo', label: 'Student'},
    {name: 'studyCenter.code', label: 'Study Center'},
    {name: 'action', label: ''}
  ];

  @Input() admissionApplication: AdmissionApplication;

}

