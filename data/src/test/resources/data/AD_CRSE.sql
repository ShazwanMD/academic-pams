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
                           WHERE F.CODE = 'FKP'), 'DDA2022', 'UKUR KEJURUTERAAN II', 'UKUR KEJURUTERAAN II',
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

                          
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5013', 'Economics & Business Environment', 'Ekonomi & Persekitaran Perniagaan', 'Economics & Business Environment', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5023', 'Organizational Design', 'Design Organisasi', 'Organizational Design', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5033', 'Financial Reporting & Control', 'Laporan Kewangan & Kawalan', 'Financial Reporting & Control', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5043', 'Operations Analysis', 
								'Analisis Operasi', 'Operations Analysis', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5053', 'Human Resource Management', 
								'Pengurusan Sumber Manusia', 'Human Resource Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5063', 'Financial Management', 
								'Pengurusan kewangan', 'Financial Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                  
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5073', 'Marketing Management', 
								'Pengurusan pemasaran', 'Marketing Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5083', 'Information Systems & Electronic Commerce', 'Sistem Maklumat & Perdagangan elektronik', 'Information Systems & Electronic Commerce', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5093', 'Business Law', 'Undang-undang perniagaan', 'Business Law', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);  
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/GST 5103', 'Strategic Management', 'Pengurusan strategik', 'Strategic Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/CORE/GSK 6153', 'Launching Global New Business Ventures', 
								'Melancarkan Ventures Perniagaan Global Baharu', 'Launching Global New Business Ventures', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/CORE/GSK 6163', 'Managing Entrepreneurial Thought & Action', 'Urusan Keusahawanan Pemikiran Tindakan', 'Managing Entrepreneurial Thought & Action', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                  
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/CORE/GSK 6173', 'Enterprise Competitive Positioning Strategy', 'Enterprise kompetitif Strategi Positioning', 'Enterprise Competitive Positioning Strategy', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
 
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/ELECTIVE/GSE6013', 'Social Entrepreneurship', 'Keusahawanan sosial', 'Social Entrepreneurship', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/PROJECTPAPER/GST5113', 'Business Research Methodology', '
								Kaedah Penyelidikan Perniagaan', 'Business Research Methodology', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'MBA/PROJECTPAPER/GST5123', 'Project Paper', 'Kertas projek', 'Project Paper', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER1/Module 1 ', 'Sustainability & Environmental Economics', 'Kelestarian & Ekonomi Alam Sekitar', 'Sustainability & Environmental Economics', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER1/Module 2 ', 'Seminar in Accounting & Control ', 'Seminar Perakaunan & Kawalan', 'Seminar in Accounting & Control ', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER1/Module 3 ', 'Advanced Financial Decision', 'Keputusan Kewangan Lanjutan', 'Advanced Financial Decision', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER1/Module 4 ', 'Advanced Marketing Strategy', 'Strategi Pemasaran Lanjutan', 'Advanced Marketing Strategy', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER2/Module 5 ', 'Seminar In Human Resource Management', 
								'Seminar Pengurusan Sumber Manusia', 'Seminar In Human Resource Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER2/Module 6 ', 'Seminar in Strategic Management', 
								'Seminar Pengurusan Strategik', 'Seminar in Strategic Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR1/SEMESTER2/Module 7', 'Consultancy & Training ( Part 1)', 'Perundingan dan Latihan (Bahagian 1)', 'Consultancy & Training ( Part 1)', 7, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR2/SEMESTER3/Module 8', 'Consultancy & Training ( Part 2)', 'Perundingan dan Latihan (Bahagian 1)', 'Consultancy & Training ( Part 2)', 8, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR2/SEMESTER3/Module 9', 'Seminar in Entrepreneurial Leadership', 
								'Seminar Kepimpinan Keusahawanan', 'Seminar in Entrepreneurial Leadership', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR2/SEMESTER3/Module 10', 'Advanced Business Statistics', 'Statistik Perniagaan Lanjutan', 'Advanced Business Statistics', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR2/SEMESTER4/Module 11', 'Seminar Advanced Research Methodology / Case Methodology', 'Seminar lanjutan Metodologi Penyelidikan/Kaedah kes', 'Seminar Advanced Research Methodology / Case Methodology', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR2/SEMESTER4/Module 12', 'Dissertation ( Part 1)', 'Disertasi (Bahagian 1)', 'Dissertation ( Part 1)', 10, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR3/SEMESTER5/Module 13', 'Dissertation ( Part 2)', 'Disertasi (Bahagian 2)', 'Dissertation ( Part 2)', 15, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'MGSEB'),
                               'DBA/YEAR3/SEMESTER6/Module 14', 'Dissertation ( Part 3)', 'Disertasi (Bahagian 3)', 'Dissertation ( Part 3)', 15, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAM', 'Management', 'Pengurusan', 'Management', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP); 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAM', 'Management', 'Pengurusan', 'Management', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAF', 'Finance', 'Kewangan', 'Finance', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAF', 'Finance', 'Kewangan', 'Finance', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAA', 'Accounting', 'Perakaunan', 'Accounting', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAA', 'Accounting', 'Perakaunan', 'Accounting', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAR', 'Retail', 'Peruncitan', 'Retail', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                               
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAR', 'Retail', 'Peruncitan', 'Retail', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAK', 'Commerce', 'Perdagangan', 'Commerce', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                 
                               
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAK', 'Commerce', 'Perdagangan', 'Commerce', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                                
                                                         
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAW', 'Health Entrepreneurship', 'Keusahawan Kesihatan', 'Health Entrepreneurship', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                          
                          
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAW', 'Health Entrepreneurship', 'Keusahawan Kesihatan', 'Health Entrepreneurship', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                          
                          
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAH', 'Hospitality', 'Hospitaliti', 'Hospitality', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                           
                          
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAH', 'Hospitality', 'Hospitaliti', 'Hospitality', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                          
                          
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAP', 'Tourism', 'Pelancongan', 'Tourism', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                           
                          
INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAP', 'Tourism', 'Pelancongan', 'Tourism', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
