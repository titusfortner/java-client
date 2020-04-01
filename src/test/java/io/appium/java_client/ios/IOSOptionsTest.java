/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.java_client.ios;

import io.appium.java_client.remote.MobilePlatform;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class IOSOptionsTest {
    private IOSMobileOptions iosMobileOptions = new IOSMobileOptions();

    @Test
    public void setsPlatformNameByDefault() {
        assertEquals(MobilePlatform.IOS, iosMobileOptions.getPlatformName());
    }

    @Test
    public void acceptsExistingCapabilities() {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("newCommandTimeout", 60);

        iosMobileOptions = new IOSMobileOptions(capabilities);

        assertEquals("Pixel", iosMobileOptions.getDeviceName());
        assertEquals("10", iosMobileOptions.getPlatformVersion());
        assertEquals(Duration.ofSeconds(60), iosMobileOptions.getNewCommandTimeout());
    }
}
