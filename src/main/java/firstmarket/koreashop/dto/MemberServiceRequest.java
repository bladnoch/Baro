package firstmarket.koreashop.dto;

import firstmarket.koreashop.member.Member;
import firstmarket.koreashop.member.MemberService;

public class MemberServiceRequest {
    private final String phoneNumber;

    public MemberServiceRequest(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getMemberId() {
        if(phoneNumber.equals("01046054434")){
            return "dong5478";
        }
        else
            return "not a member";

    }

}
