(ns ancient-clj.io-test
  (:require [midje.sweet :refer :all]
            [ancient-clj.io :refer :all]))

(tabular
  (fact "about loader creation."
        (loader-for ?v) => fn?)
  ?v
  "http://localhost:12343"
  "https://localhost:12343"
  "file:///tmp/repo"
  {:uri "http://localhost:12343" :username "abc" :passphrase "def"}
  {:uri "https://localhost:12343" :username "abc" :passphrase "def"}
  {:uri "file:///tmp/repo"}
  {:uri "s3p://maven/bucket" :username "abc" :passphrase "def"})

(tabular
  (fact "about invalid loader specifications."
        (loader-for ?v) => (throws ?ex))
  ?v                          ?ex
  ""                          IllegalArgumentException
  "invalid://abc"             IllegalArgumentException
  "s3p://"                    AssertionError
  "s3p://maven/bucket"        AssertionError
  {:uri "s3p://maven/bucket"} AssertionError
  {:uri "s3p://maven/bucket"
   :username "abc"}           AssertionError)