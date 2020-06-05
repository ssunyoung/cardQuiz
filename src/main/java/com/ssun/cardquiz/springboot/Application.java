//이 파일은 항상 프로젝트 최상단에 위치
package com.ssun.cardquiz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA auditing 활성화
@SpringBootApplication //SpringBoot 자동설정, 스프링 Bean 읽기와 생성 다 자동 설정
public class Application {
    public static void main(String[] args) {

        // 내장 WAS(tomcat)를 실행한다.
        SpringApplication.run(Application.class, args);

    }
}
