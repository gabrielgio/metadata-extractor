(ns com.gabrielgio.me.core
  (:require [com.gabrielgio.me.jpeg :refer [get-jpeg-directory get-huffman-directory]]
            [com.gabrielgio.me.exif-sub-ifd :refer [get-exif-sub-ifd-directory]]
            [com.gabrielgio.me.xmp :refer [get-xmp-directory]]
            [com.gabrielgio.me.file :refer [get-file-type-directory get-file-system-directory]]
            [com.gabrielgio.me.png :refer [get-png-directory]])
  (:import (com.drew.imaging ImageMetadataReader)
           (java.io File)
           (com.drew.metadata.exif ExifSubIFDDirectory)
           (com.drew.metadata.jpeg JpegDirectory HuffmanTablesDirectory)
           (com.drew.metadata Directory)
           (com.drew.metadata.file FileTypeDirectory FileSystemDirectory)
           (com.drew.metadata.png PngDirectory)
           (com.drew.metadata.xmp XmpDirectory)))

(defn router-directory [^Directory dir]
  (condp instance? dir
    JpegDirectory           (get-jpeg-directory dir)
    ExifSubIFDDirectory     (get-exif-sub-ifd-directory dir)
    FileTypeDirectory       (get-file-type-directory dir)
    PngDirectory            (get-png-directory dir)
    XmpDirectory            (get-xmp-directory dir)
    HuffmanTablesDirectory  (get-huffman-directory dir)
    FileSystemDirectory     (get-file-system-directory dir)
    nil))

(defn get-metadata [^File file]
  (let [metadata (ImageMetadataReader/readMetadata file)]
    (->> (.getDirectories metadata)
         (map router-directory)
         (filter #(not (nil? %)))
         (reduce merge))))