import { ChangeDetectionStrategy, Component, Input, OnChanges, SimpleChange, ViewChild } from '@angular/core';
import { SectionActions } from '../section.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { GradebookMatrix } from '../../../../shared/model/term/gradebook-matrix.interface';
import { TdDataTableComponent } from '@covalent/core';
import { Assessment } from '../../../../shared/model/term/assessment.interface';
import { Gradebook } from '../../../../shared/model/term/gradebook.interface';
import { Section } from '../../../../shared/model/term/section.interface';

@Component( {
    selector: 'pams-section-gradebook-list',
    templateUrl: './section-gradebook-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class SectionGradebookListComponent implements OnChanges {

    @Input() section: Section;
    @Input() gradebooks: Gradebook[];
    @Input() gradebookMatrices: GradebookMatrix[];
    @Input() assessments: Assessment[];
    @ViewChild( 'dataTable' ) dataTable: TdDataTableComponent;

    columns: any[] = [
        { label: 'Student name', name: 'enrollment.admission.student.name' },
    ];

    constructor( private actions: SectionActions,
        private store: Store<TermModuleState> ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        if ( changes['gradebookMatrices'] && this.gradebookMatrices ) {
            let a = changes['gradebookMatrices']['currentValue'];
            if ( a.length > 0 ) {
                a.forEach(( i ) => {
                    let b = i['gradebooks'];
                    if ( b.length > 0 ) {
                        for ( let j = 0; j < b.length; j++ ) {
                            this.columns[j + 1] = {
                                label: b[j].assessment.description,
                                name: 'gradebooks.' + j + '.score',
                            };
                        }
                        console.log( this.columns );
                    }
                    console.log( i['gradebooks'] );
                } );

            }
        }
    }

}
