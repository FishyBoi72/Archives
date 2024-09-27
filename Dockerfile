# Use an official Node.js runtime as a parent image
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and install dependencies
# If you don't have a package.json yet, you can skip this step
COPY package*.json ./
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the port that your app runs on
EXPOSE 3000

# Command to run the app
CMD ["npx", "http-server", "-p", "3000"]
