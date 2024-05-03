package firstmarket.koreashop.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    public Member(String memberId, String memberPw, String memberName, String phoneNumber) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }

    private String memberId;
    private String memberPw;
    private String memberName;
    private String phoneNumber;
}


