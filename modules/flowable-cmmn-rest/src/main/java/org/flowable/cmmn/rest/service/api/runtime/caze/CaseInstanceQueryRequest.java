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

package org.flowable.cmmn.rest.service.api.runtime.caze;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.flowable.cmmn.rest.service.api.engine.variable.QueryVariable;
import org.flowable.common.rest.api.PaginateRequest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @author Tijs Rademakers
 */
public class CaseInstanceQueryRequest extends PaginateRequest {

    private String caseInstanceId;
    private String caseDefinitionId;
    private String caseDefinitionKey;
    private String caseDefinitionKeyLike;
    private String caseDefinitionKeyLikeIgnoreCase;
    private Set<String> caseDefinitionKeys;
    private Set<String> excludeCaseDefinitionKeys;
    private String caseDefinitionCategory;
    private String caseDefinitionCategoryLike;
    private String caseDefinitionCategoryLikeIgnoreCase;
    private String caseDefinitionName;
    private String caseDefinitionNameLike;
    private String caseDefinitionNameLikeIgnoreCase;
    private String caseBusinessKey;
    private String caseInstanceName;
    private String caseInstanceNameLike;
    private String caseInstanceNameLikeIgnoreCase;
    private String caseInstanceRootScopeId;
    private String caseInstanceParentScopeId;
    private String caseInstanceBusinessKey;
    private String caseInstanceBusinessKeyLike;
    private String caseInstanceBusinessKeyLikeIgnoreCase;
    private String caseInstanceBusinessStatus;
    private String caseInstanceBusinessStatusLike;
    private String caseInstanceBusinessStatusLikeIgnoreCase;
    private String caseInstanceParentId;
    private String caseInstanceStartedBy;
    private Date caseInstanceStartedBefore;
    private Date caseInstanceStartedAfter;
    private String caseInstanceState;
    private String involvedUser;
    private String caseInstanceCallbackId;
    private String caseInstanceCallbackType;
    private String caseInstanceReferenceId;
    private String caseInstanceReferenceType;
    private String caseInstanceLastReactivatedBy;
    private Date caseInstanceLastReactivatedBefore;
    private Date caseInstanceLastReactivatedAfter;
    private Boolean includeCaseVariables;
    private List<QueryVariable> variables;
    private String activePlanItemDefinitionId;
    private Set<String> activePlanItemDefinitionIds;
    private String tenantId;
    private String tenantIdLike;
    private String tenantIdLikeIgnoreCase;
    private Boolean withoutTenantId;

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    public String getCaseBusinessKey() {
        return caseBusinessKey;
    }

    public void setCaseBusinessKey(String caseBusinessKey) {
        this.caseBusinessKey = caseBusinessKey;
    }

    public String getCaseDefinitionKeyLike() {
        return caseDefinitionKeyLike;
    }

    public void setCaseDefinitionKeyLike(String caseDefinitionKeyLike) {
        this.caseDefinitionKeyLike = caseDefinitionKeyLike;
    }

    public String getCaseDefinitionKeyLikeIgnoreCase() {
        return caseDefinitionKeyLikeIgnoreCase;
    }

    public void setCaseDefinitionKeyLikeIgnoreCase(String caseDefinitionKeyLikeIgnoreCase) {
        this.caseDefinitionKeyLikeIgnoreCase = caseDefinitionKeyLikeIgnoreCase;
    }

    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public String getCaseDefinitionKey() {
        return caseDefinitionKey;
    }

    public void setCaseDefinitionKey(String caseDefinitionKey) {
        this.caseDefinitionKey = caseDefinitionKey;
    }

    public Set<String> getCaseDefinitionKeys() {
        return caseDefinitionKeys;
    }

    public void setCaseDefinitionKeys(Set<String> caseDefinitionKeys) {
        this.caseDefinitionKeys = caseDefinitionKeys;
    }

    public Set<String> getExcludeCaseDefinitionKeys() {
        return excludeCaseDefinitionKeys;
    }

    public void setExcludeCaseDefinitionKeys(Set<String> excludeCaseDefinitionKeys) {
        this.excludeCaseDefinitionKeys = excludeCaseDefinitionKeys;
    }

    public String getCaseDefinitionCategory() {
        return caseDefinitionCategory;
    }

    public void setCaseDefinitionCategory(String caseDefinitionCategory) {
        this.caseDefinitionCategory = caseDefinitionCategory;
    }
    
    public String getCaseDefinitionCategoryLike() {
        return caseDefinitionCategoryLike;
    }

    public void setCaseDefinitionCategoryLike(String caseDefinitionCategoryLike) {
        this.caseDefinitionCategoryLike = caseDefinitionCategoryLike;
    }

    public String getCaseDefinitionCategoryLikeIgnoreCase() {
        return caseDefinitionCategoryLikeIgnoreCase;
    }

