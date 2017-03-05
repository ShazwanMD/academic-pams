package my.edu.umk.pams.academic;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class TestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(TestSupport.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected AdUser currentUser;

    public void before() {
        Session session = sessionFactory.getCurrentSession();

        // prepare currentUser
        currentUser = new AdUserImpl();
        currentUser.setUsername("root");
        currentUser.setRealName("Root Admin");
        currentUser.setPassword("abc123");
        currentUser.setEmail("root@umk.edu.my");

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(0L);
        metadata.setState(AdMetaState.ACTIVE);
        currentUser.setMetadata(metadata);

        session.save(currentUser);
        session.flush();
        session.refresh(currentUser);
    }

    public void after() {
    }
}