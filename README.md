# Demonstration of building natively compiled command line tools with Clojure and GRAAL_VM 


## Build Clojure/GRAAL Docker Image

```docker build --rm -t clj-graal:1.10 .```

## Run build step

```build.sh```

## Run compiled executable

```./githubid <githubid>```


### Dependencies

The SSL implementation in Java is dependant on a native library 'libsunec.so'. It must be in the calling directory or somewhere in the PATH 

