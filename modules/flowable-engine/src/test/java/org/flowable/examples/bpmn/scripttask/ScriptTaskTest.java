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
package org.flowable.examples.bpmn.scripttask;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

import java.util.HashMap;
import java.util.Map;

import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.common.engine.impl.scripting.FlowableScriptEvaluationException;
import org.flowable.common.engine.impl.util.CollectionUtil;
import org.flowable.engine.impl.test.PluggableFlowableTestCase;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.node.ObjectNode;

import groovy.lang.MissingPropertyException;

/**
 * @author Joram Barrez
 * @author Christian Stettler
 * @author Calin Cerchez
 */
public class ScriptTaskTest extends PluggableFlowableTestCase {

    @Test
    @Deployment
    public void testSetScriptResultToProcessVariable() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("echo", "hello");
        variables.put("existingProcessVariableName", "one");

        ProcessInstance pi = runtimeService.startProcessInstanceByKey("setScriptResultToProcessVariable", variables);

        assertThat(runtimeService.getVariable(pi.getId(), "existingProcessVariableName")).isEqualTo("hello");
        assertThat(runtimeService.getVariable(pi.getId(), "newProcessVariableName")).isEqualTo(pi.getId());
    }

    @Test
    @Deployment
    public void testFailingScript() {
        assertThatThrownBy(() -> runtimeService.startProcessInstanceByKey("failingScript"))
                .hasRootCauseInstanceOf(MissingPropertyException.class);
    }

    @Test
    @Deployment
    public void testExceptionThrownInScript() {
        assertThatThrownBy(() -> runtimeService.startProcessInstanceByKey("failingScript"))
                .hasRootCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    @Deployment
    public void testAutoStoreVariables() {
        // The first script should NOT store anything as 'autoStoreVariables' is set to false
        String id = runtimeService.startProcessInstanceByKey("testAutoStoreVariables", CollectionUtil.map("a", 20, "b", 22)).getId();
        assertThat(runtimeService.getVariable(id, "sum")).isNull();

        // The second script, after the user task will set the variable
        taskService.complete(taskService.createTaskQuery().singleResult().getId());
        assertThat(((Number) runtimeService.getVariable(id, "sum")).intValue()).isEqualTo(42);
    }

    @Test
    @Deployment
    public void testInputVariables() {
        // The first script should use the input variables
        // i.e. when input parameters are defined then doNotIncludeVariables is ignored
        String id = runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey("testInputVariables")
                .variable("a", 20)
                .variable("b", 22)
                .variable("aVar", 100)
                .variable("bVar", 10)
                .start()
                .getId();
        assertThat(runtimeService.getVariable(id, "sum"))
                .isInstanceOfSatisfying(Number.class, number -> assertThat(number.intValue()).isEqualTo(120));

        // The second script should not use the input variables at all
        assertThatThrownBy(() -> {
            taskService.complete(taskService.createTaskQuery().singleResult().getId());
        }).hasMessageContaining("\"a\" is not defined");
    }

    @Test
    public void testNoScriptProvided() {
        assertThatThrownBy(() ->  deploymentIdsForAutoCleanup.add(
                repositoryService.createDeployment().addClasspathResource("org/flowable/examples/bpmn/scripttask/ScriptTaskTest.testNoScriptProvided.bpmn20.xml").deploy().getId()
        ))
                .as("Deployment should not have worked")
                .isInstanceOf(FlowableException.class)
                .hasMessageContaining("No script provided");
    }

    @Test
    @Deployment
    public void testErrorInScript() {
        assertThatThrownBy(() -> runtimeService.startProcessInstanceByKey("testErrorInScript"))
                .as("Starting process should result in error in script")
                .isInstanceOf(FlowableException.class)
                .hasMessageContainingAll(
                        "Error evaluating juel script: \"execution.setVariable(\"myVar\", scriptVar)\" for Execution[ id",
                        " - definition 'testErrorInScript:1:",
                        " - activity 'theScriptTaskWithJuel'"
                );
    }

    /**
     * Tests {@link org.flowable.engine.impl.scripting.ProcessEngineScriptTraceEnhancer}
     * together with {@link org.flowable.engine.impl.bpmn.behavior.ScriptTaskActivityBehavior}
     * contributing the expected error trace information
     */
    @Test
    @Deployment
    public void testErrorInScriptJavaScript() {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("testErrorInScript").singleResult();
        assertThatThrownBy(() -> runtimeService.startProcessInstanceByKey("testErrorInScript"))
                .isInstanceOf(FlowableScriptEvaluationException.class)
                .hasMessage("JavaScript script evaluation failed: 'TypeError: foo.substring is not a function in <eval> at line number 2' "
                        + "Trace: scopeType=bpmn, scopeDefinitionKey=testErrorInScript, scopeDefinitionId=" + processDefinition.getId() + ","
                        + " subScopeDefinitionKey=theScriptTaskWithJavaScript, tenantId=<empty>, type=scriptTask");
    }

    @Test
    @Deployment
    public void testThrowFlowableIllegalArgumentException() {
        assertThatThrownBy(() -> runtimeService.startProcessInstanceByKey("failingScript"))
                .as("Starting process should result in illegal argument exception in script")
                .isInstanceOf(FlowableIllegalArgumentException.class)
                .hasMessageContaining("illegal");
    }

    @Test
    @Deployment
    public void testNoErrorInScript() {
        assertThatCode(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("scriptVar", "1212");
            runtimeService.startProcessInstanceByKey("testNoErrorInScript", variables);
        }).doesNotThrowAnyException();
    }

    @Test
    @Deployment
    public void testSetScriptResultToProcessVariableWithoutFormat() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("echo", "hello");
        variables.put("existingProcessVariableName", "one");

        ProcessInstance pi = runtimeService.startProcessInstanceByKey("setScriptResultToProcessVariable", variables);

        assertThat(runtimeService.getVariable(pi.getId(), "existingProcessVariableName")).isEqualTo("hello");
        assertThat(runtimeService.getVariable(pi.getId(), "newProcessVariableName")).isEqualTo(pi.getId());
    }

    @Test
    @Deployment
    public void testDynamicScript() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("testDynamicScript", CollectionUtil.map("a", 20, "b", 22));
        assertThat(((Number) runtimeService.getVariable(processInstance.getId(), "test")).intValue()).isEqualTo(42);
        taskService.complete(taskService.createTaskQuery().singleResult().getId());
        assertProcessEnded(processInstance.getId());

        String processDefinitionId = processInstance.getProcessDefinitionId();
        ObjectNode infoNode = dynamicBpmnService.changeScriptTaskScript("script1", "var sum = c + d;\nexecution.setVariable('test2', sum);");
        dynamicBpmnService.saveProcessDefinitionInfo(processDefinitionId, infoNode);

        processInstance = runtimeService.startProcessInstanceByKey("testDynamicScript", CollectionUtil.map("c", 10, "d", 12));
        assertThat(((Number) runtimeService.getVariable(processInstance.getId(), "test2")).intValue()).isEqualTo(22);
        taskService.complete(taskService.createTaskQuery().singleResult().getId());
        assertProcessEnded(processInstance.getId());
    }

    @Test
    @Deployment
    public void testSkipExpression() {
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceBuilder()
                .processDefinitionKey("scriptTaskProcess")
                .transientVariable("_FLOWABLE_SKIP_EXPRESSION_ENABLED", true)
                .transientVariable("skipExpression", true)
                .start();

        assertThat(processInstance.getProcessVariables()).isEmpty();
    }

    @Test
    @Deployment(resources = "org/flowable/examples/bpmn/scripttask/ScriptTaskTest.testSkipExpression.bpmn20.xml")
    public void testSkipExpressionFalse() {
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceBuilder()
                .processDefinitionKey("scriptTaskProcess")
                .transientVariable("_FLOWABLE_SKIP_EXPRESSION_ENABLED", true)
                .transientVariable("skipExpression", false)
                .start();

        assertThat(processInstance.getProcessVariables())
                .containsOnly(entry("persistentResult", "success"));
    }

    @Test
    @Deployment(resources = "org/flowable/examples/bpmn/scripttask/ScriptTaskTest.testSkipExpression.bpmn20.xml")
    public void testSkipExpressionDisabled() {
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceBuilder()
                .processDefinitionKey("scriptTaskProcess")
                .transientVariable("_FLOWABLE_SKIP_EXPRESSION_ENABLED", false)
                .transientVariable("skipExpression", true)
                .start();

        assertThat(processInstance.getProcessVariables())
                .containsOnly(entry("persistentResult", "success"));
    }

}
