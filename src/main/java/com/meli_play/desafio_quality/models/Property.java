package com.meli_play.desafio_quality.models;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private District district;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Room> roomLists;

    public Property(String nome, District district, List<Room> roomLists) {
        this.nome = nome;
        this.district = district;
        this.roomLists = roomLists;
    }

    public Property() {

    }
}
