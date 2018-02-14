package com.instal.ua.kotlin

import org.junit.Assert.*
import org.junit.Test


val iphone_ua_string = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B179 Safari/7534.48.3"
val ipad_ua_string = "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10"
val galaxy_tab_ua_string = "Mozilla/5.0 (Linux; U; Android 2.2; en-us; SCH-I800 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
val galaxy_s3_ua_string = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-I9300 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"
val kindle_fire_ua_string = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.1.0-80) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true"
val playbook_ua_string = "Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.0.1; en-US) AppleWebKit/535.8+ (KHTML, like Gecko) Version/7.2.0.1 Safari/535.8+"
val nexus_7_ua_string = "Mozilla/5.0 (Linux; Android 4.1.1; Nexus 7 Build/JRO03D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19"
val windows_phone_ua_string = "Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; SAMSUNG; SGH-i917)"
val blackberry_torch_ua_string = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; zh-TW) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.448 Mobile Safari/534.8+"
val blackberry_bold_ua_string = "BlackBerry9700/5.0.0.862 Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/331 UNTRUSTED/1.0 3gpp-gba"
val blackberry_bold_touch_ua_string = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9930; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.241 Mobile Safari/534.11+"
val windows_rt_ua_string = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; ARM; Trident/6.0)"
val j2me_opera_ua_string = "Opera/9.80 (J2ME/MIDP; Opera Mini/9.80 (J2ME/22.478; U; en) Presto/2.5.25 Version/10.54"
val ie_ua_string = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)"
val ie_touch_ua_string = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Touch)"
val mac_safari_ua_string = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/537.13+ (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2"
val windows_ie_ua_string = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)"
val ubuntu_firefox_ua_string = "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:15.0) Gecko/20100101 Firefox/15.0.1"
val google_bot_ua_string = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)"
val nokia_n97_ua_string = "Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/12.0.024; Profile/MIDP-2.1 Configuration/CLDC-1.1; en-us) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.12344"
val android_firefox_aurora_ua_string = "Mozilla/5.0 (Android; Mobile; rv:27.0) Gecko/27.0 Firefox/27.0"
val thunderbird_ua_string = "Mozilla/5.0 (X11; Linux x86_64; rv:38.0) Gecko/20100101 Thunderbird/38.2.0 Lightning/4.0.2"
val outlook_usa_string = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/6.0; Microsoft Outlook 15.0.4420)"
val chromebook_ua_string = "Mozilla/5.0 (X11; CrOS i686 0.12.433) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.77 Safari/534.30"

val iphone_ua = parse(iphone_ua_string)
val ipad_ua = parse(ipad_ua_string)
val galaxy_tab = parse(galaxy_tab_ua_string)
val galaxy_s3_ua = parse(galaxy_s3_ua_string)
val kindle_fire_ua = parse(kindle_fire_ua_string)
val playbook_ua = parse(playbook_ua_string)
val nexus_7_ua = parse(nexus_7_ua_string)
val windows_phone_ua = parse(windows_phone_ua_string)
val windows_rt_ua = parse(windows_rt_ua_string)
val blackberry_torch_ua = parse(blackberry_torch_ua_string)
val blackberry_bold_ua = parse(blackberry_bold_ua_string)
val blackberry_bold_touch_ua = parse(blackberry_bold_touch_ua_string)
val j2me_opera_ua = parse(j2me_opera_ua_string)
val ie_ua = parse(ie_ua_string)
val ie_touch_ua = parse(ie_touch_ua_string)
val mac_safari_ua = parse(mac_safari_ua_string)
val windows_ie_ua = parse(windows_ie_ua_string)
val ubuntu_firefox_ua = parse(ubuntu_firefox_ua_string)
val google_bot_ua = parse(google_bot_ua_string)
val nokia_n97_ua = parse(nokia_n97_ua_string)
val android_firefox_aurora_ua = parse(android_firefox_aurora_ua_string)
val thunderbird_ua = parse(thunderbird_ua_string)
val outlook_ua = parse(outlook_usa_string)
val chromebook_ua = parse(chromebook_ua_string)


class UserAgentsTest {

