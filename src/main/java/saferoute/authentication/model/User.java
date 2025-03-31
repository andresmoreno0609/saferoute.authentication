package saferoute.authentication.model;

import jakarta.persistence.*;
import lombok.*;
import saferoute.authentication.enums.EUserStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users", schema = "auth")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20, unique = true)
    private String phone;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "photo_url", length = 255)
    private String photoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EUserStatus status = EUserStatus.ACTIVE;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;
}
