package org.example.youtubeclass11a24.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.youtubeclass11a24.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer preview_attach_id;
    @Column(nullable = false)
    private String title;
    @ManyToMany
    private List<Category> category;
    @OneToOne
    private Attach attach;
    @CreatedDate
    private LocalDateTime created_date = LocalDateTime.now();
    @CreatedDate
    private LocalDateTime published_date;
    @Enumerated
    private Status status;
    @Column(nullable = false)
    private String type;
    @ManyToMany
    private List<View_count> viewCount;
    @Column(nullable = false)
    private Integer shared_count;
    @Column(nullable = false)
    private String description;
    @ManyToMany
    private List<Channel> channel;
    @Column(nullable = false)
    private Integer like_count;
    @Column(nullable = false)
    private Integer dislike_count;

}
