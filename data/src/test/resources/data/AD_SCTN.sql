INSERT INTO ad_sctn (ID, offering_id, session_id, code, canonical_code, ordinal, capacity, C_ID, C_TS, M_ST)
VALUES (nextval('SQ_AD_SCTN'),
        (SELECT ID
         FROM AD_OFRG
         WHERE canonical_code = 'A01/PHD/0001/GST5023'),
        (SELECT ID
         FROM AD_ACDM_SESN
         WHERE code = '201720181'),
        (SELECT CODE
         FROM AD_OFRG
         WHERE canonical_code = 'A01/PHD/0001/GST5023'),
        (SELECT O.CANONICAL_CODE || '/' || A.CODE
         FROM AD_OFRG O, AD_ACDM_SESN A
         WHERE O.canonical_code = 'A01/PHD/0001/GST5023' AND A.CODE = '201720181'),
        1,
        10,
        1,
        CURRENT_TIMESTAMP,
        1
);
