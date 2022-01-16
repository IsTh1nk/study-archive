package TunaF.toyPjt_Login.service;

import TunaF.toyPjt_Login.domain.Member;
import TunaF.toyPjt_Login.repository.MemberRepository;
import TunaF.toyPjt_Login.repository.MemoryMemberRepository;
import TunaF.toyPjt_Login.repository.MemoryMemberRepositoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //give - 무언가를 주어졌을 때
        Member member = new Member();

        member.setName("전승훈");
        member.setId("tmdgns0903");
        member.setPw("tmdgns0903093093");

        //when - 이것을 실행했을 때
        Member saveId = memberService.join(member);

        //then - 결과는 이렇게 나와야한다.
        Member findmember = memberService.findOne(saveId.getId()).get();
        assertThat(member.getName()).isEqualTo(findmember.getName());
    }

    @Test
    public void 중복회원예외(){
        Member member1 = new Member();
        member1.setName("전승훈");
        member1.setId("tmdgns0903");
        member1.setPw("wjdqoiwdjiq12222223");


        Member member2 = new Member();
        member2.setName("조윤성");
        member2.setId("tmdgns090233");
        member2.setPw("whdbsdwlw123424");


        try{
            memberService.join(member1);
            memberService.join(member2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("전승훈");
        member1.setId("tmdgns0903");
        member1.setPw("wjdqoiwdjiq12222223");

        Member member2 = new Member();
        member2.setName("조윤성");
        member2.setId("tmdgns090233");
        member2.setPw("whdbsdwlw123424");

        memberService.join(member1);
        memberService.join(member2);

        System.out.println(memberService.findMembers());
    }

    @Test
    void findOne() {
        Member member1 = new Member();
        member1.setName("전승훈");
        member1.setId("tmdgns0903");
        member1.setPw("wjdqoiwdjiq12222223");

        Member result = memberService.join(member1);
        System.out.println(result.getId());
        Assertions.assertEquals(member1,result);
    }
}