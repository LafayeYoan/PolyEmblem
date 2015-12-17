## TODO

(Liste non exhaustive de ce qu'il reste à faire)

Quand une tâche est faite, merci d'écrire DONE devant et de ne pas l'effacer.

# Background 

* Créer un scénario : Si le temps le permet, on pourra envisager plusieurs scénarios et fin possibles, mais pour le moment, il vaut mieux avoir toutes les fonctionnalités. On pourra peut-être aussi envisager une partie du scénario aléatoire. 

# Developpement Model

* L'utilisateur créer son personnage au début de la partie. Il choisit la classe et le pseudo. Lors de sa création, la santé Max et les caractéristiques sont automatiquement calculés en fonction de la classe choisit. 

* La santé diminue lorsque le personnage est blessé au combat. Elle peut augmenter si le personnage se soigne. 

* Le niveau d'expérience augmente lorsqu'un combat est gagné. Utiliser une fonction logarithmique ou une fonction qui permet une évolution réaliste. Il est nécéssaire d'avoir de plus en plus d'expérience au fil des niveaux. 

* Quand le personnage gagne un niveau, il dispose d'un point de compétence à attribuer quelque part dans ces compétences. (voir Dev. View pour afficher une fenêtre spécifique).  

* [OPTION] Pour rendre le jeu équitable, une contrainte commune à tous les personnages doit être vérifier. Exemple : la somme des caractéristiques de base ne dois pas exceder une certaine valeur. (VOIR SUJET DU PROF).  

* Implémenter les containtes et caractéristiques des différentes classes lors de la création du personnage par le joueur. 

* Gérer la sauvegarde EN BINAIRE (Sérialisation + déserialisation). 

* Le personnage peut récupérer du stuff. Dans ce cas, l'objet est ajouté au sac du joueur et/ou équipé. S'il est mis dans le sac, la poids disponible du sac est mis à jours. Le poids maximum supporté ne peut pas être dépassé. De base, le joueur peut être équipé de une arme, une armure et des bottes.

* Si le joueur utilise un consommable, (pendant un combat uniquement), l'objet est détruit et les stats du joueur sont mis à jour en conséquence. 

* La vie du joueur se met à jour quand il est attaqué pendant un combat.

* Chaque classe possède deux capacités (parmi attaque, parade et soin)

* Utilisation d'une capacité : 
    ** 1. Vérifier qu'elle est réussite (proba de réussite). Cette probabilité dépend des caractéristiques du personnage (?) et de ses points de compétences. 2. Si la capacité est réussie : 


# Developpement View

* [OPTION] "help" : donne toutes les commandes possibles au joueur. 

* [OPTION] "moi" : affiche le détail du personnage que joue le joueur. 

* Prévoir "une fenêtre" pour attribuer un point de compétence lors du gars de niveau.

* Prévoir "une fenêtre" pour visualiser et gérer le contenu du sac à dos.  

* [OPTION] Si le joueur tape une commande qui n'est pas prise en charge, "commande non reconnue" apparait et le jeu se poursuit. 

# Autres

* Créer un fichier UML Complet et à jour du projet
