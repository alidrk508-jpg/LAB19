# RoomMVVMDemo 📝

Une application Android de gestion de notes simple et robuste, conçue pour démontrer l'implémentation de l'architecture **MVVM** (Model-View-ViewModel) avec la bibliothèque de persistance **Room**.

## 🚀 Fonctionnalités
- **Ajout de notes** : Enregistrement persistant du titre et de la description.
- **Affichage en temps réel** : Utilisation de `LiveData` pour mettre à jour la liste automatiquement.
- **Suppression individuelle** : Clic long sur une note pour la supprimer.
- **Suppression globale** : Bouton dédié pour vider toute la base de données.
- **Design Moderne** : Interface basée sur **Material Design 3** avec des composants stylisés.

## 🏗️ Architecture
L'application suit les principes recommandés par Google pour le développement Android moderne :

- **Model (Room)** : Gère la base de données SQLite locale de manière abstraite.
- **Repository** : Centralise l'accès aux données (médiateur entre ViewModel et Room).
- **ViewModel** : Prépare et expose les données pour l'UI, survit aux changements de configuration.
- **View (Activity/Adapter)** : Affiche les données et capture les interactions utilisateur.

> [!NOTE]
> **Signature Personnalisée** : Toutes les variables, IDs de ressources et méthodes clés utilisent le préfixe `drk_` pour l'identification du code.

## 🛠️ Stack Technique
- **Langage** : Java
- **Base de données** : [Room Persistence Library](https://developer.android.com/training/data-storage/room)
- **Composants d'Architecture** : ViewModel, LiveData
- **UI** : RecyclerView, CardView, Material Components
- **Thread Management** : ExecutorService (SingleThreadExecutor)

## 📸 Démo
<!-- PLACEHOLDER POUR DÉMO -->
### Aperçu
> *Insérez ici un GIF ou des captures d'écran de l'application en action.*
> 
> ![Placeholder Demo](demo/demo.gif)

---

## ⚙️ Installation
1. Clonez le dépôt.
2. Ouvrez le projet dans **Android Studio**.
3. Assurez-vous d'avoir le SDK 36 installé (ou ajustez le `compileSdk` dans `build.gradle`).
4. Lancez sur un émulateur ou un appareil physique.

---
Développé avec ❤️ par [ali darkaoui]