    @Test
    fun test_is_tablet_property() {
        assertFalse(iphone_ua.is_tablet())
        assertFalse(galaxy_s3_ua.is_tablet())
        assertFalse(blackberry_torch_ua.is_tablet())
        assertFalse(blackberry_bold_ua.is_tablet())
        assertFalse(windows_phone_ua.is_tablet())
        assertFalse(ie_ua.is_tablet())
        assertFalse(ie_touch_ua.is_tablet())
        assertFalse(mac_safari_ua.is_tablet())
        assertFalse(windows_ie_ua.is_tablet())
        assertFalse(ubuntu_firefox_ua.is_tablet())
        assertFalse(j2me_opera_ua.is_tablet())
        assertFalse(google_bot_ua.is_tablet())
        assertFalse(nokia_n97_ua.is_tablet())
        assertTrue(windows_rt_ua.is_tablet())
        assertTrue(ipad_ua.is_tablet())
        assertTrue(playbook_ua.is_tablet())
        assertTrue(kindle_fire_ua.is_tablet())
        assertTrue(nexus_7_ua.is_tablet())
        assertFalse(android_firefox_aurora_ua.is_tablet())
    }

    @Test
    fun test_is_mobile_property() {
        assertTrue(iphone_ua.is_mobile())
        assertTrue(galaxy_s3_ua.is_mobile())
        assertTrue(blackberry_torch_ua.is_mobile())
        assertTrue(blackberry_bold_ua.is_mobile())
        assertTrue(windows_phone_ua.is_mobile())
        assertTrue(j2me_opera_ua.is_mobile())
        assertTrue(nokia_n97_ua.is_mobile())
        assertFalse(windows_rt_ua.is_mobile())
        assertFalse(ipad_ua.is_mobile())
        assertFalse(playbook_ua.is_mobile())
        assertFalse(kindle_fire_ua.is_mobile())
        assertFalse(nexus_7_ua.is_mobile())
        assertFalse(ie_ua.is_mobile())
        assertFalse(ie_touch_ua.is_mobile())
        assertFalse(mac_safari_ua.is_mobile())
        assertFalse(windows_ie_ua.is_mobile())
        assertFalse(ubuntu_firefox_ua.is_mobile())
        assertFalse(google_bot_ua.is_mobile())
        assertTrue(android_firefox_aurora_ua.is_mobile())
    }

    @Test
    fun test_is_touch_property() {
        assertTrue(iphone_ua.is_touch_capable())
        assertTrue(galaxy_s3_ua.is_touch_capable())
        assertTrue(ipad_ua.is_touch_capable())
        assertTrue(playbook_ua.is_touch_capable())
        assertTrue(kindle_fire_ua.is_touch_capable())
        assertTrue(nexus_7_ua.is_touch_capable())
        assertTrue(windows_phone_ua.is_touch_capable())
        assertTrue(ie_touch_ua.is_touch_capable())
        assertTrue(blackberry_bold_touch_ua.is_mobile())
        assertTrue(blackberry_torch_ua.is_mobile())
        assertFalse(j2me_opera_ua.is_touch_capable())
        assertFalse(ie_ua.is_touch_capable())
        assertFalse(blackberry_bold_ua.is_touch_capable())
        assertFalse(mac_safari_ua.is_touch_capable())
        assertFalse(windows_ie_ua.is_touch_capable())
        assertFalse(ubuntu_firefox_ua.is_touch_capable())
        assertFalse(google_bot_ua.is_touch_capable())
        assertFalse(nokia_n97_ua.is_touch_capable())
        assertTrue(android_firefox_aurora_ua.is_touch_capable())
    }

    @Test
    fun test_is_pc() {
        assertFalse(iphone_ua.is_pc())
        assertFalse(galaxy_s3_ua.is_pc())
        assertFalse(ipad_ua.is_pc())
        assertFalse(playbook_ua.is_pc())
        assertFalse(kindle_fire_ua.is_pc())
        assertFalse(nexus_7_ua.is_pc())
        assertFalse(windows_phone_ua.is_pc())
        assertFalse(blackberry_bold_touch_ua.is_pc())
        assertFalse(blackberry_torch_ua.is_pc())
        assertFalse(blackberry_bold_ua.is_pc())
        assertFalse(j2me_opera_ua.is_pc())
        assertFalse(google_bot_ua.is_pc())
        assertFalse(nokia_n97_ua.is_pc())
        assertTrue(mac_safari_ua.is_pc())
        assertTrue(windows_ie_ua.is_pc())
        assertTrue(ubuntu_firefox_ua.is_pc())
        assertTrue(ie_touch_ua.is_pc())
        assertTrue(ie_ua.is_pc())
        assertFalse(android_firefox_aurora_ua.is_pc())
        assertTrue(chromebook_ua.is_pc())
    }


