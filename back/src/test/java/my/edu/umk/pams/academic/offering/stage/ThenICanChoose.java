package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenICanChoose extends Stage<ThenICanChoose> {

    public ThenICanChoose i_can_choose() {
        return self();
    }

}


