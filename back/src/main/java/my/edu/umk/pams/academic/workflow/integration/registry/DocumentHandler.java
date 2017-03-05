package my.edu.umk.pams.academic.workflow.integration.registry;


import my.edu.umk.pams.academic.core.model.AdDocument;

import java.util.Map;

/**
 * @author canang technologies
 * @since 2/21/14
 */
public interface DocumentHandler<T extends AdDocument> {

    /**
     * handle document processing according to its type
     *
     * @param document
     * @param variables
     * @return
     */
    String process(T document, Map<String, Object> variables);
}
