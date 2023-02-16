package inflearn.basic;

import inflearn.basic.discount.DiscountPolicy;
import inflearn.basic.discount.FixDiscountPolicy;
import inflearn.basic.discount.RateDiscountPolicy;
import inflearn.basic.member.MemberRepository;
import inflearn.basic.member.MemberService;
import inflearn.basic.member.MemberServiceImpl;
import inflearn.basic.member.MemoryMemberRepository;
import inflearn.basic.order.OrderService;
import inflearn.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
