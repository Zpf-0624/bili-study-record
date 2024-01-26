package com.tuyoo.bi.main

/**
 * @Author zhangpengfei
 * @Date 2021-12-16 09:53
 * @Email zhangpengfei@tuyoogame.com
 * @Description  通用信息
 */
trait GAConfig {

    val hdfs_path_tmp = "obs://bi-backup-hdfs/bi-online/user/hive/warehouse/ga_hive.db/%s/day=%s"

    val hdfs_path = "obs://bi-backup-hdfs/bi-online/user/hive/warehouse/ga_hive.db/%s"

    val hive_sql = "select * from ga_hive.%s where day = '%s' "

}
