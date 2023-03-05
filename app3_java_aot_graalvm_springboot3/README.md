Spring boot application, which can be built as a native-image.

# TODO
Make the app return the current time
Make the app a lambda

# Examples


## first build as native image
https://spring.io/blog/2022/09/26/native-support-in-spring-boot-3-0-0-m5


## example aws lambda with GraalVM
https://www.formkiq.com/blog/tutorials/aws-lambda-graalvm/

## making the applicaiton - a lambda handler
https://docs.spring.io/spring-cloud-function/docs/current/reference/html/aws-intro.html


## Deployment as Lambda
https://docs.aws.amazon.com/lambda/latest/dg/java-image.html






# Requirements

OS: Ubuntu 22.04

## install SDKman - a tool to manage SDKs, needed to install right java version

### install sdkman
```
curl -fsSL "https://get.sdkman.io?rcupdate=false" | bash
```

### add to path in current session
```
source ~/.sdkman/bin/sdkman-init.sh
```

### adding sdkman to the path
```
echo "source ~/.sdkman/bin/sdkman-init.sh" >> ~/.bashrc
```




## install the open version of GraalVM
```
sdk install java 22.3.r17-nik < /dev/null
```


## When building native-images on Ubuntu 22.04 

to avoid error ```"/usr/bin/ld: cannot find -lz: No such file or directory"```

install the missing lib
as in https://stackoverflow.com/questions/3373995/usr-bin-ld-cannot-find-lz

```
sudo apt-get install zlib1g-dev
```


# Build a native-image

```
cd app3_java_aot_graalvm_springboot3
./gradlew nativeCompile --stacktrace
```

And find your native-image in ```build/native/nativeCompile/demo``` location.


# Start the native-image


```
build/native/nativeCompile/demo
```



