## Creating Docker Image
Below command will create a docker image for you. Installation steps and any configurations related to docker is beyond the scope of this documentation.

```sh
docker -t sprintbook:dev -f docker.d/sprintbook.Dockerfile ./
```
## Helm Chart for SprintBook

"springbook-chart" is a sample chart that can be used to deploy SprintBook image on kubernetes enviroment.

```sh
helm upgrade --install sprintbook-platform . \
--namespace sprintbook --create-namespace \
--values values.yaml
```


## Conclusion

You have now learned how to create, run, and manage Docker images and containers. This guide provides the basic commands, but you can explore more Docker features as needed.

