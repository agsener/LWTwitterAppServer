package com.ags.LWTwitterAppServer.controller;

import com.ags.LWTwitterAppServer.dto.SharedDto;
import com.ags.LWTwitterAppServer.dto.SharedPostDto;
import com.ags.LWTwitterAppServer.service.Impl.SharedServiceImpl;
import com.ags.LWTwitterAppServer.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.SharedCtrl.CTRL)
@CrossOrigin
public class SharedController {

    private final SharedServiceImpl sharedServiceImpl;

    public SharedController(SharedServiceImpl sharedServiceImpl) {
        this.sharedServiceImpl = sharedServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<SharedDto>> getAll() {
        List<SharedDto> sharedDtoItems = sharedServiceImpl.getAll();
        return ResponseEntity.ok(sharedDtoItems);
    }

    @PostMapping("/createPost")
    public ResponseEntity<SharedPostDto> createPost(@RequestBody SharedPostDto shared) {
        SharedPostDto sharedPostDtoItem = sharedServiceImpl.save(shared);
        return ResponseEntity.ok(sharedPostDtoItem);
    }
}
