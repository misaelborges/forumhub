package com.misael.forumhub.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
