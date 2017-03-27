package my.edu.umk.pams.academic.term.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author PAMS
 */
@Component("sectionListener")
public class SectionListener implements ApplicationListener<SectionEvent> {

    @Override
    public void onApplicationEvent(SectionEvent event) {
    }
}
