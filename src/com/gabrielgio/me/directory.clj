(ns com.gabrielgio.me.directory
  (:import (com.drew.metadata Directory)))

(defn assoc-if-contains-int [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getInt dir tag))
    map))

(defn assoc-if-contains-date [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getDate dir tag))
    map))

(defn assoc-if-contains-long [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getLong dir tag))
    map))

(defn assoc-if-contains-bytes [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getByteArray dir tag))
    map))

(defn assoc-if-contains-double [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getDouble dir tag))
    map))

(defn assoc-if-contains-object [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getObject dir tag))
    map))