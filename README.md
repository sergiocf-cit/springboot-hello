# springboot-hello
Simple project unsing Springboot, containerized and Kubernetes

## Build Project
`./mvnw install`

## Containerization
### Build the image locally
`docker build -t sergio/demo .`

### Run the image locally
`docker run -p 8080:8080 sergio/demo`

### Build the image on amd64 and push to Azure Container Registry
`docker buildx build --platform linux/amd64 -t crmultitenant.azurecr.io/sergio/demo:latest --push .`


#TO DO
auto scaler
canary release per percentage