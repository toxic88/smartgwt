/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
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
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * A SearchForm is a DynamicForm specialized for a user to enter search criteria. <P> All DynamicForm properties and
 * methods work on SearchForm.  SearchForm extends and specializes DynamicForm for searching; for example, SearchForm sets
 * <code>hiliteRequiredFields</code> false by default because fields are typically not  required in a search.
 * @see com.smartgwt.client.widgets.form.DynamicForm
 */
public class SearchForm extends DynamicForm {

    public native static SearchForm getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("SearchForm",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["SearchForm"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["SearchForm"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public SearchForm(){
        scClassName = "SearchForm";
    }

    public SearchForm(JavaScriptObject jsObj){
        scClassName = "SearchForm";
        setJavaScriptObject(jsObj);
        
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************


    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} array, that property will be
     * respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}). Also note that individual dataBoundComponents may
     * have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell} may be overridden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEditFieldAttribute . See {@link com.smartgwt.client.docs.String String}. Default value is "canFilter"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditFieldAttribute(String canEditFieldAttribute)  throws IllegalStateException {
        setAttribute("canEditFieldAttribute", canEditFieldAttribute, false);
    }

    /**
     * If this component is bound to a dataSource, this attribute may be specified to customize what fields from the dataSource
     * may be edited by default. For example the {@link com.smartgwt.client.widgets.form.SearchForm} class has this attribute
     * set to <code>"canFilter"</code> which allows search forms to edit dataSource fields marked as <code>canEdit:false</code>
     * (but not those marked as <code>canFilter:false</code>). <P> Note that if <code>canEdit</code> is explicitly specified on
     * a field in  the {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} array, that property will be
     * respected in preference to  the canEditAttribute value. (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}). Also note that individual dataBoundComponents may
     * have additional logic around whether a field can be edited - for example {@link
     * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell} may be overridden.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCanEditFieldAttribute()  {
        return getAttributeAsString("canEditFieldAttribute");
    }


    /**
     * If this attribute is true any {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter:false} fields
     * specified on the dataSource will not be shown unless explicitly included in this component's {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields fields array}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFilterFieldsOnly showFilterFieldsOnly Default value is true
     */
    public void setShowFilterFieldsOnly(Boolean showFilterFieldsOnly) {
        setAttribute("showFilterFieldsOnly", showFilterFieldsOnly, true);
    }

    /**
     * If this attribute is true any {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter:false} fields
     * specified on the dataSource will not be shown unless explicitly included in this component's {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields fields array}
     *
     * @return Boolean
     */
    public Boolean getShowFilterFieldsOnly()  {
        return getAttributeAsBoolean("showFilterFieldsOnly");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param searchFormProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SearchForm searchFormProperties) /*-{
    	var properties = $wnd.isc.addProperties({},searchFormProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.SearchForm.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(SearchFormLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canEditFieldAttribute = getAttributeAsString("canEditFieldAttribute");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SearchForm.canEditFieldAttribute:" + t.getMessage() + "\n";
        }
        try {
            s.showFilterFieldsOnly = getAttributeAsString("showFilterFieldsOnly");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SearchForm.showFilterFieldsOnly:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        SearchFormLogicalStructure s = new SearchFormLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

