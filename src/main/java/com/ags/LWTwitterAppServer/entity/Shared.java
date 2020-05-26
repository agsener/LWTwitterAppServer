package com.ags.LWTwitterAppServer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shared")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Shared extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "photo_uuid", length = 400)
    private String photoUuid;

    @Column(name = "photo_base64")
    private String photoBase64;

    @Column(name = "comment", length = 280)
    private String comment;

    @Column(name = "date")
    private Date date;

    @Column(name = "rate")
    private Float rate;

    @JoinColumn(name = "owner")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User owner;
}
