/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * The ValuesManager manages data from multiple member forms. <P> If a single logical form needs to be separated into multiple DynamicForm instances for Layout purposes (for example, spanning one logical form across multiple Tabs), a ValuesManager can be used to make the forms act as one logical form, supporting all value-related APIs otherwise called on DynamicForm directly. <P> A ValuesManager has no visual representation - it is strictly a logical entity, and the member forms provide the user interface.  You can initialize a ValuesManager with a set of member forms (by setting {@link com.smartgwt.client.widgets.form.ValuesManager#getMembers members} at init) or add and remove member forms dynamically. <P> Calling {@link com.smartgwt.client.widgets.form.ValuesManager#setValues} on a ValuesManager will automatically route new field values to whichever member form is showing an editor for that field.  Likewise, calling {@link com.smartgwt.client.widgets.form.ValuesManager#validate} will validate all member forms, and {@link com.smartgwt.client.widgets.form.ValuesManager#saveData} will initiate a save operation which aggregates values from all member forms. <P> Like a DynamicForm, a ValuesManager can be databound by setting {@link com.smartgwt.client.widgets.form.ValuesManager#getDataSource dataSource}.  In this case all member forms must also be bound to the same DataSource. <P> In general, when working with a ValuesManager and its member forms, call APIs on the ValuesManager whenever you are dealing with values that span multiple forms, and only call APIs on member forms that are specific to that form or its fields. <P> Note that, just as a DynamicForm can track values that are not shown in any FormItem, a ValuesManager may track values for which there is no FormItem in any member form.  However, when using a ValuesManager these extra values are only allowed on the ValuesManager itself. Member forms will not track values for which they do not have FormItems.

    */
public class ValuesManager extends BaseClass {

    public static ValuesManager getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ValuesManager) obj;
        } else {
            return new ValuesManager(jsObj);
        }
    }


    public ValuesManager(){
        
    }

    public ValuesManager(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        return $wnd.isc.ValuesManager.create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * The error message for a failed validator that does not specify its own errorMessage.
    *
    * @param unknownErrorMessage unknownErrorMessage Default value is "Invalid value"
    */
    public void setUnknownErrorMessage(String unknownErrorMessage) {
        setAttribute("unknownErrorMessage", unknownErrorMessage, true);
    }
    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     *
     * @return String
     *
     */
    public String getUnknownErrorMessage()  {
        return getAttributeAsString("unknownErrorMessage");
    }

    /**
    * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validatiors (if any) will still run on attempted save.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param disableValidation disableValidation Default value is null
    */
    public void setDisableValidation(Boolean disableValidation) {
        setAttribute("disableValidation", disableValidation, true);
    }
    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validatiors (if any) will still run on attempted save.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDisableValidation()  {
        return getAttributeAsBoolean("disableValidation");
    }

    // ********************* Methods ***********************


        /**
         * Edit an existing record.  Updates this editors values to match the values of the record  passed in. <P> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType} to ensure  subsequent calls to <code>saveData()</code> will use an <code>update</code> rather than an <code>add</code> operation.
         * @param record the record to be edited as a map of field names to their corresponding values
         */
        public native void editRecord(ListGridRecord record) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.editRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;






        /**
         * This method exists for clean integration with existing server frameworks that have a 'cancel' feature which typically clears session state associated with the form.  When this method is called, an RPC is sent to the server with a parameter named {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName cancelParamName} with the value {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue cancelParamValue}.<p> Note that no other form data is sent.  By default the current top-level page is replaced with the reply.  If you wish to ignore the server reply instead, call this method like this: <pre> dynamicFormInstance.cancel({ignoreTimeout: true, target: null}); </pre>
         */
        public native void cancel() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.cancel();
        }-*/;

        /**
         * This method exists for clean integration with existing server frameworks that have a 'cancel' feature which typically clears session state associated with the form.  When this method is called, an RPC is sent to the server with a parameter named {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName cancelParamName} with the value {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue cancelParamValue}.<p> Note that no other form data is sent.  By default the current top-level page is replaced with the reply.  If you wish to ignore the server reply instead, call this method like this: <pre> dynamicFormInstance.cancel({ignoreTimeout: true, target: null}); </pre>
         * @param requestProperties additional properties to set on the RPCRequest                                          that will be issued
         */
        public native void cancel(DSRequest requestProperties) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.cancel(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;





        /**
         * Validate the current set of values for this values manager against validators defined in the member forms. For databound valuesManagers, also perform validation against any validators defined on datasource fields. <P> Note that if validation errors occur for a value that is not shown in any member forms, those errors will cause a warning and {@link com.smartgwt.client.widgets.form.ValuesManager#handleHiddenValidationErrors} will be called.  This can occur if:<br> - A datasource field has no correspending item in any member form<br> - The item in question is hidden<br> - The member form containing the item is hidden.
         *
         * @return true if all validation passed
         */
        public native Boolean validate() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            var retVal =self.validate();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;





        /**
         * Clears all errors from member forms.
         * @param showErrors If true, clear any visible error messages.
         */
        public native void clearErrors(boolean showErrors) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.clearErrors(showErrors);
        }-*/;

        /**
         * Clear all validation errors associated with some field in this form
         * @param fieldName field for which errors should be cleared
     * @param show if true, and the field is present in one of our member forms,                        redraw it to clear any currently visible validation errors
         */
        public native void clearFieldErrors(String fieldName, boolean show) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.clearFieldErrors(fieldName, show);
        }-*/;



        /**
         * Are there any errors associated with any fields in this valuesManager?
         *
         * @return returns true if there are any oustanding validation errors, false                   otherwise.
         */
        public native Boolean hasErrors() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            var retVal =self.hasErrors();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Are there any errors associated with a field in this valuesManager?
         * @param fieldName field to check for errors
         *
         * @return returns true if there are any oustanding validation errors, false                   otherwise.
         */
        public native Boolean hasFieldErrors(String fieldName) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            var retVal =self.hasFieldErrors(fieldName);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Method to explicitly show the latest set of validation errors present on this  ValuesManager.<br> Will redraw all member forms to display (or clear) currently visible errors, and fire {@link com.smartgwt.client.widgets.form.ValuesManager#handleHiddenValidationErrors} to allow custom handling of hidden errors.
         */
        public native void showErrors() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.showErrors();
        }-*/;

        /**
         * Method to explicitly show the latest set of validation errors present on some field  within this ValuesManager.<br> If the field in question is present as a visible item in a member form, the form item will be redrawn to display the error message(s). Otherwise {@link com.smartgwt.client.widgets.form.ValuesManager#handleHiddenValidationErrors} will be fired to allow  custom handling of hidden errors.
         */
        public native void showFieldErrors() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.showFieldErrors();
        }-*/;



        /**
         * Clear out all the values managed by this values manager.
         */
        public native void clearValues() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.clearValues();
        }-*/;




        /**
         * Same as {@link com.smartgwt.client.widgets.form.DynamicForm#reset}.
         */
        public native void resetValues() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.resetValues();
        }-*/;

        /**
         * Compares the current set of values with the values stored by the call to the          <code>rememberValues()</code> method. Returns true if the values have changed, and false          otherwise.
         *
         * @return true if current values do not match remembered values
         */
        public native Boolean valuesHaveChanged() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            var retVal =self.valuesHaveChanged();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;










        /**
         * Takes an item name (specified via the form.fieldIdProperty value, or retrieved via item.getFieldName()) returns a reference to the appropriate item in this valuesManager. <br>Note: Unlike the <code>DynamicForm</code> class, this method will not return an  item by index
         */
        public native void getItem() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.getItem();
        }-*/;


    // ********************* Static Methods ***********************







    /**
     * The DataSource that this component should bind to for default fields and for performing&#010 DataSource
     * requests<P>
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    
    /**
     * Set the values.
     *
     * @param values the values
     */
    public void setValues(Map values) {
        setAttribute("values", values, true);
    }

    /**
     * Return the value as String
     *
     * @return the value
     */
    public native String getValueAsString(String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null || val === undefined ? null : val.toString();
    }-*/;

    /**
     * Edit the record selected in the specified selection component (typically a {@link
     * com.smartgwt.client.widgets.grid.ListGrid}). <P> Updates the values of this editor to match the selected record's
     * values. <P> If this form has a dataSource, then saving via {@link com.smartgwt.client.widgets.form.ValuesManager#saveData}
     * will use the  "update" operation type.
     *
     * @param selectionComponent the ListGrid or ID of a {@link com.smartgwt.client.widgets.grid.ListGrid} whose
     *                           currently selected     record(s) is/are to be edited
     */
    public native void editSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editSelectedData(selectionComponentJS);
    }-*/;


    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     */
    public native void editNewRecord() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.editNewRecord();
    }-*/;

    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     *
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding values
     */
    public native void editNewRecord(Map initialValues) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var initialValuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(initialValues);
        return self.editNewRecord(initialValuesJS);
    }-*/;

    /**
     * Add a new member form to this valuesManager. This form's values will subsequently be available through this
     * valuesManager.  <br> Note on pre-existant values: If the valuesManager has a value specified for some field, for
     * which the member form has an item, this value will be applied to the member form.  This is true whether the item
     * has a value or not.<br> However if the member form has a value for some field, and the ValuesManager does not
     * have a specified value for the same field, we allow the valuesManager to pick up the  value from the member
     * form.
     *
     * @param member form (or ID of form) to add to                                           this valuesManager as a
     *               member.
     */
    public native void addMember(DynamicForm member) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var memberJS = member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addMember(memberJS);
    }-*/;

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Retrieve data that matches the provided criteria, and edit the first record returned
     *
     * @param criteria search criteria
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Retrieve data that matches the provided criteria, and edit the first record returned
     *
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Retrieve data that matches the provided criteria, and edit the first record returned
     *
     * @param criteria          search criteria
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Retrieve data that matches the provided criteria, and edit the first record returned.<br> Differs from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData} in that a case insensitive substring match will be
     * performed against the criteria to retrieve the data.
     *
     * @param criteria search criteria
     */
    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Retrieve data that matches the provided criteria, and edit the first record returned.<br> Differs from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData} in that a case insensitive substring match will be
     * performed against the criteria to retrieve the data.
     *
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     */
    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Retrieve data that matches the provided criteria, and edit the first record returned.<br> Differs from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData} in that a case insensitive substring match will be
     * performed against the criteria to retrieve the data.
     *
     * @param criteria          search criteria
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is
     * bound to. <p> If client-side validators are defined, they are executed first, and if any errors are found the
     * save is aborted and the form will show the errors. <p> If client-side validation passes, a {@link
     * com.smartgwt.client.data.DSRequest} will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData}
     * or {@link com.smartgwt.client.data.DataSource#updateData} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationType} will be either "update" or "add" depending on
     * whether values were initially provided via <code>editRecord()</code> or <code>editNew()</code>. <P> On either a
     * client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items
     * within a DynamicForms will be redrawn to display errors. Validation failure occuring on hidden items, or
     * DataSource fields with no  associated form items may be handled via {@link com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors}
     * or {@link com.smartgwt.client.widgets.form.ValuesManager#handleHiddenValidationErrors}. <P> {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValidationURL validationURL} can be set to do validation against
     * a different URL from where the form will ultimately save, as part of an incremental upgrade strategy for Struts
     * and Struts-like applications.
     */
    public native void saveData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.saveData();
    }-*/;

    /**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is
     * bound to. <p> If client-side validators are defined, they are executed first, and if any errors are found the
     * save is aborted and the form will show the errors. <p> If client-side validation passes, a {@link
     * com.smartgwt.client.data.DSRequest} will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData}
     * or {@link com.smartgwt.client.data.DataSource#updateData} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationType} will be either "update" or "add" depending on
     * whether values were initially provided via <code>editRecord()</code> or <code>editNew()</code>. <P> On either a
     * client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items
     * within a DynamicForms will be redrawn to display errors. Validation failure occuring on hidden items, or
     * DataSource fields with no  associated form items may be handled via {@link com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors}
     * or {@link com.smartgwt.client.widgets.form.ValuesManager#handleHiddenValidationErrors}. <P> {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValidationURL validationURL} can be set to do validation against
     * a different URL from where the form will ultimately save, as part of an incremental upgrade strategy for Struts
     * and Struts-like applications.
     *
     * @param callback callback to invoke on completion
     */
    public native void saveData(DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.saveData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is
     * bound to. <p> If client-side validators are defined, they are executed first, and if any errors are found the
     * save is aborted and the form will show the errors. <p> If client-side validation passes, a {@link
     * com.smartgwt.client.data.DSRequest} will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData}
     * or {@link com.smartgwt.client.data.DataSource#updateData} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationType} will be either "update" or "add" depending on
     * whether values were initially provided via <code>editRecord()</code> or <code>editNew()</code>. <P> On either a
     * client-side or server-side validation failure, validation errors will be displayed in the form.  Visible items
     * within a DynamicForms will be redrawn to display errors. Validation failure occuring on hidden items, or
     * DataSource fields with no  associated form items may be handled via {@link com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors}
     * or {@link com.smartgwt.client.widgets.form.ValuesManager#handleHiddenValidationErrors}. <P> {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValidationURL validationURL} can be set to do validation against
     * a different URL from where the form will ultimately save, as part of an incremental upgrade strategy for Struts
     * and Struts-like applications.
     *
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void saveData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.saveData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem}
     * included in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter
     * saveOnEnter} is set, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If
     * {@link com.smartgwt.client.widgets.form.DynamicForm#submitValues} exists, it will be called, then immediately
     * return. <P> Otherwise, default behavior varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit}: if <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}
     * will be called to handle saving via SmartClient databinding.   <P> If <code>canSubmit</code> is true, the form
     * will be submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm}.
     * <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.ValuesManager#saveData}.  If you override <code>submit()</code>, you can safely
     * ignore the parameters as SmartClient framework code does not pass them.
     */
    public native void submit() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.submit();
    }-*/;

    /**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem}
     * included in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter
     * saveOnEnter} is set, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If
     * {@link com.smartgwt.client.widgets.form.DynamicForm#submitValues} exists, it will be called, then immediately
     * return. <P> Otherwise, default behavior varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit}: if <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}
     * will be called to handle saving via SmartClient databinding.   <P> If <code>canSubmit</code> is true, the form
     * will be submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm}.
     * <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.ValuesManager#saveData}.  If you override <code>submit()</code>, you can safely
     * ignore the parameters as SmartClient framework code does not pass them.
     *
     * @param callback callback to invoke on completion.                                          [Ignored if
     *                 this.canSubmit is true]
     */
    public native void submit(DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.submit(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem}
     * included in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter
     * saveOnEnter} is set, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If
     * {@link com.smartgwt.client.widgets.form.DynamicForm#submitValues} exists, it will be called, then immediately
     * return. <P> Otherwise, default behavior varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit}: if <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}
     * will be called to handle saving via SmartClient databinding.   <P> If <code>canSubmit</code> is true, the form
     * will be submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm}.
     * <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.ValuesManager#saveData}.  If you override <code>submit()</code>, you can safely
     * ignore the parameters as SmartClient framework code does not pass them.
     *
     * @param callback          callback to invoke on completion.                                          [Ignored if
     *                          this.canSubmit is true]
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued                                          [Ignored if this.canSubmit
     *                          is true]
     */
    public native void submit(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.saveData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    

}


