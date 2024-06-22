package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity // JPA가 JPA를 사용하는 객체라는 것을 인식한다.
public class Member {

    @Id
    private Long id;

    // 객체에서 사용할 이름과 DB에서 사용할 이름이 다를 떄 이름 지정
    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // DATE, TIME, DATETIME
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // varchar를 넘어서는 큰 데이터를 저장할 경우 Lob을 지정 -> clob으로 생성된다.
    @Lob
    private String description;

    public Member() {
    }

}

