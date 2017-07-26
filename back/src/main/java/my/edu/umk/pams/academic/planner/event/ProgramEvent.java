package my.edu.umk.pams.academic.planner.event;

import org.springframework.context.ApplicationEvent;

import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.planner.model.AdProgram;

/**
 */
public class ProgramEvent extends ApplicationEvent {

    public ProgramEvent(Object source) {
        super(source);
    }

//    private ProgramCodePayload payload;
//
//    public ProgramEvent(ProgramCodePayload payload) {
//        super(payload);
//
//    }
}
