package org.enset.app.kaissi.services;

import org.enset.app.kaissi.entities.Produit;
import org.enset.app.kaissi.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    public Optional<Produit> findById(UUID id) {
        return produitRepository.findById(id);
    }

    public void ajouterProduit(String nom,double prix) {
        Produit produit = new Produit();
        produit.setId(UUID.randomUUID());
        produit.setNom(nom);
        produit.setPrix(prix);
        produitRepository.insert(produit);
    }

    public Produit update(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteById(UUID id) {
        produitRepository.deleteById(id);
    }
}