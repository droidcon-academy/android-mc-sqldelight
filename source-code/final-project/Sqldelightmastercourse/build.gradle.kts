// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    libs.plugins.apply {
        alias(androidApplication) apply false
        alias(jetbrainsKotlinAndroid) apply false
        alias(kotlin.parcelize) apply false
    }
}