package firstmarket.koreashop.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

// 기능하는지만
class MemberRepoTempTest {

    @Test
    void testSave() {
        MemberRepoTemp memberRepoTemp = new MemberRepoTemp();

        Member member = new Member("dong5478", "ehddnr0516", "Dounguk Kim", "01046054434");
        Member member1 = new Member("dk0520", "F!ehddnr0516", "Daniel Kim", "4256238218");
        Member member3 = new Member("dounguk5478", "N!ehddnr0516", "Dounguk", "2021270682");
        Member member2 = new Member("dongwook5478", "G!ehddnr0516", "Dongwook Kim", "123445678");

        memberRepoTemp.save(member);
        memberRepoTemp.save(member1);
        memberRepoTemp.save(member2);
        memberRepoTemp.save(member3);
    }



    @Test
    void testFindMemberId_o() {
        MemberRepoTemp memberRepoTemp= new MemberRepoTemp();

        Member member1 = new Member("test1", "F!ehddnr0516", "Daniel Kim", "2222");
        Member member = new Member("test2", "ehddnr0516", "Dounguk Kim", "1111");

        memberRepoTemp.save(member);
        memberRepoTemp.save(member1);

        System.out.println(memberRepoTemp.findMemberId("01046054434")); //필요없음
        assertThat(memberRepoTemp.findMemberId("1111")).isEqualTo("test2");

        memberRepoTemp.printStoratge(); //필요없음
    }

    @Test
    void testFindMemberId_x() {
        MemberRepoTemp memberRepoTemp= new MemberRepoTemp();

        Member member1 = new Member("test1", "F!ehddnr0516", "Daniel Kim", "2222");
        Member member = new Member("test2", "ehddnr0516", "Dounguk Kim", "1111");

        memberRepoTemp.save(member);
        memberRepoTemp.save(member1);

        System.out.println(memberRepoTemp.findMemberId("01046054434")); //필요 없음
        assertThat(memberRepoTemp.findMemberId("1111")).isNotEqualTo("test1");
    }

    @Test
    void testChangePw() {
        MemberRepoTemp memberRepoTemp= new MemberRepoTemp();

        Member member = new Member("test2", "ehddnr0516", "Dounguk Kim", "1111");
        memberRepoTemp.save(member);

        memberRepoTemp.changePw("1111", "changed");

        memberRepoTemp.printStoratge();
        System.out.println("member.getMemberPw() = " + member.getMemberPw()); //필요없음


        Assertions.assertThat(memberRepoTemp.findPwByPhoneNumber("1111")).isEqualTo("changed");

    }






}


