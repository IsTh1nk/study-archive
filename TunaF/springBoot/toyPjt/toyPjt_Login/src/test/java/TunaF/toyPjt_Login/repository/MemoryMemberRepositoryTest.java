package TunaF.toyPjt_Login.repository;

import TunaF.toyPjt_Login.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("전승훈");
        member.setId("tmdgns0903");
        member.setPw("wjdqoiwdjiq12222223");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("전승훈");
        member1.setId("tmdgns0903");
        member1.setPw("wjdqoiwdjiq12222223");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("조윤성");
        member2.setId("wghdsbtj123");
        member2.setPw("whdbsdwlw123424");
        repository.save(member2);

        Member result = repository.findById(member2.getId()).get();
        Assertions.assertEquals(member2,result);
    }

    @Test
    public void findByPw(){
        Member member1 = new Member();
        member1.setName("전승훈");
        member1.setId("tmdgns0903");
        member1.setPw("wjdqoiwdjiq12222223");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("조윤성");
        member2.setId("wghdsbtj123");
        member2.setPw("whdbsdwlw123424");
        repository.save(member2);

        Member result = repository.findByPw(member2.getPw()).get();
        Assertions.assertEquals(member2,result);
    }
}
