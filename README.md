# urlshort
Java (spring) backend for shortening urls

# Prerequisites
- Java 21
- Docker
- docker-compose

# Getting started
Run `docker compose up` in the root directory to start the database container.
Run the application either by running the main class from within Intellij, or using the mvn wrapper.

# Usage
Save a url pair using the `/save` endpoint, then, assuming the application is running locally, go to `localhost:8080/your-saved-short-url`. You will be redirected to whatever url you saved to be mapped to the short one.