package com.konakart.client;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellList.Style;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.konakart.client.app.GWT_SuggestedSearchItem;

/**
 * Popup that shows list of suggested search items
 * 
 */
public class SuggestedSearchDialog extends PopupPanel
{
    private CellList<GWT_SuggestedSearchItem> searchCL;

    private SearchBody searchBody;

    /**
     * Constructor
     * 
     * @param searchBody
     */
    public SuggestedSearchDialog(SearchBody searchBody)
    {
        this.searchBody = searchBody;

        this.setPopupPosition(searchBody.getSearchTB().getAbsoluteLeft(), searchBody.getSearchTB()
                .getAbsoluteTop()
                + searchBody.getSearchTB().getOffsetHeight());

        this.setModal(false);
        this.setAutoHideEnabled(true);
        this.setStyleName("suggested-search-items");

    }

    /**
     * Displays the suggested search items
     * 
     * @param itemList
     */
    public void showData(List<GWT_SuggestedSearchItem> itemList)
    {
        initCellList();
        searchCL.setRowCount(itemList.size());
        searchCL.setRowData(0, itemList);
        setWidget(searchCL);
        show();
        this.setWidth(SearchBody.WIDTH);
    }

    /**
     * Select a row in the CellList
     * 
     * @param dir
     *            Go up if > 0, down if < 0 and select no row if 0
     */
    public void selectRow(int dir)
    {

        boolean moved = false;
        int count = searchCL.getVisibleItemCount();
        for (int i = 0; i < count; i++)
        {
            GWT_SuggestedSearchItem ssi = searchCL.getVisibleItems().get(i);
            boolean selected = searchCL.getSelectionModel().isSelected(ssi);
            if (selected)
            {
                if (dir < 0)
                {
                    if (i == count - 1)
                    {
                        searchCL.getSelectionModel().setSelected(ssi, false);
                    } else
                    {
                        searchCL.getSelectionModel().setSelected(
                                searchCL.getVisibleItems().get(i + 1), true);
                        ssi = searchCL.getVisibleItems().get(i + 1);
                        searchBody.setSelectedSearchItem(ssi);
                    }
                } else if (dir == 0)
                {
                    searchCL.getSelectionModel().setSelected(ssi, false);
                } else
                {
                    if (i == 0)
                    {
                        searchCL.getSelectionModel().setSelected(ssi, false);
                    } else
                    {
                        searchCL.getSelectionModel().setSelected(
                                searchCL.getVisibleItems().get(i - 1), true);
                        ssi = searchCL.getVisibleItems().get(i - 1);
                        searchBody.setSelectedSearchItem(ssi);
                    }
                }
                moved = true;
                break;
            }
        }

        /*
         * If no line was selected then we either select the first or last item depending on whether
         * the up or down keys were pressed.
         */
        if (!moved && count > 0 && dir != 0)
        {
            GWT_SuggestedSearchItem ssi = null;
            if (dir < 0)
            {
                ssi = searchCL.getVisibleItems().get(0);
            } else
            {
                ssi = searchCL.getVisibleItems().get(count - 1);
            }
            searchCL.getSelectionModel().setSelected(ssi, true);
            searchBody.setSelectedSearchItem(ssi);
        }

    }

    /**
     * A single cell of the Cell List widget. We trap the mouse click event here.
     * 
     */
    private static class SuggestionCell extends AbstractCell<GWT_SuggestedSearchItem>
    {
        SearchBody sb = null;

        public SuggestionCell(SearchBody sb)
        {
            // Let the parent class know that our cell responds to click events
            super("click");
            this.sb = sb;
        }

        @Override
        public void onBrowserEvent(Context context, Element parent, GWT_SuggestedSearchItem value,
                NativeEvent event, ValueUpdater<GWT_SuggestedSearchItem> valueUpdater)
        {

            // Check that the value is not null.
            if (value == null)
            {
                return;
            }

            // Call the super handler
            super.onBrowserEvent(context, parent, value, event, valueUpdater);

            // On click, perform the search.
            if ("click".equals(event.getType()))
            {
                sb.getSearchTB().setText(value.getRawText());
                sb.doSearch(value);
            }

        }

        @Override
        public void render(Context context, GWT_SuggestedSearchItem value, SafeHtmlBuilder sb)
        {
            if (value != null)
            {
                sb.appendHtmlConstant(value.getRichText());
            }
        }
    }

    /**
     * Set the background color for selected cells when scrolling up and down with keyboard
     * 
     */
    public interface CellListResources extends CellList.Resources
    {
        /**
         * Instance of class
         */
        public static final CellListResources INSTANCE = GWT.create(CellListResources.class);

        @Source("com/konakart/public/CellList.css")
        Style cellListStyle();
    }

    /**
     * Initialize the Cell List
     */
    private void initCellList()
    {
        ProvidesKey<GWT_SuggestedSearchItem> keyProvider = new ProvidesKey<GWT_SuggestedSearchItem>()
        {
            public Object getKey(GWT_SuggestedSearchItem item)
            {
                // Always do a null check.
                return (item == null) ? null : item.getId();
            }
        };

        // Create a CellList using the keyProvider.
        searchCL = new CellList<GWT_SuggestedSearchItem>(new SuggestionCell(searchBody),
                CellListResources.INSTANCE, keyProvider);
        searchCL.setWidth(SearchBody.WIDTH);
        searchCL.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

        // Add a selection model using the same keyProvider.
        final SingleSelectionModel<GWT_SuggestedSearchItem> selectionModel = new SingleSelectionModel<GWT_SuggestedSearchItem>(
                keyProvider);
        searchCL.setSelectionModel(selectionModel);

    }

    /**
     * @return the searchCL
     */
    public CellList<GWT_SuggestedSearchItem> getSearchCL()
    {
        return searchCL;
    }

}
