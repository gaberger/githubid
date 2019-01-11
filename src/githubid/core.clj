(ns githubid.core
  (:require [clj-http.lite.client :as http]
            [clojure.string :as str]
            [cheshire.core :refer :all])
  (:gen-class))

(set! *warn-on-reflection* 1)

(defn print-error-and-exit [msg]
  (binding [*out* *err*]
    (println msg))
  (System/exit 1))

(defn get-github-keys [ghid]
  (let [api (str/join "/" ["https://api.github.com/users" ghid "keys"])
        {:keys [status headers body error] :as resp} (http/get api {:throw-exceptions false})]
    (if error
      (print-error-and-exit (str "Error:" error))
      (let [result (condp = status
                     404 (print-error-and-exit (str "Error Github ID " ghid " not found"))
                     200 (let [ssh-id (map  (fn [{:keys [id key]}]
                                              (format "%s %s@github/%s #ssh-import gh:%s" key ghid id ghid))
                                            (parse-string body true))]
                           ssh-id)

                     "Unhandled error")]
        (println (str/join result))))))

(defn -main [& args]
  (System/setProperty "java.library.path"
                      (str (System/getenv "GRAALVM_HOME") "/jre/lib/amd64"))
  (if (< (count args) 1)
    (print-error-and-exit "Usage: githubid <github-id>")
    (get-github-keys (first args))))
