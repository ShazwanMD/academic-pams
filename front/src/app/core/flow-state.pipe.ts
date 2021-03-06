import {Pipe, PipeTransform} from '@angular/core';
import {FlowState} from './flow-state.enum';

@Pipe({name: 'flowStatePipe'})
export class FlowStatePipe implements PipeTransform {

  transform(value: FlowState): any {
    if (!value) return value;
    switch (FlowState[value.toString()]) {
      case FlowState.DRAFTED : {
        return 'Draft';
      }
      case FlowState.COMPLETED : {
        return 'Completed';
      }
      default: {
        return value;
      }
    }
  }
}
