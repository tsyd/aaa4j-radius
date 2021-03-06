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

package org.aaa4j.radius.core.attribute;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.aaa4j.radius.core.Utils.fromHex;
import static org.aaa4j.radius.core.Utils.toHex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("TimeData")
class TimeDataTest {

    @Test
    @DisplayName("Constructor validates arguments")
    void testConstructor() {
        assertThrows(NullPointerException.class, () -> {
            new TimeData(null);
        });
    }

    @Test
    @DisplayName("Getters return the correct values")
    void testGetters() {
        TimeData timeData = new TimeData(Instant.ofEpochSecond(1605300122L));

        assertEquals(4, timeData.length());
        assertEquals(Instant.ofEpochSecond(1605300122L), timeData.getValue());
    }

    @Test
    @DisplayName("time data is decoded successfully")
    void testDecode() {
        byte[] encoded = fromHex("5faeef9a");

        TimeData timeData = TimeData.Codec.INSTANCE.decode(null, null, encoded);

        assertNotNull(timeData);
        assertEquals(Instant.ofEpochSecond(1605300122L), timeData.getValue());
    }

    @Test
    @DisplayName("time data is encoded successfully")
    void testEncode() {
        TimeData timeData = new TimeData(Instant.ofEpochSecond(1605300122L));
        byte[] encoded = TimeData.Codec.INSTANCE.encode(null, null, timeData);

        assertEquals("5faeef9a", toHex(encoded));
    }

    @Test
    @DisplayName("Invalid time data is decoded into null")
    void testDecodeInvalid() {
        {
            byte[] encoded = fromHex("");
            TimeData timeData = TimeData.Codec.INSTANCE.decode(null, null, encoded);

            assertNull(timeData);
        }
        {
            byte[] encoded = fromHex("5faeef9a00");
            TimeData timeData = TimeData.Codec.INSTANCE.decode(null, null, encoded);

            assertNull(timeData);
        }
        {
            byte[] encoded = fromHex("5faeef");
            TimeData timeData = TimeData.Codec.INSTANCE.decode(null, null, encoded);

            assertNull(timeData);
        }
    }

}