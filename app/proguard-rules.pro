# Web Record by Waqar - ProGuard / R8
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep class com.waqar.webrecord.data.local.entity.** { *; }
-keep class com.waqar.webrecord.domain.model.** { *; }
-dontwarn okhttp3.**
-dontwarn retrofit2.**
-keep class com.google.gson.** { *; }
