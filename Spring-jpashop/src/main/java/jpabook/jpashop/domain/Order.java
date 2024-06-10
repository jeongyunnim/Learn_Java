package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    /**
     * 양방향 연관관계(양방향 참조)에서 중요한 것
     * Order에서 값을 변경할 수도 있고 Member에서 값을 변경할 수도 있다.
     * 주인을 정해주어야 한다.
     * 어떤 값이 바뀌었을 때 foreign 키를 바꿔줄 것인지
     * foreign key가 있는 곳을 주인으로 선정하라(一대多 관계에서 '多'를 주인으로 선정)
     * */
    @ManyToOne(fetch = FetchType.LAZY) // XToOne의 default는 EAGER이기 때문에 LAZY로 바꾸어서 지연 로딩으로 변환해야 한다.
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    /**
     * 1대1 관계인 경우 엑세스가 많은 쪽으로 주인을 선정하자.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    /**
     * private Date date를 사용하게 되면 날짜 관련 애노테이션들을 매핑해야 한다.
     * LocalDateTime은 자바 8부터 지원하는 기능으로 hibernate가 자동으로 매핑을 지원해준다.
     */
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // [ORDER, CANCEL]

    // 연관관계 편의 메서드

    /**
     * 양방향 연관관계가 있을 때 연결해주는 메서드
     * 양쪽을 각각 세팅을 해야 할 것을 하나의 코드로 해결할 수 있다.
     */
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public static void main(String[] args) {
        Member member = new Member();
        Order order = new Order();

        order.setMember(member);
    }
}
