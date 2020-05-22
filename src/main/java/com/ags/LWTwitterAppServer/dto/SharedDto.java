package com.ags.LWTwitterAppServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharedDto {

    private Long id;
    private String photoId;
    private String comment;
    private Date date;
    private Long rate;
    private UserDto owner;
}
