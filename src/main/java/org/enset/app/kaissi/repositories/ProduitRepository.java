package org.enset.app.kaissi.repositories;

import org.enset.app.kaissi.entities.Produit;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProduitRepository extends CassandraRepository<Produit, UUID> {
}