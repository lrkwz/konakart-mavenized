//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are 
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is free software; you can redistribute 
// it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
package com.konakart.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.konakart.client.app.GWT_SuggestedSearchItem;
import com.konakart.client.app.GWT_SuggestedSearchOptions;
import com.konakart.client.util.KKGWTInvalidSessionException;

/**
 * Search widgets for assisted search. Consists of a text box and a CellList that contains the
 * suggestions. A search can be triggered in a few ways:
 * <ul>
 * <li>By clicking the search button</li>
 * <li>By pressing the Enter key on a highlighted suggestion</li>
 * <li>By clicking a suggestion</li>
 * </ul>
 * The mouse up and down keys can be used to scroll through the suggestions. The focus always
 * remains on the search text box even as the up and down keys are used to highlight the
 * suggestions. This allows you at any time to type in more letters.
 */
public class SearchBody
{
    /* Ids of div where we add our GWT code to the jsp */
    private static final String SUGGESTED_SEARCH = "kk-SuggestedSearch";

    protected static final String BODY_ID = "kk-ss-body";

    protected static final String WIDTH = "25em";

    /**
     * ID of form that contains parameters passed to GWT widget
     */
    public static final String FORM_ID = "kkLabelForm7";

    /*
     * Objects
     */
    GWT_SuggestedSearchItem selectedItem;

    /* Pointer to Konakart.java */
    private Konakart kk;

    /*
     * Widgets
     */
    private TextBox searchTB;

    private HTML searchB;

    private SuggestedSearchDialog ssd;

    /*
     * Labels
     */
    private String suggested_search_search = "suggested.search.search";

    // Locale
    private String locale;

    // Limit
    private int limit = 10;

    /**
     * Constructor
     * 
     * @param kk
     */
    public SearchBody(Konakart kk)
    {
        this.kk = kk;

        // Get the parameters from the JSP
        getParameters(FORM_ID);

        initWidgets();
    }

    /*
     * ----- Callbacks
     */

    AsyncCallback<?> getSuggestionsCallback = new AsyncCallback<Object>()
    {
        public void onSuccess(Object result)
        {
            GWT_SuggestedSearchItem[] itemArray = (GWT_SuggestedSearchItem[]) result;
            List<GWT_SuggestedSearchItem> itemList = Arrays.asList(itemArray);
            getSsd().showData(itemList);
        }

        public void onFailure(Throwable caught)
        {
            if (caught instanceof KKGWTInvalidSessionException)
            {
                kk.redirect("Welcome.do");
            }
        }
    };

    /*
     * ----- End of Callbacks
     */

    /**
     * Creates the panel for the search
     */
    protected void renderSearch()
    {
        // Remove the current panel
        removeFromDom();

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel();

        HorizontalPanel hp = new HorizontalPanel();
        hp.setSpacing(10);
        hp.add(searchTB);
        hp.add(searchB);

        containerPanel.add(hp, BODY_ID);

        // Finally, add the outer panel to the RootPanel, so that it will be
        // displayed.
        addToDom(containerPanel);

    }

    /**
     * Initialize widgets
     */
    protected void initWidgets()
    {
        initTextBox();
        initButton();
    }

