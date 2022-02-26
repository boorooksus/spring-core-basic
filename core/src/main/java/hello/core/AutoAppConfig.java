package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 자동 등록하지 않을 것 설정
        // 여기에서는 AppConfig 코드와 충돌 방지를 위해 Configuration.class는 제외
        // (컴포넌트 스캔은 @Configuration 붙은 설정 정보도 자동으로 등록해줌)
        // 실무에서는 이 설정 할 필요는 없음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
