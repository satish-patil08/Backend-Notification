pipeline {
  agent any
  stages {
    stage('Generate Jar Files') {
      steps {
        sh '''mvn clean install'''
      }
    }
    stage('Delete the old containers') {
      steps {
        sh '''sudo systemctl stop backend-notification
        sudo rm -rf /var/lib/jenkins/backend/service-registry/*
        sudo cp -r target/*.jar /var/lib/jenkins/backend/backend-notification/
        sudo chown -R azureuser:azureuser /var/lib/jenkins/backend/backend-notification/
        sudo mv /var/lib/jenkins/backend/backend-notification/*.jar /var/lib/jenkins/backend/backend-notification/app.jar'''
      }
    }
    stage('Run the updated dockers') {
      steps {
        sh '''sudo systemctl start backend-notification'''
      }
    }
  }
}
