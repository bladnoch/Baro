package firstmarket.koreashop.member;

import firstmarket.koreashop.domain.Member;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Getter
@Component
public class MemberRepoTemp implements MemberRepo {

    /*
     * 4개짜리 리스트가 들어가서 저장되는 배열
     * memberInfo[0] = member.getMemberId();
     * memberInfo[1]= member.getMemberPw();
     * memberInfo[2] = member.getMemberName();
     * memberInfo[3]= member.getPhoneNumber();
     * */

    private static final ArrayList<String[]> storage = new ArrayList<>();
    private static String[] currentUser = new String[4];

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void save(Member member) {
        String[] singleMember = new String[4];

        singleMember[0] = member.getMemberId();
        singleMember[1] = member.getMemberPw();
        singleMember[2] = member.getMemberName();
        singleMember[3] = member.getPhoneNumber();
        storage.add(singleMember);

        //save current log in user
        currentUser[0] = member.getMemberId();
        currentUser[1] = member.getMemberPw();
        currentUser[2] = member.getMemberName();
        currentUser[3] = member.getPhoneNumber();
        }

    @Override
    public String findMemberId(String phoneNumber){
        String sql = "SELECT memberId from memberRepo WHERE phoneNumber = ('phoneNumber') VALUES (?)";

        jdbcTemplate.update(sql, phoneNumber);


        return "없는 회원정보 입니다.";
    }

    @Override
    public void printStoratge(){
        for (int i=0;i<storage.size();i++) {
            System.out.println(("\nDB에 저장된 정보-------------" + (1 + i)));
            System.out.println("storage.get(" + i + ") = " + storage.get(i)[0]);
            System.out.println("storage.get(" + i + ") = " + storage.get(i)[1]);
            System.out.println("storage.get(" + i + ") = " + storage.get(i)[2]);
            System.out.println("storage.get(" + i + ") = " + storage.get(i)[3]);
            System.out.println("----------------------------\n");
        }
    }

    /*
    * 전화번호와 새로운 비밀번호를 받아서 수정
    * @param: phoneNumber
    * @param: newPw
    * */
    @Override
    public void changePw(String phoneNumber, String newPw) {

        String[] singleMember;
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i)[3].equals(phoneNumber)) {
                singleMember = storage.get(i);
                singleMember[1] = newPw;


                storage.set(i, singleMember);
                currentUser=singleMember;

            }
        }
    }

    @Override
    public String findPwByPhoneNumber(String phoneNumber){
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i)[3].equals(phoneNumber)) {
                return storage.get(i)[1];
            }
        }
        return "없는 회원정보 입니다.";
    }

    @Override
    public String[] getCurrentUserInfo(){
        return currentUser;
    }


}
