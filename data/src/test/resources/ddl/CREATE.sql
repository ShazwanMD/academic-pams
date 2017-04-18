
create table AD_ACDM_AREA (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_ACDM_CLDR (
  ID int8 not null,
  ACADEMIC_DATE timestamp,
  CALENDAR_TYPE int4,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  SESSION_ID int8,
  STUDY_CENTER_ID int8,
  primary key (ID)
);

create table AD_ACDM_SESN (
  ID int8 not null,
  CODE varchar(255) not null,
  CURRENT_ boolean not null,
  DESCRIPTION varchar(255) not null,
  END_DATE date not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  SEMESTER int4 not null,
  START_DATE date not null,
  STATUS int4 not null,
  PREVIOUS_ID int8,
  YEAR_ID int8,
  primary key (ID)
);

create table AD_ACDM_YEAR (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  YEAR int8,
  primary key (ID)
);

create table AD_ACTR (
  ID int8 not null,
  ACTOR_TYPE int4,
  EMAIL varchar(255),
  FAX varchar(255),
  IDENTITY_NO varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  MOBILE varchar(255),
  NAME varchar(255) not null,
  PHONE varchar(255),
  primary key (ID)
);

create table AD_ADDR (
  ID int8 not null,
  ADDRESS1 varchar(255) not null,
  ADDRESS2 varchar(255),
  ADDRESS3 varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  POSTCODE varchar(255),
  ADDRESS_TYPE int4,
  COUNTRY_CODE_ID int8,
  DUN_CODE_ID int8,
  PARLIAMENT_CODE_ID int8,
  STATE_CODE_ID int8,
  STUDENT_ID int8,
  primary key (ID)
);

create table AD_ADMN (
  ID int8 not null,
  CGPA numeric(19, 2),
  CREDIT_EARNED int4,
  CREDIT_TAKEN int4,
  GPA numeric(19, 2),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  STANDING int4 not null,
  STATUS int4 not null,
  PROGRAM_ID int8,
  SESSION_ID int8,
  STUDENT_ID int8,
  STUDY_CENTER_ID int8,
  primary key (ID)
);

create table AD_ADMN_APLN (
  ID int8 not null,
  AUDIT_NO varchar(255),
  CANCEL_COMMENT varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  AV_TS timestamp,
  AV_ID int8,
  CL_ID int8,
  CL_TS timestamp,
  CK_TS timestamp,
  CK_ID int8,
  DT_TS timestamp,
  DT_ID int8,
  EV_TS timestamp,
  EV_ID int8,
  PR_TS timestamp,
  PR_ID int8,
  PS_TS timestamp,
  PS_ID int8,
  RG_TS timestamp,
  RG_ID int8,
  RM_TS timestamp,
  RM_ID int8,
  RQ_TS timestamp,
  RQ_ID int8,
  SL_TS timestamp,
  SL_ID int8,
  FD_ST int4,
  UP_TS timestamp,
  UP_ID int8,
  UV_TS timestamp,
  UV_ID int8,
  VF_TS timestamp,
  VF_ID int8,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  REFERENCE_NO varchar(255) not null,
  REMOVE_COMMENT varchar(255) not null,
  SOURCE_NO varchar(255),
  ADVISOR_ID int8,
  PROGRAM_ID int8,
  SESSION_ID int8,
  STUDENT_ID int8,
  STUDY_CENTER_ID int8,
  primary key (ID)
);

create table AD_APMT (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  STATUS int4 not null,
  SECTION_ID int8,
  STAFF_ID int8,
  primary key (ID)
);

create table AD_ASMT (
  ID int8 not null,
  CANONICAL_CODE varchar(255) not null,
  CATEGORY int4 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  TOTAL_SCORE numeric(19, 2) not null,
  TYPE int4 not null,
  WEIGHT numeric(19, 2) not null,
  OFFERING_ID int8,
  SESSION_ID int8,
  primary key (ID)
);

create table AD_AUDT (
  ID int8 not null,
  CLASS_NAME varchar(255) not null,
  MESSAGE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  OBJECT_ID int8 not null,
  USER_ID int8 not null,
  primary key (ID)
);

create table AD_BANK_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  IBG_CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  SWIFT_CODE varchar(255) not null,
  primary key (ID)
);

create table AD_BNDL_SBJT (
  ID int8 not null,
  primary key (ID)
);

create table AD_BNDL_SBJT_PART (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  BUNDLE_ID int8,
  COURSE_ID int8,
  primary key (ID)
);

create table AD_CHRG_SCDL (
  ID int8 not null,
  AMOUNT numeric(19, 2) not null,
  CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PERIOD int4 not null,
  COHORT_ID int8,
  PROGRAM_ID int8,
  STUDY_CENTER_ID int8,
  primary key (ID)
);

