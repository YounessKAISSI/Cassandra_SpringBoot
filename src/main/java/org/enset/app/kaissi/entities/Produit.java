package org.enset.app.kaissi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("Produit")
@NoArgsConstructor @AllArgsConstructor @Data
public class Produit {

    @PrimaryKey
    private UUID id;
    private String nom;
    private double prix;


}