package com.ags.LWTwitterAppServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharedPostDto {

    private String photoBase64;
    private String comment;
    private Date date;
    private Float rate;
    private Long ownerId;
}
