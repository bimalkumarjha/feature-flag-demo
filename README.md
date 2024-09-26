# Feature Flag Management Demo

This Spring Boot application demonstrates a simple implementation of **Feature Flag Management**. Feature flags allow developers to toggle features on and off without deploying new code, enabling safer releases, A/B testing, and gradual rollouts.

## Table of Contents

- [Features](#features)
- [Endpoints](#endpoints)
- [Benefits](#benefits)
- [Getting Started](#getting-started)
- [Building the Project](#building-the-project)
- [Testing the Application](#testing-the-application)
- [Example Usage](#example-usage)
- [Contributing](#contributing)
- [License](#license)


## Features

- **Manage Feature Flags**: Create, read, and toggle feature flags using a RESTful API.
- **Role-Based Access Control**: Specify which user roles can access certain features.
- **Dynamic Control**: Enable or disable features in real-time without the need for application restarts or deployments.
- **Audit Logging**: Track changes to feature flags, including who made the change and when.
- **Scheduled Feature Flag Updates**: Automatically enable or disable feature flags based on a defined schedule for A/B testing.
- **Built with Spring Boot**: Utilizes Spring Boot for rapid development and ease of integration into existing microservices.



## Endpoints

- `GET /api/feature-flags`: Retrieve all feature flags.
  
- `GET /api/feature-flags/{name}`: Get the status of a specific feature flag.
  
- `POST /api/feature-flags`: Create a new feature flag.

  **Request Body Example:**
  ```json
  {
      "name": "newFeature",
      "enabled": true,
      "roles": ["admin", "user"]
  }
- GET /api/feature-flags/{name}/status: Check if a feature is enabled for specified user
- GET /api/feature-flags/newFeature/status?userRoles=admin,user
