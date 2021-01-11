package com.example.inklow.controller.URL;

public final class URL {
    private static final String API = "/api";

    // USER END POINTS

    // ROLE END POINTS

    //PERMISSION END POINTS

    // ROLE PERMISSION END POINTS
    public static final class ROLE_PERMISSION {
        private static final String ROLE_PERMISSION = API + "/role_permission";

        public static final String ADD = ROLE_PERMISSION + "/add";
        public static final String ADD_PERMISSION = "CAN_CREATE_ROLE_PERMISSION";

        public static final String GET = ROLE_PERMISSION + "/get";
        public static final String GET_PERMISSION = "CAN_VIEW_ROLE_PERMISSION";

        public static final String GET_ALL = ROLE_PERMISSION + "/getAll";
        public static final String GET_ALL_PERMISSION = "CAN_VIEW_ALL_ROLE_PERMISSION";

        public static final String UPDATE = ROLE_PERMISSION + "/update";
        public static final String UPDATE_PERMISSION = "CAN_UPDATE_ROLE_PERMISSION";

        public static final String DELETE = ROLE_PERMISSION + "/delete";
        public static final String DELETE_PERMISSION = "CAN_DELETE_ROLE_PERMISSION";
    }


}
