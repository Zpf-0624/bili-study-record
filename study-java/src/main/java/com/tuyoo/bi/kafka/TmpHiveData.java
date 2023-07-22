package com.tuyoo.bi.kafka;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangpengfei
 * @Date 2023-06-06 10:42
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class TmpHiveData {

    public static void main(String[] args) {
        TmpHiveData tmpHiveData = new TmpHiveData();
        List<List<Object>> dataTmp = tmpHiveData.getDataTmp();
    }

    public List<List<Object>> getDataTmp() {
        List<List<Object>> objects = new ArrayList<>();
        int cnt = 0;
        while (true) {
            List<Object> list = new ArrayList<>();
            //list.add()

            cnt ++;
            if (cnt > 1000){
                return objects;
            }
        }
    }

}
