# Children Transportation System 🚍👦👧

A web-based application for managing transportation services for children, including managing passengers, vehicles, routes, payments, and mechanics. The system provides CRUD operations and is designed using **Spring Boot** for the backend and **Bootstrap** for the frontend.

---

## Features ✨

- **Passenger Management**: Add, edit, delete, and view passenger details. 🧑‍🦱📋
- **Vehicle Management**: Manage vehicle details (plate number, type, capacity). 🚗💨
- **Route Management**: Manage routes with starting points and destinations. 🗺️🚏
- **Payment Management**: Handle payment records for transportation services. 💸
- **Mechanic Management**: Manage mechanic details to ensure vehicle maintenance. 🔧🛠️
- **Frontend**: Responsive Bootstrap-based UI. 💻📱

---

## Tech Stack ⚙️

**Backend:**
- Spring Boot 🚀
- Spring Data JPA 🗄️
- Hibernate 🔄
- RESTful APIs 🌐
- Swagger for API documentation 📑
- Postman Collection for API testing 🧪
- Transaction Management 💼

**Frontend:**
- HTML 🌐
- Bootstrap 💅
- JavaScript 💻

**Database:**
- MySQL (or preferred relational database) 🗄️



---

## Getting Started 🚀

Follow these steps to set up the project locally:

### 1. Clone the repository:

```bash

---
git clone https://github.com/yourusername/children-transportation-system.git
cd children-transportation-system

mvn clean install
mvn spring-boot:run
---
```

### 2. YouTube video:

https://youtu.be/DtU0kn999UU?feature=shared



## 3. Frontend 🌟:
The frontend files are located in the src/main/resources/static directory. You can open the HTML files directly in your browser or deploy them using a web server. 🌍

**API Endpoints:**
## API Endpoints 📡
The application exposes the following REST API endpoints:

1. Passenger API 🧑‍🦱
   POST /api/passengers: Add a new passenger 📝

- GET /api/passengers: Get all passengers 👥

- GET /api/passengers/{id}: Get a passenger by ID 🔍

- PUT /api/passengers/{id}: Update a passenger ✏️

- DELETE /api/passengers/{id}: Delete a passenger 🗑️

2. Vehicle API 🚗
   POST /api/vehicles: Add a new vehicle 🚙

- GET /api/vehicles: Get all vehicles 🚘

- GET /api/vehicles/{id}: Get a vehicle by ID 🔎

- PUT /api/vehicles/{id}: Update a vehicle 🛠️

- DELETE /api/vehicles/{id}: Delete a vehicle ❌

3. Route API 🛣️
   POST /api/routes: Add a new route 🛤️

- GET /api/routes: Get all routes 🗺️

- GET /api/routes/{id}: Get a route by ID 🔍

- PUT /api/routes/{id}: Update a route ✏️

- DELETE /api/routes/{id}: Delete a route 🗑️

4. Payment API 💳
   POST /api/payments: Add a new payment 💸

- GET /api/payments: Get all payments 💰

- GET /api/payments/{id}: Get a payment by ID 🔍

- PUT /api/payments/{id}: Update a payment ✏️

- DELETE /api/payments/{id}: Delete a payment 🗑️

5. Mechanic API 🔧
   POST /api/mechanics: Add a new mechanic 🛠️

- GET /api/mechanics: Get all mechanics 🔍

- GET /api/mechanics/{id}: Get a mechanic by ID 👨‍🔧

- PUT /api/mechanics/{id}: Update a mechanic ✏️

- DELETE /api/mechanics/{id}: Delete a mechanic 🗑️

**Testing with Postman 🧪:**
You can use the provided Postman Collection to test the API endpoints. Import the collection into Postman and run the requests to interact with the system. 🚀

**Example Database Schema 📊:**
Here’s a simple example of the database schema:

### Passenger 🧑‍🦱

- Field	Type
- id	Long
- name	String
- age	Integer
- school	String
- pickupLocation	String

### Vehicle 🚗

- Field	Type
- id	Long
- plateNumber	String
- type	String
- capacity	Integer
- driverName	String

### Route 🛣️

- Field	Type
- id	Long
- routeName	String
- startingPoint	String
- destination	String

### Payment 💳

- Field	Type
- id	Long
- amount	Double
- paymentDate	String
- passengerId	Long

### Mechanic 🔧

- Field	Type
- id	Long
- name	String
- contactNumber	String
- serviceType	String
## Contributing 🤝
Feel free to fork this project, create a new branch, and submit a pull request. Contributions are welcome! 🌟

## License 📜
This project is licensed under the MIT License.

## Acknowledgments 🙏
- Bootstrap for the UI framework.

- Spring Boot for the backend framework.

- MySQL for the database.