create table AD_CHRT (
  ID int8 not null,
  CLASSIFICATION int4 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  CURRICULUM_ID int8,
  PROGRAM_ID int8,
  SESSION_ID int8,
  primary key (ID)
);

create table AD_CITY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  STATE_CODE_ID int8,
  primary key (ID)
);

create table AD_CLGE_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  CAMPUS_ID int8 not null,
  primary key (ID)
);

create table AD_CMCY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_CNFG (
  ID int8 not null,
  DESCRIPTION varchar(255),
  CONFIG_KEY varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  CONFIG_VALUE varchar(255),
  CONFIG_VALUE_BYTEA bytea,
  CONFIG_VALUE_DOUBLE float8,
  CONFIG_VALUE_LONG int8,
  primary key (ID)
);

create table AD_CNTY_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_CRLM (
  ID int8 not null,
  CODE varchar(255) not null,
  CORE int4 not null,
  CURRICULUM int4 not null,
  ELECTIVE int4 not null,
  GENERAL int4 not null,
  LANGUAGE int4 not null,
  MAX_PERIOD int4 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  OTHERS int4 not null,
  PERIOD int4 not null,
  REQUIRED int4 not null,
  TOTAL_CREDIT int4 not null,
  PROGRAM_ID int8,
  primary key (ID)
);

create table AD_CRSE (
  ID int8 not null,
  CLASSIFICATION int4 not null,
  CODE varchar(255) not null,
  CREDIT int4 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  TITLE varchar(255) not null,
  TITLE_EN varchar(255) not null,
  TITLE_MS varchar(255) not null,
  FACULTY_ID int8 not null,
  primary key (ID)
);

create table AD_CRSE_MMBR (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  COURSE_ID int8,
  MEMBER_ID int8,
  primary key (ID)
);

create table AD_CRSE_PQST (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  COURSE_ID int8,
  PREREQUISITE_ID int8,
  primary key (ID)
);

create table AD_DBLY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_DPCY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_DSCT_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_DUN_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_EMAL_QUEU (
  ID int8 not null,
  EMAIL_BCC varchar(255),
  BODY text,
  EMAIL_CC varchar(255),
  CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  QUEUE_STATUS int4,
  RETRY_COUNT int4,
  SUBJECT varchar(255),
  EMAIL_TO varchar(255),
  primary key (ID)
);

create table AD_EMIL_TMPT (
  ID int8 not null,
  BCC_ADDRESS varchar(255),
  CC_ADDRESS varchar(255),
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  SUBJECT varchar(255),
  TEMPLATE TEXT,
  TO_ADDRESS varchar(255),
  primary key (ID)
);

create table AD_EMPT_FILD_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_EMPT_LEVL_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_EMPT_SCTR_CODE (
  ID int8 not null,
  CODE varchar(2),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_ENMT (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  STANDING int4 not null,
  STATUS int4 not null,
  ADMISSION_ID int8,
  GRADE_CODE_ID int8,
  SECTION_ID int8,
  STUDENT_ID int8,
  primary key (ID)
);

create table AD_ENMT_APLN (
  ID int8 not null,
  AUDIT_NO varchar(255),
  CANCEL_COMMENT varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  AV_TS timestamp,
  AV_ID int8,
  CL_ID int8,
  CL_TS timestamp,
  CK_TS timestamp,
  CK_ID int8,
  DT_TS timestamp,
  DT_ID int8,
  EV_TS timestamp,
  EV_ID int8,
  PR_TS timestamp,
  PR_ID int8,
  PS_TS timestamp,
  PS_ID int8,
  RG_TS timestamp,
  RG_ID int8,
  RM_TS timestamp,
  RM_ID int8,
  RQ_TS timestamp,
  RQ_ID int8,
  SL_TS timestamp,
  SL_ID int8,
  FD_ST int4,
  UP_TS timestamp,
  UP_ID int8,
  UV_TS timestamp,
  UV_ID int8,
  VF_TS timestamp,
  VF_ID int8,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  REFERENCE_NO varchar(255) not null,
  REMOVE_COMMENT varchar(255) not null,
  SOURCE_NO varchar(255),
  APPLICATION_TYPE int4,
  ADMISSION_ID int8,
  ADVISOR_ID int8,
  SESSION_ID int8,
  STUDENT_ID int8,
  primary key (ID)
);

create table AD_ENMT_APPL_ITEM (
  ID int8 not null,
  ACTION int4,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  APPLICATION_ID int8,
  SECTION_ID int8,
  primary key (ID)
);

create table AD_ETNY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_FCTY (
  ID int8 not null,
  CODE varchar(255) not null,
  NAME varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PREFIX varchar(255),
  primary key (ID)
);

create table AD_FILD_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_GNDR_CODE (
  ID int8 not null,
  CODE varchar(1),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_GRBK (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  SCORE numeric(19, 2) not null,
  ASSESSMENT_ID int8,
  ENROLLMENT_ID int8,
  SECTION_ID int8,
  primary key (ID)
);

create table AD_GRDE_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  primary key (ID)
);

create table AD_GROP (
  ID int8 not null,
  primary key (ID)
);

create table AD_GROP_MMBR (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  GROUP_ID int8,
  PRINCIPAL_ID int8,
  primary key (GROUP_ID, PRINCIPAL_ID)
);

create table AD_INTK_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_INVT_LEVL_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  TYPE_CODE_ID int8,
  primary key (ID)
);

