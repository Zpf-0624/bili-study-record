package com.tuyoo.bi.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import lombok.SneakyThrows;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhangpengfei
 * @Date 2023-03-28 14:51
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Test01 {

    public Map<String, String> map = new ConcurrentHashMap<String, String>() {
        {
            {
                put("2", "10010");
                put("3", "6");
                put("4", "132");
                put("9", "28");
                put("10", "20523");
                put("11", "129");
                put("12", "20519");
                put("15", "20458");
                put("16", "20531");
                put("21", "10010");
            }
        }
    };

    @Test
    public void test01() throws InterruptedException {
        //System.out.println(map);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(map);
                }
            }
        };
        runnable.run();
    }

    @Test
    public void test02(){
        System.out.println(map);
        HashMap<String, String> mapTmp = new HashMap<>();
        //Thread.sleep(1000 * 10);
        mapTmp.put("22", "888");
        map = mapTmp;
        System.out.println(map);
    }

    @Test
    public void test03(){
        System.out.println(1 +1);
        try {
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("====");
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(3);

    }

    @SneakyThrows
    public void Example() {
        int i = 1 / 0;
        System.out.println(i);
    }

    @Test
    public void test04(){
        Example();
        System.out.println(111);

    }

    @Test
    public void test05(){
        String s = "<span style=\"color: #169BD5\">fdasdf</span>";
        System.out.println(s);
    }

    @Test
    public void test06(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());

        Collection arrayList = new ArrayList<>();
        arrayList.add("11");
        arrayList.add("22");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(null, "1");
        System.out.println(hashMap);

        System.out.println(hashMap.size());

        System.out.println("===");

        String a = "{\n" +
                "    \"event\": {\n" +
                "        \"proj_bought_pid\": \"proj_bought_pid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_game_type\": \"proj_game_type::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_brick_location_free\": \"proj_brick_location_free::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_reason\": \"proj_reason::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_time_elapsed\": \"proj_time_elapsed::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_delta\": \"proj_delta::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_finaltablechip\": \"proj_finaltablechip::double::normal::::0::-1::1::1\",\n" +
                "        \"sdk_pay_price_default\": \"sdk_pay_price_default::double::normal::计费点_配置::1::-1::1::1\",\n" +
                "        \"proj_rewarded_levels\": \"proj_rewarded_levels::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_rank_instance_id\": \"proj_rank_instance_id::string::normal::::0::-1::1::1\",\n" +
                "        \"userid\": \"userid::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_level_id\": \"proj_level_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_usercount\": \"proj_usercount::double::normal::::0::-1::1::1\",\n" +
                "        \"province\": \"province::string::normal::省份::1::-1::1::1\",\n" +
                "        \"proj_state\": \"proj_state::string::normal::::0::-1::1::1\",\n" +
                "        \"product_id\": \"product_id::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_cur_level\": \"proj_cur_level::string::normal::::0::-1::1::1\",\n" +
                "        \"app_id\": \"app_id::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_coin_count\": \"proj_coin_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_new_level\": \"proj_new_level::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_reward_chip\": \"proj_reward_chip::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_ab_test_gun\": \"vn_ab_test_gun::string::normal::ab_test_gun::2::1::1::1\",\n" +
                "        \"vn_int_final_chip\": \"vn_int_final_chip::bigint::normal::::2::1::1::1\",\n" +
                "        \"proj_success\": \"proj_success::string::normal::::0::-1::1::1\",\n" +
                "        \"device_id\": \"device_id::string::normal::设备ID::1::-1::1::1\",\n" +
                "        \"proj_suggesttype\": \"proj_suggesttype::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_location_province\": \"sdk_location_province::string::normal::籍贯省份::1::-1::1::1\",\n" +
                "        \"aps\": \"aps::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_pool_max\": \"proj_pool_max::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_costchip\": \"proj_costchip::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_birthday_year\": \"sdk_birthday_year::string::normal::出生年份::1::-1::1::1\",\n" +
                "        \"sdk_push_id\": \"sdk_push_id::string::properties::推送计划id::1::-1::1::1\",\n" +
                "        \"proj_proid\": \"proj_proid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_user_rank\": \"proj_user_rank::string::normal::::0::-1::1::1\",\n" +
                "        \"diff\": \"diff::string::normal::::1::-1::1::1\",\n" +
                "        \"quality\": \"quality::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_free_lottery\": \"proj_free_lottery::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_type\": \"sdk_push_type::string::properties::推送渠道::1::-1::1::1\",\n" +
                "        \"proj_old\": \"proj_old::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_position\": \"proj_position::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_second_num_rev\": \"vn_second_num_rev::string::normal::倒数第二位::2::1::1::1\",\n" +
                "        \"proj_highlimit\": \"proj_highlimit::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_egg1\": \"proj_egg1::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_order_track_id\": \"sdk_order_track_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_egg2\": \"proj_egg2::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_center_count\": \"proj_center_count::string::normal::::0::-1::1::1\",\n" +
                "        \"af_device_id\": \"af_device_id::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_idcard\": \"proj_idcard::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_m1_count_free\": \"proj_m1_count_free::string::normal::::0::-1::1::1\",\n" +
                "        \"ingest_time\": \"ingest_time::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_worth\": \"proj_worth::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_current_level\": \"proj_current_level::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_lastts\": \"proj_lastts::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_gift_id\": \"proj_gift_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_new_egg\": \"proj_new_egg::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_time\": \"sdk_push_time::string::normal::计划推送时间::1::-1::1::1\",\n" +
                "        \"proj_vip\": \"proj_vip::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_conch\": \"proj_conch::string::normal::::0::-1::1::1\",\n" +
                "        \"result\": \"result::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_tail_num\": \"vn_tail_num::string::normal::::2::1::1::1\",\n" +
                "        \"proj_total_free_count\": \"proj_total_free_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_wing_id\": \"proj_wing_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_egg\": \"proj_egg::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_deltacount\": \"proj_deltacount::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_process\": \"proj_process::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_init_value\": \"proj_init_value::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fu_count\": \"proj_fu_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_users_len\": \"proj_users_len::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_season_card_id\": \"proj_season_card_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_add_exchange_score\": \"proj_add_exchange_score::string::normal::::0::-1::1::1\",\n" +
                "        \"oaid\": \"oaid::string::normal::::1::-1::-1::1\",\n" +
                "        \"errorcode\": \"errorcode::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_location_city\": \"sdk_location_city::string::normal::籍贯城市::1::-1::1::1\",\n" +
                "        \"proj_wipe_level\": \"proj_wipe_level::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_sub_pay_type\": \"sdk_sub_pay_type::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_push_receive_time\": \"sdk_push_receive_time::string::normal::收到推送时间::1::-1::1::1\",\n" +
                "        \"proj_final\": \"proj_final::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fire_pool\": \"proj_fire_pool::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_day_short\": \"proj_day_short::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_playtablecount\": \"proj_playtablecount::double::normal::::0::-1::1::1\",\n" +
                "        \"phone_model\": \"phone_model::string::normal::手机型号::1::-1::1::1\",\n" +
                "        \"proj_cost_count\": \"proj_cost_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_client_id\": \"proj_client_id::string::normal::::0::-1::1::1\",\n" +
                "        \"event_id\": \"event_id::string::normal::事件ID::1::-1::1::1\",\n" +
                "        \"proj_conch_use\": \"proj_conch_use::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_m3_count\": \"proj_m3_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_season_version\": \"proj_season_version::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_ABTEST_template\": \"vn_ABTEST_template::string::normal::AB测试分组模版::2::1::1::1\",\n" +
                "        \"country\": \"country::string::normal::国家::1::-1::1::1\",\n" +
                "        \"vn_ads_click_time\": \"vn_ads_click_time::date::normal::ADS归因点击时间::2::1::1::1\",\n" +
                "        \"vn_recharge_v6_APPSTORE\": \"vn_recharge_v6_APPSTORE::string::normal::recharge_v6_APPSTORE::2::1::1::1\",\n" +
                "        \"proj_finnally_pool\": \"proj_finnally_pool::string::normal::::0::-1::1::1\",\n" +
                "        \"push_id\": \"push_id::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_coin_count_free\": \"proj_coin_count_free::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_increment\": \"proj_increment::string::normal::::0::-1::1::1\",\n" +
                "        \"client_id\": \"client_id::string::normal::clientID::1::-1::1::1\",\n" +
                "        \"proj_round_progress\": \"proj_round_progress::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_room_id\": \"proj_room_id::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_local_uuid\": \"sdk_local_uuid::string::properties::::1::-1::1::1\",\n" +
                "        \"vn_int_weapon_id\": \"vn_int_weapon_id::bigint::normal::::2::1::1::1\",\n" +
                "        \"proj_final_chip\": \"proj_final_chip::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_power_int\": \"proj_power_int::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_item_id\": \"proj_item_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_rank_index\": \"proj_rank_index::string::normal::::0::-1::1::1\",\n" +
                "        \"project_id\": \"project_id::string::normal::独立项目ID::1::-1::1::1\",\n" +
                "        \"proj_source\": \"proj_source::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_truedelta_negative\": \"vn_truedelta_negative::bigint::normal::::2::1::1::1\",\n" +
                "        \"proj_item_value\": \"proj_item_value::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_cardlist\": \"proj_cardlist::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_roundid\": \"proj_roundid::string::normal::::0::-1::1::1\",\n" +
                "        \"receive_time\": \"receive_time::date::properties::接收时间::1::-1::1::1\",\n" +
                "        \"vn_if_fircrg\": \"vn_if_fircrg::double::normal::是否破冰::2::1::1::1\",\n" +
                "        \"proj_button\": \"proj_button::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_incr_num\": \"proj_incr_num::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_prob\": \"proj_prob::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_doc_id\": \"proj_doc_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_seasons\": \"proj_seasons::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_project_id\": \"proj_project_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_consume_items\": \"proj_consume_items::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_login_type\": \"sdk_login_type::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_version\": \"proj_version::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_mission_id\": \"proj_mission_id::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_days_after_register_dhr\": \"vn_days_after_register_dhr::bigint::normal::注册后第N日::2::4::1::1\",\n" +
                "        \"proj_max_unlock\": \"proj_max_unlock::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_chiptype\": \"proj_chiptype::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_cur_season\": \"proj_cur_season::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_extentid\": \"proj_extentid::string::normal::::0::-1::1::1\",\n" +
                "        \"bossid\": \"bossid::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_lottery_no_free\": \"proj_lottery_no_free::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_pay_price_cny\": \"sdk_pay_price_cny::double::normal::付费金额_CNY::1::-1::1::1\",\n" +
                "        \"proj_roulette_level\": \"proj_roulette_level::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_random\": \"proj_random::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_rank_snapshot\": \"proj_rank_snapshot::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_succ_currency\": \"sdk_succ_currency::string::normal::::0::-1::1::1\",\n" +
                "        \"video\": \"video::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_sheet\": \"proj_sheet::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_m2_count_free\": \"proj_m2_count_free::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_message\": \"sdk_push_message::string::normal::sdk返回信息::1::-1::1::1\",\n" +
                "        \"proj_lottery_count\": \"proj_lottery_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_finaly_score\": \"proj_finaly_score::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_location_code\": \"sdk_location_code::string::normal::籍贯行政地区编码::1::-1::1::1\",\n" +
                "        \"sdk_push_body\": \"sdk_push_body::string::normal::推送文案::1::-1::1::1\",\n" +
                "        \"proj_diamond_cost\": \"proj_diamond_cost::string::normal::::0::-1::1::1\",\n" +
                "        \"game_id\": \"game_id::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_arglist\": \"proj_arglist::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_battery_level\": \"proj_battery_level::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_lowlimit\": \"proj_lowlimit::string::normal::::0::-1::1::1\",\n" +
                "        \"typushid\": \"typushid::string::normal::::1::-1::1::1\",\n" +
                "        \"fps\": \"fps::string::normal::::1::-1::1::1\",\n" +
                "        \"multiple\": \"multiple::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_gunlevel\": \"proj_gunlevel::bigint::normal::::0::-1::1::1\",\n" +
                "        \"proj_price\": \"proj_price::string::normal::::0::-1::1::1\",\n" +
                "        \"ip_address\": \"ip_address::string::normal::ip地址::1::-1::1::1\",\n" +
                "        \"proj_multiple\": \"proj_multiple::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_days_after_register\": \"vn_days_after_register::double::normal::days_after_register::2::4::1::1\",\n" +
                "        \"proj_level\": \"proj_level::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_pay_strategy_2022_02_23\": \"vn_pay_strategy_2022_02_23::string::normal::策略2022_02_23::2::1::1::1\",\n" +
                "        \"proj_day_fuqi\": \"proj_day_fuqi::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_task_group\": \"proj_task_group::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_viplevel\": \"proj_viplevel::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_round_lottery\": \"proj_round_lottery::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_abtest_majiang\": \"vn_abtest_majiang::string::normal::abtest_vivo_majiang::2::1::1::1\",\n" +
                "        \"platform_id\": \"platform_id::string::normal::平台ID::1::-1::1::1\",\n" +
                "        \"attribute_promote_channel\": \"attribute_promote_channel::string::normal::国内归因渠道::1::-1::1::1\",\n" +
                "        \"imei\": \"imei::string::normal::::1::-1::-1::1\",\n" +
                "        \"proj_remain_second\": \"proj_remain_second::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_order_desc\": \"sdk_order_desc::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_bosstype\": \"proj_bosstype::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_test_vn2\": \"vn_test_vn2::bigint::normal::测试虚拟属性2::2::1::1::1\",\n" +
                "        \"push_time\": \"push_time::string::normal::::1::-1::1::1\",\n" +
                "        \"docmid\": \"docmid::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_bought_level\": \"proj_bought_level::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_olap_id\": \"sdk_push_olap_id::string::normal::文案id::1::-1::1::1\",\n" +
                "        \"vn_int_truedelta\": \"vn_int_truedelta::bigint::normal::::2::1::1::1\",\n" +
                "        \"google_id\": \"google_id::string::normal::::1::-1::-1::1\",\n" +
                "        \"proj_cpu_percent\": \"proj_cpu_percent::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_bugtest\": \"vn_bugtest::string::normal::bugtest::2::1::1::1\",\n" +
                "        \"attribute_ads_id\": \"attribute_ads_id::string::normal::国内归因子渠道::1::-1::1::1\",\n" +
                "        \"proj_state2\": \"proj_state2::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_product_price\": \"sdk_product_price::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_s_dev_id\": \"sdk_s_dev_id::string::normal::::1::-1::1::1\",\n" +
                "        \"attribute_activity_name\": \"attribute_activity_name::string::normal::国内活动参数::1::-1::1::1\",\n" +
                "        \"proj_state1\": \"proj_state1::bigint::normal::::0::-1::1::1\",\n" +
                "        \"type\": \"type::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_m1_count\": \"proj_m1_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_gun_multi\": \"proj_gun_multi::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_multi_ratio\": \"proj_multi_ratio::string::normal::::0::-1::1::1\",\n" +
                "        \"idfv\": \"idfv::string::normal::::1::-1::-1::1\",\n" +
                "        \"proj_mode\": \"proj_mode::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_wheel_index\": \"proj_wheel_index::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_inherit_active_pool\": \"proj_inherit_active_pool::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_wheel_deep\": \"proj_wheel_deep::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_return_chip\": \"proj_return_chip::string::normal::::0::-1::1::1\",\n" +
                "        \"idfa\": \"idfa::string::normal::::1::-1::-1::1\",\n" +
                "        \"proj_fish_value\": \"proj_fish_value::string::normal::::0::-1::1::1\",\n" +
                "        \"currency_price_cny\": \"currency_price_cny::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_init_factor\": \"proj_init_factor::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_pay_type\": \"sdk_pay_type::string::normal::支付方式::1::-1::1::1\",\n" +
                "        \"proj_passedseconds\": \"proj_passedseconds::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_add_ratio\": \"proj_add_ratio::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_times_left\": \"proj_times_left::string::normal::::0::-1::1::1\",\n" +
                "        \"user_id\": \"user_id::string::normal::用户ID::1::-1::1::1\",\n" +
                "        \"proj_observercount\": \"proj_observercount::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_pool2\": \"proj_pool2::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_old_level\": \"proj_old_level::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_pool3\": \"proj_pool3::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_tableid\": \"proj_tableid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_cost\": \"proj_cost::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_is_accelerate\": \"proj_is_accelerate::string::normal::::0::-1::1::1\",\n" +
                "        \"channel_id\": \"channel_id::string::normal::渠道::1::-1::1::1\",\n" +
                "        \"proj_rank_group_id\": \"proj_rank_group_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_has_reward\": \"proj_has_reward::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_pool1\": \"proj_pool1::string::normal::::0::-1::1::1\",\n" +
                "        \"phone_maker\": \"phone_maker::string::normal::手机厂商::1::-1::1::1\",\n" +
                "        \"proj_passeddays\": \"proj_passeddays::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_clientid\": \"proj_clientid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_suggestion\": \"proj_suggestion::string::normal::::0::-1::1::1\",\n" +
                "        \"city\": \"city::string::normal::城市::1::-1::1::1\",\n" +
                "        \"proj_catchtype\": \"proj_catchtype::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_test_event_usera\": \"vn_test_event_usera::bigint::normal::测试事件用户属性::2::4::1::1\",\n" +
                "        \"sub_platform_id\": \"sub_platform_id::string::normal::子平台ID::1::-1::1::1\",\n" +
                "        \"proj_wipe_times\": \"proj_wipe_times::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_ABTEST_oppo_gun_upgrade\": \"vn_ABTEST_oppo_gun_upgrade::string::normal::ABTEST_oppo_gun_upgrade::2::1::1::1\",\n" +
                "        \"part_offset\": \"part_offset::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_client_version\": \"vn_client_version::double::normal::client_id版本号::2::1::1::1\",\n" +
                "        \"proj_m2_count\": \"proj_m2_count::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_ABtest_fishtrack\": \"vn_ABtest_fishtrack::string::normal::新渔场实验分组::2::1::1::1\",\n" +
                "        \"freespace\": \"freespace::bigint::normal::::1::-1::1::1\",\n" +
                "        \"proj_level_type\": \"proj_level_type::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_itemname\": \"proj_itemname::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_add_active_process\": \"proj_add_active_process::string::normal::::0::-1::1::1\",\n" +
                "        \"os_version\": \"os_version::string::normal::手机版本::1::-1::1::1\",\n" +
                "        \"proj_round_lottery_times\": \"proj_round_lottery_times::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_execute_id\": \"sdk_push_execute_id::string::properties::推送执行id::1::-1::1::1\",\n" +
                "        \"proj_param02\": \"proj_param02::string::normal::::0::-1::1::1\",\n" +
                "        \"rec_id\": \"rec_id::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_param01\": \"proj_param01::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_real_incr\": \"proj_real_incr::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_remain_count\": \"proj_remain_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_round_id\": \"proj_round_id::string::normal::::0::-1::1::1\",\n" +
                "        \"olapid\": \"olapid::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_param04\": \"proj_param04::bigint::normal::::0::-1::1::1\",\n" +
                "        \"proj_truedelta\": \"proj_truedelta::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_param03\": \"proj_param03::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_param06\": \"proj_param06::double::normal::::0::-1::1::1\",\n" +
                "        \"needspace\": \"needspace::bigint::normal::::1::-1::1::1\",\n" +
                "        \"proj_param05\": \"proj_param05::double::normal::::0::-1::1::1\",\n" +
                "        \"sdk_order_env\": \"sdk_order_env::string::normal::支付环境::0::-1::1::1\",\n" +
                "        \"proj_param08\": \"proj_param08::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_param07\": \"proj_param07::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_cost_diamond\": \"proj_cost_diamond::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_currency_code\": \"sdk_currency_code::string::normal::币种::1::-1::1::1\",\n" +
                "        \"sdk_third_order_id\": \"sdk_third_order_id::string::normal::三方订单号::1::-1::1::1\",\n" +
                "        \"sdk_yidun_device_id\": \"sdk_yidun_device_id::string::normal::设备指纹::0::-1::1::1\",\n" +
                "        \"proj_param09\": \"proj_param09::string::normal::::0::-1::1::1\",\n" +
                "        \"os_name\": \"os_name::string::normal::手机系统::1::-1::1::1\",\n" +
                "        \"proj_olap_id\": \"proj_olap_id::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_bind_id\": \"sdk_bind_id::string::normal::::1::-1::-1::1\",\n" +
                "        \"sdk_product_currency\": \"sdk_product_currency::string::normal::::0::-1::1::1\",\n" +
                "        \"sub_channel_id\": \"sub_channel_id::string::normal::子渠道::1::-1::1::1\",\n" +
                "        \"downloadtime\": \"downloadtime::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_product_count\": \"sdk_product_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fire_value\": \"proj_fire_value::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_m3_count_free\": \"proj_m3_count_free::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_pay_price\": \"sdk_pay_price::double::normal::付费金额_计费点::1::-1::1::1\",\n" +
                "        \"proj_indexs\": \"proj_indexs::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_actual_time\": \"sdk_push_actual_time::string::normal::实际推送时间::1::-1::1::1\",\n" +
                "        \"proj_brick_distance\": \"proj_brick_distance::string::normal::::0::-1::1::1\",\n" +
                "        \"uuid\": \"uuid::string::normal::每条日志的唯一标识::1::-1::1::1\",\n" +
                "        \"proj_detalchip\": \"proj_detalchip::double::normal::::0::-1::1::1\",\n" +
                "        \"imei2\": \"imei2::string::normal::::1::-1::-1::1\",\n" +
                "        \"proj_battery_id\": \"proj_battery_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_total_nofree_count\": \"proj_total_nofree_count::string::normal::::0::-1::1::1\",\n" +
                "        \"imei1\": \"imei1::string::normal::::1::-1::-1::1\",\n" +
                "        \"proj_wheel_id\": \"proj_wheel_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_rank\": \"proj_rank::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_base_chip\": \"proj_base_chip::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_nonvirtual_cmcc\": \"vn_nonvirtual_cmcc::string::normal::非虚拟移动手机号::2::1::-1::1\",\n" +
                "        \"phone_num\": \"phone_num::string::normal::::1::-1::-1::1\",\n" +
                "        \"sdk_push_image_url\": \"sdk_push_image_url::string::normal::推送图片::1::-1::1::1\",\n" +
                "        \"proj_task_id\": \"proj_task_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fragment_count\": \"proj_fragment_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_param1\": \"proj_param1::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_user_tail_num\": \"vn_user_tail_num::string::normal::倒数第一位::2::1::1::1\",\n" +
                "        \"proj_af_device_id\": \"proj_af_device_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_appid\": \"proj_appid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fruit_num\": \"proj_fruit_num::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_rank_value\": \"proj_rank_value::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_finaluserchip\": \"proj_finaluserchip::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_star\": \"proj_star::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_gender\": \"sdk_gender::string::normal::性别::1::-1::1::1\",\n" +
                "        \"proj_roomid\": \"proj_roomid::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_pay_cny_double\": \"vn_pay_cny_double::double::normal::付费金额双精度::2::1::1::1\",\n" +
                "        \"chanel\": \"chanel::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_push_title\": \"sdk_push_title::string::normal::推送标题::1::-1::1::1\",\n" +
                "        \"sdk_game_order_id\": \"sdk_game_order_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fishid\": \"proj_fishid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_lottery_times\": \"proj_lottery_times::string::normal::::0::-1::1::1\",\n" +
                "        \"videotype\": \"videotype::string::normal::::1::-1::1::1\",\n" +
                "        \"effect\": \"effect::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_buy_count\": \"proj_buy_count::bigint::normal::::0::-1::1::1\",\n" +
                "        \"proj_accumulate\": \"proj_accumulate::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_lottery_free\": \"proj_lottery_free::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_up_level\": \"proj_up_level::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_crgid\": \"proj_crgid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_eventparam\": \"proj_eventparam::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_gameid\": \"proj_gameid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_item_count\": \"proj_item_count::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_push_expire_time\": \"sdk_push_expire_time::string::normal::推送有效期::1::-1::1::1\",\n" +
                "        \"vn_fish_room\": \"vn_fish_room::string::normal::渔场房间::2::1::1::1\",\n" +
                "        \"proj_new\": \"proj_new::string::normal::::0::-1::1::1\",\n" +
                "        \"network\": \"network::string::normal::网络类型::1::-1::1::1\",\n" +
                "        \"vn_ab_test_dhr\": \"vn_ab_test_dhr::string::normal::ab_test_oppo_data::2::1::1::1\",\n" +
                "        \"proj_quest_id\": \"proj_quest_id::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_base_coin\": \"proj_base_coin::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_orderplatformid\": \"proj_orderplatformid::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_product\": \"proj_product::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_own_count\": \"proj_own_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_poolchip1\": \"proj_poolchip1::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_poolchip2\": \"proj_poolchip2::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_fire_count\": \"proj_fire_count::double::normal::::0::-1::1::1\",\n" +
                "        \"proj_init_event\": \"proj_init_event::string::normal::::0::-1::1::1\",\n" +
                "        \"currency_price_format\": \"currency_price_format::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_add_rate\": \"proj_add_rate::string::normal::::0::-1::1::1\",\n" +
                "        \"attribute_click_time\": \"attribute_click_time::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_order_id\": \"sdk_order_id::string::normal::订单号::1::-1::1::1\",\n" +
                "        \"proj_get_num\": \"proj_get_num::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_brick_location\": \"proj_brick_location::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_pool\": \"proj_pool::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_currency_price\": \"sdk_currency_price::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_lottery_free_round\": \"proj_lottery_free_round::string::normal::::0::-1::1::1\",\n" +
                "        \"windcoin\": \"windcoin::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_gunrate\": \"proj_gunrate::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_if_virtual_phone_num\": \"vn_if_virtual_phone_num::double::normal::是否为虚拟手机号::2::1::-1::1\",\n" +
                "        \"proj_incr_pool\": \"proj_incr_pool::string::normal::::0::-1::1::1\",\n" +
                "        \"roomid\": \"roomid::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_version_code\": \"vn_version_code::string::normal::version_code::2::1::1::1\",\n" +
                "        \"proj_price_coupon\": \"proj_price_coupon::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_reward_times\": \"proj_reward_times::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_test_vn\": \"vn_test_vn::bigint::normal::测试虚拟属性::2::1::1::1\",\n" +
                "        \"vn_ads_click_register\": \"vn_ads_click_register::double::normal::激活耗时::2::1::1::1\",\n" +
                "        \"proj_card_lvl\": \"proj_card_lvl::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_count\": \"proj_count::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_pool_before\": \"proj_pool_before::string::normal::::0::-1::1::1\",\n" +
                "        \"proj_rank_table_id\": \"proj_rank_table_id::string::normal::::0::-1::1::1\",\n" +
                "        \"sdk_product_id\": \"sdk_product_id::string::normal::商品ID::1::-1::1::1\",\n" +
                "        \"proj_lottery_no_free_round\": \"proj_lottery_no_free_round::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_VIVO_weapon_recommend\": \"vn_VIVO_weapon_recommend::string::normal::推荐炮倍实验::2::1::1::1\",\n" +
                "        \"event_time\": \"event_time::date::normal::事件时间戳::1::-1::1::1\"\n" +
                "    },\n" +
                "    \"devices\": {\n" +
                "        \"activity_name\": \"activity_name::string::normal::Ads归因活动参数::1::-1::1::1\",\n" +
                "        \"total_pay_cny\": \"total_pay_cny::double::normal::累计付费金额CNY::1::-1::1::1\",\n" +
                "        \"last_login_time\": \"last_login_time::date::normal::最后登录时间::1::-1::1::1\",\n" +
                "        \"latest_diamond_amount\": \"latest_diamond_amount::string::normal::::1::-1::1::1\",\n" +
                "        \"create_type\": \"create_type::string::normal::注册方式（游客/三方账号/手机号）::1::-1::1::1\",\n" +
                "        \"total_pay_cnt\": \"total_pay_cnt::bigint::normal::累计付费次数::1::-1::1::1\",\n" +
                "        \"adtrace_adgroup_id\": \"adtrace_adgroup_id::string::normal::AdTrace广告组ID::1::-1::1::1\",\n" +
                "        \"fish_3d_recommend_price\": \"fish_3d_recommend_price::string::normal::::1::-1::1::1\",\n" +
                "        \"uuid\": \"uuid::string::normal::每条日志的唯一标识::1::-1::1::1\",\n" +
                "        \"af_fb_campaign_id\": \"af_fb_campaign_id::string::normal::AF-FB广告计划ID::1::-1::1::1\",\n" +
                "        \"last_pay_cny\": \"last_pay_cny::double::normal::最近付费金额CNY::1::-1::1::1\",\n" +
                "        \"af_campaign\": \"af_campaign::string::normal::AF广告计划::1::-1::1::1\",\n" +
                "        \"adtrace_act_name\": \"adtrace_act_name::string::normal::AdTrace活动参数::1::-1::1::1\",\n" +
                "        \"create_country\": \"create_country::string::normal::注册国家::1::-1::1::1\",\n" +
                "        \"strategy_must_catch\": \"strategy_must_catch::string::normal::::1::-1::1::1\",\n" +
                "        \"create_date\": \"create_date::string::normal::注册日期（东八时区)::1::-1::1::1\",\n" +
                "        \"app_id\": \"app_id::string::normal::::1::-1::1::1\",\n" +
                "        \"latest_voucher_amount\": \"latest_voucher_amount::string::normal::::1::-1::1::1\",\n" +
                "        \"create_time\": \"create_time::date::normal::注册时间戳::1::-1::1::1\",\n" +
                "        \"device_id\": \"device_id::string::normal::设备ID::1::-1::1::1\",\n" +
                "        \"media_source\": \"media_source::string::normal::AF归因来源渠道::1::-1::1::1\",\n" +
                "        \"max_consume_voucher\": \"max_consume_voucher::string::normal::::1::-1::1::1\",\n" +
                "        \"last_pay_time\": \"last_pay_time::date::normal::最近付费时间::1::-1::1::1\",\n" +
                "        \"af_fb_adgroup_name\": \"af_fb_adgroup_name::string::normal::AF-FB广告组名称::1::-1::1::1\",\n" +
                "        \"af_site_id\": \"af_site_id::string::normal::AF子渠道ID::1::-1::1::1\",\n" +
                "        \"gdt_channel\": \"gdt_channel::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_project_id\": \"proj_project_id::string::normal::::0::-1::1::1\",\n" +
                "        \"last_login_type\": \"last_login_type::string::normal::最后登录方式::1::-1::1::1\",\n" +
                "        \"af_ad_id\": \"af_ad_id::string::normal::AF广告素材ID::1::-1::1::1\",\n" +
                "        \"behavior_pattern\": \"behavior_pattern::string::normal::用户异常行为模式::0::-1::1::1\",\n" +
                "        \"latest_logout_time\": \"latest_logout_time::string::normal::::1::-1::1::1\",\n" +
                "        \"ads_id\": \"ads_id::string::normal::Ads归因子渠道::1::-1::1::1\",\n" +
                "        \"total_login_days\": \"total_login_days::bigint::normal::累计活跃天数::1::-1::1::1\",\n" +
                "        \"phone_number\": \"phone_number::string::normal::::1::-1::-1::1\",\n" +
                "        \"vip_level\": \"vip_level::string::normal::::1::-1::1::1\",\n" +
                "        \"first_login_add_chip\": \"first_login_add_chip::string::normal::::1::-1::1::1\",\n" +
                "        \"first_login_time\": \"first_login_time::date::normal::首次登录时间::1::-1::1::1\",\n" +
                "        \"adtrace_platform\": \"adtrace_platform::string::normal::AdTrace归因来源渠道::1::-1::1::1\",\n" +
                "        \"last_pay_prod\": \"last_pay_prod::string::normal::最近付费商品::1::-1::1::1\",\n" +
                "        \"promote_channel\": \"promote_channel::string::normal::Ads归因来源渠道::1::-1::1::1\",\n" +
                "        \"af_adset_id\": \"af_adset_id::string::normal::AF广告组ID::1::-1::1::1\",\n" +
                "        \"first_pay_cny\": \"first_pay_cny::double::normal::破冰金额CNY::1::-1::1::1\",\n" +
                "        \"adtrace_virtual_sub_channel\": \"adtrace_virtual_sub_channel::string::normal::::1::-1::1::1\",\n" +
                "        \"recharge_cny_168h\": \"recharge_cny_168h::double::normal::最近7日内付费金额CNY::1::-1::1::1\",\n" +
                "        \"adtrace_creative_id\": \"adtrace_creative_id::string::normal::AdTrace广告创意ID::1::-1::1::1\",\n" +
                "        \"latest_coin_amount\": \"latest_coin_amount::string::normal::::1::-1::1::1\",\n" +
                "        \"create_client_id\": \"create_client_id::string::normal::注册clientID::1::-1::1::1\",\n" +
                "        \"recharge_cnt_168h\": \"recharge_cnt_168h::bigint::normal::最近7日内付费次数::1::-1::1::1\",\n" +
                "        \"af_campaign_id\": \"af_campaign_id::string::normal::AF广告计划ID::1::-1::1::1\",\n" +
                "        \"is_old_user\": \"is_old_user::string::normal::::1::-1::1::1\",\n" +
                "        \"latest_level\": \"latest_level::string::normal::::1::-1::1::1\",\n" +
                "        \"nofree_gold_add\": \"nofree_gold_add::string::normal::::1::-1::1::1\",\n" +
                "        \"routine_gun_level\": \"routine_gun_level::string::normal::::1::-1::1::1\",\n" +
                "        \"adtrace_campaign_id\": \"adtrace_campaign_id::string::normal::AdTrace广告计划ID::1::-1::1::1\",\n" +
                "        \"game_id\": \"game_id::string::normal::::1::-1::1::1\",\n" +
                "        \"max_pay_amount\": \"max_pay_amount::string::normal::::1::-1::1::1\",\n" +
                "        \"proj_client_id\": \"proj_client_id::string::normal::::0::-1::1::1\",\n" +
                "        \"risk_level\": \"risk_level::string::normal::用户风险等级::0::-1::1::1\",\n" +
                "        \"total_pay_amount\": \"total_pay_amount::string::normal::::1::-1::1::1\",\n" +
                "        \"total_pay_times\": \"total_pay_times::string::normal::::1::-1::1::1\",\n" +
                "        \"predict_stay\": \"predict_stay::string::normal::::1::-1::1::1\",\n" +
                "        \"af_adset\": \"af_adset::string::normal::AF广告组::1::-1::1::1\",\n" +
                "        \"adtrace_aid\": \"adtrace_aid::string::normal::AdTrace应用::1::-1::1::1\",\n" +
                "        \"first_pay_prod\": \"first_pay_prod::string::normal::破冰商品::1::-1::1::1\",\n" +
                "        \"first_pay_time\": \"first_pay_time::date::normal::破冰时间::1::-1::1::1\",\n" +
                "        \"free_gold_add\": \"free_gold_add::string::normal::::1::-1::1::1\",\n" +
                "        \"af_ad\": \"af_ad::string::normal::AF广告素材::1::-1::1::1\",\n" +
                "        \"adtrace_account_id\": \"adtrace_account_id::string::normal::AdTrace广告主ID::1::-1::1::1\"\n" +
                "    },\n" +
                "    \"users\": {\n" +
                "        \"total_pay_cny\": \"total_pay_cny::double::normal::累计付费金额CNY::1::-1::1::1\",\n" +
                "        \"vn_create_channel\": \"vn_create_channel::string::normal::注册渠道::2::2::1::1\",\n" +
                "        \"vn_gun_recommend\": \"vn_gun_recommend::string::normal::推荐倍率实验组::2::2::1::1\",\n" +
                "        \"create_type\": \"create_type::string::normal::注册方式（游客/三方账号/手机号）::1::-1::1::1\",\n" +
                "        \"total_pay_cnt\": \"total_pay_cnt::bigint::normal::累计付费次数::1::-1::1::1\",\n" +
                "        \"vn_ABTEST_cannon_online_oppo\": \"vn_ABTEST_cannon_online_oppo::string::normal::ABTEST_cannon_online_oppo::2::2::1::1\",\n" +
                "        \"vn_create_month\": \"vn_create_month::string::normal::create_month::2::2::1::1\",\n" +
                "        \"fish_3d_recommend_price\": \"fish_3d_recommend_price::string::normal::推荐礼包价格::1::-1::1::1\",\n" +
                "        \"vn_video_share\": \"vn_video_share::string::normal::视频分享实验组::2::2::1::1\",\n" +
                "        \"af_campaign\": \"af_campaign::string::normal::AF广告计划::1::-1::1::1\",\n" +
                "        \"vn_create_sub_channel\": \"vn_create_sub_channel::string::normal::注册子渠道::2::2::1::1\",\n" +
                "        \"adtrace_act_name\": \"adtrace_act_name::string::normal::AdTrace活动参数::1::-1::1::1\",\n" +
                "        \"app_id\": \"app_id::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_ABTEST_cannon_appStore\": \"vn_ABTEST_cannon_appStore::string::normal::苹果渠道推荐炮倍实验::2::2::1::1\",\n" +
                "        \"vn_test_0529\": \"vn_test_0529::date::normal::test_0529::2::2::1::1\",\n" +
                "        \"media_source\": \"media_source::string::normal::AF归因来源渠道::1::-1::1::1\",\n" +
                "        \"sdk_location_province\": \"sdk_location_province::string::normal::籍贯省份::1::-1::1::1\",\n" +
                "        \"last_pay_time\": \"last_pay_time::date::normal::最近付费时间::1::-1::1::1\",\n" +
                "        \"sdk_birthday_year\": \"sdk_birthday_year::string::normal::出生年份::1::-1::1::1\",\n" +
                "        \"af_site_id\": \"af_site_id::string::normal::AF子渠道ID::1::-1::1::1\",\n" +
                "        \"af_fb_adgroup_name\": \"af_fb_adgroup_name::string::normal::AF-FB广告组名称::1::-1::1::1\",\n" +
                "        \"vn_ABC_PVP_vivo\": \"vn_ABC_PVP_vivo::string::normal::最强王者ABC分组_vivo::2::2::1::1\",\n" +
                "        \"last_login_type\": \"last_login_type::string::normal::最后登录方式::1::-1::1::1\",\n" +
                "        \"behavior_pattern\": \"behavior_pattern::string::normal::用户异常行为模式::0::-1::1::1\",\n" +
                "        \"latest_logout_time\": \"latest_logout_time::date::normal::::1::-1::1::1\",\n" +
                "        \"user_id\": \"user_id::string::normal::用户ID::1::-1::1::1\",\n" +
                "        \"ads_id\": \"ads_id::string::normal::Ads归因子渠道::1::-1::1::1\",\n" +
                "        \"vip_level\": \"vip_level::string::normal::::1::-1::1::1\",\n" +
                "        \"first_login_time\": \"first_login_time::date::normal::首次登录时间::1::-1::1::1\",\n" +
                "        \"mobile_city\": \"mobile_city::string::normal::绑定手机号所属市::1::-1::1::1\",\n" +
                "        \"vn_ABTEST_onlinelottery_oppo\": \"vn_ABTEST_onlinelottery_oppo::string::normal::ABTEST_onlinelottery_oppo::2::2::1::1\",\n" +
                "        \"af_adset_id\": \"af_adset_id::string::normal::AF广告组ID::1::-1::1::1\",\n" +
                "        \"first_pay_cny\": \"first_pay_cny::double::normal::破冰金额CNY::1::-1::1::1\",\n" +
                "        \"vn_create_client_version\": \"vn_create_client_version::double::normal::注册版本号::2::2::1::1\",\n" +
                "        \"adtrace_creative_id\": \"adtrace_creative_id::string::normal::AdTrace广告创意ID::1::-1::1::1\",\n" +
                "        \"create_client_id\": \"create_client_id::string::normal::注册clientID::1::-1::1::1\",\n" +
                "        \"recharge_cnt_168h\": \"recharge_cnt_168h::bigint::normal::最近7日内付费次数::1::-1::1::1\",\n" +
                "        \"vn_vip_tier\": \"vn_vip_tier::string::normal::vip_tier::2::2::1::1\",\n" +
                "        \"is_old_user\": \"is_old_user::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_pay_motivation0208\": \"vn_pay_motivation0208::string::normal::付费激励0208::2::2::1::1\",\n" +
                "        \"latest_level\": \"latest_level::string::normal::::1::-1::1::1\",\n" +
                "        \"nofree_gold_add\": \"nofree_gold_add::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_location_city\": \"sdk_location_city::string::normal::籍贯城市::1::-1::1::1\",\n" +
                "        \"max_pay_amount\": \"max_pay_amount::double::normal::::1::-1::1::1\",\n" +
                "        \"vn_genz\": \"vn_genz::string::normal::00后用户::2::2::1::1\",\n" +
                "        \"proj_client_id\": \"proj_client_id::string::normal::::0::-1::1::1\",\n" +
                "        \"risk_level\": \"risk_level::string::normal::用户风险等级::0::-1::1::1\",\n" +
                "        \"total_pay_amount\": \"total_pay_amount::double::normal::::1::-1::1::1\",\n" +
                "        \"total_pay_times\": \"total_pay_times::bigint::normal::::1::-1::1::1\",\n" +
                "        \"ceshi01\": \"ceshi01::string::normal::::0::-1::1::1\",\n" +
                "        \"af_adset\": \"af_adset::string::normal::AF广告组::1::-1::1::1\",\n" +
                "        \"first_pay_prod\": \"first_pay_prod::string::normal::破冰商品::1::-1::1::1\",\n" +
                "        \"mobile_number\": \"mobile_number::string::normal::绑定手机号（加密）::1::-1::1::1\",\n" +
                "        \"mobile_number_segment\": \"mobile_number_segment::string::normal::绑定手机号号段::1::-1::1::1\",\n" +
                "        \"activity_name\": \"activity_name::string::normal::Ads归因活动参数::1::-1::1::1\",\n" +
                "        \"last_login_time\": \"last_login_time::date::normal::最后登录时间::1::-1::1::1\",\n" +
                "        \"latest_diamond_amount\": \"latest_diamond_amount::double::normal::::1::-1::1::1\",\n" +
                "        \"vn_new_fish_track\": \"vn_new_fish_track::string::normal::新渔场实验::2::2::1::1\",\n" +
                "        \"tail_num\": \"tail_num::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_ABTEST_dragonball\": \"vn_ABTEST_dragonball::string::normal::ABTEST_dragonball::2::2::1::1\",\n" +
                "        \"adtrace_adgroup_id\": \"adtrace_adgroup_id::string::normal::AdTrace广告组ID::1::-1::1::1\",\n" +
                "        \"uuid\": \"uuid::string::normal::每条日志的唯一标识::1::-1::1::1\",\n" +
                "        \"af_fb_campaign_id\": \"af_fb_campaign_id::string::normal::AF-FB广告计划ID::1::-1::1::1\",\n" +
                "        \"vn_bene_send\": \"vn_bene_send::string::normal::破产救济金实验::2::2::1::1\",\n" +
                "        \"last_pay_cny\": \"last_pay_cny::double::normal::最近付费金额CNY::1::-1::1::1\",\n" +
                "        \"vn_mobile_type\": \"vn_mobile_type::string::normal::手机号类型（虚拟+运营商）::2::2::1::1\",\n" +
                "        \"vn_behavior_pattern\": \"vn_behavior_pattern::string::normal::用户异常行为模式描述::2::2::1::1\",\n" +
                "        \"create_country\": \"create_country::string::normal::注册国家::1::-1::1::1\",\n" +
                "        \"strategy_must_catch\": \"strategy_must_catch::string::normal::::1::-1::1::1\",\n" +
                "        \"create_date\": \"create_date::string::normal::注册日期（东八时区)::1::-1::1::1\",\n" +
                "        \"latest_voucher_amount\": \"latest_voucher_amount::double::normal::::1::-1::1::1\",\n" +
                "        \"vn_anniversary_test\": \"vn_anniversary_test::string::normal::周年庆实验_华为渠道::2::2::1::1\",\n" +
                "        \"create_time\": \"create_time::date::normal::注册时间戳::1::-1::1::1\",\n" +
                "        \"max_consume_voucher\": \"max_consume_voucher::bigint::normal::::1::-1::1::1\",\n" +
                "        \"vn_first_pay_time\": \"vn_first_pay_time::date::normal::首次付费时间（转）::2::2::1::1\",\n" +
                "        \"gdt_channel\": \"gdt_channel::string::normal::::1::-1::1::1\",\n" +
                "        \"sdk_gender\": \"sdk_gender::string::normal::性别::1::-1::1::1\",\n" +
                "        \"proj_project_id\": \"proj_project_id::string::normal::::0::-1::1::1\",\n" +
                "        \"vn_pay_motivation2\": \"vn_pay_motivation2::string::normal::付费激励实验组::2::2::1::1\",\n" +
                "        \"af_ad_id\": \"af_ad_id::string::normal::AF广告素材ID::1::-1::1::1\",\n" +
                "        \"total_login_days\": \"total_login_days::bigint::normal::累计活跃天数::1::-1::1::1\",\n" +
                "        \"mobile_province\": \"mobile_province::string::normal::绑定手机号所属省::1::-1::1::1\",\n" +
                "        \"first_login_add_chip\": \"first_login_add_chip::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_ABTEST_santa\": \"vn_ABTEST_santa::string::normal::觉醒圣诞老人AB测试::2::2::1::1\",\n" +
                "        \"adtrace_platform\": \"adtrace_platform::string::normal::AdTrace归因来源渠道::1::-1::1::1\",\n" +
                "        \"last_pay_prod\": \"last_pay_prod::string::normal::最近付费商品::1::-1::1::1\",\n" +
                "        \"promote_channel\": \"promote_channel::string::normal::Ads归因来源渠道::1::-1::1::1\",\n" +
                "        \"adtrace_virtual_sub_channel\": \"adtrace_virtual_sub_channel::string::normal::虚拟子渠道::1::-1::1::1\",\n" +
                "        \"recharge_cny_168h\": \"recharge_cny_168h::double::normal::最近7日内付费金额CNY::1::-1::1::1\",\n" +
                "        \"mobile_bind_date\": \"mobile_bind_date::string::normal::手机号绑定日期::1::-1::1::1\",\n" +
                "        \"latest_coin_amount\": \"latest_coin_amount::double::normal::::1::-1::1::1\",\n" +
                "        \"af_campaign_id\": \"af_campaign_id::string::normal::AF广告计划ID::1::-1::1::1\",\n" +
                "        \"vn_pay_motivation\": \"vn_pay_motivation::string::normal::付费激励策略::2::2::1::1\",\n" +
                "        \"vn_tail_number\": \"vn_tail_number::string::normal::尾号::2::2::1::1\",\n" +
                "        \"vn_userflag\": \"vn_userflag::double::normal::单双号::2::2::1::1\",\n" +
                "        \"routine_gun_level\": \"routine_gun_level::bigint::normal::::1::-1::1::1\",\n" +
                "        \"adtrace_campaign_id\": \"adtrace_campaign_id::string::normal::AdTrace广告计划ID::1::-1::1::1\",\n" +
                "        \"game_id\": \"game_id::string::normal::::1::-1::1::1\",\n" +
                "        \"vn_VIVO_ABCD_TEST\": \"vn_VIVO_ABCD_TEST::string::normal::VIVO渠道三实验::2::2::1::1\",\n" +
                "        \"predict_stay\": \"predict_stay::string::normal::流失/留存预测::1::-1::1::1\",\n" +
                "        \"adtrace_aid\": \"adtrace_aid::string::normal::AdTrace应用::1::-1::1::1\",\n" +
                "        \"first_pay_time\": \"first_pay_time::date::normal::破冰时间::1::-1::1::1\",\n" +
                "        \"free_gold_add\": \"free_gold_add::string::normal::::1::-1::1::1\",\n" +
                "        \"af_ad\": \"af_ad::string::normal::AF广告素材::1::-1::1::1\",\n" +
                "        \"adtrace_account_id\": \"adtrace_account_id::string::normal::AdTrace广告主ID::1::-1::1::1\"\n" +
                "    }\n" +
                "}";

        JSONObject event = JSONObject.parseObject(a).getJSONObject("event");
        System.out.println(event);
        Collection<Object> values = event.values();
        values.forEach(System.out::println);


    }

    @Test
    public void test07(){

        String a = "{\"device_id\":\"\",\"lib\":{\"lib_version\":\"0.1.0\",\"lib_type\":\"golang\"},\"part_offset\":\"fc5b4282-7488-11ee-a380-fa163ec06378\",\"project_id\":\"20461\",\"user_id\":\"10230\",\"type\":\"track\",\"event\":\"adtrace_register_new\",\"client_id\":\"Android_5.0_tyGuest,tyAccount.alipay.0-hall20461.adtrace.tuyoo\",\"event_time\":1698384219318,\"properties\":{\"adtrace_actname\":\"\",\"country\":\"未知\",\"channel_ty_adgroup_id\":\"\",\"proj_game_id\":\"9998\",\"proj_game_type\":\"3\",\"adtrace_device_ua\":\"Mozilla/5.0 (Linux; Android 13; OPD2101 Build/TP1A.220905.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/111.0.5563.116 Safari/537.36 XWEB/5317 MMWEBSDK/20230805 MMWEBID/275 MicroMessenger/8.0.42.2460(0x28002AA8) WeChat/arm64 Weixin Android Tablet NetType/WIFI Language/zh_CN ABI/arm64 MiniProgramEnv/android\",\"city\":\"未知\",\"adtrace_did\":\"24_10230\",\"sub_platform_id\":\"2\",\"uuid\":\"fc5b4282-7488-11ee-a380-fa163ec06378\",\"userid\":\"10230\",\"channel_callback_url\":\"\",\"proj_main_channel\":\"weixin\",\"province\":\"未知\",\"product_id\":\"20461\",\"adtrace_act_name\":\"\",\"proj_sub_channel\":\"yizzqx\",\"adtrace_channel_click_id\":\"\",\"adtrace_namespace\":\"qunxiongwx20535\",\"sdk_open_id\":\"oD6xD43sA0r3PcFaBVW2H0zChEOU\",\"adtrace_attributed\":\"0\",\"channel_ks_callback\":\"\",\"proj_cloud_id\":\"80\",\"channel_ty_creative_id\":\"\",\"adtrace_ty_click_id\":\"\",\"adtrace_device_ip\":\"60.191.106.130\",\"adtrace_organic_traffic\":\"1\",\"proj_project_id\":\"0\",\"proj_client_id\":\"H5_5.0_weixin.weixin.0-hall20535.weixin.yizzqx\",\"channel_ty_account_id\":\"\",\"channel_ty_campaign_id\":\"\",\"adtrace_aid\":\"24\",\"platform_id\":\"1\",\"adtrace_reattributed\":\"0\",\"sub_channel_id\":\"tuyoo\",\"adtrace_ctit\":\"\",\"channel_id\":\"adtrace\",\"adtrace_attribution_time\":\"1698384219318\",\"adtrace_platform\":\"organic\"}}";
        AdtraceAttrData adtraceAttrData = new AdtraceAttrData(a);
        System.out.println(adtraceAttrData);

        Set<String> projectSet = new HashSet<>();
        projectSet.add("111");
        String project_id = adtraceAttrData.getProject_id();
        System.out.println(project_id);
        System.out.println(projectSet.contains(adtraceAttrData.getProject_id()));
        System.out.println(JSON.toJSONString(adtraceAttrData));

        String ss = null;

        boolean b = ss == null ? a == null : ss.equals(a);

        System.out.println(b);

        System.out.println(ss.hashCode());

    }


    @Test
    public void test08() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("aa");
        objects.add("bb");
        objects.add("cc");

        objects.forEach(x -> {
            if (x.equals("bb")) return;
            System.out.println(x);
        });

        /*System.out.println(objects);
        for (String object : objects) {
            if (object.equals("bb")) return;
            System.out.println(object);
        }*/

        String a= null;
        System.out.println(a.isEmpty());
        System.out.println(111);

    }






}

