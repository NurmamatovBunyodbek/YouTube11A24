package org.example.youtubeclass11a24.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.youtubeclass11a24.model.entity.PermissionRole;
import org.example.youtubeclass11a24.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String photo;
    @Enumerated
    private PermissionRole permissionRole;
    @Enumerated
    private Status status;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();




}