create table AD_INVT_TTLE_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_INVT_TYPE_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_MODL (
  ID int8 not null,
  CANONICAL_CODE varchar(255) not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  ENABLED boolean,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  primary key (ID)
);

create table AD_MRTL_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION_MS varchar(255),
  DESCRIPTION_EN varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_NTLY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION_MS varchar(255),
  DESCRIPTION_EN varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_OFRG (
  ID int8 not null,
  CANONICAL_CODE varchar(255) not null,
  CAPACITY int4 not null,
  CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  TITLE varchar(255) not null,
  COURSE_ID int8,
  PROGRAM_ID int8,
  primary key (ID)
);

create table AD_PCPL (
  ID int8 not null,
  ENABLED boolean not null,
  LOCKED boolean not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  NAME varchar(255) not null,
  PRINCIPAL_TYPE int4,
  primary key (ID)
);

create table AD_PCPL_ROLE (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ROLE_TYPE int4,
  PRINCIPAL_ID int8,
  primary key (ID)
);

create table AD_PLMT_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_PRCS_CLDR (
  ID int8 not null,
  ADMISSION_END timestamp,
  ADMISSION_START timestamp,
  APPEAL_FINAL_EXAM_END timestamp,
  APPEAL_FINAL_EXAM_START timestamp,
  APPEAL_SPECIAL_EXAM_END timestamp,
  APPEAL_SPECIAL_EXAM_START timestamp,
  DESCRIPTION varchar(255),
  FINAL_EXAM_END timestamp,
  FINAL_EXAM_START timestamp,
  GRADUATION_END timestamp,
  GRADUATION_START timestamp,
  INPUT_FINAL_EXAM_END timestamp,
  INPUT_FINAL_EXAM_START timestamp,
  INPUT_SPECIAL_EXAM_END timestamp,
  INPUT_SPECIAL_EXAM_START timestamp,
  LATE_ENROLLMENT_END timestamp,
  LATE_ENROLLMENT_START timestamp,
  LATE_GRADUATION_END timestamp,
  LATE_GRADUATION_START timestamp,
  MANDATORY_ENROLLMENT_END timestamp,
  MANDATORY_ENROLLMENT_START timestamp,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PRE_ENROLLMENT_END timestamp,
  PRE_ENROLLMENT_START timestamp,
  PROCESS_TYPE int4,
  PROVISION_ENROLLMENT_END timestamp,
  PROVISION_ENROLLMENT_START timestamp,
  RELEASE_FINAL_EXAM_END timestamp,
  RELEASE_FINAL_EXAM_START timestamp,
  RELEASE_SPECIAL_EXAM_END timestamp,
  RELEASE_SPECIAL_EXAM_START timestamp,
  SPECIAL_EXAM_END timestamp,
  SPECIAL_EXAM_START timestamp,
  SESSION_ID int8,
  STUDY_CENTER_ID int8,
  primary key (ID)
);

create table AD_PRGM (
  ID int8 not null,
  CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  TITLE varchar(255) not null,
  TITLE_EN varchar(255) not null,
  TITLE_MS varchar(255) not null,
  FACULTY_ID int8,
  LEVEL_ID int8,
  primary key (ID)
);

create table AD_PRGM_LEVL (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ADPROGRAM_TYPE int4,
  PREFIX varchar(225),
  primary key (ID)
);

create table AD_RACE_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION_MS varchar(255),
  DESCRIPTION_EN varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_RFRN_NO (
  ID int8 not null,
  CODE varchar(255) not null,
  CURRENT_VALUE int4,
  DESCRIPTION varchar(255) not null,
  INCREMENT_VALUE int4,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PREFIX varchar(255),
  REFERENCE_FORMAT varchar(255),
  SEQUENCE_FORMAT varchar(255),
  primary key (ID)
);

