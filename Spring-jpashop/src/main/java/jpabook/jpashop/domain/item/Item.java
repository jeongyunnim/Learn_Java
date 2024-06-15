package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.Exception.NotEnoughException;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> items = new ArrayList<>();

    //==비즈니스 로직==//
    // 도메인 주도 설계를 할 때 엔티티 안에서 비즈니스 로직을 해결할 수 있는 것이 좋다.

    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0){
            throw new NotEnoughException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
