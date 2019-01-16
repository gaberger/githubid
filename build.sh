#!/bin/bash
dname=$(basename `pwd`)

docker run --rm -it -v `pwd`:/${dname} -v ~/.m2:/root/.m2 -v ~/.gitlibs:/root/.gitlibs  -w=/${dname} -e GRAALVM_HOME=/opt/graalvm-ce-1.0.0-rc10  gaberger/clj-graal:1.10 clojure -A:native-image