    /**
     * Initialize button used to set off search
     */
    private void initButton()
    {
        searchB = new HTML("<a style=\"float:right\" class=\"button\"><span>"
                + suggested_search_search + "</span></a>");
        searchB.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                doSearch(selectedItem);
            }
        });
    }

    /**
     * Initializes the search text box
     * 
     * @param textBox
     */
    private void initTextBox()
    {
        searchTB = new TextBox();

        searchTB.setWidth(WIDTH);
        searchTB.addKeyUpHandler(new KeyUpHandler()
        {
            public void onKeyUp(KeyUpEvent event)
            {
                int keyCode = event.getNativeKeyCode();
                if (!(keyCode == KeyCodes.KEY_LEFT || keyCode == KeyCodes.KEY_RIGHT
                        || keyCode == KeyCodes.KEY_UP || keyCode == KeyCodes.KEY_DOWN || keyCode == KeyCodes.KEY_ENTER))
                {
                    getSuggestions(((TextBox) event.getSource()).getText());
                }

                /*
                 * Up key moves cursor to start of word so always have to reset it to end.
                 */
                if (searchTB.getText() != null && searchTB.getText().length() > 0)
                {
                    searchTB.setCursorPos(searchTB.getText().length());
                }
            }
        });
        searchTB.addKeyDownHandler(new KeyDownHandler()
        {
            public void onKeyDown(KeyDownEvent event)
            {
                int keyCode = event.getNativeKeyCode();
                if (keyCode == KeyCodes.KEY_DOWN)
                {
                    if (getSsd().getSearchCL().getVisibleItemCount() > 0)
                    {
                        getSsd().selectRow(-1);
                    }
                } else if (keyCode == KeyCodes.KEY_UP)
                {
                    if (getSsd().getSearchCL().getVisibleItemCount() > 0)
                    {
                        getSsd().selectRow(1);
                    }
                } else if (keyCode == KeyCodes.KEY_ENTER)
                {
                    int count = getSsd().getSearchCL().getVisibleItemCount();
                    for (int i = 0; i < count; i++)
                    {
                        GWT_SuggestedSearchItem ssi = getSsd().getSearchCL().getVisibleItems().get(
                                i);
                        boolean selected = getSsd().getSearchCL().getSelectionModel().isSelected(
                                ssi);
                        if (selected)
                        {
                            searchTB.setText(ssi.getRawText());
                            doSearch(ssi);
                            break;
                        }
                    }
                }
            }
        });

    }

    /**
     * Perform the database search
     * 
     * @param ssi
     */
    protected void doSearch(GWT_SuggestedSearchItem ssi)
    {
        String searchBoxText = (searchTB.getText() != null) ? searchTB.getText() : "";

        /* Create a suggested search object if null, and populate it with text from search text box */
        if (ssi == null)
        {
            ssi = new GWT_SuggestedSearchItem();
            ssi.setCategoryId(-1);
            ssi.setManufacturerId(-1);
            ssi.setProductId(-1);
            ssi.setRawText(searchBoxText);
        }

        String ssiText = (ssi.getRawText() != null) ? ssi.getRawText() : "";

        /*
         * If the text in the suggested search object doesn't match the search text box text, this
         * means that someone may have changed the text in the search text box so we need to use
         * that and to invalidate any of the ids that may be set.
         */
        if (!ssiText.equalsIgnoreCase(searchBoxText))
        {
            ssi.setRawText(searchBoxText);
            ssi.setCategoryId(-1);
            ssi.setManufacturerId(-1);
            ssi.setProductId(-1);
        }

        if (ssd != null)
        {
            ssd.hide();
        }
        searchTB.setFocus(true);

        if (ssi.getCategoryId() > -1 && ssi.getManufacturerId() > -1)
        {
            // Search category and manufacturer
            kk.redirect("SelectCat.do?catId=" + ssi.getCategoryId() + "&manuId="
                    + ssi.getManufacturerId());
        } else if (ssi.getCategoryId() > -1)
        {
            // Search cat
            kk.redirect("SelectCat.do?catId=" + ssi.getCategoryId());
        } else if (ssi.getManufacturerId() > -1)
        {
            // Search manufacturer
            kk.redirect("ShowSearchByManufacturerResultsByLink.do?manuId="
                    + ssi.getManufacturerId());
        } else
        {
            // Search based on text
            kk.redirect("QuickSearch.do?searchText=" + ssi.getRawText());
        }
        // Window.alert("You clicked " + ssi.getRawText());
    }

    /**
     * Set the search text in the text box and set the selected item at the same time
     * 
     * @param ssi
     */
    public void setSelectedSearchItem(GWT_SuggestedSearchItem ssi)
    {
        searchTB.setText(ssi.getRawText());
        selectedItem = ssi;
    }

    /**
     * Get a list of suggestions from the server
     * 
     * @param text
     */
    private void getSuggestions(String text)
    {
        String lowerCaseText = "";
        if (text != null)
        {
            lowerCaseText = text.toLowerCase();
        }

        GWT_SuggestedSearchOptions options = new GWT_SuggestedSearchOptions();
        if (locale != null && locale.length() >= 2)
        {
            options.setLanguageCode(locale.substring(0, 2));
        } else
        {
            options.setLanguageId(-1);
        }
        options.setLimit(limit);
        options.setStartTag("<b>");
        options.setEndTag("</b>");
        options.setSearchText(lowerCaseText);
        options.setReturnRichText(true);
        options.setReturnRawText(true);
        kk.getMyKKGWTService().getSuggestedSearchItems(options, getSuggestionsCallback);
    }

    /**
     * Add the widget to the DOM structure
     * 
     * @param panel
     */
    protected void addToDom(HTMLPanel panel)
    {
        RootPanel.get(SUGGESTED_SEARCH).add(panel);
    }

    /**
     * Remove the current panel from the DOM structure
     * 
     */
    protected void removeFromDom()
    {
        if (RootPanel.get(SUGGESTED_SEARCH) != null)
        {
            RootPanel.get(SUGGESTED_SEARCH).clear();
        }
    }

    /**
     * Creates a panel containing the framework html
     * 
     * @param mode
     *            Determines which framework to generate
     * 
     * @return Return the panel
     */
    protected HTMLPanel getContainerPanel()
    {
        String framework = "<div id=\"" + BODY_ID + "\" class=\"suggested-search-input\">"
                + "</div>";
        HTMLPanel containerPanel = new HTMLPanel(framework);
        return containerPanel;
    }

    /**
     * @return the searchTB
     */
    public TextBox getSearchTB()
    {
        return searchTB;
    }

    /**
     * @return the ssd
     */
    public SuggestedSearchDialog getSsd()
    {
        if (ssd == null)
        {
            ssd = new SuggestedSearchDialog(this);
        }
        return ssd;
    }

    /**
     * Get all parameters passed in as hidden inputs of a form from the JSP. This is a common method
     * which calls a method to process the attributes that has to be overridden by the superclass
     * 
     * @param formId
     * @return Returns true if label section was found
     * 
     */
    protected boolean getParameters(String formId)
    {
        Element parmForm = DOM.getElementById(formId);
        if (parmForm != null)
        {
            String name, value;

            int attrCount = DOM.getChildCount(parmForm);

            for (int i = 0; i < attrCount; i++)
            {
                name = DOM.getElementProperty(DOM.getChild(parmForm, i), "name");
                value = DOM.getElementProperty(DOM.getChild(parmForm, i), "value");
                if (name != null)
                {
                    setAttr(name, value);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        if (name.equals("suggested.search.search"))
        {
            suggested_search_search = value;
        } else if (name.equals("locale"))
        {
            locale = value;
        } else if (name.equals("limit"))
        {
            try
            {
                limit = Integer.parseInt(value);
            } catch (NumberFormatException e)
            {
            }
        }
    }

}
