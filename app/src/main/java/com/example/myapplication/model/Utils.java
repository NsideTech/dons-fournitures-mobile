package com.example.myapplication.model;

public class Utils {
 //Créer les REGEX
 public static boolean checkRegexNom(String nom) {
  if (!nom.matches("[a-z-A-Z-0-9-]{1,21}+")) {
   return false;
  } else {
   return true;
  }

 }

 public static boolean checkRegexPhone(String phone) {
  if (!phone.matches("[0-9]{1,4}[-][0-9]{1,4}[-][0-9]{1,5}+")) {
   return false;
  } else {
   return true;
  }
 }

 public static boolean checkRegexEmail(String email) {
  if (!email.matches("[a-z-A-Z-0-9]+")) {
   return false;
  } else {
   return true;
  }
 }
 public static boolean checkRegexPays(String pays) {
  if (!pays.matches("[a-z-A-Z]+")) {
   return false;
  } else {
   return true;
  }
 }
 public static boolean checkRegexVille(String ville) {
  if (!ville.matches("[a-z-A-Z]+")) {
   return false;
  } else {
   return true;
  }
 }
 public static boolean checkRegexDescription(String description) {
  if (!description.matches("[a-z-A-Z0-9:_-]+")) {
   return false;
  } else {
   return true;
  }
 }
}