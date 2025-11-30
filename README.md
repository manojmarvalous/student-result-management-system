# Student Result Management System

A **full-stack web application** to manage and view student results, built using **Spring Boot, Thymeleaf, MySQL, and Docker**, and deployed on **Render**.

---

## 🔗 Live Demo

Access the application here: [Student Result Management System](https://student-result-management-system1.onrender.com)

> **Note:** For testing, use the following demo credentials:
> Username: 'manoj'
> Password: '123'

Admin credentials are private and should not be shared.

---

## 🛠️ Technologies Used

* **Backend:** Spring Boot (Java 17), Spring Data JPA, Hibernate
* **Frontend:** Thymeleaf, HTML, CSS
* **Database:** MySQL (Clever Cloud)
* **Build & Deployment:** Maven, Docker, Render
* **Other:** HikariCP for connection pooling, Thymeleaf templates for views

---

## ⚙️ Features

* User authentication and login system
* Role-based access control (Admin / Student / Demo)
* View student results and dashboards
* CRUD operations for student records (Admin only)
* Responsive Thymeleaf-based UI
* Live deployment with secure environment variables
* Dockerized for easy deployment

---

## 🚀 Deployment Instructions

1. Clone the repository:

```bash
git clone <your-repo-link>
cd student-result-system
```

2. Build and run locally (optional):

```bash
mvn clean package
java -jar target/student-result-system-0.0.1-SNAPSHOT.jar
```

3. Environment Variables (for database connection):

```bash
JDBC_DATABASE_URL=jdbc:mysql://<host>:3306/<dbname>?useSSL=false&serverTimezone=UTC
JDBC_DATABASE_USERNAME=<username>
JDBC_DATABASE_PASSWORD=<password>
PORT=8080
```

4. Deploy on Render using Docker:

* Create a **new Web Service** on Render
* Connect to your GitHub repository
* Environment: **Docker**
* Add the above environment variables
* Render automatically builds the Docker image and runs the app

---

## 📂 Project Structure

```
student-result-system/
 ├─ src/
 │   ├─ main/java/...          ← Java packages
 │   ├─ main/resources/
 │       ├─ application.properties
 │       ├─ templates/         ← Thymeleaf HTML files
 │       └─ static/            ← CSS/JS files
 ├─ pom.xml
 └─ Dockerfile
```

---

## 🔑 Demo Credentials

| Username | Password | Role    |
| -------- | -------- | ------- |
| demo     | demo123  | STUDENT |

> Use these credentials for testing the app without accessing admin account.

---

## 📈 Future Enhancements

* Role-based dashboards (Admin / Teacher / Student)
* PDF export of results
* Automated email notifications
* Improved UI/UX with Bootstrap or Material UI

---

## 💡 Notes

* Make sure to **never share admin credentials** publicly.
* Database connection must be secured via **environment variables**.
* The Dockerfile ensures the app can run anywhere with Docker installed.

---

## 📝 Author

**MULINTI Manoj**
Engineering Student, Santhiram Engineering College
Email: [marvalousmanoj@gmail.com](mailto:marvalousmanoj@gmail.com)
Phone: +91 8309429711

---


