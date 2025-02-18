## SprintBook Layered Approach

Spring Boot API project is divided into multiple layers keeping seperation of concern. Each layer has its own responsibility to deal with. Controler-> Service-> Repository -> Entities (Models).
Introduced DTO that will be mapped by the service on relevant entities/models object to have loose coupling. Code is in impl/SprintBook folder. Project is setup using maven. I covered Dockerization, Jenkins Pipeline and deployment to Kubernetes using helm chart.

```sh
impl/SprintBook
```

## Creating Docker Image
Below command will create a docker image for you. Installation steps and any configurations related to docker is beyond the scope of this documentation.

```sh
docker -t sprintbook:dev -f docker.d/sprintbook.Dockerfile ./
```

## Jenkins Pipeline to Build Image
"jenkinsFile" is for running pipeline responsible to create Docker image and Pushed the newly created image into a private dockerhub repository. build will process on node having a special label "sprintbook-OnBuild" on it. This will help us to avoid creating build on random nodes. Process of pipeline is simple to start with but can be complex like before pushing dockerhub image that image can be used to run testcases before pushing it to hub.



## Helm Chart for SprintBook

"springbook-chart" is a sample chart that can be used to deploy SprintBook image on kubernetes enviroment.

```sh
helm upgrade --install sprintbook-platform . \
--namespace sprintbook --create-namespace \
--values values.yaml
```


## Conclusion

Topics covered are project intro, Docker file, Jenkins Pipeline to build, run tests and push image on successfull results. A sample helmchart that can be used to deploy this image in kubernetes enviroment.
