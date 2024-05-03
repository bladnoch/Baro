package firstmarket.koreashop.controller;

import firstmarket.koreashop.dto.CurrentUserResponse;
import firstmarket.koreashop.member.Member;
import firstmarket.koreashop.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 멤버 저장 기능
     * 들어온 멤버 정보를 저장한다. 반환은 하지 않는다.
     * 추후 클라이언트에서 저장여부 확인을 위해 return 추가할 수 있음
     * 추가하지 못했을 때 문제를 return
     */

    @GetMapping("/member")
    public void saveMember(@RequestBody Member member){
        String sql = "INSERT INTO memberRepo (memberId, memberPw, memberName, phoneNumber) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, member.getMemberId(), member.getMemberPw(), member.getMemberName(), member.getPhoneNumber());

//        memberService.join(member);
    }

    //    String findMemberIdByPhoneNumber(String phoneNumber);
    @GetMapping("/member/getId")
    public String findMemberIdByPhoneNumber(@RequestParam String phoneNumber) {
        String sql = "SELECT memberId from memberRepo WHERE phoneNumber = ('phoneNumber') VALUES (?)";

        return memberService.findMemberIdByPhoneNumber(phoneNumber);
    }

    /**
     * change password by phone number
     * @param phoneNumber : saved phone number
     * @param newPw : new password that user is going to use
     */
    //아직 테스트 못해봄
    @GetMapping("/member/changePw")
    public void changePwByPhoneNumber(@RequestParam String phoneNumber, @RequestParam String newPw) {
        memberService.changePwByPhoneNumber(phoneNumber,newPw);
    }


    /**
     * keep current user's information from member repo
     * @return Member : String list of member's elements
     */
//    String[] currentUser(); //get
    @GetMapping("/member/currentUser")
    public CurrentUserResponse getCurrentUser(){
        memberService.currentUser();
        return new CurrentUserResponse( memberService.currentUser());
    }


}
