-- ACL Schema SQL for PostgreSQL
--
-- drop table acl_entry;
-- drop table acl_object_identity;
-- drop table acl_class;
-- drop table acl_sid;
CREATE TABLE ACL_SID (
  ID        BIGSERIAL    NOT NULL PRIMARY KEY,
  PRINCIPAL BOOLEAN      NOT NULL,
  SID       VARCHAR(100) NOT NULL,
  CONSTRAINT UNIQUE_UK_1 UNIQUE (SID, PRINCIPAL)
);

CREATE TABLE ACL_CLASS (
  ID    BIGSERIAL    NOT NULL PRIMARY KEY,
  CLASS VARCHAR(100) NOT NULL,
  CONSTRAINT UNIQUE_UK_2 UNIQUE (CLASS)
);

CREATE TABLE ACL_OBJECT_IDENTITY (
  ID                 BIGSERIAL PRIMARY KEY,
  OBJECT_ID_CLASS    BIGINT  NOT NULL,
  OBJECT_ID_IDENTITY BIGINT  NOT NULL,
  PARENT_OBJECT      BIGINT  NULL,
  OWNER_SID          BIGINT,
  ENTRIES_INHERITING BOOLEAN NOT NULL,
  CONSTRAINT UNIQUE_UK_3 UNIQUE (OBJECT_ID_CLASS, OBJECT_ID_IDENTITY),
  CONSTRAINT FOREIGN_FK_1 FOREIGN KEY (PARENT_OBJECT) REFERENCES ACL_OBJECT_IDENTITY (ID),
  CONSTRAINT FOREIGN_FK_2 FOREIGN KEY (OBJECT_ID_CLASS) REFERENCES ACL_CLASS (ID),
  CONSTRAINT FOREIGN_FK_3 FOREIGN KEY (OWNER_SID) REFERENCES ACL_SID (ID)
);

CREATE TABLE ACL_ENTRY (
  ID                  BIGSERIAL PRIMARY KEY,
  ACL_OBJECT_IDENTITY BIGINT  NOT NULL,
  ACE_ORDER           INT     NOT NULL,
  SID                 BIGINT  NOT NULL,
  MASK                INTEGER NOT NULL,
  GRANTING            BOOLEAN NOT NULL,
  AUDIT_SUCCESS       BOOLEAN NOT NULL,
  AUDIT_FAILURE       BOOLEAN NOT NULL,
  CONSTRAINT UNIQUE_UK_4 UNIQUE (ACL_OBJECT_IDENTITY, ACE_ORDER),
  CONSTRAINT FOREIGN_FK_4 FOREIGN KEY (ACL_OBJECT_IDENTITY) REFERENCES ACL_OBJECT_IDENTITY (ID),
  CONSTRAINT FOREIGN_FK_5 FOREIGN KEY (SID) REFERENCES ACL_SID (ID)
);
