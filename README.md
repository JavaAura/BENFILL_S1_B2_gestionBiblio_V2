# Gestion Bibliothèque Municipale - V2

## Description du projet
Cette application de gestion de bibliothèque municipale permet de gérer efficacement les livres, les magazines, les thèses universitaires, et les journaux scientifiques, ainsi que les processus de prêt et de retour. Le système offre des rôles distincts pour les utilisateurs, tels que les étudiants et les professeurs, chacun ayant des fonctionnalités spécifiques selon son rôle.

## Objectif général de l'application
L'objectif principal de cette application est d'automatiser les tâches courantes de gestion de bibliothèque, notamment :
- Gérer l'inventaire des documents (livres, magazines, thèses, etc.)
- Permettre l'emprunt et le retour de documents
- Améliorer la gestion des utilisateurs par des rôles spécifiques (étudiant et professeur)

## Technologies utilisées
- **Java 8** : Langage principal pour le développement
- **Eclipse IDE** : Environnement de développement intégré
- **PostgreSQL** : Base de données relationnelle pour la persistance des données
- **JDBC (Java Database Connectivity)** : Pour la gestion de la persistance des données
- **Git & GitHub** : Gestion de version et hébergement du projet

## Structure du projet
Le projet est organisé comme suit :

- **controllers** : Gère les contrôleurs qui relient les vues et la logique métier (ex. `AppController`, `LibraryController`).
- **dao** : Contient les interfaces pour l'accès aux données des documents et utilisateurs (`DocumentDao`, `BookDao`, etc.).
- **db** : Contient les classes pour la gestion de la connexion et des requêtes à la base de données (`DbConnection`, `DbRequest`) ainsi que pour la création des tables.
- **models** : Les classes représentant les modèles de données de l'application (`Book`, `Magazine`, `Student`, etc.).
- **services** : Responsable de l'implémentation des DAO, gérant les opérations CRUD avec PostgreSQL.
- **views** : Contient les classes liées à l'interface utilisateur console.
- **utils** : Classes utilitaires pour les opérations de base (ex. gestion de date dans `DateUtils`).

## Description brève de l'architecture adoptée
L'application suit une architecture MVC (Modèle-Vue-Contrôleur) :
- **Modèle** : Représente la structure de données (classes `Document`, `Livre`, `Magazine`, etc.).
- **Vue** : Interface utilisateur sous forme de menus interactifs en ligne de commande.
- **Contrôleur** : Relie les vues et les modèles, gère la logique métier et les actions utilisateur (classe `AppController`, `LibraryController`).

Les données sont gérées via PostgreSQL pour garantir la persistance. Le projet inclut des classes pour la création des tables et l'exécution de requêtes CRUD, assurant ainsi une gestion efficace des documents et des utilisateurs.

## Instructions d'installation et d'utilisation

### Prérequis
- **Java 8** ou version supérieure installée
- **PostgreSQL** pour la persistance des données
- **Git** pour la gestion des versions du projet

### Étapes pour configurer la base de données
1. Installer et configurer PostgreSQL.
2. Créer une base de données pour l'application.
3. Modifier les configurations dans la classe `DbConnection` pour ajouter vos paramètres de base de données.
4. Exécuter les scripts SQL dans le répertoire `db` pour créer les tables nécessaires.

### Comment lancer l'application
1. Clonez le dépôt Git :
   ```bash
   git clone https://github.com/JavaAura/BENFILL_S1_B2_gestionBiblio_V
   ```
2. Importez le projet dans Eclipse IDE.
3. Compilez et exécutez la classe principale `AppController.java`.
4. Suivez les instructions dans la console pour interagir avec l'application.

## Améliorations futures possibles
- **Interface utilisateur graphique** : Création d'une interface graphique avec JavaFX ou Swing pour rendre l'application plus conviviale.
- **Gestion des utilisateurs avancée** : Ajout des rôles supplémentaires et des permissions spécifiques à chaque rôle.
- **Statistiques et rapports** : Génération des rapports sur les emprunts, les retours et l'inventaire.

## Idées pour étendre ou améliorer le projet
- **Intégration avec des systèmes de gestion de bibliothèque tiers**.
- **Fonctionnalités d'import/export** pour permettre aux utilisateurs d'importer ou d'exporter les données de la bibliothèque sous forme de fichiers CSV ou JSON.
- **Recherche avancée** : Ajouter la possibilité de rechercher des documents avec des filtres avancés (par auteur, sujet, etc.).

## Auteur et contact
Développé par **Anass Benfillous**.  
Contact : [Benfianass@gmail.com]
