package my.edu.umk.pams.academic.security.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.*;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author canang technologies
 * @since 1/13/14
 */
public class AdAclService implements AclService {

    // ~ Static fields/initializers
    // =====================================================================================

    private Logger log = LoggerFactory.getLogger(AdAclService.class);
    private static final String selectAclObjectWithParent = "SELECT obj.object_id_identity AS obj_id, "
            + "       class.class AS class " + "  FROM acl_object_identity obj, "
            + "       acl_object_identity parent, " + "       acl_class class "
            + " WHERE obj.parent_object = parent.id " + "   AND obj.object_id_class = class.id "
            + "   AND parent.object_id_identity = ? "
            + "   AND parent.object_id_class = (SELECT id FROM acl_class WHERE acl_class.class = ?)";

    // ~ Instance fields
    // ================================================================================================

    protected JdbcTemplate jdbcTemplate;
    private LookupStrategy lookupStrategy;

    // ~ Constructors
    // ===================================================================================================

    public AdAclService(DataSource dataSource, LookupStrategy lookupStrategy) {
        Assert.notNull(dataSource, "DataSource required");
        Assert.notNull(lookupStrategy, "LookupStrategy required");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.lookupStrategy = lookupStrategy;
    }

    // ~ Methods
    // ========================================================================================================

    public List<ObjectIdentity> findChildren(ObjectIdentity parentIdentity) {
        Object[] args = {Long.parseLong(String.valueOf(parentIdentity.getIdentifier())), parentIdentity.getType()};
        List objects = jdbcTemplate.query(selectAclObjectWithParent, args, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                String javaType = rs.getString("class");
                String identifier = rs.getString("obj_id");

                return new ObjectIdentityImpl(javaType, identifier);
            }
        });
        return objects;
    }

    public Acl readAclById(ObjectIdentity object, List<Sid> sids) throws NotFoundException {
        Map map = readAclsById(Arrays.asList(object), sids);

        if (map.size() == 0) {
            throw new NotFoundException("Could not findAddresses ACL");
        } else {
            return (Acl) map.get(object);
        }
    }

    public Acl readAclById(ObjectIdentity object) throws NotFoundException {
        return readAclById(object, null);
    }

    public Map readAclsById(List<ObjectIdentity> objects) {
        return readAclsById(objects, null);
    }

    public Map readAclsById(List<ObjectIdentity> objects, List<Sid> sids) throws NotFoundException {
        return lookupStrategy.readAclsById(objects, sids);
    }
}

