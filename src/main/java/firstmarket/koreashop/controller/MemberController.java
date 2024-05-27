package firstmarket.koreashop.controller;

import firstmarket.koreashop.dto.ChangePasswordRequest;

import firstmarket.koreashop.dto.MemberCreateRequest;
import firstmarket.koreashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void saveMember(@RequestBody MemberCreateRequest request){
        memberService.join(request);
    }

    @GetMapping("/member/getId")
    public String findMemberIdByPhoneNumber(@RequestParam String phoneNumber) {
        return memberService.findMemberIdByPhoneNumber(phoneNumber);
    }

    @PostMapping("/member/changePw")
    public void changePwByPhoneNumber(@RequestBody ChangePasswordRequest request) {
        memberService.changePwByPhoneNumber(request);
    }
}