    public void setCaseDefinitionCategoryLikeIgnoreCase(String caseDefinitionCategoryLikeIgnoreCase) {
        this.caseDefinitionCategoryLikeIgnoreCase = caseDefinitionCategoryLikeIgnoreCase;
    }
    
    public String getCaseDefinitionName() {
        return caseDefinitionName;
    }

    public void setCaseDefinitionName(String caseDefinitionName) {
        this.caseDefinitionName = caseDefinitionName;
    }
    
    public String getCaseDefinitionNameLike() {
        return caseDefinitionNameLike;
    }

    public void setCaseDefinitionNameLike(String caseDefinitionNameLike) {
        this.caseDefinitionNameLike = caseDefinitionNameLike;
    }

    public String getCaseDefinitionNameLikeIgnoreCase() {
        return caseDefinitionNameLikeIgnoreCase;
    }

    public void setCaseDefinitionNameLikeIgnoreCase(String caseDefinitionNameLikeIgnoreCase) {
        this.caseDefinitionNameLikeIgnoreCase = caseDefinitionNameLikeIgnoreCase;
    }

    public String getCaseInstanceName() {
        return caseInstanceName;
    }

    public void setCaseInstanceName(String caseInstanceName) {
        this.caseInstanceName = caseInstanceName;
    }

    public String getCaseInstanceNameLike() {
        return caseInstanceNameLike;
    }

    public void setCaseInstanceNameLike(String caseInstanceNameLike) {
        this.caseInstanceNameLike = caseInstanceNameLike;
    }

    public String getCaseInstanceNameLikeIgnoreCase() {
        return caseInstanceNameLikeIgnoreCase;
    }

    public void setCaseInstanceNameLikeIgnoreCase(String caseInstanceNameLikeIgnoreCase) {
        this.caseInstanceNameLikeIgnoreCase = caseInstanceNameLikeIgnoreCase;
    }

    public String getCaseInstanceRootScopeId() {
        return caseInstanceRootScopeId;
    }

    public void setCaseInstanceRootScopeId(String caseInstanceRootScopeId) {
        this.caseInstanceRootScopeId = caseInstanceRootScopeId;
    }

    public String getCaseInstanceParentScopeId() {
        return caseInstanceParentScopeId;
    }

    public void setCaseInstanceParentScopeId(String caseInstanceParentScopeId) {
        this.caseInstanceParentScopeId = caseInstanceParentScopeId;
    }

    public String getCaseInstanceBusinessKey() {
        return caseInstanceBusinessKey;
    }

    public void setCaseInstanceBusinessKey(String caseInstanceBusinessKey) {
        this.caseInstanceBusinessKey = caseInstanceBusinessKey;
    }

    public String getCaseInstanceBusinessKeyLike() {
        return caseInstanceBusinessKeyLike;
    }

    public void setCaseInstanceBusinessKeyLike(String caseInstanceBusinessKeyLike) {
        this.caseInstanceBusinessKeyLike = caseInstanceBusinessKeyLike;
    }

    public String getCaseInstanceBusinessKeyLikeIgnoreCase() {
        return caseInstanceBusinessKeyLikeIgnoreCase;
    }

    public void setCaseInstanceBusinessKeyLikeIgnoreCase(String caseInstanceBusinessKeyLikeIgnoreCase) {
        this.caseInstanceBusinessKeyLikeIgnoreCase = caseInstanceBusinessKeyLikeIgnoreCase;
    }

    public String getCaseInstanceBusinessStatus() {
        return caseInstanceBusinessStatus;
    }

    public void setCaseInstanceBusinessStatus(String caseInstanceBusinessStatus) {
        this.caseInstanceBusinessStatus = caseInstanceBusinessStatus;
    }
    
    public String getCaseInstanceBusinessStatusLike() {
        return caseInstanceBusinessStatusLike;
    }

    public void setCaseInstanceBusinessStatusLike(String caseInstanceBusinessStatusLike) {
        this.caseInstanceBusinessStatusLike = caseInstanceBusinessStatusLike;
    }

    public String getCaseInstanceBusinessStatusLikeIgnoreCase() {
        return caseInstanceBusinessStatusLikeIgnoreCase;
    }

    public void setCaseInstanceBusinessStatusLikeIgnoreCase(String caseInstanceBusinessStatusLikeIgnoreCase) {
        this.caseInstanceBusinessStatusLikeIgnoreCase = caseInstanceBusinessStatusLikeIgnoreCase;
    }

    public String getCaseInstanceStartedBy() {
        return caseInstanceStartedBy;
    }

    public void setCaseInstanceStartedBy(String caseInstanceStartedBy) {
        this.caseInstanceStartedBy = caseInstanceStartedBy;
    }

