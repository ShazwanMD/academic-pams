import { ProfileActions } from './profile.action';
import { Student } from './../identity/student.interface';
import { Observable } from 'rxjs';
import { Action } from '@ngrx/store';

export type ProfileDetailState = Student[];

const initialState: ProfileDetailState = <Student[]>[];

export function profileDetailReducer(state = initialState,
                action: Action): ProfileDetailState{

                    switch(action.type){
                        case ProfileActions.FIND_PROFILE:{
                            return action.payload;
                        }
                        default: {
                            return state;
                        }
                    }
                }