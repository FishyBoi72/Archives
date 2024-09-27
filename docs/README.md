# To-Do List Application

This repository contains a simple To-Do List application implemented in JavaScript. The application allows users to add, view, and remove tasks through a user-friendly interface. Additionally, this repository includes a GitHub Actions workflow to automate the CI/CD process, building and deploying the application to DockerHub.

## Purpose of Workflows

The purpose of the GitHub Actions workflows is to automate the following tasks:

1. **Continuous Integration (CI)**:
   - Build the Docker image for the To-Do List application.
   - Run tests (if applicable) to ensure code quality.

2. **Continuous Deployment (CD)**:
   - Push the built Docker image to DockerHub for deployment.

## Workflow Steps

The workflow consists of several steps, each of which is defined in the `.github/workflows/main.yml` file.

### 1. Checkout Code

This step checks out the code from the repository so that the subsequent steps can access the application files.

```yaml
- name: Checkout code
  uses: actions/checkout@v2

2. Set Up Docker Buildx
This step sets up Docker Buildx, which allows you to build multi-platform images.
- name: Set up Docker Buildx
  uses: docker/setup-buildx-action@v2

3. Login to DockerHub
In this step, the workflow logs in to DockerHub using credentials stored as GitHub Secrets to ensure secure access.
- name: Login to DockerHub
  uses: docker/login-action@v2
  with:
    username: ${{ secrets.DOCKER_USERNAME }}
    password: ${{ secrets.DOCKER_PASSWORD }}

4. Build Docker Image
This step builds the Docker image for the application using the Dockerfile present in the root directory.
- name: Build Docker image
  run: |
    docker build -t your-dockerhub-username/your-app:latest .

5. Push Docker Image to DockerHub
The final step in the workflow pushes the built Docker image to DockerHub, making it available for deployment.
- name: Push Docker image to DockerHub
  run: |
    docker push your-dockerhub-username/your-app:latest
