package com.ags.LWTwitterAppServer.service.Impl;

import com.ags.LWTwitterAppServer.dto.SharedDto;
import com.ags.LWTwitterAppServer.dto.SharedPostDto;
import com.ags.LWTwitterAppServer.entity.Shared;
import com.ags.LWTwitterAppServer.entity.User;
import com.ags.LWTwitterAppServer.repository.SharedRepository;
import com.ags.LWTwitterAppServer.service.SharedService;
import com.ags.LWTwitterAppServer.service.UserService;
import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class SharedServiceImpl implements SharedService {

    private final SharedRepository sharedRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public SharedServiceImpl(SharedRepository sharedRepository, UserService userService, ModelMapper modelMapper) {
        this.sharedRepository = sharedRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SharedDto> getAll() {
        List<Shared> sharedItems = sharedRepository.findAll();
        for (Shared shared : sharedItems) {
            String sharedPhotoUuid = shared.getPhotoUuid();
            String ownerProfilPictureUuid = shared.getOwner().getProfilPictureUuid();
            String encodedStringSharedPhoto = null;
            String encodedStringProfilPicture = null;
            try {
                encodedStringSharedPhoto = convertImageFiletoBase64String(sharedPhotoUuid);
                encodedStringProfilPicture = convertImageFiletoBase64String(ownerProfilPictureUuid);
            } catch (IOException e) {
                e.printStackTrace();
            }
            shared.setPhotoBase64(encodedStringSharedPhoto);
            shared.getOwner().setProfilPictureBase64(encodedStringProfilPicture);
        }
        List<SharedDto> sharedDtoItems = Arrays.asList(modelMapper.map(sharedItems, SharedDto[].class));
        return sharedDtoItems;
    }

    @Override
    public SharedPostDto save(SharedPostDto shared) {
        Shared s = modelMapper.map(shared, Shared.class);
        User owner = userService.getUserById(shared.getOwnerId());
        s.setOwner(owner);
        s.setRate((float) 0);
        s.setPhotoBase64(null);
        String uuid = "";
        try {
            uuid = convertBase64StringtoImageFile(shared.getPhotoBase64());
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.setPhotoUuid(uuid);
        sharedRepository.save(s);
        return shared;
    }

    public String convertImageFiletoBase64String(String sharedPhotoUuid) throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\pictures\\sharedPhoto\\" + sharedPhotoUuid + ".jpg";
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    public String convertBase64StringtoImageFile(String encodedString) throws IOException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String outputFileName = System.getProperty("user.dir") + "\\src\\main\\resources\\pictures\\sharedPhoto\\" + randomUUIDString + ".jpg";
        FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);
        return randomUUIDString;
    }
}
