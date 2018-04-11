/*
 * Copyright 2016-2018 Leon Chen
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

package com.moilioncircle.redis.replicator.rdb;

import com.moilioncircle.redis.replicator.Replicator;
import com.moilioncircle.redis.replicator.rdb.datatype.KeyValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Leon Chen
 * @since 2.1.0
 */
public interface RdbListener {
    void preFullSync(Replicator replicator);

    void handle(Replicator replicator, KeyValuePair<?> kv);

    void postFullSync(Replicator replicator, long checksum);

    abstract class Adaptor implements RdbListener {

        private static final Logger logger = LoggerFactory.getLogger(Adaptor.class);

        public void preFullSync(Replicator replicator) {
            logger.info("pre full sync");
            //do nothing
        }

        public void postFullSync(Replicator replicator, long checksum) {
            logger.info("post full sync");
            //do nothing
        }
    }
}
