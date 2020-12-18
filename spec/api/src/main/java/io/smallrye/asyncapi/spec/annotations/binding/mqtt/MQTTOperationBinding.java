/*
 * Copyright (C) open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package io.smallrye.asyncapi.spec.annotations.binding.mqtt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Protocol-specific information for an MQTT operation.
 *
 * @see "https://github.com/asyncapi/bindings/blob/master/mqtt/README.md#operation-binding-object"
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MQTTOperationBinding {

    /**
     * Its value MUST be either 0, 1 or 2.
     *
     * @return defines how hard the broker/client will try to ensure that a message is received.
     */
    int qos();

    /**
     * @return whether the broker should retain the message or not.
     */
    boolean retain();

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     *
     * @return version of the binding
     */
    String bindingVersion() default "latest";
}