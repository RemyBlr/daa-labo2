# DAA - labo2

## Exercice 1

### Choix d'implémentations
Il y a deux activités distinctes, une première `MainActivity` qui affiche le message de bienvenue,
et `EditUsernameActivity` qui permet de choisir un nom et de l'envoyer à la première.

Utilisation des contracts de la librairie `AndroidX` avec `registerForActivityResult` comme vu
lors de la théorie.

Utilisation de `Lod.d` dans chaque méthode pour logger les différents chemins parcourus.

Utilisation d'un `ConstrainLayout` afin de pouvoir centrer horizontallement et verticallement dans 
le parent.

### Questions
- Que se passe-t-il si l’utilisateur appuie sur « back » lorsqu’il se trouve sur la seconde Activité ?
- Veuillez réaliser un diagramme des changements d’état des deux Activités pour les utilisations
suivantes, vous mettrez en évidence les différentes instances de chaque Activité :
  - L’utilisateur ouvre l’application, clique sur le bouton éditer, renseigne son prénom et
  sauve.
  - L’utilisateur ouvre l’application en mode portrait, clique sur le bouton éditer, bascule en
  mode paysage, renseigne son prénom et sauve.
- Que faut-il mettre en place pour que vos Activités supportent la rotation de l’écran ? Est-ce
nécessaire de le réaliser pour les deux Activités, quelle est la différence ?

### Tests
| Test effectué                                        | Résultat attendu                                             | Résultat obtenu    |
|------------------------------------------------------|--------------------------------------------------------------|--------------------|
| Ouvrir l'application                                 | Affichage du "Bonjour"                                       | OK                 |
| Cliquer sur le bouton éditer                         | Affichage d'un champ de text avec un bouton sauver           | OK                 |
| Cliquer sur le bouton sauver avec un nom             | Affichage du "Bonjour + nom"                                 | OK                 |
| Cliquer sur le bouton sauver avec champ vide         | Il ne devrait pas avoir de modification du message précédent | KO le nom est vide |
| Rotation de l'écran                                  | Les texts et les boutons s'adaptent à l'écran                | OK                 |
| Cliquer sur le bouton "back" depuis la 2ème activité | Retour à la 1ère activité sans changement de text            | OK                 |