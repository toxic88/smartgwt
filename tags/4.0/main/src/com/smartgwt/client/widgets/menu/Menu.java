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
 
package com.smartgwt.client.widgets.menu;


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
 * The Menu widget class implements interactive menu widgets, with optional icons, submenus, and shortcut keys. <p> A Menu
 * is initialized with an Array of items, specified as menu.data, each of which represents one row in the menu's display
 * and specifies the action to take when that menu item is selected. <p> Generally to create a context menu for a
 * component, provide a Menu instance for the <code>contextMenu</code> property.  Note that some components have special
 * context menu support because they have distinct regions or because they have a default set of context menu actions
 * available. <p> If you want a button that pops up a menu when clicked, or a bar of such buttons, see the MenuButton and
 * MenuBar classes.
 * @see com.smartgwt.client.widgets.menu.Menu#getData
 * @see com.smartgwt.client.widgets.Canvas#getContextMenu
 * @see com.smartgwt.client.widgets.menu.MenuButton
 * @see com.smartgwt.client.widgets.menu.MenuBar
 */
public class Menu extends ListGrid  implements com.smartgwt.client.widgets.menu.events.HasItemClickHandlers {

    public native static Menu getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("Menu",jsObj);
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
        $wnd.isc["Menu"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["Menu"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public Menu(){
        setAlternateRecordStyles(false);scClassName = "Menu";
    }

    public Menu(JavaScriptObject jsObj){
        scClassName = "Menu";
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
     * Explicitly disable alternateRecordStyles at the menu level by default so setting to true for all ListGrids will not
     * impact menus' appearance.
     *
     * @param alternateRecordStyles alternateRecordStyles Default value is false
     */
    public void setAlternateRecordStyles(Boolean alternateRecordStyles) {
        setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }

    /**
     * Explicitly disable alternateRecordStyles at the menu level by default so setting to true for all ListGrids will not
     * impact menus' appearance.
     *
     * @return Boolean
     */
    public Boolean getAlternateRecordStyles()  {
        return getAttributeAsBoolean("alternateRecordStyles");
    }


    /**
     * When false, when a menu item is chosen (via mouse click or keyboard), the menu is not automatically hidden, staying in
     * place for further interactivity
     *
     * @param autoDismiss autoDismiss Default value is true
     * @see com.smartgwt.client.widgets.menu.Menu#setCascadeAutoDismiss
     */
    public void setAutoDismiss(Boolean autoDismiss) {
        setAttribute("autoDismiss", autoDismiss, true);
    }

    /**
     * When false, when a menu item is chosen (via mouse click or keyboard), the menu is not automatically hidden, staying in
     * place for further interactivity
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.menu.Menu#getCascadeAutoDismiss
     */
    public Boolean getAutoDismiss()  {
        return getAttributeAsBoolean("autoDismiss");
    }


    /**
     * When false, when a user clicks outside the menu, or hits the Escape key, this menu will not be automatically hidden,
     * staying in place for further interactivity.
     *
     * @param autoDismissOnBlur autoDismissOnBlur Default value is true
     */
    public void setAutoDismissOnBlur(Boolean autoDismissOnBlur) {
        setAttribute("autoDismissOnBlur", autoDismissOnBlur, true);
    }

    /**
     * When false, when a user clicks outside the menu, or hits the Escape key, this menu will not be automatically hidden,
     * staying in place for further interactivity.
     *
     * @return Boolean
     */
    public Boolean getAutoDismissOnBlur()  {
        return getAttributeAsBoolean("autoDismissOnBlur");
    }


    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoDraw autoDraw Default value is false
     */
    public void setAutoDraw(Boolean autoDraw) {
        setAttribute("autoDraw", autoDraw, true);
    }

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     *
     * @return Boolean
     */
    public Boolean getAutoDraw()  {
        return getAttributeAsBoolean("autoDraw");
    }


    /**
     * CSS style for a normal cell
     *
     * @param baseStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "menu"
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * CSS style for a normal cell
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }


    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of
     * hiding the menus, calling click  handlers, etc) instead of showing the submenu.
     *
     * @param canSelectParentItems canSelectParentItems Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public void setCanSelectParentItems(Boolean canSelectParentItems) {
        setAttribute("canSelectParentItems", canSelectParentItems, true);
    }

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of
     * hiding the menus, calling click  handlers, etc) instead of showing the submenu.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public Boolean getCanSelectParentItems()  {
        return getAttributeAsBoolean("canSelectParentItems");
    }


    /**
     * When true any generated submenus will inherit {@link com.smartgwt.client.widgets.menu.Menu#getAutoDismiss autoDismiss}
     * from this menu.
     *
     * @param cascadeAutoDismiss cascadeAutoDismiss Default value is true
     */
    public void setCascadeAutoDismiss(Boolean cascadeAutoDismiss) {
        setAttribute("cascadeAutoDismiss", cascadeAutoDismiss, true);
    }

    /**
     * When true any generated submenus will inherit {@link com.smartgwt.client.widgets.menu.Menu#getAutoDismiss autoDismiss}
     * from this menu.
     *
     * @return Boolean
     */
    public Boolean getCascadeAutoDismiss()  {
        return getAttributeAsBoolean("cascadeAutoDismiss");
    }


    /**
     * The height of each item in the menu, in pixels.
     *
     * @param cellHeight cellHeight Default value is 20
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setCellHeight(int cellHeight) {
        setAttribute("cellHeight", cellHeight, true);
    }

    /**
     * The height of each item in the menu, in pixels.
     *
     * @return int
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }





    /**
     * Optional DataSource to fetch menuItems and submenus from, instead of using {@link
     * com.smartgwt.client.widgets.menu.Menu#getData data}/menu.items. <P> The provided DataSource must be set up for
     * hierarchical fetching - see the {@link com.smartgwt.client.docs.TreeDataBinding Tree Data Binding overview}.
     *
     * @param dataSource dataSource Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataSource(DataSource dataSource)  throws IllegalStateException {
        setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * Optional DataSource to fetch menuItems and submenus from, instead of using {@link
     * com.smartgwt.client.widgets.menu.Menu#getData data}/menu.items. <P> The provided DataSource must be set up for
     * hierarchical fetching - see the {@link com.smartgwt.client.docs.TreeDataBinding Tree Data Binding overview}.
     *
     * @return DataSource
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }


    /**
     * The default menu width.
     *
     * @param defaultWidth defaultWidth Default value is 150
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setDefaultWidth(int defaultWidth) {
        setAttribute("defaultWidth", defaultWidth, true);
    }

    /**
     * The default menu width.
     *
     * @return int
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }


    /**
     * Message to show when a menu is shown with no items.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyMessage . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "[Empty menu]"
     */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * Message to show when a menu is shown with no items.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }


    /**
     * When using a Tree or hierarchical DataSource as the menu's data, submenus are automatically generated from child nodes. 
     * <code>fetchSubmenus</code> can be set to false to disable this for the whole menu, or can be set false on a per-item
     * basis via {@link com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus fetchSubmenus}.
     *
     * @param fetchSubmenus fetchSubmenus Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFetchSubmenus(Boolean fetchSubmenus)  throws IllegalStateException {
        setAttribute("fetchSubmenus", fetchSubmenus, false);
    }

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, submenus are automatically generated from child nodes. 
     * <code>fetchSubmenus</code> can be set to false to disable this for the whole menu, or can be set false on a per-item
     * basis via {@link com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus fetchSubmenus}.
     *
     * @return Boolean
     */
    public Boolean getFetchSubmenus()  {
        return getAttributeAsBoolean("fetchSubmenus");
    }



    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @param iconHeight iconHeight Default value is 16
     */
    public void setIconHeight(int iconHeight) {
        setAttribute("iconHeight", iconHeight, true);
    }

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @return int
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }


    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @param iconWidth iconWidth Default value is 16
     */
    public void setIconWidth(int iconWidth) {
        setAttribute("iconWidth", iconWidth, true);
    }

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @return int
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }



    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     * @param menuButtonWidth menuButtonWidth Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMenuButtonWidth(Integer menuButtonWidth)  throws IllegalStateException {
        setAttribute("menuButtonWidth", menuButtonWidth, false);
    }

    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     * @return Integer
     */
    public Integer getMenuButtonWidth()  {
        return getAttributeAsInt("menuButtonWidth");
    }


