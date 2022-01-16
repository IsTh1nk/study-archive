package TunaF.toyPjt_Login.Controller;

import TunaF.toyPjt_Login.domain.Member;
import TunaF.toyPjt_Login.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.script.ScriptContext;
import javax.swing.text.html.Option;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setId(form.getId());
        member.setPw(form.getPw());

        memberService.join(member);

        return "redirect:/";
    }

    @PostMapping("/")
    public String login(loginForm form, Model model){
        Optional<Member> result = memberService.findOne(form.getId());
        if(result.isPresent()){
            model.addAttribute("member", result.get());
            return "welcome/main";
        }else{
            return "/home";
        }
    }
}
