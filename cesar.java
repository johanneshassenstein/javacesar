import java.util.*; //importiert Java Werkzeuge, z.B. die Arrayliste

public class cesar { //deklariert unsere Hauptklasse
  private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //speichert das verwendete Alphabet in einen String
  public static void main(String[] args) //Hauptfunktion der Klasse, die über das Terminal aufgerufen wird
  {
    if(args.length == 0){
      System.out.println("Please use java cesar and chain one of the following commands: encrypt, decrypt, force, tryout, analyse.");
    }
    else if(args[0].equals("encrypt")){ //wenn encrypt als erster Parameter übergeben wird
      if(args.length < 3){
        System.out.println("Please pass a string to encrypt and a offset as a second and third argument like so: 'java cesar encrypt HELLO 5'");
      }
      else{
        String phrase = args[1]; //speichert den zweiten Parameter als Phrase
        int offset = Integer.parseInt(args[2]); //speichert den dritten Paramter als Offset. Dazu wird dieser zunächst in einen Integer konvertiert
        String encryptedString = encrypt(phrase,offset); //ruft encrypt mit den beiden Parametern auf und speichert das Ergebnis
        System.out.println(encryptedString); //schreibt das Ergebnis in die Konsole
      }
    }
    else if(args[0].equals("decrypt")){ //wenn decrypt als erster Parameter übergeben wird
      if(args.length < 3){
        System.out.println("Please pass a string to decrypt and a offset as a second and third argument like so: 'java cesar decrypt MJQQT 5'");
      }
      else{
        String phrase = args[1]; //speichert den zweiten Parameter als Phrase
        int offset = Integer.parseInt(args[2]); //speichert den dritten Paramter als Offset. Dazu wird dieser zunächst in einen Integer konvertiert
        String decryptedString = decrypt(phrase,offset); //ruft decrypt mit den beiden Parametern auf und speichert das Ergebnis
        System.out.println(decryptedString); //schreibt das Ergebnis in die Konsole
      }
    }
    else if(args[0].equals("force")){ //wenn force als erster Parameter übergeben wird
      if(args.length < 3){
        System.out.println("Please pass a string to bruteforce as well as a part to test as a second and third argument, like so:'java cesar force JGNNQ HE'");
      }
      else{
        String phrase = args[1]; //speichert den zweiten Parameter als Phrase
        String part = args[2]; //speichert den dritten Parameter als zu findenen Part
        String forcedStrings = force(phrase,part); //ruft force mit den beiden Parametern auf und speichert das Ergebnis
        System.out.println(forcedStrings); //schreibt das Ergebnis in die Konsole
      }
    }
    else if(args[0].equals("tryout")){ //wenn force als erster Parameter übergeben wird
      if(args.length == 1){
        System.out.println("Please pass a string to try out as a second argument like so: 'java cesar tryout JGNNQ'");
      }
      else{
        String phrase = args[1]; //speichert den zweiten Parameter als Phrase
        String triedStrings = tryout(phrase); //ruft force mit den beiden Parametern auf und speichert das Ergebnis
        System.out.println(triedStrings); //schreibt das Ergebnis in die Konsole
      }
    }
    else if(args[0].equals("analyse")){ //wenn force als erster Parameter übergeben wird
      if(args.length == 1){
        System.out.println("Please pass a string to analyse as a second argument like so: 'java cesar analyse JGNNQ'");
      }
      else{
        String phrase = args[1]; //speichert den zweiten Parameter als Phrase
        String result = analyse(phrase); //ruft force mit den beiden Parametern auf und speichert das Ergebnis
        System.out.println(result); //schreibt das Ergebnis in die Konsole
      }
    }
    else{ //falls kein bekannter Operator als erstes Argument übergeben wird
      System.out.println("Unvalid operation"); //schreibt den Fehler in die Konsole
    }
  }
  public static String encrypt(String phrase, int offset){ //verschlüsselt einen String mit einem bestimmten Offset
    String[] array = phrase.split(""); //schreibt die einzelnden Buchstaben des String in eine Liste
    String encrPhrase = ""; //initiert einen leeren String
    for(int i = 0; i < array.length; i++){ //für jeden Buchstaben der Liste
      encrPhrase += alphabet.charAt(offset(array[i],offset, false)); //fügt den verschlüsselten Buchstaben dem Speicherstring hinzu
    }
    return encrPhrase; //gibt das Ergebnis zurück
  }
  public static String decrypt(String phrase, int offset){ //entschlüsselt einen String mit einem bestimmten Offset
    String[] array = phrase.split(""); //schreibt die einzelnden Buchstaben des String in eine Liste
    String decrPhrase = ""; //initiert einen leeren String
    for(int i = 0; i < array.length; i++){ //für jeden Buchstaben der Liste
      decrPhrase += alphabet.charAt(offset(array[i],offset, true)); //fügt den entschlüsselten Buchstaben dem Speicherstring hinzu
    }
    return decrPhrase; //gibt das Ergebnis zurück
  }
  public static String force(String phrase, String part){ //entschlüsselt einen String mit sog. Bruteforce indem ein bekannter Part im String gesucht wird
    List<String> possPhrases = new ArrayList<String>(); //deklariert eine leere Liste, die alle gefundenen Strings speichert. Da die größe nicht bekannt ist nutzen wir eine Arraylist
    for(int i = 0; i < alphabet.length(); i++){ //für jeden Buchstaben im Alphabet
      String poss = decrypt(phrase,i); //versucht den String mit dem aktuellen Parameter zu entschlüsseln
      if(poss.contains(part)){ //wenn das Ergebnis den gesuchten Part enthält
        possPhrases.add(poss); //fügt es der Speicherliste hinzu
      }
    }
    return String.join(", ", possPhrases); //gibt die Speicherliste als einen String zurück
  }
  public static String tryout(String phrase){
    List<String> allPhrases = new ArrayList<String>(); //deklariert eine leere Liste, die alle gefundenen Strings speichert. Da die größe nicht bekannt ist nutzen wir eine Arraylist
    for(int i = 0; i < alphabet.length(); i++){ //für jeden Buchstaben im Alphabet
      allPhrases.add(decrypt(phrase,i)); //versucht den String mit dem aktuellen Parameter zu entschlüsseln
    }
    return String.join(", ", allPhrases); //gibt die Speicherliste als einen String zurück
  }
  public static String analyse(String phrase){
    int[] statistic = new int[26];
    String[] array = phrase.split(""); //schreibt die einzelnden Buchstaben des String in eine Liste
    String result  = "";
    for(int i = 0; i < array.length; i++){ //für jeden Buchstaben der Liste
      statistic[alphabet.indexOf(array[i])]++; //fügt den entschlüsselten Buchstaben dem Speicherstring hinzu
    }
    for(int i = 0; i < alphabet.length(); i++){
      result += alphabet.charAt(i) + ":" + statistic[i] + " ";
    }
    return result; //gibt die Speicherliste als einen String zurück
  }
  public static int offset(String letter, int offset, boolean reverse){ //gibt eine Verschiebung von einer bestimmten Position um einen bestimmten Wert zurück
    int base = alphabet.length(); //die Rechenbasis um Werte unter 0 zu vermeiden
    int pos = alphabet.indexOf(letter); //die Startposition
    if(reverse){ //falls in entgegengesetzter Richtung verschoben werden soll
      return (base + (pos - (offset % base ))) % base; //gibt Verschiebung in umgekehrter Richtung zurück
    }
    else{
      return (base + (pos + (offset % base ))) % base; //gibt Verschiebung in positiver Richtung zurück
    }
  }
}
