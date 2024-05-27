package firstmarket.koreashop.member;

import firstmarket.koreashop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo {
    /**
     * get member's param and create new Member info
     * @param member : String memberId, String memberPw, String memberName, String phoneNumber
     */
    void save(Member member);
    String findMemberId(String phoneNumber);
    void printStoratge();
    void changePw(String phoneNumber, String newPw);
    String findPwByPhoneNumber(String phoneNumber);
    String[] getCurrentUserInfo();

//    public String findPwByPhoneNumber(String phoneNumber);

}
