# urlshort
Java (spring) backend for shortening urls by redirecting.
Caches on redirect using Redis for improved performance.

# Prerequisites
- Java 21
- Docker
- docker-compose

# Getting started
Run `docker compose up` in the root directory to start the MySQL and Redis containers.
Run the application either by running the main class from within Intellij, or using the mvn wrapper.

# Usage
Save a url pair using the `/save` endpoint, then, assuming the application is running locally, go to `localhost:8080/your-saved-short-url`. You will be redirected to whatever url you saved to be mapped to the short one.