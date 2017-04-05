INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/PHD/0001',
   'Doctor of Philosophy Bio-Industrial Technology',
   'Doctor of Philosophy Bio-Industrial Technology',
   'Doctor of Philosophy Bio-Industrial Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/PHD/0002',
   'Doctor of Philosophy Agro Technopreneurship',
   'Doctor of Philosophy Agro Technopreneurship',
   'Doctor of Philosophy Agro Technopreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/PHD/0003',
   'Doctor of Philosophy Agriculture Biotechnology',
   'Doctor of Philosophy Agriculture Biotechnology',
   'Doctor of Philosophy Agriculture Biotechnology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/PHD/0004',
   'Doctor of Philosophy Product Development Technology',
   'Doctor of Philosophy Product Development Technology',
   'Doctor of Philosophy Product Development Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/MASTER/0001',
   'Master of Science Bio-Industrial Technology',
   'Master of Science Bio-Industrial Technology',
   'Master of Science Bio-Industrial Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/MASTER/0002',
   'Master of Science Agro Technopreneurship',
   'Master of Science Agro Technopreneurship',
   'Master of Science Agro Technopreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/MASTER/0003',
   'Master of Science Agriculture Biotechnology',
   'Master of Science Agriculture Biotechnology',
   'Master of Science Agriculture Biotechnology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A07/MASTER/0004',
   'Master of Science Product Development Technology',
   'Master of Science Product Development Technology',
   'Master of Science Product Development Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A07'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/PHD/0001',
   'Doctor of Philosophy Geoscience',
   'Doctor of Philosophy Geoscience',
   'Doctor of Philosophy Geoscience',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/PHD/0002',
   'Doctor of Philosophy Natural Resources Management',
   'Doctor of Philosophy Natural Resources Management',
   'Doctor of Philosophy Natural Resources Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/PHD/0003',
   'Doctor of Philosophy Sustainable Science',
   'Doctor of Philosophy Sustainable Science',
   'Doctor of Philosophy Sustainable Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/PHD/0004',
   'Doctor of Philosophy Material Technology',
   'Doctor of Philosophy Material Technology',
   'Doctor of Philosophy Material Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/PHD/0005',
   'Doctor of Philosophy Forest Resources Technology',
   'Doctor of Philosophy Forest Resources Technology',
   'Doctor of Philosophy Forest Resources Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/PHD/0006',
   'Doctor of Philosophy Energy Technology',
   'Doctor of Philosophy Energy Technology',
   'Doctor of Philosophy Energy Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/MASTER/0001',
   'Master of Science Geoscience',
   'Master of Science Geoscience',
   'Master of Science Geoscience',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/MASTER/0002',
   'Master of Science Natural Resources Management',
   'Master of Science Natural Resources Management',
   'Master of Science Natural Resources Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/MASTER/0003',
   'Master of Science Sustainable Science',
   'Master of Science Sustainable Science',
   'Master of Science Sustainable Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/MASTER/0004',
   'Master of Science Material Technology',
   'Master of Science Material Technology',
   'Master of Science Material Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/MASTER/0005',
   'Master of Science Forest Resources Technology',
   'Master of Science Forest Resources Technology',
   'Master of Science Forest Resources Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A08/MASTER/0006',
   'Master of Science Energy Technology',
   'Master of Science Energy Technology',
   'Master of Science Energy Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A08'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/PHD/0001',
   'Doctor of Philosophy Phatology',
   'Doctor of Philosophy Phatology',
   'Doctor of Philosophy Phatology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/PHD/0002',
   'Doctor of Philosophy Nutrition',
   'Doctor of Philosophy Nutrition',
   'Doctor of Philosophy Nutrition',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/PHD/0003',
   'Doctor of Philosophy Anatomy',
   'Doctor of Philosophy Anatomy',
   'Doctor of Philosophy Anatomy',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/PHD/0004',
   'Doctor of Philosophy Microbiology',
   'Doctor of Philosophy Microbiology',
   'Doctor of Philosophy Microbiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/PHD/0005',
   'Doctor of Philosophy Parasitology',
   'Doctor of Philosophy Parasitology',
   'Doctor of Philosophy Parasitology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/PHD/0006',
   'Doctor of Philosophy Physiology',
   'Doctor of Philosophy Physiology',
   'Doctor of Philosophy Physiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/MASTER/0001',
   'Master of Science Phatology',
   'Master of Science Phatology',
   'Master of Science Phatology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/MASTER/0002',
   'Master of Science Nutrition',
   'Master of Science Nutrition',
   'Master of Science Nutrition',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/MASTER/0003',
   'Master of Science Anatomy',
   'Master of Science Anatomy',
   'Master of Science Anatomy',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/MASTER/0004',
   'Master of Science Microbiology',
   'Master of Science Microbiology',
   'Master of Science Microbiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/MASTER/0005',
   'Master of Science Parasitology',
   'Master of Science Parasitology',
   'Master of Science Parasitology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A06/MASTER/0006',
   'Master of Science Physiology',
   'Master of Science Physiology',
   'Master of Science Physiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A06'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0001',
   'Doctor of Philosophy Studies of History and Civilisation',
   'Doctor of Philosophy Studies of History and Civilisation',
   'Doctor of Philosophy Studies of History and Civilisation',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0002',
   'Doctor of Philosophy Development and Educational Values',
   'Doctor of Philosophy Development and Educational Values',
   'Doctor of Philosophy Development and Educational Values',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0003',
   'Doctor of Philosophy Industrial Psychological Organization',
   'Doctor of Philosophy Industrial Psychological Organization',
   'Doctor of Philosophy Industrial Psychological Organization',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0004',
   'Doctor of Philosophy Religion And Contemporary',
   'Doctor of Philosophy Religion And Contemporary',
   'Doctor of Philosophy Religion And Contemporary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0005',
   'Doctor of Philosophy Social Work',
   'Doctor of Philosophy Social Work',
   'Doctor of Philosophy Social Work',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0006',
   'Doctor of Philosophy Language Studies',
   'Doctor of Philosophy Language Studies',
   'Doctor of Philosophy Language Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/PHD/0007',
   'Doctor of Philosophy Communication',
   'Doctor of Philosophy Communication',
   'Doctor of Philosophy Communication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0001',
   'Master of Arts Studies of History and Civilisation',
   'Master of Arts Studies of History and Civilisation',
   'Master of Arts Studies of History and Civilisation',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0002',
   'Master of Arts Development and Educational Values',
   'Master of Arts Development and Educational Values',
   'Master of Arts Development and Educational Values',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0003',
   'Master of Arts Industrial Psychological Organization',
   'Master of Arts Industrial Psychological Organization',
   'Master of Arts Industrial Psychological Organization',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0004',
   'Master of Arts Religion And Contemporary',
   'Master of Arts Religion And Contemporary',
   'Master of Arts Religion And Contemporary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0005',
   'Master of Arts Social Work',
   'Master of Arts Social Work',
   'Master of Arts Social Work',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0006',
   'Master of Arts Language Studies',
   'Master of Arts Language Studies',
   'Master of Arts Language Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A04/MASTER/0007',
   'Master of Arts Communication',
   'Master of Arts Communication',
   'Master of Arts Communication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A04'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/PHD/0001',
   'Doctor of Philosophy Heritage Studies',
   'Doctor of Philosophy Heritage Studies',
   'Doctor of Philosophy Heritage Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/PHD/0002',
   'Doctor of Philosophy Textile and Fashion',
   'Doctor of Philosophy Textile and Fashion',
   'Doctor of Philosophy Textile and Fashion',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/PHD/0003',
   'Doctor of Philosophy Product Design',
   'Doctor of Philosophy Product Design',
   'Doctor of Philosophy Product Design',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/PHD/0004',
   'Doctor of Philosophy Multimedia',
   'Doctor of Philosophy Multimedia',
   'Doctor of Philosophy Multimedia',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/PHD/0005',
   'Doctor of Philosophy VisualCommunication',
   'Doctor of Philosophy VisualCommunication',
   'Doctor of Philosophy VisualCommunication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/MASTER/0001',
   'Master of Arts Heritage Studies',
   'Master of Arts Heritage Studies',
   'Master of Arts Heritage Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/MASTER/0002',
   'Master of Arts Textile and Fashion',
   'Master of Arts Textile and Fashion',
   'Master of Arts Textile and Fashion',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/MASTER/0003',
   'Master of Arts Product Design',
   'Master of Arts Product Design',
   'Master of Arts Product Design',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/MASTER/0004',
   'Master of Arts Multimedia',
   'Master of Arts Multimedia',
   'Master of Arts Multimedia',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A02/MASTER/0005',
   'Master of Arts VisualCommunication',
   'Master of Arts VisualCommunication',
   'Master of Arts VisualCommunication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A02'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0001',
   'Doctor of Philosophy Management',
   'Doctor of Philosophy Management',
   'Doctor of Philosophy Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0002',
   'Doctor of Philosophy Finance',
   'Doctor of Philosophy Finance',
   'Doctor of Philosophy Finance',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0003',
   'Doctor of Philosophy Accounting',
   'Doctor of Philosophy Accounting',
   'Doctor of Philosophy Accounting',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0004',
   'Doctor of Philosophy Retailing',
   'Doctor of Philosophy Retailing',
   'Doctor of Philosophy Retailing',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0005',
   'Doctor of Philosophy Commerce',
   'Doctor of Philosophy Commerce',
   'Doctor of Philosophy Commerce',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0006',
   'Doctor of Philosophy HealthEntrepreneurship',
   'Doctor of Philosophy HealthEntrepreneurship',
   'Doctor of Philosophy HealthEntrepreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0007',
   'Doctor of Philosophy Hospitality',
   'Doctor of Philosophy Hospitality',
   'Doctor of Philosophy Hospitality',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/PHD/0008',
   'Doctor of Philosophy Tourism',
   'Doctor of Philosophy Tourism',
   'Doctor of Philosophy Tourism',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0001',
   'Master of Entrepreneurship Management',
   'Master of Entrepreneurship Management',
   'Master of Entrepreneurship Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0002',
   'Master of Entrepreneurship Finance',
   'Master of Entrepreneurship Finance',
   'Master of Entrepreneurship Finance',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0003',
   'Master of Entrepreneurship Accounting',
   'Master of Entrepreneurship Accounting',
   'Master of Entrepreneurship Accounting',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0004',
   'Master of Entrepreneurship Retailing',
   'Master of Entrepreneurship Retailing',
   'Master of Entrepreneurship Retailing',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0005',
   'Master of Entrepreneurship Commerce',
   'Master of Entrepreneurship Commerce',
   'Master of Entrepreneurship Commerce',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0006',
   'Master of Entrepreneurship HealthEntrepreneurship',
   'Master of Entrepreneurship HealthEntrepreneurship',
   'Master of Entrepreneurship HealthEntrepreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0007',
   'Master of Entrepreneurship Hospitality',
   'Master of Entrepreneurship Hospitality',
   'Master of Entrepreneurship Hospitality',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A01/MASTER/0008',
   'Master of Entrepreneurship Tourism',
   'Master of Entrepreneurship Tourism',
   'Master of Entrepreneurship Tourism',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A01'), CURRENT_TIMESTAMP, 0, 1);
    
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'A10',
   'Master of Economics & Business Environment',
   'Master of Economics & Business Environment',
   'Master of Economics & Business Environment',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.CODE = 'A10'), CURRENT_TIMESTAMP, 0, 1);    
    
    
    
    
    
