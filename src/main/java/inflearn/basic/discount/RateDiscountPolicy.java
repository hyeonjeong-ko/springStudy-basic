package inflearn.basic.discount;

import inflearn.basic.member.Grade;
import inflearn.basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) { // ctrl+shift+t
        if(member.getGrade()== Grade.VIP){
            return price * discountPercent/100;
        } else {
            return 0;
        }
    }
}
