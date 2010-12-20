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
 
package com.smartgwt.client.widgets.form.fields;



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
    * FormItem that allows picking a value from a hierarchical data model.

    */
public class PickTreeItem extends CanvasItem {

    public static PickTreeItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (PickTreeItem) obj;
        } else {
            return new PickTreeItem(jsObj);
        }
    }


    public PickTreeItem(){
        setType("PickTreeItem");
    }

    public PickTreeItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public PickTreeItem(String name) {
        setName(name);
        setType("PickTreeItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * If this is a databound item, should the load our set of possible options be loaded on demand (as submenus are displayed), or upfront?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param loadDataOnDemand loadDataOnDemand Default value is null
    */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand) {
        setAttribute("loadDataOnDemand", loadDataOnDemand);
    }
    /**
     * If this is a databound item, should the load our set of possible options be loaded on demand (as submenus are displayed), or upfront?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }

    /**
    * Specifies an alternative field from which display values should be retrieved for this item.<br> If this item is not databound ({@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} is unset), this is implemented by picking up the value of the specified field from the {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueTree valueTree}.<br> Otherwise this item will attempt to map its underlying value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} where the  {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueField valueField} matches this item's value, and displaying the  <code>displayField</code> value from that record.<br>
    *
    * @param displayField displayField Default value is null
    */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }
    /**
     * Specifies an alternative field from which display values should be retrieved for this item.<br> If this item is not databound ({@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} is unset), this is implemented by picking up the value of the specified field from the {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueTree valueTree}.<br> Otherwise this item will attempt to map its underlying value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} where the  {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueField valueField} matches this item's value, and displaying the  <code>displayField</code> value from that record.<br>
     *
     *
     * @return String
     *
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
    * Which field in the tree-data should be returned as this item's value? If unspecified, the path will be used
    *
    * @param valueField valueField Default value is null
    */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }
    /**
     * Which field in the tree-data should be returned as this item's value? If unspecified, the path will be used
     *
     *
     * @return String
     *
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }

    /**
    * This message will be displayed as a singled, disabled option in any empty menu/submenu created from this item's data tree.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param emptyMenuMessage emptyMenuMessage Default value is "No items to display"
    */
    public void setEmptyMenuMessage(String emptyMenuMessage) {
        setAttribute("emptyMenuMessage", emptyMenuMessage);
    }
    /**
     * This message will be displayed as a singled, disabled option in any empty menu/submenu created from this item's data tree.
     *
     *
     * @return String
     *
     */
    public String getEmptyMenuMessage()  {
        return getAttributeAsString("emptyMenuMessage");
    }

    /**
    * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of hiding the menus, calling click  handlers, etc) instead of showing the submenu.
    *
    * @param canSelectParentItems canSelectParentItems Default value is null
    */
    public void setCanSelectParentItems(Boolean canSelectParentItems) {
        setAttribute("canSelectParentItems", canSelectParentItems);
    }
    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of hiding the menus, calling click  handlers, etc) instead of showing the submenu.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanSelectParentItems()  {
        return getAttributeAsBoolean("canSelectParentItems");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************





    /**
     * If specified, the tree of possible options will be derived from the dataSource as a ResultTree, rather than using
     * this.valueTree.  Options can be loaded on demand or up front according tp {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getLoadDataOnDemand loadDataOnDemand}. <p><b>Note : </b>
     * This is an advanced setting</p>
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj());
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
     * A {@link com.smartgwt.client.widgets.tree.Tree} of options from which the user can select.
     *
     * @param valueTree valueTree Default value is null
     */
    public void setValueTree(Tree valueTree) {
        setAttribute("valueTree", valueTree);
    }

}


