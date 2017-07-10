import {FlowState} from './flow-state.enum';
import {MetaObject} from './meta-object.interface';
export interface FlowObject extends MetaObject {
  flowState?: FlowState;
}
