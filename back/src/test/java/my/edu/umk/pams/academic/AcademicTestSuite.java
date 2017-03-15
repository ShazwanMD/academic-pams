package my.edu.umk.pams.academic;

import my.edu.umk.pams.academic.identity.IdentityModuleTestSuite;
import my.edu.umk.pams.academic.offering.OfferingModuleTestSuite;
import my.edu.umk.pams.academic.profile.ProfileModuleTestSuite;
import my.edu.umk.pams.academic.studyplan.StudyplanModuleTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IdentityModuleTestSuite.class,
        OfferingModuleTestSuite.class,
        ProfileModuleTestSuite.class,
        StudyplanModuleTestSuite.class,
})
public class AcademicTestSuite {
}