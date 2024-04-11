package firstmarket.koreashop.profile;

import firstmarket.koreashop.member.MemberRepo;
import firstmarket.koreashop.member.MemberService;
import firstmarket.koreashop.upload.UploadService;
import org.springframework.stereotype.Component;

@Component
public class PersonalInfoImpl {

    private final UploadService uploadService;
    private final MemberService memberService;

    public PersonalInfoImpl(MemberService memberService, UploadService uploadService) {
        this.memberService = memberService;
        this.uploadService = uploadService;
    }

    public String getMemberPhoneNumber() {
        return memberService.currentUser()[3];
    }

    public String getMemberId() {
        return memberService.currentUser()[0];
    }

    public String[] MemberUploadedItem() {
        return null;
    }

    public String[] MemberReservedItem() {
        return null;
    }

    public String[] likedItem() {
        return null;
    }

    public void deleteMember() {
        memberService.currentUser();
    }
}
