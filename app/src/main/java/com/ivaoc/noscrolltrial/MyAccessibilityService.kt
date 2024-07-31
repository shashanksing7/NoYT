package com.ivaoc.noscrolltrial

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

//class MyAccessibilityService : AccessibilityService() {
//    private val processedNodes = HashSet<Int>()
//
//    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
//        if (event == null) {
//            return
//        }
//
//        // Get the root node of the active window
//        val rootNode = rootInActiveWindow
//        if (rootNode != null) {
//            traverseAndHandleViews(rootNode)
//        }
//    }
//
//    override fun onInterrupt() {
//        // Handle service interruption
//    }
//
//    private fun traverseAndHandleViews(node: AccessibilityNodeInfo?) {
//        if (node == null) {
//            return
//        }
//
//        // Check if the node has already been processed
//        val nodeId = System.identityHashCode(node)
//        if (processedNodes.contains(nodeId)) {
//            return
//        }
//
//        // Mark the node as processed
//        processedNodes.add(nodeId)
//
//        // Handle buttons
//        if (node.className == "android.widget.Button") {
//            handleButton(node)
//        }
//
//        // Handle text views
//        if (node.className == "android.widget.TextView") {
//            handleTextView(node)
//        }
//
//        // Handle other view types (e.g., ImageView)
//        if (node.className == "android.widget.ImageView") {
//            handleImageView(node)
//        }
//
//        // Recursively traverse children
//        for (i in 0 until node.childCount) {
//            traverseAndHandleViews(node.getChild(i))
//        }
//    }
//
//    private fun handleButton(node: AccessibilityNodeInfo) {
//        val buttonText = node.text
//        if (buttonText != null) {
//            Log.d("MyAccessibilityService", "Button found: $buttonText")
//            try {
//                if ("Smart Lock".contentEquals(buttonText)) {
//                    // Perform your custom action here
//                    Log.d("MyAccessibilityService", "handleButton: ")
//                }
//            } catch (e: Exception) {
//                Log.d("error", "handleButton: " + e.toString())
//            }
//        }
//    }
//
//    private fun handleTextView(node: AccessibilityNodeInfo) {
//        val text = node.text
//        if (text != null) {
//            Log.d("MyAccessibilityService", "TextView found: $text")
//            // Perform actions based on the text content
//        }
//    }
//
//    private fun handleImageView(node: AccessibilityNodeInfo) {
//        val contentDescription = node.contentDescription
//        if (contentDescription != null) {
//            Log.d("MyAccessibilityService", "ImageView found: $contentDescription")
//            // Perform actions based on the content description
//        }
//    }
//}
class MyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (
            event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
//            event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
        ) {
            val nodeInfo = event.source
            if (nodeInfo != null) {
                val packageName = event.packageName
                Log.d("MyAccessibilityService", "Foreground app: $packageName")
//                handleAppChange(packageName.toString())
            }
        }
    }

    override fun onInterrupt() {
        // Handle service interruption
    }

    private fun handleAppChange(packageName: String) {
        // Perform specific actions based on the foreground app
        Log.d("MyAccessibilityService", "App in foreground: $packageName")
        // Add additional logic based on the package name
    }
}
