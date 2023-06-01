/*
 * Copyright 2020 The AAA4J-RADIUS Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package org.aaa4j.radius.core.attribute.attributes;

import org.aaa4j.radius.core.attribute.AttributeType;
import org.aaa4j.radius.core.attribute.Ipv6AddrData;
import org.aaa4j.radius.core.attribute.StandardAttribute;

/**
 * PMIP6-Visited-DHCP6-Server-Address (160) attribute.
 */
public final class Pmip6VisitedDhcp6ServerAddress extends StandardAttribute<Ipv6AddrData> {

    public static final AttributeType TYPE = new AttributeType(160);

    public static final String NAME = "PMIP6-Visited-DHCP6-Server-Address";

    public Pmip6VisitedDhcp6ServerAddress(Ipv6AddrData data) {
        super(TYPE.head(), data);
    }

}

