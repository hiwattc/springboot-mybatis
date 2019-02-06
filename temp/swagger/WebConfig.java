package com.staroot.mybatis.config.swagger;

//이 WebConfig.java 클래스는없어도 문제없음 
///@Configuration
////@EnableWebMvc  --> 이거 주석처리 안하면 로그인화면이 깨지는 현상 발생함 
//@EnableAspectJAutoProxy
//@ComponentScan("com.staroot")
//public class WebConfig extends WebMvcConfigurerAdapter {
	public class WebConfig{
  //---중략---/
  //static 리소스 처리
		/*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/WEB-INF/resources/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
                */
}	