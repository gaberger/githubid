(ns githubid.test
  (:require [clojure.test :refer :all]
            [com.rpl.specter :refer :all]
            [githubid.core :refer [get-github-keys]]))


(deftest test-github-id
  (is (= "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDBcYVYR+rqPdDJHYOSgiIjj1OrtQEFeytgVO3wuKojUXGbUEyjmDuGrh+H2GuLmW+WMmO7tSRQSUo5rlNaQL4bhE3Lf4oy7PPkEp3zyjhCKUKZwdjDKWpLmrcYDRE+Y6x9UgjVRv0fQGSjBliXb1I0YH7ijcoxFP98kip6JWrPTWvbL6tZ/zJajCz2Ycr91JP7jobNEhL20495K7h4VsH5oaIVviQHjJQYQ1zkYW5Uu7mC8e76Mdzgs8nJMzG/lYQjigWTNWbyEjQP0S9lBqwQoERf9RtILYF6t4mK2R7NbZFDYP79XtJhD61QVit3tRFqPmywVSbBue+PqfSUDh0F gaberger@github/9881028 #ssh-import gh:gaberger"
         (prn-str (get-github-keys "gaberger")))))         
  