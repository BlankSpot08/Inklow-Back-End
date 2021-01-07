package com.example.inklow.controller.URL;

public class URL {
    private static final String API = "/api";

    // USER END POINTS
    public static final class USER {
        private static final String USER = API + "/user";

        public static final String GET_USER = USER + "/get";
        public static final String GET_USER_PERMISSION = "CAN_VIEW_USER_PROFILE";

        public static final String GET_ALL_USER = USER + "/getAll";
        public static final String GET_ALL_USER_PERMISSION = "CAN_VIEW_ALL_USER_PROFILE";

        public static final String UPDATE_USER = USER + "/update";
        public static final String UPDATE_USER_PERMISSION = "CAN_UPDATE_USER_PROFILE";

        public static final String DELETE_USER = USER + "/delete";
        public static final String DELETE_USER_PERMISSION = "CAN_DELETE_USER_PROFILE";
    }

    // ROLE END POINTS
    private static final String ROLE = API + "/role";

    public static final String ADD_ROLE = "/add";
    public static final String ADD_ROLE_PERMISSION = "CAN_CREATE_ROLE";

    public static final String GET_ROLE = "/get";
    public static final String GET_ROLE_PERMISSION = "CAN_VIEW_ROLE";

    public static final String GET_ALL_ROLE = "/getAll";
    public static final String GET_ALL_ROLE_PERMISSION = "CAN_VIEW_ALL_ROLE";

    public static final String UPDATE_ROLE = "/update";
    public static final String UPDATE_ROLE_PERMISSION = "CAN_UPDATE_ROLE";

    public static final String DELETE_ROLE = "/delete";
    public static final String DELETE_ROLE_PERMISSION = "CAN_DELETE_ROLE";

    //PERMISSION END POINTS

    public static final String GET_PERMISSION = "/get";
    public static final String GET_PERMISSION_PERMISSION = "CAN_PERMISSiON_ROLE";

    public static final String GET_ALL_PERMISSION = "/getAll";
    public static final String GET_ALL_PERMISSION_PERMISSION = "CAN_VIEW_ALL_PERMISSION";
}