create table AD_RLGN_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION_MS varchar(255),
  DESCRIPTION_EN varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_RSCY_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_SBJT (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PERIOD int4 not null,
  SUBJECT_TYPE int4 not null,
  CURRICULUM_ID int8 not null,
  primary key (ID)
);

create table AD_SBJT_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_SCHL_CODE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_SCTN (
  ID int8 not null,
  CANONICAL_CODE varchar(255) not null,
  CAPACITY int4 not null,
  CODE varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4 not null,
  OFFERING_ID int8 not null,
  SESSION_ID int8 not null,
  primary key (ID)
);

create table AD_SCTN_PLCY (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  FACULTY_ID int8,
  SECTION_ID int8,
  primary key (ID)
);

create table AD_SITE (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_SITE_OFRG (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PROGRAM_ID int8 not null,
  SITE_ID int8 not null,
  primary key (ID)
);

create table AD_SMDL (
  ID int8 not null,
  CODE varchar(255),
  DESCRIPTION varchar(255),
  ENABLED boolean,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  ORDINAL int4,
  MODULE_ID int8,
  primary key (ID)
);

create table AD_SNGL_SBJT (
  ID int8 not null,
  COURSE_ID int8 not null,
  primary key (ID)
);

create table AD_STAF (
  STAFF_TYPE int4,
  ID int8 not null,
  primary key (ID)
);

create table AD_STDN (
  STUDENT_STATUS int4,
  ID int8 not null,
  COHORT_ID int8,
  primary key (ID)
);

create table AD_STDY_CNTR (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_STDY_CNTR_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_STDY_MODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION_EN varchar(255) not null,
  DESCRIPTION_MS varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  PREFIX varchar(255) not null,
  primary key (ID)
);

create table AD_STTE_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255),
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  COUNTRY_CODE_ID int8,
  primary key (ID)
);

create table AD_USER (
  EMAIL varchar(255) not null,
  PASSWORD varchar(255),
  REAL_NAME varchar(255) not null,
  ID int8 not null,
  ACTOR_ID int8,
  primary key (ID)
);

create table AD_VENU_CODE (
  ID int8 not null,
  CODE varchar(255) not null,
  DESCRIPTION varchar(255) not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  primary key (ID)
);

create table AD_WTCH (
  ID int8 not null,
  C_TS timestamp,
  C_ID int8,
  D_TS timestamp,
  D_ID int8,
  M_TS timestamp,
  M_ID int8,
  M_ST int4,
  OBJECT_CLASS varchar(255) not null,
  OBJECT_ID int8 not null,
  USER_ID int8 not null,
  primary key (ID)
);

alter table AD_ACDM_AREA
  add constraint uc_AD_ACDM_AREA_1 unique (CODE);

alter table AD_ACDM_CLDR
  add constraint FK9351992F3C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_ACDM_CLDR
  add constraint FK9351992F680A6167
foreign key (STUDY_CENTER_ID)
references AD_STDY_CNTR;

alter table AD_ACDM_SESN
  add constraint uc_AD_ACDM_SESN_1 unique (CODE);

alter table AD_ACDM_SESN
  add constraint FK9358C6A59D7702C9
foreign key (PREVIOUS_ID)
references AD_ACDM_SESN;

alter table AD_ACDM_SESN
  add constraint FK9358C6A5331FE0CA
foreign key (YEAR_ID)
references AD_ACDM_YEAR;

alter table AD_ACDM_YEAR
  add constraint uc_AD_ACDM_YEAR_1 unique (CODE);

alter table AD_ACTR
  add constraint uc_AD_ACTR_1 unique (IDENTITY_NO);

alter table AD_ADDR
  add constraint FKE7D7E28D3588F8C1
foreign key (COUNTRY_CODE_ID)
references AD_CNTY_CODE;

alter table AD_ADDR
  add constraint FKE7D7E28DAC66E48F
foreign key (DUN_CODE_ID)
references AD_DUN_CODE;

alter table AD_ADDR
  add constraint FKE7D7E28D331FF0E3
foreign key (PARLIAMENT_CODE_ID)
references AD_PLMT_CODE;

alter table AD_ADDR
  add constraint FKE7D7E28D55D2CB37
foreign key (STATE_CODE_ID)
references AD_STTE_CODE;

alter table AD_ADDR
  add constraint FKE7D7E28D54FCB007
foreign key (STUDENT_ID)
references AD_STDN;

alter table AD_ADMN
  add constraint uc_AD_ADMN_1 unique (CGPA);

alter table AD_ADMN
  add constraint uc_AD_ADMN_2 unique (GPA);

alter table AD_ADMN
  add constraint FKE7D7E3A0293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_ADMN
  add constraint FKE7D7E3A03C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_ADMN
  add constraint FKE7D7E3A054FCB007
