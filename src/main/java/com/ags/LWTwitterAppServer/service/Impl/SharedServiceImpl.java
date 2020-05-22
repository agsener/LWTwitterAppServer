package com.ags.LWTwitterAppServer.service.Impl;

import com.ags.LWTwitterAppServer.dto.SharedDto;
import com.ags.LWTwitterAppServer.entity.Shared;
import com.ags.LWTwitterAppServer.repository.SharedRepository;
import com.ags.LWTwitterAppServer.service.SharedService;
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
    private final ModelMapper modelMapper;

    public SharedServiceImpl(SharedRepository sharedRepository, ModelMapper modelMapper) {
        this.sharedRepository = sharedRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SharedDto> getAll() {
        List<Shared> sharedItems = sharedRepository.findAll();
        for (Shared shared : sharedItems) {
            String sharedPhotoUuid = shared.getPhotoUuid();
            String encodedString = null;
            try {
                encodedString = convertImageFiletoBase64String(sharedPhotoUuid);
            } catch (IOException e) {
                e.printStackTrace();
            }
            shared.setPhotoBase64(encodedString);
        }
        List<SharedDto> sharedDtoItems = Arrays.asList(modelMapper.map(sharedItems, SharedDto[].class));
        return sharedDtoItems;
    }

    public String convertImageFiletoBase64String(String sharedPhotoUuid) throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\pictures\\sharedPhoto\\" + sharedPhotoUuid + ".jpg";
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    public void convertBase64StringtoImageFile(String encodedString) throws IOException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String outputFileName = System.getProperty("user.dir") + "\\src\\main\\resources\\pictures\\sharedPhoto\\" + randomUUIDString + ".jpg";
        FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);
    }
}
