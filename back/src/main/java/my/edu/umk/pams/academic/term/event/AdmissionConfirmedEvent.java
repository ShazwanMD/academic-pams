package my.edu.umk.pams.academic.term.event;

import my.edu.umk.pams.connector.payload.AdmissionPayload;

/**
 * @author PAMS
 */
public class AdmissionConfirmedEvent extends AdmissionEvent {

    public AdmissionConfirmedEvent(AdmissionPayload payload) {
        super(payload);
    }
}
