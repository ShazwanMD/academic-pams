INSERT INTO AD_PRGM(id,code,Status,title_en,title_ms,faculty_id,level_id,m_st,c_id,c_ts) 
VALUES (nextval('SQ_AD_PRGM'),'MGSEB-MBPA',1,'Master of Business Administration','Sarjana Pentadbiran Perniagaan',
(select id from ad_fcty where code='A10'),(select id from ad_prgm_levl where code='MASTER'),1,1,CURRENT_TIMESTAMP);

INSERT INTO AD_PRGM(id,code,Status,title_en,title_ms,faculty_id,level_id,m_st,c_id,c_ts) 
VALUES (nextval('SQ_AD_PRGM'),'MGSEB-DBPA',1,'Doctor of Business Administration','Doktor Pentadbiran Perniagaan',
(select id from ad_fcty where code='A10'),(select id from ad_prgm_levl where code='PHD'),1,1,CURRENT_TIMESTAMP);
