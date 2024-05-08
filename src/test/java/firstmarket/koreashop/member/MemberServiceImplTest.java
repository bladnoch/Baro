package firstmarket.koreashop.member;

import firstmarket.koreashop.dto.ChangePasswordRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class MemberServiceImplTest {

    @Test
    void testJoin() {
        MemberRepo tempMemberRepo=new MemberRepoTemp();
        MemberService memberService = new MemberServiceImpl(tempMemberRepo);
        Member tempMember = new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
        Member member1 = new Member("test1", "F!ehddnr0516", "Daniel Kim", "2222");

        memberService.join(tempMember);
        memberService.join(member1);

        Assertions.assertThat(memberService.findMemberIdByPhoneNumber("2222")).isEqualTo("test1");

    }

    @Test
    void testFindByPhoneNumber() {
        MemberRepo tempMemberRepo=new MemberRepoTemp();
        MemberService memberService = new MemberServiceImpl(tempMemberRepo);

        Member member = new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
        Member member1 = new Member("test1", "F!ehddnr0516", "Daniel Kim", "2222");

        memberService.join(member);
        memberService.join(member1);

        Assertions.assertThat(memberService.findMemberIdByPhoneNumber("0102464318")).isEqualTo("yujung0516");
    }


    @Test
    void testChangePwByPhoneNumber() {
        MemberRepo tempMemberRepo=new MemberRepoTemp();
        MemberService memberService = new MemberServiceImpl(tempMemberRepo);

        Member member = new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
        memberService.join(member);

        memberService.changePwByPhoneNumber(new ChangePasswordRequest("0102464318","1234yujung"));

        Assertions.assertThat(tempMemberRepo.findPwByPhoneNumber("0102464318")).isEqualTo("1234yujung");
    }



}