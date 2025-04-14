package org.example.youtubeclass11a24.repository;

import org.example.youtubeclass11a24.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
