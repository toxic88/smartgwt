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
    * FormItem for managing a text field.

    */
public class TextItem extends FormItem {

    public static TextItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TextItem) obj;
        } else {
            return new TextItem(jsObj);
        }
    }


    public TextItem(){
        setType("TextItem");
    }

    public TextItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public TextItem(String name) {
        setName(name);
        setType("TextItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Default width for fields.
    *
    * @param width width Default value is 150
    */
    public void setWidth(int width) {
        setAttribute("width", width);
    }
    /**
     * Default width for fields.
     *
     *
     * @return int
     *
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    /**
    * Default height for text items.
    *
    * @param height height Default value is 19
    */
    public void setHeight(int height) {
        setAttribute("height", height);
    }
    /**
     * Default height for text items.
     *
     *
     * @return int
     *
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
    * Base CSS class name for this item's input element. NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
    *
    * @param textBoxStyle textBoxStyle Default value is "textItem"
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class name for this item's input element. NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
    * if set, maximum number of characters for this field
    *
    * @param length length Default value is null
    */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }
    /**
     * if set, maximum number of characters for this field
     *
     *
     * @return Integer
     *
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }

    /**
    * If this property is set to true, whenever this item is given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem}), all text within the item will be selected.<br> If false, the selection is not modified on focus - any previous selection within the item will be restored.<br> If unset, this property is derived from {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}
    *
    * @param selectOnFocus selectOnFocus Default value is null
    */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus);
    }
    /**
     * If this property is set to true, whenever this item is given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem}), all text within the item will be selected.<br> If false, the selection is not modified on focus - any previous selection within the item will be restored.<br> If unset, this property is derived from {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSelectOnFocus()  {
        return getAttributeAsBoolean("selectOnFocus");
    }

    // ********************* Methods ***********************

        /**
         * Returns the hint text for this item. Default implementation returns {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, or  null if there is no hint to show.
         *
         * @return HTML to show as the hint for the item
         */
        public native String getHint() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            return self.getHint();
        }-*/;

    // ********************* Static Methods ***********************

}



