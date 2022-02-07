package no.visma.nk22project.imgflip.repo;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "T_MEME")
@NoArgsConstructor
@AllArgsConstructor
public class PersistedMeme {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;
}
