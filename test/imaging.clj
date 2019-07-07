(ns imaging
  (:require [clojure.test :refer :all]
            [com.gabrielgio.core :refer [get-metadata]])
  (:import (java.text SimpleDateFormat)
           (java.util TimeZone)))

;assertEquals(PngChunkType.gAMA, dirs[1].getPngChunkType());
;assertEquals(0.45455, dirs[1].getDouble(PngDirectory.TAG_GAMMA), 0.00001);
;
;assertEquals(PngChunkType.bKGD, dirs[2].getPngChunkType());
;assertArrayEquals(new byte[]{0, 52}, dirs[2].getByteArray(PngDirectory.TAG_BACKGROUND_COLOR));
;
;//noinspection ConstantConditions
;assertEquals(PngChunkType.pHYs, dirs[3].getPngChunkType());
;assertEquals(1, dirs[3].getInt(PngDirectory.TAG_UNIT_SPECIFIER));
;assertEquals(2835, dirs[3].getInt(PngDirectory.TAG_PIXELS_PER_UNIT_X));
;assertEquals(2835, dirs[3].getInt(PngDirectory.TAG_PIXELS_PER_UNIT_Y));
;
;assertEquals(PngChunkType.tIME, dirs[4].getPngChunkType());
;assertEquals("2013:01:01 04:08:30", dirs[4].getString(PngDirectory.TAG_LAST_MODIFICATION_TIME));
;
;java.util.Date modTime = dirs[4].getDate(PngDirectory.TAG_LAST_MODIFICATION_TIME);
;SimpleDateFormat formatter = new SimpleDateFormat("EE MMM DD HH:mm:ss z yyyy", Locale.US);
;formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
;assertEquals("Tue Jan 01 04:08:30 GMT 2013", formatter.format(modTime));
;assertNotNull(modTime);
;assertEquals(1357013310000L, modTime.getTime());
;
;assertEquals(PngChunkType.iTXt, dirs[5].getPngChunkType());
;@SuppressWarnings("unchecked")
;List<KeyValuePair> pairs = (List<KeyValuePair>)dirs[5].getObject(PngDirectory.TAG_TEXTUAL_DATA);
;assertNotNull(pairs);
;assertEquals(1, pairs.size());
;assertEquals("Comment", pairs.get(0).getKey().toString());
;assertEquals("Created with GIMP", pairs.get(0).getValue().toString());


(defn format-date [date]
  (let [formatter (SimpleDateFormat. "yyyy-MM-dd hh:mm:ss")]
    (.setTimeZone formatter (TimeZone/getTimeZone "UTC"))
    (.format formatter date)))

(testing "gimp greyscale with many chunks"
  (let [file (clojure.java.io/file "test/data/gimp-8x12-greyscale-alpha-time-background.png")
        meta (get-metadata file)]
    (is (= 8 (:png/width meta)))
    (is (= 12 (:png/height meta)))
    (is (= 8 (:png/bits-per-sample meta)))
    (is (= 4 (:png/color-type meta)))
    (is (= 0 (:png/compression-type meta)))
    (is (= 0 (:png/filter-method meta)))
    (is (= 0 (:png/interlace-method meta)))
    (is (> 0.00001 (- (:png/gamma meta) 0.45455)))
    (is (= (byte 0) (first (:png/background-color meta))))
    (is (= (byte 52) (last (:png/background-color meta))))
    (is (= 1 (:png/unit-specifier meta)))
    (is (= 2835 (:png/pixel-per-unit-x meta)))
    (is (= 2835 (:png/pixel-per-unit-y meta)))
    (is (= "2013-01-01 04:08:30" (format-date (:png/last-modification-time meta))))
    (is (= 0 (:png/interlace-method meta)))
    (is (= "Comment" (-> meta :png/textual-data first .getKey)))
    (is (= "Created with GIMP" (-> meta :png/textual-data first .getValue str)))))