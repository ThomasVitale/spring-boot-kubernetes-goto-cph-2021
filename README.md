# Cloud Native with Spring Boot and Kubernetes (GOTO Copenhagen 2021)

Source code and examples from my presentation "Cloud Native with Spring Boot and Kubernetes" at Devoxx UK 2021

Demonstration of:

- Cloud native development with Spring Boot and Reactive Spring
- Containerization with Cloud Native Buildpacks
- Kubernetes deployment manifests, graceful shutdown, and health probes
- Spring Boot configuration through ConfigMaps
- Native executables with Spring Native and GraalVM
- Serverless applications on Knative

## Prerequisites

To run all the examples, you need to install the following tools:

* [Java 17](https://adoptium.net)
* [Docker](https://www.docker.com)
* [Kubernetes CLI](https://kubernetes.io/docs/tasks/tools/)
* [kind](https://kind.sigs.k8s.io/docs/)

Recommended tools:

* [Octant](https://octant.dev)
* [Knative CLI](https://knative.dev/docs/client/)

## Usage

Both Spring Boot applications can be run locally with this command:

```shell
$ ./gradlew bootRun
```

You can containerize them via Buildpacks. Demo Service will be containerized as a JVM image, whereas Demo Native will be containerized as a Native image.

```shell
$ ./gradlew bootBuildImage
```

## Deployment on a local Kubernetes cluster

You can spin up a Kubernetes cluster as follows:

```shell
$ ./kind/create-cluster.sh
```

Then, deploy Demo Service with kubectl:

```shell
$ kubectl apply demo-service/k8s
```

When you're done, you can destroy the cluster as follows:

```shell
$ ./kind/destroy-cluster.sh
```

## Deployment on a local Kubernetes cluster with Knative

You can spin up a Kubernetes cluster with Knative as follows:

```shell
$ ./kind/install-knative.sh
```

Then, deploy Demo Native with kubectl:

```shell
$ kubectl apply demo-service/knative
```

When you're done, you can uninstall the cluster as follows:

```shell
$ ./kind/uninstall-knative.sh
```

## Other

If you're looking for an open-source Kubernetes-based platform, you might want to try [https://tanzucommunityedition.io](VMware Tanzu Community Edition), which is the one I used for the presentation.
