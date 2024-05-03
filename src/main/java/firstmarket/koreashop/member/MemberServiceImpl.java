package firstmarket.koreashop.member;


import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepo memberRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void join(Member member) {
        String sql = "INSERT INTO memberRepo (memberId, memberPw, memberName, phoneNumber) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, member.getMemberId(), member.getMemberPw(), member.getMemberName(), member.getPhoneNumber());
    }

    public String findMemberIdByPhoneNumber(String phoneNumber){
        String sql = "SELECT memberId FROM memberRepo WHERE phoneNumber = ?";
        // ? 에 들어가는 값을 찾아 매핑한다.
        return jdbcTemplate.queryForObject(sql, new Object[]{phoneNumber}, String.class);
    }

    public void changePwByPhoneNumber(String phoneNumber, String newPw) {
        String sql = "INSERT INTO memberPw From MemberRepo WHERE phoneNumber = ?";
        jdbcTemplate.update(sql, newPw);

//        memberRepo.changePw(phoneNumber,newPw);
    }

    public String[] currentUser() {
        return memberRepo.getCurrentUserInfo();
    }


//    public void findMemberIdByPhoneNumber() {
//    }

}