foreign key (STUDENT_ID)
references AD_STDN;

alter table AD_ADMN
  add constraint FKE7D7E3A0680A6167
foreign key (STUDY_CENTER_ID)
references AD_STDY_CNTR;

alter table AD_ADMN_APLN
  add constraint FKD8FEDB30AAEC85C7
foreign key (ADVISOR_ID)
references AD_STAF;

alter table AD_ADMN_APLN
  add constraint FKD8FEDB30293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_ADMN_APLN
  add constraint FKD8FEDB303C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_ADMN_APLN
  add constraint FKD8FEDB3054FCB007
foreign key (STUDENT_ID)
references AD_STDN;

alter table AD_ADMN_APLN
  add constraint FKD8FEDB30680A6167
foreign key (STUDY_CENTER_ID)
references AD_STDY_CNTR;

alter table AD_APMT
  add constraint FKE7D810B241D87DF5
foreign key (SECTION_ID)
references AD_SCTN;

alter table AD_APMT
  add constraint FKE7D810B21F62CEA7
foreign key (STAFF_ID)
references AD_STAF;

alter table AD_ASMT
  add constraint uc_AD_ASMT_1 unique (CANONICAL_CODE);

alter table AD_ASMT
  add constraint FKE7D81BF5207B8BFF
foreign key (OFFERING_ID)
references AD_OFRG;

alter table AD_ASMT
  add constraint FKE7D81BF53C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_BANK_CODE
  add constraint uc_AD_BANK_CODE_1 unique (CODE);

alter table AD_BANK_CODE
  add constraint uc_AD_BANK_CODE_2 unique (IBG_CODE);

alter table AD_BANK_CODE
  add constraint uc_AD_BANK_CODE_3 unique (SWIFT_CODE);

alter table AD_BNDL_SBJT
  add constraint FK9C953E48C7189E9E
foreign key (ID)
references AD_SBJT;

alter table AD_BNDL_SBJT_PART
  add constraint FK453E838A9524B059
foreign key (BUNDLE_ID)
references AD_BNDL_SBJT;

alter table AD_BNDL_SBJT_PART
  add constraint FK453E838AB997CDA3
foreign key (COURSE_ID)
references AD_CRSE;

alter table AD_CHRG_SCDL
  add constraint uc_AD_CHRG_SCDL_1 unique (CODE);

alter table AD_CHRG_SCDL
  add constraint FK9DA1A5811EBD8A63
foreign key (COHORT_ID)
references AD_CHRT;

alter table AD_CHRG_SCDL
  add constraint FK9DA1A581293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_CHRG_SCDL
  add constraint FK9DA1A581680A6167
foreign key (STUDY_CENTER_ID)
references AD_STDY_CNTR;

alter table AD_CHRT
  add constraint uc_AD_CHRT_1 unique (CODE);

alter table AD_CHRT
  add constraint FKE7D8DC034A161D23
foreign key (CURRICULUM_ID)
references AD_CRLM;

alter table AD_CHRT
  add constraint FKE7D8DC03293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_CITY_CODE
  add constraint uc_AD_CITY_CODE_1 unique (CODE);

alter table AD_CITY_CODE
  add constraint FK8DFF6B2555D2CB37
foreign key (STATE_CODE_ID)
references AD_STTE_CODE;

alter table AD_CLGE_CODE
  add constraint uc_AD_CLGE_CODE_1 unique (CODE);

alter table AD_CLGE_CODE
  add constraint FKF3D10309CCFDDB93
foreign key (CAMPUS_ID)
references AD_STDY_CNTR;

alter table AD_CMCY_CODE
  add constraint uc_AD_CMCY_CODE_1 unique (CODE);

alter table AD_CNTY_CODE
  add constraint uc_AD_CNTY_CODE_1 unique (CODE);

alter table AD_CRLM
  add constraint uc_AD_CRLM_1 unique (CODE);

alter table AD_CRLM
  add constraint FKE7D900CC293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_CRSE
  add constraint uc_AD_CRSE_1 unique (CODE);

alter table AD_CRSE
  add constraint FKE7D9019D57A98791
foreign key (FACULTY_ID)
references AD_FCTY;

alter table AD_CRSE_MMBR
  add constraint FKDDE75B52B997CDA3
foreign key (COURSE_ID)
references AD_CRSE;

alter table AD_CRSE_MMBR
  add constraint FKDDE75B52B2399EC4
foreign key (MEMBER_ID)
references AD_CRSE;

alter table AD_CRSE_PQST
  add constraint FKDDE8C984B997CDA3
foreign key (COURSE_ID)
references AD_CRSE;

alter table AD_CRSE_PQST
  add constraint FKDDE8C9843C3B8128
