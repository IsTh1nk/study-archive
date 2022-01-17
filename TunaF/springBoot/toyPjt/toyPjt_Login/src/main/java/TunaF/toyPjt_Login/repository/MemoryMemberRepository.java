package TunaF.toyPjt_Login.repository;

import TunaF.toyPjt_Login.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Map.Entry;


public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<Long, Member>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setSeq(++sequence);
        store.put(member.getSeq(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional<Member> findByPw(String pw) {
        return store.values().stream()
                .filter(member -> member.getPw().equals(pw))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
