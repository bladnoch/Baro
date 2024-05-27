package firstmarket.koreashop.service;

import firstmarket.koreashop.dto.ChangePasswordRequest;
import firstmarket.koreashop.dto.MemberCreateRequest;


public interface MemberService {

    void join(MemberCreateRequest request); //post

    String findMemberIdByPhoneNumber(String phoneNumber); //get

    void changePwByPhoneNumber(ChangePasswordRequest request);

}
