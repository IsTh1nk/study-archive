package TunaF.toyPjt_Login.service;

import TunaF.toyPjt_Login.domain.Member;
import TunaF.toyPjt_Login.repository.MemberRepository;
import TunaF.toyPjt_Login.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public Member join(Member member){
        validateDuplicateMember(member);
        validateVerifyMemberPw(member);
        memberRepository.save(member);
        return member;
    }

    private void validateVerifyMemberPw(Member member) {
        Pattern pattern = Pattern.compile("((?=.*[a-zA-Z])(?=.*[0-9@#$%]).{8,})");
        Matcher matcher = pattern.matcher(member.getPw());
        if(!matcher.matches()){
            throw new IllegalStateException("패스워드 8자이상.");
        }
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findById(member.getId());
        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId){
        return memberRepository.findById(memberId);
    }

}
