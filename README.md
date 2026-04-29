# 🌳 Tree Visualization Project

## 📌 Overview

This project is a Java application that visualizes operations on tree data structures:

* Generic Tree
* Binary Tree
* Red-Black Tree

The goal is to help users understand how tree operations work through **step-by-step animation**.

---

## ✨ Features (Current)

* Binary Tree visualization
* Inorder traversal (step-by-step)
* Node highlighting during traversal
* Basic animation engine (StepPlayer)

---

## 🧠 Project Architecture

The project follows a layered design:

```
User → UI → Controller → Algorithm → Engine → UI
                      ↓
                    Core
```

---

## 📦 Components

### 🧱 `core/` — Data Structures

Handles tree logic and data storage.

**Contains:**

* `Node`
* `BinaryTree`
* (future) `GenericTree`, `RedBlackTree`

**Responsibilities:**

* Insert, delete, search
* Maintain tree structure

**Rules:**

* No UI code
* No JavaFX
* No Step logic

---

### ⚙️ `algorithm/` — Step Generation

Converts operations into step-by-step instructions.

**Contains:**

* `Step`
* `TraversalAlgorithm`

**Example:**

```java
List<Step> inorderSteps(Node root);
```

**Responsibilities:**

* Generate steps for visualization

---

### 🎬 `engine/` — Step Player

Executes steps over time.

**Contains:**

* `StepPlayer`

**Responsibilities:**

* Play steps sequentially
* Control animation timing

---

### 🖥️ `ui/` — User Interface

Handles everything the user sees.

**Contains:**

* `MainScreen`

**Responsibilities:**

* Draw tree
* Handle button clicks
* Display step descriptions

---

### 🎨 `visual/` (future)

Handles layout and positioning.

**Responsibilities:**

* Compute node positions
* Improve tree readability

---

### 🔗 `controller/` (future)

Connects UI with logic.

**Responsibilities:**

* Coordinate between layers
* Keep UI clean

---

### 🚀 `Main.java`

Entry point of the application.

---

## 🔥 Dependency Rule

```
core → algorithm → engine → controller → ui
           ↘ visual ↗
```

Lower layers must NOT depend on higher layers.

---

## 🛠️ Installation & Setup

### 1. Clone the repository

```bash
git clone <your-repo-url>
```

---

### 2. Install Java

Make sure you have:

* Java 21 (recommended)

---

### 3. Download JavaFX

Download from:
https://gluonhq.com/products/javafx/

---

### 4. Setup JavaFX

#### Step A — Place JavaFX

Extract and place inside project:

```
TreeVisualization/lib/javafx-sdk-21/
```

---

#### Step B — Add to Eclipse

* Right-click project → Build Path → Configure Build Path
* Libraries → Add JARs
* Select all `.jar` files from:

```
lib/javafx-sdk-21/lib/
```

Make sure they are added to **Modulepath**

---

#### Step C — Set VM options

Go to:
Run → Run Configurations → Your Main class

Add:

```bash
--module-path "lib/javafx-sdk-21/lib" --add-modules javafx.controls,javafx.fxml
```

---

### 5. Run the project

Run:

```
Main.java
```

---

## ⚠️ Notes

* The `lib/` folder is ignored in Git (JavaFX must be installed manually)
* All teammates must configure JavaFX locally

---

## 👥 Team Workflow

Each member should focus on a specific module:

| Role      | Responsibility      |
| --------- | ------------------- |
| Core      | Tree structures     |
| Algorithm | Step generation     |
| Engine    | Animation playback  |
| UI        | Interface & drawing |
| Visual    | Layout (optional)   |

---

## 📈 Future Improvements

* Preorder & Postorder traversal
* Red-Black Tree visualization
* Pause / Resume controls
* Step-by-step navigation
* Better layout system
* Code highlighting panel

---

## 💬 Summary

This project demonstrates:

* Object-Oriented Design
* Separation of concerns
* Visualization of algorithms
* Team-based software architecture

---
