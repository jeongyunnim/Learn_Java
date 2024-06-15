package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/*
    서비스의 역할
    - 엔티티 조회, 연결, 호출
    엔티티에 핵심 비즈니스 로직을 때려넣는 패턴 == 도메인 모델 패턴
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문
    @Transactional(readOnly = false)
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member member = memberRepository.findById(memberId);
        Item item = itemRepository.findById(itemId);

        // 배송 정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        /**
         * Order에 CascadeType.ALL 옵션을 넣어주었기 때문에 order만 save 해주어도 된다.
         * 여기서 em.persist(order)이 호출될 때 delivery와 orderItem도 자동으로 em.persist()를 호출해준 효과가 난다.
         *
         * Cascade를 사용하는 기준
         * 1. private owner: 해당 객체에서만 호출하는 객체들인 경우 사용해도 된다.
         * 2. Life Cycle: 해당 객체와 생명 주기가 같은가?
         * -> 이 개념이 이해가 안 된다면 각각 repostiroy를 개발하여 각각 persist를 해주는 것이 낫다. 감을 잡은 뒤 리팩토링 하라.
         */
        orderRepository.save(order);
        return order.getId();
    }

    //취소
    /**
     * 주문 취소
     */
    @Transactional
    public void cancel(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();
    }

    //검색
    /**
     * 주문 검색
     */

/*
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
*/

}
