package org.inject.api.constants;

import org.inject.api.config.ApiConfig;

public class PathsConstants {

    public static final String BASE_URL = ApiConfig.config().getBaseUrl();

    public static class USER{
        public static final String CREATE = "/user";
        public static final String LOGIN = "/user/login";
        public static final String GET_USER = "/user/{username}";
    }
}
