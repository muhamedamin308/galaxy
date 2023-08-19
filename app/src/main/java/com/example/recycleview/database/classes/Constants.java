package com.example.recycleview.database.classes;

import com.example.recycleview.R;

public class Constants {
    public static class Record {
        public static final int TITLE_IN_RECORD = 1;
        public static final int DESC1_IN_RECORD = 2;
        public static final int DESC2_IN_RECORD = 3;
    }
    public static class Details {
        public static final String DETAILS_ID = "ID";
        public static final String DETAILS_PLANET_NAME = "NAME";
        public static final String DETAILS_DESC_1 = "DESC 1";
        public static final String DETAILS_DESC_2 = "DESC 2";
        public static final String DETAILS_PLANET_IMAGE = "IMAGE";
        public static final String DETAILS_PLANET_RADIUS = "RADIUS";
        public static final String DETAILS_PLANET_LENGTH = "LENGTH";
        public static final String DETAILS_PLANET_TYPE = "TYPE";
        public static final String DETAILS_PLANET_COLOR = "COLOR";
    }
    public static class Extras {
        public static final String EXTRA_ID = "PLANET ID";
        public static final String EXTRA_PLANET_NAME = "PLANET NAME";
        public static final String EXTRA_DESC_1 = "PLANET DESC 1";
        public static final String EXTRA_DESC_2 = "PLANET DESC 2";
        public static final String EXTRA_PLANET_IMAGE = "PLANET IMAGE";
        public static final String EXTRA_PLANET_RADIUS = "PLANET RADIUS";
        public static final String EXTRA_PLANET_LENGTH = "PLANET LENGTH";
        public static final String EXTRA_PLANET_TYPE = "PLANET TYPE";
        public static final String EXTRA_PLANET_COLOR = "PLANET COLOR";
    }
    public static class Select {
        public static final String SELECT_IMAGE_ID = "IMAGE ID";
        public static final String SELECT_IMAGE_COLOR = "IMAGE COLOR";
        public static final String IMAGE_ID = "1";
        public static int SELECTED_IMAGE = R.drawable.unknown;
        public static int SELECTED_COLOR = R.color.unKnown;
    }
    public static String RADIUS(int radius) {
        return ("" + radius + " in KM");
    }
    public static String LENGTH(int length) {
        return ("" + length + " Earth days");
    }
}
