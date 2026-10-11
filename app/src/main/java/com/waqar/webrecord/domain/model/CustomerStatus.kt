package com.waqar.webrecord.domain.model

enum class CustomerStatus(val label: String, val colorHex: String) {
    NEW_INQUIRY("New Inquiry", "#2196F3"),
    FOLLOW_UP("Follow Up", "#FF9800"),
    INTERESTED("Interested", "#9C27B0"),
    NOT_INTERESTED("Not Interested", "#9E9E9E"),
    CONFIRMED("Confirmed", "#00BCD4"),
    IN_PROGRESS("In Progress", "#3F51B5"),
    PAYMENT_PENDING("Payment Pending", "#FF5722"),
    PAYMENT_RECEIVED("Payment Received", "#4CAF50"),
    WEBSITE_COMPLETED("Website Completed", "#8BC34A"),
    SUCCESS("Success", "#2E7D32"),
    CANCELLED("Cancelled", "#F44336");

    companion object {
        fun fromLabel(label: String): CustomerStatus =
            entries.find { it.label.equals(label, ignoreCase = true) } ?: NEW_INQUIRY
    }
}

enum class PaymentStatus(val label: String) {
    NONE("None"),
    PENDING("Pending"),
    PARTIAL("Partial"),
    RECEIVED("Received"),
    REFUNDED("Refunded")
}

enum class Priority(val label: String) {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    URGENT("Urgent")
}

enum class ThemeMode { LIGHT, DARK, SYSTEM }
