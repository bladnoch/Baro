package firstmarket.koreashop.member;

import firstmarket.koreashop.dto.ChangePasswordRequest;
import lombok.ToString;


public interface MemberService {
    /**
     * get member's param and create new Member info
     * @param member : String memberId, String memberPw, String memberName, String phoneNumber
     */
    void join(Member member); //put

    /**
     * find account Id by saved phone number
     * @param phoneNumber : String phoneNumber
     * @return get String MemberId
     */
    String findMemberIdByPhoneNumber(String phoneNumber); //get

    /**
     * change password by phone number
     * ChangePasswordRequest 변수들
     * phoneNumber : saved phone number
     * newPw : new password that user is going to use
     */
    void changePwByPhoneNumber(ChangePasswordRequest request);

    /**
     * keep current user's information from member repo
     * @return Member : String list of member's elements
     */
    Member currentUser(String ); //get
}
