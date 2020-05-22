package com.ags.LWTwitterAppServer.service.Impl;

import com.ags.LWTwitterAppServer.dto.SharedDto;
import com.ags.LWTwitterAppServer.entity.Shared;
import com.ags.LWTwitterAppServer.repository.SharedRepository;
import com.ags.LWTwitterAppServer.service.SharedService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
        List<SharedDto> sharedDtoItems = Arrays.asList(modelMapper.map(sharedItems, SharedDto[].class));
        return sharedDtoItems;
    }
}
