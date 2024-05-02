package firstmarket.koreashop.controller;

import firstmarket.koreashop.dto.MemberServiceRequest;
import firstmarket.koreashop.member.Member;
import firstmarket.koreashop.member.MemberRepo;
import firstmarket.koreashop.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    @Autowired
    MemberService memberService;

    /**
     * 멤버 저장 기능
     * 들어온 멤버 정보를 저장한다. 반환은 하지 않는다.
     * 추후 클라이언트에서 저장여부 확인을 위해 return 추가할 수 있음
     * 추가하지 못했을 때 문제를 return
     */
    @GetMapping("/member")
    public void saveMember(@RequestBody Member member){
        memberService.join(member);
    }


}
