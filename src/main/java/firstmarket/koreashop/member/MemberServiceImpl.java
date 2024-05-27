package firstmarket.koreashop.member;


import firstmarket.koreashop.dto.ChangePasswordRequest;
import firstmarket.koreashop.dto.CurrentUserResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    @Transactional
    public void join(MemberCreateRequest request) {
        memberRepository.save(new Member(request.getMemberId(), request.getMemberPw(), request.getMemberName(), request.getPhoneNumber()));

    }

    @Transactional(readOnly = true)
    public String findMemberIdByPhoneNumber(String phoneNumber) {
        Member target = memberRepository.findByPhoneNumber(phoneNumber).orElseThrow(IllegalArgumentException::new);

        return target.getMemberId();
    }

    @Transactional
    public void changePwByPhoneNumber(ChangePasswordRequest request) {
//        String sql = "UPDATE memberRepo SET memberPw = ? WHERE phoneNumber = ?";
//        jdbcTemplate.update(sql, request.getNewPw(), request.getPhoneNumber());

//        memberRepo.changePw(phoneNumber,newPw);
        Member target = memberRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(IllegalAccessError::new);
        target.updatePw(request.getNewPw());

    }


//    public Member currentUser(String phoneNum) {
//        String sql = String.format("SELECT * From MemberRepo WHERE phoneNumber = %s", phoneNum);
//        return jdbcTemplate.query(sql, (RowMapper<String>) (rs, rowNum) -> {
//            String memberId = rs.getString("memberId");
//            String memberPw = rs.getString("memberPw");
//            String memberName = rs.getString("memberName");
//            String phoneNumber = rs.getString("phoneNumber");
////            return new Member(memberId, memberPw, memberName, phoneNumber);

//
//        });
//    }


//    public void findMemberIdByPhoneNumber() {
//    }

}
