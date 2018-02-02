package com.instal.ua.kotlin

import com.github.coveo.ua_parser.Parser

val MOBILE_DEVICE_FAMILIES = listOf(
        "iPhone",
        "iPod",
        "Generic Smartphone",
        "Generic Feature Phone",
        "PlayStation Vita",
        "iOS-Device"
)

val PC_OS_FAMILIES = listOf(
        "Windows 95",
        "Windows 98",
        "Windows ME",
        "Solaris"
)

val MOBILE_OS_FAMILIES = listOf(
        "Windows Phone",
        "Windows Phone OS",  // Earlier versions of ua-parser returns Windows Phone OS
        "Symbian OS",
        "Bada",
        "Windows CE",
        "Windows Mobile",
        "Maemo"
)

val MOBILE_BROWSER_FAMILIES = listOf(
        "Opera Mobile",
        "Opera Mini"
)

val TABLET_DEVICE_FAMILIES = listOf(
        "iPad",
        "BlackBerry Playbook",
        "Blackberry Playbook",  // Earlier versions of ua-parser returns "Blackberry" instead of "BlackBerry"
        "Kindle",
        "Kindle Fire",
        "Kindle Fire HD",
        "Galaxy Tab",
        "Xoom",
        "Dell Streak"
)

val TOUCH_CAPABLE_OS_FAMILIES = listOf(
        "iOS",
        "Android",
        "Windows Phone",
        "Windows Phone OS",
        "Windows RT",
        "Windows CE",
        "Windows Mobile",
        "Firefox OS",
        "MeeGo"
)

val TOUCH_CAPABLE_DEVICE_FAMILIES = listOf(
        "BlackBerry Playbook",
        "Blackberry Playbook",
        "Kindle Fire"
)

val EMAIL_PROGRAM_FAMILIES = setOf(
    "Outlook",
    "Windows Live Mail",
    "AirMail",
    "Apple Mail",
    "Outlook",
    "Thunderbird",
    "Lightning",
    "ThunderBrowse",
    "Windows Live Mail",
    "The Bat!",
    "Lotus Notes",
    "IBM Notes",
    "Barca",
    "MailBar",
    "kmail2",
    "YahooMobileMail"
)

data class Version(val parts: List<String>) {

    fun asString(): String = parts.joinToString(".")

}

fun parse_version(major: String? = null, minor: String? = null, patch: String? = null, patch_minor: String? = null): Version {

//    // Returns version number tuple, attributes will be integer if they're numbers
//    major = verify_attribute(major)
//    minor = verify_attribute(minor)
//    patch = verify_attribute(patch)
//    patch_minor = verify_attribute(patch_minor)

    return Version(listOf(major, minor, patch, patch_minor).filterNotNull())
}

data class Browser(
        val family: String , val version: Version, val version_string: String
)

fun parse_browser(family: String, major: String? = null, minor: String? = null, patch: String? = null, patch_minor: String? = null): Browser {
    val version = parse_version(major, minor, patch, patch_minor)
    val version_string = version.asString()
    return Browser(family, version, version_string)
}

data class OperatingSystem(val family: String , val version: Version, val version_string: String)

fun parse_operating_system(family: String, major: String? = null, minor: String? = null, patch: String? = null, patch_minor: String? = null): OperatingSystem {
    val version = parse_version(major, minor, patch)
    val version_string = version.asString()
    return OperatingSystem(family, version, version_string)
}

data class Device(val family:String, val brand:String, val model:String)

fun parse_device(family:String, brand:String, model:String): Device {
    return Device(family, brand, model)
}

class UserAgent(val ua_string: String) {

    val os: OperatingSystem
    val browser: Browser
    val device: Device

    init {
        val parserClient = Parser().parse(ua_string)
        os = parse_operating_system(parserClient.os.family, parserClient.os.major, parserClient.os.minor, parserClient.os.patch, parserClient.os.patchMinor)
        browser = parse_browser(parserClient.userAgent.family, parserClient.userAgent.major, parserClient.userAgent.minor, parserClient.userAgent.patch, null)
        device = parse_device(parserClient.device.family, "", "") //TODO brand model not actual supported
    }

