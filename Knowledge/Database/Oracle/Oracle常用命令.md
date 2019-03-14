# 一、表空间扩展

1. #### 表空间使用情况查询

    ```sql
    SELECT TABLESPACE_NAME "表空间",
           To_char(Round(BYTES / 1024, 2), '99990.00')
           || ''           "实有",
           To_char(Round(FREE / 1024, 2), '99990.00')
           || 'G'          "现有",
           To_char(Round(( BYTES - FREE ) / 1024, 2), '99990.00')
           || 'G'          "使用",
           To_char(Round(10000 * USED / BYTES) / 100, '99990.00')
           || '%'          "比例"
    FROM   (SELECT A.TABLESPACE_NAME                             TABLESPACE_NAME,
                   Floor(A.BYTES / ( 1024 * 1024 ))              BYTES,
                   Floor(B.FREE / ( 1024 * 1024 ))               FREE,
                   Floor(( A.BYTES - B.FREE ) / ( 1024 * 1024 )) USED
            FROM   (SELECT TABLESPACE_NAME TABLESPACE_NAME,
                           Sum(BYTES)      BYTES
                    FROM   DBA_DATA_FILES
                    GROUP  BY TABLESPACE_NAME) A,
                   (SELECT TABLESPACE_NAME TABLESPACE_NAME,
                           Sum(BYTES)      FREE
                    FROM   DBA_FREE_SPACE
                    GROUP  BY TABLESPACE_NAME) B
            WHERE  A.TABLESPACE_NAME = B.TABLESPACE_NAME)
    --WHERE TABLESPACE_NAME LIKE 'CDR%' --这一句用于指定表空间名称
    ORDER  BY Floor(10000 * USED / BYTES) DESC;
    ```

2. #### 查询表空间路径

    ```sql
    select * from dba_data_files where tablespace_name='USERS';
    ```

3. #### 表空间扩展

    - 数据文件路径为第二步查询出的路径

    ```sql
    alter tablespace USERS add datafile '数据文件路径' size 10000m autoextend on next 100m maxsize 40000M;
    ```

    