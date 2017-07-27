import {Action} from '@ngrx/store';
import {Actor} from '../shared/model/identity/actor.interface';
import {ActorActions} from './actor.action';

export type ActorState = Actor;

const initialState: ActorState = <Actor>{};

export function actorReducer(state = initialState, action: Action): ActorState {
  switch (action.type) {
    case ActorActions.FIND_ACTOR_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
