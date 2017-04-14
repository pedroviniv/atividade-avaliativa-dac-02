/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.bank.shared.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Pedro Arthur
 */

@Embeddable
public class Address implements Serializable {
    
    private String city;
    private String neighbordhood;
    private String street;

    public Address(String city, String neighbordhood, String street) {
        this.city = city;
        this.neighbordhood = neighbordhood;
        this.street = street;
    }
    
    public Address() {
        
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbordhood() {
        return neighbordhood;
    }

    public void setNeighbordhood(String neighbordhood) {
        this.neighbordhood = neighbordhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", neighbordhood=" + neighbordhood + ", street=" + street + '}';
    }
}
