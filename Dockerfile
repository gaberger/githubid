FROM clojure:tools-deps
COPY . /usr/src/app
WORKDIR /usr/src/app
CMD ["clj", "-A:test"]
