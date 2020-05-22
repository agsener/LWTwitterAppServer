package com.ags.LWTwitterAppServer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Rate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rate")
    private int rate;

    @JoinColumn(name = "shared_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Shared shared;

    @JoinColumn(name = "rate_owner")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User owner;
}