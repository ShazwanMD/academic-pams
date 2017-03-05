package my.edu.umk.pams.academic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {

        // internals
        "my.edu.umk.pams.academic.identity",
        "my.edu.umk.pams.academic.security",
        "my.edu.umk.pams.academic.system",
        "my.edu.umk.pams.academic.workflow",

        // modules
        "my.edu.umk.pams.academic.common",
        "my.edu.umk.pams.academic.studyplan",
        "my.edu.umk.pams.academic.offering",
        "my.edu.umk.pams.academic.enrollment",
})
@Import({
        TestDatasourceConfig.class,
        TestWorkflowConfig.class,
        TestAccessConfig.class,
        TestCacheConfig.class,
})
@PropertySource("classpath:application.properties")
public class TestAppConfiguration {


}
