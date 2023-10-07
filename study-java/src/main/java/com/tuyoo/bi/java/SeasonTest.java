package com.tuyoo.bi.java;

/**
 * @Author zhangpengfei
 * @Date 2023-09-05 23:04
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.spring);
        String seasonDesc = Season.spring.getSeasonDesc();
        System.out.println(seasonDesc);
    }

}

class Season{

    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public static final Season spring = new Season("1","11");
    public static final Season summer = new Season("2", "22");
}