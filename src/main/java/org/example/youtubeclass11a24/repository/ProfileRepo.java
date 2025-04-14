package org.example.youtubeclass11a24.repository;

import org.example.youtubeclass11a24.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {

    boolean existsByEmail(String email);


}
