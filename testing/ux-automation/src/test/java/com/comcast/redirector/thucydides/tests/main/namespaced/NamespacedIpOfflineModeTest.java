/**
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author Alexey Mironchenko (amironchenko@productengine.com)
 */

package com.comcast.redirector.thucydides.tests.main.namespaced;

import com.comcast.redirector.api.model.namespaced.NamespacedListType;
import com.comcast.redirector.thucydides.steps.namespaced.NamespacedAddIPPageUserSteps;
import com.comcast.redirector.thucydides.steps.namespaced.NamespacedAddPageUserSteps;
import com.comcast.redirector.thucydides.util.TestConstants;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ThucydidesRunner.class)
public class NamespacedIpOfflineModeTest extends NamespacedBaseTest {

    @Steps
    NamespacedAddIPPageUserSteps namespacedAddIPSteps;

    @ManagedPages(defaultUrl = TestConstants.OFFLINE_UX_URL)
    public Pages pages;

    public NamespacedIpOfflineModeTest() {
        EDIT_EMPTY_VALUE = "192.168.0.1";
        VALUE1 = "192.168.0.100";
        VALUE2 = "FE80:0000:0000:0000:0202:B3FF:FE1E:8329";
        VALUE3 = "162.168.0.192";
        EDIT_TEST_VALUE = "10.10.10.11";
    }

    @Override
    String getSuffix() {
        return "_IP_Offline";
    }

    @Override
    String getValueSuffix() {
        return "";
    }

    @Override
    NamespacedListType getSelectorForNamespacedListType() {
        return NamespacedListType.IP;
    }

    @Override
    String getVisibleNamespacedListType() {
        return "IP";
    }

    @Override
    protected NamespacedAddPageUserSteps getNamespacedAddSteps() {
        return namespacedAddIPSteps;
    }

    @Test
    public void _90_createNamespacedWithInvalidValue() {
        NamespacedIpOnlineModeTest.testInvalidNamespacedLists(getNamespacedAddSteps(), TEST, getSuffix(), getValueSuffix());
    }

}
