import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {AcademicSession} from "../academic-session.interface";

@Component ({
    selector: 'pams-academic-session-list',
    templateUrl: './academic-session-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AcademicSessionListComponent {

    @Input() academicSessions: AcademicSession[];
    @Output() view = new EventEmitter<AcademicSession>();

    private columns: any [] = [
        {name: 'code', label: 'Code'},
        {name: 'description', label: 'Description'},
        {name: 'action', label: ''},


    ];

}