    public Date getCaseInstanceStartedBefore() {
        return caseInstanceStartedBefore;
    }

    public void setCaseInstanceStartedBefore(Date caseInstanceStartedBefore) {
        this.caseInstanceStartedBefore = caseInstanceStartedBefore;
    }

    public Date getCaseInstanceStartedAfter() {
        return caseInstanceStartedAfter;
    }

    public void setCaseInstanceStartedAfter(Date caseInstanceStartedAfter) {
        this.caseInstanceStartedAfter = caseInstanceStartedAfter;
    }

    public String getCaseInstanceState() {
        return caseInstanceState;
    }

    public void setCaseInstanceState(String caseInstanceState) {
        this.caseInstanceState = caseInstanceState;
    }
    
    public String getCaseInstanceParentId() {
        return caseInstanceParentId;
    }

    public void setCaseInstanceParentId(String caseInstanceParentId) {
        this.caseInstanceParentId = caseInstanceParentId;
    }

    public String getInvolvedUser() {
        return involvedUser;
    }

    public void setInvolvedUser(String involvedUser) {
        this.involvedUser = involvedUser;
    }

    public String getCaseInstanceCallbackId() {
        return caseInstanceCallbackId;
    }

    public void setCaseInstanceCallbackId(String caseInstanceCallbackId) {
        this.caseInstanceCallbackId = caseInstanceCallbackId;
    }

    public String getCaseInstanceCallbackType() {
        return caseInstanceCallbackType;
    }

    public void setCaseInstanceCallbackType(String caseInstanceCallbackType) {
        this.caseInstanceCallbackType = caseInstanceCallbackType;
    }

    public String getCaseInstanceReferenceId() {
        return caseInstanceReferenceId;
    }

    public void setCaseInstanceReferenceId(String caseInstanceReferenceId) {
        this.caseInstanceReferenceId = caseInstanceReferenceId;
    }

    public String getCaseInstanceReferenceType() {
        return caseInstanceReferenceType;
    }

    public void setCaseInstanceReferenceType(String caseInstanceReferenceType) {
        this.caseInstanceReferenceType = caseInstanceReferenceType;
    }

    public String getCaseInstanceLastReactivatedBy() {
        return caseInstanceLastReactivatedBy;
    }

    public void setCaseInstanceLastReactivatedBy(String caseInstanceLastReactivatedBy) {
        this.caseInstanceLastReactivatedBy = caseInstanceLastReactivatedBy;
    }

    public Date getCaseInstanceLastReactivatedBefore() {
        return caseInstanceLastReactivatedBefore;
    }

    public void setCaseInstanceLastReactivatedBefore(Date caseInstanceLastReactivatedBefore) {
        this.caseInstanceLastReactivatedBefore = caseInstanceLastReactivatedBefore;
    }

    public Date getCaseInstanceLastReactivatedAfter() {
        return caseInstanceLastReactivatedAfter;
    }

    public void setCaseInstanceLastReactivatedAfter(Date caseInstanceLastReactivatedAfter) {
        this.caseInstanceLastReactivatedAfter = caseInstanceLastReactivatedAfter;
    }

    public Boolean getIncludeCaseVariables() {
        return includeCaseVariables;
    }

    public void setIncludeCaseVariables(Boolean includeCaseVariables) {
        this.includeCaseVariables = includeCaseVariables;
    }

    @JsonTypeInfo(use = Id.CLASS, defaultImpl = QueryVariable.class)
    public List<QueryVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<QueryVariable> variables) {
        this.variables = variables;
    }

    public String getActivePlanItemDefinitionId() {
        return activePlanItemDefinitionId;
    }

    public void setActivePlanItemDefinitionId(String activePlanItemDefinitionId) {
        this.activePlanItemDefinitionId = activePlanItemDefinitionId;
    }

    public Set<String> getActivePlanItemDefinitionIds() {
        return activePlanItemDefinitionIds;
    }

    public void setActivePlanItemDefinitionIds(Set<String> activePlanItemDefinitionIds) {
        this.activePlanItemDefinitionIds = activePlanItemDefinitionIds;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setWithoutTenantId(Boolean withoutTenantId) {
        this.withoutTenantId = withoutTenantId;
    }

    public Boolean getWithoutTenantId() {
        return withoutTenantId;
    }

    public String getTenantIdLike() {
        return tenantIdLike;
    }

    public void setTenantIdLike(String tenantIdLike) {
        this.tenantIdLike = tenantIdLike;
    }
    
    public String getTenantIdLikeIgnoreCase() {
        return tenantIdLikeIgnoreCase;
    }

    public void setTenantIdLikeIgnoreCase(String tenantIdLikeIgnoreCase) {
        this.tenantIdLikeIgnoreCase = tenantIdLikeIgnoreCase;
    }
}
