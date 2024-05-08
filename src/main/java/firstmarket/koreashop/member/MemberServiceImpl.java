package firstmarket.koreashop.member;


import firstmarket.koreashop.dto.ChangePasswordRequest;
import firstmarket.koreashop.dto.CurrentUserResponse;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

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

    public void changePwByPhoneNumber(ChangePasswordRequest request) {
        String sql = "UPDATE memberRepo SET memberPw = ? WHERE phoneNumber = ?";
        jdbcTemplate.update(sql, request.getNewPw(), request.getPhoneNumber());

//        memberRepo.changePw(phoneNumber,newPw);
    }

    public Member currentUser(String phoneNum) {
        String sql = String.format("SELECT * From MemberRepo WHERE phoneNumber = %s", phoneNum);
        return jdbcTemplate.query(sql, (RowMapper<String>) (rs, rowNum) -> {
            String memberId = rs.getString("memberId");
            String memberPw = rs.getString("memberPw");
            String memberName = rs.getString("memberName");
            String phoneNumber = rs.getString("phoneNumber");
//            return new Member(memberId, memberPw, memberName, phoneNumber);

        });

    }


//    public void findMemberIdByPhoneNumber() {
//    }

}
