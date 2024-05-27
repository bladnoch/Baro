package firstmarket.koreashop.service.member;


import firstmarket.koreashop.domain.member.Member;
import firstmarket.koreashop.domain.member.MemberRepository;
import firstmarket.koreashop.dto.member.ChangePasswordRequest;

import firstmarket.koreashop.dto.member.MemberCreateRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
