# Projet Examen Java
Projet examen de java 2020

## AfficherLesTables
Permet de lister le contenu d'une table choisie par l'utilisateur.

La méthode ***RécupérerNomsTableau*** permet de chercher les noms des tableaux et d'afficher ceci dans la comboChoix.
La méthode ***ActionAfficherTable*** permet de faire appel à la classe AfficherUneTable afin d'afficher le tableau choisi par l'utilisateur.

## AfficherUneTable
Cette classe permet l'affichage d'un tableau.

La Jtable sera placée dans un JScrollPane afin d'éviter des risques d'affichage. On affiche donc le JScollPane contenant la Jtable au container.

## APropos
La classe APropos permet de faire apparaitre une petite fenêtre à l'utilisateur, cette fenêtre contient des informations sur le programme et ses créateurs.

Des boutons sont disponibles afin d'envoyer l'utilisateur vers le compte github des développeurs.

## BoutonAnnulation
Cette classe permet de créer un bouton et de faire appel à la méthode ActionAnnulation qui permet d'annuler l'ajout d'une nouvelle installation lorsque ce bouton est appuyé. 

## BoutonInsertion
Cette classe permet de créer un bouton et de faire appel à la méthode AjoutNouvelleInstallation qui permet d'd'ajouter nouvelle installation.

## ComboxDate
Cette classe sert à gérer les combox Date.

***getDate()*** permet de récupérer la date choisie par l'utilisateur et le transformer en format yyyMMdd pour ensuite le stocker dans une variable de type java.util.Date.
***getDateAcquis()*** permet de récupérer la date et la renvoie en String.

## Fenetre
Permet d'afficher la fenêtre principale du programme aves les menus.

## Login
La classe Login permet la connexion à la base de donné.


## LoginFenetre
Permet de créer la fenêtre de connexion et d'appeler la classe Login.

## NouvelleInstallation
Permettre l’encodage via un formulaire d’une nouvelle installation et l’insertion de cette nouvelle installation dans la table correspondante de la base de données MySQL.

*** ActionBoutonLogin *** permet de se connecter et d'afficher le programme.

## Principale
Lance le programme.

## SoftwareProfesseur
Lister les softwares utilisés dans les sections où travaille principalement un professeur choisi par l’utilisateur parmi la liste des noms et prénoms de professeurs existants dans la BD.

## SoftwaresAcquisDate
Lister les installations de softwares acquis entre deux dates introduites par l’utilisateur.

## Suppression
Permettre la suppression d’une installation dans la liste des installations de softwares d’une famille de software choisie par l’utilisateur, et pour lesquelles la durée d’installation est inférieure à deux heures.
