INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'FKP'),
                               'DDA2113', 'MEKANIK BAHAN', 'MEKANIK BAHAN', 'MECHANICS OF MATERIALS', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'FKP'),
                               'DDA2103', 'MEKANIK BAHAN DAN STRUKTUR',
                               'MEKANIK BAHAN DAN STRUKTUR',
                               'MECHANICS OF MATERIALS AND STRUCTURES', 3, 1, 1, 0, CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_AD_CRSE'), (SELECT ID
                           FROM AD_FCTY F
                           WHERE F.CODE = 'FKP'),
                          'DDA2062', 'KEJURUTERAAN ELEKTRIK', 'KEJURUTERAAN ELEKTRIK',
                          'ELECTRICAL ENGINEERING', 2,
                          1, 1, 0, CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_AD_CRSE'), (SELECT ID
                           FROM AD_FCTY F
                           WHERE F.CODE = 'FKP'),
                          'DDA2043', 'PENGATURCARAAN', 'PENGATURCARAAN', 'PROGRAMMING', 3, 1, 1, 0, CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_AD_CRSE'), (SELECT ID
                           FROM AD_FCTY F
                           WHERE F.CODE = 'FIAT'), 'DDA2022', 'UKUR KEJURUTERAAN II', 'UKUR KEJURUTERAAN II',
                          'ENGINEERING SURVEYING II', 2,
                          1, 1, 0, CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'FKP'),
                               'DDA1163', 'LUKISAN KEJURUTERAAN AWAM', 'LUKISAN KEJURUTERAAN AWAM',
                               'CIVIL ENGINEERING DRAWING', 3, 1, 1, 0, CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES
  (nextval('SQ_AD_CRSE'), (SELECT ID
                           FROM AD_FCTY F
                           WHERE F.CODE = 'FKP'),
                          'DDA1153', 'LUKISAN KEJURUTERAAN', 'LUKISAN KEJURUTERAAN', 'ENGINEERING DRAWING', 3, 1, 1,
                          0, CURRENT_TIMESTAMP);
