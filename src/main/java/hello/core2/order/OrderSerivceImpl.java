package hello.core2.order;

import hello.core2.discount.DisCountPolicy;
import hello.core2.discount.FixDiscountPolicy;
import hello.core2.member.Member;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;

public class OrderSerivceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