    override fun toString(): String {
        val device =  if (is_pc()) { "PC"}  else {device.family}

        val os = "%s %s".format(os.family, os.version_string).trim()
        val browser = "%s %s".format (browser.family, browser.version_string).trim()
        return arrayOf(device, os, browser).joinToString(" / ")
    }

    fun _is_android_tablet(): Boolean {
        // Newer Android tablets don't have "Mobile" in their user agent string,
        //older ones like Galaxy Tab still have "Mobile" though they're not
        return ! ua_string.contains("Mobile Safari") && browser.family != "Firefox Mobile"
    }

    fun _is_blackberry_touch_capable_device(): Boolean {
        // A helper to determine whether a BB phone has touch capabilities
        // Blackberry Bold Touch series begins with 99 XX
        if (device.family.contains("Blackberry 99"))
            return true
        if (device.family.contains("Blackberry 95"))  // BB Storm devices
            return true
        if (device.family.contains("Blackberry 95"))  // BB Torch devices
            return true
        return false
    }

    fun is_tablet(): Boolean {
        if (device.family in TABLET_DEVICE_FAMILIES )
            return true
        if (os.family == "Android" && _is_android_tablet())
            return true
        if (os.family.startsWith("Windows RT"))
            return true
        if (os.family == "Firefox OS" && ! browser.family.contains("Mobile") )
            return true
        return false
    }

    fun is_mobile(): Boolean {
        // First check for mobile device and mobile browser families
        if (device.family in MOBILE_DEVICE_FAMILIES)
            return true
        if (MOBILE_BROWSER_FAMILIES.contains(browser.family))
            return true
        // Device is considered Mobile OS is Android and not tablet
        // This is not fool proof but would have to suffice for now
        if ( (os.family == "Android" || os.family == "Firefox OS") and ! is_tablet())
            return true
        if (os.family == "BlackBerry OS" && device.family != "Blackberry Playbook")
            return true
        if (MOBILE_OS_FAMILIES.contains(os.family) )
            return true
        // TODO: remove after https://github.com/tobie/ua-parser/issues/126 is closed
        if (ua_string.contains("J2ME") || ua_string.contains("MIDP") )
            return true
        // This is here mainly to detect Google"s Mobile Spider
        if (ua_string.contains("iPhone;"))
            return true
        if (ua_string.contains("Googlebot-Mobile"))
            return true
        // Mobile Spiders should be identified as mobile
        if (device.family == "Spider" && browser.family.contains("Mobile"))
            return true
        // Nokia mobile
        if (ua_string.contains("NokiaBrowser") &&  ua_string.contains("Mobile"))
            return true
        return false
    }


    fun is_touch_capable(): Boolean {
        // TODO: detect touch capable Nokia devices
        if (os.family in TOUCH_CAPABLE_OS_FAMILIES)
            return true
        if (device.family in TOUCH_CAPABLE_DEVICE_FAMILIES)
            return true
        if (os.family.startsWith("Windows 8") && "Touch" in ua_string)
            return true
        if ("BlackBerry" in os.family && _is_blackberry_touch_capable_device())
            return true
        return false
    }

    fun is_pc(): Boolean {
        // Returns True for "PC" devices (Windows, Mac and Linux)
        if ("Windows NT" in ua_string || os.family in PC_OS_FAMILIES)
            return true
        // TODO: remove after https://github.com/tobie/ua-parser/issues/127 is closed
        if (os.family == "Mac OS X" &&  ! ("Silk" in ua_string) )
            return true
        // Maemo has "Linux" && "X11" in UA, but it is not for PC
        if ("Maemo" in ua_string)
            return false
        if ("Chrome OS" in os.family)
            return true
        if ("Linux" in ua_string && "X11" in ua_string)
            return true
        return false
    }

    fun is_bot(): Boolean = device.family == "Spider"

    fun is_email_client(): Boolean {
        if (browser.family in EMAIL_PROGRAM_FAMILIES)
            return true
        return false
    }

}

fun parse(user_agent_string: String) = UserAgent(user_agent_string)
