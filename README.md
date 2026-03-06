# JavaStock — JDBC Inventory Management System 📦
### Study Project: Data Persistence & Graphical User Interface (Java)

![Status](https://img.shields.io/badge/status-active-blue)
![Type](https://img.shields.io/badge/project-study-orange)
![Stack](https://img.shields.io/badge/stack-Java%20Desktop-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

**JavaStock** is an individual project focused on implementing a robust CRUD (Create, Read, Update, Delete) system. The main objective was to apply advanced **Java Database Connectivity (JDBC)** concepts and the **DAO (Data Access Object)** design pattern to manage product inventory in a persistent and professional manner.

This project demonstrates the transition from volatile data (in-memory) to permanent data stored in a relational database.

---

## 🎯 **Project Goals**

- **Real Persistence:** Implement a secure connection between Java and SQLite.
- **Clean Architecture:** Decouple the Interface logic (GUI) from the Data Access logic (DAO).
- **Reactive Interface:** Create a JavaFX UI that automatically syncs after every database operation.
- **Data Security:** Utilize `PreparedStatement` to protect the application against SQL Injection attacks.
- **Resource Management:** Ensure proper closing of connections and statements to prevent memory leaks.

---

## 🛠️ **Technologies Used**

### **Core Development**
- **Java 17+**: Main programming language.
- **JDBC (Java Database Connectivity)**: For database engine communication.
- **SQLite**: Lightweight, local relational database management system.

### **Frontend (GUI)**
- **JavaFX**: For building windows, tables, and forms.
- **CSS**: Custom styling for an enhanced user experience.
- **ObservableLists**: For real-time data binding with the `TableView`.

### **Patterns & Tools**
- **DAO Pattern**: For isolating persistence logic.
- **Git & GitHub**: For version control.
- **Visual Studio Code / IntelliJ**: Preferred development environments.

---

## 📦 **Core Features**

### 🔹 **1. Product Management (CRUD)**
- **Add:** Insert new products with field validation.
- **List:** Dynamic table visualization with automatic column resizing.
- **Update:** Modify existing product information directly in the database.
- **Delete:** Safely remove records by ID.

### 🔹 **2. Intelligent Interface**
- **Table Selection:** Clicking a product in the list automatically populates the editing fields.
- **Price Handling:** Automatic replacement of commas with dots to ensure `Double` value compatibility.
- **Inventory Status:** Categorize products via ComboBox (e.g., Normal Stock / Low Stock).

### 🔹 **3. SQL Automation**
- Automatic creation of the product table on startup if it doesn't exist.
- Automated ID management (Primary Key / Autoincrement).

---

## 🧩 **Architecture Overview**

The project is divided into layers to follow the **Single Responsibility Principle**:

- **`Produto.java`**: The Model (POJO) representing the real-world object.
- **`ProdutoDAO.java`**: The "SQL Brain." Contains `insert`, `update`, `list`, and `delete` methods.
- **`ConexaoDB.java`**: Centralizes the `DriverManager` to open and manage the connection to the `.db` file.
- **`ProdutoGUI.java`**: Manages buttons, events, and the visual presentation (JavaFX).



---
