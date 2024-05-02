package firstmarket.koreashop.dto;


import firstmarket.koreashop.member.Member;
import firstmarket.koreashop.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class MemberServiceRequest {

    private final String phoneNumber;

    public MemberServiceRequest(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
