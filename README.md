# Feature Flag Management Demo

This Spring Boot application demonstrates a simple implementation of **Feature Flag Management**. Feature flags allow developers to toggle features on and off without deploying new code, enabling safer releases, A/B testing, and gradual rollouts.

## Table of Contents

- [Features](#features)
- [Endpoints](#endpoints)
- [Benefits](#benefits)
- [Getting Started](#getting-started)
- [Building the Project](#building-the-project)
- [Testing the Application](#testing-the-application)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Manage Feature Flags**: Create, read, and toggle feature flags using a RESTful API.
- **Dynamic Control**: Enable or disable features in real-time without the need for application restarts or deployments.
- **Built with Spring Boot**: Utilizes Spring Boot for rapid development and ease of integration into existing microservices.

## Endpoints

- `GET /api/feature-flags`: Retrieve all feature flags.
- `GET /api/feature-flags/{name}`: Get the status of a specific feature flag.
- `POST /api/feature-flags/{name}/toggle`: Toggle the state of a specific feature flag.

## Benefits

- **Improved Deployment Practices**: Reduce the risk of deploying new features by testing them with a small subset of users first.
- **User Experience Optimization**: Gather user feedback on new features before a full rollout.
- **Version Control**: Easily manage different feature versions and configurations without code changes.

## Getting Started

1. Clone the repository:
   ```bash
   git clone <repository-url>
