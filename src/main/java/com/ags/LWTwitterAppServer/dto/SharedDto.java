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
    private String photoUuid;
    private String photoBase64;
    private String comment;
    private Date date;
    private Long rate;
    private UserDto owner;
}
