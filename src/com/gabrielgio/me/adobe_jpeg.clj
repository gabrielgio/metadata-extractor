(ns com.gabrielgio.me.adobe-jpeg
  (:import (com.drew.metadata.adobe AdobeJpegDirectory)))

(defn get-adobe-jpeg-directory [^AdobeJpegDirectory dir]
  {:adobe-jpeg/tag-dct-encode-version (.getInt dir AdobeJpegDirectory/TAG_DCT_ENCODE_VERSION)
   :adobe-jpeg/tag-app14-flags0       (.getInt dir AdobeJpegDirectory/TAG_APP14_FLAGS0)
   :adobe-jpeg/tag-app14-flags1       (.getInt dir AdobeJpegDirectory/TAG_APP14_FLAGS1)
   :adobe-jpeg/tag-color-transform    (.getInt dir AdobeJpegDirectory/TAG_COLOR_TRANSFORM)})