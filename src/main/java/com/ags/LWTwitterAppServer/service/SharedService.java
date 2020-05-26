package com.ags.LWTwitterAppServer.service;

import com.ags.LWTwitterAppServer.dto.SharedDto;
import com.ags.LWTwitterAppServer.dto.SharedPostDto;

import java.util.List;

public interface SharedService {

    List<SharedDto> getAll();

    SharedPostDto save(SharedPostDto shared);
}
