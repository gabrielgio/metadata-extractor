# Meta extractor

[![Clojars Project](https://img.shields.io/clojars/v/metadata-extractor.svg)](https://clojars.org/metadata-extractor)

Wrapper for [meta-extractor](https://github.com/drewnoakes/metadata-extractor).

So far it does not cover all api from metadata-extractor java version.
Also it does not parse all metadata directories, the whole process it quite a chore and I will 
add over time.

So far the project extracts the following metadata:

* Avi
* Bmp
* Exif
* Jpeg
* Png
* Xmp

## Usage
This api has only one method that you will need:

```clojure
(require '[com.gabrielgio.me.core :as me])
;; you have to pass a file
(me/get-metadata (clojure.java.io/file "<some file>"))
```
And that will return something like:
```clojure
{:huffman-tables/is-optimized true,
 :file-type/detected-file-mime-type 1785750887,
 :jpeg/data-precision 8,
 :file-type/detected-file-type-name 1246774599,
 :jpeg/components ({:name "Y", :quantization-table 0, :horizontal-sampling-factor 1, :vertical-sampling-factor 1}
                   {:name "Cb", :quantization-table 1, :horizontal-sampling-factor 1, :vertical-sampling-factor 1}
                   {:name "Cr", :quantization-table 1, :horizontal-sampling-factor 1, :vertical-sampling-factor 1}),
 :file-system/file-size 116259,
 :jpeg/width 1200,
 :file-system/file-modified-date #inst"2019-09-13T16:21:44.000-00:00",
 :jpeg/compression-type "Progressive, Huffman",
 :file-type/detected-file-name-extension 6975591,
 :file-system/file-name "0sNPIwO.jpg",
 :huffman-tables/is-typical false,
 :jpeg/height 900,
 :file-type/detected-file-type-long-name 1919907184}
```