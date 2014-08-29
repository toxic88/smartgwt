package com.smartgwt.sample.showcase.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.IconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.IconClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.data.CommandTreeNode;
import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;
import com.smartgwt.sample.showcase.client.data.ShowcaseData;

public class TileView extends VLayout {
    private static final ShowcaseMessages M = ShowcaseMessages.INSTANCE;
    
    private Map<String, Integer> rankOfSamples = new HashMap<String, Integer>();
    private boolean considerForRanking = false;
    private static final native boolean _useRoundedSearchItem() /*-{
        var isc = $wnd.isc;
        return (!isc.Browser.isIE || isc.Browser.isIE9);
    }-*/;

    private final boolean useDesktopMode;

    private TileGrid tileGrid;
    private final String idSuffix = SideNavTree.ID_SUFFIX;
    private TreeNode[] showcaseData = ShowcaseData.getDataVersioned(idSuffix);
    private DynamicForm filterForm;

    private TextItem searchItem;
    private SliderItem numSamplesItem;
    private CheckboxItem ascendingItem;
    //private CheckboxItem disabledModeCB;

    private CheckboxItem featuredCB;
    private CheckboxItem newSamplesCB;
    private CheckboxItem comboBoxCB;
    private CheckboxItem gridsCB;
    private CheckboxItem treeCB;
    private CheckboxItem calendarCB;
    private CheckboxItem tilesCB;
    private CheckboxItem formsCB;
    private CheckboxItem layoutCB;
    private CheckboxItem windowsCB;
    private CheckboxItem tabsCB;
    private CheckboxItem sectionsCB;
    private CheckboxItem portalLayoutCB;
    private CheckboxItem buttonsCB;
    private CheckboxItem menusCB;
    private CheckboxItem toolStripCB;
    private CheckboxItem otherControlsCB;
    private CheckboxItem dataIntegrationCB;
    private CheckboxItem dragDropCB;
    private CheckboxItem basicsCB;
    private CheckboxItem drawingCB;
    private CheckboxItem effectsCB;
    private CheckboxItem betaSamplesCB;
    // ---- OR ----
    private SelectItem categoriesItem;

    private Tree tree;

    public interface ShowcaseCustomTileMetaFactory extends BeanFactory.MetaFactory {  
        BeanFactory<ShowcaseCustomTile> getShowcaseCustomTileFactory();  
    }

