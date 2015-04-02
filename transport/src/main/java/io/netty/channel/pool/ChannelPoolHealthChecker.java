/*
 * Copyright 2015 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;


/**
 * Called before a {@link Channel} will be returned via {@link ChannelPool#acquire(ChannelPoolKey)} or
 * {@link ChannelPool#acquire(ChannelPoolKey, Promise)}.
 *
 * @param <C>   the {@link Channel} type to pool.
 * @param <K>   the {@link ChannelPoolKey} that is used to store and lookup the {@link Channel}s.
 */
public interface ChannelPoolHealthChecker<C extends Channel, K extends ChannelPoolKey> {

    /**
     * Check if the given channel is healthy which means it can be used. The returned {@link Future} is notified once
     * the check is complete. If notified with {@link Boolean#TRUE} it can be used {@link Boolean#FALSE} otherwise.
     */
    Future<Boolean> isHealthy(C channel, K key);
}
