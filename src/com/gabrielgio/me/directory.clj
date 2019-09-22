(ns com.gabrielgio.me.directory
  (:import (com.drew.metadata Directory)))

(defn assoc-dir-int [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getInt dir tag))
    map))

(defn assoc-dir-date [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getDate dir tag))
    map))

(defn assoc-dir-long [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getLong dir tag))
    map))

(defn assoc-dir-bytes [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getByteArray dir tag))
    map))

(defn assoc-dir-double [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getDouble dir tag))
    map))

(defn assoc-dir-object [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getObject dir tag))
    map))

(defn assoc-dir-descriptor [map ^Directory dir ^Integer key tag]
  (if (.containsTag dir tag)
    (assoc map key (.getDescription dir tag))
    map))