    /**
     * When this menu is shown how should it animate into view? By default the menu will just show at the specified
     * size/position. Options for animated show effects are <code>"fade"</code> to fade from transparent to visible,
     * <code>"slide"</code> to slide the menu into view, or <code>"wipe"</code> to have the menu grow into view, revealing its
     * content as it grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showAnimationEffect . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setShowAnimationEffect(String showAnimationEffect) {
        setAttribute("showAnimationEffect", showAnimationEffect, true);
    }

    /**
     * When this menu is shown how should it animate into view? By default the menu will just show at the specified
     * size/position. Options for animated show effects are <code>"fade"</code> to fade from transparent to visible,
     * <code>"slide"</code> to slide the menu into view, or <code>"wipe"</code> to have the menu grow into view, revealing its
     * content as it grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getShowAnimationEffect()  {
        return getAttributeAsString("showAnimationEffect");
    }


    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed. If showIcons is not set, the menu
     * will show the icon column only if one of its items specifies an icon, checked, checkIf, or dynamicIcon property.
     *
     * @param showIcons showIcons Default value is true
     */
    public void setShowIcons(Boolean showIcons) {
        setAttribute("showIcons", showIcons, true);
    }

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed. If showIcons is not set, the menu
     * will show the icon column only if one of its items specifies an icon, checked, checkIf, or dynamicIcon property.
     *
     * @return Boolean
     */
    public Boolean getShowIcons()  {
        return getAttributeAsBoolean("showIcons");
    }


    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     * @param showKeys showKeys Default value is true
     */
    public void setShowKeys(Boolean showKeys) {
        setAttribute("showKeys", showKeys, true);
    }

    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     * @return Boolean
     */
    public Boolean getShowKeys()  {
        return getAttributeAsBoolean("showKeys");
    }


    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * @param showSubmenus showSubmenus Default value is true
     */
    public void setShowSubmenus(Boolean showSubmenus) {
        setAttribute("showSubmenus", showSubmenus, true);
    }

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * @return Boolean
     */
    public Boolean getShowSubmenus()  {
        return getAttributeAsBoolean("showSubmenus");
    }


