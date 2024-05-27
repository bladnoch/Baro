package firstmarket.koreashop.dto.member;

import lombok.Getter;

@Getter
public class MemberCreateRequest {

    public MemberCreateRequest(String memberId, String memberPw, String memberName, String phoneNumber) {
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