foreign key (PREREQUISITE_ID)
references AD_CRSE;

alter table AD_DBLY_CODE
  add constraint uc_AD_DBLY_CODE_1 unique (CODE);

alter table AD_DPCY_CODE
  add constraint uc_AD_DPCY_CODE_1 unique (CODE);

alter table AD_DSCT_CODE
  add constraint uc_AD_DSCT_CODE_1 unique (CODE);

alter table AD_DUN_CODE
  add constraint uc_AD_DUN_CODE_1 unique (CODE);

alter table AD_EMAL_QUEU
  add constraint uc_AD_EMAL_QUEU_1 unique (CODE);

alter table AD_EMIL_TMPT
  add constraint uc_AD_EMIL_TMPT_1 unique (CODE);

alter table AD_EMPT_FILD_CODE
  add constraint uc_AD_EMPT_FILD_CODE_1 unique (CODE);

alter table AD_EMPT_LEVL_CODE
  add constraint uc_AD_EMPT_LEVL_CODE_1 unique (CODE);

alter table AD_EMPT_SCTR_CODE
  add constraint uc_AD_EMPT_SCTR_CODE_1 unique (CODE);

alter table AD_ENMT
  add constraint FKE7D9DAAC72AE81C8
foreign key (ADMISSION_ID)
references AD_ADMN;

alter table AD_ENMT
  add constraint FKE7D9DAAC519575C3
foreign key (GRADE_CODE_ID)
references AD_GRDE_CODE;

alter table AD_ENMT
  add constraint FKE7D9DAAC41D87DF5
foreign key (SECTION_ID)
references AD_SCTN;

alter table AD_ENMT
  add constraint FKE7D9DAAC54FCB007
foreign key (STUDENT_ID)
references AD_STDN;

alter table AD_ENMT_APLN
  add constraint FK43196BA472AE81C8
foreign key (ADMISSION_ID)
references AD_ADMN;

alter table AD_ENMT_APLN
  add constraint FK43196BA4AAEC85C7
foreign key (ADVISOR_ID)
references AD_STAF;

alter table AD_ENMT_APLN
  add constraint FK43196BA43C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_ENMT_APLN
  add constraint FK43196BA454FCB007
foreign key (STUDENT_ID)
references AD_STDN;

alter table AD_ENMT_APPL_ITEM
  add constraint FK4878A29478AB75B1
foreign key (APPLICATION_ID)
references AD_ENMT_APLN;

alter table AD_ENMT_APPL_ITEM
  add constraint FK4878A29441D87DF5
foreign key (SECTION_ID)
references AD_SCTN;

alter table AD_ETNY_CODE
  add constraint uc_AD_ETNY_CODE_1 unique (CODE);

alter table AD_FCTY
  add constraint uc_AD_FCTY_1 unique (CODE);

alter table AD_FILD_CODE
  add constraint uc_AD_FILD_CODE_1 unique (CODE);

alter table AD_GNDR_CODE
  add constraint uc_AD_GNDR_CODE_1 unique (CODE);

alter table AD_GRBK
  add constraint FKE7DAD1109721673F
foreign key (ASSESSMENT_ID)
references AD_ASMT;

alter table AD_GRBK
  add constraint FKE7DAD11027EBF6FF
foreign key (ENROLLMENT_ID)
references AD_ENMT;

alter table AD_GRBK
  add constraint FKE7DAD11041D87DF5
foreign key (SECTION_ID)
references AD_SCTN;

alter table AD_GRDE_CODE
  add constraint uc_AD_GRDE_CODE_1 unique (CODE);

alter table AD_GRDE_CODE
  add constraint uc_AD_GRDE_CODE_2 unique (ORDINAL);

alter table AD_GROP
  add constraint FKE7DAD2A8E43AD0B6
foreign key (ID)
references AD_PCPL;

alter table AD_GROP_MMBR
  add constraint FK6E2579272B894EC7
foreign key (GROUP_ID)
references AD_GROP;

alter table AD_GROP_MMBR
  add constraint FK6E2579271A7CAE67
foreign key (PRINCIPAL_ID)
references AD_PCPL;

alter table AD_INTK_CODE
  add constraint uc_AD_INTK_CODE_1 unique (CODE);

alter table AD_INVT_LEVL_CODE
  add constraint uc_AD_INVT_LEVL_CODE_1 unique (CODE);

alter table AD_INVT_LEVL_CODE
  add constraint FK3AD5073D1B52944
foreign key (TYPE_CODE_ID)
references AD_INVT_TYPE_CODE;

alter table AD_INVT_TTLE_CODE
  add constraint uc_AD_INVT_TTLE_CODE_1 unique (CODE);

