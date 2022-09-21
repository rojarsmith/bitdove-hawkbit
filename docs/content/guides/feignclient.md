---
title: Feign Client
parent: Guides
weight: 32
---

In this guide we describe how to create a [Feign](https://github.com/Netflix/feign) Rest Client based on a  [Spring Boot](http://projects.spring.io/spring-boot/) Application. 
<!--more-->

## Create Feign REST Client
Bitdove provides REST interfaces for [Management API]() and [DDI API](). Using this interfaces you can create a feign client with the help of the [feign inheritance support](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign-inheritance).

## Example Management API simulator

In the follow code section, you can a see a feign client resource example. The interface extend the origin api interface to declare the `@FeignClient`. The `@FeignClient`declares that a REST client with that interface should be created. 

```Java
@FeignClient(url = "${bitdove.url:localhost:8080}/" + MgmtRestConstants.TARGET_V1_REQUEST_MAPPING)
public interface MgmtTargetClientResource extends MgmtTargetRestApi {
}
```

This interface can be autowired and use as a normal java interface:

```Java
public class CreateStartedRolloutExample {

    @Autowired
    private MgmtTargetClientResource targetResource;


    public void run() {
        // create ten targets
        targetResource.createTargets(new TargetBuilder().controllerId("00-FF-AA-0").name("00-FF-AA-0")
                .description("Targets used for rollout example").buildAsList(10));
    }

```
