package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
//        MemberService memberService = appConfig.memberService();

        // 인자로 AppConfig.class 넣어주면,
        // 스프링이 AppConfig에 작성한 Bean들을 객체들에 넣어줌
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);

        // getBean에서 사용할 메서드 이름 넣어줘서 객체 얻기
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);


        //'new Member(1L, "memberA", Grade.VIP);' 먼저 작성하고,
        // ctrl + alt + v 누르면 자동 생성
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
