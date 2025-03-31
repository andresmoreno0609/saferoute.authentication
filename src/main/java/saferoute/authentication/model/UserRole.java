package saferoute.authentication.model;

import jakarta.persistence.*;
import lombok.*;
import saferoute.authentication.enums.EUserRole;

@Entity
@Table(name = "user_roles", schema = "auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EUserRole role;
}
