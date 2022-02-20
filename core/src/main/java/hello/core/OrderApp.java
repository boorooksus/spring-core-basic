package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    // psvm 으로 자동 생성
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

//        MemberService memberService = new MemberServiceImpl();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = new OrderServiceImpl();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",
                OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        
        
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        
        // toSring 만들었으므로 값들 출력해줌
        System.out.println("order = " + order);
    }
}
