package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
//    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given: 이런 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when: 이렇게 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then: 어떻게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
