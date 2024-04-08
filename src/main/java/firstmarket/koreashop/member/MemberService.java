package firstmarket.koreashop.member;

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
     * @param phoneNumber : saved phone number
     * @param newPw : new password that user is going to use
     */
    void changePwByPhoneNumber(String phoneNumber,String newPw); //patch

    /**
     * keep current user's information from member repo
     * @return Member : String list of member's elements
     */
    String[] currentUser(); //get
}
