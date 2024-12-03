# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the Java program (if you have .java files)
RUN javac YourProgram.java

# Command to run the application
CMD ["java", "YourProgram"]
