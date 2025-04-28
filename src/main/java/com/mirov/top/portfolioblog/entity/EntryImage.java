package com.mirov.top.portfolioblog.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "entry_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) //разобраться
    @JoinColumn(name = "entry_id", nullable = false)
    private DiaryEntry diaryEntry;

    @Column(name="image_url", nullable = false)
    private String imageUrl;
}
