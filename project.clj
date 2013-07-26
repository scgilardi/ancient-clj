(defproject ancient-clj "0.1.0-SNAPSHOT"
  :description "Maven Version Utilities for Clojure"
  :url "https://github.com/xsc/ancient-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.xml "0.0.7"]
                 [clj-aws-s3 "0.3.6"]
                 [version-clj "0.1.0"]]
  :repositories  {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :profiles {:dev {:dependencies [[midje "1.5.1"]]
                   :plugins [[lein-midje "3.0.1"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0-master-SNAPSHOT"]]}}
  :aliases {"midje-all" ["with-profile" "dev,1.4:dev,1.5:dev,1.6" "midje"]
            "deps-all" ["with-profile" "dev,1.4:dev,1.5:dev,1.6" "deps"]})
