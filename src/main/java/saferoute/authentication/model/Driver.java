package saferoute.authentication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "drivers", schema = "auth")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "vehicle_plate", length = 20)
    private String vehiclePlate;

    @Column(nullable = false, length = 20)
    private String status = "PENDING"; // PENDING, ACTIVE, INACTIVE

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;
}
