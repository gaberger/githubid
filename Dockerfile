FROM oracle/graalvm-ce:1.0.0-rc10
RUN yum -y  update
RUN yum install -y sudo rlwrap 
RUN curl -O https://download.clojure.org/install/linux-install-1.10.0.411.sh && chmod +x linux-install-1.10.0.411.sh && sudo ./linux-install-1.10.0.411.sh
RUN clojure -e "(println \"Clojure tools installed\")"

