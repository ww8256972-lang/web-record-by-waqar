package com.waqar.webrecord.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun openDialer(context: Context, phone: String) {
    val cleaned = phone.filter { it.isDigit() || it == '+' }
    if (cleaned.isBlank()) {
        Toast.makeText(context, "No phone number", Toast.LENGTH_SHORT).show()
        return
    }
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$cleaned"))
    context.startActivity(intent)
}

fun openWhatsApp(context: Context, phone: String, message: String) {
    val cleaned = phone.filter { it.isDigit() }
    if (cleaned.isBlank()) {
        Toast.makeText(context, "No WhatsApp number", Toast.LENGTH_SHORT).show()
        return
    }
    val encoded = Uri.encode(message)
    val uri = Uri.parse("https://wa.me/$cleaned?text=$encoded")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "WhatsApp not available", Toast.LENGTH_SHORT).show()
    }
}