@Data
@ToString
class BaseData {

    public String event;
    public long event_time;     // 毫秒值
    public String user_id;
    public String project_id;
    public String client_id;    //client_name
    public String device_id;
    public String type;
    public JSONObject properties = new JSONObject();
    public JSONObject lib = new JSONObject();


    public BaseData() {
        lib.put("trans_by", "GA-axe");
        lib.put("language", "java");
        lib.put("version", "0.0.1");
    }
}


class AdtraceAttrData extends BaseData {

    /**
     * 将OPPO数据装成接收的kafka数据标准格式
     */

    public AdtraceAttrData(String value) {
        JSONObject jsonObject = JSON.parseObject(value);
        JSONObject properties = jsonObject.getJSONObject("properties");

        this.event_time = jsonObject.getLong("event_time");
        this.user_id = jsonObject.getString("user_id");

        String cloud = properties.getString("proj_cloud_id");
        String game = properties.getString("proj_game_id");
        String client = properties.getString("proj_client_id");

        this.project_id = null;
        this.client_id = properties.getString("proj_client_id");
        this.device_id = jsonObject.getString("device_id");

        this.type = "profile";
        this.event = "profile_set_once";

        String sourceEvent = jsonObject.getString("event");

        if ("adtrace_register_new".equals(sourceEvent)) {
            this.device_id = "";
            //设备归因用户属性
            String adtracePlatform = properties.getString("adtrace_platform").trim().equals("organic") ? null : properties.getString("adtrace_platform");
            this.properties.put("adtrace_platform", adtracePlatform);
            this.properties.put("adtrace_act_name", properties.getString("adtrace_act_name"));
            this.properties.put("adtrace_account_id", properties.getString("channel_ty_account_id"));
            this.properties.put("adtrace_campaign_id", properties.getString("channel_ty_campaign_id"));
            this.properties.put("adtrace_adgroup_id", properties.getString("channel_ty_adgroup_id"));
            this.properties.put("adtrace_creative_id", properties.getString("channel_ty_creative_id"));
            this.properties.put("adtrace_uniq_id", properties.getString("sdk_uniq_id"));
            this.properties.put("adtrace_video_id", properties.getString("sdk_video_id"));
        } else if ("adtrace_register".equals(sourceEvent)) {
            //虚拟子渠道
            this.properties.put("adtrace_virtual_sub_channel", properties.getString("proj_virtual_sub_channel"));
        }
    }

}