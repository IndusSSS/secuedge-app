package com.secuedge.edgeai

import android.content.Context
import org.tensorflow.lite.task.vision.detector.ObjectDetector

/**
 * Simple wrapper around TFLite Task vision detector.
 */
class ObjectDetectorWrapper(context: Context) {
    private val detector: ObjectDetector = ObjectDetector.createFromFileAndOptions(
        context,
        "person-detector.tflite",
        ObjectDetector.ObjectDetectorOptions.builder().setMaxResults(1).build()
    )

    fun detect(bitmap: android.graphics.Bitmap) = detector.detect(bitmap)
}
