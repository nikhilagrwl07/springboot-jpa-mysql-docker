//package fitness.table;
//
//import fitness.table.User;
//import lombok.NoArgsConstructor;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import javax.validation.constraints.Size;
//import java.io.Serializable;
//import java.util.Date;
//
//@Entity
//@Table(name = "USER_PROFILE")
//@EntityListeners(AuditingEntityListener.class)
//@NoArgsConstructor
//public class UserProfile implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "phone_number")
//    @Size(max = 15)
//    private String phoneNumber;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 10)
//    private Gender gender;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "dob")
//    private Date dateOfBirth;
//
//    @Size(max = 100)
//    private String address1;
//
//    @Size(max = 100)
//    private String address2;
//
//    @Size(max = 100)
//    private String street;
//
//    @Size(max = 100)
//    private String city;
//
//    @Size(max = 100)
//    private String state;
//
//    @Size(max = 100)
//    private String country;
//
//    @Column(name = "zip_code")
//    @Size(max = 32)
//    private String zipCode;
//
//    @OneToOne(mappedBy = "userProfile")
//    private User user;
//
//}
