package my.edu.umk.pams.academic;

import my.edu.umk.pams.academic.identity.IdentityTestSuite;
import my.edu.umk.pams.academic.offering.OfferingTestSuite;
import my.edu.umk.pams.academic.studyplan.StudyplanTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudyplanTestSuite.class,
        OfferingTestSuite.class,
        IdentityTestSuite.class,
})
public class AcademicTestSuite {
}