package hello.core2.discount;

import hello.core2.member.Member;

public interface DisCountPolicy {

    /**
     * @return 할인대상 금액
     */
    int discount(Member member,int price);
}
