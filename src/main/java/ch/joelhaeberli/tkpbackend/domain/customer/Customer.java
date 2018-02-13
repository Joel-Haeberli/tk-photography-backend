package ch.joelhaeberli.tkpbackend.domain.customer;

import ch.joelhaeberli.tkpbackend.domain.ort.Ort;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String prename;
    private String email;
    private String adresse;
    private Ort ort;
    private Boolean agbAccepted;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public Boolean getAgbAccepted() {
        return agbAccepted;
    }

    public void setAgbAccepted(Boolean agbAccepted) {
        this.agbAccepted = agbAccepted;
    }
}
