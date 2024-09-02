# Survival-Game

Java 2D Game Project

## Overview:

This project is a basic 2D game developed in Java. The game features a player that must dodge enemies on the screen while managing health and score. The game includes several enemy types, a player character, a heads-up display (HUD), and a simple game loop.

**Features:** 

- Player Movement: The player can move using the arrow keys.
- BasicEnemy: Moves at a constant speed and bounces off walls.
- FastEnemy: Moves quickly and changes direction upon hitting walls.
- EnemyBoss: A boss enemy that releases bullets and changes its behavior over time.
- HUD: Displays the player's health, score, and level.
- Menu System: Includes options to start the game, access help, and exit.
- Game States: Manage different game modes like Menu, Game, Help, and End.

## Classes
- Game: The main game class that contains the game loop, handles rendering, and manages game states.
- Player: Represents the player character, handles movement, and detects collisions with enemies.
- BasicEnemy, FastEnemy, EnemyBoss, EnemyBossBullet: Represent different types of enemies with unique behaviors.
- HUD: Displays the player's health, score, and level.
- Handler: Manages and updates all game objects.
- Menu: Handles the game's menu and its interactions.
- Window: Creates the game window and initializes the game.

## How to Play
**Starting the Game:**
Run the game and the main menu will appear.
Use the mouse to click "Play" to start the game.
**Controls:**
Use the arrow keys to move the player character.
Dodge the enemies to avoid losing health.

**Objective:**
Survive as long as possible while accumulating a high score.
Your score increases over time and with levels.
Boss fight appears once you get to level 10

**Game Over:**
If your health reaches zero, the game will end and your score will be displayed.
You can choose to retry or exit from the game over screen.
