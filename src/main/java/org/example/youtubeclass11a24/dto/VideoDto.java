package org.example.youtubeclass11a24.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.youtubeclass11a24.model.Attach;
import org.example.youtubeclass11a24.model.Category;
import org.example.youtubeclass11a24.model.Channel;
import org.example.youtubeclass11a24.model.View_count;
import org.example.youtubeclass11a24.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {

    private Integer preview_attach_id;
    private String title;
    private Integer category;

    private Integer attach;
    private Integer status;
    private String type;
    private Integer viewCount;
    private Integer shared_count;
    @Column(nullable = false)
    private String description;

    private Integer channel;
    @Column(nullable = false)
    private Integer like_count;
    @Column(nullable = false)
    private Integer dislike_count;

}
