# javacesar

This small program can be used for educational purposes. It demonstrates the usage of the Ceasar's cipher to de- and encrypt messages as well the way a brute force algorithm works. It may be used on it's own or as a starting point to develop a command line application to break ciphers, encrypted with the Ceasear's cipher using brute force together with a dictionary or a analysis of frequency.

## Usage

To use the Java program open a terminal and navigate to the folder, where the "cesar.class" file is stored. Now type: "java cesar". The program should respond with: "Please use java cesar and chain one of the following commands: encrypt, decrypt, force, tryout, analyse."

A list of all operations can be found below.

To edit the program open the "cesar.java" file in your least favorite text editor, make your changes. Then head over to the command line and use *"cd"* to get into the folder where the "cesar.java" file is stored. Now use the command *"javac cesar.java"* to compile the file into a program that can be executed from the commandline.

## Operations

The following operations can be made with the unmodified cesar.class program:

### encrypt

| Argument 1      | string to encrypt          |
| --------------- | -------------------------- |
| Argument 2      | offset to use              |
| Example         | java cesar encrypt HELLO 5 |
| Expected result | MJQQT                      |

Will encrypt a given string with a given offset using the Ceasar's Cipher.

### decrypt

| Argument 1      | string to encrypt          |
| --------------- | -------------------------- |
| Argument 2      | offset to use              |
| Example         |  java cesar decrypt MJQQT 5 |
| Expected result | HELLO                      |

Will decrypt a given string with a given offset using the Ceasar's Cipher.

### force

| Argument 1      | string to brute force      |
| --------------- | -------------------------- |
| Argument 2      | part that is expected      |
| Example         | java cesar force MJQQT H   |
| Expected result | HELLO, DAHHK, AXEEH, KHOOR |

Will use brute force on a given string while looking for a given part of the expected clear text. Just like the Turing machine!

### tryout

| Argument 1      | string to try out                                            |
| --------------- | ------------------------------------------------------------ |
| Example         | java cesar tryout MJQQT                                      |
| Expected result | MJQQT, LIPPS, KHOOR, JGNNQ, IFMMP, HELLO, GDKKN, FCJJM, EBIIL, DAHHK, CZGGJ, BYFFI, AXEEH, ZWDDG, YVCCF, XUBBE, WTAAD, VSZZC, URYYB, TQXXA, SPWWZ, ROVVY, QNUUX, PMTTW, OLSSV, NKRRU |

Will give back every decryption with a key from 0 to 26. May be used for educational purposes (aka "Why is 26 possibilities a bit to few").

### analyse

| Argument 1      | string to analye                                            |
| --------------- | ------------------------------------------------------------ |
| Example         | java cesar analyse SUPERCALIFRAGILISTICEXPIALIGETISCH                                      |
| Expected result | A:3 B:0 C:3 D:0 E:3 F:1 G:2 H:1 I:7 J:0 K:0 L:3 M:0 N:0 O:0 P:2 Q:0 R:2 S:3 T:2 U:1 V:0 W:0 X:1 Y:0 Z:0 |

Will give the frequency of each letter in the given string. May be used for further cryptographic experiments. **Mom look, I'm a cryptographer now!**

## Extending

As this is a educational program only (so no using it to decrypt your communication, use PGP instead!) it may be used as a foundation for further advances into cryptography and Java. I suggest the following things:

- Support
  - Whitespaces
  - Non-alphabetic characters like numbers and symbols
  - And think about if they should be encrypted or not and if, then how?
- Extend bruteforce to throw out sentences that do not make any sense because they contain illegal characters (maybe get into Regex?)
- Build a bruteforce algorithm that uses a dictionary
- Fight each other with Caesar based decryption algorithms and brute force programs!

## Contact

Johannes Hassenstein

johannes.hassenstein@protonmail.com

https://johassenstein.de

## Copyright

Use for whatever you want, just nothing illegal please.



