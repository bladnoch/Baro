package firstmarket.koreashop.service.member;

import firstmarket.koreashop.dto.member.ChangePasswordRequest;
import firstmarket.koreashop.dto.member.MemberCreateRequest;


public interface MemberService {

    void join(MemberCreateRequest request); //post

    String findMemberIdByPhoneNumber(String phoneNumber); //get

    void changePwByPhoneNumber(ChangePasswordRequest request);

}
