# 🚨 Urban Emergency Service System

This project implements a **Urban Emergency Service System** using **Java**, developed as part of the *Data Structures* course in the **Information Systems degree**.

The system simulates a real-world emergency call center, applying fundamental data structures to manage and prioritize service requests efficiently.

## 📖 Overview

The system is responsible for handling urban emergency calls such as power outages, gas leaks, floods, and fires.

It demonstrates the practical application of different data structures, each chosen according to its behavior and performance characteristics.

According to the project specification :contentReference[oaicite:0]{index=0}, the system must:
- Organize calls by arrival order
- Prioritize urgent cases
- Maintain a full history of requests
- Track active services
- Generate analytical reports

## 🧩 Data Structures Used

- **Queue (FIFO)** → Manages regular calls  
- **Stack (LIFO)** → Handles high-priority emergency calls  
- **Linked List** → Stores call history  
- **ArrayList (Linear List)** → Tracks active services and rankings  

## ⚙️ System Rules

- Calls with urgency **≥ 4** are treated as emergencies and pushed to the stack  
- Calls with urgency **< 4** are added to the queue  
- Every call is stored in the history  
- Emergency calls are always handled first  
- Active calls are stored in a linear list  
- Completed calls are removed from active list and marked as finished in history  

These rules follow the specification described in the project document :contentReference[oaicite:1]{index=1}.

## 📊 Features

- Register new calls  
- Process calls based on priority  
- Finalize calls with status update  
- Generate reports:
  - Total calls per neighborhood  
  - Ranking of most problematic neighborhoods  
  - Average urgency level  
  - Pending calls  

## 🏗️ Data Model

### Class: `Chamado` (Call)

- `id`  
- `bairro` (neighborhood)  
- `descricao`  
- `nivelUrgencia` (1–5)  
- `status` (OPEN, IN_PROGRESS, FINISHED)  

## 🧪 Simulation

The system supports simulation scenarios with:
- Regular and emergency calls
- Priority-based processing
- Analysis of service order and fairness

As described in the project requirements, the implementation allows evaluating:
- Real order of execution
- Starvation possibility (common calls waiting too long)
- Fairness of the system

## 🎯 Objectives

- Apply core data structures in a real-world scenario  
- Understand FIFO vs LIFO behaviors in practice  
- Analyze trade-offs between different structures  
- Implement manual sorting algorithms  
- Strengthen problem-solving and system modeling skills  

## 🛠️ Tech Stack

- **Language:** Java  
- **Concepts:** Data Structures, Algorithms, OOP  

## 📌 Academic Context

This project was developed throughout my **Information Systems degree**, combining academic requirements with practical implementation of data structures and algorithms.

## 🔗 Repository

👉 https://github.com/Henrique8000/Projeto-1-Estrutura-De-Dados/tree/main
