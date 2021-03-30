package ru.waveaccess.conference.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "presentation")
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "presentation")
    private Schedule schedule;

    @ManyToMany()
    @JoinTable(name = "user_presentation",
            joinColumns = {
                    @JoinColumn(name = "presentation_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")})
    private List<User> users;
}
