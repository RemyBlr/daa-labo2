Ce projet Android est basé sur le template "Empty Views Activity".

A partir duquel avons effectué les modifications suivantes :

- Changement de la couleur du fond du thème, de l'icône de l'app et du message d'accueil
- Ajout dans le layout de l'activité d'une barre des tâches et liaison de celle-ci avec l'activité au niveau de MainActivity.kt

Ce projet peut vous servir de point de départ pour les laboratoires de DAA pour lesquels aucun code n'est mis à disposition sur Cyberlearn.

Si vous souhaitez renommer l'application et changer son identifiant, voici les opérations à effectuer :

- Changer le nom du projet dans le fichier `.idea/.name`
- Editer la propriété `applicationId` dans le fichier `build.gradle.kts` du module `app`
- Idéalement, il faudrait également modifier le nom de package (propriété `namespace` du fichier `build.gradle.kts`) ainsi que refactoriser le code