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

    @Column(name = "photo", length = 400)
    private String photoId;

    @Column(name = "comment", length = 280)
    private String comment;

    @Column(name = "date")
    private Date date;

    @Column(name = "rate")
    private Long rate;

    @JoinColumn(name = "owner")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User owner;
}
