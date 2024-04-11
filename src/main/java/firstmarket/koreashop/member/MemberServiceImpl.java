package firstmarket.koreashop.member;


import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepo memberRepo;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void join(Member member) {
        memberRepo.save(member);
    }

    public String findMemberIdByPhoneNumber(String phoneNumber){
        return memberRepo.findMemberId(phoneNumber);
    }

    public void changePwByPhoneNumber(String phoneNumber, String newPw) {
        memberRepo.changePw(phoneNumber,newPw);
    }

    public String[] currentUser() {
        return memberRepo.getCurrentUserInfo();
    }


//    public void findMemberIdByPhoneNumber() {
//    }

}
