package com.ro.web.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class AppConfig extends ResourceConfig {

    public AppConfig(){
        packages("com.ro.web.controller");

        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH,"/WEB-INF/views");
    }

}
