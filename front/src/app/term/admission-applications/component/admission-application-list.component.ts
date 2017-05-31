import { Component, ChangeDetectionStrategy, Output, Input, EventEmitter } from '@angular/core';
import { AdmissionApplication } from "./../admission-application.interface";

@Component({
  selector: 'pams-admission-application-list',
  templateUrl: './admission-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AdmissionApplicationListComponent {

  @Input() admissionApplications: AdmissionApplication[];
  @Output() view = new EventEmitter<AdmissionApplication>();

  private columns: any[] = [
    { name: 'auditNo', label: 'Audit No' },
    // { name: 'description', label: 'Description' },
    // { name: 'sourceNo', label: 'Source No' },
    // { name: 'referenceNo', label: 'Reference No' },
    // { name: 'cancelComment', label: 'Cancel Comment' },
    // { name: 'removeComment', label: 'Remove Comment' },
    { name: 'advisor.identityNo', label: 'Advisor' },
    { name: 'program.code', label: 'Program' },
    { name: 'session.code', label: 'Academic Session' },
    { name: 'student.identityNo', label: 'Student' },
    { name: 'studyCenter.code', label: 'Study Center' },
    { name: 'action', label: '' }
    
  ];
}