alter table AD_INVT_TYPE_CODE
  add constraint uc_AD_INVT_TYPE_CODE_1 unique (CODE);

alter table AD_MODL
  add constraint uc_AD_MODL_1 unique (CANONICAL_CODE);

alter table AD_MODL
  add constraint uc_AD_MODL_2 unique (CODE);

alter table AD_MRTL_CODE
  add constraint uc_AD_MRTL_CODE_1 unique (CODE);

alter table AD_NTLY_CODE
  add constraint uc_AD_NTLY_CODE_1 unique (CODE);

alter table AD_OFRG
  add constraint uc_AD_OFRG_1 unique (CANONICAL_CODE);

alter table AD_OFRG
  add constraint FKE7DE48E8B997CDA3
foreign key (COURSE_ID)
references AD_CRSE;

alter table AD_OFRG
  add constraint FKE7DE48E8293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_PCPL
  add constraint uc_AD_PCPL_1 unique (NAME);

alter table AD_PCPL_ROLE
  add constraint FKBC70E66A1A7CAE67
foreign key (PRINCIPAL_ID)
references AD_PCPL;

alter table AD_PLMT_CODE
  add constraint uc_AD_PLMT_CODE_1 unique (CODE);

alter table AD_PRCS_CLDR
  add constraint FK2EDC93C83C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_PRCS_CLDR
  add constraint FK2EDC93C8680A6167
foreign key (STUDY_CENTER_ID)
references AD_STDY_CNTR;

alter table AD_PRGM
  add constraint uc_AD_PRGM_1 unique (CODE);

alter table AD_PRGM
  add constraint FKE7DEE90457A98791
foreign key (FACULTY_ID)
references AD_FCTY;

alter table AD_PRGM
  add constraint FKE7DEE904F30F379F
foreign key (LEVEL_ID)
references AD_PRGM_LEVL;

alter table AD_PRGM_LEVL
  add constraint uc_AD_PRGM_LEVL_1 unique (CODE);

alter table AD_RACE_CODE
  add constraint uc_AD_RACE_CODE_1 unique (CODE);

alter table AD_RFRN_NO
  add constraint uc_AD_RFRN_NO_1 unique (CODE);

alter table AD_RLGN_CODE
  add constraint uc_AD_RLGN_CODE_1 unique (CODE);

alter table AD_RSCY_CODE
  add constraint uc_AD_RSCY_CODE_1 unique (CODE);

alter table AD_SBJT
  add constraint FKE7E00A754A161D23
foreign key (CURRICULUM_ID)
references AD_CRLM;

alter table AD_SBJT_CODE
  add constraint uc_AD_SBJT_CODE_1 unique (CODE);

alter table AD_SCHL_CODE
  add constraint uc_AD_SCHL_CODE_1 unique (CODE);

alter table AD_SCTN
  add constraint uc_AD_SCTN_1 unique (CANONICAL_CODE);

alter table AD_SCTN
  add constraint FKE7E00F66207B8BFF
foreign key (OFFERING_ID)
references AD_OFRG;

alter table AD_SCTN
  add constraint FKE7E00F663C7922CA
foreign key (SESSION_ID)
references AD_ACDM_SESN;

alter table AD_SCTN_PLCY
  add constraint FK503FDCAB57A98791
foreign key (FACULTY_ID)
references AD_FCTY;

alter table AD_SCTN_PLCY
  add constraint FK503FDCAB41D87DF5
foreign key (SECTION_ID)
references AD_SCTN;

alter table AD_SITE
  add constraint uc_AD_SITE_1 unique (CODE);

alter table AD_SITE_OFRG
  add constraint FKB02AC328293A8391
foreign key (PROGRAM_ID)
references AD_PRGM;

alter table AD_SITE_OFRG
  add constraint FKB02AC3287EFBA663
foreign key (SITE_ID)
references AD_SITE;

alter table AD_SMDL
  add constraint FKE7E032FE3DCC5F1C
foreign key (MODULE_ID)
references AD_MODL;

alter table AD_SNGL_SBJT
  add constraint FK13D34F1CB997CDA3
foreign key (COURSE_ID)
references AD_CRSE;

alter table AD_SNGL_SBJT
  add constraint FK13D34F1CC7189E9E
foreign key (ID)
references AD_SBJT;

alter table AD_STAF
  add constraint FKE7E04CE27BECED7D
foreign key (ID)
references AD_ACTR;

alter table AD_STDN
  add constraint FKE7E04D471EBD8A63
foreign key (COHORT_ID)
references AD_CHRT;

alter table AD_STDN
  add constraint FKE7E04D477BECED7D
foreign key (ID)
references AD_ACTR;

alter table AD_STDY_CNTR
  add constraint uc_AD_STDY_CNTR_1 unique (CODE);

