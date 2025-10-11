## Manipulation 2

`Les deux Fragments fournis implémentent la restauration de leur état. Si on enlève la
sauvegarde de l’état sur le ColorFragment sa couleur sera tout de même restaurée, comment
pouvons-nous expliquer cela ?`

Si on enlève la sauvegarde de l'état sur le ColorFragment:

Normalement les états des vues ne sont pas enregistrés par défaut SAUF pour les champs avec un ID.
Ici les champs avec ID sont enregistrés et suffisent à recalculer (via les listeners) la couleur, car techniquement seulement les états des "curseurs" du fragment sont enregistrés et partir de cela le fragment va redéterminer la couleur (qui était donc là dans l'état précécent).

`Si nous plaçons deux fois le CounterFragment dans l’Activité, nous aurons deux instances
indépendantes de celui-ci. Comment est-ce que la restauration de l’état se passe en cas de
rotation de l’écran ?`

Malgré la duplication du fragment les 2 différent conteneurs de fragments. Donc à l'appel de ces conteneurs via la classe R, chacun aura une identification unique -> R.id...par container, qui auront chacun leur propriétés. Il n'y aura donc aucune différence malgré la répétition du fragment.


### Choix d'implémentation
Le layout utilise un `ConstraintLayout` avec les éléments suivants :

1. **AppBar** : En haut de l'écran
2. **Container pour CounterFragment** : Occupe 50% de l'espace disponible sous l'AppBar
3. **Container pour ColorFragment** : Occupe les 50% restants

**Choix techniques :**

- Utilisation de `FrameLayout` comme conteneurs de fragments (pratique standard Android)
- Division de l'écran en deux parties égales via des contraintes :
  - `layout_height="0dp"` avec contraintes top/bottom
  - `layout_constraintHeight_percent="0.5"` pour 50% de hauteur chacun
- L'AppBar est placée en haut et ne compte pas dans la division 50/50
