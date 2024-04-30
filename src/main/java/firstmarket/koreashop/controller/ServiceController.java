package firstmarket.koreashop.controller;

import firstmarket.koreashop.dto.MemberServiceRequest;
import firstmarket.koreashop.member.Member;
import firstmarket.koreashop.member.MemberService;
import firstmarket.koreashop.member.MemberServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    /**
     * find account Id by saved phone number
     * @param phoneNumber : String phoneNumber
     * @return get String MemberId
     */
//    String findMemberIdByPhoneNumber(String phoneNumber); //get
    @GetMapping("/findId")
    public String getMemberIdByPhoneNumber(MemberServiceRequest phoneNumber){
        return phoneNumber.getMemberId();
    }
}
