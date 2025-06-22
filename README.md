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
