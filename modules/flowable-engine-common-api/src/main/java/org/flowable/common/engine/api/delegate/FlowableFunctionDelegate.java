/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.common.engine.api.delegate;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

/**
 * Interface for pluggable functions that can be used in the EL expressions
 * 
 * @author Tijs Rademakers
 * @author Joram Barrez
 */
public interface FlowableFunctionDelegate {

    /**
     * The prefix of the method when used in an expression, like the first part of ${prefix:method()}.
     * Will be used to match the text of the expression to the actual {@link FlowableFunctionDelegate} instance.
     */
    String prefix();

    /**
     * All the prefixes of the method when used in an expression. It allows one method to cover multiple prefixes.
     * e.g. {@code ${prefix:method()}} or {$code ${alternativePrefix:method()}}.
     * Will be used to match the text of the expression to the actual {@link FlowableFunctionDelegate} instance.
     */
    default Collection<String> prefixes() {
        return Collections.singleton(prefix());
    }

    /**
     * The name of the method when used in an expression, like the second part of ${prefix:method()}.
     * Will be used to match the text of the expression to the actual {@link FlowableFunctionDelegate} instance.
     */
    String localName();

    /**
     * All the names of the method when used in an expression, like the second part of ${prefix:method()}.
     * It allows one method to cover multiple local names.
     * e.g. {@code ${prefix:method()}} or {@code ${prefix:alternativeMethod()}}.
     * Will be used to match the text of the expression to the actual {@link FlowableFunctionDelegate} instance.
     */
    default Collection<String> localNames() {
        return Collections.singleton(localName());
    }

    /**
     * Returns the method that is invoked by JUEL.
     */
    Method functionMethod() throws NoSuchMethodException;

    default Method functionMethod(String prefix, String localName) throws NoSuchMethodException{
        return functionMethod();
    }

}
