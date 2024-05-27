package firstmarket.koreashop.member;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class MemberCreateRequest {

    private String memberId;

    private String memberPw;

    private String memberName;

    private String phoneNumber;

    public MemberCreateRequest(String memberId, String memberPw, String memberName, String phoneNumber) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }
}
