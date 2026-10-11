package com.waqar.webrecord.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "customers",
    indices = [
        Index(value = ["customerCode"], unique = true),
        Index(value = ["mobile"]),
        Index(value = ["whatsapp"]),
        Index(value = ["name"]),
        Index(value = ["businessName"]),
        Index(value = ["city"]),
        Index(value = ["status"]),
        Index(value = ["followUpDate"]),
        Index(value = ["isArchived"]),
        Index(value = ["paymentStatus"]),
        Index(value = ["updatedAt"])
    ]
)
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val customerCode: String,
    val name: String,
    val mobile: String = "",
    val whatsapp: String = "",
    val businessName: String = "",
    val businessType: String = "",
    val address: String = "",
    val city: String = "",
    val state: String = "",
    val websiteRequirement: String = "",
    val websiteType: String = "",
    val requiredFeatures: String = "",
    val estimatedAmount: Double = 0.0,
    val pendingAmount: Double = 0.0,
    val confirmAmount: Double = 0.0,
    val successAmount: Double = 0.0,
    val paymentReceived: Double = 0.0,
    val inquiryDate: Long = System.currentTimeMillis(),
    val followUpDate: Long? = null,
    val expectedCompletionDate: Long? = null,
    val status: String = "New Inquiry",
    val priority: String = "Medium",
    val notes: String = "",
    val internalRemarks: String = "",
    val assignedAdmin: String = "waqar",
    val paymentStatus: String = "None",
    val projectStatus: String = "New Inquiry",
    val isOverdue: Boolean = false,
    val isArchived: Boolean = false,
    val lastCallAt: Long? = null,
    val lastWhatsAppAt: Long? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val syncStatus: String = "local",
    val remoteId: String? = null
)
