-- SID
INSERT INTO acl_sid (id, principal, sid) VALUES (nextval('SQ_ACL_SID'), true, 'root');
INSERT INTO acl_sid (id, principal, sid) VALUES (nextval('SQ_ACL_SID'), true, 'GRP_APCN');

-- CLASS
INSERT INTO acl_class (id, class) VALUES (nextval('SQ_ACL_CLASS'), 'my.edu.umk.pams.academic.system.model.AdModule');

-- object identity
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (nextval('SQ_ACL_OBJECT_IDENTITY'), 1, 2, null, 1, true);
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (nextval('SQ_ACL_OBJECT_IDENTITY'), 1, 1, null, 1, true);
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (nextval('SQ_ACL_OBJECT_IDENTITY'), 1, 3, null, 1, true);
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (nextval('SQ_ACL_OBJECT_IDENTITY'), 1, 6, null, 1, true);
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (nextval('SQ_ACL_OBJECT_IDENTITY'), 1, 5, null, 1, true);
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (nextval('SQ_ACL_OBJECT_IDENTITY'), 1, 4, null, 1, true);

-- entry
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 1, 0, 1, 1, true, false, false);
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 2, 0, 1, 1, true, false, false);
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 4, 0, 1, 1, true, false, false);
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 5, 0, 1, 1, true, false, false);
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 6, 0, 1, 1, true, false, false);
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 3, 0, 1, 1, true, false, false);
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (nextval('SQ_ACL_ENTRY'), 3, 1, 2, 1, true, false, false);