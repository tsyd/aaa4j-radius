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
import org.aaa4j.radius.core.attribute.ExtendedAttribute;
import org.aaa4j.radius.core.attribute.TlvData;

/**
 * Softwire46-Priority (241.10) attribute.
 */
public final class Softwire46Priority extends ExtendedAttribute<TlvData> {

    public static final AttributeType TYPE = new AttributeType(241, 10);

    public static final String NAME = "Softwire46-Priority";

    public Softwire46Priority(TlvData data) {
        super(TYPE.head(), TYPE.at(1), data);
    }

}