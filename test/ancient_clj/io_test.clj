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
  {:f (constantly ["1.0.0"])}
  {:uri "http://localhost:12343" :username "abc" :passphrase "def"}
  {:uri "https://localhost:12343" :username "abc" :passphrase "def"}
  {:uri "file:///tmp/repo"}
  {:url "file:///tmp/repo"}
  {:uri "s3p://maven/bucket" :username "abc" :passphrase "def"}
  {:uri "s3p://maven/bucket" :username "abc" :password "def"}
  {:url "s3p://maven/bucket" :username "abc" :passphrase "def"}
  {:uri "s3://maven/bucket" :username "abc" :passphrase "def"})

(tabular
  (fact "about invalid loader specifications."
        (loader-for ?v) => (throws ?ex))
  ?v                          ?ex
  ""                          IllegalArgumentException
  "invalid://abc"             IllegalArgumentException
  "s3p://"                    AssertionError
  "s3p://maven/bucket"        AssertionError
  {}                          Exception
  {:uri "s3p://maven/bucket"} AssertionError
  {:uri "s3://maven/bucket"}  AssertionError
  {:uri "s3p://maven/bucket"
   :username "abc"}           AssertionError)