    @Test
    fun test_is_bot() {
        assertTrue(google_bot_ua.is_bot())
        assertFalse(iphone_ua.is_bot())
        assertFalse(galaxy_s3_ua.is_bot())
        assertFalse(ipad_ua.is_bot())
        assertFalse(playbook_ua.is_bot())
        assertFalse(kindle_fire_ua.is_bot())
        assertFalse(nexus_7_ua.is_bot())
        assertFalse(windows_phone_ua.is_bot())
        assertFalse(blackberry_bold_touch_ua.is_bot())
        assertFalse(blackberry_torch_ua.is_bot())
        assertFalse(blackberry_bold_ua.is_bot())
        assertFalse(j2me_opera_ua.is_bot())
        assertFalse(mac_safari_ua.is_bot())
        assertFalse(windows_ie_ua.is_bot())
        assertFalse(ubuntu_firefox_ua.is_bot())
        assertFalse(ie_touch_ua.is_bot())
        assertFalse(ie_ua.is_bot())
        assertFalse(nokia_n97_ua.is_bot())
        assertFalse(android_firefox_aurora_ua.is_bot())
    }

    @Test
    fun test_is_email_client() {
        assertTrue(thunderbird_ua.is_email_client())
        assertTrue(outlook_ua.is_email_client())
        assertFalse(playbook_ua.is_email_client())
        assertFalse(kindle_fire_ua.is_email_client())
        assertFalse(nexus_7_ua.is_email_client())
        assertFalse(windows_phone_ua.is_email_client())
        assertFalse(blackberry_bold_touch_ua.is_email_client())
        assertFalse(blackberry_torch_ua.is_email_client())
        assertFalse(blackberry_bold_ua.is_email_client())
        assertFalse(j2me_opera_ua.is_email_client())
        assertFalse(mac_safari_ua.is_email_client())
        assertFalse(windows_ie_ua.is_email_client())
        assertFalse(ubuntu_firefox_ua.is_email_client())
        assertFalse(ie_touch_ua.is_email_client())
        assertFalse(ie_ua.is_email_client())
        assertFalse(nokia_n97_ua.is_email_client())
        assertFalse(android_firefox_aurora_ua.is_email_client())
    }


    @Test
    fun test_strings() {
        assertEquals(iphone_ua.toString(), "iPhone / iOS 5.1 / Mobile Safari 5.1")
        assertEquals(ipad_ua.toString(), "iPad / iOS 3.2 / Mobile Safari 4.0.4")
        assertEquals(galaxy_tab.toString(), "Samsung SCH-I800 / Android 2.2 / Android 2.2")
        assertEquals(galaxy_s3_ua.toString(), "Samsung GT-I9300 / Android 4.0.4 / Android 4.0.4")
        assertEquals(kindle_fire_ua.toString(), "Kindle / Android / Amazon Silk 1.1.0-80")
        assertEquals(playbook_ua.toString(), "BlackBerry Playbook / BlackBerry Tablet OS 2.0.1 / BlackBerry WebKit 2.0.1")
        assertEquals(nexus_7_ua.toString(), "Asus Nexus 7 / Android 4.1.1 / Chrome 18.0.1025")
        assertEquals(windows_phone_ua.toString(), "Samsung SGH-i917 / Windows Phone 7.5 / IE Mobile 9.0")
        assertEquals(windows_rt_ua.toString(), "PC / Windows RT / IE 10.0")
        assertEquals(blackberry_torch_ua.toString(), "BlackBerry 9800 / BlackBerry OS 6.0.0 / BlackBerry WebKit 6.0.0")
        assertEquals(blackberry_bold_ua.toString(), "BlackBerry 9700 / BlackBerry OS 5.0.0 / BlackBerry 9700")
        assertEquals(blackberry_bold_touch_ua.toString(), "BlackBerry 9930 / BlackBerry OS 7.0.0 / BlackBerry WebKit 7.0.0")
        assertEquals(j2me_opera_ua.toString(), "Generic Feature Phone / Other / Opera Mini 9.80")
        assertEquals(ie_ua.toString(), "PC / Windows 8 / IE 10.0")
        assertEquals(ie_touch_ua.toString(), "PC / Windows 8 / IE 10.0")
        assertEquals(mac_safari_ua.toString(), "PC / Mac OS X 10.6.8 / WebKit Nightly 537.13")
        assertEquals(windows_ie_ua.toString(), "PC / Windows 7 / IE 9.0")
        assertEquals(ubuntu_firefox_ua.toString(), "PC / Ubuntu / Firefox 15.0.1")
        assertEquals(google_bot_ua.toString(), "Spider / Other / Googlebot 2.1")
        assertEquals(nokia_n97_ua.toString(), "Nokia N97 / Symbian OS 9.4 / Nokia Browser 7.1.12344")
        assertEquals(android_firefox_aurora_ua.toString(), "Generic Smartphone / Android / Firefox Mobile 27.0")
    }

}
