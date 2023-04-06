package by.levitsky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users", schema = "public", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "username", nullable = false, length = 32)
    private String username;
    @Basic
    @Column(name = "firstname", nullable = false, length = 64)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 64)
    private String lastname;
    @Basic
    @Column(name = "age", nullable = false)
    private Integer age;
}
