(defproject ncp-service "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/spec.alpha "0.1.143"]
                 [io.pedestal/pedestal.service "0.5.3"]
                 [io.pedestal/pedestal.jetty "0.5.3"]
                 [io.pedestal/pedestal.log   "0.5.3"]
                 [org.clojure/tools.namespace  "0.2.11"]
                 ;; [io.pedestal/pedestal.immutant "0.5.3"]
                 ;; [io.pedestal/pedestal.tomcat "0.5.3"]

                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.22"]
                 [org.slf4j/jcl-over-slf4j "1.7.22"]
                 [org.slf4j/log4j-over-slf4j "1.7.22"]
                 [org.clojure/tools.logging "0.4.1"]
                 [http-kit "2.2.0"]
                 [cheshire "5.8.0"]]

  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :source-paths ["src" "dev"]
  :aliases {"rebl" ["trampoline" "run" "-m" "rebel-readline.main"]}
  ;; If you use HTTP/2 or ALPN, use the java-agent to pull in the correct alpn-boot dependency
  ;:java-agents [[org.mortbay.jetty.alpn/jetty-alpn-agent "2.0.5"]]
  :profiles {:dev {:extra-paths ["dev" "test"]
                   :aliases {"run-dev" ["trampoline" "run" "-m" "ncp-service.server/run-dev"]
                             "rebl" ["trampoline" "run" "-m" "rebel-readline.main"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.5.3"]
                                  [com.bhauman/rebel-readline "0.1.3"]]}
             :uberjar {:aot [ncp-service.server]}}
  :main ^{:skip-aot true} ncp-service.server)
