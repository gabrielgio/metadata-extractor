(ns com.gabrielgio.me.xmp
  (:require [com.gabrielgio.me.directory :refer :all])
  (:import (com.drew.metadata.xmp XmpDirectory)
           (java.util Map)))

(defn assoc-xmp-properties [coll ^Map maps]
  (assoc coll :xmp/xmp-values (into {} maps)))

(defn get-xmp-directory [^XmpDirectory dir]
  (-> {}
      (assoc-if-contains-int dir :xmp/xmp-value-count XmpDirectory/TAG_XMP_VALUE_COUNT)
      (assoc-xmp-properties (.getXmpProperties dir))))