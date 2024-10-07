package org.enset.app.kaissi.web;

import org.enset.app.kaissi.entities.Produit;
import org.enset.app.kaissi.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    //@Autowired il est recommander d'utiliser l'injection par constructeur
    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable UUID id) {
        Optional<Produit> produit = produitService.findById(id);
        return produit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String createProduit(@RequestParam String nom,@RequestParam double prix) {
        produitService.ajouterProduit(nom,prix);
        return "Produit ajouté";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable UUID id, @RequestBody Produit updatedProduit) {
        Optional<Produit> produit = produitService.findById(id);
        if (produit.isPresent()) {
            updatedProduit.setId(id);
            return ResponseEntity.ok(produitService.update(updatedProduit));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable UUID id) {
        produitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}