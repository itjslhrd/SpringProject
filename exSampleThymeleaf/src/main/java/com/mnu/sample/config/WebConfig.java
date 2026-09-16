package com.mnu.sample.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//파일 업로드 구현시 파일 저장경로 설정
public class WebConfig implements WebMvcConfigurer {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 웹에서 /images/** 로 접근하면, 실제로는 C:/myapp/uploads/ 경로를 탐색합니다.
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///C:/Users/websnet/uploads/");
    
/*	   맥/Linux 계열
        registry.addResourceHandler("/images/**")
        // file:// 뒤에 맥의 절대 경로인 /Users/websnet/uploads/ 를 붙여줍니다. (슬래시 총 3개)
        .addResourceLocations("file:///Users/websnet/uploads/");
*/        
	}
}