alter table AD_STDY_CNTR_CODE
  add constraint uc_AD_STDY_CNTR_CODE_1 unique (CODE);

alter table AD_STTE_CODE
  add constraint uc_AD_STTE_CODE_1 unique (CODE);

alter table AD_STTE_CODE
  add constraint FK26D25C5E3588F8C1
foreign key (COUNTRY_CODE_ID)
references AD_CNTY_CODE;

alter table AD_USER
  add constraint uc_AD_USER_1 unique (EMAIL);

alter table AD_USER
  add constraint FKE7E13267198B6807
foreign key (ACTOR_ID)
references AD_ACTR;

alter table AD_USER
  add constraint FKE7E13267E43AD0B6
foreign key (ID)
references AD_PCPL;

alter table AD_VENU_CODE
  add constraint uc_AD_VENU_CODE_1 unique (CODE);

create sequence SQ_AD_ACDM_AREA;

create sequence SQ_AD_ACDM_CLDR;

create sequence SQ_AD_ACDM_SESN;

create sequence SQ_AD_ACDM_YEAR;

create sequence SQ_AD_ACTR;

create sequence SQ_AD_ADDR;

create sequence SQ_AD_ADMN;

create sequence SQ_AD_ADMN_APLN;

create sequence SQ_AD_APMT;

create sequence SQ_AD_ASMT;

create sequence SQ_AD_AUDT;

create sequence SQ_AD_BANK_CODE;

create sequence SQ_AD_BNDL_SBJT_PART;

create sequence SQ_AD_CHRG_SCDL;

create sequence SQ_AD_CHRT;

create sequence SQ_AD_CITY_CODE;

create sequence SQ_AD_CLGE_CODE;

create sequence SQ_AD_CMCY_CODE;

create sequence SQ_AD_CNFG;

create sequence SQ_AD_CNTY_CODE;

create sequence SQ_AD_CRLM;

create sequence SQ_AD_CRSE;

create sequence SQ_AD_CRSE_MMBR;

create sequence SQ_AD_CRSE_PQST;

create sequence SQ_AD_DBLY_CODE;

create sequence SQ_AD_DPCY_CODE;

create sequence SQ_AD_DSCT_CODE;

create sequence SQ_AD_DUN_CODE;

create sequence SQ_AD_EMAL_QUEU;

create sequence SQ_AD_EMIL_TMPT;

create sequence SQ_AD_EMPT_FILD_CODE;

create sequence SQ_AD_EMPT_LEVL_CODE;

create sequence SQ_AD_EMPT_SCTR_CODE;

create sequence SQ_AD_ENMT;

create sequence SQ_AD_ENMT_APPL_ITEM;

create sequence SQ_AD_ETNY_CODE;

create sequence SQ_AD_FCTY;

create sequence SQ_AD_FILD_CODE;

create sequence SQ_AD_GNDR_CODE;

create sequence SQ_AD_GRBK;

create sequence SQ_AD_GRDE_CODE;

create sequence SQ_AD_GROP_MMBR;

create sequence SQ_AD_INTK_CODE;

create sequence SQ_AD_INVT_LEVL_CODE;

create sequence SQ_AD_INVT_TTLE_CODE;

create sequence SQ_AD_INVT_TYPE_CODE;

create sequence SQ_AD_MODL;

create sequence SQ_AD_MRTL_CODE;

create sequence SQ_AD_NTLY_CODE;

create sequence SQ_AD_OFRG;

create sequence SQ_AD_PCPL;

create sequence SQ_AD_PCPL_ROLE;

create sequence SQ_AD_PLMT_CODE;

create sequence SQ_AD_PRCS_CLDR;

create sequence SQ_AD_PRGM;

create sequence SQ_AD_PRGM_LEVL;

create sequence SQ_AD_RACE_CODE;

create sequence SQ_AD_RFRN_NO;

create sequence SQ_AD_RLGN_CODE;

create sequence SQ_AD_RSCY_CODE;

create sequence SQ_AD_SBJT_CODE;

create sequence SQ_AD_SCHL_CODE;

create sequence SQ_AD_SCTN;

create sequence SQ_AD_SCTN_PLCY;

create sequence SQ_AD_SITE;

create sequence SQ_AD_SITE_OFRG;

create sequence SQ_AD_SMDL;

create sequence SQ_AD_STDY_CNTR;

create sequence SQ_AD_STDY_CNTR_CODE;

create sequence SQ_AD_STTE_CODE;

create sequence SQ_AD_STDY_MODE;

create sequence SQ_AD_VENU_CODE;

create sequence SQ_AD_WTCH;

create sequence SQ_Ad_ENMT_APLN;

create sequence SQ_CNG_SBJT;
