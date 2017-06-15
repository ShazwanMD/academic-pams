import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Admission } from "../admission.interface";
import { Enrollment } from "../../enrollments/enrollment.interface";

@Component( {
    selector: 'pams-admission-enrollment-info',
    templateUrl: './admission-enrollment-info.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class AdmissionEnrollmentInfoComponent {

    private columns: any[] = [
        { name: 'section.id', label: 'Section' },
        { name: 'section.code', label: 'Code' },
        { name: 'section.offering.titleEn', label: 'Title' },
        { name: 'section.offering.course.credit', label: 'Credit' },
        { name: 'section.offering.program.code', label: 'Program' },
        { name: 'section.offering.course.faculty.name', label: 'Faculty' },
        { name: 'enrollmentStatus', label: 'Status' },
        { name: 'action', label: '' },
    ];

    @Input() admission: Admission;
    @Input() enrollments: Enrollment[];
    @Output() view: EventEmitter<Enrollment> = new EventEmitter<Enrollment>();
}