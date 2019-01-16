# Demonstration of building natively compiled command line tools with Clojure and GRAAL_VM 

## Pull build container 

```docker pull gaberger/clj-graal:1.10```

or

## Build Clojure/GRAAL Docker Image

```docker build --rm -t clj-graal:1.10 .```

## Run build step

```build.sh```

or

## Do it manually

```docker run --rm -it -v `pwd`:/<dirname> -v ~/.m2:/root/.m2 -v ~/.gitlibs:/root/.gitlibs  -w=/<dirname> -e GRAALVM_HOME=/opt/graalvm-ce-1.0.0-rc10  <clj-graal:1.10> clojure -A:native-image```

## Run compiled executable

```./githubid <githubid>```


### Dependencies

The SSL implementation in Java is dependant on a native library 'libsunec.so'. It must be in the calling directory or somewhere in the PATH 

