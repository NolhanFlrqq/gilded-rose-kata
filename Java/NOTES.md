# Notes

## Ce que j'ai choisi de faire
J'ai appliqué le design pattern Stratégie pour refactoriser `GildedRose.java`.
J'ai constaté que toute la logique métier était concentrée dans une seule classe, ce qui la rendait difficile à lire et à maintenir.
J'ai créé une interface `ItemUpdater` déclarant une méthode `update(Item)`, puis une classe par type d'item, chacune implémentant cette interface avec sa propre logique.
`GildedRose.java` utilise ensuite une `Map` pour associer chaque nom d'item à son updater.

## Pourquoi
Ce découpage rend le code plus lisible car toutes les responsabilités sont séparées.
Il est aussi plus maintenable : si le comportement d'un item change, on sait directement vers quelle classe se diriger.
Enfin, il est ouvert à l'extension : ajouter un nouveau type d'item avec une nouvelle logique ne nécessite de modifier GildedRose.java qu'à un seul endroit (l'ajout d'une entrée dans la Map), sans toucher à la logique existante, une modification minime comparée à l'ancienne approche.

## Avec plus de temps
Honnêtement, je ne vois pas d'amélioration majeure à apporter dans le cadre ou j'aurais eu plus de temps et surtout avec les contraintes actuelles.
Si la contrainte sur la classe `Item` était levée, j'aurais introduit une énumération pour les types afin de séparer le nom de l'item de son type, tout en conservant le design pattern Stratégie.