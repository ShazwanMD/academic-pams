package my.edu.umk.pams.academic;

import my.edu.umk.pams.academic.identity.IdentityModuleTestSuite;
import my.edu.umk.pams.academic.term.TermModuleTestSuite;
import my.edu.umk.pams.academic.profile.ProfileModuleTestSuite;
import my.edu.umk.pams.academic.planner.PlannerModuleTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IdentityModuleTestSuite.class,
        ProfileModuleTestSuite.class,
        PlannerModuleTestSuite.class,
        TermModuleTestSuite.class,
})
public class AcademicTestSuite {
}