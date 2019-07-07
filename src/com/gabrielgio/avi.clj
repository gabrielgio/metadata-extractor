(ns com.gabrielgio.avi
  (:import (com.drew.metadata.avi AviDirectory)))

(defn get-avi-directory [^AviDirectory dir]
  {:avi/frames-per-seconds  (.getInt dir AviDirectory/TAG_FRAMES_PER_SECOND)
   :avi/samples-per-seconds (.getInt dir AviDirectory/TAG_SAMPLES_PER_SECOND)
   :avi/duration            (.getInt dir AviDirectory/TAG_DURATION)
   :avi/video-codec         (.getString dir AviDirectory/TAG_VIDEO_CODEC)
   :avi/audio-codec         (.getString dir AviDirectory/TAG_AUDIO_CODEC)
   :avi/width               (.getInt dir AviDirectory/TAG_WIDTH)
   :avi/height              (.getInt dir AviDirectory/TAG_HEIGHT)
   :avi/streams             (.getInt dir AviDirectory/TAG_STREAMS)})