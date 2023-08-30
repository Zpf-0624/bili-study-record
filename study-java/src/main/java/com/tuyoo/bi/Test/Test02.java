package com.tuyoo.bi.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.joda.time.DateTime;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhangpengfei
 * @Date 2023-04-11 17:36
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Test02 {

    public static String getNowDate() {
        DateTime nowTime = new DateTime();
        //nowTime.plusSeconds(600);
        return nowTime.toString("yyyy-MM-dd");
    }

    public static String join(){
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");

        List<String> l2 = new ArrayList<>();
        //l2.add("c");
        //l2.add("d");

        System.out.println(l2.isEmpty());

        //String join1 = String.join("`, `", l1);
        //String join2 = String.join(", ", l2);

        //System.out.println(join1);
        //System.out.println(join2);
        //return "`" + join1 + ", " + join2;

        String viewDeclareSql = String.format("select `%s`, %s from ga_kudu.%s",
                String.join("`, `", l1),
                String.join(", ", l2),
                "event_10010_v4");

        return viewDeclareSql;


    }

    public static void main(String[] args) {
        System.out.println(getNowDate());
        System.out.println(join());


    }

    @Test
    public void test001(){
        for (int i = 20 ; i> 10; i--){
            switch (i){
                case 11 :
                    System.out.println( "aaa");
                    break;
                case 12 :
                    System.out.println("bbb");
                    break;
                case 15:
                    System.out.println("eeee");
                    break;
                default:
                    System.out.println(i);
            }
        }
    }

    @Test
    public void test002(){
        Set<String> set1 = new HashSet<>();
        set1.add("event");
        //set1.add("property");
        set1.add("users");
        set1.add("devices");

        System.out.println(set1);
        List<String> sortedList = set1.stream()
                .sorted(Comparator.comparing(s -> {
                    if (s.equals("property")) {
                        return 0;  // property 排在最前面
                    } else if (s.equals("event")) {
                        return 1;  // event 排在第二个
                    } else {
                        return 2;  // 其他的不排序，按照元素插入顺序排序
                    }
                }))
                .collect(Collectors.toList());

        System.out.println(sortedList);   // 输出 [property, event, users, devices]


    }

    @Test
    public void test003(){
        String a = "{\"propertiesErrorCounts\":{\n" +
                "        \"country\":{\n" +
                "\n" +
                "        },\n" +
                "        \"google_id\":{\n" +
                "            \"empty-value\":47899\n" +
                "        },\n" +
                "        \"phone_maker\":{\n" +
                "            \"empty-value\":92808\n" +
                "        },\n" +
                "        \"ingest_time\":{\n" +
                "\n" +
                "        },\n" +
                "        \"city\":{\n" +
                "            \"empty-value\":9698\n" +
                "        },\n" +
                "        \"sdk_pay_price\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_pay_price_cny\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_pay_price_default\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sub_platform_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"type\":{\n" +
                "\n" +
                "        },\n" +
                "        \"client_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"network\":{\n" +
                "            \"empty-value\":92808\n" +
                "        },\n" +
                "        \"imei2\":{\n" +
                "\n" +
                "        },\n" +
                "        \"imei1\":{\n" +
                "\n" +
                "        },\n" +
                "        \"part_offset\":{\n" +
                "\n" +
                "        },\n" +
                "        \"province\":{\n" +
                "            \"empty-value\":196,\n" +
                "            \"value-error\":92612\n" +
                "        },\n" +
                "        \"project_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"product_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"idfv\":{\n" +
                "\n" +
                "        },\n" +
                "        \"currency_price_format\":{\n" +
                "\n" +
                "        },\n" +
                "        \"app_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_order_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"oaid\":{\n" +
                "            \"empty-value\":10896\n" +
                "        },\n" +
                "        \"game_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"device_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_currency_price\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_sub_pay_type\":{\n" +
                "            \"empty-value\":92808\n" +
                "        },\n" +
                "        \"idfa\":{\n" +
                "\n" +
                "        },\n" +
                "        \"currency_price_cny\":{\n" +
                "\n" +
                "        },\n" +
                "        \"ip_address\":{\n" +
                "\n" +
                "        },\n" +
                "        \"phone_model\":{\n" +
                "            \"empty-value\":92808\n" +
                "        },\n" +
                "        \"sdk_pay_type\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_order_env\":{\n" +
                "            \"empty-value\":75224\n" +
                "        },\n" +
                "        \"event_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_currency_code\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_third_order_id\":{\n" +
                "            \"empty-value\":4\n" +
                "        },\n" +
                "        \"sdk_yidun_device_id\":{\n" +
                "            \"empty-value\":4055\n" +
                "        },\n" +
                "        \"user_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"platform_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"imei\":{\n" +
                "            \"empty-value\":92808\n" +
                "        },\n" +
                "        \"os_name\":{\n" +
                "            \"empty-value\":92808\n" +
                "        },\n" +
                "        \"sdk_order_desc\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sdk_product_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"sub_channel_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"channel_id\":{\n" +
                "\n" +
                "        },\n" +
                "        \"event_time\":{\n" +
                "\n" +
                "        }\n" +
                "}}";


        HashMap<String, Map<String,Long>> objectObjectHashMap = new HashMap<>();

        Map<String, Long> map = new HashMap<>();
        /*Map<String, Map<String, Long>> stringMapMap = JSONObject.parseObject(a, new TypeReference<Map<String, Map<String, Long>>>() {
        });

        Long os_name = stringMapMap.get("os_name").get("empty-value");
        System.out.println(os_name);*/

        String s = JSONObject.toJSONString(map);
        System.out.println(s);

        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);

        Map<String, Long> map1 = JSONObject.parseObject(s, Map.class);
        System.out.println(map1);
        System.out.println(map1.isEmpty());


        Map<String, Map<String, Map<String, Integer>>> map2 = JSONObject.parseObject(a, Map.class);
        System.out.println(map2);
        Map<String, Integer> stringLongMap = map2.get("propertiesErrorCounts").get("os_name");
        System.out.println(stringLongMap);
        Integer aLong = stringLongMap.get("empty-value");
        System.out.println(aLong);

    }

    @Test
    public void test04() {
        Map map = new HashMap<String, String>();
        Object put = map.put("键", "对应的值");//如果有值则覆盖，没有则添加。如果没值则返回空，有则返回上次的值
        Object put2 = map.put("键", "对应的值2");//如果有值则覆盖，没有则添加。如果没值则返回空，有则返回上次的值
        Object put3 = map.put("键", "对应的值3");//如果有值则覆盖，没有则添加。如果没值则返回空，有则返回上次的值
        System.out.println(put); //输出结果  null
        System.out.println(put2); //输出结果(上次的值)  对应的值
        System.out.println(put3); //输出结果(上次的值)  对应的值2
        System.out.println(map);

        //02 这里的操作等价于 01 的操作 k代表键，v代表值
        Map mapCompute = new HashMap<String, String>();
        Object mapComputeValue = mapCompute.compute("键", (k, v) -> "对应的值");//有值则覆盖，没值则添加，这个跟put一样，但是返回是目前的值，put是返回上次的值
        Object mapComputeValue2 = mapCompute.compute("键", (k, v) -> "对应的值2");//有值则覆盖，没值则添加，这个跟put一样，但是返回是目前的值，put是返回上次的值
        System.out.println(mapComputeValue); //输出结果  对应的值
        System.out.println(mapComputeValue2); //输出结果  对应的值2
        System.out.println(mapCompute);

        //03 如果map中不存在等于"键"的k，则添加为"键"的k以及"对应的值",如果有，则不操作
        System.out.println("--------------mapComputeIfAbsent-----------------");
        Map mapComputeIfAbsent = new HashMap<String, String>();
        Object valueAbsent = mapComputeIfAbsent.computeIfAbsent("键", k -> "value");
        Object valueAbsent2 = mapComputeIfAbsent.computeIfAbsent("键", k -> "value2");
        System.out.println(mapComputeIfAbsent); //输出结果 {键=value}
        System.out.println(valueAbsent); //输出结果 value
        System.out.println(valueAbsent2); //输出结果 value


        //04 如果map中不存在等于"键"的k，则不操作，有才覆盖,跟computeIfAbsent相反
        System.out.println("--------------computeIfPresent-----------------");
        Map mapIfPresent = new HashMap<String, String>();
        Object valuePresent = mapIfPresent.computeIfPresent("键", (k,v) -> "value");
        System.out.println(mapIfPresent); //输出结果 {}
        System.out.println(valuePresent); //输出结果 null
        mapIfPresent.put("键", "对应的值");
        Object valuePresent2 = mapIfPresent.computeIfPresent("键",(k,v) -> "value2");
        System.out.println(mapIfPresent); //输出结果 {键=value2}
        System.out.println(valuePresent2); //输出结果 value2


        System.out.println(mapIfPresent.remove("键","对应的值"));
        System.out.println(mapIfPresent.remove("键","value2"));
        System.out.println("------------------getOrDefault----------------------------");
        Map getOrdefault = new HashMap<String, String>();
        Object orDefault = getOrdefault.getOrDefault("java", "ifconfig");//这里ifconfig是一个默认值，不会添加到Map里面去
        System.out.println(orDefault);
        System.out.println(getOrdefault);

        System.out.println("------------------replaceAll----------------------------");
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivia", "james bond");
        favouriteMovies.replaceAll((friend, movie) -> {return friend.toLowerCase();});
        System.out.println(favouriteMovies);//输出 {Olivia=olivia, Raphael=raphael}

        System.out.println("------------------replace----------------------------");
        Map<String, String> favouriteMovies2 = new HashMap<>();
        favouriteMovies2.put("Raphael", "Star Wars");
        favouriteMovies2.put("Olivia", "james bond");
        favouriteMovies2.replace("Raphael","bond");
        System.out.println(favouriteMovies2);;//输出 {Olivia=james bond, Raphael=bond}


        System.out.println("------------------merge----------------------------");
        Map<String, String> m1 = new HashMap<>();
        m1.put("Raphael", "Star Wars");
        m1.put("Olivia2", "james bond2");
        m1.put("Olivia", "james bon2d");
        Map<String, String> m2 = new HashMap<>();
        m2.put("Raphael", "Star Wars");
        m2.put("Olivia", "james bond");

        Map<String, String> everyone = new HashMap<>(m1);
        everyone.putAll(m2);
        System.out.println(everyone);//{Olivia=james bond, Raphael=Star Wars, Olivia2=james bond2}

        Map<String, String> everyone2 = new HashMap<>(m1);

        m2.forEach((k,v)->everyone2.merge(k,v,(k1,k2)->k1+"&"+k2));//{Olivia=james bon2d&james bond, Raphael=Star Wars&Star Wars, Olivia2=james bond2}
        m2.forEach((k,v)->everyone2.merge(k,v,(k1,k2)->k1==k2?k1:k1+"&"+k2));//{Olivia=james bon2d&james bond, Raphael=Star Wars, Olivia2=james bond2}
        System.out.println(everyone2);


    }

    @Test
    public void test05(){

        // System.out.println(System.currentTimeMillis());

        String value = "select " +
                "a.event_name eventName, " +
                "GROUP_CONCAT(distinct property_name ) VALUE " +
                "from (   " +
                "  select a.project_id,b.event_name,a.property_name " +
                "  from   (" +
                "    select project_id,name as property_name from event_property_track where project_id = ?1 and common = '1') as a   " +
                "  join   (" +
                "    select distinct project_id,name as event_name from event_track where project_id = ?1 and status = '1' and preset = 0 ) as b   " +
                "  on a.project_id = b.project_id   " +
                "  union all   " +
                "  select project_id,event_name,property_name from event_property_map_track where project_id = ?1 " +
                ") as a " +
                "where a.event_name in (?2) " +
                "group by  a.event_name ";
        System.out.println(value);

        String a =  "select a.title,a.remark,a.check_value checkValue, " +
                "a.id, a.project_id projectId, a.type, a.add_time addTime, a.add_user addUser, a.check_dimension checkDimension, a.status, a.event_count eventCount, a.finish_event_count finishEventCount, " +
                "count(distinct if(b.event_check_result!='success' and cast(b.vacancy as double) * 100 > a.threshold ,b.event_name,null)) as valueCount, " +
                "count(distinct if(b.all_counts != 0,b.event_name,null)) as haveDataCount " +
                "from " +
                "(select * from data_track_check where project_id = ?1 and type = 'event' and IF(?2 != -999,id = ?2, 1=1)) as a " +
                "left join " +
                "data_track_check_result as b " +
                "on a.id = b.`check_id`  " +
                "group by  a.id, a.project_id, a.type, a.add_time, a.add_user, a.check_dimension, a.status, a.event_count, a.finish_event_count  " +
                "" +
                "union all  " +
                "" +
                "select  a.title,a.remark,a.check_value checkValue, a.id, a.project_id projectId, a.type, a.add_time addTime, a.add_user addUser, a.check_dimension checkDimension, a.status, a.event_count eventCount, a.finish_event_count finishEventCount, " +
                "count(distinct if(b.event_check_result!='success' and cast(b.vacancy as double) * 100 > a.threshold ,b.property_name,null)) as valueCount, " +
                "count(distinct if(b.all_counts != 0,b.all_counts,null)) as haveDataCount " +
                "from  " +
                "(select * from data_track_check where project_id = ?1 and type != 'event' and IF(?2 != -999,id = ?2, 1=1)) as a " +
                "left join data_track_check_result as b " +
                "on a.id = b.`check_id`  " +
                "group by  a.id, a.project_id, a.type, a.add_time, a.add_user, a.check_dimension, a.status, a.event_count, a.finish_event_count ";
        System.out.println(a);

    }


    @Test
    public void test06(){
        HashSet<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        HashSet<String> set2 = new HashSet<>();
        set2.add("2");
        set2.add("3");
        set2.add("4");

        HashSet<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set);

        System.out.println("-----");

        set1.remove("2");
        set2.remove("2");

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set);

        System.out.println("--------");

        String s = "BILOG_EVENT_MAIN_LOADING".toLowerCase(Locale.ROOT);
        System.out.println(s);

    }


    @Test
    public void test07(){
        try {
            // 可能会抛出异常的代码
            throw new MyCustomException("Something went wrong");
        } catch (MyCustomException ex) {
            // 捕获异常并进行处理
            System.out.println("Caught exception: " + ex.getMessage());
        }

        // 在捕获异常后继续执行其他代码
        System.out.println("Method execution continues...");
    }

    @Test
    public void test08(){
        String jsonStr = "{\"name\":\"John\",\"City\":\"New York\",\"age\":25}";

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String cityName = jsonObject.getString("city");

        System.out.println("City: " + cityName);
        System.out.println(Objects.equals("c", "C"));
    }

}
