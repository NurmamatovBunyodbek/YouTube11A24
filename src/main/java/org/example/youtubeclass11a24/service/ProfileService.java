package org.example.youtubeclass11a24.service;

import org.example.youtubeclass11a24.dto.ProfileDto;
import org.example.youtubeclass11a24.model.Profile;
import org.example.youtubeclass11a24.model.Result;
import org.example.youtubeclass11a24.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    public List<Profile> get_all() {
        return profileRepo.findAll();
    }

    public Profile get_by_id(Integer id) {
        return profileRepo.findById(id).get();
    }

    public Result create(ProfileDto profileDto) {
        boolean existsed = profileRepo.existsByEmail(profileDto.getEmail());
        if (existsed) {
            return new Result(false, "Bunday email mavjud");
        }
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPassword(profileDto.getPassword());
        profile.setPhoto(profileDto.getPhoto());
        profileRepo.save(profile);
        return new Result(true, "Saqlandi");
    }

    // delete
    public Result delete(Integer id) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        if (profileOptional.isPresent()) {
            profileRepo.deleteById(id);
            return new Result(true, "Deleted");
        }
        return new Result(false, "Bunday Id mavjud emas");
    }

    // update4
    public Result update(Integer id, ProfileDto profileDto) {

        Optional<Profile> optionalProfile = profileRepo.findById(id);

        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPassword(profileDto.getPassword());
            profile.setPhoto(profileDto.getPhoto());
            profileRepo.save(profile);
            return new Result(true, "Updated");

        }
        return new Result(false, "Id not found");
    }

}
