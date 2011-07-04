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
 
package com.smartgwt.client.widgets.viewer;



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
    * Displays one or more records "horizontally" with one property per line.

    */
public class DetailViewer extends Canvas  implements DataBoundComponent {

    public static DetailViewer getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (DetailViewer) obj;
        } else {
            return new DetailViewer(jsObj);
        }
    }


    public DetailViewer(){
        
    }

    public DetailViewer(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.DetailViewer.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************
             
    /**
    * DetailViewers do not yet support paging, and will fetch and render all available&#010 records.
    *
    * @param dataFetchMode dataFetchMode Default value is "basic"
    */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode.getValue(), true);
    }
    /**
     * DetailViewers do not yet support paging, and will fetch and render all available&#010 records.
     *
     *
     * @return FetchMode
     *
     */
    public FetchMode getDataFetchMode()  {
        return (FetchMode) EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }

    /**
    * Name of the field in the DetailViewerRecord which specifies the data property for that record.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param fieldIdProperty fieldIdProperty Default value is "name"
    */
    public void setFieldIdProperty(String fieldIdProperty) {
        setAttribute("fieldIdProperty", fieldIdProperty, true);
    }
    /**
     * Name of the field in the DetailViewerRecord which specifies the data property for that record.
     *
     *
     * @return String
     *
     */
    public String getFieldIdProperty()  {
        return getAttributeAsString("fieldIdProperty");
    }

    /**
    * The number of records to display in a block. A block is a horizontal row on a page&#010          containing one or more records, as specified by the value of recordsPerBlock. The&#010          height of a block is equal to the height of a single record. The default setting of&#010          1 causes each record to appear by itself in a vertical row. Setting recordsPerBlock&#010          to 2 would cause records to appear side by side in groups of two.&#010          Use a value of "*" to indicate all records.
    *
    * @param recordsPerBlock recordsPerBlock Default value is 1
    */
    public void setRecordsPerBlock(int recordsPerBlock) {
        setAttribute("recordsPerBlock", recordsPerBlock, true);
    }
    /**
     * The number of records to display in a block. A block is a horizontal row on a page&#010          containing one or more records, as specified by the value of recordsPerBlock. The&#010          height of a block is equal to the height of a single record. The default setting of&#010          1 causes each record to appear by itself in a vertical row. Setting recordsPerBlock&#010          to 2 would cause records to appear side by side in groups of two.&#010          Use a value of "*" to indicate all records.
     *
     *
     * @return int
     *
     */
    public int getRecordsPerBlock()  {
        return getAttributeAsInt("recordsPerBlock");
    }

    /**
    * A string (HTML acceptable) that will be written to a page to separate blocks.
    *
    * @param blockSeparator blockSeparator Default value is "<BR><BR>"
    */
    public void setBlockSeparator(String blockSeparator) {
        setAttribute("blockSeparator", blockSeparator, true);
    }
    /**
     * A string (HTML acceptable) that will be written to a page to separate blocks.
     *
     *
     * @return String
     *
     */
    public String getBlockSeparator()  {
        return getAttributeAsString("blockSeparator");
    }

    /**
    * Whether to show the field when the value is null
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showEmptyField showEmptyField Default value is true
    */
    public void setShowEmptyField(Boolean showEmptyField) {
        setAttribute("showEmptyField", showEmptyField, true);
    }
    /**
     * Whether to show the field when the value is null
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEmptyField()  {
        return getAttributeAsBoolean("showEmptyField");
    }

    /**
    * Text to show for an empty cell
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param emptyCellValue emptyCellValue Default value is "&nbsp;"
    */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue, true);
    }
    /**
     * Text to show for an empty cell
     *
     *
     * @return String
     *
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
    * text to put before a label
    *
    * @param labelPrefix labelPrefix Default value is ""
    */
    public void setLabelPrefix(String labelPrefix) {
        setAttribute("labelPrefix", labelPrefix, true);
    }
    /**
     * text to put before a label
     *
     *
     * @return String
     *
     */
    public String getLabelPrefix()  {
        return getAttributeAsString("labelPrefix");
    }

    /**
    * text to put after a label
    *
    * @param labelSuffix labelSuffix Default value is ":"
    */
    public void setLabelSuffix(String labelSuffix) {
        setAttribute("labelSuffix", labelSuffix, true);
    }
    /**
     * text to put after a label
     *
     *
     * @return String
     *
     */
    public String getLabelSuffix()  {
        return getAttributeAsString("labelSuffix");
    }

    /**
    * Should the label be allowed to wrap, or be fixed to one line no matter how long
    *
    * @param wrapLabel wrapLabel Default value is false
    */
    public void setWrapLabel(Boolean wrapLabel) {
        setAttribute("wrapLabel", wrapLabel, true);
    }
    /**
     * Should the label be allowed to wrap, or be fixed to one line no matter how long
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrapLabel()  {
        return getAttributeAsBoolean("wrapLabel");
    }

    /**
    * Whether values should be allowed to wrap by default, or should be shown on one line&#010 regardless of length.
    *
    * @param wrapValues wrapValues Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setWrapValues(Boolean wrapValues)  throws IllegalStateException {
        setAttribute("wrapValues", wrapValues, false);
    }
    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line&#010 regardless of length.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrapValues()  {
        return getAttributeAsBoolean("wrapValues");
    }

    /**
    * CSS style for the component as a whole.
    *
    * @param styleName styleName Default value is "detailViewer"
    */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }
    /**
     * CSS style for the component as a whole.
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
    * CSS style for each block (one record's worth of data).
    *
    * @param blockStyle blockStyle Default value is "detailBlock"
    */
    public void setBlockStyle(String blockStyle) {
        setAttribute("blockStyle", blockStyle, true);
    }
    /**
     * CSS style for each block (one record's worth of data).
     *
     *
     * @return String
     *
     */
    public String getBlockStyle()  {
        return getAttributeAsString("blockStyle");
    }

    /**
    * CSS style for a normal detail label
    *
    * @param labelStyle labelStyle Default value is "detailLabel"
    */
    public void setLabelStyle(String labelStyle) {
        setAttribute("labelStyle", labelStyle, true);
    }
    /**
     * CSS style for a normal detail label
     *
     *
     * @return String
     *
     */
    public String getLabelStyle()  {
        return getAttributeAsString("labelStyle");
    }

    /**
    * CSS style for a normal value
    *
    * @param cellStyle cellStyle Default value is "detail"
    */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle, true);
    }
    /**
     * CSS style for a normal value
     *
     *
     * @return Return the CSS class for a cell. Default implementation calls&#010 {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getCellStyle} on the field if defined, otherwise&#010 returns {@link com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle}&#010
     *
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }

    /**
    * CSS style for a header
    *
    * @param headerStyle headerStyle Default value is "detailHeader"
    */
    public void setHeaderStyle(String headerStyle) {
        setAttribute("headerStyle", headerStyle, true);
    }
    /**
     * CSS style for a header
     *
     *
     * @return String
     *
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }

    /**
    * CSS style for a separator
    *
    * @param separatorStyle separatorStyle Default value is "detail"
    */
    public void setSeparatorStyle(String separatorStyle) {
        setAttribute("separatorStyle", separatorStyle, true);
    }
    /**
     * CSS style for a separator
     *
     *
     * @return String
     *
     */
    public String getSeparatorStyle()  {
        return getAttributeAsString("separatorStyle");
    }
             
    /**
    * Display format to use for fields specified as type 'date'.  Default is to use the&#010 system-wide default normal date format, configured via&#010 {@link com.smartgwt.client..Date#setNormalDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to&#010 change the format used by this detailViewer.
    *
    * @param dateFormatter dateFormatter Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter)  throws IllegalStateException {
        setAttribute("dateFormatter", dateFormatter.getValue(), false);
    }
    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the&#010 system-wide default normal date format, configured via&#010 {@link com.smartgwt.client..Date#setNormalDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to&#010 change the format used by this detailViewer.
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDateFormatter()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
    * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to display?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showEmptyMessage showEmptyMessage Default value is true
    */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }
    /**
     * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to display?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEmptyMessage()  {
        return getAttributeAsBoolean("showEmptyMessage");
    }

    /**
    * The string to display in the body of a detailViewer with no records.
    *
    * @param emptyMessage emptyMessage Default value is "No items to display."
    */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }
    /**
     * The string to display in the body of a detailViewer with no records.
     *
     *
     * @return String
     *
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }

    /**
    * CSS style to display this message in
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param emptyMessageStyle emptyMessageStyle Default value is "normal"
    */
    public void setEmptyMessageStyle(String emptyMessageStyle) {
        setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }
    /**
     * CSS style to display this message in
     *
     *
     * @return String
     *
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }

    /**
    * The string to display in the body of a detailViewer which is loading records.
    *
    * @param loadingMessage loadingMessage Default value is "&nbsp;"
    */
    public void setLoadingMessage(String loadingMessage) {
        setAttribute("loadingMessage", loadingMessage, true);
    }
    /**
     * The string to display in the body of a detailViewer which is loading records.
     *
     *
     * @return String
     *
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    /**
    * CSS style to use for the {@link com.smartgwt.client.widgets.viewer.DetailViewer#getLoadingMessage loadingMessage}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param loadingMessageStyle loadingMessageStyle Default value is "normal"
    */
    public void setLoadingMessageStyle(String loadingMessageStyle) {
        setAttribute("loadingMessageStyle", loadingMessageStyle, true);
    }
    /**
     * CSS style to use for the {@link com.smartgwt.client.widgets.viewer.DetailViewer#getLoadingMessage loadingMessage}.
     *
     *
     * @return String
     *
     */
    public String getLoadingMessageStyle()  {
        return getAttributeAsString("loadingMessageStyle");
    }

    // ********************* Methods ***********************


        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource} to &#010 retrieve data that matches the current filter and sort criteria for this component, then &#010 exports the resulting data to a file or window in the requested format.&#010 <P>&#010 For more information on exporting data, see {@link com.smartgwt.client.data.DataSource#exportData}.&#010&#010
         */
        public native void exportData() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData();
        }-*/;

        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource} to &#010 retrieve data that matches the current filter and sort criteria for this component, then &#010 exports the resulting data to a file or window in the requested format.&#010 <P>&#010 For more information on exporting data, see {@link com.smartgwt.client.data.DataSource#exportData}.&#010&#010
         * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
         */
        public native void exportData(DSRequest requestProperties) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;






    // ********************* Static Methods ***********************





    /**
     * An array of records, specifying data. Note that DetailViewers do not observe changes to the data array (in other
     * words they will not automatically re-draw when the data provided via this property is altered)
     *
     * @param data the data
     */
    public void setData(DetailViewerRecord[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data array of Record objects.
     * @see #setData(DetailViewerRecord[])   
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    //TODO
    //public DetailViewerRecord[] getData()

    /**
     * An array of field objects, specifying the order and type of fields to display in this DetailViewer. In
     * DetailViewers, the fields specify rows.
     *
     * @param fields the fields
     */
    public void setFields(DetailViewerField... fields) {
        setAttribute("fields", fields, true);
    }

    //TODO getFields

    /**
     * If true, the set of fields given by the "default binding" (see DataBoundComponent.fields) is used, with any
     * fields specified in component.fields acting as overrides that can suppress or modify the display of individual
     * fields, without having to list the entire set of fields that should be shown.
     * <p/>
     * If component.fields contains fields that are not found in the DataSource, they will be shown after the most
     * recently referred to DataSource field. If the new fields appear first, they will be shown first.
     *
     * @param useAllDataSourceFields useAllDataSourceFields
     */
    public void setUseAllDataSourceFields(boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    /**
     * Displays the currently selected record(s) of the ListGrid in the detailViewer.
     *
     * @param selectionComponent the ListGrid whose currently selected record(s) is/are to be edited
     */
    public native void viewSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.grid.ListGrid::getJsObj()();
        self.viewSelectedData(selectionComponentJS);
    }-*/;

    /**
     * Displays the currently selected record(s) of the ListGrid in the detailViewer.
     *
     * @param selectionComponentID the ID of a ListGrid whose currently selected record(s) is/are to be edited
     */
    public native void viewSelectedData(String selectionComponentID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.viewSelectedData(selectionComponentID);
    }-*/;






    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        return getAttributeAsInt("dataPageSize");
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowDetailFields(Boolean showDetailFields) {
        setAttribute("showDetailFields", showDetailFields, true);
    }

    public Boolean getShowDetailFields() {
        return getAttributeAsBoolean("showDetailFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }
    public String[] getExportFields()  {
         return getAttributeAsStringArray("exportFields");
     }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
         setAttribute("dropValues", dropValues, true);
     }

    public Map getDropValues()  {
         return getAttributeAsMap("dropValues");
     }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return (DragDataAction) EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************


    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record);
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData)  throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter)  throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter()  {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

}