    /**
     * When using a Tree or hierarchical DataSource as the menu's data, optional subclass of Menu that should be used when
     * generating submenus.
     *
     * @param submenuConstructor . See {@link com.smartgwt.client.docs.SCClassName SCClassName}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubmenuConstructor(String submenuConstructor)  throws IllegalStateException {
        setAttribute("submenuConstructor", submenuConstructor, false);
    }

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, optional subclass of Menu that should be used when
     * generating submenus.
     *
     * @return . See {@link com.smartgwt.client.docs.SCClassName SCClassName}
     */
    public String getSubmenuConstructor()  {
        return getAttributeAsString("submenuConstructor");
    }


    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code> or <code>"right"</code>. If
     * unset, submenus show up on the right by default in Left-to-right text mode, or on the left in Right-to-left text mode
     * (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL}).
     *
     * @param submenuDirection . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setSubmenuDirection(String submenuDirection) {
        setAttribute("submenuDirection", submenuDirection, true);
    }

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code> or <code>"right"</code>. If
     * unset, submenus show up on the right by default in Left-to-right text mode, or on the left in Right-to-left text mode
     * (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL}).
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getSubmenuDirection()  {
        return getAttributeAsString("submenuDirection");
    }




    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf}. <P> Whenever a Menu is shown as a contextMenu by a
     * widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} being set, <code>menu.target</code>
     * is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @param target target Default value is null
     */
    public void setTarget(Canvas target) {
        setAttribute("target", target == null ? null : target.getOrCreateJsObj(), true);
    }

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf}. <P> Whenever a Menu is shown as a contextMenu by a
     * widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} being set, <code>menu.target</code>
     * is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @return Canvas
     */
    public Canvas getTarget()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("target"));
    }


    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @param useKeys useKeys Default value is true
     */
    public void setUseKeys(Boolean useKeys) {
        setAttribute("useKeys", useKeys, true);
    }

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @return Boolean
     */
    public Boolean getUseKeys()  {
        return getAttributeAsBoolean("useKeys");
    }

    // ********************* Methods ***********************
	/**
     * Get a particular MenuItem by index. <P> If passed a MenuItem, returns it.
     * @param item index of the MenuItem
     *
     * @return the MenuItem, Pointer to the item, or null if not defined
     */
    public native MenuItem getItem(int item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getItem(item);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.menu.MenuItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Hide the context menu - alias for hide()
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public native void hideContextMenu() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideContextMenu();
    }-*/;
    /**
     * Add a itemClick handler.
     * <p>
     * Executed when a menu item with no click handler is clicked by the user. This          itemClick handler must be
     * specified as a function. It is passed an item parameter that          is a reference to the clicked menu item.
     *
     * @param handler the itemClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemClickHandler(com.smartgwt.client.widgets.menu.events.ItemClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType()) == 0) setupItemClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType());
    }

    private native void setupItemClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var itemClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.menu.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemClick: 
                function () {
                    var param = {"item" : arguments[0], "colNum" : arguments[1]};
                    return itemClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemClick = 
                function () {
                    var param = {"item" : arguments[0], "colNum" : arguments[1]};
                    return itemClick(param) == true;
                }
            ;
        }
   }-*/;
	/**
     * Show this menu as a context menu, that is, immediately adjacent to the current mouse position.
     *
     * @return false == stop processing this event
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public native Boolean showContextMenu() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.showContextMenu();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    // ********************* Static Methods ***********************
	/**
     * Hide all menus that are currently open. This method is useful to hide the current set of menus including submenus, and
     * dismiss the menu's clickMask.
     */
    public static native void hideAllMenus() /*-{
        $wnd.isc.Menu.hideAllMenus();
    }-*/;
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
     * @param menuProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Menu menuProperties) /*-{
    	var properties = $wnd.isc.addProperties({},menuProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Menu.addProperties(properties);
    }-*/;

    // ***********************************************************


    //override to avoid ListGrid's onInit behavior
    protected void onInit_ListGrid() {
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show.
     *
     * @param data menu items
     */
    public void setData(MenuItem... data) {
        setAttribute("data", data, true);
    }

    /**
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data array of Record objects.
     * @see #setData(MenuItem[])
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * Display a hierarchical set of menu items and submenus based on a
     * Tree of data.
     *
     * @param data Tree
     */
    public void setData(Tree data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * An List of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data List of Records
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * Synonym for {@link com.smartgwt.client.widgets.menu.Menu#getData data} Synonym for {@link
     * com.smartgwt.client.widgets.menu.Menu#setData}.
     *
     * @param items new items for this menu. Default value is null
     */
    public void setItems(MenuItem... items) {
        setAttribute("items", items, true);
    }

    /**
     * Return the menu items.
     *
     * @return the menu items
     */
    public MenuItem[] getItems() {
        JavaScriptObject dataJS;
        if (!this.isCreated()) {
            dataJS = getAttributeAsJavaScriptObject("items");
        } else {
            dataJS = getAttributeAsJavaScriptObject("data");
        }
        if (dataJS == null) return null;
        MenuItem[] data = com.smartgwt.client.util.ConvertTo.arrayOfMenuItem(dataJS);
        return data;
    }

    /**
     * When used in a MenuBar, the title of the menu button create will be the title of the Menu.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    public native void removeItem(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeItem(itemJS);
    }-*/;

    public void addItem(MenuItem item) {
        JavaScriptObject itemJS = item.getJsObj();

        if (isCreated()) {
            addItemPostCreate(itemJS);

        } else {
            addItemPreCreate(itemJS);
        }
    }

    private native void addItemPreCreate(JavaScriptObject itemJS) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.items) {
            config.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.items.push(itemJS);
    }-*/;

    private native void addItemPostCreate(JavaScriptObject itemJS) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addItem(itemJS);
    }-*/;

    public native void addItem(MenuItem item, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addItem(itemJS, index);
    }-*/;

    /**
     * Given a MenuItem, return it's index in the items array.
     * @param item the MenuItem
     *
     * @return index of the item, or -1 if not defined.
     */
    public native int getItemNum(MenuItem  item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getItemNum(itemJS);
    }-*/;

    /**
     * Set arbitrary properties for a particular menu item.
     * @param item index of the MenuItem
     * @param properties properties to apply to the item
     */
    public native void setItemProperties(int item, MenuItem properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var props = properties.@com.smartgwt.client.widgets.menu.MenuItem::getJsObj()();
        self.setItemProperties(item, props);
    }-*/;

    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemChecked(itemJS);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(int item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemChecked(item);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     * @param newState true to check the menu item, false to uncheck it.  If not                             passed, true is assumed
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(MenuItem item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemChecked(itemJS, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     * @param newState true to check the menu item, false to uncheck it.  If not                             passed, true is assumed
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(int item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemChecked(item, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemEnabled(itemJS);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(int item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemEnabled(item);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     * @param newState true to enable the menu item, false to disable it.  If not                             passed, true is assumed
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(MenuItem item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemEnabled(itemJS, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     * @param newState true to enable the menu item, false to disable it.  If not                             passed, true is assumed
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(int item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemEnabled(item, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(MenuItem item, String newIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemIcon(itemJS, newIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(int item, String newIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemIcon(item, newIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     * @param newDisabledIcon new icon URL for disabled image
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(MenuItem item, String newIcon, String newDisabledIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemIcon(itemJS, newIcon, newDisabledIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     * @param newDisabledIcon new icon URL for disabled image
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(int item, String newIcon, String newDisabledIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemIcon(item, newIcon, newDisabledIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the title of a particular menu item to the string specified by newTitle and redraws the menu if necessary.
     * @param item MenuItem in question, or it's index
     * @param newTitle new title
     *
     * @return true if the title was changed, and false otherwise
     */
    public native Boolean setItemTitle(MenuItem item, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemTitle(itemJS, newTitle);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the title of a particular menu item to the string specified by newTitle and redraws the menu if necessary.
     * @param item MenuItem in question, or it's index
     * @param newTitle new title
     *
     * @return true if the title was changed, and false otherwise
     */
    public native Boolean setItemTitle(int item, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemTitle(item, newTitle);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    public LogicalStructureObject setLogicalStructure(MenuLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alternateRecordStyles = getAttributeAsString("alternateRecordStyles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.alternateRecordStyles:" + t.getMessage() + "\n";
        }
        try {
            s.autoDismiss = getAttributeAsString("autoDismiss");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.autoDismiss:" + t.getMessage() + "\n";
        }
        try {
            s.autoDismissOnBlur = getAttributeAsString("autoDismissOnBlur");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.autoDismissOnBlur:" + t.getMessage() + "\n";
        }
        try {
            s.autoDraw = getAttributeAsString("autoDraw");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.autoDraw:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.canSelectParentItems = getAttributeAsString("canSelectParentItems");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.canSelectParentItems:" + t.getMessage() + "\n";
        }
        try {
            s.cascadeAutoDismiss = getAttributeAsString("cascadeAutoDismiss");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.cascadeAutoDismiss:" + t.getMessage() + "\n";
        }
        try {
            s.cellHeight = getAttributeAsString("cellHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.cellHeight:" + t.getMessage() + "\n";
        }
        try {
            s.dataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.dataSource:" + t.getMessage() + "\n";
        }
        try {
            s.defaultWidth = getAttributeAsString("defaultWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.defaultWidth:" + t.getMessage() + "\n";
        }
        try {
            s.emptyMessage = getAttributeAsString("emptyMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.emptyMessage:" + t.getMessage() + "\n";
        }
        try {
            s.fetchSubmenus = getAttributeAsString("fetchSubmenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fetchSubmenus:" + t.getMessage() + "\n";
        }
        try {
            s.fieldsAsStringArrayArray = getAttributeAsStringArray("fields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fieldsAsStringArrayArray:" + t.getMessage() + "\n";
        }
        try {
            s.iconHeight = getAttributeAsString("iconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.iconWidth = getAttributeAsString("iconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.items = getItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.itemsArray:" + t.getMessage() + "\n";
        }
        try {
            s.menuButtonWidth = getAttributeAsString("menuButtonWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.menuButtonWidth:" + t.getMessage() + "\n";
        }
        try {
            s.showAnimationEffect = getAttributeAsString("showAnimationEffect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showAnimationEffect:" + t.getMessage() + "\n";
        }
        try {
            s.showIcons = getAttributeAsString("showIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showKeys = getAttributeAsString("showKeys");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showKeys:" + t.getMessage() + "\n";
        }
        try {
            s.showSubmenus = getAttributeAsString("showSubmenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showSubmenus:" + t.getMessage() + "\n";
        }
        try {
            s.submenuConstructor = getAttributeAsString("submenuConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.submenuDirection = getAttributeAsString("submenuDirection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuDirection:" + t.getMessage() + "\n";
        }
        try {
            s.target = getTarget();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.target:" + t.getMessage() + "\n";
        }
        try {
            s.useKeys = getAttributeAsString("useKeys");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.useKeys:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        MenuLogicalStructure s = new MenuLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

