package Modele.Abstract;

import Modele.Auteur;
import Modele.Disque;
import Modele.DisqueVinyle;
import Modele.FichierNumerique;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Disque.class, name = "cd"),
        @JsonSubTypes.Type(value = DisqueVinyle.class, name = "thermostat"),
        @JsonSubTypes.Type(value = FichierNumerique.class, name = "mp3")
})

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Album {

    protected String nom;
    protected Auteur auteur;
    protected LocalDate annee;
    protected int quantite;

    public Album(String nom, Auteur auteur, LocalDate annee, int quantite) {
        this.nom = nom;
        this.auteur = auteur;
        this.annee = annee;
        this.quantite = quantite;
    }

    protected Album() {

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public LocalDate getAnnee() {
        return annee;
    }

    public void setAnnee(LocalDate annee) {
        this.annee = annee;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public abstract String getSupport();

    @Override
    public String toString() {
        return " " + nom + " de " + auteur + " sortie en " + annee + " avec " + quantite + " album ";
    }
}
