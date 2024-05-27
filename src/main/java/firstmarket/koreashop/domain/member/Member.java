package firstmarket.koreashop.domain.member;

import firstmarket.koreashop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    public Member(String memberId, String memberPw, String memberName, String phoneNumber) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=null;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @Column(length = 20)
    private String memberId;

    @Column(length = 20)
    private String memberPw;

    @Column(length = 20)
    private String memberName;

    @Column(length = 20)
    private String phoneNumber;

    public void updatePw(String newPw) {
        this.memberPw = newPw;
    }
}