    public TileView(boolean useDesktopMode) {
        this.useDesktopMode = useDesktopMode;
        tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("name");
        tree.setOpenProperty("isOpen");
        tree.setIdField("nodeID");
        tree.setParentIdField("parentNodeID");

        tree.setRootValue("root" + idSuffix);

        tree.setData(showcaseData);

        setMembersMargin(10);

        setWidth100();
        setOverflow(Overflow.HIDDEN);

        GWT.create(ShowcaseCustomTileMetaFactory.class);

        tileGrid = new TileGrid() {
			@Override
			public Canvas getTile(int recordNum) {
				ShowcaseCustomTile customTile = (ShowcaseCustomTile) super.getTile(recordNum);
				customTile.applyRecord();
				return customTile;
			}
		};
        if (useDesktopMode) tileGrid.setStyleName("showcaseTileGrid");
        tileGrid.setShowEdges(false);
        tileGrid.setTileWidth(useDesktopMode ? 140 : 70);
        tileGrid.setTileHeight(useDesktopMode ? 120 : 90); // not half of "normal" because there needs to be room for the label,
                                                           // especially since the labels tend to wrap, so they require 2-3 lines
        tileGrid.setWidth100();
        tileGrid.setHeight100();
        tileGrid.setShowAllRecords(true);
        tileGrid.setTileConstructor(ShowcaseCustomTile.class.getName());  
        tileGrid.setAutoFetchData(false);
        tileGrid.setAnimateTileChange(true);
        tileGrid.setEmptyMessage("No samples match your criteria.");
        tileGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                Record record = event.getRecord();
                showSample(record);
            }
        });

        filterForm = new DynamicForm();
        filterForm.setFixedColWidths(true);
        filterForm.setBorder("1px solid #9C9C9C");
        if (useDesktopMode) {
            filterForm.setNumCols(8);
            filterForm.setColWidths(16, "*", 16, "*", 16, "*", 16, "*");
        } else {
            filterForm.setNumCols(3);
            filterForm.setColWidths("*", 10, "*");
        }
        filterForm.setAutoFocus(false);
        filterForm.setPadding(5);

        searchItem = new TextItem("description_search", M.searchTitle().asString());
        searchItem.setWidth("*");
        searchItem.setTitleOrientation(TitleOrientation.TOP);
        searchItem.setColSpan(useDesktopMode ? 2 : 1);
        searchItem.setTitleAlign(Alignment.LEFT);
        searchItem.setBrowserAutoCorrect(false);
        searchItem.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if ("Enter".equals(event.getKeyName())) {
                    searchItem.blurItem();
                    updateTiles(true);
                }
            }
        });
        final FormItemIcon searchIcon = new FormItemIcon();
        searchIcon.setName("search");
        searchIcon.setInline(true);
        searchIcon.setAttribute("imgOnly", true);
        searchIcon.setSrc("[SKINIMG]actions/view.png");
        searchIcon.setWidth(16);
        searchIcon.setHeight(16);
        searchIcon.setShowRTL(true);
        searchIcon.setHspace(5);
        final FormItemIcon clearIcon = new FormItemIcon();
        clearIcon.setName("clear");
        clearIcon.setInline(true);
        clearIcon.setAttribute("imgOnly", true);
        clearIcon.setSrc("[SKINIMG]actions/close.png");
        clearIcon.setWidth(10);
        clearIcon.setHeight(10);
        clearIcon.setHspace(3);
        searchItem.setIcons(searchIcon, clearIcon);
        if (_useRoundedSearchItem()) searchItem.setTextBoxStyle("explorerSearchItem");
        searchItem.addIconClickHandler(new IconClickHandler() {
            public void onIconClick(IconClickEvent event) {
                if ("clear".equals(event.getIcon().getName())) {
                    filterForm.reset();
                    featuredCB.setValue(true);
                    updateTiles(false);
                } else {
                    updateTiles(true);
                }
            }
        });

        if (useDesktopMode) {
            numSamplesItem = new SliderItem("numSamples");
            numSamplesItem.setTitle(M.numSamplesTitle().asString());
            numSamplesItem.setTitleOrientation(TitleOrientation.TOP);
            numSamplesItem.setColSpan(1);
            numSamplesItem.setTitleAlign(Alignment.LEFT);
            numSamplesItem.setMinValue(1.0);
            // grep '^ *new ExplorerTreeNode' ShowcaseData.java | grep -o 'new [^.,]*\.Factory()' | sort | uniq | wc
            numSamplesItem.setMaxValue(328.0);
            numSamplesItem.setDefaultValue(100);
            numSamplesItem.setHeight(50);
            numSamplesItem.setOperator(OperatorId.LESS_THAN);

            ascendingItem = new CheckboxItem("chkSortDir");
            ascendingItem.setTitle(M.ascendingTitle().asString());
        }

        //disabledModeCB = new CheckboxItem("disabledModeCB", M.disabledModeTitle().asString());

        if (useDesktopMode) {
            featuredCB = new CheckboxItem("featuredCB", M.featuredCategoryName().asString());
            featuredCB.setValue(true);
            newSamplesCB = new CheckboxItem("newSamplesCB", M.newSamplesCategoryName().asString());
            comboBoxCB = new CheckboxItem("comboBoxCB", M.comboBoxCategoryName().asString());
            gridsCB = new CheckboxItem("gridsCB", M.gridsCategoryName().asString());
            treeCB = new CheckboxItem("treeCB", M.treeCategoryName().asString());
            calendarCB = new CheckboxItem("calendarCB", M.calendarCategoryName().asString());
            tilesCB = new CheckboxItem("tilesCB", M.tilesCategoryName().asString());
            formsCB = new CheckboxItem("formsCB", M.formsCategoryName().asString());
            layoutCB = new CheckboxItem("layoutCB", M.layoutCategoryName().asString());
            windowsCB = new CheckboxItem("windowsCB", M.windowsCategoryName().asString());
            tabsCB = new CheckboxItem("tabsCB", M.tabsCategoryName().asString());
            sectionsCB = new CheckboxItem("accordionCB", M.sectionsCategoryName().asString());
            portalLayoutCB = new CheckboxItem("portalLayoutCB", M.portalLayoutCategoryName().asString());
            buttonsCB = new CheckboxItem("buttonsCB", M.buttonsCategoryName().asString());
            menusCB = new CheckboxItem("menusCB", M.menusCategoryName().asString());
            toolStripCB = new CheckboxItem("toolStripCB", M.toolStripCategoryName().asString());
            otherControlsCB = new CheckboxItem("otherControlsCB", M.otherControlsCategoryName().asString());
            dataIntegrationCB = new CheckboxItem("dataIntegrationCB", M.dataIntegrationCategoryName().asString());
            dragDropCB = new CheckboxItem("dragDropCB", M.dragDropCategoryName().asString());
            basicsCB = new CheckboxItem("basicsCB", M.basicsCategoryName().asString());
            drawingCB = new CheckboxItem("drawingCB", M.drawingCategoryName().asString());
            effectsCB = new CheckboxItem("effectsCB", M.effectsCategoryName().asString());
            betaSamplesCB = new CheckboxItem("betaSamplesCB", M.betaSamplesName().asString());
        } else {
            categoriesItem = new SelectItem("categories", M.categoriesTitle().asString());
            categoriesItem.setTitleOrientation(TitleOrientation.TOP);
            categoriesItem.setColSpan(1);
            categoriesItem.setMultiple(true);
            categoriesItem.setMultipleAppearance(MultipleAppearance.PICKLIST);
            final LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
            valueMap.put("layout_sections_category", M.sectionsCategoryName().asString());
            valueMap.put("basics_category", M.basicsCategoryName().asString());
            valueMap.put("beta_samples", M.betaSamplesName().asString());
            valueMap.put("buttons_category", M.buttonsCategoryName().asString());
            valueMap.put("calendar_category", M.calendarCategoryName().asString());
            valueMap.put("combobox_category", M.comboBoxCategoryName().asString());
            valueMap.put("data_integration_category", M.dataIntegrationCategoryName().asString());
            valueMap.put("tiling_category", M.tilesCategoryName().asString());
            valueMap.put("effects_dd_category", M.dragDropCategoryName().asString());
            valueMap.put("drawing", M.drawingCategoryName().asString());
            valueMap.put("effects_category", M.effectsCategoryName().asString());
            valueMap.put("featured_category", M.featuredCategoryName().asString());
            valueMap.put("form_category", M.formsCategoryName().asString());
            valueMap.put("grid_category", M.gridsCategoryName().asString());
            valueMap.put("layout_category", M.layoutCategoryName().asString());
            valueMap.put("menus_category", M.menusCategoryName().asString());
            valueMap.put("new_category", M.newSamplesCategoryName().asString());
            valueMap.put("controls_category", M.otherControlsCategoryName().asString());
            valueMap.put("portal_layout_category", M.portalLayoutCategoryName().asString());
            valueMap.put("layout_tabs_category", M.tabsCategoryName().asString());
            valueMap.put("toolstrip_category", M.toolStripCategoryName().asString());
            valueMap.put("tree_category", M.treeCategoryName().asString());
            valueMap.put("layout_windows_category", M.windowsCategoryName().asString());
            categoriesItem.setValueMap(valueMap);
            categoriesItem.setDefaultValue(new String[] {"featured_category"});

            final LinkedHashMap<String, String> valueMapIcons = new LinkedHashMap<String, String>();
            valueMapIcons.put("featured_category", ((ExplorerTreeNode)tree.find("nodeID", "featured_category"+ idSuffix)).getIcon());
            valueMapIcons.put("new_category", ((ExplorerTreeNode)tree.find("nodeID", "new_category"+ idSuffix)).getIcon());
            valueMapIcons.put("combobox_category", ((ExplorerTreeNode)tree.find("nodeID", "combobox_category"+ idSuffix)).getIcon());
            valueMapIcons.put("grid_category", ((ExplorerTreeNode)tree.find("nodeID", "grid_category"+ idSuffix)).getIcon());
            valueMapIcons.put("tree_category", ((ExplorerTreeNode)tree.find("nodeID", "tree_category"+ idSuffix)).getIcon());
            valueMapIcons.put("calendar_category", ((ExplorerTreeNode)tree.find("nodeID", "calendar_category"+ idSuffix)).getIcon());
            valueMapIcons.put("tiling_category", ((ExplorerTreeNode)tree.find("nodeID", "tiling_category"+ idSuffix)).getIcon());
            valueMapIcons.put("form_category", ((ExplorerTreeNode)tree.find("nodeID", "form_category"+ idSuffix)).getIcon());
            valueMapIcons.put("layout_category", ((ExplorerTreeNode)tree.find("nodeID", "layout_category"+ idSuffix)).getIcon());
            valueMapIcons.put("layout_windows_category", ((ExplorerTreeNode)tree.find("nodeID", "layout_windows_category"+ idSuffix)).getIcon());
            valueMapIcons.put("layout_tabs_category", ((ExplorerTreeNode)tree.find("nodeID", "layout_tabs_category"+ idSuffix)).getIcon());
            valueMapIcons.put("layout_sections_category", ((ExplorerTreeNode)tree.find("nodeID", "layout_sections_category"+ idSuffix)).getIcon());
            valueMapIcons.put("portal_layout_category", ((ExplorerTreeNode)tree.find("nodeID", "portal_layout_category"+ idSuffix)).getIcon());
            valueMapIcons.put("buttons_category", ((ExplorerTreeNode)tree.find("nodeID", "buttons_category"+ idSuffix)).getIcon());
            valueMapIcons.put("menus_category", ((ExplorerTreeNode)tree.find("nodeID", "menus_category"+ idSuffix)).getIcon());
            valueMapIcons.put("toolstrip_category", ((ExplorerTreeNode)tree.find("nodeID", "toolstrip_category"+ idSuffix)).getIcon());
            valueMapIcons.put("controls_category", ((ExplorerTreeNode)tree.find("nodeID", "controls_category"+ idSuffix)).getIcon());
            valueMapIcons.put("data_integration_category", ((ExplorerTreeNode)tree.find("nodeID", "data_integration_category"+ idSuffix)).getIcon());
            valueMapIcons.put("effects_dd_category", ((ExplorerTreeNode)tree.find("nodeID", "effects_dd_category"+ idSuffix)).getIcon());
            valueMapIcons.put("basics_category", ((ExplorerTreeNode)tree.find("nodeID", "basics_category"+ idSuffix)).getIcon());
            valueMapIcons.put("drawing", ((ExplorerTreeNode)tree.find("nodeID", "drawing"+ idSuffix)).getIcon());
            valueMapIcons.put("effects_category", ((ExplorerTreeNode)tree.find("nodeID", "effects_category"+ idSuffix)).getIcon());
            categoriesItem.setValueIcons(valueMapIcons);
        }

        final List<FormItem> filterFormItems = new ArrayList<FormItem>();
        filterFormItems.add(searchItem);
        {
            final SpacerItem spacerItem = new SpacerItem();
            spacerItem.setWidth(1);
            filterFormItems.add(spacerItem);
        }
        if (useDesktopMode) {
            filterFormItems.add(numSamplesItem);
            filterFormItems.add(ascendingItem);
            filterFormItems.add(new SpacerItem());
            //filterFormItems.add(disabledModeCB);
            filterFormItems.addAll(Arrays.asList(
                    sectionsCB, basicsCB, betaSamplesCB, buttonsCB, calendarCB, comboBoxCB, dataIntegrationCB,
                    tilesCB, dragDropCB, drawingCB, effectsCB, featuredCB, formsCB, gridsCB, layoutCB, 
                    menusCB, newSamplesCB, otherControlsCB, portalLayoutCB, tabsCB, toolStripCB, 
                    treeCB, windowsCB));
        } else {
            filterFormItems.add(categoriesItem);
        }
        filterForm.setItems(filterFormItems.toArray(new FormItem[filterFormItems.size()]));

        filterForm.addItemChangedHandler(new ItemChangedHandler() {
            public void onItemChanged(ItemChangedEvent event) {
                FormItem item = event.getItem();
                if (item instanceof CheckboxItem || item instanceof SliderItem || item == categoriesItem) {
                    updateTiles(false);
                }
            }
        });

        addMember(filterForm);

        addMember(tileGrid);

        updateTiles(false);
    }

    public void updateTiles(String searchText) {
        searchItem.setValue(searchText);
        updateTiles(true);
        // Don't focusInItem() on mobile because the browser will attempt to scroll the newly-focused
        // searchItem into view, as the SplitPane page transition is underway.
        if (useDesktopMode) filterForm.focusInItem(searchItem);
    }

    private void updateTiles(boolean isSearchText) {
        final String searchText = (String)searchItem.getValue();
        this.considerForRanking = isSearchText;
        final List<String> categories = new ArrayList<String>();
        if (!Browser.getIsTouch()) {
            if (featuredCB.getValueAsBoolean()) categories.add("featured_category");
            if (newSamplesCB.getValueAsBoolean()) categories.add("new_category");
            if (comboBoxCB.getValueAsBoolean()) categories.add("combobox_category");
            if (gridsCB.getValueAsBoolean()) categories.add("grid_category");
            if (treeCB.getValueAsBoolean()) categories.add("tree_category");
            if (calendarCB.getValueAsBoolean()) categories.add("calendar_category");
            if (tilesCB.getValueAsBoolean()) categories.add("tiling_category");
            if (formsCB.getValueAsBoolean()) categories.add("form_category");
            if (layoutCB.getValueAsBoolean()) categories.add("layout_category");
            if (windowsCB.getValueAsBoolean()) categories.add("layout_windows_category");
            if (tabsCB.getValueAsBoolean()) categories.add("layout_tabs_category");
            if (sectionsCB.getValueAsBoolean()) categories.add("layout_sections_category");
            if (portalLayoutCB.getValueAsBoolean()) categories.add("portal_layout_category");
            if (buttonsCB.getValueAsBoolean()) categories.add("buttons_category");
            if (menusCB.getValueAsBoolean()) categories.add("menus_category");
            if (toolStripCB.getValueAsBoolean()) categories.add("toolstrip_category");
            if (otherControlsCB.getValueAsBoolean()) categories.add("controls_category");
            if (dataIntegrationCB.getValueAsBoolean()) categories.add("data_integration_category");
            if (dragDropCB.getValueAsBoolean()) categories.add("effects_dd_category");
            if (basicsCB.getValueAsBoolean()) categories.add("basics_category");
            if (drawingCB.getValueAsBoolean()) categories.add("drawing");
            if (effectsCB.getValueAsBoolean()) categories.add("effects_category");
            if (betaSamplesCB.getValueAsBoolean()) categories.add("beta_samples");
        } else {
            categories.addAll(Arrays.asList(categoriesItem.getValues()));
        }

        showTiles(searchText, categories);

        final boolean sortDir = (ascendingItem == null ? true : ascendingItem.getValueAsBoolean());
        if (this.considerForRanking) tileGrid.sortByProperty("position", false);
        else tileGrid.sortByProperty("name", sortDir);

    }

    private void showSample(Record node) {
        boolean isExplorerTreeNode = node instanceof ExplorerTreeNode;
        if (node instanceof CommandTreeNode) {
            CommandTreeNode commandTreeNode = (CommandTreeNode) node;
            commandTreeNode.getCommand().execute();
        } else if (isExplorerTreeNode) {
            ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode)node;
            History.newItem(explorerTreeNode.getNodeID(), true);
        }
    }

    private void showTiles(String searchText, List<String> categories) {
        final Set<TreeNode> data = new HashSet<TreeNode>();

        final Integer maxResults = (numSamplesItem == null ? null : Integer.valueOf(numSamplesItem.getValueAsFloat().intValue()));

        if (searchText != null) {
            TreeNode[] children = tree.getAllNodes();
            applyFilterAccordingToRanking(tree, children, data, searchText, maxResults);
        } else {
            for (final String category : categories) {
                if (category.equalsIgnoreCase("beta_samples")) {
                    TreeNode[] children = tree.getAllNodes();
                    searchBetaSamples(tree, children, data, searchText, maxResults, false);
                } else {
                    TreeNode categoryNode = tree.find("nodeID", category + idSuffix);
                    if (categoryNode == null) continue;
                    TreeNode[] children = tree.getChildren(categoryNode);

                    applyFilter(tree, children, data, searchText, maxResults, false);
                }
            }
        }
        tileGrid.setData((Record[])data.toArray(new Record[data.size()]));
    }

    private void searchBetaSamples(Tree tree, TreeNode[] children, Set<TreeNode> data, String searchText, 
        Integer maxResults, boolean skipCategories) 
    {
        for (int i = 0; i < children.length; i++) {
            if (maxResults != null && data.size() >= maxResults) return;
            final TreeNode child = children[i];
            if (!tree.hasChildren(child)) {
                boolean isExplorerTreeNode = child instanceof ExplorerTreeNode;
                if (isExplorerTreeNode) {
                    final ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode) child;
                    if (explorerTreeNode.getName().contains("BETA")) {
                        children[i].setAttribute("description", explorerTreeNode.getFactory().getDescription());
                        data.add(children[i]);
                    }
                }
            } else if(!skipCategories) {
                searchBetaSamples(tree, tree.getChildren(child), data, searchText, maxResults, skipCategories);
            }
        }
    }

    private void applyFilterAccordingToRanking(Tree tree, TreeNode[] children, Set<TreeNode> data, 
        String searchText, Integer maxResults) 
    {
        String[] arraySearchText = searchText.trim().split(" ");
        for (int j = 0; j < children.length; j++) {
            if (arraySearchText[j] == null || arraySearchText[j].length() == 0) continue;
            for (int i = 0; i < children.length; i++) {
                if (maxResults != null && data.size() >= maxResults) return;
                TreeNode child = children[i];
                if (!tree.hasChildren(child)) {
                    searchText = arraySearchText[j].toLowerCase();
                    boolean isExplorerTreeNode = child instanceof ExplorerTreeNode;
                    if (isExplorerTreeNode) {
                        ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode) child;
                        //when searching through all nodes, skip the featured section to avoid duplicates
                        if(explorerTreeNode.getNodeID().contains("featured")) continue;
                        if (explorerTreeNode.getName().toLowerCase().contains(searchText)) {
                            int rank = rankSamples(explorerTreeNode.getName().toLowerCase(), 5);
                            child.setAttribute("position", rank);
                            data.add(child);
                        } else {
                            PanelFactory factory = explorerTreeNode.getFactory();
                            if (factory != null) {
                                String description = factory.getDescription();
                                if (description != null && description.toLowerCase().contains(searchText)) {
                                    int rank = rankSamples(explorerTreeNode.getName().toLowerCase(), 1);
                                    child.setAttribute("position", rank);
                                    data.add(child);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void applyFilter(Tree tree, TreeNode[] children, Set<TreeNode> data, String searchText, 
        Integer maxResults, boolean skipCategories) 
    {
        for (int i = 0; i < children.length; i++) {
            if (maxResults != null && data.size() >= maxResults) return;
            TreeNode child = children[i];
            if (!tree.hasChildren(child)) {
                if (searchText == null) data.add(child);

            } else if(!skipCategories) {
                //skip categories when searching all nodes so that duplicates that exist in featured section and category are
                //both not included
                applyFilter(tree, tree.getChildren(child), data, searchText, maxResults, skipCategories);
            }
        }
    }
    
    private int rankSamples(String name, int amount) {
        if (!this.considerForRanking) return 0;

        if (rankOfSamples.get(name) == null) {
            rankOfSamples.put(name, amount);
        } else {
            rankOfSamples.put(name, (Integer)rankOfSamples.get(name) + amount);
        }
        return (Integer)rankOfSamples.get(name);
    }
}
