import { Program } from "../../programs/program.interface";
import { Input, ChangeDetectionStrategy, Component } from '@angular/core';


@Component({
  selector: 'pams-faculty-program-list',
  templateUrl: 'faculty-program-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class FacultyProgramListComponent {

@Input() programs: Program[];

}