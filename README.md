//E-Voting System Project Directory Structure

src/main/java/com/evoting
├── controller
│   ├── AuthController.java        # Handles register and login endpoints
│   └── TestController.java        # Protected endpoints for testing roles
│
├── model
│   └── User.java                  # Model class for user credentials and role
│
├── security
│   ├── JwtUtil.java               # Generates and validates JWT tokens
│   ├── JwtAuthFilter.java         # Intercepts and authenticates JWT from requests
│   └── SecurityConfig.java        # Spring Security configuration
│
├── service
│   └── InMemoryService.java       # In-memory user store and UserDetailsService
│
└── EvotingApplication.java        # Main Spring Boot application


--http://localhost:8080/api/public/hello :-> For public api accessible for all.

Test via Postman:
--POST http://localhost:8080/api/auth/login to get the token.
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
-> RETURNS Token 

->Use the token to access:

/api/secure/user (for role: USER or ADMIN)

/api/secure/admin (only ADMIN)
Authorization: Bearer eyJhbGciOi...

