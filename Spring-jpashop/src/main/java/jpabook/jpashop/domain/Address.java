package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // JPA 구현 라이브러리가 객체를 생성할 때 리플랙션 같은 기술을 사용할 수 있도록 기본 생성자를 제공해야 한다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipdcode;

    protected Address() {}

    public Address(String city, String street, String zipdcode) {
        this.city = city;
        this.street = street;
        this.zipdcode = zipdcode;
    }

}
