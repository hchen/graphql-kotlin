/*
 * Copyright 2020 Expedia, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.graphql.plugin.maven

import com.expediagroup.graphql.plugin.config.TimeoutConfig
import com.expediagroup.graphql.plugin.introspectSchema
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo

/**
 * Run introspection query against specified endpoint and save resulting GraphQL schema locally.
 */
@Mojo(name = "introspect-schema", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
class IntrospectSchemaMojo : RetrieveSchemaAbstractMojo() {

    @Suppress("EXPERIMENTAL_API_USAGE")
    override suspend fun retrieveGraphQLSchema(endpoint: String, httpHeaders: Map<String, Any>, timeoutConfig: TimeoutConfig): String =
        introspectSchema(endpoint = endpoint, httpHeaders = httpHeaders, timeoutConfig = timeoutConfig)
}
