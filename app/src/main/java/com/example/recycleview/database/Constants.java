package com.example.recycleview.database;

public class Constants {
    public static final int TITLE_IN_RECORD = 1;
    public static final int DESC1_IN_RECORD = 2;
    public static final int DESC2_IN_RECORD = 3;
    public static final String EXTRA_ID = "PLANET ID";
    public static final String EXTRA_PLANET_NAME = "PLANET NAME";
    public static final String EXTRA_DESC_1 = "PLANET DESC 1";
    public static final String EXTRA_DESC_2 = "PLANET DESC 2";
    public static final String EXTRA_PLANET_IMAGE = "PLANET IMAGE";
    public static final String EXTRA_PLANET_RADIUS = "PLANET RADIUS";
    public static final String EXTRA_PLANET_LENGTH = "PLANET LENGTH";
    public static final String EXTRA_PLANET_TYPE = "PLANET TYPE";
    public static final String DETAILS_ID = "ID";
    public static final String DETAILS_PLANET_NAME = "NAME";
    public static final String DETAILS_DESC_1 = "DESC 1";
    public static final String DETAILS_DESC_2 = "DESC 2";
    public static final String DETAILS_PLANET_IMAGE = "IMAGE";
    public static final String DETAILS_PLANET_RADIUS = "RADIUS";
    public static final String DETAILS_PLANET_LENGTH = "LENGTH";
    public static final String DETAILS_PLANET_TYPE = "TYPE";

    public static String RADIUS(int radius) {
        return ("" + radius + " in KM");
    }

    public static String LENGTH(int length) {
        return ("" + length + " Earth days");
    }
}
