package Banque;


/**
* Banque/BanqueOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idl
* mercredi 17 novembre 2021 11 h 21 WEST
*/

public interface BanqueOperations 
{
  float lire_compte ();
  void debiter (float solde);
  void crediter (float solde);
} // interface BanqueOperations