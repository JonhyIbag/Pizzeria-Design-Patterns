/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.abst;

/**
 *
 * @author Usuario
 */
public interface Subject {
    void registerObservers(Observador o);
    void removeObservers(Observador o);
    void notifyObservers(String mensaje);
    
}
