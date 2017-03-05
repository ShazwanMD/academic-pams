package my.edu.umk.pams.academic.offering.workflow.handler;


import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.workflow.integration.registry.DocumentHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author PAMS
 */
@Component
public class EnrollmentApplicationHandler implements DocumentHandler<AdDocument> {

    @Override
    public String process(AdDocument document, Map<String, Object> variables) {
        return null;
    }
}
