package org.example.youtubeclass11a24.repository;

import org.example.youtubeclass11a24.model.Video;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

public interface VideoRepo extends JpaRepository<Video , Integer> {
}
